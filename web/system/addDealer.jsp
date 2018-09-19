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
    <%@include file="common/left.jsp" %>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content">

        <!-- header section start-->
        <%@include file="common/header.jsp" %>
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>
                    <a href="#">经销商</a>
                </li>
                <li class="active"> 添加经销商</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            经销商表单
                        </header>
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
                                        <label for="roleId" class="control-label col-lg-3">级别</label>
                                        <div class="col-lg-5">
                                            <select class="form-control m-bot15" name="roleId" id="roleId">
                                                <option value="">请选择</option>
                                                <!--通过js增加-->
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="phone" class="control-label col-lg-3">手机号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="phone" name="phone" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="wxNum" class="control-label col-lg-3">微信号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="wxNum" name="wxNum" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-3">密码</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="password" name="loginPwd" type="password"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="confirm_password" class="control-label col-lg-3">确认密码</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="confirm_password" name="confirm_password"
                                                   type="password"/>
                                        </div>
                                    </div>

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

        <!--footer section start-->
        <%@include file="common/footer.jsp" %>
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
<script src="/js/validation-init.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");

    const TYPE_MAP = {
        '1': '股东',
        '2': '联创',
        '3': '执行董事',
        '4': '官方',
        '5': '总代理',
        '6': '一级代理',
        '7': '二级代理',
        '9': '普通用户'
    };

    (function () {
        // 渲染下拉框
        var typeSelect = document.querySelector('select[name="roleId"]');

        for (var key in TYPE_MAP) {
            var option = document.createElement('option');
            option.value = key;
            option.innerText = TYPE_MAP[key];
            typeSelect.appendChild(option);
        }
        $("#return").click(function () {
            window.history.go(-1);
        });

        $("#submit").click(function () {
            var serise = document.querySelector('[name="serise"]').value;
            var name = document.querySelector('[name="name"]').value;
            var roleId = document.querySelector('select[name="roleId"]').value;
            var phone = document.querySelector('[name="phone"]').value;
            var wxNum = document.querySelector('[name="wxNum"]').value;
            var loginName = document.querySelector('[name="loginName"]').value;
            var loginPwd = document.querySelector('[name="loginPwd"]').value;
            var confirm_password = document.querySelector('[name="confirm_password"]').value;
            if(name==''||name==null||loginName==''||loginName==null){
                swal({
                    type: 'info',
                    html: '请填写完整经销商信息！'
                });
                return;
            }
            if(roleId == ''){
                swal({
                    type: 'info',
                    html: '请选择经销商级别！'
                });
                return;
            }
            if(loginPwd != confirm_password){
                swal({
                    type: 'info',
                    html: '两次输入密码不一致！'
                });
                return;
            }

            $.ajax({
                url: "/addDealer2.do",
                type: "post",
                data: "serise=" + serise + "&loginPwd=" + loginPwd + "&name=" + name + "&loginName=" + loginName + "&phone=" + phone+ "&wxNum=" + wxNum+ "&roleId=" + roleId,
                success: function (data) {
                    if (data == 0) {
                        swal({
                            type: 'success',
                            html: '添加成功！'
                        });
                    } else if (data == 2) {
                        swal({
                            type: 'warning',
                            html: '该用户名已存在！'
                        });
                    } else if (data == 1){
                        swal({
                            type: 'warning',
                            html: '添加失败！'
                        });
                    }
                    console.log(data);
                },
                error: function (data) {
                    console.log(data);
                    swal({
                        type: 'error',
                        html: '添加异常！'
                    });
                }
            });
        });
    })();
</script>