<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title><%=title%></title>
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
    <div class="main-content" >

        <!-- header section start-->
        <%@include file="common/header.jsp" %>
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>
                    <a href="#">学院</a>
                </li>
                <li class="active"> 添加素材</li>
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
                                <fieldset title="商品详情">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">文章标题</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" id="title" placeholder="title" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img  id="img1" src="/images/default.png" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label  class="col-md-2 control-label ">学院展示图片</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover1" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file1" type="file" name="file1" style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">Browse</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label span3"></label>
                                        <div class="col-md-6">
                                            <img  id="img2" src="/images/default.png" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label  class="col-md-2 control-label ">视频上传</label>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input id="photoCover2" class="form-control" readonly type="text">
                                                <label class="input-group-btn">
                                                    <input id="file2" type="file" name="file2" style="left: -9999px; position: absolute;">
                                                    <span class="btn btn-default">Browse</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="type" class="control-label col-lg-2">类型</label>
                                        <div class="col-lg-6">
                                            <select class="form-control m-bot15" name="type" id="type">
                                                <option value="1">素材</option>
                                                <option value="2">官方素材</option>
                                            </select>
                                        </div>
                                    </div>
                                </fieldset >
                                <fieldset>
                                    <legend></legend>
                                <p>编辑素材内容上传到到服务器</p>
                                <div id="div3">
                                    <p>请编写文本内容</p>
                                </div>
                                </fieldset>
<%--                                <fieldset title="确认提交">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label  class="col-md-1 control-label "></label>
                                        <div class="col-md-11">
                                            <script type="text/plain" id="myEditor" style="width:1000px;height:240px;">
                                                &lt;%&ndash;  <p>这里我可以写一些输入提示</p>&ndash;%&gt;
                                            </script>
                                        </div>
                                    </div>
                                </fieldset>--%>
                                <legend></legend>
                                <button class="btn btn-info finish" id = 'finished' style="float:right;margin-top: 10px;" type="button">
                                    完成 </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">

                    <!--style给定宽度可以影响编辑器的最终宽度-->



                    <div class="clear"></div>
                        <div id="btns">
                     <button class="btn" onclick="clearContent()">清空内容</button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="btn" onclick="getContent()">获得内容</button>&nbsp;


                        <div>
                        <h3 id="focush2"></h3>
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
</script>

<script type="text/javascript">


    function  clearContent() {
        editor2.txt.clear();
    }

    function getContent() {
        alert(editor2.txt.html());
    }



    //html5实现图片预览功能
    $(function () {

        $("#file1").change(function (e) {
            var file = e.target.files[0] || e.dataTransfer.files[0];
            $('#photoCover1').val(document.getElementById("file1").files[0].name);
            if (file) {
                var reader = new FileReader();
                reader.onload = function () {
                    $("#img1").attr("src", this.result);
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

        $("#finished").click(function (e) {
            saveCollege();
        });
    });


    function saveCollege() {

        var title = $("#title").val().trim();
        var type = $("#type").val().trim();
        var content = editor2.txt.html();
        var file1 = document.getElementById("file1").files[0];
        var file2 = document.getElementById("file2").files[0];
        var formData = new FormData();
        formData.append('title', title);
        formData.append('content', content);
        formData.append('type', type);

        if (file1) {
            formData.append('file1', file1);
        }
        if (file2) {
            formData.append('file2', file2);
        }
        $.ajax({
            url: "/addCollege2.do",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            mimeType: "multipart/form-data",
            success: function (data) {
                if (data) {
                    alert('素材添加成功');
                }
                console.log(data);
            },
            error: function (data) {
                alert('素材添加失败');
                console.log(data);
            }
        });
    }
</script>

<script type="text/javascript" src="/js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor

    var editor2 = new E('#div3')
    editor2.customConfig.uploadImgServer = '/imageUp.do';
    editor2.customConfig.uploadFileName = 'upfile';
    editor2.customConfig.uploadImgHooks = {
        // customInsert: function (insertImg, result, editor) {
        //     console.log(JSON.stringify(result))
        //     insertImg(result.data[0])
        // },

        // customInsert: function (insertImg, result, editor) {
        //     console.log(result)
        // }
    }
    // editor2.customConfig.uploadImgParams = {
    //     a: 123,
    //     b: 'vvv'
    // }
    // editor2.customConfig.uploadImgParamsWithUrl = true
    editor2.create()


</script>