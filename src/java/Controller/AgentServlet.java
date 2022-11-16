package Controller;

import ControllerHelper.AgentHelper;
import ControllerHelper.BranchHelper;
import ControllerHelper.CommonConstant;
import ControllerHelper.FuntionHelper;
import ControllerHelper.InterfaceAgent;
import ControllerHelper.InterfaceBranch;
import ControllerHelper.validationHelper;
import Model.Agent;
import Model.Branch;
import Model.UserCredentials;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.json.JSONObject;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AgentServlet extends HttpServlet {
    
    /*
     *creating object from AgentHelper with reference to InterfaceAgent interface
     */
    InterfaceAgent interfaceAgent = new AgentHelper();
    
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
            case "/agentSignin":
                agentSignin(request, response);
                break;
            case "/agentSignOut":
                agentSignOut(request, response);
                break;
            case "/agentInsert":
                insertAgent(request, response);
                break;
            case "/agentDelete":
                deleteAgent(request, response);
                break;
            case "/agentEdit":
                showEditAgentForm(request, response);
                break;
            case "/agentUpdate":
                updateAgent(request, response);
                break;
            case "/agentProfilePage":
                agentProfilePage(request, response);
                break;
            case "/agentChangePassword":
                agentChangePassword(request, response);
                break;
            case "/agentEditProfile":
                agentEditProfile(request, response);
                break;
            default:
                listAgent(request, response);
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

    private void listAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Agent> agentList = interfaceAgent.getAllAgent();
        request.setAttribute("agentList", agentList);
        List<Branch> branchList = interfaceBranch.getAllBranch();
        request.setAttribute("branchList", branchList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_agent.jsp");
        dispatcher.forward(request, response);
    }

    private void insertAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Agent agent = new Agent(
                request.getParameter("name"),
                request.getParameter("nic"),
                request.getParameter("email"),
                FuntionHelper.randomPassword(),
                request.getParameter("branch_id")
        );

        if (interfaceAgent.insertAgent(agent) > 0) {
            listAgent(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceAgent.deleteAgent(id) > 0) {
            listAgent(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditAgentForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Agent editAgent = interfaceAgent.selectAgent(id);
        request.setAttribute("editAgent", editAgent);
        listAgent(request, response);
    }

    private void updateAgent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Agent agent = new Agent(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("nic"),
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("branch_id")
        );

        if (interfaceAgent.updateAgent(agent) > 0) {
            listAgent(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void agentSignin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (new validationHelper().isValidEmailAddress(request.getParameter("email")) == false) {
            JSONObject jsonData = new JSONObject();
            jsonData.put("status", "invalidEmail");
            response.setContentType("application/json");
            response.getWriter().print(jsonData.toString());
        } else {
            UserCredentials agent = new Agent(
                    request.getParameter("email"),
                    request.getParameter("password")
            );

            if (interfaceAgent.validateAgent(agent) > 0) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1800);
                String id = String.valueOf(interfaceAgent.validateAgent(agent));
                session.setAttribute("USER_ID", id);
                session.setAttribute("USER_TYPE", "agent");
                // request.getRequestDispatcher("Views/Admin/index.jsp").forward(request, response);
                JSONObject jsonData = new JSONObject();
                jsonData.put("status", "pass");
                response.setContentType("application/json");
                response.getWriter().print(jsonData.toString());
            } else {
                // request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
                JSONObject jsonData = new JSONObject();
                jsonData.put("status", "fail");
                response.setContentType("application/json");
                response.getWriter().print(jsonData.toString());
            }
        }
    }

    private void agentProfilePage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("Views/Admin/profile.jsp").forward(request, response);
    }

    private void agentSignOut(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.removeAttribute("USER_ID");
        request.getRequestDispatcher("Views/Admin/signin.jsp").forward(request, response);
    }

    private void agentChangePassword(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        final String curuntPassword = request.getParameter("current_password");
        final String newPassword = request.getParameter("new_password");

        if (interfaceAgent.selectChangePasswordAgent(id, curuntPassword) > 0) {
            if (interfaceAgent.changePasswordAgent(id, newPassword) > 0) {
//                    adminProfilePage(request, response);
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
        } else {
            JSONObject jsonData = new JSONObject();
            jsonData.put("status", "invalidCurrent");
            response.setContentType("application/json");
            response.getWriter().print(jsonData.toString());
        }

    }

    private void agentEditProfile(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String fileName = null;

            Part part = request.getPart("image");

            fileName = FuntionHelper.extractFileName(part);
            part.write(CommonConstant.AGENT_IMAGE_UPLOAD_DIR + fileName);

            Agent agent = new Agent(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("nic"),
                    request.getParameter("email"),
                    fileName
            );

            if (interfaceAgent.updateProfileImageAndData(agent) > 0) {
                agentProfilePage(request, response);
            } else {
                request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Agent agent = new Agent(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("nic"),
                    request.getParameter("email")
            );

            if (interfaceAgent.updateProfileData(agent) > 0) {
                agentProfilePage(request, response);
            } else {
                request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
            }
        }
    }

}
