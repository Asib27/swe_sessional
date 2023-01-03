package examcontroller;

public class Examiner implements Participant{
    private int[] marks;
    private Mediator mediator;

    public Examiner(Mediator mediator, int [] marks){
        this.mediator = mediator;
        this.marks = marks;
    }

    public int[] getMarks() {
        return marks;
    }

    public void sendMarks(){
        System.out.println("Examiner sending marks to exam controller");
        System.out.println("===========================================");
        for(int i = 0; i < marks.length; i++){
            System.out.println("student id " + (i+1) + " , marks : "+ marks[i]);
        }
        mediator.notifyMediator(this);
    }

    public int reexamine(int id){
        System.out.println("Recieved reexamine request of student id " + id);
        System.out.println("Marks unchanged");
        return marks[id-1];
    }
}
