<%@page import="ControllerHelper.CustomerHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Model.Customer"%>
<!doctype html>
<html lang="en">


    <head>

        <meta charset="utf-8" />
        <title>Profile| Ryptor</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- plugin css -->
        <link href="assets/libs/admin-resources/jquery.vectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- preloader css -->
        <link href="assets/css/main.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap Css -->
        <link href="assets/css/bootstrap.min.css" id="bootstrap-style" rel="stylesheet" type="text/css" />
        <!-- Icons Css -->
        <link href="assets/css/icons.min.css" rel="stylesheet" type="text/css" />
        <!-- App Css-->
        <link href="assets/css/app.min.css" id="app-style" rel="stylesheet" type="text/css" />

        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css" integrity="sha512-f8gN/IhfI+0E9Fc/LKtjVq4ywfhYAVeMGKsECzDUHcFJ5teVwvKTqizm+5a84FINhfrgdvjX8hEJbem2io1iTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>

    <body>
        <%
            HttpSession sessionCheck = request.getSession();

            if (null == sessionCheck.getAttribute("user_id")) {
                System.out.println("<Script>alert('Your Session Expired')</script>");
                response.sendRedirect("../index.jsp");

            }

            CustomerHelper customer1 = new CustomerHelper();
        %>

        <!-- Begin page -->


        <jsp:include page="/include/navbar.jsp"/>


        <!-- ========== Left Sidebar Start ========== -->
        <div class="vertical-menu">

            <div data-simplebar class="h-100">

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu list-unstyled" id="side-menu">
                        <li class="menu-title" data-key="t-menu">

                            Welcome <% if (null != sessionCheck.getAttribute("user_id")) {
                                    out.print(sessionCheck.getAttribute("username").toString());
                                }%>!</li>

                        <li>
                            <a href="manage_package">
                                <i data-feather="home"></i>
                                <span data-key="t-dashboard">Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="inquiry">
                                <i data-feather="home"></i>
                                <span data-key="t-dashboard">Inquiry</span>
                            </a>
                        </li>

                        <li>
                            <a href="Chat">
                                <i data-feather="home"></i>
                                <span data-key="t-dashboard">Chat</span>
                            </a>
                        </li> 
                        <li>
                            <a href="dashboard">
                                <i data-feather="home"></i>
                                <span data-key="t-dashboard">Profile</span>
                            </a>
                        </li>




                    </ul>

                    <div class="card sidebar-alert border-0 text-center mx-4 mb-0 mt-5">
                        <div class="card-body">
                            <img src="assets/images/giftbox.png" alt="">
                            <div class="mt-4">
                                <h5 class="alertcard-title font-size-16">Unlimited Access</h5>
                                <p class="font-size-13">Upgrade your plan from a Free trial, to select ?Business Plan?.</p>
                                <a href="#!" class="btn btn-primary mt-2">Upgrade Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sidebar -->
            </div>
        </div>
        <!-- Left Sidebar End -->



        <!-- ============================================================== -->
        <!-- Start right Content here -->
        <!-- ============================================================== -->
        <div class="main-content">

            <div class="page-content">
                <div class="container-fluid">

                    <!-- start page title -->
                    <div class="row">
                        <div class="col-12">
                            <div class="page-title-box d-sm-flex align-items-center justify-content-between">
                                <h4 class="mb-sm-0 font-size-18">Dashboard</h4>

                                <div class="page-title-right">
                                    <ol class="breadcrumb m-0">
                                        <li class="breadcrumb-item"><a href="javascript: void(0);">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Dashboard</li>
                                    </ol>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- end page title -->

                    <div class="row">
                        <div class="col-xl-12 col-md-12">
                            <!-- card -->
                            <div class="card">
                                <!-- card body -->
                                <div  class="custom-card-header">
                                    <h5 class="card-title">Personal & Broadbrand Information</h5> 

                                </div>
                                <div class="card-body">

                                    <table class="package-details">

                                        <%
                                            if (null != sessionCheck.getAttribute("user_id")) {%>
                                        <%  int id = Integer.parseInt(sessionCheck.getAttribute("user_id").toString());%>

                                        <%Customer customer = customer1.selectCustomer(id);%>
                                        <tr>

                                            <td >
                                                <span class="custom-card-topic">Name:</span>
                                            </td>

                                            <td class="left">
                                                <span class="custom-card-details"><%= customer.getName()%></span>
                                            </td>
                                        </tr>
                                        <tr>

                                            <td >
                                                <span class="custom-card-topic">Email:</span>
                                            </td>

                                            <td class="left">
                                                <span class="custom-card-details"><%= customer.getEmail()%></span
                                            </td>



                                        </tr>

                                        <tr>

                                            <td >
                                                <span class="custom-card-topic">Nic:</span>
                                            </td>

                                            <td class="left">
                                                <span class="custom-card-details"><%= customer.getNic()%></span>
                                            </td>
                                        </tr>
                                        <tr>

                                            <td >
                                                <span class="custom-card-topic">Address:</span>
                                            </td>

                                            <td class="left">
                                                <span class="custom-card-details"><%= customer.getAddress()%></span>
                                            </td>
                                        </tr>

                                        <% }%>
                                    </table>

                                </div>


                            </div><!-- end card body -->
                        </div><!-- end card -->

                    </div><!-- end col -->


                </div><!-- end row-->



            </div>
            <!-- container-fluid -->
        </div>
        <!-- End Page-content -->


        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6">
                        <script>document.write(new Date().getFullYear())</script> © <label style="text-decoration: none;color: #db144c" >Ryptor</label>
                    </div>
                    <div class="col-sm-6">
                        <div class="text-sm-end d-none d-sm-block">
                            Design & Develop by : <a href="#!"  style="text-decoration: none;color: #db144c" >CLAY </a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <!-- end main content-->

    <!-- JAVASCRIPT -->
    <script src="assets/libs/jquery/jquery.min.js"></script>
    <script src="assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/libs/metismenu/metisMenu.min.js"></script>

    <!-- Plugins js-->
    <script src="assets/libs/admin-resources/jquery.vectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="assets/libs/admin-resources/jquery.vectormap/maps/jquery-jvectormap-world-mill-en.js"></script>
    <!-- dashboard init -->
    <script src="assets/js/pages/dashboard.init.js"></script>

    <script src="assets/js/app.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js" integrity="sha512-MqEDqB7me8klOYxXXQlB4LaNf9V9S0+sG1i8LtPOYmHqICuEZ9ZLbyV3qIfADg2UJcLyCm4fawNiFvnYbcBJ1w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <Script>
                            //AJAX FOR DELETE,LOGOUT
                            $(document).ready(function () {


                                $("#logout-btn").click(function (event) {


                                    swal({
                                        title: "Are you sure?",
                                        text: "You will not be able to Access Some Features!",
                                        type: "warning",
                                        showCancelButton: true,
                                        confirmButtonColor: "#ed1c24",
                                        confirmButtonText: "Log Out",
                                        closeOnConfirm: false
                                    }, function () {

                                        $.ajax({
                                            url: "customerLogout",
                                            type: "POST",
                                            data: {},
                                            dataType: "JSON",
                                            success: function (result) {

                                                if (result.status == "fail") {
                                                    swal({
                                                        title: "Error!",
                                                        text: "Error..!",
                                                        type: 'error',
                                                        timer: 1500,
                                                        showConfirmButton: false

                                                    });
                                                } else if (result.status == "pass") {
                                                    swal({
                                                        title: "Success!",
                                                        text: "Your Have Successfully Logout!",
                                                        type: 'success',
                                                        timer: 2000,
                                                        showConfirmButton: false
                                                    }, function () {
                                                        setTimeout(function () {
                                                            window.location.replace("home");
                                                        }, 1500);
                                                    });

                                                }


                                            }
                                        });
                                    });


                                });
                            });
    </script>



</body>


</html>