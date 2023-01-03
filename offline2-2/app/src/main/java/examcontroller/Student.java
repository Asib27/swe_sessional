package examcontroller;

public class Student implements Participant{
    private int studentId;
    private Mediator mediator;

    public Student(int studentId, Mediator mediator){
        this.studentId = studentId;
        this.mediator = mediator;
    }

    public int getStudentId() {
        return studentId;
    }

    public void recieveMarks(int mark) {
        System.out.println("Recieved Student Id: " + studentId + " , Mark : " + mark);
    }

    public void sendRecheckRequest(){
        System.out.println("Student id " + studentId + " sending reexamine request");
        mediator.notifyMediator(this);
    }
}
