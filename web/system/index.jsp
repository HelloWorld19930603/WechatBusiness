<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title>AdminX</title>

    <!--common-->
    <link href="<%=path%>/css/style.css" rel="stylesheet">
    <link href="<%=path%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=path%>/css/systemcss.css" rel="stylesheet">


    <link rel="stylesheet" type="text/css" media="screen" href="<%=path%>/css/jquery-ui.css" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=path%>/js/html5shiv.js"></script>
    <script src="<%=path%>/js/respond.min.js"></script>
    <![endif]-->
</head>

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

            <section class="panel">
                <div class="panel-body">
                    <form class="form-horizontal adminex-form" method="get">
                            <label class="col-sm-1 control-label" for="inputSuccess">Input</label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="inputSuccess">
                            </div>
                            <label class="col-sm-1 control-label" for="inputWarning">Input</label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="inputWarning">
                            </div>
                            <label class="col-sm-1 control-label" for="inputError">Input</label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="inputError">
                            </div>
                        <label class="col-sm-1 control-label" >Input</label>

                    </form>
                </div>


            </section>



                <div class="row">
                    <div class="col-sm-12">
                        <section class="panel">
                            <header class="panel-heading">
                                Editable Table
                                <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                     </span>
                            </header>
                            <div class="panel-body">
                                <div class="adv-table editable-table ">
                                    <div class="clearfix">
                                        <div class="btn-group">
                                            <button id="editable-sample_new" class="btn btn-primary">
                                                Add New <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                        <div class="btn-group pull-right">
                                            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
                                            </button>
                                            <ul class="dropdown-menu pull-right">
                                                <li><a href="#">Print</a></li>
                                                <li><a href="#">Save as PDF</a></li>
                                                <li><a href="#">Export to Excel</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="space15"></div>
                                    <table class="table table-striped table-hover table-bordered" id="editable-sample">
                                        <thead>
                                        <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Points</th>
                                            <th>Status</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr class="">
                                            <td>Jonathan</td>
                                            <td>Smith</td>
                                            <td>3455</td>
                                            <td class="center">Lorem ipsume</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Mojela</td>
                                            <td>Firebox</td>
                                            <td>567</td>
                                            <td class="center">new user</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Akuman </td>
                                            <td> Dareon</td>
                                            <td>987</td>
                                            <td class="center">ipsume dolor</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Theme</td>
                                            <td>Bucket</td>
                                            <td>342</td>
                                            <td class="center">Good Org</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Jhone</td>
                                            <td> Doe</td>
                                            <td>345</td>
                                            <td class="center">super user</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Margarita</td>
                                            <td>Diar</td>
                                            <td>456</td>
                                            <td class="center">goolsd</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Jhon Doe</td>
                                            <td>Jhon Doe </td>
                                            <td>1234</td>
                                            <td class="center"> user</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Helena</td>
                                            <td>Fox</td>
                                            <td>456</td>
                                            <td class="center"> Admin</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Aishmen</td>
                                            <td> Samuel</td>
                                            <td>435</td>
                                            <td class="center">super Admin</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>dream</td>
                                            <td>Land</td>
                                            <td>562</td>
                                            <td class="center">normal user</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>babson</td>
                                            <td> milan</td>
                                            <td>567</td>
                                            <td class="center">nothing</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>
                                        <tr class="">
                                            <td>Waren</td>
                                            <td>gufet</td>
                                            <td>622</td>
                                            <td class="center">author</td>
                                            <td><a class="edit" href="javascript:;">Edit</a></td>
                                            <td><a class="delete" href="javascript:;">Delete</a></td>
                                        </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>

            <div class="xuanzhe_tj">
                <form action=""
                      method="post" name="form1" id="form1">
                    <ul class="clear">
                        <li>基地编号:</li>
                        <li><input type="text" size="10" class="ppname" id="bh"
                                   value="${bh}" name="bh" /></li>
                        <li>所在企业:</li>
                        <li><input type="text" size="10" class="ppname" id="en_name"
                                   value="${en_name}" name="en_name" /></li>
                        <li>基地状态:</li>
                        <li>
                            <select id="status" name="status" style="width: 100px">
                                <option value="">--请选择--</option>
                                <option value="9" <c:out value="${status=='9'?'selected':''}"/>>禁用</option>
                                <option value="1" <c:out value="${status=='1'?'selected':''}"/>>启用</option>
                            </select>
                        </li>
                        <li><input type="button" class="chax" value="" /></li>
                        <li><input type="button" class="tianj"></li>
                        <li><input type="button" class="removeBtn" value="" /></li>
                        <li><input type="hidden" name="pageIndex" id="pageIndex" />
                            <input type="hidden" name="en_id" id="en_id" value="${en_id}"/>
                        </li>
                    </ul>
                </form>
            </div>

            <div class="xianbo">
                <div class="biaoge" style="height: 600px;">
                    <table cellpadding="0" cellspacing="1" width="100%" bgcolor="#b2d3f6">
                        <thead>
                        <tr>
                            <th bgcolor="#eff0f3" style="width:30px;"><input type="checkbox"  id="checkAll"/></th>
                            <th bgcolor="#eff0f3" height="36">序号</th>
                            <th bgcolor="#eff0f3">所在企业</th>
                            <th bgcolor="#eff0f3">基地编号</th>
                            <th bgcolor="#eff0f3">基地名称</th>
                            <th bgcolor="#eff0f3">基地类型</th>
                            <th bgcolor="#eff0f3">基地状态</th>
                            <th bgcolor="#eff0f3">操作</th>
                        </tr>
                        </thead>
                            <tr style="height:30px;" >
                                <td align="center"><input type="checkbox" name="ids" value="${v.id}"/></td>
                                <td align="center">${pager.pageIndex * pager.pageSize + s.index + 1}
                                    <input type="hidden" name="ids" value="${v.id}"/>
                                </td>
                                <td align="center">${v.en_name}</td>
                                <td align="center">${v.bh}</td>
                                <td align="center">${v.name}</td>
                                <td align="center">
                                    室内
                                </td>
                                <td align="center">
                                   启用
                                </td>
                                <td align="center">
                                    <img src="${pageContext.request.contextPath}/images/czuox1.jpg" class="modifyBtn" style="cursor: pointer;" title="点击进入修改基地信息"/>
                                  <img src="${pageContext.request.contextPath}/images/czuox3.jpg" class="removeOneBtn" style="cursor: pointer;" title="点击可禁用该基地"/>
                                </td>
                            </tr>
                        <tr style="height:30px;" >
                            <td align="center"><input type="checkbox" name="ids" value="${v.id}"/></td>
                            <td align="center">${pager.pageIndex * pager.pageSize + s.index + 1}
                                <input type="hidden" name="ids" value="${v.id}"/>
                            </td>
                            <td align="center">${v.en_name}</td>
                            <td align="center">${v.bh}</td>
                            <td align="center">${v.name}</td>
                            <td align="center">
                                室内
                            </td>
                            <td align="center">
                                启用
                            </td>
                            <td align="center">
                                <img src="${pageContext.request.contextPath}/images/czuox1.jpg" class="modifyBtn" style="cursor: pointer;" title="点击进入修改基地信息"/>
                                <img src="${pageContext.request.contextPath}/images/czuox3.jpg" class="removeOneBtn" style="cursor: pointer;" title="点击可禁用该基地"/>
                            </td>
                        </tr>
                    </table>

                </div>
                <div class="xiaobt"></div>
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
<script src="<%=path%>/js/jquery-1.10.2.min.js"></script>
<script src="<%=path%>/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="<%=path%>/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/modernizr.min.js"></script>
<script src="<%=path%>/js/jquery.nicescroll.js"></script>


<!--common scripts for all pages-->
<script src="<%=path%>/js/scripts.js"></script>

<!--data table-->
<script type="text/javascript" src="<%=path%>/js/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="<%=path%>/js/data-tables/DT_bootstrap.js"></script>

<!--script for editable table-->
<script src="<%=path%>/js/editable-table.js"></script>

<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
</body>
</html>
<script type="text/javascript">
    $(".${active}").addClass("active");
    $(".${active}").parents("li").addClass("active");

    $.ajax({
        type: "GET",
        url: "",
        dataType: "json",
        success: function (data) {
            if (data.success) {
                $("#createResult").html(data.msg);
            } else {
                $("#createResult").html("出现错误" + data.msg);
            }
        },
        error: function (jqXHR) {
            console.log("发生错误：" + jqXHR.status);
        }
    });
    jQuery(document).ready(function() {
        EditableTable.init();
    });
    $(document).ready(function () {
        $(".save").click(function () {
            alert("save");
        });
        $(".delete").click(function () {
            alert("delete");
        });
        $.messager.alert('提示:','请选择要删除的数据!','warning');
    })
</script>