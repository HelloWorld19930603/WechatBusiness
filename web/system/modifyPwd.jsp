<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title><%=title%>
    </title>

    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content">

        <!-- header section start-->
        <!-- header section end-->

        <!-- page heading start-->
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="signupForm">
                                    <input type="hidden" name="serise" value="${serise}">
                                    <div class="form-group ">
                                        <label for="name" class="control-label col-lg-3">经销商名字</label>
                                        <div class="col-lg-5">
                                            <input class=" form-control" id="name" name="name" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="loginName" class="control-label col-lg-3">账号</label>
                                        <div class="col-lg-5">
                                            <input class=" form-control" id="loginName" name="loginName" type="text"/>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label for="phone" class="control-label col-lg-3">手机号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="phone" name="phone" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-3">密码</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="password" name="loginPwd" type="password"/>
                                        </div>
                                    </div>
                                    <%--                                    <div class="form-group ">
                                                                            <label for="confirm_password" class="control-label col-lg-3">确认密码</label>
                                                                            <div class="col-lg-5">
                                                                                <input class="form-control " id="confirm_password" name="confirm_password" type="password" />
                                                                            </div>
                                                                        </div>--%>

                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-10">
                                            <button class="btn btn-primary" type="button" id="submit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button class="btn btn-default" type="button" id="return">返回</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="/js/validation-init.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>
<script type="text/javascript">


    (function () {

        $("#return").click(function () {
            window.history.go(-1);
        });

        $("#submit").click(function () {

            var loginPwd = document.querySelector('[name="loginPwd"]').value;

            $.ajax({
                url: "/toModifyPwd.do",
                type: "post",
                data:  "loginPwd=" + loginPwd,
                success: function (data) {
                    if (data == 1) {
                        alert("添加成功");
                    } else if (data == 2) {
                        alert("用户名已存在")
                    } else {
                        alert("添加失败");
                    }
                    console.log(data);
                },
                error: function (data) {
                    console.log(data);
                    alert("添加失败");
                }
            });
        });
    })();
</script>