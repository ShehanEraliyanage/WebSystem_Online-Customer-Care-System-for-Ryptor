package Controller;

import ControllerHelper.InterfaceRequest;
import ControllerHelper.RequestHelper;
import Model.Request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

public class RequestServlet extends HttpServlet {

    /*
     *creating object from RequestHelper with reference to InterfaceRequest interface
     */
    InterfaceRequest interfaceRequest = new RequestHelper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/requestInsert":
                insertRequest(request, response);
                break;
            case "/fowardRequest":
                fowardRequest(request, response);
                break;
            case "/confirmRequest":
                confirmRequest(request, response);
                break;
            case "/rejectRequest":
                rejectRequest(request, response);
                break;
            case "/deleteRequest":
                deleteRequest(request, response);
                break;
            default:
                listRequest(request, response);
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

    private void listRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("USER_ID");
        String userType = (String) session.getAttribute("USER_TYPE");

        List<Request> requestList = interfaceRequest.getAllRequestByEmployeeType(Integer.parseInt(id), userType);
        request.setAttribute("requestList", requestList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/customer_request.jsp");
        dispatcher.forward(request, response);
    }

    private void insertRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Request inquiry = new Request(
                request.getParameter("topic"),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("customer_id")),
                request.getParameter("connection"),
                Integer.parseInt(request.getParameter("agent_id"))
        );
        if (interfaceRequest.insertRequest(inquiry) > 0) {
            request.getRequestDispatcher("inquiry").forward(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void fowardRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("USER_ID");
        String userType = (String) session.getAttribute("USER_TYPE");

        int id = Integer.parseInt(request.getParameter("id"));

        if (interfaceRequest.fowardRequest(id, Integer.parseInt(userID), userType) > 0) {
            listRequest(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void confirmRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceRequest.toConfirmRequest(id) > 0) {
            listRequest(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void rejectRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceRequest.toRejectRequest(id) > 0) {
            listRequest(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (new RequestHelper().deleteRequest(id) > 0) {
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

}
