<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords"
          content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">
    <link href="<%=path%>/css/animate.min.css" rel="stylesheet">
    <title><%=title%>
    </title>


    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="js/morris-chart/morris.css">

    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="css/datepicker.css">

    <style>
        #main-chart {
            min-height: 330px;
        }

        .state-value {
            cursor: pointer;
        }
        .fa-check:hover{
            background-color: #ef579d;
            color: white;
            border-radius:4px;
        }

        .panel.active2{
            box-shadow:10px 10px 5px #a5a9b7;
        }



    </style>

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
                    <a href="#">首页</a>
                </li>
            </ul>
            <div class="state-info" style="margin-right: 30%">
                <section class="panel"><i class="fa fa-check"
                                          style="text-align: center; height: 33px;width: 24px;padding-top:10px;width: 52px;cursor: pointer;">确认</i>
                </section>

                <section class="panel">
                    <div class="mt40">
                        <div class="c-datepicker-date-editor  J-datepicker-range-day mt10">
                            <i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
                            <input placeholder="开始日期" name="" class="c-datepicker-data-input only-date start" value="">
                            <span class="c-datepicker-range-separator">-</span>
                            <input placeholder="结束日期" name="" class="c-datepicker-data-input only-date end" value="">
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-md-6">
                    <!--statistics start-->
                    <div class="row state-overview ">
                        <div class="col-md-6 col-xs-12 col-sm-6 r1">
                            <div class="panel purple">
                                <div class="symbol">
                                    <i class="fa fa-archive"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v1"></div>
                                    <div class="title">待发货</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-12 col-sm-6 r2">
                            <div class="panel red">
                                <div class="symbol">
                                    <i class="fa fa-cny"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v2"></div>
                                    <div class="title">待充值审核</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row state-overview">
                        <div class="col-md-6 col-xs-12 col-sm-6 r3">
                            <div class="panel blue">
                                <div class="symbol">
                                    <i class="fa fa-envelope"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v3"></div>
                                    <div class="title"> 待邀请审核</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-12 col-sm-6 r4">
                            <div class="panel green">
                                <div class="symbol">
                                    <i class="fa fa-gavel"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v4"></div>
                                    <div class="title"> 待升级审核</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--statistics end-->
                </div>
                <div class="col-md-6">
                    <!--more statistics box start-->
                    <div class="panel deep-purple-box">
                        <div class="panel-body pie">
                            <div class="row p1">
                                <div class="col-md-7 col-sm-7 col-xs-7">
                                    <div id="graph-donut1" class="revenue-graph"></div>
                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-5">
                                    <ul class="bar-legend">
                                        <li><span style="background: #38A9E0"></span> 待发货</li>
                                        <li><span style="background: #4DE4C4"></span> 已发货</li>
                                        <li><span style="background: #A280D6"></span> 已完成</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row p2">
                                <div class="col-md-7 col-sm-7 col-xs-7">
                                    <div id="graph-donut2" class="revenue-graph"></div>
                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-5">
                                    <ul class="bar-legend">
                                        <li><span style="background: #5187BA"></span> 待审核</li>
                                        <li><span style="background: #DF585C"></span> 已通过</li>
                                        <li><span style="background: #F0953A"></span> 已拒绝</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row p3">
                                <div class="col-md-7 col-sm-7 col-xs-7">
                                    <div id="graph-donut3" class="revenue-graph"></div>
                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-5">
                                    <ul class="bar-legend">
                                        <li><span style="background: #5187BA"></span> 待审核</li>
                                        <li><span style="background: #DF585C"></span> 已通过</li>
                                        <li><span style="background: #F0953A"></span> 已拒绝</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row p4">
                                <div class="col-md-7 col-sm-7 col-xs-7">
                                    <div id="graph-donut4" class="revenue-graph"></div>
                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-5">
                                    <ul class="bar-legend">
                                        <li><span style="background: #5187BA"></span> 待审核</li>
                                        <li><span style="background: #DF585C"></span> 已通过</li>
                                        <li><span style="background: #F0953A"></span> 已拒绝</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--more statistics box end-->
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-body">

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="clearfix">
                                        <div id="main-chart-legend" class="pull-right">
                                        </div>
                                    </div>

                                    <div id="main-chart">
                                        <div id="main-chart-container" class="main-chart">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-body">

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="clearfix">
                                        <div id="main-chart-legend2" class="pull-right">
                                        </div>
                                    </div>

                                    <div id="main-chart2">
                                        <div id="main-chart-container2" class="main-chart">
                                        </div>
                                    </div>

                                </div>
                            </div>
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
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="/js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<script src="/js/chart-js/echartsUtil.js"></script>
<script src="/js/chart-js/echarts.js"></script>


</body>
</html>
<script src="js/date/moment.min.js"></script>

