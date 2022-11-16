
<%@page import="ControllerHelper.CommonConstant"%>
<%@page import="Model.Agent"%>
<%@page import="ControllerHelper.AgentHelper"%>
<%@page import="ControllerHelper.AdminHelper"%>
<%@page import="Model.Admin"%>

<%String id = (String) session.getAttribute("USER_ID");%>
<%String userType = (String) session.getAttribute("USER_TYPE");%>
<%Admin admin = null;%>
<%Agent agent = null;%>

<%if ("admin".equals(userType) || "manager".equals(userType)) {%>
<%admin = new AdminHelper().getNameAndImageAdmin(Integer.parseInt(id));%>
<%} else {%>
<%agent = new AgentHelper().getNameAndImageAgent(Integer.parseInt(id));%>
<%}%>

<nav id="sidebar" class="sidebar">
    <a class="sidebar-brand" href="indexjsp">
        <img src="img/logo/logo.png"  alt="Linda Miller" style="max-width: 22px" />
        Ryptor
    </a>
    <div class="sidebar-content">
        <div class="sidebar-user">
            <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                <%if (admin.getImage() == null) {%>
                <img alt="Chris Wood" src="img/defult_avatar.jpg" class="rounded-circle img-responsive mt-2" width="128" height="128">
                    <%if ("1".equals(id)) {%>
                    <div class="fw-bold" style="font-size: 12px;margin-top: 10px"><%= admin.getName()%></div>
                    <small>Admin Manager</small>
                    <%} else {%>  
                    <div class="fw-bold" style="font-size: 12px;margin-top: 10px"><%= admin.getName()%></div>
                    <small>Admin</small>
                    <%}%>
                 <%} else {%>   
                <img alt="Chris Wood" src="<%=CommonConstant.ADMIN_DRI + admin.getImage()%>" class="rounded-circle img-responsive mt-2" width="128" height="128">
                    <%if ("1".equals(id)) {%>
                    <div class="fw-bold" style="font-size: 12px;margin-top: 10px"><%= admin.getName()%></div>
                    <small>Admin Manager</small>
                    <%} else {%>  
                     <div class="fw-bold" style="font-size: 12px;margin-top: 10px"><%= admin.getName()%></div>
                    <small>Admin</small>
                    <%}%>
                <%}%>
            <%} else {%>
                 <%if (agent.getImage() == null) {%>
                 <img alt="Chris Wood" src="img/defult_avatar.jpg" class="rounded-circle img-responsive mt-2" width="128" height="128">
                 <div class="fw-bold" style="font-size: 12px;margin-top: 10px"><%= agent.getName()%></div>
                 <small>Agent</small>
                 <%} else {%>   
                 <img alt="Chris Wood" src="<%=CommonConstant.AGENT_DRI + agent.getImage()%>" class="rounded-circle img-responsive mt-2" width="128" height="128">
                 <div class="fw-bold" style="font-size: 12px;margin-top: 10px"><%= agent.getName()%></div>
                <small>Agent</small>
                <%}%>   
            <%}%>

        </div>

        <ul class="sidebar-nav">
            <li class="sidebar-header">
                Main
            </li>


            <li class="sidebar-item ">
                <a class="sidebar-link" href="indexjsp"> 
                    <i class="align-middle me-2 fas fa-fw fa-home"></i> <span class="align-middle">Dashboards</span>
                </a>

            </li>
            <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
            <li class="sidebar-item ">
                <a data-bs-target="#customer" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-user-friends"></i> <span class="align-middle">Customers</span>
                </a>
                <ul id="customer" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="customerPage">Manage Customer</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="customerRequestPage">Customer request</a></li>
                </ul>
            </li>
            <%} else {%> 
            <li class="sidebar-item ">
                <a data-bs-target="#customer" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-user-friends"></i> <span class="align-middle">Customers</span>
                </a>
                <ul id="customer" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="customerPage">Manage Customer</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="customerRequestPage">Customer request</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="ChatAdmin">Chat</a></li>
                </ul>
            </li>
            <%}%>
            <li class="sidebar-item">
                <a data-bs-target="#sim" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-globe"></i> <span class="align-middle">SIM</span>
                </a>
                <ul id="sim" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="simPage">Manage SIM</a></li>
                </ul>
            </li>
            <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
            <li class="sidebar-item">
                <a data-bs-target="#package" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-cubes"></i> <span class="align-middle">Packages</span>
                </a>
                <ul id="package" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="packagePage">Manage Package</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="packageTypePage">Manage Package Type</a></li>
                </ul>
            </li>
            <%} else {%> 
            <li class="sidebar-item">
                <a data-bs-target="#package" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-cubes"></i> <span class="align-middle">Packages</span>
                </a>
                <ul id="package" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="packagePage">Manage Package</a></li>
                </ul>
            </li>
            <%}%>
            <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
            <li class="sidebar-item">
                <a data-bs-target="#services" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-wrench"></i> <span class="align-middle">Services</span>
                </a>
                <ul id="services" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="servicesPage">Manage Services</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="servicesTypePage">Manage Services Type</a></li>
                </ul>
            </li>
            <%} else {%> 
            <li class="sidebar-item">
                <a data-bs-target="#services" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-wrench"></i> <span class="align-middle">Services</span>
                </a>
                <ul id="services" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="servicesPage">Manage Services</a></li>
                </ul>
            </li>
            <%}%>
            <%if ("manager".equals(userType)) {%>
            <li class="sidebar-item">
                <a data-bs-target="#admin" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-user-cog"></i> <span class="align-middle">Admin</span>
                </a>
                <ul id="admin" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="adminPage">Manage Admin</a></li>
                </ul>
            </li>
            <%}%>
            <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
            <li class="sidebar-item">
                <a data-bs-target="#agent" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-user-cog"></i> <span class="align-middle">Agents</span>
                </a>
                <ul id="agent" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="agentPage">Manage Agent</a></li>
                </ul>
            </li>
            <%}%>
            <%if ("manager".equals(userType)) {%>
            <li class="sidebar-item">
                <a data-bs-target="#branch" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-building"></i> <span class="align-middle">Branch</span>
                </a>
                <ul id="branch" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="branchPage">Manage Branch</a></li>
                </ul>
            </li>
            <%}%>
            <li class="sidebar-item">
                <a data-bs-target="#faq" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-question"></i> <span class="align-middle">FAQ</span>
                </a>
                <ul id="faq" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">
                    <li class="sidebar-item"><a class="sidebar-link" href="faqPage">Manage FAQ</a></li>
                </ul>
            </li>
            <li class="sidebar-item">
                <a data-bs-target="#profile" data-bs-toggle="collapse" class="sidebar-link collapsed">
                    <i class="align-middle me-2 fas fa-fw fa-user"></i> <span class="align-middle">My Profile</span>
                </a>
                <ul id="profile" class="sidebar-dropdown list-unstyled collapse " data-bs-parent="#sidebar">      
                    <%if ("admin".equals(userType) || "manager".equals(userType)) {%>
                    <li class="sidebar-item"><a class="sidebar-link" href="adminProfilePage">Profile Settings</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="adminSignOut">Sign Out</a></li>
                        <%} else {%>
                    <li class="sidebar-item"><a class="sidebar-link" href="agentProfilePage">Profile Settings</a></li>
                    <li class="sidebar-item"><a class="sidebar-link" href="agentSignOut">Sign Out</a></li>
                        <%}%>    
                </ul>
            </li>
        </ul>
    </div>
</nav>