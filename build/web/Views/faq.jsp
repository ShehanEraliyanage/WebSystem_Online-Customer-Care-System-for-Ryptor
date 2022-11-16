<%@page import="Model.FAQ"%>
<%@page import="java.util.List"%>
<%@page import="ControllerHelper.FaqHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>FAQ</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .accordion {
                background-color: #eee;
                color: #444;
                cursor: pointer;
                padding: 18px;
                width: 100%;
                text-align: left;
                border: none;
                outline: none;
                transition: 0.4s;
            }

            /* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
            .active, .accordion:hover {
                background-color: #ccc;
            }

            /* Style the accordion panel. Note: hidden by default */
            .panel {
                padding: 0 18px;
                background-color: white;
                display: none;
                overflow: hidden;
            }
            button.accordion.active, button.accordion:hover {
                background-color: #ccc;
            }
            button.accordion::after {
                content: '\002B';
                color: #777;
                font-weight: bold;
                float: right;
                margin-left: 5px;
            }
        </style>
    </head>
    <body>

        <jsp:include page="/include/navbar.jsp"/>





        <!-- The Modal -->


        <div class="container-fluid">
            <div style="padding: 20px 20px;background-color: #dcdcdc2b;" >
                <div class="help-desk-title" >

                    <h1>FAQ</h1>
                </div>
                <div>
                    <h5 class="help-desk-sub-title">Take a look at below Q&A to find out a solution for your matter</h5>
                </div>
                <div class="col-md-12" style="padding-top: 20px">
                    <h5 style="padding: 10px 10px 10px 31px;background-color: #bfbfcd;margin-bottom: 30px;">Frequently Asked Questions and Anwsers</h5>
                    <% List<FAQ> faqList = new FaqHelper().getAllFAQ();
                        for (FAQ faq : faqList) {%>
                    <button class="accordion"><%=faq.getQuestion()%></button>
                    <div class="panel">
                        <p><%=faq.getAnswer()%>; </p>
                    </div>

                    <%}%>
                </div>

            </div>

        </div>
        <!-- Footer -->
        <jsp:include page="/include/footer.jsp"/>
        <!-- Footer -->

        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script>

            var acc = document.getElementsByClassName("accordion");
            var i;

            for (i = 0; i < acc.length; i++) {
                acc[i].addEventListener("click", function () {
                    /* Toggle between adding and removing the "active" class,
                     to highlight the button that controls the panel */
                    this.classList.toggle("active");

                    /* Toggle between hiding and showing the active panel */
                    var panel = this.nextElementSibling;
                    if (panel.style.display === "block") {
                        panel.style.display = "none";
                    } else {
                        panel.style.display = "block";
                    }
                });
            }
            document.getElementById("login-btn").onclick = function () {
                document.getElementById("id01").style.display = "block"
            };
        </script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
</html>