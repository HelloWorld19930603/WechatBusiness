<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">
    <link rel="stylesheet" href="/css/snow.css" type="text/css">

    <title>Login</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" action="/toLogin.do" method="post">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">后台管理系统登录</h1>
            <img src="/images/home/login_logo.jpg" alt="" width="144px" height="99px"/>
        </div>
        <div class="login-wrap">
            <input type="text" class="form-control" id="loginName" placeholder="用户名" autofocus>
            <input type="password" class="form-control" id="loginPwd" placeholder="密码">

            <button class="btn btn-lg btn-login btn-block" type="button" id="submit">
                <i class="fa fa-check"></i>
            </button>


            <label class="checkbox">
                <input type="checkbox" value="remember-me"> 记住我
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> </a>

                </span>
            </label>

        </div>

        <!-- Modal -->

        <!-- modal -->

    </form>

</div>

<!--PageEndHtml Block Begin-->
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>
<!--PageEndHtml Block End-->

<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/modernizr.min.js"></script>

</body>
</html>
<script type="text/javascript">

    $(function () {
        $("#submit").click(function () {


            var loginName = $("#loginName").val().trim();
            var loginPwd = $("#loginPwd").val().trim();

            var formData = new FormData();
            formData.append('loginName', loginName);
            formData.append('loginPwd', loginPwd);
            $.ajax({
                url: "/toLogin.do",
                type: "post",
                data: formData,
                contentType: false,
                processData: false,
                mimeType: "multipart/form-data",
                success: function (data) {
                    if (data) {
                        window.location.href = "index.do";
                    } else {
                        alert("用户名/密码错误！");
                    }
                    console.log(data);
                },
                error: function (data) {
                    alert("用户名/密码错误！");
                    console.log(data);
                }
            })
        });
    })

</script>