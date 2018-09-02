<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="main-content">

        <!-- header section start-->
        <%@include file="common/header.jsp" %>
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">

            <ul class="breadcrumb">
                <li>
                    <a href="#">商品</a>
                </li>
                <li class="active">修改商品详情</li>
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
                                <input type="hidden" name="commId" id="commId" value="${commId}">
                                <input type="hidden" name="img1" id="img1" value="${detail1.url}">
                                <input type="hidden" name="img2" id="img2" value="${detail2.url}">
                                <input type="hidden" name="id1" id="id1" value="${detail1.id}">
                                <input type="hidden" name="id2" id="id2" value="${detail2.id}">
                                <fieldset title="商品详情">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <c:if test="${detail1 != null}">
                                                <img  id="img_2"src="${detail1.url}" width="100px" height="100px">
                                            </c:if>
                                            <c:if test="${detail1 == null}">
                                                <img  id="img_2"src="/images/default.png" width="100px" height="100px">
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label ">商品详情上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover2" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file2" type="file" name="file2"
                                                           style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">Browse</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <c:if test="${detail2 != null}">
                                                <img id="img_3" src="${detail2.url}" width="100px" height="100px">
                                            </c:if>
                                            <c:if test="${detail2 == null}">
                                                <img id="img_3" src="/images/default.png" width="100px" height="100px">
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label class="col-md-2 control-label ">商品详情上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover3" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file3" type="file" name="file3"
                                                           style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">Browse</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset title="确认提交">
                                    <legend></legend>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <p>最后一步，请确认提交</p>
                                        </div>
                                    </div>
                                </fieldset>
                                <button class="btn btn-info finish" id='finished' type="button">
                                    完成
                                </button>
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


    //html5实现图片预览功能
    $(function () {

        $("#file2").change(function (e) {
            var file = e.target.files[0] || e.dataTransfer.files[0];
            $('#photoCover2').val(document.getElementById("file2").files[0].name);
            if (file) {
                var reader = new FileReader();
                reader.onload = function () {
                    $("#img_2").attr("src", this.result);
                }

                reader.readAsDataURL(file);
            }
        });
        $("#file3").change(function (e) {
            var file = e.target.files[0] || e.dataTransfer.files[0];
            $('#photoCover3').val(document.getElementById("file3").files[0].name);
            if (file) {
                var reader = new FileReader();
                reader.onload = function () {
                    $("#img_3").attr("src", this.result);
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
        var commId = $("#commId").val();
        var img1 = $("#img1").val();
        var img2 = $("#img2").val();
        var id1 = $("#id1").val();
        var id2 = $("#id2").val();

        var file2 = document.getElementById("file2").files[0];
        var file3 = document.getElementById("file3").files[0];
        var formData = new FormData();
        formData.append('commId', commId);
        if (img1) {
            formData.append('img1', img1);
        }
        if (img2) {
            formData.append('img2', img2);
        }
        if (id1) {
            formData.append('id1', id1);
        }
        if (id2) {
            formData.append('id2', id2);
        }
        if (file2) {
            formData.append('file2', file2);
        }
        if (file3) {
            formData.append('file3', file3);
        }


        $.ajax({
            url: "/editCommDetail2.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            mimeType: "multipart/form-data",
            success: function (data) {
                if (data) {
                    alert('添加成功');
                }
                console.log(data);
            },
            error: function (data) {
                alert('添加失败');
                console.log(data);
            }
        });
    }


</script>