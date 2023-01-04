package abccompany;

import java.util.HashSet;
import java.util.Set;

public class Server implements Publisher{
    Set<Observer> subscriber = new HashSet<>();
    String state = "O"; 
    
    @Override
    public void addSubscriber(Observer observer) {
        subscriber.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        subscriber.remove(observer);        
    }

    private void updateAll(String msg){
        for(Observer obs: subscriber){
            obs.update(msg);
        }
    }

    public void setState(String next){
        String prev = state;
        state = next;

        if(prev != state){
            updateAll(prev + state);
        }
    }
}
