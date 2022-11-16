<%@page import="ControllerHelper.CommonConstant"%>
<%@page import="ControllerHelper.BranchHelper"%>
<%@page import="Model.Admin"%>
<%@page import="ControllerHelper.AdminHelper"%>
<%@page import="Model.Branch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Manage</title>
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
                                <%if (request.getAttribute("editAdmin") != null) {%>
                                Edit Admin
                                <%} else {%>
                                Add New Admin
                                <%}%>
                            </h1>

                        </div>

                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">

                                    <%if (request.getAttribute("editAdmin") == null) {%>
                                    <form action="adminInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editAdmin") != null) {%>
                                        <form action="adminUpdate" method="post">
                                            <%}%>
                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Name</label>
                                                    <input type="text" class="form-control"   value="${editAdmin.name}" id="name" name="name" >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputPassword4">Email</label>
                                                    <input type="email" class="form-control" value="${editAdmin.email}"  id="email" name="email">
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputAddress">NIC</label>
                                                    <input type="text" class="form-control" id="nic" value="${editAdmin.nic}" name="nic">

                                                </div>

                                                <div class="mb-3 col-md-6">
                                                    <label for="inputState">Branch</label>
                                                    <select  class="form-control" id="branch_id" name="branch_id" >

                                                        <%List<Branch> branchList = new BranchHelper().getAllBranch();%>
                                                        <% for (Branch branch : branchList) {%>
                                                            <%if (AdminHelper.BRANCHNAME != null) {%>
                                                                <%if (AdminHelper.BRANCHNAME.equals(branch.getName())) {%>
                                                                    <option selected="" value="<%=branch.getId()%>"><%=branch.getName()%></option> 
                                                                <%} else {%>
                                                                     <option  value="<%=branch.getId()%>"><%=branch.getName()%></option> 
                                                                <%}%>
                                                            <%} else {%>
                                                            <option  value="<%=branch.getId()%>"><%=branch.getName()%></option> 
                                                            <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>


                                            <%if (request.getAttribute("editAdmin") != null) {%>
                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Password</label>
                                                    <input type="hidden"  id="admin-id" name="id" value="${editAdmin.id}" >
                                                    <input type="test" class="form-control" id="password-admin" name="password" value="${editAdmin.password}">
                                                </div>
                                            </div>
                                            <%}%>
                                            <%if (request.getAttribute("editAdmin") == null) {%>
                                            <button type="submit" id="adminInsert" class="btn btn-primary">Submit</button>
                                            <%}%>
                                            <%if (request.getAttribute("editAdmin") != null) {%>
                                            <button type="submit" id="adminUpdate" class="btn btn-primary">Submit</button>
                                            <%}%>
                                        </form>
                                </div>
                            </div>
                        </div>
                                            
                  
                        <!--Table start-->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">Admin Table</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>NIC</th>
                                                <th>Email</th>
                                                <th>Password</th>
                                                <th>Branch</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%List<Admin> adminList = new AdminHelper().getAllAdmin();;
                                                for (Admin admin : adminList) {%>

                                            <tr>
                                                <td><%=admin.getId()%></td>
                                                <%if (admin.getImage() == null) {%>
                                                <td><img src="img/defult_avatar.jpg" class="rounded-circle me-2" alt="Avatar" width="48" height="48"><%=admin.getName()%></td>
                                                    <%} else {%>
                                                <td><img src="<%=CommonConstant.ADMIN_DRI + admin.getImage()%>" class="rounded-circle me-2" alt="Avatar" width="48" height="48"><%=admin.getName()%></td>
                                                    <%}%>
                                                <td><%=admin.getNic()%></td>
                                                <td><%=admin.getEmail()%></td>
                                                <td><%=admin.getPassword()%></td>
                                                <td><%=admin.getBranchId()%></td>
                                                <td class="table-action">
                                                    <a href="adminEdit?id=<%=admin.getId()%>"  style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                                    <a  class="delete-admin" delete-id="<%=admin.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
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
        <script src="assets/libs/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js" integrity="sha512-MqEDqB7me8klOYxXXQlB4LaNf9V9S0+sG1i8LtPOYmHqICuEZ9ZLbyV3qIfADg2UJcLyCm4fawNiFvnYbcBJ1w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

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
    </script>
    <script>
        $(document).ready(function () {

            //AJAX FOR INSERT
            $("#adminInsert").click(function (event) {
                event.preventDefault();

                if (!$('#name').val() || $('#name').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Name.!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#email').val() || $('#email').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Email.!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#nic').val() || $('#nic').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Nic..!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#branch_id').val() || $('#branch_id').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Select Your Branch..!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else {
                    var name = $('#name').val();

                    var email = $('#email').val();

                    var nic = $('#nic').val();

                    var password = $('#password').val()

                    var branch = $('#branch_id').val();


                    $.ajax({
                        type: "POST",
                        url: "adminInsert",
                        data: {name: name, email: email, nic: nic, password: password, branch_id: branch},
                        dataType: "json",
                        //if received a response from the server
                        success: function (result) {

                            if (result.status == "fail") {
                                swal({
                                    title: "Error!",
                                    text: "Insert Error!",
                                    type: 'error',
                                    timer: 1500,
                                    showConfirmButton: false

                                });
                            } else if (result.status == "invalidEmail") {
                                swal({
                                    title: "Error!",
                                    text: "Email is Invalid..!",
                                    type: 'error',
                                    timer: 1500,
                                    showConfirmButton: false

                                });
                            } else if (result.status == "invalidNIC") {
                                swal({
                                    title: "Error!",
                                    text: "NIC is Invalid..!",
                                    type: 'error',
                                    timer: 1500,
                                    showConfirmButton: false

                                });
                            } else if (result.status == "pass") {
                                swal({
                                    title: "Success!",
                                    text: "Your Have Successfully Unserted An Admin",
                                    type: 'success',
                                    timer: 2000,
                                    showConfirmButton: false
                                }, function () {
                                    setTimeout(function () {
                                        window.location.replace("adminPage");
                                    }, 1500);
                                });
                            }


                        }

                    });

                }
            });
            //AJAX FOR UPDATE
            $("#adminUpdate").click(function (event) {
                event.preventDefault();

                if (!$('#name').val() || $('#name').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Name.!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#email').val() || $('#email').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Email.!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#nic').val() || $('#nic').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Nic..!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#branch_id').val() || $('#branch_id').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Select Your Branch..!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else {
                    var name = $('#name').val();

                    var email = $('#email').val();

                    var nic = $('#nic').val();

                    var password = $('#password-admin').val()

                    var branch = $('#branch_id').val();
                    
                    var id = $('#admin-id').val();
                    
                    

                    $.ajax({
                        type: "POST",
                        url: "adminUpdate",
                        data: {id:id,name: name, email: email, nic: nic, password: password, branch_id: branch},
                        dataType: "json",
                        //if received a response from the server
                        success: function (result) {

                            if (result.status == "fail") {
                                swal({
                                    title: "Error!",
                                    text: "Update Error! ",
                                    type: 'error',
                                    timer: 1500,
                                    showConfirmButton: false

                                });
                            } else if (result.status == "invalidEmail") {
                                swal({
                                    title: "Error!",
                                    text: "Email is Invalid..!",
                                    type: 'error',
                                    timer: 1500,
                                    showConfirmButton: false

                                });
                            } else if (result.status == "invalidNIC") {
                                swal({
                                    title: "Error!",
                                    text: "NIC is Invalid..!",
                                    type: 'error',
                                    timer: 1500,
                                    showConfirmButton: false

                                });
                            } else if (result.status == "pass") {
                                swal({
                                    title: "Success!",
                                    text: "Your Have Successfully Updated the Admin",
                                    type: 'success',
                                    timer: 2000,
                                    showConfirmButton: false
                                }, function () {
                                    setTimeout(function () {
                                        window.location.replace("adminPage");
                                    }, 1500);
                                });
                            }


                        }

                    });

                }
            });
//AJAX FOR DELETE
            $(".delete-admin").click(function (event) {
                var id = $(".delete-admin").attr("delete-id");

                $.ajax({
                    type: "POST",
                    url: "adminDelete",
                    data: {id: id},
                    dataType: "json",
                    //if received a response from the server
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
                                text: "Your Have Successfully Deleted An Admin",
                                type: 'success',
                                timer: 2000,
                                showConfirmButton: false
                            }, function () {
                                setTimeout(function () {
                                    window.location.replace("adminPage");
                                }, 1500);
                            });
                        }


                    }

                });


            });
        });
    </script>
</body>
</html>
