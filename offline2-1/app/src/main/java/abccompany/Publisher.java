package abccompany;

public interface Publisher {
    void addSubscriber(Observer observer);
    void removeSubscriber(Observer observer);
    void useServer(int num, Observer obs);
    void payForFunctionality(Observer obs);
    int getMoney(Observer obs);
}
