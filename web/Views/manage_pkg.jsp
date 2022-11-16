<%@page import="Model.Packages"%>
<%@page import="ControllerHelper.PackageHelper"%>
<%@page import="Model.Sim"%>
<%@page import="ControllerHelper.SimHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Model.Customer"%>
<!doctype html>
<html lang="en">


    <head>

        <meta charset="utf-8" />
        <title>Dashboard | Ryptor</title>
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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css" integrity="sha512-f8gN/IhfI+0E9Fc/LKtjVq4ywfhYAVeMGKsECzDUHcFJ5teVwvKTqizm+5a84FINhfrgdvjX8hEJbem2io1iTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <style>
            .card-header{
                border-top: 1px solid #9b9b9c;
            }

        </style>
    </head>

    <body>
        <%
            HttpSession sessionCheck = request.getSession();

            if (null == sessionCheck.getAttribute("user_id")) {
                System.out.println("<Script>alert('Your Session Expired')</script>");
                response.sendRedirect("../index.jsp");

            }

            SimHelper sim = new SimHelper();
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



                        <!--                            <ul class="sub-menu" aria-expanded="true">
                                                        <li><a href="javascript: void(0);" data-key="t-level-1-1">Level 1.1</a></li>
                                                        <li>
                                                            <a href="javascript: void(0);" class="has-arrow" data-key="t-level-1-2">Level 1.2</a>
                                                            <ul class="sub-menu" aria-expanded="true">
                                                                <li><a href="javascript: void(0);" data-key="t-level-2-1">Level 2.1</a></li>
                                                                <li><a href="javascript: void(0);" data-key="t-level-2-2">Level 2.2</a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>-->


                    </ul>

                    <div class="card sidebar-alert border-0 text-center mx-4 mb-0 mt-5">
                        <div class="card-body">
                            <img src="assets/images/giftbox.png" alt="">
                            <div class="mt-4">
                                <h5 class="alertcard-title font-size-16">Unlimited Access</h5>
                                <p class="font-size-13">Upgrade your plan Unlimited Data on Day and Night?.</p>
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
                            <div class="alert alert-warning alert-dismissible fade show mb-0 " style="display: flex;align-items: center;padding: 8px 6px;margin-bottom: 10px !important" role="alert">
                                <i class="mdi mdi-alert-circle-outline me-2"></i>
                                Want to Activate A Package?
                                <div style="margin-left: auto">
                                    <a href="packages" type="button" class="btn btn-warning" >Active Packages</a>
                                </div>
                            </div>
                            <div class="card">
                                <!-- card body -->
                                <div  class="custom-card-header">
                                    <h5 class="card-title">Connections & Package Information</h5> 

                                </div>







                                <div class="card-body"  style="padding: 0">
                                    <%
                                        if (null != sessionCheck.getAttribute("user_id")) {
                                            String nic = sessionCheck.getAttribute("nic").toString();

                                            List<Sim> simList = (ArrayList<Sim>) sim.getSimByNic(nic);
                                            for (Sim simDetails : simList) {%>
                                    <div class="col-md-12">

                                        <div class="card"  style="border : 0"   >

                                            <div class="card-header align-items-center d-flex ">
                                                <h4 class="card-title mb-0 flex-grow-1">Connection-<%= simDetails.getSimNumber()%></h4>
                                                <div class="flex-shrink-0">
                                                    <ul class="nav justify-content-end nav-pills card-header-pills" role="tablist">
                                                        <li class="nav-item">

                                                            <%if (simDetails.getStatus() == 1) {%>
                                                            <a class="btn btn-success">
                                                                Active
                                                            </a>
                                                            <%} else {%>
                                                            <a class="btn btn-danger">
                                                                Inactive
                                                            </a>

                                                            <%}%>
                                                        </li>

                                                    </ul>
                                                </div>
                                            </div><!-- end card header -->

                                            <div class="card-body" class="collapse" id="collapseExample">

                                                <!-- Tab panes -->
                                                <div class="tab-content text-muted">

                                                    <%
                                                        PackageHelper package_helper = new PackageHelper();

                                                        List<Packages> package_list = package_helper.getAllSimPackage(simDetails.getId());

                                                        for (Packages packages : package_list) {

                                                            if ("Rental".equals(packages.getPackageType())) {
                                                    %>
                                                    <div>
                                                        <h5 style="padding: 10px 10px 10px 4px;background-color: #a1a1a1;"> Base Package</h5>
                                                        <div class="col-md-12" style="padding-top: 20px">
                                                            <div class="row">

                                                                <div class="col-md-4">

                                                                    <div class="card" class="mb-20">

                                                                        <div class="card-body">
                                                                            <div class="pkg-header">
                                                                                <h5 class="card-title"><%=packages.getName()%></h5> 
                                                                                <div class="pkg-price">
                                                                                    <label>Rs.</label> <span class="font-size-30"><%=packages.getPrice()%></span>
                                                                                </div>
                                                                            </div>
                                                                            <div class="p-10">
                                                                                <div class="pkg-data">
                                                                                    <label class="card-text">  Anytime:<span class="font-size-20"><%=packages.getAntData()%></span></label>
                                                                                    <div class="ml-auto">
                                                                                        <label class="card-text">  Nightime:<span class="font-size-20"><%=packages.getNigthtData()%></span></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="pkg-data" >
                                                                                <div>
                                                                                    <div class="pkg-validity">
                                                                                        <label class="card-text">  Validity:<span class="font-size-20"></span> </label>
                                                                                    </div>

                                                                                    <label><Span class="font-size-30"><%=packages.getValidityPeriod()%></Span> Days</label>
                                                                                </div>

                                                                                <div class="ml-auto">
                                                                                    <label class="card-text">   <a href="packages" class="btn  btn-info" >Switch</a></label>
                                                                                </div>

                                                                            </div>


                                                                        </div>
                                                                    </div>

                                                                </div>



                                                            </div>

                                                        </div>
                                                    </div>
                                                    <% }
                                                        }
                                                    %>
                                                    <div>
                                                        <h5 style="padding: 10px 10px 10px 4px;background-color: #a1a1a1;"> Add-On Packages</h5>

                                                        <div class="col-md-12" style="padding-top: 20px">
                                                            <div class="row">
                                                                <%
                                                                    for (Packages packages : package_list) {

                                                                        if (!"Rental".equals(packages.getPackageType())) {
                                                                %>
                                                                <div class="col-md-4">

                                                                    <div class="card" class="mb-20">

                                                                        <div class="card-body">
                                                                            <div class="pkg-header">
                                                                                <h5 class="card-title"><%=packages.getName()%></h5> 
                                                                                <div class="pkg-price">
                                                                                    <label>Rs.</label> <span class="font-size-30"><%=packages.getPrice()%></span>
                                                                                </div>
                                                                            </div>
                                                                            <div class="p-10">
                                                                                <div class="pkg-data">
                                                                                    <label class="card-text">  Anytime:<span class="font-size-20"><%=packages.getAntData()%></span></label>
                                                                                    <div class="ml-auto">
                                                                                        <label class="card-text">  Nightime:<span class="font-size-20"><%=packages.getNigthtData()%></span></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="pkg-data" >
                                                                                <div>
                                                                                    <div class="pkg-validity">
                                                                                        <label class="card-text">  Validity:<span class="font-size-20"></span> </label>
                                                                                    </div>

                                                                                    <label><Span class="font-size-30"><%=packages.getValidityPeriod()%></Span> Days</label>
                                                                                </div>

                                                                                <div class="ml-auto">
                                                                                    <label class="card-text">   <a href="DeactivatePackage?packageid=<%=packages.getId()%>&simid=<%=simDetails.getId()%>" class="btn  btn-danger">Deactivate</a></label>
                                                                                </div>

                                                                            </div>


                                                                        </div>
                                                                    </div>

                                                                </div>

                                                                <% }
                                                                    }
                                                                %>  
                                                            </div>

                                                        </div>
                                                    </div>



                                                </div>
                                            </div><!-- end card-body -->
                                        </div><!-- end card -->

                                    </div>
                                    <%}
                                        }%>
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