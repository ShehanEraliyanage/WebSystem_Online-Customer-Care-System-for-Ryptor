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
        <title>Manage Package</title>
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
                                <%if (request.getAttribute("editPackage") != null) {%>
                                Edit Package
                                <%} else {%>
                                Add New Package
                                <%}%>
                            </h1>

                        </div>
 <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editPackage") == null) {%>
                                    <form action="packageInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editPackage") != null) {%>
                                        <form action="packageUpdate" method="post">
                                            <%}%>
                                            <%if (request.getAttribute("editPackage") != null) {%>
                                            <input type="hidden"  name="id" value="${editPackage.id}" >
                                            <%}%>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Name</label>
                                                    <input type="text" class="form-control"   value="${editPackage.name}" name="name" >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Price</label>
                                                    <input type="text" class="form-control"    value="${editPackage.price}"  name="price">
                                                </div>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Description</label>
                                                <%if (request.getAttribute("editPackage") != null) {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="description" >${editPackage.description}</textarea>
                                                <%} else {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="description" ></textarea>
                                                <%}%>

                                            </div>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Any Time Data</label>
                                                    <input type="text" class="form-control"  value="${editPackage.antData}" name="any_data" >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputPassword4">Night Time Data</label>
                                                    <input type="text" class="form-control"   value="${editPackage.nigthtData}"  name="night_data">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Validity Period</label>
                                                    <input type="text" class="form-control"   value="${editPackage.validityPeriod}" name="validity_period" >
                                                </div>

                                                <div class="mb-3 col-md-6">
                                                    <label for="inputState">Package Type</label>
                                                    <select id="inputState" class="form-control" name="package_type" >
                                                        <%List<PackageType> packageTypeList = (ArrayList<PackageType>) request.getAttribute("packageTypeList");%>
                                                        <% for (PackageType packageType : packageTypeList) {%>
                                                            <%if (PackageHelper.PACKAGETYPE != null) {%>
                                                                <%if (PackageHelper.PACKAGETYPE.equals(packageType.getName())) {%>
                                                                    <option selected="" value="<%=packageType.getId()%>"><%=packageType.getName()%></option> 
                                                                <%} else {%>
                                                                    <option  value="<%=packageType.getId()%>"><%=packageType.getName()%></option> 
                                                                <%}%>
                                                            <%} else {%>
                                                                   <option  value="<%=packageType.getId()%>"><%=packageType.getName()%></option> 
                                                            <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
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
                                                  <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                <th>Action</th>
                                                  <%}%>
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
                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                <td class="table-action">
                                                    <a href="packageEdit?id=<%=packages.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                    <a href="packageDelete?id=<%=packages.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
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
