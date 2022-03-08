package Model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private Strategy strategy;

    public Scheduler(int maxNoServers)
    {
        this.servers = new ArrayList<>();
        for(int i = 0; i < maxNoServers; i++)
        {
            Server server;
            server = new Server();
            servers.add(server);
        }

    }

    public void startServers()
    {
        for(Server server : this.servers)
        {
            Thread thread = new Thread(server);
            thread.start();
        }
    }

    public void changeStrategy(SelectionPolicy selectionPolicy)
    {
        if(selectionPolicy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyQueue();
        }

        if(selectionPolicy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchCustomer(Customer customer)
    {
        strategy.addCustomer(servers, customer);
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
