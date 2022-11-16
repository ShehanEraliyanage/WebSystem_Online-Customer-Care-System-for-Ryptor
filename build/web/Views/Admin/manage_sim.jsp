<%@page import="Model.Sim"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%String id = (String) session.getAttribute("USER_ID");%>
<%String userType = (String) session.getAttribute("USER_TYPE");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIM Manage</title>
        <link href="css/modern.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <jsp:include page="/include/admin_side_nav.jsp"/>

            <div class="main">

                <jsp:include page="/include/admin_top_nav.jsp"/>

                <main class="content">
                    <div class="container-fluid">

                        <div class="header">
                            <h1 class="header-title">
                                <%if (request.getAttribute("editSim") != null) {%>
                                Edit SIM Details 
                                <%} else {%>
                                Add New SIM
                                <%}%>
                            </h1>

                        </div>

                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editSim") == null) {%>
                                    <form action="simInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editSim") != null) {%>
                                        <form action="simUpdate" method="post">
                                            <%}%>

                                            <%if (request.getAttribute("editSim") != null) {%>
                                            <input type="hidden" class="form-control"  value="${editSim.id}" name="id" >
                                            <%}%>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">SIM Number</label>
                                                    <input type="text" class="form-control"  value="${editSim.simNumber}" name="number" >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputPassword4">Customer NIC</label>
                                                    <input type="text" class="form-control"  value="${editSim.customerNIC}"  name="nic">
                                                </div>
                                            </div>


                                            <button type="submit" class="btn btn-primary">Submit</button>

                                        </form>
                                </div>
                            </div>
                        </div>

                        <!--Table start-->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">SIM Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>SIM Number</th>
                                                <th>Customer NIC</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <% List<Sim> simList = (ArrayList<Sim>) request.getAttribute("simList");
                                                for (Sim sim : simList) {%>

                                            <tr>
                                                <td><%=sim.getId()%></td>
                                                <td><%=sim.getSimNumber()%></td>
                                                <td><%=sim.getCustomerNIC()%></td>
                                                <%if (sim.getStatus() == 1) {%>
                                                <td><div class="small"><span class="fas fa-circle chat-online" style="margin-right: 5px"></span> Active</div></td>
                                                <%} else {%>
                                                <td><div class="small"><span class="fas fa-circle chat-offline" style="margin-right: 5px"></span> Deactive</div></td>
                                                <%}%>

                                                <td class="table-action" style="width: 25%">
                                                  
                                                    <%if (sim.getStatus() == 1) {%>
                                                    <a href="simDeactive?id=<%=sim.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-user-times"></i></a>
                                                        <%} else {%>
                                                    <a href="simActive?id=<%=sim.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-user-check"></i></i></a>
                                                    <%}%>
                                                   
                                                    <a href="simEdit?id=<%=sim.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                    <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                    <a href="simDelete?id=<%=sim.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
                                                     <%}%>
                                                    <a href="manageSimPackage?simid=<%=sim.getId()%>" style="margin-left: 20px">   <button type="submit" class="btn btn-primary">Manage Package</button></a>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>



                    </div>
                </main>




            </div>



        </div>





        <script src="js/app.js"></script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Datatables basic
                $('#datatables-basic').DataTable({
                    responsive: true
                });
                // Datatables with Buttons
                var datatablesButtons = $('#datatables-buttons').DataTable({
                    lengthChange: !1,
                    buttons: ["copy", "print"],
                    responsive: true
                });
                datatablesButtons.buttons().container().appendTo("#datatables-buttons_wrapper .col-md-6:eq(0)")
            });
        </script>
    </body>
</html>
