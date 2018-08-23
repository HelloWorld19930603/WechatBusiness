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
                    管理员
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
                <h4><a href="#">管理员</a></h4>
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
<script language="javascript">

    function logout(){
        $.messager.confirm('提示框', '确定退出系统？',function(event){
            if(event){
                window.location.href = "<c:url value='/jsp/login_ypt.jsp' />";
            }
        });
    }

    function modifyPassword(){
        var user_id = $("#user_id").val();
        var path = "<c:url value='/userInfo/toModifyPwd.action?user_id="+user_id+"' />";
        var left1 = (screen.width-700)/2;
        var top1 = (screen.height-400)/2;
        window.open(path, "", "width=600, height=400, left=" + left1.toString() + ", top=" + top1.toString());
    }
</script>