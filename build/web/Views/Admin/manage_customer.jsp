<%@page import="Model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%String id = (String) session.getAttribute("USER_ID");%>
<%String userType = (String) session.getAttribute("USER_TYPE");%>

<html>
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Manage</title>
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
                                <%if (request.getAttribute("editCustomer") != null) {%>
                                Edit Customer
                                <%} else {%>
                                Add New Customer
                                <%}%>
                            </h1>

                        </div>

                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editCustomer") == null) {%>
                                    <form action="customerInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editCustomer") != null) {%>
                                        <form action="customerUpdate" method="post">
                                            <%}%>
                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Name</label>
                                                    <input type="text" class="form-control"   value="${editCustomer.name}" name="name" required >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputPassword4">Email</label>
                                                    <input type="email" class="form-control" id="inputPassword4"  value="${editCustomer.email}"  name="email" required>
                                                </div>
                                            </div>

                                            <%if (request.getAttribute("editCustomer") != null) {%>
                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">User Name</label>
                                                    <input type="hidden"  name="id" value="${editCustomer.id}" >
                                                    <input type="text" class="form-control"  name="user_name" value="${editCustomer.userName}" required >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputPassword4">Password</label>
                                                    <input type="test" class="form-control" name="password" value="${editCustomer.password}" required >
                                                </div>
                                            </div>
                                            <%}%>

                                            <div class="mb-3 ">
                                                <label for="inputAddress">Address</label>
                                                <input type="text" class="form-control" id="inputAddress"  value="${editCustomer.address}" name="address" required >

                                            </div>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputCity">NIC</label>
                                                    <input type="text" class="form-control"  value="${editCustomer.nic}" name="nic" required >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputCity">Contact No</label>
                                                    <input type="text" class="form-control"  value="${editCustomer.contactNo}" name="contactNo" required >
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
                                    <h5 class="card-title">Customer Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>NIC</th>
                                                <th>Address</th>
                                                <th>Contact No</th>
                                                <th>User Name</th>
                                                <th>Password</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<Customer> customerList = (ArrayList<Customer>) request.getAttribute("customerList");
                                                for (Customer customer : customerList) {%>

                                            <tr>
                                                <td><%=customer.getId()%></td>
                                                <td><%=customer.getName()%></td>
                                                <td><%=customer.getEmail()%></td>
                                                <td><%=customer.getNic()%></td>
                                                <td><%=customer.getAddress()%></td>
                                                <td><%=customer.getContactNo()%></td>
                                                <td><%=customer.getUserName()%></td>
                                                <td><%=customer.getPassword()%></td>
                                                <td class="table-action">
                                                    <a href="customerEdit?id=<%=customer.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                  <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                    <a href="customerDelete?id=<%=customer.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
                                                  <%}%>
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