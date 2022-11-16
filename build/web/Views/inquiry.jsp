<%@page import="Model.Request"%>
<%@page import="ControllerHelper.RequestHelper"%>
<%@page import="Model.Sim"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ControllerHelper.SimHelper"%>
<%
    HttpSession sessionCheck = request.getSession();
    int customer_id = 0;
    int agent_id = 0;
    if (null != sessionCheck.getAttribute("user_id")) {
        customer_id = Integer.parseInt(sessionCheck.getAttribute("user_id").toString());
        agent_id = Integer.parseInt(sessionCheck.getAttribute("agent_id").toString());

    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <style>
            body {
                opacity: 0;
            }
            .bg-dark {
                background-color: #313336 !important;
            }
            .chat-messages{
                height: 400px !important;
            }.navbar-nav {
                margin-left: auto !important;
            }
            .navbar-nav li {
                padding: 0 5px;
            }
            .btn-login {
                color: #fff !important;
                background-color: #8dc63f!important;
                border: 0 !important;
                text-align: center !important ;
                border-radius: 0 !important;
                padding: 2px !important;
                padding-right: 2px !important;
                padding-left: 2px !important;
                padding-right: 10px !important;
                padding-left: 10px !important;
                width: 70px !important;
                margin-top: 20px !important;
            }
            .nav-link {
                display: block;
                padding: .5rem 1rem ;
                padding-right: 1rem;
                padding-left: 1rem;
                color: #0d6efd;
                text-decoration: none;
                transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out;
            }

            .width-60{

            }
            .chat-style-fix{
                display: flex;align-items: center;border-radius: 10px !important
            }
            .ml-5{
                margin-left: 10px !important
            }
        </style>
        <title>Inquiry</title>

        <!-- PICK ONE OF THE STYLES BELOW -->
        <!-- <link href="css/modern.css" rel="stylesheet"> -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css" integrity="sha512-f8gN/IhfI+0E9Fc/LKtjVq4ywfhYAVeMGKsECzDUHcFJ5teVwvKTqizm+5a84FINhfrgdvjX8hEJbem2io1iTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- <link href="css/dark.css" rel="stylesheet"> -->
        <!-- <link href="css/light.css" rel="stylesheet"> -->

        <!-- BEGIN SETTINGS -->
        <!-- You can remove this after picking a style -->

        <script src="js/settings.js"></script>
        <!-- END SETTINGS -->
        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-120946860-7"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());
            gtag('config', 'UA-120946860-7');
        </script></head>

    <body>
        <jsp:include page="/include/navbar.jsp"/>

        <!--Use To Validate Session Through Ajax-->
        <input id="customer_id" type="hidden" value="<%=customer_id%>">



        <div class="wrapper">

            <div class="main">

                <main class="content">
                    <div class="container-fluid">
                        <div class="header">
                        </div>
                        <div class="row">
                            <div class="col-2"></div>
                            <div class="col-8 col-lg-8 col-xl-8">
                                <div class="card">

                                    <div class="card-body" style="margin-top: 20px;">

                                        <form action="requestInsert" onsubmit="return Validate()" method="post">
                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <h2 for="inputEmail4">Send A Request</h2>

                                                </div>


                                            </div>

                                            <div class="row">
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputEmail4">Topic</label>
                                                    <input type="text" class="form-control"  id="topic" placeholder="Topic of your inquiry" value="" name="topic" >
                                                </div>
                                                <div class="mb-3 col-md-6">
                                                    <label for="inputState">Mobile Number</label>
                                                    <select id="inputState" class="form-control" name="connection" >
                                                        <%
                                                            if (null != sessionCheck.getAttribute("user_id")) {
                                                                String nic = sessionCheck.getAttribute("nic").toString();
                                                                SimHelper sim = new SimHelper();
                                                                List<Sim> simList = (ArrayList<Sim>) sim.getSimByNic(nic);
                                                                for (Sim simDetails : simList) {%>
                                                        <option value="<%=simDetails.getSimNumber()%>"><%=simDetails.getSimNumber()%></option>




                                                        <%}
                                                            }%>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Description</label>

                                                <textarea class="form-control" id="description" placeholder="Write your inquiry here" rows="2"  name="description" ></textarea>


                                            </div>
                                            <input type="hidden" name="customer_id" value="<%=customer_id%>" >
                                            <input type="hidden" name="agent_id" value="<%=agent_id%>">
                                            <div style="width: 100%;text-align: right" >
                                                <button type="submit" id="create" class="btn btn-primary">Submit</button>

                                            </div>




                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Table start-->
                        <%if (customer_id > 0) {%>
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">Your Requests</h5>
                                </div>
                                <div class="card-body">
                                    <table id="datatables-basic" class="table table-striped" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Topic</th>
                                                <th>Request</th>
                                                <th>Connection</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>

                                        <tbody>


                                            <%
                                                List<Request> requestList = new RequestHelper().getAllRequestByCustomer(customer_id);
                                                for (Request requests : requestList) {%>

                                            <tr id="div<%=requests.getId()%>">
                                                <td><%=requests.getId()%></td>
                                                <td><%=requests.getTitle()%></td>
                                                <td><%=requests.getRequest()%></td>
                                                <td><%=requests.getNumber()%></td>

                                                <td class="table-action">
                                                    <%if (requests.getStatus() == 0) {%>
                                                    <button class="btn btn-primary">Pending</button>
                                                    <%} else if (requests.getStatus() == 10) {%>
                                                    <button class="btn btn-success">Solved</button>
                                                    <%} else if (requests.getStatus() == 20) {%>
                                                    <button class="btn btn-danger">Ignored</button>
                                                    <%}%>
                                                </td>
                                                <td class="table-action">
                                                    <a class="delete-request" status="<%=requests.getStatus()%>" delete-id="<%=requests.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                        <%}%>
                    </div>
                </main>

            </div>

        </div>

        <svg width="0" height="0" style="position:absolute">
        <defs>
    <symbol viewBox="0 0 512 512" id="ion-ios-pulse-strong">
        <path
            d="M448 273.001c-21.27 0-39.296 13.999-45.596 32.999h-38.857l-28.361-85.417a15.999 15.999 0 0 0-15.183-10.956c-.112 0-.224 0-.335.004a15.997 15.997 0 0 0-15.049 11.588l-44.484 155.262-52.353-314.108C206.535 54.893 200.333 48 192 48s-13.693 5.776-15.525 13.135L115.496 306H16v31.999h112c7.348 0 13.75-5.003 15.525-12.134l45.368-182.177 51.324 307.94c1.229 7.377 7.397 11.92 14.864 12.344.308.018.614.028.919.028 7.097 0 13.406-3.701 15.381-10.594l49.744-173.617 15.689 47.252A16.001 16.001 0 0 0 352 337.999h51.108C409.973 355.999 427.477 369 448 369c26.511 0 48-22.492 48-49 0-26.509-21.489-46.999-48-46.999z">
        </path>
    </symbol>
    </defs>
    </svg>
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
    <script>

        function Validate() {

            if ($('#customer_id').val() == 0) {
                swal({
                    title: "Error!",
                    text: "You Need to Login First..!",
                    type: 'error',
                    timer: 1500,
                    showConfirmButton: false

                });
                return false
            } else if (!$('#topic').val() || $('#topic').val().length === 0) {
                swal({
                    title: "Error!",
                    text: "Please enter the topic..!",
                    type: 'error',
                    timer: 1500,
                    showConfirmButton: false

                });
                return false
            } else if (!$('#description').val() || $('#description').val().length === 0) {
                swal({
                    title: "Error!",
                    text: "Please enter description..!",
                    type: 'error',
                    timer: 1500,
                    showConfirmButton: false
                });
                return false
            } else {
                return true
            }

        }

        //AJAX FOR DELETE,LOGOUT
        $(document).ready(function () {

            $(".delete-request").click(function (event) {
                var id = $(this).attr("delete-id");
                var status = $(this).attr("status");
              //Show Error If Request is Pending
                if (status == 0) {
                    swal({
                        title: "Error!",
                        text: "Cannot Delete Pending Requests!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false

                    });
                } else {

                    swal({
                        title: "Are you sure?",
                        text: "You will not be able to recover this Request!",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#ed1c24",
                        confirmButtonText: "Yes, delete it!",
                        closeOnConfirm: false
                    }, function () {

                        $.ajax({
                            url: "deleteRequest",
                            type: "POST",
                            data: {id: id},
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
                                        text: "Your Have Successfully Deleted An Admin",
                                        type: 'success',
                                        timer: 2000,
                                        showConfirmButton: false
                                    });
                                    $('#div' + id).remove();
                                }


                            }
                        });
                    });

                }
            });
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
