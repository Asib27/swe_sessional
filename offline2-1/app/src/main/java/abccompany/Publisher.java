package abccompany;

public interface Publisher {
    void addSubscriber(Observer observer);
    void removeSubscriber(Observer observer);
}
