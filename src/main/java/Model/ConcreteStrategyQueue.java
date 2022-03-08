package Model;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addCustomer(List<Server> servers, Customer customer) {
        Server bestServer;
        bestServer = servers.get(0);
        for(Server server : servers)
        {
            if(server.getCustomersSize() < bestServer.getCustomersSize()){
                bestServer = server;
            }
        }

        bestServer.addCustomer(customer);
    }
}
