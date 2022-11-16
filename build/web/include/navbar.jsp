
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #212529 !important;z-index: 10000;">
    <div class="container-fluid">

        <img src="img/logo/logo.png" alt="Linda Miller" style="max-width: 22px">


        <a class="navbar-brand" href="#">Ryptor</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="packages">Package</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="faq">FAQ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="inquiry">Inquiry</a>
                </li>
                <li class="nav-item">
                    <%
                        HttpSession sessionCheckHeader = request.getSession();
                        if (null != sessionCheckHeader.getAttribute("user_id")) {
                            out.println("<a  class='nav-link ' href='manage_package'>Dashboard</a>");
                        }
                    %>
                </li>

                <li class="nav-item">
                    <%
             
                        if (null == sessionCheckHeader.getAttribute("user_id")) {
                            out.println("<a id='login-btn' class='nav-link btn btn-login' href='#'>login</a>");
                        } else {
                            out.println("<a id='logout-btn' class='nav-link btn btn-login'>logout </a>");
                        
                        }
                    %>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div id="login" class="modal">
 

    <!-- Modal Content -->
    <form class="modal-content animate" method="post" action="customerLogin">
        <div class="imgcontainer">
            <h5>Customer Login </h5>
        </div>

        <div class="container">
            <label for="uname"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" id="email" name="email"  required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" id="password" name="password"  required>

            <button id="login-form-btn" type="submit">Login</button>
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="document.getElementById('login').style.display = 'none'" class="cancelbtn">Cancel</button>
            <span class="psw"><a href="#">Forgot Password?</a></span>

        </div>
    </form>
</div>