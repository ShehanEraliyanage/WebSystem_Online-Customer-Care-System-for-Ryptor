<%@page import="Model.Packages"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIM Packages</title>
        <link href="css/modern.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">

            <jsp:include page="/include/admin_side_nav.jsp"/>

            <div class="main">

                <jsp:include page="/include/admin_top_nav.jsp"/>

                <main class="content">
                    <div class="container-fluid">


                        <%if (request.getAttribute("simPackageList") != null) {%>
                        <!--Table start-->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">Active Packages of ${simNumber}</h5>
                                </div>
                                <div class="card-body">
                                    <table  class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Price</th>
                                                <th>Validity Period</th>
                                                <th>Any Time</th>
                                                <th>Night Time</th>
                                                <th>Type</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<Packages> simPackageList = (ArrayList<Packages>) request.getAttribute("simPackageList");
                                                for (Packages simpackages : simPackageList) {%>

                                            <tr>
                                                <td><%=simpackages.getId()%></td>
                                                <td><%=simpackages.getName()%></td>
                                                <td><%=simpackages.getDescription()%></td>
                                                <td><%=simpackages.getPrice()%></td>
                                                <td><%=simpackages.getValidityPeriod()%></td>
                                                <td><%=simpackages.getAntData()%></td>
                                                <td><%=simpackages.getNigthtData()%></td>
                                                <td><%=simpackages.getPackageType()%></td>
                                                <td class="table-action">
                                                    
                                                    <a href="simPackageDeactive?packageid=<%=simpackages.getId()%>&simid=${simID}" style="margin-left: 8px"> <button type="submit" class="btn btn-danger">Deactive</button></a>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                                        <br><br>
                        <%}%>

                       <!--Table start-->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">Package Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Price</th>
                                                <th>Validity Period</th>
                                                <th>Any Time</th>
                                                <th>Night Time</th>
                                                <th>Type</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<Packages> packageList = (ArrayList<Packages>) request.getAttribute("packageList");
                                                for (Packages packages : packageList) {%>

                                            <tr>
                                                <td><%=packages.getId()%></td>
                                                <td><%=packages.getName()%></td>
                                                <td><%=packages.getDescription()%></td>
                                                <td><%=packages.getPrice()%></td>
                                                <td><%=packages.getValidityPeriod()%></td>
                                                <td><%=packages.getAntData()%></td>
                                                <td><%=packages.getNigthtData()%></td>
                                                <td><%=packages.getPackageType()%></td>
                                                <td class="table-action">
                            
                                                    <a href="simPackageActive?packageid=<%=packages.getId()%>&simid=${simID}" style="margin-left: 8px"><button type="submit" class="btn btn-success">Active</button></a>
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
