<%@page import="ControllerHelper.AgentHelper"%>
<%@page import="ControllerHelper.AdminHelper"%>
<%@page import="ControllerHelper.BranchHelper"%>
<%@page import="ControllerHelper.SimHelper"%>
<%@page import="ControllerHelper.PackageHelper"%>
<%@page import="ControllerHelper.CustomerHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboards</title>
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
                                Analytics Overview
                            </h1>

                        </div>

                        <div class="row">
                            <div class="col-xl-6 col-xxl-5 d-flex">
                                <div class="w-100">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Customers</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="users"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    
                                                    <h1 class="display-5 mt-2 mb-4"><%=new CustomerHelper().CountCustomer()%></h1>

                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Packages</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="package"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new PackageHelper().CountPackage()%></h1>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">SIM</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="globe"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new SimHelper().CountSim()%></h1>

                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Branches</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="home"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new BranchHelper().CountBranch()%></h1>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-xl-6 col-xxl-5 d-flex">
                                <div class="w-100">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Active SIM</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="wifi"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new SimHelper().CountActiveSim()%></h1>

                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Admin</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="users"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new AdminHelper().CountAdmin()%></h1>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Deactive SIM</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="wifi-off"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new SimHelper().CountDeactiveSim()%></h1>

                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row">
                                                        <div class="col mt-0">
                                                            <h5 class="card-title">Agents</h5>
                                                        </div>

                                                        <div class="col-auto">
                                                            <div class="avatar">
                                                                <div class="avatar-title rounded-circle bg-primary-dark">
                                                                    <i class="align-middle" data-feather="users"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <h1 class="display-5 mt-2 mb-4"><%=new AgentHelper().CountAgent()%></h1>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>


                        </div>


                    </div>
                </main>



            </div>

        </div>




        <script src="js/app.js"></script>


    </body>

</html>