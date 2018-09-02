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
                    <a href="#">返利</a>
                </li>
                <li class="active"> 返利详情</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <section class="search-area panel">
                <input type="hidden" name="serise" value="1">
                <div class="sa-ele">
                    <label class="se-title">返利名称:</label>
                    <input class="se-con" name="name"/>
                </div>
                <div class="sa-ele">
                    <label class="se-title">系列:</label>
                    <select class="se-con" name="serise">
                        <option value="-1">请选择</option>
                        <!--通过js增加-->
                    </select>
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
    const TYPE_MAP = {
        '1': '格丽缇',
        '2': 'Utomorrow',
        '3': 'Pslady'
    };

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
                return '/getRebateRules.do';
            }
            // ,firstLoading: false // 初始渲染时是否加载数据
            ,ajax_type: 'POST'
            ,supportMenu: true


            // AJAX失败事件函数
            ,ajax_error: function(error){
                console.log('ajax_error');
            }
            ,query: {serise: -1}
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
                    key: 'name',
                    remind: 'the pic',
                    width: '130px',
                    align: 'center',
                    text: '返利名称',
                    template: function(name, rowObject) {

                        return name;
                    }
                },
                {
                    key: 'serise',
                    remind: 'the pic',
                    width: '130px',
                    align: 'center',
                    text: '系列',
                    template: function(serise, rowObject) {

                        return serise;
                    }
                },
                {
                    key: 'roleId',
                    remind: 'the pic',
                    width: '130px',
                    align: 'center',
                    text: '返利等级',
                    template: function(roleId, rowObject) {

                        return roleId;
                    }
                }
                ,
                {
                    key: 'first',
                    remind: 'the pic',
                    width: '130px',
                    align: 'center',
                    text: '一级返利比例',
                    template: function(first, rowObject) {

                        return first;
                    }
                },{
                    key: 'second',
                    remind: 'the title',
                    align: 'center',
                    width: '120px',
                    text: '二级返利比例',
                    sorting: '',
                    template: function(second, rowObject) {

                        return second;
                    }
                },{
                    key: 'description',
                    remind: 'the title',
                    align: 'center',
                    width: '120px',
                    text: '返利说明',
                    sorting: '',
                    template: function(description, rowObject) {

                        return description;
                    }
                },{
                    key: 'action',
                    remind: 'the action',
                    width: '110px',
                    align: 'center',
                    text: '<span style="color: red">操作</span>',
                    template: '<span class="plugin-action" gm-click="editRowData">编辑</span><span class="plugin-action" gm-click="delectRowData">删除</span>'
                }
            ]
            // 排序后事件
            ,sortingAfter: function (data) {
                console.log('sortAfter', data);
            }
        }, function(query){
            // 渲染完成后的回调函数
            console.log('渲染完成后的回调函数:', query);
        });
    }

    // 删除功能
    function delectRowData(rowData){
        // 执行删除操作
        if(window.confirm('确认要删除['+rowData.name+']?')){
            $.ajax({
                url: "/removeRebateRule.do?id=" + rowData.id ,
                type: "get",
                success: function (data) {
                    if(data == 0){
                        alert("删除成功");
                    }
                    console.log(data);
                },
                error: function (data) {
                    alert("删除异常");
                    console.log(data);
                }
            });
        }
    }
    function editRowData(rowData){
        // 执行删除操作
        if(window.confirm('确认要修改['+rowData.name+']?')){

        }
    }

    /**
     * 提供demo中的搜索, 重置
     */
    (function(){
        var typeSelect2 = document.querySelector('.search-area select[name="serise"]');

        for(var key in TYPE_MAP){
            var option = document.createElement('option');
            option.value = key;
            option.innerText = TYPE_MAP[key];
            typeSelect2.appendChild(option);
        }
        // 绑定搜索事件
        document.querySelector('.search-action').addEventListener('click', function () {
            var _query = {
                name: document.querySelector('[name="name"]').value,
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
            document.querySelector('[name="serise"]').value = '-1';
        });

        $("#editable-sample_new").click(function () {
            window.open("/addRebateRule.do");
        })
    })();

    (function(){
        init();
    })();
</script>