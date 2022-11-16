<%@page import="Model.Services"%>
<%@page import="ControllerHelper.ServicesHelper"%>
<%@page import="Model.ServicesType"%>
<%@page import="ControllerHelper.PackageHelper"%>
<%@page import="Model.PackageType"%>
<%@page import="Model.Packages"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String id = (String) session.getAttribute("USER_ID");%>
<%String userType = (String) session.getAttribute("USER_TYPE");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Services</title>
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
                                <%if (request.getAttribute("editServices") != null) {%>
                                Edit Service
                                <%} else {%>
                                Add New Service
                                <%}%>
                            </h1>

                        </div>
<%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editServices") == null) {%>
                                    <form action="servicesInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editServices") != null) {%>
                                        <form action="servicesUpdate" method="post">
                                            <%}%>
                                            <%if (request.getAttribute("editServices") != null) {%>
                                            <input type="hidden"  name="id" value="${editServices.id}" >
                                            <%}%>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Service Name</label>
                                                    <input type="text" class="form-control"   value="${editServices.name}" name="name" >
                                                </div>
                                                  <div class="mb-3 col-md-6">
                                                    <label for="inputState">Service Type</label>
                                                    <select id="inputState" class="form-control" name="service_type" >
                                                        <%List<ServicesType> servicesTypeList = (ArrayList<ServicesType>) request.getAttribute("servicesTypeList");%>
                                                        <% for (ServicesType servicesType : servicesTypeList) {%>
                                                            <%if (ServicesHelper.SERVICETYPE != null) {%>
                                                                <%if (ServicesHelper.SERVICETYPE.equals(servicesType.getName())) {%>
                                                                    <option selected="" value="<%=servicesType.getId()%>"><%=servicesType.getName()%></option> 
                                                                <%} else {%>
                                                                    <option  value="<%=servicesType.getId()%>"><%=servicesType.getName()%></option> 
                                                                <%}%>
                                                            <%} else {%>
                                                                   <option  value="<%=servicesType.getId()%>"><%=servicesType.getName()%></option> 
                                                            <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Description</label>
                                                <%if (request.getAttribute("editServices") != null) {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="description" >${editServices.description}</textarea>
                                                <%} else {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="description" ></textarea>
                                                <%}%>
                                            </div>

                                            <button type="submit" class="btn btn-primary">Submit</button>

                                        </form>
                                </div>
                            </div>
                        </div>
                 <%}%> 
                 
                        <!--Table start-->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">Services Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Type</th>
                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                <th>Action</th>
                                                 <%}%>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<Services> servicesList = (ArrayList<Services>) request.getAttribute("servicesList");
                                                for (Services services : servicesList) {%>

                                            <tr>
                                                <td><%=services.getId()%></td>
                                                <td><%=services.getName()%></td>
                                                <td><%=services.getDescription()%></td>
                                                <td><%=services.getServicetype_id()%></td>
                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                <td class="table-action">
                                                    <a href="servicesEdit?id=<%=services.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                    <a href="servicesDelete?id=<%=services.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
                                                </td>
                                                 <%}%>
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
