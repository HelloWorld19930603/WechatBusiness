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
            <li class="index"><a href="index.do"><i class="fa fa-home"></i> <span>Dashboard</span></a></li>
            <li class="menu-list"><a href=""><i class="fa fa-laptop"></i> <span>经销商</span></a>
                <ul class="sub-menu-list">
                    <li class="dealer1"><a href="/dealer1.do"> 格丽缇</a></li>
                    <li class="dealer2"><a href="/dealer2.do"> Utomorrow</a></li>
                    <li class="dealer3"><a href="/dealer3.do"> Pslady</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>广告</span></a>
                <ul class="sub-menu-list">
                    <li class="poster"><a href="/poster.do"> 广告管理</a></li>
                    <li><a href="buttons.html"> Buttons</a></li>

                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-cogs"></i> <span>商品</span></a>
                <ul class="sub-menu-list">
                    <li class="commodity"><a href="/commodity.do"> 商品管理</a></li>
                    <li><a href="gallery.html"> 添加商品</a></li>

                </ul>
            </li>

            <li><a href="fontawesome.html"><i class="fa fa-bullhorn"></i> <span>Fontawesome</span></a></li>

        </ul>
        <!--sidebar nav end-->

    </div>
</div>
