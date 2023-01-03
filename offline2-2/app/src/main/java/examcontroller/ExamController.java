package examcontroller;

public class ExamController implements Mediator{
    Examiner examiner;
    Student[] students;

    public ExamController(Examiner examiner, Student[] students){
        this.examiner = examiner;
        this.students = students;
    }

    @Override
    public void notifyMediator(Participant participant) {
        // TODO Auto-generated method stub
        
    }
    
}
