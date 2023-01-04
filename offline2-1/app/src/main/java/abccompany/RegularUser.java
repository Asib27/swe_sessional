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
    }
    
}
