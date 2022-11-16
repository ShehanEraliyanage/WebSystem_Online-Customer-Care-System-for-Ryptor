package Controller;

import ControllerHelper.FaqHelper;
import ControllerHelper.InterfaceFaq;
import Model.FAQ;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FaqServlet extends HttpServlet {
    
    
     /*
     *creating object from FaqHelper with reference to InterfaceFaq interface
     */
    InterfaceFaq interfaceFaq = new FaqHelper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getServletPath();
        switch (action) {
            case "/faqInsert":
                insertFAQ(request, response);
                break;
            case "/faqDelete":
                deleteFAQ(request, response);
                break;
            case "/faqEdit":
                showEditFAQForm(request, response);
                break;
            case "/faqUpdate":
                updateFAQ(request, response);
                break;
            default:
                listFAQ(request, response);
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
    
    private void listFAQ(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        List<FAQ> faqList = interfaceFaq.getAllFAQ();
        request.setAttribute("faqList", faqList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_faq.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFAQ(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        FAQ faq = new FAQ(
                request.getParameter("question"),
                request.getParameter("answer")
        );

        if (interfaceFaq.insertFAQ(faq) > 0) {
            listFAQ(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteFAQ(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceFaq.deleteFAQ(id) > 0) {
            listFAQ(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }

    }

    private void showEditFAQForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        FAQ editFAQ = interfaceFaq.selectFAQ(id);
        request.setAttribute("editFAQ", editFAQ);
        listFAQ(request, response);
    }

    private void updateFAQ(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        FAQ faq = new FAQ(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("question"),
                request.getParameter("answer")
        );

        if (interfaceFaq.updateFAQ(faq) > 0) {
            listFAQ(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }
}
