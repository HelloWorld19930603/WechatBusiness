<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<style type="text/css">

    * {
        margin: 0;
        padding: 0;
    }

    .result-box {
        margin-top: 0;
        padding: 0;
    }

    ul, dl {
        list-style: none;
    }

    .com-info {
        padding: 0.5rem 1rem;
        line-height: 1.5rem;
        text-align: center;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        color: #fff;
        background-color: #878787;
        border-bottom: 0.0625rem solid #747474;
    }

    .result-list {
        margin-bottom: 35px;
    }

    ul, dl {
        list-style: none;
    }

    .result-list li.last {
        color: #e36301;
    }

    .result-list li.last {
        color: #ff7f02;
        background-color: #fff;
    }

    .result-list li {
        display: -webkit-box;
        -webkit-box-align: center;
        padding: 1rem 0;
        overflow: hidden;
        color: #878787;
        background-color: #f7f7f7;
        border-bottom: 0.0625rem solid #dadada;
    }

    .result-list li .col1 {
        width: 5rem;
        padding: 0 0.5rem;
        text-align: center;
        font-size: 0.875rem;
        font-weight: bold;
        font-family: Helvetica, Arial, sans-serif;
    }

    .result-list li .col1, .result-list li .col2, .result-list li .col3 {
        display: block;
    }

    ul, dl {
        list-style: none;
    }

    body, ul, ol, li, dl, dd, p, h1, h2, h3, h4, h5, h6, form, fieldset, table {
        margin: 0;
        padding: 0;
    }

    .result-list li .col2 {
        width: 1.25rem;
        position: relative;
    }

    .result-list li .col1, .result-list li .col2, .result-list li .col3 {
        display: block;
    }

    .result-list li .col2 .line2 {
        top: 0;
    }

    .result-list li .col2 .line1, .result-list li .col2 .line2 {
        position: absolute;
        z-index: 1;
        left: 0;
        width: 0.4375rem;
        height: 10em;
        border-right: 0.125rem solid #bebebe;
    }

    .result-list li.last .col2 .point {
        background-color: #ff7f02;
    }

    .result-list li .col2 .point {
        position: absolute;
        z-index: 2;
        top: -0.5rem;
        left: 0;
        width: 1rem;
        height: 1rem;
        border-radius: 0.5rem;
        background-color: #bebebe;
    }

    .result-list li .col3 {
        -webkit-box-flex: 1;
        padding: 0 0.5rem;
    }

    .result-list li .col1, .result-list li .col2, .result-list li .col3 {
        display: block;
    }

    .result-list li.first .col2 .point {
        background-color: #66cc00;
    }

    .result-list li .col2 .point {
        position: absolute;
        z-index: 2;
        top: -0.5rem;
        left: 0;
        width: 1rem;
        height: 1rem;
        border-radius: 0.5rem;
        background-color: #bebebe;
    }

    .result-list li .col2 .line1 {
        top: -10em;
    }

    .result-list li .col2 .line1, .result-list li .col2 .line2 {
        position: absolute;
        z-index: 1;
        left: 0;
        width: 0.4375rem;
        height: 10em;
        border-right: 0.125rem solid #bebebe;
    }
</style>
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
                <li class="active">订单商品列表 </li>
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
                                <input type="hidden" id="id" value="${poster.id}">
                                <input type="hidden" id="content" name="content" value="${poster.content}">
                                <fieldset title="订单商品列表">
                                    <legend></legend>
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">
                                        <section class="result-box" id="resultBox" hidden="" style="margin-top: 2rem; display: block;">

                                                <div class="com-info">快递公司：<span class="info1" id="showName">${logistics.company}</span>
                                                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;快递单号：<span class="info2" id="showNumber">${logistics.no}</span></div>
                                                <div class="result-success" id="success">
                                                    <c:if test="${error != null}">
                                                    <div class="col-sm-4"><span style="color: red">${error}</span></div>
                                                    </c:if>
                                                    <ul id="result" class="result-list">


                                                        <c:forEach items="${logistics.list}" var="l" varStatus="i">

                                                        <li class="first">
                                                            <div class="col1">
                                                                <dl>
                                                                    <dt>${fn:split(l.datetime," ")[0]}</dt>
                                                                    <dd>${fn:split(l.datetime," ")[1]}</dd>
                                                                </dl>
                                                            </div>
                                                            <div class="col2"><span class="step"><span class="line2"></span><span class="point"></span></span></div>
                                                            <div class="col3">${l.remark}
                                                            </div>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                                <div class="result-fail" id="fail" style="display: none;">
                                                    <h4>抱歉，该单号暂无记录，请稍后再试</h4>
                                                    <div id="autoCom" class="auto-div hidden">
                                                        <p>该单号可能是以下公司，请确认：</p>
                                                        <ul id="autoComList">
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="result-fail" id="nocom" style="display: none;">
                                                    <h4>抱歉告知您识别不了单号的公司</h4>
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
<script src="/js/jquery.stepy.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("nav-active");

    $(function () {


        $("#finished").click(function (e) {
            window.opener=null;
            window.open('','_self');
            window.close();
        });
    })


</script>