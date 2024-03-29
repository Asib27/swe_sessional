/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package offline1_1;

import java.util.ArrayList;
import java.util.Scanner;

import offline1_1.Builder.*;
import offline1_1.graphics.Gb2GraphicsCard;
import offline1_1.graphics.Gb4GraphicsCard;
import offline1_1.graphics.GraphicsCard;
import offline1_1.ram.*;

public class App {
    static Scanner scn = new Scanner(System.in);

    private static int inputHelper(){
        while(true){
            String s = scn.next();

            if(s.equalsIgnoreCase("e")){
                System.out.println("Do you want to exit this order");
                System.out.println("[E] Exit");
                System.out.println("[N] No");

                s = scn.next();
                if(s.equalsIgnoreCase("e")){
                    return 0;
                }
                else{
                    System.out.println("Enter your choice: ");
                    continue;
                }
            }

            try{
                int input =  Integer.parseInt(s);
                return input;
            }catch(Exception e){
                System.out.println("Must be a integer");
                System.out.println("Your input: ");
            }
        }
    }

    private static PCBuilder getBuilder(int type){
        if(type == 1) return new GamingPCBuilder();
        if(type == 2) return new Type1PCBuilder();
        if(type == 3) return new Type2PCBuilder();
        if(type == 4) return new Type3PCBuilder();
        return null;
    }

    private static RAM getRam(int type){
        if(type == 1) return new MHz2666RAM();
        else if(type == 2) return new MHz3200RAM();
        else return null;
    }

    private static void processRamRequest(Director director){
        while(true){
            int ramType = 0;

            System.out.println("What type of ram do you want to include ");
            System.out.println("[1] 8 GB DDR4 2666 MHz RAM");
            System.out.println("[2] 8 GB DDR4 3200 MHz RAM");
            System.out.println("[0] Quit without adding");
            System.out.println("Your choice [0-2]: ");

            ramType = inputHelper();
            if(ramType == 0) break;
            else if(ramType < 0 || ramType > 2){
                System.out.println("Invalid Choice. Should be between 0-2");
                continue;
            }
            else{
                director.addRam(getRam(ramType));
            }
        }
    }

    private static GraphicsCard getGraphicsCard(int type){
        if(type == 1) return new Gb2GraphicsCard();
        else if(type == 2) return new Gb4GraphicsCard();
        else return null;
    }

    private static void processGraphicsCardRequest(Director director){
        while(true){
            int type = 0;

            System.out.println("What type of graphics card do you want to include ");
            System.out.println("[1] 2GB graphics card");
            System.out.println("[2] 4GB graphics card");
            System.out.println("[0] Quit without adding");
            System.out.println("Your choice [0-2]: ");

            type = inputHelper();
            if(type == 0) break;
            else if(type < 0 || type > 2){
                System.out.println("Invalid Choice. Should be between 0-2");
                continue;
            }
            else{
                director.addGraphicsCard(getGraphicsCard(type));
            }
        }
    }

    private static PC processOneOrder(Director director){
        int type = 0;

        while(type == 0){
            System.out.println("What type of pc do you want to build ");
            System.out.println("[1] Gaming pc");
            System.out.println("[2] Core i5 pc");
            System.out.println("[3] Core i7 pc");
            System.out.println("[4] Core i9 pc");
            System.out.println("Your choice [1-4]: ");

            type = inputHelper();
            if(type == 0) return null;
            if(type < 1 || type > 4){
                System.out.println("Should be between 1-4\n");
                type = 0;
            }
            else break;
        }

        director.setPCBuilder(getBuilder(type));
        processRamRequest(director);
        processGraphicsCardRequest(director);

        return director.getPC();
    }

    private static boolean processWhetherNextPCOrder(){
        while(true){
            System.out.println("Do you want to add more PC ? ");
            System.out.println("[C] Continue");
            System.out.println("[E] Exit");
            String s = scn.next();

            if(s.equalsIgnoreCase("c")){
                return true;
            }
            else if(s.equalsIgnoreCase("e")) return false;
            else continue;
        }
    }

    static ArrayList<PC> processOrder(Director director){
        ArrayList<PC> pcs =  new ArrayList<>();
        
        while(true){
            PC pc = processOneOrder(director);
            if(pc == null) return pcs;
            pcs.add(pc);

            
            if(!processWhetherNextPCOrder()){
                break;
            }
        }
        
        return pcs;
    }

    private static boolean processOpeningMenu(){
        while(true){
            System.out.println("Do you want to open a new order? ");
            System.out.println("[O] Open");
            System.out.println("[Q] Quit");
            String s = scn.next();

            if(s.equalsIgnoreCase("o")){
                return true;
            }
            else if(s.equalsIgnoreCase("q")) return false;
            else continue;
        }
    }

    public static void main(String[] args) {
        Director director = new Director(new GamingPCBuilder());

        System.out.println("Welcome to PC Builder");
        while(true){
            if(!processOpeningMenu()) break;

            ArrayList<PC> pcs = processOrder(director);
            System.out.println("\nOrder Completed");
            System.out.println("Total " + pcs.size() + " ordered");
            System.out.println("=============================");


            int total = 0;
            for(int i = 0; i < pcs.size(); i++){
                System.out.println("PC " + i + " details");
                System.out.println(pcs.get(i));
                int cur = pcs.get(i).getTotalPrice();
                System.out.println("Total " + cur + "/=");
                System.out.println("==============");

                total += cur;
            }
            System.out.println("Grand Total = BDT " + total + "/=");
        }
        
        System.out.println("Thank You");
    }
}
