package examcontroller;

import java.util.Arrays;
import java.util.Random;

public class Examiner implements Participant{
    private int[] marks;
    private int[] wrongMarks;
    private Mediator mediator;

    private Random random =  new Random();

    public Examiner(Mediator mediator, int [] marks){
        this.mediator = mediator;
        this.marks = marks;

        int mistake = random.nextInt(marks.length);
        wrongMarks =  Arrays.copyOf(marks, marks.length);
        wrongMarks[mistake] -= 5;

        for(int i = 0; i < marks.length; i++){
            wrongMarks[i] -= (random.nextInt(2)) * 5;
        }
    }

    public int[] getMarks() {
        return wrongMarks;
    }

    public int getMarks(int id){
        return wrongMarks[id-1];
    }

    public void sendMarks(){
        System.out.println("Examiner sending marks to exam controller");
        System.out.println("===========================================");
        for(int i = 0; i < marks.length; i++){
            System.out.println("student id " + (i+1) + " , marks : "+ marks[i]);
        }
        mediator.notifyMediator(this, "checked");
    }

    public void sendRecheckMarks(){
        System.out.println("Examiner sending recheck result to exam controller");
        System.out.println("===================================================");
        mediator.notifyMediator(this, "rechecked");
    }

    public void reexamine(int id){
        System.out.println("Recieved reexamine request of student id " + id);
        wrongMarks[id-1] = marks[id-1];
    }
}
