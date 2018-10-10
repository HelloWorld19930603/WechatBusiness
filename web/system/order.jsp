<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title><%=title%>
    </title>

    <!--common-->
    <link href="<%=path%>/css/style.css" rel="stylesheet">
    <link href="<%=path%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=path%>/css/gm.css" rel="stylesheet">
    <link href="<%=path%>/css/grid.css" rel="stylesheet">
    <link rel="stylesheet" href="css/datepicker.css">

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
                    <a href="#">订单</a>
                </li>
                <li class="active"> 订单管理</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <section class="search-area panel">
                <div class="sa-ele">
                    <label class="se-title">订单状态:</label>
                    <select class="se-con" name="status">
                        <option value="">请选择</option>
                        <!--通过js增加-->
                    </select>
                </div>
                <div class="sa-ele">
                    <label class="se-title">订单编号:</label>
                    <input class="se-con" name="orderId"/>
                </div>
                <div class="sa-ele">
                <label class="se-title">收货人姓名:</label>
                <input class="se-con" name="name"/>
            </div>
                <div class="sa-ele">
                    <label class="se-title">收货人电话:</label>
                    <input class="se-con" name="phone"/>
                </div>
                <div class="sa-ele">
                    <button class="search-action">搜索</button>
                    <button class="reset-action">重置</button>
                </div>
                <div class="btn-group" style="float:right;">
                    <button id="share" class="btn btn-primary" style="font-size: 12px;padding: 4px 4px;">
                        导出 <i class="fa fa-share-square-o"></i>
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

<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>

<script type="text/javascript" src="<%=path%>/js/gm.js"></script>

