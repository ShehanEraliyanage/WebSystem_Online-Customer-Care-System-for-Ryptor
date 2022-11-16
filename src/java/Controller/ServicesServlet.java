
package Controller;

import ControllerHelper.InterfaceServices;
import ControllerHelper.InterfaceServicesType;
import ControllerHelper.ServicesHelper;
import ControllerHelper.ServicesTypeHelper;
import Model.Services;
import Model.ServicesType;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServicesServlet extends HttpServlet {
    
     /*
     *creating object from ServicesHelper with reference to InterfaceServices interface
     */
    InterfaceServices interfaceServices = new ServicesHelper();
    
    
     /*
     *creating object from ServicesTypeHelper with reference to InterfaceServicesType interface
     */
    InterfaceServicesType interfaceServicesType = new ServicesTypeHelper();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String action = request.getServletPath();
        switch (action) {
            case "/servicesInsert":
                insertServices(request, response);
                break;
            case "/servicesDelete":
                deleteServices(request, response);
                break;
            case "/servicesEdit":
                showEditServicesForm(request, response);
                break;
            case "/servicesUpdate":
                updateServices(request, response);
                break;
            default:
                listServices(request, response);
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
    
     private void listServices(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<ServicesType> servicesTypeList = interfaceServicesType.getAllServicesType();
        request.setAttribute("servicesTypeList", servicesTypeList);
        List<Services> servicesList = interfaceServices.getAllServices();
        request.setAttribute("servicesList", servicesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_services.jsp");
        dispatcher.forward(request, response);
    }

    private void insertServices(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Services services = new Services(
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("service_type")
        );

        if (interfaceServices.insertServices(services) > 0) {
            listServices(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteServices(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceServices.deleteServices(id) > 0) {
            listServices(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditServicesForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Services editServices = interfaceServices.selectServices(id);
        request.setAttribute("editServices", editServices);
        listServices(request, response);
    }

    private void updateServices(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Services services = new Services(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("service_type")
        );

        if (interfaceServices.updateServices(services) > 0) {
            listServices(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

}
