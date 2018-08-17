<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="header-section">

    <!--toggle button start-->
    <a class="toggle-btn"><i class="fa fa-bars"></i></a>
    <!--toggle button end-->

    <!--search start-->

    <!--search end-->

    <!--notification menu start -->
    <div class="menu-right">
        <ul class="notification-menu">
            <li>
                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <img src="<%=path%>/images/photos/user-avatar.png" alt="" />
                    John Doe
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                    <li><a href="#"><i class="fa fa-user"></i>  Profile</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i>  Settings</a></li>
                    <li><a href="#"><i class="fa fa-sign-out"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!--notification menu end -->
    <!-- visible to small devices only -->
    <div class="visible-xs hidden-sm hidden-md hidden-lg">
        <div class="media logged-user">
            <img alt="" src="<%=path%>/images/photos/user-avatar.png" class="media-object">
            <div class="media-body">
                <h4><a href="#">John Doe</a></h4>
                <span>"Hello There..."</span>
            </div>
        </div>

        <h5 class="left-nav-title">Account Information</h5>
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
            <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
            <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
        </ul>
    </div>
</div>
