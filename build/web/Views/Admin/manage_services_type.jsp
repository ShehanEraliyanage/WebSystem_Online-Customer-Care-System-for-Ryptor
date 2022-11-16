<%@page import="Model.ServicesType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Services Type </title>
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
                                <%if (request.getAttribute("editServicesType") != null) {%>
                                Edit Service Type
                                <%} else {%>
                                Add New Service Type
                                <%}%>
                            </h1>

                        </div>

                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editServicesType") == null) {%>
                                    <form action="servicesTypeInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editServicesType") != null) {%>
                                        <form action="servicesTypeUpdate" method="post">
                                            <%}%>
                                            <div class="row">
                                                <%if (request.getAttribute("editServicesType") != null) {%>
                                                <input type="hidden" class="form-control"  value="${editServicesType.id}" name="id" >
                                                <%}%>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Service Type Name</label>
                                                    <input type="text" class="form-control"  value="${editServicesType.name}" name="name" >
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
                                    <h5 class="card-title">Service Type Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Service Type Name</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<ServicesType> servicesTypeList = (ArrayList<ServicesType>) request.getAttribute("servicesTypeList");
                                                for (ServicesType servicesType : servicesTypeList) {%>

                                            <tr>
                                                <td><%=servicesType.getId()%></td>
                                                <td><%=servicesType.getName()%></td>
                                                <td class="table-action">
                                                    <a href="servicesTypeEdit?id=<%=servicesType.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                    <a href="servicesTypeDelete?id=<%=servicesType.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
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
