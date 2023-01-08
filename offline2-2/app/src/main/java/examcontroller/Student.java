package examcontroller;

public class Student implements Participant{
    private int studentId;
    private Mediator mediator;
    private int marks;

    public Student(int studentId, Mediator mediator){
        this.studentId = studentId;
        this.mediator = mediator;
    }

    public int getStudentId() {
        return studentId;
    }

    public void recieveMarks(int mark) {
        this.marks = mark;
        System.out.println("student : Recieved Student Id: " + studentId + " , Mark : " + mark);
    }

    public void sendRecheckRequest(){
        System.out.println("student : Student id " + studentId + " sending reexamine request");
        mediator.notifyMediator(this, "recheck");
    }
}
