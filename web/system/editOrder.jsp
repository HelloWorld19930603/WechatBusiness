<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
                    <a href="#">订单</a>
                </li>
                <li class="active">订单详情 </li>
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
                                <fieldset title="订单商品列表">
                                    <legend></legend>
                                    <div class="col-sm-12">
                                        <section class="panel">
                                            <header class="panel-heading">
                                                订单信息
                                                <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                             </span>
                                            </header>
                                            <div class="panel-body">
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>订单号</th>
                                                        <th>买家姓名</th>
                                                        <th>买家电话</th>
                                                        <th>支付方式</th>
                                                        <th>支付金额</th>
                                                        <th>订单状态</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>${order.id}</td>
                                                            <td>${order.name}</td>
                                                            <td>${order.phone}</td>
                                                            <td>余额支付</td>
                                                            <td>${order.totals}</td>
                                                            <td class="status">${order.status}</td>
                                                            <td><a href="#" onclick="updateTotals(${order.status})">修改价格</a></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </section>
                                    </div>


                                </fieldset>
                                <fieldset title="收货人信息">
                                    <legend></legend>
                                    <div class="col-sm-12">
                                        <section class="panel">
                                            <header class="panel-heading">
                                                收货人信息
                                                <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                             </span>
                                            </header>
                                            <div class="panel-body">
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>收货人姓名</th>
                                                        <th>收货人电话</th>
                                                        <th>所在省市区</th>
                                                        <th>详细地址</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>${address.name}</td>
                                                            <td>${address.phone}</td>
                                                            <td>${address.ssq}</td>
                                                            <td>${address.addr}</td>
                                                            <td><a href="#" onclick="updateAddress()">修改</a></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </section>
                                    </div>


                                </fieldset>
                                <fieldset title="订单商品列表">
                                    <legend></legend>
                                    <div class="col-sm-12">
                                        <section class="panel">
                                            <header class="panel-heading">
                                                订单商品列表
                                                <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                             </span>
                                            </header>
                                            <div class="panel-body">
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>商品编号</th>
                                                        <th>商品名称</th>
                                                        <th>商品英文名</th>
                                                        <th>商品规格</th>
                                                        <th>数量</th>
                                                        <th>小计</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${list}" var="comm">
                                                    <tr>
                                                        <td><span class = 'sp'>${comm.commId}</span></td>
                                                        <td>${comm.commName}</td>
                                                        <td>${comm.eName}</td>
                                                        <td>${comm.scale}</td>
                                                        <td>${comm.num}<c:if test="${userRole.roleId == 1 || userRole.roleId == 2}">(箱）</c:if><c:if test="${userRole.roleId != 1 && userRole.roleId != 2}">(盒）</c:if></td>
                                                        <td>${comm.aPrice}</td>
                                                    </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </section>
                                    </div>

                                </fieldset>
                                <fieldset title="订单商品列表">
                                    <legend></legend>
                                    <div class="col-sm-12">
                                        <section class="panel">
                                            <header class="panel-heading">
                                                物流信息
                                                <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                             </span>
                                            </header>
                                            <div class="form-group" style="margin-top: 5px;">

                                                <label class="col-md-1 control-label span3">物流公司：</label>
                                                <div class="col-md-3">

                                                    <select class="form-control m-bot15" id = "com">

                                                    </select>
                                                </div>
                                                <label class="col-md-1 control-label span3"></label>
                                                <label class="col-md-1 control-label span3">物流单号：</label>
                                                <div class="col-md-3">
                                                    <input type="text" id="no" placeholder="物流单号" class="form-control"
                                                           value="${order.no}">
                                                </div>
                                                <div class="col-md-1">
                                                    <button class="btn btn-info finish" id = 'logistics'  type="button">
                                                            提交
                                                        </button>
                                                </div>
                                            </div>
                                        </section>
                                    </div>
                                    <button class="btn btn-info finish" id = 'finished'  type="button">
                                        关闭 </button>
                                </fieldset>
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
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>


<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>

</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");
    const TYPE_MAP = {
        '1': '未付款',
        '2': '已付款',
        '3': '已付款已发货',
        '4': '已完成',
        '5': '已退款'
    };

    const EXPRESS_MAP = [{"com":"顺丰","no":"sf"},{"com":"申通","no":"sto"},{"com":"圆通","no":"yt"},{"com":"韵达","no":"yd"},{"com":"天天","no":"tt"},{"com":"EMS","no":"ems"},{"com":"中通","no":"zto"},{"com":"汇通","no":"ht"},{"com":"全峰","no":"qf"},{"com":"德邦","no":"db"},{"com":"国通","no":"gt"},{"com":"如风达","no":"rfd"},{"com":"京东快递","no":"jd"},{"com":"宅急送","no":"zjs"},{"com":"EMS国际","no":"emsg"},{"com":"Fedex国际","no":"fedex"},{"com":"邮政国内（挂号信）","no":"yzgn"},{"com":"UPS国际快递","no":"ups"},{"com":"中铁快运","no":"ztky"},{"com":"佳吉快运","no":"jiaji"},{"com":"速尔快递","no":"suer"},{"com":"信丰物流","no":"xfwl"},{"com":"优速快递","no":"yousu"},{"com":"中邮物流","no":"zhongyou"},{"com":"天地华宇","no":"tdhy"},{"com":"安信达快递","no":"axd"},{"com":"快捷速递","no":"kuaijie"},{"com":"AAE全球专递","no":"aae"},{"com":"DHL","no":"dhl"},{"com":"DPEX国际快递","no":"dpex"},{"com":"D速物流","no":"ds"},{"com":"FEDEX国内快递","no":"fedexcn"},{"com":"OCS","no":"ocs"},{"com":"TNT","no":"tnt"},{"com":"东方快递","no":"coe"},{"com":"传喜物流","no":"cxwl"},{"com":"城市100","no":"cs"},{"com":"城市之星物流","no":"cszx"},{"com":"安捷快递","no":"aj"},{"com":"百福东方","no":"bfdf"},{"com":"程光快递","no":"chengguang"},{"com":"递四方快递","no":"dsf"},{"com":"长通物流","no":"ctwl"},{"com":"飞豹快递","no":"feibao"},{"com":"马来西亚（大包EMS）","no":"malaysiaems"},{"com":"安能快递","no":"ane66"}]


    $(function () {

        var typeSelect2 = document.querySelector('select[id="com"]');

        for (var key in EXPRESS_MAP) {
            var option = document.createElement('option');
            option.value = EXPRESS_MAP[key].no;
            option.innerText = EXPRESS_MAP[key].com;
            <c:if test="${order.com != null}">
            if(EXPRESS_MAP[key].no == '${order.com}')
                option.setAttribute("selected",true);
            </c:if>
            typeSelect2.appendChild(option);
        }

        $("#logistics").click(function () {

            var orderId = ${order.id};
            var com = $("#com").val();
            var no = $("#no").val();
            var name = '${user.name}';
            if(window.confirm('确认要提交物流信息?')){
                $.ajax({
                    //几个参数需要注意一下
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/deliverGoods2.do" ,//url
                    data: "name="+name+"&com="+com+"&orderId="+orderId+"&no="+no,
                    success: function (result) {
                        console.log(result);//打印服务端返回的数据(调试用)
                        if(result == 0)
                            swal({
                                type: 'success',
                                html: '提交成功 '
                            });
                        else
                            swal({
                                type: 'warning',
                                html: '提交失败'
                            });
                    },
                    error : function() {
                        swal({
                            type: 'warning',
                            html: '提交异常'
                        });
                    }
                })
            }
        })
    })

    $(".status").text(TYPE_MAP[${order.status}]);


    function updateTotals(status) {
        if(status != 1){
            swal({
                type: 'info',
                html: '只允许修改未付款订单价格哦！'
            });
            return;
        }
        swal({
            title: '请输入新的价格',
            input: 'text',
            showCancelButton: true,
            inputValidator: function(value) {
                return new Promise(function(resolve, reject) {
                    if (value && !isNaN(value) && value >= 0) {
                        resolve();
                    } else {
                        reject('请输入合法值!');
                    }
                });
            }
        }).then(function(result) {
            if (result) {
                var orderId = '${order.id}';
                $.ajax({
                    //几个参数需要注意一下
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/editMoney.do" ,//url
                    data: "money="+result+"&orderId="+orderId,
                    success: function (data) {
                        console.log(data);//打印服务端返回的数据(调试用)
                        if (data == 0) {
                            swal({
                                type: 'success',
                                html: '修改后的价格为: ' + result
                            });
                        }else {
                            swal({
                                type: 'warning',
                                html: '修改价格失败'
                            });
                        }
                    },
                    error : function() {
                        swal({
                            type: 'warning',
                            html: '修改价格异常'
                        });
                    }
                })



            }
        })
    }

    function updateAddress() {
        swal({
            title: '收货人信息',
            showCancelButton: true,
            html:
            '收货人名称<input id="swal-input1" class="swal2-input" autofocus value=${address.name}>' +
            '收货人电话<input id="swal-input2" class="swal2-input" value=${address.phone}>' +
            '所在省市区<input id="swal-input3" class="swal2-input" value=${address.ssq}>' +
            '详细地址<input id="swal-input4" class="swal2-input" value=${address.addr}>' +
            '<input id="swal-input5" class="swal2-input" type="hidden" value="${address.id}">'+
            '<input id="swal-input6" class="swal2-input" type="hidden" value="${address.userId}">',
            preConfirm: function(result) {
                return new Promise(function(resolve) {
                    if (result) {
                        resolve([
                            $('#swal-input1').val(),
                            $('#swal-input2').val(),
                            $('#swal-input3').val(),
                            $('#swal-input4').val(),
                            $('#swal-input5').val(),
                            $('#swal-input6').val()
                        ]);
                    }
                });
            }
        }).then(function(result) {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/editAddress.do" ,//url
                data: "name="+result[0]+"&phone="+result[1]+"&ssq="+result[2]+"&addr="+result[3]+"&id="+result[4]+"&userId="+result[5],
                success: function (data) {
                    console.log(data);//打印服务端返回的数据(调试用)
                    if (data == 0) {
                        swal({
                            type: 'success',
                            html: '收获人信息修改成功: '
                        });
                    }else {
                        swal({
                            type: 'warning',
                            html: '收获人信息修改失败'
                        });
                    }
                },
                error : function() {
                    swal({
                        type: 'warning',
                        html: '收获人信息修改异常'
                    });
                }
            })

        })
    }


</script>