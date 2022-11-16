
package Controller;

import ControllerHelper.InterfaceServicesType;
import ControllerHelper.ServicesTypeHelper;
import Model.ServicesType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServicesTypeServlet extends HttpServlet {
    
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
            case "/servicesTypeInsert":
                insertServicesType(request, response);
                break;
            case "/servicesTypeDelete":
                deleteServicesType(request, response);
                break;
            case "/servicesTypeEdit":
                showEditServicesTypeForm(request, response);
                break;
            case "/servicesTypeUpdate":
                updateServicesType(request, response);
                break;
            default:
                listServicesType(request, response);
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
    
    
    private void listServicesType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<ServicesType> servicesTypeList = interfaceServicesType.getAllServicesType();
        request.setAttribute("servicesTypeList", servicesTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_services_type.jsp");
        dispatcher.forward(request, response);
    }

    private void insertServicesType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        ServicesType servicesType = new ServicesType(
                request.getParameter("name")
        );

        if (interfaceServicesType.insertServicesType(servicesType) > 0) {
            listServicesType(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteServicesType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceServicesType.deleteServicesType(id) > 0) {
            listServicesType(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditServicesTypeForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        ServicesType editServicesType = interfaceServicesType.selectServicesType(id);
        request.setAttribute("editServicesType", editServicesType);
        listServicesType(request, response);
    }

    private void updateServicesType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        ServicesType servicesType = new ServicesType(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name")
        );

        if (interfaceServicesType.updateServicesType(servicesType) > 0) {
            listServicesType(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

}