<script src="js/date/datepicker.all.js"></script>
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");
    var date1 = new Date();
    var date2 = date1 - 3600 * 24 * 31 * 1000;
    var start = dateFtt("yyyy-MM-dd", new Date(date2));
    var end = dateFtt("yyyy-MM-dd", date1);
    $(function () {
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


        $(".fa").click(function () {
            var date1 = $('.start').val();
            var date2 = $(".end").val();
            if(date1 == null || date1 == ''|| date2 == null || date2 == '' ){
                return;
            }
            start = dateFtt("yyyy-MM-dd",new Date(new Date(date1)-3600*24*1000));
            end =dateFtt("yyyy-MM-dd",new Date(new Date(date2)-3600*24*1000));
            if (start && end) {
                selectForDealer();
                selectForSale();
            }
        })

        var $btn = $('.col-md-6.col-xs-12.col-sm-6').find('.panel');
        $btn.click(function(){
            var that = this;
            $(this).addClass('active2').siblings().removeClass('active2');
            $(this).addClass('flipInX animated infinite');
            setTimeout(function () {
                $(that).removeClass("flipInX animated infinite");
            }, 1000);
        });


        $(".r1").click(function () {
            $(".pie .row").hide();
            $(".p1").show();
        });
        $(".r2").click(function () {
            $(".pie .row").hide();
            $(".p2").show();
        });
        $(".r3").click(function () {
            $(".pie .row").hide();
            $(".p3").show();
        });
        $(".r4").click(function () {
            $(".pie .row").hide();
            $(".p4").show();
        });

        selectAll();
        selectForSale();
        selectForDealer();


        $(".state-value").eq(0).click(function () {
            window.location.href = "/order.do?status=2";
        })
        $(".state-value").eq(1).click(function () {
            window.location.href = "/rechargeAudit.do";
        })
        $(".state-value").eq(2).click(function () {
            window.location.href = "/agent.do";
        })
        $(".state-value").eq(3).click(function () {
            window.location.href = "/agentUpgrade.do";
        })

    });

    function selectAll() {
        $.ajax({
            url: '/selectAll.do',
            data: "&start=" + start + "&end=" + end,
            dataType: 'json',
            success: function (data) {

                $(".v1").text(data.obj[0]);
                $(".v2").text(data.obj[3]);
                $(".v3").text(data.obj[6]);
                $(".v4").text(data.obj[9]);
                ;
                var charData1 = "订单,待发货," + data.obj[0] + ",已发货," + data.obj[1] + ",已完成," + data.obj[2];
                ;
                var charData2 = "充值审核,待审核," + data.obj[3] + ",已通过," + data.obj[4] + ",已拒绝," + data.obj[5];
                ;
                var charData3 = "代理邀请审核,待审核," + data.obj[6] + ",已通过," + data.obj[7] + ",已拒绝," + data.obj[8];
                ;
                var charData4 = "代理升级审核,待审核," + data.obj[9] + ",已通过," + data.obj[10] + ",已拒绝," + data.obj[11];
                new EchartsUtils("graph-donut1", {
                    "colorType": "slhd",
                    "chartType": "pie",
                    "innerSize": "60%",
                    "data": charData1,
                    "yAxisTitle": "个"
                });
                new EchartsUtils("graph-donut2", {
                    "colorType": "xdjy",
                    "chartType": "pie",
                    "innerSize": "60%",
                    "data": charData2,
                    "yAxisTitle": "个"
                });
                new EchartsUtils("graph-donut3", {
                    "colorType": "xdjy",
                    "chartType": "pie",
                    "innerSize": "60%",
                    "data": charData3,
                    "yAxisTitle": "个"
                });
                new EchartsUtils("graph-donut4", {
                    "colorType": "xdjy",
                    "chartType": "pie",
                    "innerSize": "60%",
                    "data": charData4,
                    "yAxisTitle": "个"
                });
                $(".panel.deep-purple-box").show();
                $(".pie .row").hide();
                $(".p1").show();
            },
            error: function (data) {

            }
        })
    }

    function selectForSale() {
        $.ajax({
            url: '/selectForSale.do',
            data: "&start=" + start + "&end=" + end,
            dataType: 'json',
            success: function (data) {
                var num = '';
                var year = '';

                year += data.obj[0].t;
                for (var i = 1; i < data.obj.length; i++) {
                    year += "," + data.obj[i].t;
                }
                num += '销量';
                for (var i = 0; i < data.obj.length; i++) {
                    num += "," + data.obj[i].n;
                }
                var chart = year + ";" + num;
                new EchartsUtils("main-chart-container", {
                    "colorType": "ldhp",
                    "data": chart,
                    "yAxisTitle": "个"
                });

            },
            error: function (data) {

            }
        })

    }

    function selectForDealer() {
        $.ajax({

            url: '/selectForDealer.do',
            data: "&start=" + start + "&end=" + end,
            dataType: 'json',
            success: function (data) {
                var num = '';
                var year = '';

                year += data.obj[0].t;
                for (var i = 1; i < data.obj.length; i++) {
                    year += "," + data.obj[i].t;
                }
                num += '新增代理';
                for (var i = 0; i < data.obj.length; i++) {
                    num += "," + data.obj[i].n;
                }
                var chart = year + ";" + num;
                new EchartsUtils("main-chart-container2", {
                    "colorType": "qxzr",
                    "data": chart,
                    "yAxisTitle": "位"
                });

            },
            error: function (data) {

            }
        })
    }


</script>