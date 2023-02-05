import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee{
    private String name;
    private String role;

    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    abstract public void show_details();
    abstract public void hierarchy(int tab);
    abstract public boolean delete(String name);
    abstract public void print(String name, boolean type);
}

class Developer extends Employee{
    private String curProject;

    public Developer(String name, String curProject) {
        super(name, "Developer");
        this.curProject = curProject;
    }

    @Override
    public void show_details() {
        System.out.println("Name : " + getName());
        System.out.println("Role : " + getRole());
        System.out.println("Current Project : " + getCurProject());
    }

    @Override
    public void hierarchy(int tab) {
        for(int i = 0; i < tab; i++)
            System.out.print("\t");
        System.out.println("- " + getName());
    }

    @Override
    public boolean delete(String name) {
        return name == getName();
    }

    public String getCurProject() {
        return curProject;
    }

    @Override
    public void print(String name, boolean type) {
        if(!getName().equalsIgnoreCase(name)) return ;

        if(type){
            hierarchy(0);
        }
        else show_details();
    }
}

abstract class EmployeeHolder extends Employee{
    ArrayList<Employee> employees = new ArrayList<>();
    public EmployeeHolder(String name, String role) {
        super(name, role);
    }

    @Override
    abstract public void show_details();
    abstract protected void hierarchy_name();

    @Override
    public void hierarchy(int tab) {
        for(int i = 0; i < tab; i++)
            System.out.print("\t");
        hierarchy_name();
        for(Employee emp: employees) {
            emp.hierarchy(tab+1);
        }
    }

    @Override
    public boolean delete(String name) {
        if(name == getName() && employees.size() != 0){
            System.out.println(getName() + " childlist not empty");
            return false;
        }else if(name == getName())
            return true;
        else{
            for(Employee emp: employees){
                if(emp.delete(name)){
                    employees.remove(emp);
                    return false;
                }
            }
            return false;
        }
    }

    void addChild(Employee emp){
        employees.add(emp);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    
    @Override
    public void print(String name, boolean type) {
        if(getName().equalsIgnoreCase(name)){
            if(type){
                hierarchy(0);
            }
            else show_details();
        }
        else{
            for(Employee emp: employees){
                emp.print(name, type);
            }
        }
    }

}

class ProjectManager extends EmployeeHolder{
    String currentProject;
    public ProjectManager(String name, String curProject) {
        super(name, "project manager");
        this.currentProject = curProject;
    }

    @Override
    public void show_details() {
        System.out.println("Name : " + getName());        
        System.out.println("Role : " + getRole());
        System.out.println("Current Project: " + getCurrentProject());
        System.out.println("Number of supervisees : " + getEmployees().size());
    }
   
    public String getCurrentProject() {
        return currentProject;
    }

    @Override
    protected void hierarchy_name() {
        System.out.println("- " + getName() + "(" + getCurrentProject()+ ")");
    }
}

class SoftwareCompany extends EmployeeHolder{

    public SoftwareCompany(String name) {
        super(name, "company");
    }

    @Override
    public void show_details() {
        System.out.println("Name : " + getName());        
        System.out.println("Role : " + getRole());
        System.out.println("Number of Current Projects : " + getEmployees().size()); 
    }

    @Override
    protected void hierarchy_name() {
        System.out.println("- " + getName());
    }
    
}


/**
 * Main
 */
public class Main {
    public static void hardcoded(String[] args) {
        SoftwareCompany company = new SoftwareCompany("abc");
        ProjectManager pm1 = new ProjectManager("pm1", "prj1");
        ProjectManager pm2 = new ProjectManager("pm2", "prj2");
        company.addChild(pm1);
        company.addChild(pm2);

        Developer dv1 = new Developer("dev1", "prj1");
        Developer dv2 = new Developer("dev2", "prj1");
        Developer dv3 = new Developer("dev3", "prj1");
        Developer dv4 = new Developer("dev4", "prj1");

        pm1.addChild(dv1);
        pm2.addChild(dv2);
        pm1.addChild(dv3);
        pm2.addChild(dv4);

        company.show_details();
        System.out.println("-----------");
        company.hierarchy(0);
        System.out.println("-----------");

        pm1.show_details();
        System.out.println("-----------");
        pm1.hierarchy(0);
        System.out.println("-----------");

        dv1.show_details();
        System.out.println("-----------");
        dv1.hierarchy(0);
        System.out.println("-----------");

        company.delete("dev1");
        company.hierarchy(0);
        System.out.println("-----------");

        company.delete("dev3");
        company.hierarchy(0);
        System.out.println("-----------");
        
        company.delete("pm1");
        company.hierarchy(0);
        System.out.println("-----------");
    }

    static Scanner scn = new Scanner(System.in);
    static SoftwareCompany findCompany(ArrayList<SoftwareCompany> emps, String name){
        for(SoftwareCompany emp: emps){
            if(emp.getName().equalsIgnoreCase(name)){
                return emp;
            }
        }
        return null;
    }
    
    static ProjectManager findProjectManager(ArrayList<Employee> emps, String name){
        for(int i = 0; i < emps.size(); i++){
            ProjectManager emp = (ProjectManager) emps.get(i);
            if(emp.getCurrentProject().equalsIgnoreCase(name)){
                return emp;
            }
        }
        return null;
    }

    public static void fromConsole(String[] args) {
        ArrayList<SoftwareCompany> companyList = new ArrayList<>();

        while(true){
            System.out.println("Your command : ");
            
            String c1 = scn.next();
            String c2 = scn.next();

            System.out.println(c1);
            System.out.println(c2);

            if(c1.equalsIgnoreCase("c")  && c2.equalsIgnoreCase("c")){ // create company
                String name = scn.next();
                companyList.add(new SoftwareCompany(name));
            }
            else if(c1.equalsIgnoreCase("c")  && c2.equalsIgnoreCase("p")){ // create project manager
                String name = scn.next();
                String pname = scn.next();
                String cname = scn.next();

                SoftwareCompany e = findCompany(companyList, cname);
                if(e == null){
                    System.out.println("No company with this name");
                }else{
                    e.addChild(new ProjectManager(name, pname));
                }
                
            }
            else if(c1.equalsIgnoreCase("c")  && c2.equalsIgnoreCase("d")){
                String name = scn.next();
                String pname = scn.next();
                String cname = scn.next();

                SoftwareCompany e = findCompany(companyList, cname);
                if(e == null){ System.out.println("No company with name " + name); continue;}

                ProjectManager pm = findProjectManager(e.getEmployees(), pname);
                if(pm == null){ System.out.println("No project with name " + pname); continue;}

                Developer d = new Developer(name, pname);
                pm.addChild(d);
            }
            else if(c1.equalsIgnoreCase("p")){
                String name = scn.next();
                
                // SoftwareCompany e = findCompany(companyList, name);
                // if(e == null){
                //     System.out.println("No company with this name");
                // }
                // else if(c2.equalsIgnoreCase("d")){
                //     e.print(name, false);
                // }else{
                //     e.print(name, true);
                // }
                for(SoftwareCompany s: companyList){
                    if(c2.equalsIgnoreCase("d")){
                        s.print(name, false);
                    }else{
                        s.print(name, true);
                    }
                }
            }
            else if(c1.equalsIgnoreCase("q")){
                break;
            }
            else{
                System.out.println("Invalid input");
            }


        }
    }

    public static void main(String[] args) {
        fromConsole(args);
    }
}