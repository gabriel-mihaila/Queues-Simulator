package Model;

public class Customer implements Comparable<Customer>{
    private int id;
    private volatile int arrivalTime;
    private volatile int serviceTime;


    public Customer(int id, int arrivalTime, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Customer customer) {
        return this.arrivalTime - customer.arrivalTime;
    }

    public String toString(){
        return "(" + this.id + ", " + this.arrivalTime + ", " + this.serviceTime + ") ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

}
