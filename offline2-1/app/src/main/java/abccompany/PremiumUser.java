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
        System.out.println("message " + msg);
    }
    
}
