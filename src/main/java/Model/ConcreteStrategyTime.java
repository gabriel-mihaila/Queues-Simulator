package Model;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{

    @Override
    public void addCustomer(List<Server> servers, Customer customer) {
        Server bestServer;
        bestServer = servers.get(0);

        for(Server server : servers)
        {
            if(server.getWaitingPeriod().intValue() < bestServer.getWaitingPeriod().intValue()){
                bestServer = server;
            }
        }

        bestServer.addCustomer(customer);
    }
}
