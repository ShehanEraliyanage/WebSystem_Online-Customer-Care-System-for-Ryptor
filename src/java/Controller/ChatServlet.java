package Controller;

import ControllerHelper.ChatHelper;
import ControllerHelper.CustomerHelper;
import ControllerHelper.InterfaceChat;
import ControllerHelper.InterfaceCustomer;
import Model.Chat;
import Model.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class ChatServlet extends HttpServlet {
    
    /*
     *creating object from ChatHelper with reference to InterfaceChat interface
     */
    InterfaceChat interfaceChat = new ChatHelper();
    
    /*
     *creating object from CustomerHelper with reference to InterfaceCustomer interface
     */
    InterfaceCustomer interfaceCustomer = new CustomerHelper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/sendMessage":
                sendMessage(request, response);
                break;
            case "/getMessage":
                getMessages(request, response);

                break;
            case "/getCustomerChatHead":
                getCustomerChatHead(request, response);

                break;
            case "/getCustomerNameandImage":
                getCustomerNameandImage(request, response);
                break;

        }
    }

   public void sendMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Chat chat = new Chat(
                Integer.parseInt(request.getParameter("customer_id")),
                Integer.parseInt(request.getParameter("agent_id")),
                request.getParameter("message"),
                Integer.parseInt(request.getParameter("send_by"))
        );

        
        if (Integer.parseInt(request.getParameter("customer_id"))== 0) {

            JSONObject jsonData = new JSONObject();
            jsonData.put("status", "nullCustomer");
            response.setContentType("application/json");
            response.getWriter().print(jsonData.toString());
        }else if (interfaceChat.sendMessage(chat) > 0) {

            JSONObject jsonData = new JSONObject();
            jsonData.put("status", "pass");
            response.setContentType("application/json");
            response.getWriter().print(jsonData.toString());
        } else {
            JSONObject jsonData = new JSONObject();
            jsonData.put("status", "fail");
            response.setContentType("application/json");
            response.getWriter().print(jsonData.toString());
        }

    }
    public void getMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        List<Chat> msgList = interfaceChat.getMessagesByCustomer(customer_id);

//        for (Customer customers : customerList) {
//            cus.put("name", customers.getName());
//            cus.put("user_name", customers.getUserName());
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(msgList, new TypeToken<List<Chat>>() {
        }.getType());
        JsonArray msgArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(msgArray);
    }

    public void getCustomerChatHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        List<Customer> chatList = interfaceChat.getCustomerChatHeads();
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(chatList, new TypeToken<List<Customer>>() {
        }.getType());
        JsonArray msgArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(msgArray);
    }

    public void getCustomerNameandImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        
        Customer customer = interfaceCustomer.selectCustomer(Integer.parseInt(request.getParameter("customer_id")));
        JSONObject jsonData = new JSONObject();
        jsonData.put("customer_name", customer.getName());
//        jsonData.put("customer_image", "value2");
//        jsonData.put("key3", "value3");

        response.setContentType("application/json");
        response.getWriter().print(jsonData.toString());
    }

}
