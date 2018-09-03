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
    <!--dashboard calendar-->
    <link href="/css/clndr.css" rel="stylesheet">
    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="/js/morris-chart/morris.css">

    <link rel="stylesheet" type="text/css" media="screen" href="<%=path%>/css/jquery-ui.css" />
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
        '1': '股东',
        '2': '合伙人',
        '3': '经理',
        '4': '执行董事',
        '5': '官方',
        '6': '总代',
        '7': '体验'
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
                    <a href="#">经销商</a>
                </li>
                <li class="active"> Utomorrow</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <section class="search-area panel">
                <input type="hidden" name="serise" value="2">
                <div class="sa-ele">
                    <label class="se-title">经销商名称:</label>
                    <input class="se-con" name="name"/>
                </div>
                <div class="sa-ele">
                    <label class="se-title">手机号:</label>
                    <input class="se-con" name="phone"/>
                </div>
                <div class="sa-ele">
                    <label class="se-title">授权码:</label>
                    <input class="se-con" name="code"/>
                </div>
                <div class="sa-ele">
                    <button class="search-action">搜索</button>
                    <button class="reset-action">重置</button>
                </div>
                <div class="btn-group" style="float:right;">
                    <button id="editable-sample_new" class="btn btn-primary" style="font-size: 12px;padding: 4px 10px;">
                        Add New <i class="fa fa-plus"></i>
                    </button>
                </div>
            </section>

            <section class="grid-main">
                <table></table>
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
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>




