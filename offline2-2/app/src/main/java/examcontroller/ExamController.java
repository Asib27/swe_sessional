package examcontroller;

import java.util.HashSet;
import java.util.Set;

public class ExamController implements Mediator{
    Examiner examiner;
    Student[] students;
    int[] marks;
    Set<Student> recheck = new HashSet<>();

    public ExamController(){
    }

    public void setExaminer(Examiner examiner) {
        this.examiner = examiner;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public void notifyMediator(Participant participant, String msg) {
        if(participant == examiner && msg == "checked"){
            marks = examiner.getMarks();
            
            System.out.println("Exam Controller");
            System.out.println("=====================");
            for(int i = 0; i < marks.length; i++){
                System.out.println("student id " + (i+1) + " , marks : "+ marks[i]);
            }

            for(int i = 0; i < marks.length; i++){
                students[i].recieveMarks(marks[i]);
            }
        }
        else if(participant == examiner && msg == "rechecked"){
            for(Student i: recheck){
                int id = i.getStudentId();
                int mark = examiner.getMarks(id);
                if(marks[id-1] != mark){
                    System.out.println("Exam Controller: Student id : " + id + " marks updated to " + mark);
                }
                else{
                    System.out.println("Exam Controller: Student id : " + id + " marks unchanged");
                }
                i.recieveMarks(mark);
            }
            recheck.clear();
        }
        else if(participant instanceof Student){
            Student s = (Student) participant;
            System.out.println("Exam controller: Request of reexamine from studentId" + s.getStudentId());
            examiner.reexamine(s.getStudentId());
            recheck.add(s);
        }
    }
    
}
