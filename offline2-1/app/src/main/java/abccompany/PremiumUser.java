package abccompany;

public class PremiumUser implements Observer {
    Publisher publisher;
    String username;

    public PremiumUser(Publisher publisher, String username){
        this.publisher = publisher;
        publisher.addSubscriber(this);
        this.username = username;
    }

    @Override
    public void update(String msg) {
        System.out.println("========== Premium User : " + username +" ============");

        if(msg.charAt(0) == 'O' && msg.charAt(1) == 'P'){
            operationalToPartial();
        }
        else if(msg.charAt(0) == 'O' && msg.charAt(1) == 'F'){
            System.out.println("Service is now provided by DEF company");
        }
        else if(msg.charAt(0) == 'P' && msg.charAt(1) == 'O'){
            System.out.println("ABC server is now operational");
        }
        else if(msg.charAt(0) == 'P' && msg.charAt(1) == 'F'){
            System.out.println("Service is now provided by ABC server");
        }
        else if(msg.charAt(0) == 'F' && msg.charAt(1) == 'O'){
            System.out.println("Server is now operational");
        }
        else if(msg.charAt(0) == 'O' && msg.charAt(1) == 'P'){
            System.out.println("Server is partially  down.");
        }
    }
    
    private void operationalToPartial(){
        System.out.println("Our server is partially down. Do you want service from -");
        System.out.println("[1] 2 servers");
        System.out.println("[2] 1 server");
        int input = App.scn.nextInt();
        if(input == 1){
            System.out.println("You are taking service from ABC and DEF server");
            publisher.useServer(input, this);
        }
        else{
            System.out.println("You are taking service from DEF server");
            publisher.useServer(input, this);
        }
    }
}
