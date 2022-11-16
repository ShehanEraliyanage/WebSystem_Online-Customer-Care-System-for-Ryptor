<%@page import="Model.Branch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Package Manage</title>
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
                                <%if (request.getAttribute("editBranch") != null) {%>
                                Edit Branch
                                <%} else {%>
                                Add New Branch
                                <%}%>
                            </h1>

                        </div>

                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editBranch") == null) {%>
                                    <form action="branchInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editBranch") != null) {%>
                                        <form action="branchUpdate" method="post">
                                            <%}%>
                                            <div class="row">
                                                <%if (request.getAttribute("editBranch") != null) {%>
                                                <input type="hidden" class="form-control"  value="${editBranch.id}" name="id" >
                                                <%}%>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Branch Name</label>
                                                    <input type="text" class="form-control"  value="${editBranch.name}" name="name" >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputPassword4">Branch Location</label>
                                                    <input type="text" class="form-control"  value="${editBranch.location}"  name="location">
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
                                    <h5 class="card-title">Branch Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Branch Name</th>
                                                <th>Branch Location</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<Branch> branchList = (ArrayList<Branch>) request.getAttribute("branchList");
                                                for (Branch branch : branchList) {%>

                                            <tr>
                                                <td><%=branch.getId()%></td>
                                                <td><%=branch.getName()%></td>
                                                <td><%=branch.getLocation()%></td>
                                                <td class="table-action">
                                                    <a href="branchEdit?id=<%=branch.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                    <a href="branchDelete?id=<%=branch.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
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
