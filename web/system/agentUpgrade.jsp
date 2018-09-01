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
    const STATUS_MAP = {
        '1': '待审核',
        '2': '审核通过',
        '3': '审核未通过'
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
                    <a href="#">审核</a>
                </li>
                <li class="active"> 充值审核</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <section class="search-area panel">
                <div class="sa-ele">
                    <label class="se-title">系列:</label>
                    <select class="se-con" name="serise">
                        <option value="-1">请选择</option>
                        <!--通过js增加-->
                    </select>
                </div>
                <div class="sa-ele">
                    <label class="se-title">经销商授权码:</label>
                    <input class="se-con" name="id"/>
                </div>
                <div class="sa-ele">
                    <label class="se-title">审核状态:</label>
                    <select class="se-con" name="status">
                        <option value="1">待审核</option>
                        <option value="2">审核通过</option>
                        <option value="3">审核未通过</option>
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
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery.stepy.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>


<script src="https://csdnimg.cn/public/common/libs/jquery/jquery-1.9.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.3.5/jquery.fancybox.min.js"></script>

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
                return '/getRechargeAudits.do';
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
                    key: 'id',
                    remind: 'the pic',
                    text: '编号',
                    isShow: false
                }, {
                    key: 'voucher',
                    remind: 'the pic',
                    width: '110px',
                    align: 'center',
                    text: '缩略图',
                    // 使用函数返回 dom node
                    template: function(voucher, rowObject) {
                        var picNode= '<a href="'+voucher+'" data-fancybox data-caption="My caption">'+
                        '<img src="'+voucher+'" width="100px" height="68px" alt="" />'
                            +'</a>';
                        return picNode;
                    }
                },
                {
                    key: 'userId',
                    remind: 'the pic',
                    width: '120px',
                    align: 'center',
                    text: '经销商授权码',
                    // 使用函数返回 dom node
                    template: function(userId, rowObject) {

                        return userId;
                    }
                },{
                    key: 'money',
                    remind: 'the title',
                    align: 'center',
                    width: '120px',
                    text: '充值金额',
                    sorting: '',
                    // 使用函数返回 dom node
                    template: function(money, rowObject) {

                        return money;
                    }
                },{
                    key: 'serise',
                    remind: 'the type',
                    text: '系列',
                    width: '100px',
                    align: 'center',
                    template: function(serise, rowObject){
                        return TYPE_MAP[serise];
                    }
                },{
                    key: 'status',
                    remind: 'the type',
                    text: '审核状态',
                    width: '100px',
                    align: 'center',
                    template: function(status, rowObject){
                        return STATUS_MAP[status];
                    }
                },{
                    key: 'action',
                    remind: 'the action',
                    width: '110px',
                    align: 'center',
                    text: '<span style="color: red">操作</span>',
                    // 直接返回 htmlString
                    template: '<span class="plugin-action" gm-click="editRowData">通过</span><span class="plugin-action" gm-click="editRowData2">拒绝</span>'
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
    function editRowData(rowData) {
        // 执行删除操作
        if (window.confirm('确认要通过授权码为[' + rowData.userId + ']的用户的充值审核?')) {
            $.ajax({
                url: "/decideRecharge.do?id=" + rowData.id + "&status=2",
                type: "get",
                success: function (data) {
                    if (data) {
                       alert("通过成功");
                      console.log(data);
                    }else{
                        alert("审核异常");
                        console.log(data);
                    }
                },
                error: function (data) {
                    alert("审核异常");
                    console.log(data);
                }
            });
        }
    }

    function editRowData2(rowData) {
        // 执行删除操作
        if (window.confirm('确认要拒绝授权码为[' + rowData.userId + ']的用户的充值审核?')) {
            $.ajax({
                url: "/decideRecharge.do?id=" + rowData.id + "&status=3",
                type: "get",
                success: function (data) {
                    alert("拒绝成功");
                    console.log(data);
                },
                error: function (data) {
                    alert("审核异常");
                    console.log(data);
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
                id: document.querySelector('[name="id"]').value,
                status: document.querySelector('[name="status"]').value,
                serise: document.querySelector('[name="serise"]').value,
                index: 1
            };
            table.GM('setQuery', _query, function(){
                console.log('setQuery执行成功');
            });
        });

        // 绑定重置
        document.querySelector('.reset-action').addEventListener('click', function () {
            document.querySelector('[id="id"]').value = '';
            document.querySelector('select[name="serise"]').value = '-1';
            document.querySelector('select[name="status"]').value = '1';
        });

        $("#editable-sample_new").click(function () {
            window.open("/addCommodity.do");
        })
    })();

    (function(){
        init();
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


    //  $.fancybox.open('<div class="message"><h2>Hello!</h2><p>You are awesome!</p></div>');
</script>