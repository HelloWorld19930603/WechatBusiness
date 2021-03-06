<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<link href="<%=path%>/css/animate.min.css" rel="stylesheet">
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="index.do"><div class="dv">GRI-KRITY</div></a>
    </div>

    <div class="logo-icon text-center">
        <a href="index.do"><img src="<%=path%>/images/home/login_logo.jpg" alt="" width="40px" height="40px"></a>
    </div>
    <!--logo and iconic logo end-->

    <div class="left-side-inner">

        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="index"><a href="index.do"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <li class="menu-list"><a href=""><i class="fa fa-users"></i> <span>经销商</span></a>
                <ul class="sub-menu-list">
                    <li class="dealer1"><a href="/dealer1.do"> 格丽缇经销商</a></li>
                    <li class="dealer2"><a href="/dealer2.do"> Utomorrow经销商</a></li>
                    <li class="dealer3"><a href="/dealer3.do"> Pslady经销商</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-file-text"></i> <span>订单</span></a>
                <ul class="sub-menu-list">
                    <li class="order"><a href="/order.do"> 订单管理</a></li>
                    <%--<li class=""><a href="/order.do"> 物流查询</a></li>
                    <li class=""><a href="/order.do"> 扫码发货</a></li>--%>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-legal"></i> <span>审核</span></a>
                <ul class="sub-menu-list">
                    <li class="rechargeAudit"><a href="/rechargeAudit.do"> 充值审核</a></li>
                    <li class="agent"><a href="/agent.do"> 代理审核</a></li>
                    <li class="agentUpgrade"><a href="/agentUpgrade.do"> 代理升级审核</a></li>
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
                    <li class="traceability"><a href="traceability.do"> 商品追溯</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-jpy"></i> <span>返利</span></a>
                <ul class="sub-menu-list">
                    <li class="rebate1"><a href="/rebate1.do"> 格丽缇返利</a></li>
                    <li class="rebate2"><a href="/rebate2.do"> Utomorrow返利</a></li>
                    <li class="rebate3"><a href="/rebate3.do"> Pslady返利</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>学院</span></a>
                <ul class="sub-menu-list">
                    <li class="college"><a href="/college.do"> 学院详情</a></li>
                    <li class="addCollege"><a href="/addCollege.do"> 添加素材</a></li>
                </ul>
            </li>
         <%--   <li><a href="fontawesome.html"><i class="fa fa-bullhorn"></i> <span>Fontawesome</span></a></li>--%>
            <li class="system"><a href="system.do"><i class="fa fa-cogs"></i> <span>系统管理</span></a></li>
        </ul>
        <!--sidebar nav end-->

    </div>
</div>
