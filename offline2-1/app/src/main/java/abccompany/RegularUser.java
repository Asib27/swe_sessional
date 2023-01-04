package abccompany;

public class RegularUser implements Observer{
    Publisher publisher;
    String username;
    
    public RegularUser(Publisher publisher, String username){
        this.publisher = publisher;
        this.publisher.addSubscriber(this);
        this.username = username;
    }

    @Override
    public void update(String msg) {
        System.out.println("========== Regular User : " + username +" ============");
        System.out.println("message " + msg);
        
        if(msg.charAt(0) == 'O' && msg.charAt(1) == 'P'){
            operationalToPartial();
        }
        else if(msg.charAt(0) == 'O' && msg.charAt(1) == 'F'){
            operationalToFull();
        }
        else if(msg.charAt(0) == 'P' && msg.charAt(1) == 'O'){
            System.out.println("Total bill :" + 100 + " dollar");
        }
        else if(msg.charAt(0) == 'P' && msg.charAt(1) == 'F'){
            System.out.println("Our server is fully down");
        }
        else if(msg.charAt(0) == 'F' && msg.charAt(1) == 'O'){
            System.out.println("Total bill :" + 100 + " dollar");
        }
        else if(msg.charAt(0) == 'O' && msg.charAt(1) == 'P'){
            System.out.println("Server is now partially down.");
        }
    }


    private void operationalToPartial(){
        System.out.println("Our server is partially down. Do you want to - ");
        System.out.println("[1] Continue using limited functionality");
        System.out.println("[2] Pay $20 for full functionality");
        int input = App.scn.nextInt();
        if(input == 1){
            System.out.println("You are using limited functionality");
        }
        else{
            System.out.println("Your data is copied to the server of DEF company");
        }
    }
    
    private void operationalToFull(){
        System.out.println("Our server is fully down. Do you want to pay 20$ per hour to take service from DEF company ");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int input = App.scn.nextInt();
        if(input == 1){
            System.out.println("Your data is copied to the server of DEF company");
        }
        else{
        }
    }
    
}
