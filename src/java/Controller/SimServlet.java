/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ControllerHelper.InterfaceSim;
import ControllerHelper.SimHelper;
import Model.Sim;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hirusha
 */
public class SimServlet extends HttpServlet {
    
     /*
     *creating object from SimHelper with reference to InterfaceSim interface
     */
    InterfaceSim interfaceSim = new SimHelper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/simInsert":
                insertSim(request, response);
                break;
            case "/simDelete":
                deleteSim(request, response);
                break;
            case "/simEdit":
                showEditSimForm(request, response);
                break;
            case "/simUpdate":
                updateSim(request, response);
                break;
            case "/simActive":
                toActive(request, response);
                break;
            case "/simDeactive":
                toDeactive(request, response);
                break;
            default:
                listSim(request, response);
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

    private void listSim(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Sim> simList = interfaceSim.getAllSim();
        request.setAttribute("simList", simList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Admin/manage_sim.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSim(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Sim sim = new Sim(
                request.getParameter("number"),
                1,
                request.getParameter("nic")
        );

        if (interfaceSim.insertSim(sim) > 0) {
            listSim(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void deleteSim(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceSim.deleteSim(id) > 0) {
            listSim(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void showEditSimForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Sim editSim = interfaceSim.selectSim(id);
        request.setAttribute("editSim", editSim);
        listSim(request, response);
    }

    private void updateSim(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Sim sim = new Sim(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("number"),
                request.getParameter("nic")
        );

        if (interfaceSim.updateSim(sim) > 0) {
            listSim(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void toActive(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceSim.toActive(id,1) > 0) {
            listSim(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

    private void toDeactive(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (interfaceSim.toDeactive(id,0) > 0) {
            listSim(request, response);
        } else {
            request.getRequestDispatcher("Views/Admin/fail.jsp").forward(request, response);
        }
    }

}
