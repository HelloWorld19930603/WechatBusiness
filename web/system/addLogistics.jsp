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
                    <a href="#">订单</a>
                </li>
                <li class="active">添加物流信息 </li>
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
                            <form id="form1" class="form-horizontal" onsubmit="javascript:confirm()">
                                <fieldset title="物流信息">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">订单编号</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" id="orderId" name="orderId" placeholder="返利名称" class="form-control" value="${orderId}" disabled>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">物流单号</label>
                                        <div class="col-lg-6">
                                            <input type="text" id="no" name="no" placeholder="物流单号" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">物流公司</label>
                                        <div class="col-lg-6">
                                            <select class="form-control m-bot15" name="com" id="com" >
                                                <option value="">请选择</option>
                                            </select>
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


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");

    $(function () {

        $("#finished").click(function (e) {
            saveLogistics();
        });


        $.ajax({
            //几个参数需要注意一下
            type: "get",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/getExpress.do" ,//url
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                var typeSelect = document.querySelector('select[name="com"]');

                for(var i = 0;i<result.length;i++){
                    var option = document.createElement('option');
                    option.value = result[i].com;
                    option.innerText = result[i].name;
                    typeSelect.appendChild(option);
                }
            },
            error : function() {
                alert("异常！");
            }
        });
    })
    //方式一 Jquery实现
    function saveLogistics() {

        var name = $("#com").find("option:selected").text().trim();
        var com =  $("#com").val().trim();
        var no =  $("#no").val().trim();
        if(no == "" || no == null){
            alert("请填写物流单号");
            return;
        }

        if(com == "" || com == null){
            alert("请选择物流公司");
            return;
        }
        var orderId =  $("#orderId").val().trim();


        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/deliverGoods2.do" ,//url
            data: "name="+name+"&com="+com+"&orderId="+orderId+"&no="+no,
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                 alert("添加成功");
            },
            error : function() {
                alert("异常！");
            }
        });
    }


</script>