<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">


  <title><%=title%></title>

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

    <link href="css/jquery.stepy.css" rel="stylesheet">
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
    <div class="main-content" >

        <!-- header section start-->
        <%@include file="common/header.jsp" %>
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">

            <ul class="breadcrumb">
                <li>
                    <a href="#">返利</a>
                </li>
                <li class="active">添加返利 </li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-md-12">
                    <div class="square-widget">
                        <div class="widget-container">
                            <div class="stepy-tab">
                            </div>
                            <form id="default" class="form-horizontal" onsubmit="javascript:confirm()">
                                <fieldset title="经销商信息">
                                    <legend>选择经销商</legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">经销商级别:</label>
                                        <div class="col-md-6 col-sm-6">
                                            <select class="form-control m-bot15" name="level" id="level">
                                                <option value="">请选择</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">经销商名称:</label>
                                        <div class="col-lg-6">
                                            <select class="form-control m-bot15" name="name" id="name">
                                                <option value="">请选择</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">经销商账号:</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="loginName" name="loginName" type="text" disabled/>
                                            <input  id="userId" name="userId" type="hidden" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">联系方式:</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="phone" name="phone" type="text" disabled/>
                                        </div>
                                    </div>

                                </fieldset>
                                <fieldset title="返利">
                                    <legend>返利</legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利类别:</label>
                                        <div class="col-md-6 col-sm-6">
                                            <select class="form-control m-bot15" name="type" id="type">
                                                <option value="">请选择</option>
                                                <option value="1">推荐返利</option>
                                                <option value="2">补货返利</option>
                                                <option value="3">其它</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利比例:</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="ratio" name="ratio" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利金额:</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="money" name="money" type="text" />
                                        </div>
                                    </div>

                                </fieldset>
                                <fieldset title="确认提交">
                                    <legend></legend>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                        </div>
                                    </div>
                                </fieldset>

                                <button class="btn btn-info finish" id = 'finished'  type="button">
                                    完成 </button>
                            </form>
                        </div>
                    </div>
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
<script src="js/jquery.validate.min.js"></script>
<script src="/js/jquery.stepy.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>
<!--common scripts for all pages-->
<script src="/js/scripts.js"></script>

</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");

    $(function () {
        var typeSelect = document.querySelector('[name="level"]');

        for(var key in ROLE_MAP[${serise-1}]){
            var option = document.createElement('option');
            option.value = key;
            option.innerText = ROLE_MAP[${serise-1}][key];
            typeSelect.appendChild(option);
        }
        var users;
        
        $("#level").change(function () {
            var roleId = $("#level").val();
            var serise = ${serise};
            $.ajax({
                url: "/getUsersByRole.do",
                type: "post",
                data: "serise=" + serise + "&roleId=" + roleId,
                success: function (data) {
                    var typeSelect2 = document.querySelector('[name="name"]');
                    users = data;
                    for(var key in data){
                        var option = document.createElement('option');
                        option.value = key;
                        option.innerText = data[key].name;
                        typeSelect2.appendChild(option);
                    }
                    console.log(data);
                },
                error: function (data) {
                    console.log(data);
                    alert("失败");
                }
            })
        });

        $("#name").change(function () {
                var key = $("#name").val();
                var u = users[key];
                $("#loginName").val(u.loginName);
                $("#phone").val(u.phone);
                $("#userId").val(u.id);
        })
    })


    //方式一 Jquery实现
    $("#finished").click(function () {
        var serise = ${serise};
        var userId = document.querySelector('[name="userId"]').value;
        var level = document.querySelector('select[name="level"]').value;
        var ratio = document.querySelector('[name="ratio"]').value;
        var type = document.querySelector('[name="type"]').value;
        var money = document.querySelector('[name="money"]').value;
        if (userId=="" || userId==null ) {
            swal({
                type: 'info',
                html: '请选择经销商！'
            });
            return;
        }
        if (type == ''  || ratio == '') {
            swal({
                type: 'info',
                html: '请选择返利信息！'
            });
            return;
        }
        if (!(ratio && !isNaN(ratio) && ratio >= 0)) {
            swal({
                type: 'info',
                html: '请输入数字！'
            });
            return;
        }
        if (!(money && !isNaN(money) && money >= 0)) {
            swal({
                type: 'info',
                html: '请输入合法金额！'
            });
            return;
        }
        $.ajax({
            url: "/addRebate2.do",
            type: "post",
            data: "serise=" + serise + "&ratio=" + ratio + "&userId=" + userId + "&type=" + type + "&level=" + level+ "&money=" + money,
            success: function (data) {
                swal({
                    type: 'success',
                    html: '添加返利成功！'
                });
                console.log(data);
            },
            error: function (data) {
                console.log(data);
                alert("添加失败");
            }
        });
    })

</script>