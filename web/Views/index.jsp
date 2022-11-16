<%@page import="ControllerHelper.PackageHelper"%>
<%@page import="java.util.List"%>
<%@page import="Model.Packages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Home</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css" integrity="sha512-f8gN/IhfI+0E9Fc/LKtjVq4ywfhYAVeMGKsECzDUHcFJ5teVwvKTqizm+5a84FINhfrgdvjX8hEJbem2io1iTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>

        <jsp:include page="/include/navbar.jsp"/>


        <jsp:include page="/include/slider.jsp"/>


        <!-- The Modal -->

        <div class="container">

            <div style="padding: 50px 0 70px 0" >
                <div class="help-desk-title" >

                    <h1>We Have Got You Covered</h1>
                </div>
                <div>
                    <h5 class="help-desk-sub-title">Use one of the methods below to get in touch with us.</h5>
                </div>
                <div class="col-md-12">
                    <div class="row">

                        <div class="col-md-4 help-desk-btn" >
                            <a href="Chat" style="text-decoration: none">
                                <div class="p-10">
                                    <div class="row" >
                                        <div class="btn-container">

                                            <div  class="display-aligned">

                                                <img src="img/logo/customer-service.png" height="80"alt=""/>
                                                <div class="title">
                                                    <h3>Contact Agent</h3>
                                                </div>

                                            </div>

                                        </div>
                                    </div>


                                </div>
                            </a>
                        </div>



                        <div class="col-md-4 help-desk-btn" >

                            <a href="inquiry" style="text-decoration: none">
                                <div class="p-10"k>
                                    <div class="row" >
                                        <div class="btn-container">

                                            <div class="display-aligned">

                                                <img src="img/logo/contract.png" height="80"alt=""/>
                                                <div class="title"> 
                                                    <h3>Make An Inquiry</h3>
                                                </div>

                                            </div>

                                        </div>
                                    </div>


                                </div>
                            </a>

                        </div>

                        <div class="col-md-4 help-desk-btn" >
                            <a href="faq" style="text-decoration: none">
                                <div class="p-10">
                                    <div class="row" >
                                        <div class="btn-container">

                                            <div class="display-aligned">

                                                <img src="img/logo/reception.png" height="80"alt=""/>
                                                <div class="title">
                                                    <h3>FAQ</h3>
                                                </div>

                                            </div>

                                        </div>
                                    </div>


                                </div>
                            </a>
                        </div>




                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div style="padding: 20px 20px;background-color: #dcdcdc2b;" >
                <div class="help-desk-title" >

                    <h1>Trending Packages</h1>
                </div>
                <div>
                    <h5 class="help-desk-sub-title">We offer the fastest and economical Packages to the whole Country.</h5>
                </div>
                <div class="col-md-12" style="padding-top: 20px">
                    <div class="row">

                        <%
                            PackageHelper package_helper = new PackageHelper();
                            List<Packages> package_list = package_helper.getAllPackage();
                            int key = 0;
                            for (Packages packages : package_list) {
                                key++;
                                if (key > 4) {
                                    key = 0;
                                    break;
                                }

                        %>
                        <div class="col-md-3">

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

                                        <div class="pkg-data" style="margin-top: 5px" >
                                            <div>
                                                <div class="pkg-validity">
                                                    <label class="card-text">  Validity:<span class="font-size-20"></span> </label>
                                                </div>

                                                <label><Span class="font-size-30"><%=packages.getValidityPeriod()%></Span> Days</label>
                                            </div>

                                            <div class="ml-auto">
                                            </div>

                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>
                        <%}%>
                        <div style="width: 100%;padding-top: 30px">
                            <center>  <a href="packages" class="btn pink-btn">View All</a></center>
                        </div>
                    </div>

                </div>
            </div>

        </div>
        <!-- Footer -->
        <jsp:include page="/include/footer.jsp"/>
        <!-- Footer -->

        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="assets/libs/jquery/jquery.min.js" type="text/javascript"></script>
        <script>


            document.getElementById("login-btn").onclick = function () {
                document.getElementById("login").style.display = "block"
            };
            $(document).ready(function () {

                //Login AJAX

                $("#login-form-btn").click(function (event) {
                    event.preventDefault();
                    ;

                    if (!$('#email').val() || $('#email').val().length === 0) {
                        swal({
                            title: "Error!",
                            text: "Please enter Email..!",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false
                        });
                    } else if (!$('#password').val() || $('#password').val().length === 0) {
                        swal({
                            title: "Error!",
                            text: "Please enter Password..!",
                            type: 'error',
                            timer: 1500,
                            showConfirmButton: false
                        });
                    } else {
                        var email = $('#email').val();

                        var pass = $('#password').val()
                        $.ajax({
                            type: "POST",
                            url: "customerLogin",
                            data: {email :email, password: pass},
                            dataType: "json",
                            //if received a response from the server
                            success: function (result) {

                                if (result.status == "fail") {
                                    swal({
                                        title: "Error!",
                                        text: "Email or Password Invalid..!",
                                        type: 'error',
                                        timer: 1500,
                                        showConfirmButton: false

                                    });
                                } else {
                                    swal({
                                        title: "Success!",
                                        text: "Your Have Successfully Login",
                                        type: 'success',
                                        timer: 2000,
                                        showConfirmButton: false
                                    }, function () {
                                        setTimeout(function () {
                                            window.location.replace("manage_package");
                                        }, 1500);
                                    });
                                }


                            }

                        });

                    }
                });
                
                //Logout AJAX
                
                $("#logout-btn").click(function (event) {


                    swal({
                        title: "Are you sure?",
                        text: "You will not be able to Access Some Features!",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#ed1c24 !important",
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
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js" integrity="sha512-MqEDqB7me8klOYxXXQlB4LaNf9V9S0+sG1i8LtPOYmHqICuEZ9ZLbyV3qIfADg2UJcLyCm4fawNiFvnYbcBJ1w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</html>