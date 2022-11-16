package ControllerHelper;

import Model.Chat;
import Model.Customer;
import java.util.List;

public interface InterfaceChat {

    public int sendMessage(Chat chat);

    public List<Chat> getMessagesByCustomer(int customer_id);

    public List<Customer> getCustomerChatHeads();
}
