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
                    <a href="#">返利</a>
                </li>
                <li class="active">添加返利规则 </li>
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
                                <fieldset title="返利规则信息">
                                    <legend></legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利名称</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" id="name" placeholder="返利名称" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利名称</label>
                                        <div class="col-md-6 col-sm-6">
                                            <select class="form-control m-bot15" name="serise" id="serise">
                                                <option value="1">格丽缇</option>
                                                <option value="2">Utomorrow</option>
                                                <option value="3">Pslady</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利等级</label>
                                        <div class="col-md-6 col-sm-6">
                                            <select class="form-control m-bot15" name="roleId" id="roleId">

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">一级返利比例</label>
                                        <div class="col-lg-6">
                                            <input type="text" id="first" placeholder="一级返利比例" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">二级返利比例</label>
                                        <div class="col-lg-6">
                                            <input type="text" id="second" placeholder="一级返利比例" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">返利描述</label>
                                        <div class="col-lg-6">
                                            <textarea rows="6" class="form-control" id="description"></textarea>
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
    },{
        '1': '股东',
        '2': '合伙人',
        '3': '经理',
        '4': '执行董事',
        '5': '官方',
        '6': '总代',
        '7': '体验'
    },{
        '1': '股东',
        '2': '合伙人',
        '3': '执行董事',
        '4': '官方',
        '5': '总代理',
        '6': '一级代理',
        '7': '体验'
    }];
    //html5实现图片预览功能
    $(function () {
        initRoles(1);
        $("#serise").change(function () {
            initRoles($("#serise").val());
        })

        $("#finished").click(function (e) {
            saveRebateRule();
        });
    })

    function  initRoles(serise) {
        var roleId = $('#roleId');
        roleId.html("");
        var html = ' <legend></legend>';
        var map = TYPE_MAP[serise-1];
        for(var key in map) {
            html += '<option value="' + key + '">'+map[key]+'</option>  ';
        }
        roleId.html(html);
    }
    //方式一 Jquery实现
    function saveRebateRule() {

        var name = $("#name").val().trim();
        var serise = $("#serise").val().trim();
        var second = $("#second").val().trim();
        var first = $("#first").val().trim();
        var roleId = $("#roleId").val().trim();
        var description = $("#description").val().trim();

        var formData = new FormData();
        formData.append('name', name);
        formData.append('serise', serise);
        formData.append('second', second);
        formData.append('first', first);
        formData.append('roleId', roleId);
        formData.append('description', description);


        $.ajax({
            url: "/addRebateRule2.do",
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