package Controller;

import ControllerHelper.InterfacePackageType;
import ControllerHelper.PackageTypeHelper;
import Model.PackageType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PackageTypeServlet extends HttpServlet {
    
    /*
     *creating object from PackageTypeHelper with reference to InterfacePackageType interface
     */
    InterfacePackageType interfacePackageType = new PackageTypeHelper();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getServletPath();
        switch (action) {
            case "/packageTypeInsert":
                insertPackageType(request, response);
                break;
            case "/packageTypeDelete":
                deletePackageType(request, response);
                break;
            case "/packageTypeEdit":
                showEditPackageTypeForm(request, response);
                break;
            case "/packageTypeUpdate":
                updatePackageType(request, response);
                break;
            default:
                listPackageType(request, response);
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
    
     private void listPackageType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<PackageType> packageTypeList = interfacePackageType.getAllPackageType();
        request.setAttribute("packageTypeList", packageTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_package_type.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPackageType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PackageType packageType = new PackageType(
                request.getParameter("name")
        );

        if (interfacePackageType.insertPackageType(packageType) > 0) {
            listPackageType(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deletePackageType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfacePackageType.deletePackageType(id) > 0) {
            listPackageType(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditPackageTypeForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        PackageType editPackageType = interfacePackageType.selectPackageType(id);
        request.setAttribute("editPackageType", editPackageType);
        listPackageType(request, response);
    }

    private void updatePackageType(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PackageType packageType = new PackageType(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name")
        );

        if (interfacePackageType.updatePackageType(packageType) > 0) {
            listPackageType(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

}
