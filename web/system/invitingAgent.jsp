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

    <title>邀请代理</title>

    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <style>
        .div1 {
            position: fixed;
            left:40%;
            z-index: 100;
            margin: 0 auto;
            display: none;
            width: 200px;
            height: 200px;
            border: 2px solid rgba(55, 117, 206, 0.8);
            border-radius: 50%;
            text-align: center;
            line-height: 200px;
            font-size: 18px;
            font-family: "微软雅黑";
        }

        .bounceinDown {
            -webkit-animation: bounceinDownAnimate .5s ease .5s infinite;
            animation: bounceinDownAnimate 6s ease .1s infinite;
        }

        @-webkit-keyframes bounceinDownAnimate {
            0% {
                -webkit-transform: translateY(-200px);
            }
            30% {
                -webkit-transform: translateY(350px);
            }
            70% {
                -webkit-transform: translateY(-10px);
            }
            100% {
                -webkit-transform: translateY(0px);
            }
        }
    </style>
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content">

        <!-- header section start-->
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            <h3>
                邀请代理
            </h3>

        </div>
        <!-- page heading end-->
        <div id="success" class="div1"><span style="color: #208fd2">恭喜您申请成功！</span></div>
        <div id="failed" class="div1"><span style="color: #666e73">很抱歉，申请发生异常！</span></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            填写申请人信息
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="signupForm" method="post"
                                      action="/applyAgent.do" enctype="multipart/form-data">
                                    <input type="hidden" id="userId" value="${inviting}">
                                    <input type="hidden" id="serise" value="${serise}">
                                    <input type="hidden" id="level" value="${level}">
                                    <div class="form-group ">
                                        <label for="userName" class="control-label col-lg-3">邀请人</label>
                                        <div class="col-lg-5">
                                            <input class=" form-control"  id="userName" type="text"
                                                   value="${invitationName}" disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="applyName" class="control-label col-lg-3">申请人</label>
                                        <div class="col-lg-5">
                                            <input class=" form-control" id="applyName" name="applyName" type="text"
                                                   value="${applyName}" disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="seriseName" class="control-label col-lg-3">申请系列</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="seriseName" name="seriseName" type="text"
                                                   disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="levelName" class="control-label col-lg-3">申请级别</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="levelName" name="levelName" type="text"
                                                   disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="phone" class="control-label col-lg-3">手机号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="phone" name="phone" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="wxNum" class="control-label col-lg-3">微信号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="wxNum" name="wxNum" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="idNum" class="control-label col-lg-3">身份证号</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="idNum" name="idNum" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="description" class="control-label col-lg-3">备注</label>
                                        <div class="col-lg-5">
                                            <input class="form-control " id="description" name="description" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label span3"></label>
                                        <div class="col-md-5">
                                            <img id="img" src="/images/default.png" width="100px" height="100px">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label ">凭证上传</label>
                                        <div class="col-md-5">
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

                                    <div class="form-group">
                                        <div class="col-lg-offset-4 col-lg-10">
                                            <button class="btn btn-primary" type="button" id="submit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;

                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
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
<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/modernizr.min.js"></script>
<script src="/js/jquery.nicescroll.js"></script>


<%--<script src="js/validation-init.js"></script>--%>

<!--common scripts for all pages-->
<script src="/js/scripts.js"></script>

</body>
</html>
<script type="text/javascript">

    const TYPE_MAP = {
        '1': '格丽缇',
        '2': 'Utomorrow',
        '3': 'Pslady'
    };
    const ROLE_MAP = [{
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

    $(function () {
        $("#seriseName").val(TYPE_MAP[${serise}]);
        $("#levelName").val(ROLE_MAP[${serise}][${level}]);
        $("#submit").click(function () {
            var phone = $("#phone").val().trim();
            if(!isPhoneAvailable(phone)){
                alert("请输入合法的手机号！");
                return;
            }

            var targetUrl = $("#signupForm").attr("action");
            var userId = $("#userId").val().trim();
            var applyName = $("#applyName").val().trim();
            var serise = $("#serise").val().trim();

            var wxNum = $("#wxNum").val().trim();
            var idNum = $("#idNum").val().trim();
            var level = $("#level").val().trim();
            var description = $("#description").val().trim();
            var file = document.getElementById("file").files[0];

            var formData = new FormData();
            formData.append('userId', userId);
            formData.append('applyName', applyName);
            formData.append('serise', serise);
            formData.append('phone', phone);
            formData.append('wxNum', wxNum);
            formData.append('level', level);
            formData.append('description', description);
            if(file){
                formData.append('file', file);
            }else{
                alert("请上传凭证");
                return;
            }

            $.ajax({
                type: 'post',
                url: targetUrl,
                cache: false,
                data: formData,
                contentType: false, //禁止设置请求类型
                processData: false, //禁止jquery对DAta数据的处理,默认会处理
                success: function (data) {
                    $("#success").fadeToggle(3000);
                    $("#success").addClass("bounceinDown");
                    $("#success").fadeToggle(3000);
                    $("#submit").attr('disabled',true);
                },
                error: function () {
                    $("#failed").fadeToggle(3000);
                    $("#failed").addClass("bounceinDown");
                    $("#failed").fadeToggle(3000);
                }
            })
        })
    })


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
    })


    function isPhoneAvailable(str) {
        var myreg=/^[1][0-9]{10}$/;
        if (!myreg.test(str)) {
            return false;
        } else {
            return true;
        }
    }

</script>