package Controller;

import ControllerHelper.InterfacePackage;
import ControllerHelper.InterfacePackageType;
import ControllerHelper.InterfaceSim;
import ControllerHelper.PackageHelper;
import ControllerHelper.PackageTypeHelper;
import ControllerHelper.SimHelper;
import Model.PackageType;
import Model.Packages;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PackageServlet extends HttpServlet {
    
     /*
     *creating object from PackageHelper with reference to InterfacePackage interface
     */
    InterfacePackage interfacePackage = new PackageHelper();
    
    
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
            case "/packageInsert":
                insertPackage(request, response);
                break;
            case "/manage_pkg":
                manage_pkg(request, response);
                break;
            case "/packageDelete":
                deletePackage(request, response);
                break;
            case "/packageEdit":
                showEditPackageForm(request, response);
                break;
            case "/packageUpdate":
                updatePackage(request, response);
                break;
            case "/manageSimPackage":
                listManageSimPackage(request, response);
                break;
            case "/simPackageActive":
                simPackageActive(request, response);
                break;
            case "/simPackageDeactive":
                simPackageDeactive(request, response);
                break;
            case "/ActivatePackage":
                ActivatePackage(request, response);
                break;
            case "/DeactivatePackage":
                DeactivatePackage(request, response);
                break;
            default:
                listPackage(request, response);
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

    private void listPackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<PackageType> packageTypeList = interfacePackageType.getAllPackageType();
        request.setAttribute("packageTypeList", packageTypeList);
        List<Packages> packageList = interfacePackage.getAllPackage();
        request.setAttribute("packageList", packageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_package.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Packages packages = new Packages(
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("price"),
                Integer.parseInt(request.getParameter("validity_period")),
                request.getParameter("any_data"),
                request.getParameter("night_data"),
                request.getParameter("package_type")
        );

        if (interfacePackage.insertPackage(packages) > 0) {
            listPackage(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deletePackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfacePackage.deletePackage(id) > 0) {
            listPackage(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditPackageForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Packages editPackage = interfacePackage.selectPackage(id);
        request.setAttribute("editPackage", editPackage);
        listPackage(request, response);
    }

    private void updatePackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Packages packages = new Packages(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("price"),
                Integer.parseInt(request.getParameter("validity_period")),
                request.getParameter("any_data"),
                request.getParameter("night_data"),
                request.getParameter("package_type")
        );

        if (interfacePackage.updatePackage(packages) > 0) {
            listPackage(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void manage_pkg(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("Views/manage_pkg.jsp").forward(request, response);
    }

    private void listManageSimPackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int simID = Integer.parseInt(request.getParameter("simid"));
        String simNumber = new SimHelper().getSimNumber(simID);
        List<Packages> simPackageList = interfacePackage.getAllSimPackage(simID);
        request.setAttribute("simPackageList", simPackageList);
        request.setAttribute("simID", simID);
        request.setAttribute("simNumber", simNumber);
        List<Packages> packageList = interfacePackage.getAllPackage();
        request.setAttribute("packageList", packageList);
        request.getRequestDispatcher("Views/Admin/manage_sim_package.jsp").forward(request, response);
    }

    private void simPackageActive(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int packageID = Integer.parseInt(request.getParameter("packageid"));
        int simID = Integer.parseInt(request.getParameter("simid"));
        if (interfacePackage.simPackageActive(simID, packageID) > 0) {
            listManageSimPackage(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void simPackageDeactive(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int packageID = Integer.parseInt(request.getParameter("packageid"));
        int simID = Integer.parseInt(request.getParameter("simid"));
        if (interfacePackage.simPackageDeactive(simID, packageID) > 0) {
            listManageSimPackage(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void ActivatePackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int packageID = Integer.parseInt(request.getParameter("packageid"));
        int simID = Integer.parseInt(request.getParameter("simid"));
        String packageType = request.getParameter("packageType");

        if ("Rental".equals(packageType)) {
            if (interfacePackage.updateRentalPackage(simID, packageID) > 0) {
                request.getRequestDispatcher("manage_package").forward(request, response);
            } else {
                request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
            }
        } else if (interfacePackage.simPackageActive(simID, packageID) > 0) {
            request.getRequestDispatcher("manage_package").forward(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void DeactivatePackage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int packageID = Integer.parseInt(request.getParameter("packageid"));
        int simID = Integer.parseInt(request.getParameter("simid"));
        if (interfacePackage.simPackageDeactive(simID, packageID) > 0) {
            request.getRequestDispatcher("manage_package").forward(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

}
