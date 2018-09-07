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

    <!--data table-->
    <link rel="stylesheet" href="/js/data-tables/DT_bootstrap.css" />

    <link href="/css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <style>
        .center{
            text-align: center;
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
                    <a href="#">经销商</a>
                </li>
                <li class="active">团队列表 </li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            团队所属经销商：${userName}
                            <span style="float:right;margin-right: 20px;">团队充值总额：${totals}</span>
                        </header>
                        <div class="panel-body">
                            <div class="adv-table editable-table ">
                                <table class="table table-striped table-hover table-bordered" id="editable-sample">
                                    <thead>
                                    <tr>
                                        <th class="center">授权码</th>
                                        <th class="center">名称</th>
                                        <th class="center">账号</th>
                                        <th class="center">等级</th>
                                        <th class="center">电话</th>
                                        <th class="center">微信号</th>
                                        <th class="center">充值金额</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${data}" var="u">
                                    <tr class="">
                                        <td class="center">${u.id}</td>
                                        <td class="center">${u.name}</td>
                                        <td class="center">${u.loginName}</td>
                                        <td class="center">${u.roleId}</td>
                                        <td class="center">${u.phone}</td>
                                        <td class="center">${u.wxNum}</td>
                                        <td class="center">${u.money}</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
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
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<!--data table-->
<script type="text/javascript" src="/js/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="/js/data-tables/DT_bootstrap.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<!--script for editable table-->
<script src="/js/editable-table.js"></script>

</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");

    jQuery(document).ready(function() {
        EditableTable.init();
    });

</script>