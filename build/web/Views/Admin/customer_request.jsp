<%@page import="ControllerHelper.CustomerHelper"%>
<%@page import="Model.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Request</title>
        <link href="css/modern.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="wrapper">

            <jsp:include page="/include/admin_side_nav.jsp"/>

            <div class="main">

                <jsp:include page="/include/admin_top_nav.jsp"/>

                <main class="content">
                    <div class="container-fluid">


                        <!--Card start-->
                        <%List<Request> requestList = (ArrayList<Request>) request.getAttribute("requestList");
                            for (Request customer_request : requestList) {%>
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">


                                    <div class="row">
                                        <div class="col-md-8">
                                            <h5 style="font-size: 13px"> <%=new CustomerHelper().getCustomerName(customer_request.getCustomer_id())%> ( <%=customer_request.getNumber()%> )</h5>
                                        </div>

                                        <div class="col-md-4" >
                                            <h5 style="font-size: 13px;float: right"><%=customer_request.getDate_time()%></h5>
                                        </div>
                                    </div>


                                    <h5><%=customer_request.getTitle()%></h5>

                                    <p><%=customer_request.getRequest()%></p>

                                     <%String userType = (String) session.getAttribute("USER_TYPE");%>

                                    <%if ("agent".equals(userType) || "admin".equals(userType)) {%>
                                    <a href="fowardRequest?id=<%=customer_request.getId()%>">   <button type="submit" class="btn btn-primary"  style="width: 80px; margin-right: 10px">Foward</button></a>
                                    <%}%>
                                    <a href="confirmRequest?id=<%=customer_request.getId()%>" >   <button type="submit" class="btn btn-success" style="width: 80px; margin-right: 10px">Confirm</button></a>
                                    <a href="rejectRequest?id=<%=customer_request.getId()%>">   <button type="submit" class="btn btn-danger" style="width: 80px; margin-right: 10px">Reject</button></a>



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