<script src="js/date/moment.min.js"></script>
<script src="js/date/datepicker.all.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");


    const TYPE_MAP = {
        '1': '未付款',
        '2': '已付款',
        '3': '已付款已发货',
        '4': '已完成',
        '5': '已退款'
    };
    const TYPE_MAP2 = {
        '1': '格丽缇',
        '2': 'Utomorrow',
        '3': 'Pslady'
    };
    // GridManager 渲染
    var table = document.querySelector('table');
    function init() {
        table.GM({
            supportRemind: true
            , gridManagerName: 'test'
            , height: '100%'
            , supportAjaxPage: true
            , supportSorting: true
            , supportCheckbox: false
            , isCombSorting: false
            , disableCache: false
            , checkbox: false
            // ajax_url 将在v2.6.0以上版本废弃，请不要再使用
            // ,ajax_url: 'http://www.lovejavascript.com/blogManager/getBlogList'
            , ajax_data: function () {
                return '/getOrders.do';
            }
            // ,firstLoading: false // 初始渲染时是否加载数据
            , ajax_type: 'POST'
            , supportMenu: true


            // AJAX失败事件函数
            , ajax_error: function (error) {
                console.log('ajax_error');
            }
            , query: {serise: 1}
            , dataKey: 'list'  // 注意: 这里是用来测试responseHandler 是否生效; 数据本身返回为data, 而在这里我把数据名模拟为list, 再通过responseHandler去更改
            , pageSize: 10

            // 通过该方法修改全部的请求参数
            , requestHandler: function (request) {
                request.newParams = '这个参数是通过 requestHandler 函数新增的';
                // 更改这个参数后, 将会强制createDate字段使用 降序排序.
                // 'sort_' 通过 配置项 sortKey 进行配置
                // 'DESC' 通过 配置项 sortDownText 进行配置
                //			request.sort_createDate = 'DESC';
                return request;
            }
            // 可以通过该方法修改返回的数据
            , responseHandler: function (response) {

                // 数据本身返回为data, 通过responseHandler更改为与dataKey匹配的值
                response.list = response.data;
                return response;
            }
            , columnData: [
                {
                    key: 'id',
                    remind: 'the info',
                    text: '订单编号',
                    isShow: true,
                    width: '100px',
                    align: 'center'
                },
                {
                    key: 'addrName',
                    remind: 'the pic',
                    width: '110px',
                    align: 'center',
                    text: '购买人姓名',
                    // 使用函数返回 dom node
                    template: function (addrName, rowObject) {

                        return addrName;
                    }
                }, {
                    key: 'phone',
                    remind: 'the title',
                    align: 'center',
                    width: '110px',
                    text: '购买人电话',
                    sorting: '',
                    // 使用函数返回 dom node
                    template: function (phone, rowObject) {

                        return phone;
                    }
                },{
                    key: 'totals',
                    remind: 'the title',
                    align: 'center',
                    width: '100px',
                    text: '总金额',
                    sorting: '',
                    // 使用函数返回 dom node
                    template: function (totals, rowObject) {

                        return totals;
                    }
                }, {
                    key: 'serise',
                    remind: 'the type',
                    text: '系列',
                    width: '80px',
                    align: 'center',
                    template: function (serise, rowObject) {
                        return TYPE_MAP2[serise];
                    }
                }, {
                    key: 'status',
                    remind: 'the type',
                    text: '订单状态',
                    width: '80px',
                    align: 'center',
                    template: function (status, rowObject) {
                        return TYPE_MAP[status];
                    }
                }, {
                    key: 'time',
                    remind: 'the createDate',
                    width: '100px',
                    align: 'center',
                    text: '提交时间',
                    sorting: 'DESC',
                    // 使用函数返回 htmlString
                    template: function (time, rowObject) {
                        return dateFtt("yyyy-MM-dd hh:mm:ss",new Date(time));
                    }
                }, {
                    key: 'action',
                    remind: 'the action',
                    width: '120px',
                    align: 'center',
                    text: '<span style="color: red">操作</span>',
                    // 直接返回 htmlString
                    template: function (action, rowObject) {
                        var option = '';
                        if (rowObject.no != null) {
                            option += '<span class="plugin-action" onclick="getLogistics(\'' + rowObject.com+'\',\''+rowObject.no + '\');">查看物流</span>';
                        }
                        option += '<span class="plugin-action" onclick="editOrder(\'' + rowObject.id + '\');">订单详情</span>';
                        return option;
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


    function receivingAddress(orderId) {
        window.open("/receivingAddress.do?addrId=" + orderId);
    }

    function deliverGoods(orderId) {
        window.open("/deliverGoods.do?orderId=" + orderId);
    }

    function getLogistics(com,no) {
        window.open("/getLogistics.do?com=" + com+"&no="+no);
    }

    function editOrder(orderId) {
        window.open("/editOrder.do?orderId=" + orderId);
    }

    /**
     * 渲染用户级别
     */


    /**
     * 提供demo中的搜索, 重置
     */
    (function () {

        var typeSelect2 = document.querySelector('.search-area select[name="status"]');

        for (var key in TYPE_MAP) {
            var option = document.createElement('option');
            option.value = key;
            option.innerText = TYPE_MAP[key];
            typeSelect2.appendChild(option);
        }

        // 绑定搜索事件
        document.querySelector('.search-action').addEventListener('click', function () {
            var _query = {
                name: document.querySelector('[name="name"]').value,
                status: document.querySelector('[name="status"]').value,
                phone: document.querySelector('[name="phone"]').value,
                orderId: document.querySelector('[name="orderId"]').value,
                index: 1
            };
            table.GM('setQuery', _query, function () {
                console.log('setQuery执行成功');
            });
        });

        // 绑定重置
        document.querySelector('.reset-action').addEventListener('click', function () {
            document.querySelector('[name="name"]').value = '';
            document.querySelector('select[name="status"]').value = '-1';
        });

        $("#share").click(function () {
            initDatepicker();
            swal({
                title: '请选择要导出的时间段',
                showCancelButton: true,
                animation: "slide-from-top",
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                html: '<div class="mt40" onload="initDatepicker()">'+
                '<div class="c-datepicker-date-editor  J-datepicker-range-day mt10">'+
                '<i class="c-datepicker-range__icon kxiconfont icon-clock"></i>'+
                '<input placeholder="开始日期" name="" class="c-datepicker-data-input only-date start" value="">'+
                '<span class="c-datepicker-range-separator">-</span>'+
                '<input placeholder="结束日期" name="" class="c-datepicker-data-input only-date end" value="">'+
                '</div>'+
                '</div>',
                preConfirm: function (result) {
                    return new Promise(function (resolve) {
                        if (result) {
                            resolve([
                                $('.start').val(),
                                $('.end').val(),
                            ]);
                        }
                    });
                }
            }).then(function (result) {
                if (result){
                    var start = new Date(new Date(result[0]).getTime() - 8 * 3600000);
                    var end = new Date(new Date(result[1]).getTime() - 8 * 3600000);
                   window.location.href="/writeOrders.do?start="+start.getTime()+"&end="+end.getTime();
                }
            })

        })

    })();

    (function () {
        init();
    })();

    function initDatepicker() {
        $(this).click(function () {
        var DATAPICKERAPI = {
            // 默认input显示当前月,自己获取后填充
            activeMonthRange: function () {
                return {
                    begin: moment().set({'date': 1, 'hour': 0, 'minute': 0, 'second': 0}).format('YYYY-MM-DD'),
                    end: moment().set({'hour': 23, 'minute': 59, 'second': 59}).format('YYYY-MM-DD')
                }
            },
            shortcutMonth: function () {
                // 当月
                var nowDay = moment().get('date');
                var prevMonthFirstDay = moment().subtract(1, 'months').set({'date': 1});
                var prevMonthDay = moment().diff(prevMonthFirstDay, 'days');
                return {
                    now: '-' + (nowDay - 1) + ',0',
                    prev: '-' + prevMonthDay + ',-' + nowDay
                }
            },
            // 快捷选项option
            rangeShortcutOption1: function () {
                var result = DATAPICKERAPI.shortcutMonth();
                return [{
                    name: '当前月',
                    day: result.now
                }, {
                    name: '最近一周',
                    day: '-7,0'
                }, {
                    name: '最近一个月',
                    day: '-30,0'
                }, {
                    name: '最近三个月',
                    day: '-90, 0'
                }];

            }
        };

        //年月日范围
        $('.J-datepicker-range-day').datePicker({
            hasShortcut: true,
            format: 'YYYY-MM-DD',
            isRange: true,
            shortcutOptions: DATAPICKERAPI.rangeShortcutOption1()
        });
        });
    }

</script>