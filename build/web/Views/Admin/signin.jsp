<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("USER_ID") != null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }%>
<html>
    <head>
        <title>Sign in</title>

        <link href="css/modern.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css" integrity="sha512-f8gN/IhfI+0E9Fc/LKtjVq4ywfhYAVeMGKsECzDUHcFJ5teVwvKTqizm+5a84FINhfrgdvjX8hEJbem2io1iTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <!--img/logo/admin.png-->
    <body class="theme-blue">
        <div class="splash active">
            <div class="splash-icon"></div>
        </div>


        <main class="content">
            <div class="container-fluid">


                <div class="row">
                    <div class="col-md-3 col-xl-2">

                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title mb-0">Sign in type</h5>
                            </div>

                            <div class="list-group list-group-flush" role="tablist">
                                <a class="list-group-item list-group-item-action active" data-bs-toggle="list" href="#admin" role="tab">
                                    Admin
                                </a>

                                <a class="list-group-item list-group-item-action" data-bs-toggle="list" href="#agent" role="tab">
                                    Agent
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-9 col-xl-8">
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="admin" role="tabpanel">

                                <div class="card">
                                    <div class="text-center mt-4">
                                        <h1 class="h2">Admin Sign in</h1>
                                    </div>
                                    <div class="card-body">
                                        <div class="m-sm-4">
                                            <div class="text-center">
                                                <img src="img/logo/logo.png" alt="Linda Miller" class="img-fluid " width="80" height="80" />
                                            </div>
                                            <form action="adminSignin" method="post">
                                                <div class="mb-3">
                                                    <label>Email</label>
                                                    <input class="form-control form-control-lg" type="email" name="email" id="email" placeholder="Enter your email" />
                                                </div>
                                                <div class="mb-3">
                                                    <label>Password</label>
                                                    <input class="form-control form-control-lg" type="password" name="password" id="password" placeholder="Enter your password" />
                                                </div>
                                                <div class="text-center mt-3">
                                                    <button type="submit" id="login-admin" class="btn btn-lg btn-primary">Sign in</button> 
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>






                            <div class="tab-pane fade" id="agent" role="tabpanel">
                                <div class="card">
                                    <div class="text-center mt-4">
                                        <h1 class="h2">Agent Sign in</h1>
                                    </div>
                                    <div class="card-body">
                                        <div class="m-sm-4">
                                            <div class="text-center">
                                                <img src="img/logo/logo.png" alt="Linda Miller" class="img-fluid " width="80" height="80" />
                                            </div>
                                            <form action="agentSignin" method="post">
                                                <div class="mb-3">
                                                    <label>Email</label>
                                                    <input class="form-control form-control-lg" type="email" name="email" id="emailagent" placeholder="Enter your email" />
                                                </div>
                                                <div class="mb-3">
                                                    <label>Password</label>
                                                    <input class="form-control form-control-lg" type="password" name="password" id="passwordagent" placeholder="Enter your password" />
                                                </div>
                                                <div class="text-center mt-3">
                                                    <button type="submit" id="login-agent" class="btn btn-lg btn-primary">Sign in</button> 
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>


                </div>
            </div>
        </main>





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
    <script>
        $(document).ready(function () {
            //Create slider

            $("#login-admin").click(function (event) {
                event.preventDefault();
                ;

                if (!$('#email').val() || $('#email').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Email..!",
                        type: 'error',
                        timer: 2000,
                        showConfirmButton: false
                    });
                } else if (!$('#password').val() || $('#password').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Password..!",
                        type: 'error',
                        timer: 2000,
                        showConfirmButton: false
                    });
                } else {
                    var email = $('#email').val();

                    var pass = $('#password').val()
                    $.ajax({
                        type: "POST",
                        url: "adminSignin",
                        data: {email: email, password: pass},
                        dataType: "json",
                        //if received a response from the server
                        success: function (result) {

                            if (result.status == "fail") {
                                swal({
                                    title: "Error!",
                                    text: "Email or Password Invalid..!",
                                    type: 'error',
                                    timer: 2000,
                                    showConfirmButton: false
                                    
                                });
                            }  else if (result.status == "invalidEmail") {
                                swal({
                                    title: "Error!",
                                    text: "Email is Invalid..!",
                                    type: 'error',
                                    timer: 2000,
                                    showConfirmButton: false

                                });
                            }else {
                                swal({
                                    title: "Success!",
                                    text: "Your Have Successfully Login",
                                    type: 'success',
                                    timer: 2000,
                                    showConfirmButton: false
                                }, function () {
                                    setTimeout(function () {
                                        window.location.replace("indexjsp");
                                    }, 2000);
                                });
                            }


                        }

                    });

                }
            });

        });
    </script>
        <script>
        $(document).ready(function () {
            //Create slider

            $("#login-agent").click(function (event) {
                event.preventDefault();
                ;

                if (!$('#emailagent').val() || $('#emailagent').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter Email.!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else if (!$('#passwordagent').val() || $('#passwordagent').val().length === 0) {
                    swal({
                        title: "Error!",
                        text: "Please enter password..!",
                        type: 'error',
                        timer: 1500,
                        showConfirmButton: false
                    });
                } else {
                    var email = $('#emailagent').val();

                    var pass = $('#passwordagent').val()
                    $.ajax({
                        type: "POST",
                        url: "agentSignin",
                        data: {email: email, password: pass},
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
                            }  else if (result.status == "invalidEmail") {
                                swal({
                                    title: "Error!",
                                    text: "Email is Invalid..!",
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
                                        window.location.replace("indexjsp");
                                    }, 1500);
                                });
                            }


                        }

                    });

                }
            });

        });
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js" integrity="sha512-MqEDqB7me8klOYxXXQlB4LaNf9V9S0+sG1i8LtPOYmHqICuEZ9ZLbyV3qIfADg2UJcLyCm4fawNiFvnYbcBJ1w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</body>
</html>
