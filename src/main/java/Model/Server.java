package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private volatile BlockingQueue<Customer> customers;
    private AtomicInteger waitingPeriod;
    private AtomicInteger totalWaitingPeriod;
    private boolean exit;

    public Server()
    {
        this.customers = new LinkedBlockingQueue<>();
        this.waitingPeriod = new AtomicInteger(0);
        this.totalWaitingPeriod = new AtomicInteger(0);
        this.exit = true;
    }

    public void addCustomer(Customer newCustomer)
    {
        customers.add(newCustomer);
        waitingPeriod.addAndGet(newCustomer.getServiceTime());
        for(Customer customer : this.customers) {
            totalWaitingPeriod.addAndGet(customer.getServiceTime());
        }
    }
    @Override
    public void run() {
        while(exit)
        {
            if(!customers.isEmpty())
            {
                Customer headCustomer;
                headCustomer = getFirstCustomer();

                try
                {
                    Thread.sleep(1000 * headCustomer.getServiceTime());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                waitingPeriod.addAndGet(-headCustomer.getServiceTime());
                customers.remove(headCustomer);
            }
            else
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Customer getFirstCustomer()
    {
        return customers.peek();
    }

    public int getCustomersSize()
    {
        return customers.size();
    }

    public BlockingQueue<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(BlockingQueue<Customer> customers) {
        this.customers = customers;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public AtomicInteger getTotalWaitingPeriod() {
        return totalWaitingPeriod;
    }

    public void setTotalWaitingPeriod(AtomicInteger totalWaitingPeriod) {
        this.totalWaitingPeriod = totalWaitingPeriod;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
