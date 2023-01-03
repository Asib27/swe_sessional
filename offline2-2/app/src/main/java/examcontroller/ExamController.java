package examcontroller;

public class ExamController implements Mediator{
    Examiner examiner;
    Student[] students;

    public ExamController(){
    }

    public void setExaminer(Examiner examiner) {
        this.examiner = examiner;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public void notifyMediator(Participant participant) {
        if(participant == examiner){
            int[] marks = examiner.getMarks();
            
            System.out.println("Exam Controller");
            System.out.println("=====================");
            for(int i = 0; i < marks.length; i++){
                System.out.println("student id " + (i+1) + " , marks : "+ marks[i]);
            }

            for(int i = 0; i < marks.length; i++){
                students[i].recieveMarks(marks[i]);
            }
        }
        else if(participant instanceof Student){
            Student s = (Student) participant;
            examiner.reexamine(s.getStudentId());
        }
    }
    
}
