package abccompany;

import java.util.HashSet;
import java.util.Set;

public class Server implements Publisher{
    Set<Observer> subscriber = new HashSet<>();
    Set<Observer> paying = new HashSet<>();
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
        if(state == "O") paying.clear();
    }

    @Override
    public void useServer(int num, Observer obs) {
        
    }

    @Override
    public void payForFunctionality(Observer obs) {
        paying.add(obs);
    }

    @Override
    public int getMoney(Observer obs) {
        if(paying.contains(obs))
            return 100;
        else return 0;
    }
}
