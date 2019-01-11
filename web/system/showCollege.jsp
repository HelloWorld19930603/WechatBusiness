<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">


  <title>学院详情</title>

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content" style="padding-top:0px;margin-left: 0px;width: 100%;">

        <!-- header section start-->
        <!-- header section end-->

        <!-- page heading start-->
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper" style="padding: 0;"><div class="col-md-12" style="padding: 0 0">
            <div class="blog">
                <div class="single-blog">
                    <div class="panel">
                        <div class="panel-body">
                            <h2 class="text-center mtop35"><a href="#">${college.title}</a></h2>

                            <p class="text-center auth-row">
                                <a href="#"> 阅读量:${college.readNum} </a> &nbsp;| &nbsp;  <a href="#">转发量:${college.forward} </a>   &nbsp; |  &nbsp;  上传时间:<fmt:formatDate value="${college.time}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </p>
                            <div style="text-align: center">
                                <c:if test="${college.video != null && college.video != ''}">
                                <video src="${college.video}" controls="controls" style="width: 100%;">
                                    您的浏览器不支持 video 标签。
                                </video>
                                </c:if>
                                <c:if test="${college.video == null || college.video == ''}">
                                <img src="${college.img}" alt="" style="width: 100%;">
                                </c:if>
                            </div>
                            <div style="text-align: center">
                            ${college.content}
                            </div>

                            <div class="blog-tags"></div>
                        </div>
                    </div>

                </div>
            </div>
        </div></div>
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

</body>
</html>
