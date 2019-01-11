<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">

    <title>AdminX</title>

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
    // 博文类型
    const TYPE_MAP = {
        '1': 'HTML/CSS',
        '2': 'nodeJS',
        '3': 'javaScript',
        '4': '前端鸡汤',
        '5': 'PM Coffee',
        '6': '前端框架',
        '7': '前端相关'
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
            <h3>
                Dashboard
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">Dashboard</a>
                </li>
                <li class="active"> My Dashboard</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <section class="search-area">
                <div class="sa-ele">
                    <label class="se-title">标题:</label>
                    <input class="se-con" name="title"/>
                </div>
                <div class="sa-ele">
                    <label class="se-title">博文分类:</label>
                    <select class="se-con" name="type">
                        <option value="-1">请选择</option>
                        <!--通过js增加-->
                    </select>
                </div>
                <div class="sa-ele">
                    <label class="se-title">内容:</label>
                    <input class="se-con" name="content"/>
                </div>
                <div class="sa-ele">
                    <button class="search-action">搜索</button>
                    <button class="reset-action">重置</button>
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
            ,isCombSorting: false
            ,disableCache: false
            // ajax_url 将在v2.6.0以上版本废弃，请不要再使用
            // ,ajax_url: 'http://www.lovejavascript.com/blogManager/getBlogList'
            ,ajax_data: function () {
                return 'http://www.lovejavascript.com/blogManager/getBlogList';
            }
            // ,firstLoading: false // 初始渲染时是否加载数据
            ,ajax_type: 'POST'
            ,supportMenu: true

            // 选择事件执行前事件
            ,checkedBefore: function(checkedList){
                console.log('checkedBefore==', checkedList);
            }

            // 选择事件执行后事件
            ,checkedAfter: function(checkedList){
                console.log('checkedAfter==', checkedList);
            }

            // 全选事件执行前事件
            ,checkedAllBefore: function(checkedList){
                console.log('checkedAllBefore==', checkedList);
            }

            // 全选事件执行后事件
            ,checkedAllAfter: function(checkedList){
                console.log('checkedAllAfter==', checkedList);
            }

            // AJAX请求前事件函数
            ,ajax_beforeSend: function(promise){
                console.log('ajax_beforeSend');
            }
            // AJAX成功事件函数
            ,ajax_success: function(response){
                console.log('ajax_success');
            }

            // AJAX失败事件函数
            ,ajax_error: function(error){
                console.log('ajax_error');
            }

            // AJAX结束事件函数
            ,ajax_complete: function(complete){
                console.log('ajax_complete');
            }

            // ,emptyTemplate: '<div class="void-template">通过 emptyTemplate 配置的空数据提示</div>'
            // 配置 request header, 非xhr自带的头信息将会触发非简单请求, 需要在后端进行对应的配置
            // 参考链接: http://www.lovejavascript.com/#!zone/blog/content.html?id=53
//				,ajax_headers: {
//					'header-test': 'this is test request header'
//					'Content-Type': 'application/json'
//				}
            // 配置xhr, 如: withCredentials -> 跨域情况使用cookie等证书. 需要在后端进行对应的配置
            // 参考链接: http://www.lovejavascript.com/#!zone/blog/content.html?id=59
            //		,ajax_xhrFields: {
            //			withCredentials: true
            //		}
            ,query: {test2: 222}
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
                    key: 'pic',
                    remind: 'the pic',
                    width: '110px',
                    align: 'center',
                    text: '缩略图',
                    // 使用函数返回 dom node
                    template: function(pic, rowObject) {
                        var picNode = document.createElement('a');
                        picNode.setAttribute('href', `http://www.lovejavascript.com/#!zone/blog/content.html?id=`+rowObject.id);
                        picNode.setAttribute('title', rowObject.title);
                        picNode.setAttribute('target', '_blank');
                        picNode.title = `点击阅读[${rowObject.title}]`;
                        picNode.style.display = 'block';
                        picNode.style.height = '68.5px';

                        var imgNode = document.createElement('img');
                        imgNode.style.width = '100px';
                        imgNode.style.padding = '5px';
                        imgNode.style.margin = '0 auto';
                        imgNode.alt = rowObject.title;
                        imgNode.src = `http://www.lovejavascript.com/`+rowObject.pic;

                        picNode.appendChild(imgNode);
                        return picNode;
                    }
                },{
                    key: 'title',
                    remind: 'the title',
                    align: 'left',
                    text: '标题',
                    sorting: '',
                    // 使用函数返回 dom node
                    template: function(title, rowObject) {
                        var titleNode = document.createElement('a');
                        titleNode.setAttribute('href', `http://www.lovejavascript.com/#!zone/blog/content.html?id=`+rowObject.id);
                        titleNode.setAttribute('title', title);
                        titleNode.setAttribute('target', '_blank');
                        titleNode.innerText = title;
                        titleNode.title = `点击阅读[${rowObject.title}]`;
                        titleNode.classList.add('plugin-action');
                        return titleNode;
                    }
                },{
                    key: 'type',
                    remind: 'the type',
                    text: '博文分类',
                    width: '100px',
                    align: 'center',
                    template: function(type, rowObject){
                        return TYPE_MAP[type];
                    }
                },{
                    key: 'info',
                    remind: 'the info',
                    text: '简介',
                    isShow: false
                },{
                    key: 'username',
                    remind: 'the username',
                    align: 'center',
                    width: '100px',
                    text: '作者',
                    template: function(username){
                        return `<a class="plugin-action" href="https://github.com/baukh789" target="_blank" title="去看看${username}的github">${username}</a>`;
                    }
                },{
                    key: 'createDate',
                    remind: 'the createDate',
                    width: '130px',
                    text: '创建时间',
                    sorting: 'DESC',
                    // 使用函数返回 htmlString
                    template: function(createDate, rowObject){
                        return new Date(createDate).toLocaleDateString();
                    }
                },{
                    key: 'lastDate',
                    remind: 'the lastDate',
                    width: '130px',
                    text: '最后修改时间',
                    sorting: '',
                    // 使用函数返回 htmlString
                    template: function(lastDate, rowObject){
                        return new Date(lastDate).toLocaleDateString();
                    }
                },{
                    key: 'action',
                    remind: 'the action',
                    width: '100px',
                    align: 'center',
                    text: '<span style="color: red">操作</span>',
                    // 直接返回 htmlString
                    template: '<span class="plugin-action" gm-click="delectRowData">编辑</span><span class="plugin-action" gm-click="delectRowData">删除</span>'
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
        if(window.confirm('确认要删除['+rowData.title+']?')){
            window.alert('当然这只是个示例,并不会真实删除,要不然每天我每天就光填demo数据了.');
        }
    }

    /**
     * 渲染博文类型
     */
    (function () {
        // 渲染下拉框
        var typeSelect = document.querySelector('.search-area select[name="type"]');

        for(var key in TYPE_MAP){
            var option = document.createElement('option');
            option.value = key;
            option.innerText = TYPE_MAP[key];
            typeSelect.appendChild(option);
        }
    })();

    /**
     * 提供demo中的搜索, 重置
     */
    (function(){

        // 绑定搜索事件
        document.querySelector('.search-action').addEventListener('click', function () {
            var _query = {
                title: document.querySelector('[name="title"]').value,
                type: document.querySelector('[name="type"]').value,
                content: document.querySelector('[name="content"]').value,
                index: 1
            };
            table.GM('setQuery', _query, function(){
                console.log('setQuery执行成功');
            });
        });

        // 绑定重置
        document.querySelector('.reset-action').addEventListener('click', function () {
            document.querySelector('[name="title"]').value = '';
            document.querySelector('[name="type"]').value = '-1';
            document.querySelector('[name="content"]').value = '';
        });
    })();

    (function(){
        init();
    })();
</script>