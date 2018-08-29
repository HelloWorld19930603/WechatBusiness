<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="index.html"><img src="<%=path%>/images/logo.png" alt=""></a>
    </div>

    <div class="logo-icon text-center">
        <a href="index.html"><img src="<%=path%>/images/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->

    <div class="left-side-inner">

        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="index"><a href="index.do"><i class="fa fa-home"></i> <span>系统管理</span></a></li>
            <li class="menu-list"><a href=""><i class="fa fa-users"></i> <span>经销商</span></a>
                <ul class="sub-menu-list">
                    <li class="dealer1"><a href="/dealer1.do"> 格丽缇</a></li>
                    <li class="dealer2"><a href="/dealer2.do"> Utomorrow</a></li>
                    <li class="dealer3"><a href="/dealer3.do"> Pslady</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-file-text"></i> <span>订单</span></a>
                <ul class="sub-menu-list">
                    <li class="order"><a href="/order.do"> 订单管理</a></li>
                    <li class="addPoster"><a href="/order.do"> 物流查询</a></li>
                    <li class="addPoster"><a href="/order.do"> 扫码发货</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-picture-o"></i> <span>广告</span></a>
                <ul class="sub-menu-list">
                    <li class="poster"><a href="/poster.do"> 广告管理</a></li>
                    <li class="addPoster"><a href="/addPoster.do"> 添加广告</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-list-alt"></i> <span>商品</span></a>
                <ul class="sub-menu-list">
                    <li class="commodity"><a href="/commodity.do"> 商品管理</a></li>
                    <li class="addCommodity"><a href="/addCommodity.do"> 添加商品</a></li>
                    <li class="addCommodity"><a href="/addCommodity.do"> 商品追溯</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-jpy"></i> <span>返利</span></a>
                <ul class="sub-menu-list">
                    <li class="rebate"><a href="/rebate.do"> 返利详情</a></li>
                    <li class="addRebate"><a href="/addRebate.do"> 添加规则</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>学院</span></a>
                <ul class="sub-menu-list">
                    <li class="college"><a href="/college.do"> 学院详情</a></li>
                    <li class="addCollege"><a href="/addCollege.do"> 添加素材</a></li>
                </ul>
            </li>
         <%--   <li><a href="fontawesome.html"><i class="fa fa-bullhorn"></i> <span>Fontawesome</span></a></li>--%>

        </ul>
        <!--sidebar nav end-->

    </div>
</div>
