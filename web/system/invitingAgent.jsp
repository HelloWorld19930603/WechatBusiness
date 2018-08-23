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

  <title>邀请代理</title>

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
    <div class="main-content" >

        <!-- header section start-->
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            <h3>
                邀请代理
            </h3>

        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            填写申请人信息
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="signupForm" method="get" action="">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">邀请人</label>
                                        <div class="col-lg-5">
                                            <input class=" form-control" id="firstname" name="firstname" type="text" value="${invitationName}"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">申请人</label>
                                        <div class="col-lg-5">
                                            <input class=" form-control" id="lastname" name="lastname" type="text" value="${applyName}"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username2" class="control-label col-lg-3">申请系列</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="username2" name="username" type="text" value="${serise}"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username3" class="control-label col-lg-3">申请级别</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="username3" name="username" type="text" value="${level}"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username4" class="control-label col-lg-3">手机号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="username4" name="username" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username5" class="control-label col-lg-3">微信号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="username5" name="username" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username6" class="control-label col-lg-3">身份证号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="username6" name="username" type="text" />
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-10">
                                            <button class="btn btn-primary" type="submit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button class="btn btn-default" type="button">取消</button>
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

        <!--footer section start-->
        <footer>
            2014 &copy; AdminEx by ThemeBucket
        </footer>
        <!--footer section end-->


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
<%--<script src="js/validation-init.js"></script>--%>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");
</script>