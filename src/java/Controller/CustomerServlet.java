package Controller;

import ControllerHelper.AgentHelper;
import ControllerHelper.CustomerHelper;
import ControllerHelper.FuntionHelper;
import ControllerHelper.InterfaceCustomer;
import Model.Agent;
import Model.Customer;
import Model.UserCredentials;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

public class CustomerServlet extends HttpServlet {
    
    /*
     *creating object from CustomerHelper with reference to InterfaceCustomer interface
     */
    InterfaceCustomer interfaceCustomer = new CustomerHelper();

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/customerLogin":
                customerLogin(request, response);
                break;
            case "/customerLogout":
                customerLogout(request, response);
                break;
            case "/customerInsert":
                insertCustomer(request, response);
                break;
            case "/customerDelete":
                deleteCustomer(request, response);
                break;
            case "/customerEdit":
                showEditCustomerForm(request, response);
                break;
            case "/customerUpdate":
                updateCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Customer> customerList = interfaceCustomer.getAllCustomers();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Customer customer = new Customer(
                request.getParameter("name"),
                request.getParameter("nic"),
                new FuntionHelper().randomUserName(),
                new FuntionHelper().randomPassword(),
                request.getParameter("address"),
                request.getParameter("email"),
                request.getParameter("contactNo")
        );

        if (interfaceCustomer.insertCustomer(customer) > 0) {
            listCustomer(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceCustomer.deleteCustomer(id) > 0) {
            listCustomer(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer editCustomer = interfaceCustomer.selectCustomer(id);
        request.setAttribute("editCustomer", editCustomer);
        listCustomer(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Customer customer = new Customer(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("nic"),
                request.getParameter("user_name"),
                request.getParameter("password"),
                request.getParameter("address"),
                request.getParameter("email"),
                request.getParameter("contactNo")
        );

        if (interfaceCustomer.updateCustomer(customer) > 0) {
            listCustomer(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    public static int randomAgent() {
        List<Agent> agents = new AgentHelper().getAllAgent();
        int agentCount = agents.size();

        Random random = new Random();
        //Randomly get a agent_id
        int agent_id = random.nextInt(agentCount);

        return agent_id;
    }

    private void customerLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
       
        UserCredentials customer = new Customer(
                request.getParameter("email"),
                request.getParameter("password")
        );

        if (interfaceCustomer.validateCustomer(customer) != null) {

            Customer getCustomer = interfaceCustomer.validateCustomer(customer);

            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            session.setAttribute("username", getCustomer.getUserName());
            session.setAttribute("user_id", getCustomer.getId());
            session.setAttribute("nic", getCustomer.getNic());
            session.setAttribute("agent_id", randomAgent());

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

    private void customerLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sessionLogout = request.getSession();
        sessionLogout.invalidate();
        JSONObject jsonData = new JSONObject();
        jsonData.put("status", "pass");
        response.setContentType("application/json");
        response.getWriter().print(jsonData.toString());

    }


}
