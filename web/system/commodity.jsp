<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">

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
    const TYPE_MAP2 = {
        '0':'无',
        '1': '明星产品',
        '2': '人气爆款',
        '3': '人气推荐'
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
                    <a href="#">商品</a>
                </li>
                <li class="active"> 商品管理</li>
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
                    <label class="se-title">商品名称:</label>
                    <input class="se-con" name="name"/>
                </div>

                <div class="sa-ele">
                    <button class="search-action">搜索</button>
                    <button class="reset-action">重置</button>
                </div>
                <div class="btn-group" style="float:right;">
                    <button id="editable-sample_new" class="btn btn-primary" style="font-size: 12px;padding: 4px 10px;">
                        新增 <i class="fa fa-plus"></i>
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


<script src="js/sweetalert/sweetalert2.min.js"></script>
<link rel="stylesheet" href="js/sweetalert/sweetalert2.min.css">
<!-- IE support -->
<script src="js/sweetalert/es6-promise.min.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active animated rubberBand");
    $(".${active}").parents("li").addClass("nav-active animated pulse");


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
                return '/getCommoditys.do';
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
                    key: 'img',
                    remind: 'the pic',
                    width: '110px',
                    align: 'center',
                    text: '缩略图',
                    // 使用函数返回 dom node
                    template: function(img, rowObject) {
                        var picNode= '<a href="'+img+'" data-fancybox data-caption="'+rowObject.name+'">'+
                        '<img src="'+img+'" width="100px" height="68px" alt="" />'
                            +'</a>';
                        return picNode;
                    }
                },
                {
                    key: 'name',
                    remind: 'the pic',
                    width: '120px',
                    align: 'center',
                    text: '商品名称',
                    // 使用函数返回 dom node
                    template: function(name, rowObject) {

                        return name;
                    }
                },{
                    key: 'eName',
                    remind: 'the title',
                    align: 'center',
                    width: '120px',
                    text: '英文名',
                    sorting: '',
                    // 使用函数返回 dom node
                    template: function(name, rowObject) {

                        return name;
                    }
                },{
                    key: 'serise',
                    remind: 'the type',
                    text: '系列',
                    width: '80px',
                    align: 'center',
                    template: function(serise, rowObject){
                        return TYPE_MAP[serise];
                    }
                },{
                    key: 'scale',
                    remind: 'the info',
                    text: '规格',
                    isShow: true,
                    width: '80px',
                    align: 'center'
                },{
                    key: 'mPrice',
                    remind: 'the info',
                    text: '市场价',
                    isShow: true,
                    width: '70px',
                    align: 'center'
                },{
                    key: 'type',
                    remind: 'the type',
                    text: '活动',
                    width: '70px',
                    align: 'center',
                    template: function(type, rowObject){
                        if(type == null){
                            type = 0;
                        }
                        return TYPE_MAP2[type];
                    }
                },{
                    key: 'action',
                    remind: 'the action',
                    width: '145px',
                    align: 'center',
                    text: '<span style="color: red">操作</span>',
                    // 直接返回 htmlString
                    template: function (action,rowObjct) {
                        var htmlString = '<span class="plugin-action" gm-click="editRowData">编辑</span>';
                         htmlString += '<span class="plugin-action" gm-click="activities" style="color:#f0ad4e">活动</span>';
                        if(rowObjct.status == 1){
                            htmlString += '<span class="plugin-action" style="color:#d9534f" onclick="updateShelf('+rowObjct.id+',\''+rowObjct.name+'\','+rowObjct.status+')">删除</span>';
                        }else{
                            htmlString += '<span class="plugin-action" style="color:#5bc0de" onclick="updateShelf('+rowObjct.id+',\''+rowObjct.name+'\','+rowObjct.status+')">上架</span>';
                        }
                        return htmlString;
                    }
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

    // 上下架
    function updateShelf(commId,name,status){
        if(status == 1){
            swal({
                title: '你确定吗?',
                text: '你将会删除'+name+'这件商品!',
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '确认删除',
                cancelButtonText:'点错了'
            }).then(function(isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        url: "/removeCommodity.do?commId="+commId+"&status=0",
                        type: "get",
                        success: function (data) {
                            if(data == 0){
                              swal('大功告成!', '好的，以后你将不会再商品列表中看到它了!', 'success');
                            }else{
                                swal('Oh no...', '商品删除异常!', 'error');
                            }
                            console.log(data);
                        },
                        error: function (data) {
                            swal('Oh no...', '商品删除失败!', 'error');
                            console.log(data);
                        }
                    });

                }
            });
        }else{
            swal({
                title: '你确定吗?',
                text: '你将会上架'+name+'这件商品!',
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '确认上架',
                cancelButtonText:'点错了'
            }).then(function(isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        url: "/updateShelf.do?commId="+commId+"&status=1",
                        type: "get",
                        success: function (data) {
                            if(data == 0){
                                swal('大功告成!', '好的，商品列表中又可以找到这件商品了!', 'success');
                            }else{
                                swal('Oh no...', '商品上架异常!', 'error');
                            }
                        },
                        error: function (data) {
                            alert("商品上架失败");
                            console.log(data);
                        }
                    });

                }
            });
        }
    }

    function activities(rowData) {
        swal({
            title: '请选择['+rowData.name+']要参加的活动',
            input: 'select',
            inputOptions: {
                '0':'无',
                '1': '明星产品',
                '2': '人气爆款',
                '3': '人气推荐'
            },
            inputPlaceholder: '',
            showCancelButton: true,
            confirmButtonText: '确认',
            cancelButtonText:'取消',
            inputValidator: function(value) {
                return new Promise(function(resolve, reject) {
                    resolve();

                });
            }
        }).then(function(result) {
            if (result) {
                $.ajax({
                    //几个参数需要注意一下
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/activities.do" ,//url
                    data: "type="+result+"&commId="+rowData.id,
                    success: function (data) {
                        console.log(data);//打印服务端返回的数据(调试用)
                        if (data == 0) {
                            swal({
                                type: 'success',
                                html: '提交成功 '
                            });
                        }else {
                            swal({
                                type: 'warning',
                                html: '提交失败'
                            });
                        }
                    },
                    error : function(data) {
                        console.log(data);//打印服务端返回的数据(调试用)
                        swal({
                            type: 'warning',
                            html: '提交异常'
                        });
                    }
                })

            }
        })
    }

    function editRowData(rowData){
        window.location.href = "/editCommodity.do?commId="+rowData.id;
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
            document.querySelector('select[name="serise"]').value = '-1';
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