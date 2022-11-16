package Controller;

import ControllerHelper.BranchHelper;
import ControllerHelper.InterfaceBranch;
import Model.Branch;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchServlet extends HttpServlet {
    
    /*
     *creating object from AgentHelper with reference to InterfaceAgent interface
     */
    InterfaceBranch interfaceBranch = new BranchHelper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/branchInsert":
                insertBranch(request, response);
                break;
            case "/branchDelete":
                deleteBranch(request, response);
                break;
            case "/branchEdit":
                showEditBranchForm(request, response);
                break;
            case "/branchUpdate":
                updateBranch(request, response);
                break;
            default:
                listBranch(request, response);
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

    private void listBranch(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Branch> branchList = interfaceBranch.getAllBranch();
        request.setAttribute("branchList", branchList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_branch.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBranch(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Branch branch = new Branch(
                request.getParameter("name"),
                request.getParameter("location")
        );

        if (interfaceBranch.insertBranch(branch) > 0) {
            listBranch(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteBranch(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceBranch.deleteBranch(id) > 0) {
            listBranch(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditBranchForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Branch editBranch = interfaceBranch.selectBranch(id);
        request.setAttribute("editBranch", editBranch);
        listBranch(request, response);
    }

    private void updateBranch(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Branch branch = new Branch(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("location")
        );

        if (interfaceBranch.updateBranch(branch) > 0) {
            listBranch(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

}
