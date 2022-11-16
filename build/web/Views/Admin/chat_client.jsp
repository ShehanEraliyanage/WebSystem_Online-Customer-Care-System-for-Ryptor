<%@page import="java.io.PrintWriter"%>
<%@page import="Model.Chat"%>
<%@page import="Model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="ControllerHelper.ChatHelper"%>
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
            .wrapper::before {
                background: #e4e4e4 !important;
                height: 100% !important;
                position: absolute;

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
        <title>Chat</title>

        <!-- PICK ONE OF THE STYLES BELOW -->
        <!-- <link href="css/modern.css" rel="stylesheet"> -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/" rel="stylesheet">
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

        <div class="wrapper">

            <div class="main">

                <main class="content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-2"></div>
                            <div class="col-8 col-lg-8 col-xl-8">
                                <div class="card">
                                    <div class="py-2 px-4 border-bottom d-none d-lg-block" style="background-color: #3b7ddd;">
                                        <div class="d-flex align-items-center py-1">
                                            <div class="position-relative">
                                                <img src="img/avatars/avatar-6.jpg" class="rounded-circle me-1" alt="Kathie Burton" width="40" height="40">
                                            </div>
                                            <div class="flex-grow-1 ps-3">
                                                <strong style="color: #fff">Agent</strong>
                                                <div style="color: #fff"class=" small"><em>Online</em></div>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="position-relative">
                                        <div class="chat-messages p-4" id="chat-messagesssss">
                                            <%
                                                ChatHelper chat = new ChatHelper();
                                                List<Chat> chatList = chat.getMessagesByCustomer(customer_id);
                                                if (chatList.size() == 0) {
                                            %>
                                            <div class="chat-message-left pb-4">
                                                <div>
                                                    <img src="img/avatars/avatar-6.jpg" class="rounded-circle me-1" alt="Chris Wood" width="40" height="40">
                                                    <div class="text-muted small text-nowrap mt-2">2:33 am</div>
                                                </div>
                                                <div class="flex-shrink-1 bg-light rounded py-2 px-3 me-3 ml-5 chat-style-fix width-60" >
                                                    <div > Hi...!Tell Me How can i help you!i will fix it up For You!</div>
                                                </div>
                                            </div>

                                            <%}%>
                                        </div>
                                    </div>

                                    <div class="flex-grow-0 py-3 px-4 border-top">
                                        <div class="input-group">
                                            <input type="hidden" id="customer_id" value="<%=customer_id%>">
                                            <input type="hidden" id="agent_random_id" value="<%=agent_id%>">
                                            <input type="hidden" id="send_by" value="0">
                                            <input type="text" id="message_chat" class="form-control" placeholder="Type your message">
                                            <button class="btn btn-primary" onclick="sendMsg()">Send</button>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

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

    <script>
                                                // Chat

    </script>
    <script src="assets/libs/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js" integrity="sha512-MqEDqB7me8klOYxXXQlB4LaNf9V9S0+sG1i8LtPOYmHqICuEZ9ZLbyV3qIfADg2UJcLyCm4fawNiFvnYbcBJ1w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <script>
                                                //Append Chat 

//Convert    
                                                function msToTime(duration) {
                                                    var milliseconds = parseInt((duration % 1000) / 100),
                                                            seconds = Math.floor((duration / 1000) % 60),
                                                            minutes = Math.floor((duration / (1000 * 60)) % 60),
                                                            hours = Math.floor((duration / (1000 * 60 * 60)) % 24),
                                                            days = (duration / (1000 * 60 * 60 * 24)).toFixed(0);

                                                    console.log(days);
                                                    if (days >= 1) {
                                                        if (days == 1) {
                                                            return days + "d ago";
                                                        } else {
                                                            return days + "d ago";
                                                        }
                                                    } else if (hours > 0 && days == 0) {
                                                        return hours + "h ago";
                                                    } else if (hours == 0 && minutes > 0) {

                                                        return minutes + "m ago";
                                                    } else if (minutes == 0) {

                                                        return  "just now";
                                                    }
                                                }


                                                $(document).ready(function () {
                                                    //Append Data With 1 Second Repeatedly
                                                    setInterval(function () {

                                                        //get the form data using input fields
                                                        var customer_id = $("#customer_id").val();
                                                        $(".help-desk-title").empty();
                                                        $.ajax({
                                                            type: "POST",
                                                            url: "getMessage",
                                                            data: {customer_id: customer_id},
                                                            dataType: "json",
                                                            //if received a response from the server
                                                            success: function (response) {
                                                                //our country code was correct so we have some information to display
                                                                if (response) {
                                                                    var html = ""
                                                                    $.each(response, function (key, value) {

                                                                        var date;
                                                                        var today = new Date();
                                                                        var date = new Date(value['sent_time']);
                                                                        var min = today.getTime() - date.getTime();
                                                                        var time = (msToTime(min));
                                                                        if (value['send_by'] === 0) {


                                                                            html += "<div class='chat-message-right pb-4'>"
                                                                            html += "<div>"
                                                                            html += "<img src='img/avatars/avatar-3.jpg' class='rounded-circle me-1' alt='Chris Wood' width='40' height='40'>"
                                                                            html += "<div class='text-muted small text-nowrap mt-2'>" + time + "</div>"
                                                                            html += "</div>"
                                                                            html += "<div class='flex-shrink-1 bg-light rounded py-2 px-3 me-3 ml-5 chat-style-fix width-60'>"
                                                                            html += "<div >"
                                                                            html += value['message']
                                                                            html += "</div>"
                                                                            html += "</div>"
                                                                            html += "</div>"

                                                                        } else {

                                                                            html += "<div class='chat-message-left pb-4'>"
                                                                            html += "<div>"
                                                                            html += "<img src='img/avatars/avatar.jpg' class='rounded-circle me-1' alt='Chris Wood' width='40' height='40'>"
                                                                            html += "<div class='text-muted small text-nowrap mt-2'>" + time + "</div>"
                                                                            html += "</div>"
                                                                            html += "<div class='flex-shrink-1 bg-light rounded py-2 px-3 me-3 ml-5 chat-style-fix width-60'>"
                                                                            html += "<div >"
                                                                            html += value['message']
                                                                            html += "</div>"
                                                                            html += "</div>"
                                                                            html += "</div>"


                                                                        }

                                                                        $("#chat-messagesssss").empty();
                                                                        $("#chat-messagesssss").append(html);
                                                                    });
                                                                }
                                                                ;
                                                            }

                                                        });
                                                    }, 1000);
                                                });


    </script>

    <script>
        //Send Message AJAX
        function sendMsg() {

            //get the form data using another method 
            var customer_id = $("#customer_id").val();
            var agent_id = $("#agent_random_id").val();
            var message = $("#message_chat").val();
            var send_by = $("#send_by").val();
            $("#message_chat").val('');

            if (customer_id == 0) {
                swal({
                    title: "Error!",
                    text: "You need to Login To Sent Messages!",
                    type: 'error',
                    timer: 2000,
                    showConfirmButton: false
                });

            } else {
                $.ajax({
                    type: "POST",
                    url: "sendMessage",
                    data: {customer_id: customer_id, agent_id: agent_id, message: message, send_by: send_by},
                    dataType: "json",
                    //if received a response from the server
                    success: function (result) {
                        if (result.status == "fail") {
                            swal({
                                title: "Error!",
                                text: "Message Was Not Sent..!",
                                type: 'error',
                                timer: 1500,
                                showConfirmButton: false

                            });
                        }

                    }

                });
            }

        }
    </script>
</body>
</html>
