<%@page import="ControllerHelper.CommonConstant"%>
<%@page import="ControllerHelper.AgentHelper"%>
<%@page import="Model.Agent"%>
<%@page import="ControllerHelper.AdminHelper"%>
<%@page import="Model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%  String id = (String) session.getAttribute("USER_ID");%>
<%String userType = (String) session.getAttribute("USER_TYPE");%>
<%Admin admin = null;%>
<%Agent agent = null;%>
<%if ("admin".equals(userType) || "manager".equals(userType)) {%>
<%admin = new AdminHelper().selectAdmin(Integer.parseInt(id));%>
<%} else {%>
<%agent = new AgentHelper().selectAgent(Integer.parseInt(id));%>
<%}%> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link href="css/modern.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css" integrity="sha512-f8gN/IhfI+0E9Fc/LKtjVq4ywfhYAVeMGKsECzDUHcFJ5teVwvKTqizm+5a84FINhfrgdvjX8hEJbem2io1iTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

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
                                Profile Settings
                            </h1>
                        </div>
                        <div class="row">
                            <div class="col-md-3 col-xl-2">

                                <div class="card">


                                    <div class="list-group list-group-flush" role="tablist">
                                        <a class="list-group-item list-group-item-action active" data-bs-toggle="list" href="#viewprofile" role="tab" aria-selected="false">
                                            View Profile
                                        </a>
                                        <a class="list-group-item list-group-item-action " data-bs-toggle="list" href="#password" role="tab" aria-selected="true">
                                            Password
                                        </a>
                                        <a class="list-group-item list-group-item-action" data-bs-toggle="list" href="#editprofile" role="tab" aria-selected="false">
                                            Edit Profile
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-9 col-xl-10">
                                <div class="tab-content">


                                    <div class="tab-pane fade active show" id="viewprofile" role="tabpanel">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h5 class="card-title mb-0">Profile info</h5>
                                                </div>
                                                <div class="card-body">

                                                    <div class="row">

                                                        <div class="col-md-4">
                                                            <div class="text-center">
                                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                    <%if (admin.getImage() == null) {%>
                                                                    <img alt="Chris Wood" src="img/defult_avatar.jpg" class="rounded-circle img-responsive mt-2" width="128" height="128">
                                                                        <%if ("1".equals(id)) {%>
                                                                        <div class="fw-bold" style="font-size: 12px;margin-top: 10px">Admin Manager</div>
                                                                        <%} else {%>  
                                                                        <div class="fw-bold" style="font-size: 12px;margin-top: 10px">Admin </div>
                                                                        <%}%>
                                                                    <%} else {%>  
                                                                    <img alt="Chris Wood" src="<%=CommonConstant.ADMIN_DRI + admin.getImage()%>" class="rounded-circle img-responsive mt-2" width="128" height="128">
                                                                        <%if ("1".equals(id)) {%>
                                                                        <div class="fw-bold" style="font-size: 12px;margin-top: 10px">Admin Manager</div>
                                                                        <%} else {%>  
                                                                        <div class="fw-bold" style="font-size: 12px;margin-top: 10px">Admin </div>
                                                                        <%}%>
                                                                    <%}%>
                                                                <%} else {%>
                                                                    <%if (agent.getImage() == null) {%>
                                                                    <img alt="Chris Wood" src="img/defult_avatar.jpg" class="rounded-circle img-responsive mt-2" width="128" height="128">
                                                                    <div class="fw-bold" style="font-size: 12px;margin-top: 10px">Agent</div>
                                                                    <%} else {%>   
                                                                    <img alt="Chris Wood" src="<%=CommonConstant.AGENT_DRI + agent.getImage()%>" class="rounded-circle img-responsive mt-2" width="128" height="128">
                                                                    <div class="fw-bold" style="font-size: 12px;margin-top: 10px">Agent</div>
                                                                    <%}%>   
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="row" style="margin-bottom: 15px ;">
                                                                <div class="col-md-2"> <h4 style="color: #3e4676 ">Name</h4></div>
                                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= admin.getName()%></h4></div>
                                                                    <%} else {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= agent.getName()%></h4></div>
                                                                    <%}%>
                                                            </div>
                                                            <div class="row" style="margin-bottom: 15px ;">
                                                                <div class="col-md-2"> <h4 style="color: #3e4676">Email</h4></div>
                                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= admin.getEmail()%></h4></div>
                                                                    <%} else {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= agent.getEmail()%></h4></div>
                                                                    <%}%>
                                                            </div>
                                                            <div class="row" style="margin-bottom: 15px ;">
                                                                <div class="col-md-2"> <h4 style="color: #3e4676">NIC</h4></div>
                                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= admin.getNic()%></h4></div>
                                                                    <%} else {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= agent.getNic()%></h4></div>
                                                                    <%}%>
                                                            </div>
                                                            <div class="row" style="margin-bottom: 15px ;">
                                                                <div class="col-md-2"> <h4 style="color: #3e4676">Branch</h4></div>
                                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= admin.getBranchId()%></h4></div>
                                                                    <%} else {%>
                                                                <div class="col-md-6"><h4 style="color: black"><%= agent.getBranchId()%></h4></div>
                                                                    <%}%>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="tab-pane fade " id="password" role="tabpanel">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title">Password</h5>
                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                <form action="adminChangePassword" method="post" >
                                                    <%} else {%>
                                                    <form action="agentChangePassword" method="post">
                                                        <%}%>
                                                        <div class="mb-3">
                                                            <label for="inputPasswordCurrent">Current password</label>
                                                            <input type="hidden"  name="id" id="id" value="<%=id%>" >
                                                            <input type="password" class="form-control" id="inputPasswordCurrent" name="current_password">
                                                            <small><a href="#">Forgot your password?</a></small>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="inputPasswordNew">New password</label>
                                                            <input type="password" class="form-control" id="inputPasswordNew" name="new_password">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="inputPasswordNew2">Verify password</label>
                                                            <input type="password" class="form-control" id="inputPasswordNew2" name="verify_password">
                                                        </div>


                                                        <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                        <button type="submit" id="change-password-admin" class="btn btn-primary">Save changes</button>
                                                        <%} else {%>
                                                        <button type="submit" id="change-password-agent" class="btn btn-primary">Save changes</button>
                                                        <%}%>
                                                    </form>

                                            </div>
                                        </div>
                                    </div>


                                    <div class="tab-pane fade " id="editprofile" role="tabpanel">
                                        <div class="card">
                                            <div class="card-header">
                                                <h5 class="card-title mb-0">Edit info</h5>
                                            </div>
                                            <div class="card-body">
                                                <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                <form action="adminEditProfile" method="post" enctype="multipart/form-data">
                                                    <%} else {%>
                                                    <form action="agentEditProfile" method="post" enctype="multipart/form-data">
                                                        <%}%>
                                                        <div class="row">
                                                            <div class="col-md-8">
                                                                <div class="mb-3">
                                                                    <label for="inputUsername">Name</label>

                                                                    <input type="hidden"  name="id" value="<%=id%>" >

                                                                    <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                    <input type="text" class="form-control" id="inputUsername" name="name" value="<%= admin.getName()%>">
                                                                    <%} else {%>
                                                                    <input type="text" class="form-control" id="inputUsername" name="name" value="<%= agent.getName()%>">
                                                                    <%}%>
                                                                </div>
                                                                <div class="mb-3">
                                                                    <label for="inputUsername">NIC</label>
                                                                    <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                    <input type="text" class="form-control" id="inputUsername" name="nic" value="<%= admin.getNic()%>">
                                                                    <%} else {%>
                                                                    <input type="text" class="form-control" id="inputUsername" name="nic" value="<%= agent.getNic()%>">
                                                                    <%}%>
                                                                </div>
                                                                <div class="mb-3">
                                                                    <label for="inputUsername">Email</label>
                                                                    <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                    <input type="text" class="form-control" id="inputUsername" name="email" value="<%= admin.getEmail()%>">
                                                                    <%} else {%>
                                                                    <input type="text" class="form-control" id="inputUsername" name="email" value="<%= agent.getEmail()%>">
                                                                    <%}%>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <div class="text-center">
                                                                    <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                    <%if (admin.getImage() == null) {%>
                                                                    <img id="profile_image" alt="Chris Wood" src="img/defult_avatar.jpg" class="rounded-circle img-responsive mt-2" width="128" height="128"> 
                                                                    <%} else {%>
                                                                    <img id="profile_image" alt="Chris Wood" src="<%=CommonConstant.ADMIN_DRI + admin.getImage()%>" class="rounded-circle img-responsive mt-2" width="128" height="128">     
                                                                    <%}%>
                                                                    <%} else {%>
                                                                    <%if (agent.getImage() == null) {%>
                                                                    <img id="profile_image" alt="Chris Wood" src="img/defult_avatar.jpg" class="rounded-circle img-responsive mt-2" width="128" height="128">  
                                                                    <%} else {%>
                                                                    <img id="profile_image" alt="Chris Wood" src="<%=CommonConstant.AGENT_DRI + agent.getImage()%>" class="rounded-circle img-responsive mt-2" width="128" height="128"> 
                                                                    <%}%>
                                                                    <%}%>
                                                                    <div class="mt-2">
                                                                        <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                                                                        <input style="margin-left: 100px; margin-top: 10px" type="file" name="image" id="image" onchange="preview_image(event);"  />  
                                                                        <%} else {%>
                                                                        <input style="margin-left: 100px; margin-top: 10px" type="file" name="image" id="image" onchange="preview_image(event);"  />  
                                                                        <%}%>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                                    </form>

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

        <script>
            function preview_image(event) {
                var reader = new FileReader();
                reader.onload = function () {
                    var output = document.getElementById('profile_image');
                    output.src = reader.result;
                }
                reader.readAsDataURL(event.target.files[0]);
            }
        </script>

        <script src="js/app.js"></script>
        <script src="assets/libs/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js" integrity="sha512-MqEDqB7me8klOYxXXQlB4LaNf9V9S0+sG1i8LtPOYmHqICuEZ9ZLbyV3qIfADg2UJcLyCm4fawNiFvnYbcBJ1w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
            $(document).ready(function () {

                //AJAX FOR Chage Password admin
                $("#change-password-admin").click(function (event) {
                    event.preventDefault();

                    if (!$('#inputPasswordCurrent').val() || $('#inputPasswordCurrent').val().length === 0) {
                        swal({
                            title: "Error!",
                            text: "Please Enter Current Password",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false

                        });

                    } else if ($('#inputPasswordNew').val() != $('#inputPasswordNew2').val()) {
                        swal({
                            title: "Error!",
                            text: "Passwords Did Not Match!",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false

                        });

                    } else if ($('#inputPasswordNew').val().length < 6 || $('#inputPasswordNew2').val().length < 6) {
                        swal({
                            title: "Error!",
                            text: "Please Enter a Password 6 or More Characters..!",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false
                        });

                    } else {
                        var id = $('#id').val();

                        var current_password = $('#inputPasswordCurrent').val();

                        var new_password = $('#inputPasswordNew').val();

                        var verify_password = $('#inputPasswordNew2').val();



                        $.ajax({
                            type: "POST",
                            url: "adminChangePassword",
                            data: {id: id, current_password: current_password, new_password: new_password, verify_password: verify_password},
                            dataType: "json",
                            //if received a response from the server
                            success: function (result) {

                                if (result.status == "fail") {
                                    swal({
                                        title: "Error!",
                                        text: "Password Did Not Changed..!",
                                        type: 'error',
                                        timer: 1500,
                                        showConfirmButton: false

                                    });
                                } else if (result.status == "invalidCurrent") {
                                    swal({
                                        title: "Error!",
                                        text: "Current Password is Wrong .!",
                                        type: 'error',
                                        timer: 1500,
                                        showConfirmButton: false

                                    });
                                } else if (result.status == "pass") {
                                    swal({
                                        title: "Success!",
                                        text: "Your Have Successfully Changed The Password",
                                        type: 'success',
                                        timer: 1500,
                                        showConfirmButton: false
                                    }, function () {
                                        setTimeout(function () {
                                            window.location.replace("adminProfilePage");
                                        }, 1500);
                                    });
                                }


                            }

                        });

                    }
                });
                //AJAX FOR Change Password Agent
                $("#change-password-agent").click(function (event) {
                    event.preventDefault();

                    if (!$('#inputPasswordCurrent').val() || $('#inputPasswordCurrent').val().length === 0) {
                        swal({
                            title: "Error!",
                            text: "Please Enter Current Password",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false

                        });

                    } else if ($('#inputPasswordNew').val() != $('#inputPasswordNew2').val()) {
                        swal({
                            title: "Error!",
                            text: "Passwords Did Not Match!",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false

                        });

                    } else if ($('#inputPasswordNew').val().length < 6 || $('#inputPasswordNew2').val().length < 6) {
                        swal({
                            title: "Error!",
                            text: "Please Enter a Password 6 or More Characters..!",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false
                        });

                    } else {
                        var id = $('#id').val();

                        var current_password = $('#inputPasswordCurrent').val();

                        var new_password = $('#inputPasswordNew').val();

                        var verify_password = $('#inputPasswordNew2').val();



                        $.ajax({
                            type: "POST",
                            url: "agentChangePassword",
                            data: {id: id, current_password: current_password, new_password: new_password, verify_password: verify_password},
                            dataType: "json",
                            //if received a response from the server
                            success: function (result) {

                                if (result.status == "fail") {
                                    swal({
                                        title: "Error!",
                                        text: "Password Did Not Changed..!",
                                        type: 'error',
                                        timer: 1500,
                                        showConfirmButton: false

                                    });
                                } else if (result.status == "invalidCurrent") {
                                    swal({
                                        title: "Error!",
                                        text: "Current Password is Wrong .!",
                                        type: 'error',
                                        timer: 1500,
                                        showConfirmButton: false

                                    });
                                } else if (result.status == "pass") {
                                    swal({
                                        title: "Success!",
                                        text: "Your Have Successfully Changed The Password",
                                        type: 'success',
                                        timer: 2000,
                                        showConfirmButton: false
                                    }, function () {
                                        setTimeout(function () {
                                            window.location.replace("agentProfilePage");
                                        }, 1500);
                                    });
                                }


                            }

                        });

                    }
                });


            });
        </script>


    </body>
</html>
