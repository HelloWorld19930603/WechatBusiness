<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li class="active">编辑商品信息</li>
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
                                <input type="hidden" id="id" value="${commodity.id}">
                                <input type="hidden" id="img" name="img" value="${commodity.img}">
                                <fieldset title="商品信息">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">商品名称</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" id="name" placeholder="中文名" class="form-control"
                                                   value="${commodity.name}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">商品英文名</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="英文名" class="form-control" id="eName"
                                                   value="${commodity.eName}">
                                        </div>
                                    </div>
                                    <%--<div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">系列</label>
                                        <div class="col-lg-6">
                                            <select class="form-control m-bot15" name="serise" id="serise">
                                                <option value="1"  checked>
                                                    格丽缇
                                                </option>
                                                <option value="2" >
                                                    Utomorrow
                                                </option>
                                                <option value="3" >
                                                    Pslady
                                                </option>
                                            </select>
                                        </div>
                                    </div>--%>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">规格</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="" class="form-control" id="scale"
                                                   value="${commodity.scale}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img id="image" src="${commodity.img}" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label class="col-md-2 control-label ">图片上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file" type="file" name="file"
                                                           style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">浏览</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                </fieldset>
                                <c:if test="${commodity.serise == 1}">
                                    <%@include file="common/editPrice1.jsp" %>
                                </c:if>
                                <c:if test="${commodity.serise == 2}">
                                    <%@include file="common/editPrice2.jsp" %>
                                </c:if>
                                <c:if test="${commodity.serise == 3}">
                                    <%@include file="common/editPrice3.jsp" %>
                                </c:if>
                                <%@include file="common/editCommDetail.jsp" %>
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
<script src="/js/scripts.js"></script>

<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");


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
    var flag = true;
    //方式一 Jquery实现
    function saveCommodity() {

        var id = $("#id").val().trim();
        var name = $("#name").val().trim();
        var eName = $("#eName").val().trim();
        var serise = ${commodity.serise};
        var scale = $("#scale").val().trim();
        var img = $("#img").val().trim();

        var file = document.getElementById("file").files[0];

        var formData = new FormData();
        formData.append('id', id);
        formData.append('name', name);
        formData.append('eName', eName);
        formData.append('serise', serise);
        formData.append('scale', scale);
        formData.append('img', img);
        if (file) {
            formData.append('file', file);
        }

        $.ajax({
            url: "/editCommodity2.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            mimeType: "multipart/form-data",
            success: function (data) {
                if (data == 0) {
                    savePrice();
                    if (flag) {
                        swal('干的漂亮!', '你成功修改了这件商品的所有信息！', 'success');
                    }
                    $("#finished").text("返回");
                    $("#finished").click(function (e) {
                        window.location.href = "/commodity.do";
                    });
                } else {
                    swal('Oh no...', '商品信息修改异常!', 'error');
                }
                console.log(data);
            },
            error: function (data) {
                swal('Oh no...', '发生了一个未知错误！!', 'error');
                console.log(data);
            }
        });
    }

    const TYPE_MAP = [{
        '1': '股东',
        '2': '联创',
        '3': '执行董事',
        '4': '官方',
        '5': '总代理',
        '6': '一级代理',
        '7': '二级代理',
        '8': '特约'
    }, {
        '1': '股东',
        '2': '合伙人',
        '3': '经理',
        '4': '执行董事',
        '5': '官方',
        '6': '总代',
        '7': '体验'
    }, {
        '1': '股东',
        '2': '合伙人',
        '3': '执行董事',
        '4': '官方',
        '5': '总代理',
        '6': '一级代理',
        '7': '体验'
    }];
    function getPrices() {
        var serise = 1;
        var mp = TYPE_MAP[serise - 1];
        var prices = [];
        prices.push($("#0").val());
        for (var key in mp) {
            var p = $("#" + key).val();
            if (p == "" || p == undefined || p == null) {
                p = 0;
            }
            prices.push($("#" + key).val());
        }
        return prices;
    }

    //方式一 Jquery实现
    function savePrice() {

        var commId = ${commodity.id};
        var serise = ${commodity.serise};

        var formData = new FormData();
        formData.append('commId', commId);
        formData.append('serise', serise);
        formData.append('prices', getPrices());
        $.ajax({
            url: "/updatePrice.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            mimeType: "multipart/form-data",
            success: function (data) {
                if (data == 0) {
                    saveCommDetail();
                } else {
                    swal('Oh no...', '价格信息修改异常!', 'error');
                    flag = false;
                }
                console.log(data);
            },
            error: function (data) {
                alert(data);
                console.log(data);
            }
        });
    }

    function saveCommDetail() {
        var commId = ${commodity.id};
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
        if (file2 == null && file3 == null) {
            return;
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
                if (data != 0) {
                    swal('Oh no...', '商品详情上传异常!', 'error');
                    flag = false;
                }
                console.log(data);
            },
            error: function (data) {
                alert('添加失败');
                console.log(data);
            }
        });
    }
    /*=====STEPY WIZARD====*/
    $(function () {
        $('#default').stepy({
            backLabel: '上一步',
            block: true,
            nextLabel: '下一步',
            titleClick: true,
            titleTarget: '.stepy-tab'
        });

    });
    /*=====STEPY WIZARD WITH VALIDATION====*/
</script>