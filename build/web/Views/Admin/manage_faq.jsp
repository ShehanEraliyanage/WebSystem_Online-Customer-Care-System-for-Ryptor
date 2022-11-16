
<%@page import="Model.FAQ"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage FAQ</title>
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
                                <%if (request.getAttribute("editFAQ") != null) {%>
                                Edit FAQ
                                <%} else {%>
                                Add New FAQ
                                <%}%>
                            </h1>

                        </div>

                        <!--From start-->
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body" style="margin-top: 20px;">
                                    <%if (request.getAttribute("editFAQ") == null) {%>
                                    <form action="faqInsert" method="post">
                                        <%}%>
                                        <%if (request.getAttribute("editFAQ") != null) {%>
                                        <form action="faqUpdate" method="post">
                                            <%}%>
                                            <%if (request.getAttribute("editFAQ") != null) {%>
                                            <input type="hidden"  name="id" value="${editFAQ.id}" >
                                            <%}%>

                                            <div class="mb-3">
                                                <label class="form-label">Question</label>
                                                <%if (request.getAttribute("editFAQ") != null) {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="question" >${editFAQ.question}</textarea>
                                                <%} else {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="question" ></textarea>
                                                <%}%>
                                            </div>


                                            <div class="mb-3">
                                                <label class="form-label">Answer</label>
                                                <%if (request.getAttribute("editFAQ") != null) {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="answer" >${editFAQ.answer}</textarea>
                                                <%} else {%>
                                                <textarea class="form-control" placeholder="Textarea" rows="2"  name="answer" ></textarea>
                                                <%}%>
                                            </div>

                                            <button type="submit" class="btn btn-primary">Submit</button>

                                        </form>
                                </div>
                            </div>
                        </div>

                        <!--Card start-->
                        <%List<FAQ> faqList = (ArrayList<FAQ>) request.getAttribute("faqList");
                             for (FAQ faq : faqList) {%>
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-11">
                                            <h4 class="tab-title" style="margin-top: 20px"><%=faq.getQuestion()%></h4>
                                            <p><%=faq.getAnswer()%>
                                            </p>
                                        </div>
                                        <div class="col-md-1">
                                            <a href="faqEdit?id=<%=faq.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-pen"></i></i></a>
                                            <a href="faqDelete?id=<%=faq.getId()%>" style="margin-left: 8px"><i class="align-middle fas fa-fw fa-trash"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}%>


                    </div>
                </main>
            </div>
        </div>
        <script src="js/app.js"></script>
    </body>

</html>
