<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title><%=title%></title>

    <!--common-->
    <link href="<%=path%>/css/style.css" rel="stylesheet">
    <link href="<%=path%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=path%>/css/gm.css" rel="stylesheet">
    <link href="<%=path%>/css/grid.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.3.5/jquery.fancybox.min.css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/js/html5shiv.js"></script>
    <script src="<%=path%>/js/respond.min.js"></script>
    <![endif]-->
</head>
<style>


</style>
<script>
    const TYPE_MAP = {
        '1': '格丽缇',
        '2': 'Utomorrow',
        '3': 'Pslady'
    };

</script>
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
                <li class="active"> 商品管理</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <section class="search-area panel">

                <div class="form-group">
                    <label class="control-label" for="code">商品追溯码:</label>
                <div class="sa-ele">

                    <input class="form-control" name="code" id="code"/>
                </div>
                <div class="sa-ele">
                    <button class="btn btn-primary search">搜索</button>
                </div>
                </div>
            </section>

            <section class="grid-main" id="comm" style="display:none ;">
                <div class="col-md-7">
                <div class="panel">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="blog-img-sm">
                                    <img src="images/default.png" alt="" id="img">
                                </div>
                            </div>
                            <div class="col-md-7">
                                <h1 class=""><a href="#" id="name">comm name</a></h1>
                                <h3 class=""><a href="#" id="eName">english name</a></h3>
                                <p class=" auth-row">
                                    规格： <a href="#" id="scale">scale</a>   |   价格： <a href="#" id="price">price</a>   |   数量： <a href="#" id="num">num</a>
                                </p>

                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </section>
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
<script src="js/jquery.stepy.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>


<script src="https://csdnimg.cn/public/common/libs/jquery/jquery-1.9.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.3.5/jquery.fancybox.min.js"></script>


<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");

    /**
     * 提供demo中的搜索, 重置
     */
    (function(){

        // 绑定搜索事件
        document.querySelector('.search').addEventListener('click', function () {

            var code = $("#code").val();
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/traceability2.do" ,//url
                data: "code="+code,
                success: function (data) {
                    console.log(data);//打印服务端返回的数据(调试用)
                    if (data == null || data.commName == undefined) {
                        swal({
                            type: 'warning',
                            html: '查询不到此条记录'
                        });
                        $("#comm").css("display","none");
                    }else{
                        $("#comm").css("display","block");
                        $("#name").text(data.commName);
                        $("#eName").text(data.eName);
                        $("#scale").text(data.scale);
                        $("#price").text(data.aPrice);
                        $("#num").text(data.num);
                        $("#img").attr("src",data.img);
                    }
                },
                error : function() {
                    swal({
                        type: 'warning',
                        html: '查询异常'
                    });
                }
            })

        });

    })();



    $("[data-fancybox]").fancybox({
        // Options will go here
        buttons : [
            'zoom',
            'close'
        ]
    });


    $().fancybox({
        selector : '[data-fancybox="images"]',
        loop     : true
    });


</script>