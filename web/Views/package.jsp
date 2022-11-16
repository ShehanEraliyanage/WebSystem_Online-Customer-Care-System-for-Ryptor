<%@page import="ControllerHelper.SimHelper"%>
<%@page import="Model.Sim"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Packages"%>
<%@page import="ControllerHelper.PackageHelper"%>
<%@page import="Model.PackageType"%>
<%@page import="java.util.List"%>
<%@page import="ControllerHelper.PackageTypeHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    HttpSession sessionCheck = request.getSession();

    SimHelper sim = new SimHelper();
%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .btn-success{
                background-color: #4a7499 !important;
            }
        </style>
    </head>
    <body>


        <jsp:include page="/include/navbar.jsp"/>


        <div class="container-fluid">
            <div style="padding: 20px 20px;background-color: #dcdcdc2b;" >
                <div class="help-desk-title" >

                    <h1>Broadband Packages</h1>
                </div>
                <div>
                    <h5 class="help-desk-sub-title">We offer the fastest and economical Packages to the whole Country.</h5>
                </div>
                <%
                    PackageTypeHelper package_type_helper = new PackageTypeHelper();

                    PackageHelper package_helper = new PackageHelper();

                    List<PackageType> package_type_list = package_type_helper.getAllPackageType();
                    for (PackageType packagetypes : package_type_list) {


                %>
                <div class="col-md-12 pt-20">
                    <h5 class="title-section"><%=packagetypes.getName()%>s</h5>

                    <div class="row">

                        <%

                            List<Packages> package_list = package_helper.getAllPackageByType(packagetypes.getId());

                            for (Packages packages : package_list) {


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

                                            <div class="pkg-data" style="margin-top: 5px">
                                            <div>
                                                <div class="pkg-validity">
                                                    <label class="card-text">  Validity:<span class="font-size-20"></span> </label>
                                                </div>

                                                <label><Span class="font-size-30"><%=packages.getValidityPeriod()%></Span> Days</label>
                                            </div>

                                            <div class="ml-auto">
                                                <label class="card-text">   <button  onclick="activate('id0<%=packages.getId()%>')" class="activate-btn btn btn-success">Activate</button></label>
                                            </div>

                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>


                        <div id="id0<%=packages.getId()%>" class="modal">

                            <!-- Modal Content -->
                            <form class="modal-content animate" method="post" action="ActivatePackage">


                                <div class="container">
                                    <%     String modelid = "id0" + packages.getId();
                                        if (null == sessionCheck.getAttribute("user_id")) {
                                    %>
                                    <label for="uname"><b>You Need To Login,In Order to Activate Packages!  </b></label>
                                    <% } else {
                                    %>


                                    <label for="uname"><b>Select Your Connection</b></label>

                                    <select style="padding: 10px;margin: 25px 0 25px 0;" class="input-group" name="simid">
                                        <option value="0">Select Your Sim</option>
                                        <%                                            //Generate Id For The model  

                                            if (null != sessionCheck.getAttribute("user_id")) {
                                                String nic = sessionCheck.getAttribute("nic").toString();

                                                List<Sim> simList = (ArrayList<Sim>) sim.getSimByNic(nic);
                                                for (Sim simDetails : simList) {


                                        %>
                                        <option value="<%=simDetails.getId()%>"><%=simDetails.getSimNumber()%></option>


                                        <%}
                                            }%>
                                    </select>
                                    <input type="hidden" name="packageid" value="<%=packages.getId()%>">
                                    <input type="hidden" name="packageType" value="<%=packages.getPackageType()%>">
                                    <div>
                                        <button class="btn confirmbtn" type="submit">Activate</button>
                                    </div>  
                                    <%}%>
                                </div>

                                <div class="container" style="background-color:#f1f1f1;text-align: right">
                                    <button type="button" onclick="document.getElementById('<%=modelid%>').style.display = 'none'" class="cancelbtn">Cancel</button>

                                </div>
                            </form>
                        </div>     
                        <%}%>


                    </div>

                </div>
                <%     }%>
            </div>


        </div>
        <!-- Footer -->
        <jsp:include page="/include/footer.jsp"/>
        <!-- Footer -->

        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>


                                        document.getElementById("login-btn").onclick = function () {
                                            document.getElementById("login").style.display = "block"
                                        };


        </script>
        <script>
            function activate(para) {

                document.getElementById(para).style.display = "block";
            }
            ;
        </script>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
</html>