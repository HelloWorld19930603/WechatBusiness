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
                <li class="active">添加商品</li>
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
                                <fieldset title="销售属性">
                                    <legend></legend>
                                    <div id="jiage">
                                        <legend></legend>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">股东</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="1"
                                                                                  class="form-control" placeholder="0" value="${price[1]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">合伙人</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="2"
                                                                                  class="form-control" placeholder="0" value="${price[2]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">经理</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="3"
                                                                                  class="form-control" placeholder="0" value="${price[3]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">执行董事</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="4"
                                                                                  class="form-control" placeholder="0" value="${price[4]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">官方</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="5"
                                                                                  class="form-control" placeholder="0" value="${price[5]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">总代</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="6"
                                                                                  class="form-control" placeholder="0" value="${price[6]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">体验</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="7"
                                                                                  class="form-control" placeholder="0" value="${price[7]}">
                                            </div>
                                        </div>
                                        <div class="form-group"><label
                                                class="col-md-2 col-sm-2 control-label">市场价</label>
                                            <div class="col-md-6 col-sm-6"><input type="text" id="0"
                                                                                  class="form-control" placeholder="0" value="${price[0]}">
                                            </div>
                                        </div>
                                    </div>
                                    <button class="btn btn-info finish" id='finished' type="button">
                                        完成
                                    </button>
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
        var serise = 2;
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

    $("#finished").click(function (e) {
        savePrice();
    });
    //方式一 Jquery实现
    function savePrice() {

        var commId = ${commId};
        var serise = ${serise};

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
                if (data) {
                    alert('商品信息修改成功');
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