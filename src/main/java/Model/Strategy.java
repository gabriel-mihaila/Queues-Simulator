package Model;

import java.util.List;

public interface Strategy {

    public void addCustomer(List<Server> servers, Customer customer);
}
