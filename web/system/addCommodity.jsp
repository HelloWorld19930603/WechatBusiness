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
                    <a href="#">商品</a>
                </li>
                <li class="active">添加商品 </li>
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
                                <fieldset title="商品信息">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">商品名称</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" id="name" placeholder="中文名" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">商品英文名</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="英文名" class="form-control" id="eName">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">系列</label>
                                        <div class="col-lg-6">
                                        <select class="form-control m-bot15" name="serise" id="serise">
                                            <option value="1">格丽缇</option>
                                            <option value="2">Utomorrow</option>
                                            <option value="3">Pslady</option>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">规格</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="" class="form-control" id="scale">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img  id="img" src="/images/default.png" width="100px" height="100px">
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
                                </fieldset>
                                <fieldset title="销售属性" >
                                    <legend></legend>
                                    <div id="jiage"></div>
                                </fieldset>
                                <fieldset title="商品详情">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img  id="img2" src="/images/default.png" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label  class="col-md-2 control-label ">商品详情上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover2" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file2" type="file" name="file2" style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">浏览</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img  id="img3" src="/images/default.png" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label  class="col-md-2 control-label ">商品详情上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover3" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file3" type="file" name="file3" style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">浏览</span>
                                                </label>
                                            </div>
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
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");


    /*=====STEPY WIZARD====*/
    $(function() {
        $('#default').stepy({
            backLabel: '上一步',
            block: true,
            nextLabel: '下一步',
            titleClick: true,
            titleTarget: '.stepy-tab'
        });


        initRoles();

        $("#serise").change(function () {
            initRoles();
        })
    });
    /*=====STEPY WIZARD WITH VALIDATION====*/

    function  initRoles() {
        var jiage = $('#jiage');
        jiage.html("");
        var html = ' <legend></legend>';
        var serise = $("#serise").val();
        var map = ROLE_MAP[serise-1];

        for(var key in map){
            html += '        <div class="form-group"> <label class="col-md-2 col-sm-2 control-label">'+map[key]+
                '</label><div class="col-md-6 col-sm-6">'+
                '<input type="text"  id="'+key+'" class="form-control" placeholder="0">'+
                '</div></div>';
        }
        html += '        <div class="form-group"> <label class="col-md-2 col-sm-2 control-label">市场价</label><div class="col-md-6 col-sm-6">'+
            '<input type="text"  id="0" class="form-control" placeholder="0"  >'+
            '</div></div>';
        jiage.html(html);
    }

    function getPrices() {
        var serise = $("#serise").val();
        var mp = TYPE_MAP[serise-1];
        var prices = [];
        prices.push($("#0").val());
        for(var key in mp){
            var p = $("#"+key).val();
            if(p == "" || p==undefined||p==null){
                p=0;
            }
            prices.push($("#"+key).val());
        }
        return prices;
    }

    //html5实现图片预览功能
    $(function () {
        $("#file").change(function (e) {
            var file = e.target.files[0] || e.dataTransfer.files[0];
            $('#photoCover').val(document.getElementById("file").files[0].name);
            if (file) {
                var reader = new FileReader();
                reader.onload = function () {
                    $("#img").attr("src", this.result);
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
                    $("#img2").attr("src", this.result);
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
                    $("#img3").attr("src", this.result);
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

        var name = $("#name").val().trim();
        var eName = $("#eName").val().trim();
        var serise = $("#serise").val().trim();
        var scale = $("#scale").val().trim();
        var file = document.getElementById("file").files[0];
        var file2 = document.getElementById("file2").files[0];
        var file3 = document.getElementById("file3").files[0];
        var formData = new FormData();
        formData.append('name', name);
        formData.append('eName', eName);
        formData.append('serise', serise);
        formData.append('scale', scale);
        if(file){
            formData.append('file', file);
        }else{
            alert("请添加商品图片");
            return;
        }
        if(file2){
            formData.append('file2', file2);
        }
        if(file3){
            formData.append('file3', file3);
        }
        formData.append('prices',getPrices());

        $.ajax({
            url: "/addCommodity2.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            mimeType: "multipart/form-data",
            success: function (data) {
                if(data){
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