<script type="text/javascript" src="<%=path%>/js/gm.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");


    // GridManager 渲染
    var table = document.querySelector('table');
    function init() {
        table.GM({
            supportRemind: true
            ,gridManagerName: 'test'
            ,height: '100%'
            ,supportAjaxPage:true
            ,supportSorting: true
            ,supportCheckbox: false
            ,isCombSorting: false
            ,disableCache: false
            ,checkbox:false
            // ajax_url 将在v2.6.0以上版本废弃，请不要再使用
            // ,ajax_url: 'http://www.lovejavascript.com/blogManager/getBlogList'
            ,ajax_data: function () {
                return '/getUsers.do';
            }
            // ,firstLoading: false // 初始渲染时是否加载数据
            ,ajax_type: 'POST'
            ,supportMenu: true


            // AJAX失败事件函数
            ,ajax_error: function(error){
                console.log('ajax_error');
            }
            ,query: {serise: 2}
            ,dataKey: 'list'  // 注意: 这里是用来测试responseHandler 是否生效; 数据本身返回为data, 而在这里我把数据名模拟为list, 再通过responseHandler去更改
            ,pageSize:10

            // 通过该方法修改全部的请求参数
            ,requestHandler: function(request){
                request.newParams = '这个参数是通过 requestHandler 函数新增的';
                // 更改这个参数后, 将会强制createDate字段使用 降序排序.
                // 'sort_' 通过 配置项 sortKey 进行配置
                // 'DESC' 通过 配置项 sortDownText 进行配置
                //			request.sort_createDate = 'DESC';
                return request;
            }
            // 可以通过该方法修改返回的数据
            ,responseHandler: function(response){

                // 数据本身返回为data, 通过responseHandler更改为与dataKey匹配的值
                response.list = response.data;
                return response;
            }
            ,columnData: [
                {
                    key: 'id',
                    remind: 'the id',
                    width: '80px',
                    align: 'center',
                    text: '授权码',
                    // 使用函数返回 dom node
                    template: function(id, rowObject) {

                        return id;
                    }
                },{
                    key: 'loginName',
                    remind: 'the pic',
                    width: '130px',
                    align: 'center',
                    text: '经销商账号',
                    // 使用函数返回 dom node
                    template: function(loginName, rowObject) {

                        return loginName;
                    }
                },{
                    key: 'name',
                    remind: 'the title',
                    align: 'center',
                    width: '120px',
                    text: '经销商名称',
                    sorting: '',
                    // 使用函数返回 dom node
                    template: function(name, rowObject) {

                        return name;
                    }
                },{
                    key: 'phone',
                    remind: 'the pic',
                    width: '120px',
                    align: 'center',
                    text: '手机号',
                    // 使用函数返回 dom node
                    template: function(phone, rowObject) {
                        return phone;
                    }
                },{
                    key: 'roleId',
                    remind: 'the type',
                    text: '级别',
                    width: '100px',
                    align: 'center',
                    template: function(roleId, rowObject){
                        return TYPE_MAP[roleId];
                    }
                },{
                    key: 'sex',
                    remind: 'the type',
                    text: '性别',
                    width: '50px',
                    align: 'center',
                    template: function(sex, rowObject){
                        return sex;
                    }
                },{
                    key: 'wxNum',
                    remind: 'the type',
                    text: '微信号',
                    width: '120px',
                    align: 'center',
                    template: function(wxNum, rowObject){
                        return wxNum;
                    }
                },{
                    key: 'idNum',
                    remind: 'the type',
                    text: '身份证号',
                    width: '130px',
                    align: 'center',
                    template: function(idNum, rowObject){
                        return idNum;
                    }
                },{
                    key: 'loginTime',
                    remind: 'the createDate',
                    width: '100px',
                    align: 'center',
                    text: '最近登录时间',
                    sorting: 'DESC',
                    // 使用函数返回 htmlString
                    template: function(loginTime, rowObject){
                        if(loginTime == null){
                            return "";
                        }
                        return dateFtt("yyyy-MM-dd hh:mm:ss",new Date(loginTime));
                    }
                },{
                    key: 'status',
                    remind: 'the action',
                    width: '110px',
                    align: 'center',
                    text: '<span style="color: red">操作</span>',
                    // 直接返回 htmlString
                    template: function (status, rowObject) {
                        if (status == 1) {
                            return '<span class="plugin-action" gm-click="closeUser">关闭账号</span>';
                        } else if (status == 0) {
                            return '<span class="plugin-action" gm-click="openUser">开启账号</span>';
                        }
                    }
                }
            ]
            // 排序后事件
            , sortingAfter: function (data) {
                console.log('sortAfter', data);
            }
        }, function (query) {
            // 渲染完成后的回调函数
            console.log('渲染完成后的回调函数:', query);
        });
    }

    function closeUser(rowData) {
        if (window.confirm('确认要关闭账号[' + rowData.loginName + ']?')) {
            $.ajax({
                url: "/updateStatus.do",
                type: "post",
                data: "id=" + rowData.id + "&status=0",
                success: function (data) {
                    if (data == 0) {
                        alert("关闭成功");
                    }
                    console.log(data);
                },
                error: function (data) {
                    console.log(data);
                    alert("开启失败");
                }
            });
        }
    }

    function openUser(rowData) {
        if (window.confirm('确认要开启账号[' + rowData.loginName + ']?')) {
            $.ajax({
                url: "/updateStatus.do",
                type: "post",
                data: "id=" + rowData.id + "&status=1",
                success: function (data) {
                    if (data == 0) {
                        alert("开启成功");
                    }
                    console.log(data);
                },
                error: function (data) {
                    console.log(data);
                    alert("开启失败");
                }
            });
        }
    }

    /**
     * 渲染用户级别
     */


    /**
     * 提供demo中的搜索, 重置
     */
    (function(){

        // 绑定搜索事件
        document.querySelector('.search-action').addEventListener('click', function () {
            var _query = {
                name: document.querySelector('[name="name"]').value,
                phone: document.querySelector('[name="phone"]').value,
                code: document.querySelector('[name="code"]').value,
                serise: document.querySelector('[name="serise"]').value,
                index: 1
            };
            table.GM('setQuery', _query, function(){
                console.log('setQuery执行成功');
            });
        });

        // 绑定重置
        document.querySelector('.reset-action').addEventListener('click', function () {
            document.querySelector('[name="name"]').value = '';
            document.querySelector('[name="phone"]').value = '';
            document.querySelector('[name="code"]').value = '';
        });

        $("#editable-sample_new").click(function () {
            window.location.href =  "/addDealer.do?serise="+document.querySelector('[name="serise"]').value;
        })
    })();

    (function(){
        init();
    })();
</script>