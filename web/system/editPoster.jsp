<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
                    <a href="#">广告</a>
                </li>
                <li class="active">编辑广告 </li>
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
                                <input type="hidden" id="id" value="${poster.id}">
                                <input type="hidden" id="content" name="content" value="${poster.content}">
                                <fieldset title="商品信息">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">商品名称</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" id="name" placeholder="中文名" class="form-control" value="${poster.name}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">所在页面</label>
                                        <div class="col-lg-6">
                                            <select class="form-control m-bot15" name="page" id="page">
                                                <option value="1" <c:if test="${poster.page == 1}">checked</c:if>>首页</option>
                                                <option value="2" <c:if test="${poster.page == 2}">checked</c:if>>物流详情页</option>
                                                <option value="2" <c:if test="${poster.page == 3}">checked</c:if>>商品追溯页</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">类型</label>
                                        <div class="col-lg-6">
                                            <select class="form-control m-bot15" name="type" id="type">
                                                <option value="1" <c:if test="${poster.type == 1}">checked</c:if>>轮播</option>
                                                <option value="2" <c:if test="${poster.type == 2}">checked</c:if>>静态</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">状态</label>
                                        <div class="col-lg-6">
                                        <select class="form-control m-bot15" name="status" id="status">
                                            <option value="1" <c:if test="${poster.status == 1}">checked</c:if>>显示</option>
                                            <option value="2" <c:if test="${poster.status == 2}">checked</c:if>>隐藏</option>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">尺寸</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="" class="form-control" id="scale" value="${poster.size}" disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img  id="image" src="${poster.content}" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label  class="col-md-2 control-label ">图片上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file" type="file" name="file" style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">浏览</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                    <button class="btn btn-info finish" id = 'finished'  type="button">
                                        完成 </button>
                                </fieldset>

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
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");


    /*=====STEPY WIZARD====*/

    /*=====STEPY WIZARD WITH VALIDATION====*/


    //html5实现图片预览功能
    $(function () {
        $("#file").change(function (e) {
            var file = e.target.files[0] || e.dataTransfer.files[0];
            $('#photoCover').val(document.getElementById("file").files[0].name);
            if (file) {
                var reader = new FileReader();
                reader.onload = function () {
                    $("#image").attr("src", this.result);
                }

                reader.readAsDataURL(file);
            }
        });


        $("#finished").click(function (e) {
            saveCommodity();
        });
    })
    //方式一 Jquery实现
    function saveCommodity() {

        var id = $("#id").val().trim();
        var name = $("#name").val().trim();
        var status = $("#status").val().trim();
        var page = $("#page").val().trim();
        var type = $("#type").val().trim();
        var content = $("#content").val().trim();

        var file = document.getElementById("file").files[0];

        var formData = new FormData();
        formData.append('id', id);
        formData.append('name', name);
        formData.append('status', status);
        formData.append('page', page);
        formData.append('type', type);
        formData.append('content', content);
        if(file){
            formData.append('file', file);
        }

        $.ajax({
            url: "/editPoster2.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            mimeType: "multipart/form-data",
            success: function (data) {
                if(data){
                    alert('广告信息修改成功');
                }else{
                    alert('广告信息修改失败');
                }
                console.log(data);
            },
            error: function (data) {
                alert(data);
                console.log(data);
            }
        });
    }


</script>