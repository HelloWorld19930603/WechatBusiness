<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>AdminX</title>


    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="js/morris-chart/morris.css">

    <!--common-->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="css/datepicker.css">

    <style>
        #main-chart{
            min-height: 330px;
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
    <div class="main-content" >

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
            <div class="state-info" style="margin-right: 30%" >
                <section class="panel">
                    <div class="mt40" ><div class="c-datepicker-date-editor  J-datepicker-range-day mt10">
                    <i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
                    <input placeholder="开始日期" name="" class="c-datepicker-data-input only-date" value="">
                    <span class="c-datepicker-range-separator">-</span>
                    <input placeholder="结束日期" name="" class="c-datepicker-data-input only-date" value="">
                </div> </div></section>
                <section class="panel"></section>
            </div>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-md-6">
                    <!--statistics start-->
                    <div class="row state-overview">
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel purple">
                                <div class="symbol">
                                    <i class="fa fa-gavel"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v1"></div>
                                    <div class="title">待发货</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel red">
                                <div class="symbol">
                                    <i class="fa fa-tags"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v2"></div>
                                    <div class="title">待充值审核</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row state-overview">
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel blue">
                                <div class="symbol">
                                    <i class="fa fa-money"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v3"></div>
                                    <div class="title"> 待升级审核</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel green">
                                <div class="symbol">
                                    <i class="fa fa-eye"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value v4"></div>
                                    <div class="title"> 待邀请审核</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--statistics end-->
                </div>
                <div class="col-md-6">
                    <!--more statistics box start-->
                    <div class="panel deep-purple-box">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-7 col-sm-7 col-xs-7">
                                    <div id="graph-donut" class="revenue-graph"></div>
                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-5">
                                    <ul class="bar-legend">
                                        <li><span style="background: #5187BA"></span> 待发货</li>
                                        <li><span style="background: #DF585C"></span> 已发货</li>
                                        <li><span style="background: #F0953A"></span> 已完成</li>
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
<script src="js/jquery.nicescroll.js"></script>



<!-- jQuery Flot Chart-->
<script src="js/flot-chart/jquery.flot.js"></script>
<script src="js/flot-chart/jquery.flot.tooltip.js"></script>
<script src="js/flot-chart/jquery.flot.resize.js"></script>



<!--Morris Chart-->
<script src="js/morris-chart/morris.js"></script>
<script src="js/morris-chart/raphael-min.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js/chart-js/echartsUtil.js"></script>
<script src="/js/chart-js/echarts.js"></script>


</body>
</html>
<script src="js/date/moment.min.js"></script>
<!-- <script src="js/datapicker-separate/api.js"></script>
<script src="js/datapicker-separate/year.js"></script>
<script src="js/datapicker-separate/month.js"></script>
<script src="js/datapicker-separate/day.js"></script>
<script src="js/datapicker-separate/time.js"></script>
<script src="js/datapicker-separate/datepicker.js"></script> -->
<script src="js/date/datepicker.all.js"></script>
<!-- <script src="js/datepicker.all.min.js"></script> -->
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");

    $(function(){
        var DATAPICKERAPI = {
            // 默认input显示当前月,自己获取后填充
            activeMonthRange: function () {
                return {
                    begin: moment().set({ 'date': 1, 'hour': 0, 'minute': 0, 'second': 0 }).format('YYYY-MM-DD HH:mm:ss'),
                    end: moment().set({ 'hour': 23, 'minute': 59, 'second': 59 }).format('YYYY-MM-DD HH:mm:ss')
                }
            },
            shortcutMonth: function () {
                // 当月
                var nowDay = moment().get('date');
                var prevMonthFirstDay = moment().subtract(1, 'months').set({ 'date': 1 });
                var prevMonthDay = moment().diff(prevMonthFirstDay, 'days');
                return {
                    now: '-' + (nowDay-1) + ',0',
                    prev: '-' + prevMonthDay + ',-' + nowDay
                }
            },
            // 快捷选项option
            rangeShortcutOption1: function () {
                var result = DATAPICKERAPI.shortcutMonth();
                return [{
                    name: '当前月',
                    day:  result.now
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

        $('.but').click(function () {

        })


        $.ajax({

            url:'/selectAll.do',
            data :"&start=2018-8-1&end=2018-9-18",
            dataType:'json',
            success: function(data){

                $(".v1").text(data.obj[0]);
                $(".v2").text(data.obj[3]);
                $(".v3").text(data.obj[6]);
                $(".v4").text(data.obj[9]);
;               var charData = "订单,待发货,"+data.obj[0]+",已发货,"+data.obj[1]+",已完成,"+data.obj[2]

                new EchartsUtils("graph-donut",{
                    "colorType": "xdjy",
                    "chartType": "pie",
                    "innerSize": "60%",
                    "data": charData,
                    "yAxisTitle": "个"
                });
            },
            error:function(data){

            }
        })


        $.ajax({

            url:'/selectForSale.do',
            data :"&start=2018-8-28&end=2018-9-28",
            dataType:'json',
            success: function(data){
                var num = '';
                var year = '';

                year += data.obj[0].t;
                for(var i=1;i<data.obj.length;i++){
                    year += ","+data.obj[i].t;
                }
                num += '销量';
                for(var i=0;i<data.obj.length;i++){
                    num += ","+data.obj[i].n;
                }
                var chart = year+";"+num;
                new EchartsUtils("main-chart-container",{
                    "colorType": "ldhp",
                    "data": chart,
                    "yAxisTitle": "个"
                });

            },
            error:function(data){

            }
        })


        $.ajax({

            url:'/selectForDealer.do',
            data :"&start=2018-8-28&end=2018-9-28",
            dataType:'json',
            success: function(data){
                var num = '';
                var year = '';

                year += data.obj[0].t;
                for(var i=1;i<data.obj.length;i++){
                    year += ","+data.obj[i].t;
                }
                num += '新增代理';
                for(var i=0;i<data.obj.length;i++){
                    num += ","+data.obj[i].n;
                }
                var chart = year+";"+num;
                new EchartsUtils("main-chart-container2",{
                    "colorType": "qxzr",
                    "data": chart,
                    "yAxisTitle": "位"
                });

            },
            error:function(data){

            }
     });
    });
</script>