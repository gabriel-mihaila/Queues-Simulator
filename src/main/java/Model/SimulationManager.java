package Model;

import View.OutputView;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulationManager implements Runnable{

    private int timeLimit;
    private int maxServicingTime;
    private int minServicingTime;
    private int maxArrivingTime;
    private int minArrivingTime;
    private int numberOfServers;
    private int numberOfCustomers;
    private SelectionPolicy selectionPolicy;
    private Scheduler scheduler;
    private OutputView outputView;
    private Writer writer;
    private List<Customer> generatedCustomers;

    public SimulationManager(int timeLimit, int maxServicingTime, int minServicingTime, int maxArrivingTime, int minArrivingTime, int numberOfCustomers, int numberOfServers, SelectionPolicy selectionPolicy){
        this.timeLimit = timeLimit;
        this.maxServicingTime = maxServicingTime;
        this.minServicingTime = minServicingTime;
        this.maxArrivingTime = maxArrivingTime;
        this.minArrivingTime = minArrivingTime;
        this.numberOfServers = numberOfServers;
        this.numberOfCustomers = numberOfCustomers;
        this.selectionPolicy = selectionPolicy;

        try {
            this.writer = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.scheduler = new Scheduler(numberOfServers);
        this.scheduler.startServers();
        scheduler.changeStrategy(this.selectionPolicy);

        this.generateNRandomCustomers();

    }

    public void generateNRandomCustomers(){
        Random random = new Random();
        int arriveTime, serviceTime;
        this.generatedCustomers = new ArrayList<>();
        for(int i = 0; i < numberOfCustomers; i++)
        {
            Customer customer;
            arriveTime = random.nextInt(maxArrivingTime - minArrivingTime + 1);
            arriveTime += minArrivingTime;
            serviceTime = random.nextInt(maxServicingTime - minServicingTime + 1);
            serviceTime += minServicingTime;

            customer = new Customer(i + 1, arriveTime, serviceTime);
            this.generatedCustomers.add(customer);
        }

        Collections.sort(this.generatedCustomers);
    }

    public void dispatchCustomerFunction(int currentTime, List<Customer> auxCustomers)
    {
        for(Customer customer : generatedCustomers) {
            if(customer.getArrivalTime() != currentTime){
                break;
            }
            scheduler.dispatchCustomer(customer);
            auxCustomers.add(customer);
        }
    }

    public int decreaseServiceTime()
    {
        int localNrOfCustomers = 0;
        for(Server server : scheduler.getServers()) {
            if(!server.getCustomers().isEmpty()) {
                localNrOfCustomers += server.getCustomersSize();
                server.getFirstCustomer().setServiceTime(server.getFirstCustomer().getServiceTime() - 1);
            }
        }

        return localNrOfCustomers;
    }

    @Override
    public void run() {
        List<Customer> auxCustomers = new ArrayList<>();
        int currentTime = 0, peakHour = 0, localNrOfCustomers, maxNrOfCustomers = 0;
        double averageServiceTime, averageWaitingTime;
        averageServiceTime = averageServiceTimeFunc();
        while(currentTime <= timeLimit && (scheduler.getServers().stream().anyMatch(x -> x != null && !x.getCustomers().isEmpty()) || !generatedCustomers.isEmpty())) {
            dispatchCustomerFunction(currentTime, auxCustomers);
            generatedCustomers.removeAll(auxCustomers);
            writeInformations(printStore(currentTime));
            localNrOfCustomers = decreaseServiceTime();
            if(localNrOfCustomers > maxNrOfCustomers){
                maxNrOfCustomers = localNrOfCustomers;
                peakHour = currentTime;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime++;
        }
        averageWaitingTime = averageWaitingTimeOnServer();
        writeInformations(printFinalData(averageServiceTime, averageWaitingTime, peakHour));
    }

    public double averageWaitingTimeOnServer()
    {
        double average;
        int i = 0;
        int sumWaitingTime = 0;
        for(Server server : scheduler.getServers()) {
            sumWaitingTime += server.getTotalWaitingPeriod().intValue();
        }

        average = (double) sumWaitingTime / (double) numberOfCustomers;
        return average;
    }

    public double averageServiceTimeFunc()
    {
        double average;
        int sumServiceTime = 0;
        for(Customer customer : generatedCustomers) {
            sumServiceTime += customer.getServiceTime();
        }

        average = (double) sumServiceTime / (double) numberOfCustomers;
        return average;
    }

    public String printStore(int currentTime)
    {
        String myText = "Time " + currentTime + "\n";
        myText += "Waiting clients: ";
        if(generatedCustomers.isEmpty()){
            myText += "empty";
        }
        for(Customer customer : generatedCustomers){
            myText += customer.toString();
        }
        int id = 0;
        myText += "\n";
        for(Server server : scheduler.getServers())
        {
            myText += "Queue " + (++id) + ": ";
            if(server.getCustomers().isEmpty())
                myText += "closed\n";
            else
            {
                for(Customer customer : server.getCustomers()) {
                    myText += customer.toString();
                }
                myText += "\n";
            }
        }

        return myText;
    }

    public String printFinalData(double averageServiceTime, double averageWaitingTime, int peakHour)
    {
        String myFinalText;
        myFinalText = "Successful simulation\n";
        myFinalText += "Average service time per customer: " + averageServiceTime + "\n";
        myFinalText += "Average waiting time per customer in the server: " + averageWaitingTime + "\n";
        myFinalText += "Peak hour: " + peakHour +"\n\n";

        return myFinalText;
    }

    public void writeInformations(String myText)
    {
       outputView.getTextPane().setText(myText + outputView.getTextPane().getText());
        try {
            writer.write(myText);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMaxServicingTime() {
        return maxServicingTime;
    }

    public void setMaxServicingTime(int maxServicingTime) {
        this.maxServicingTime = maxServicingTime;
    }

    public int getMinServicingTime() {
        return minServicingTime;
    }

    public void setMinServicingTime(int minServicingTime) {
        this.minServicingTime = minServicingTime;
    }

    public int getNumberOfServers() {
        return numberOfServers;
    }

    public void setNumberOfServers(int numberOfServers) {
        this.numberOfServers = numberOfServers;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public List<Customer> getGeneratedCustomers() {
        return generatedCustomers;
    }

    public void setGeneratedCustomers(List<Customer> generatedCustomers) {
        this.generatedCustomers = generatedCustomers;
    }

    public SelectionPolicy getSelectionPolicy() {
        return selectionPolicy;
    }

    public void setSelectionPolicy(SelectionPolicy selectionPolicy) {
        this.selectionPolicy = selectionPolicy;
    }

    public int getMaxArrivingTime() {
        return maxArrivingTime;
    }

    public void setMaxArrivingTime(int maxArrivingTime) {
        this.maxArrivingTime = maxArrivingTime;
    }

    public int getMinArrivingTime() {
        return minArrivingTime;
    }

    public void setMinArrivingTime(int minArrivingTime) {
        this.minArrivingTime = minArrivingTime;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }
}
