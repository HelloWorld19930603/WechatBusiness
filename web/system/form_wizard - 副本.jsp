<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@include file="common/path.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>Form Wizard</title>

  <link href="css/style.css" rel="stylesheet">
  <link href="css/jquery.stepy.css" rel="stylesheet">
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
    <div class="main-content" >

        <!-- header section start-->
        <!-- header section end-->

        <!-- page heading start-->
        <div class="page-heading">
            <h3>
                Form Wizard
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">Forms</a>
                </li>
                <li class="active">Form Wizard</li>
            </ul>
        </div>
        <!-- page heading end-->
        <hr/>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-md-12">
                    <div class="square-widget">
                        <div class="widget-container">
                            <div class="stepy-tab">
                            </div>
                            <form id="default" class="form-horizontal">
                                <fieldset title="Initial Info">
                                    <legend>Personal Information</legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Full Name</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Full Name" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Email Address</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Email Address" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">User Name</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Username" class="form-control">
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset title="Contact Info">
                                    <legend>Contact Details</legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Phone</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Phone" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Mobile</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Mobile" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Address</label>
                                        <div class="col-md-6 col-sm-6">
                                            <textarea rows="5" cols="60" class="form-control"></textarea>
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset title="Billing Details">
                                    <legend>Billing Details</legend>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Billing Name 1</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Billing Name 1" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Billing Name 2</label>
                                        <div class="col-md-6 col-sm-6">
                                            <input type="text" placeholder="Billing Name 2" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-2 col-sm-2 control-label">Status</label>
                                        <div class="col-md-6 col-sm-6">
                                            <textarea rows="5" cols="60" class="form-control"></textarea>
                                        </div>
                                    </div>
                                </fieldset>
                                <fieldset title="Final Step">
                                    <legend>Final Step Information</legend>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <p>Congratulations This is the Final Step</p>
                                        </div>
                                    </div>
                                </fieldset>
                                <button class="btn btn-info finish">
                                    Finish </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h4 class="fw-title">Form Wizard with Validation</h4>
                    <div class="box-widget">
                        <div class="widget-head clearfix">
                            <div id="top_tabby" class="block-tabby pull-left">
                            </div>
                        </div>
                        <div class="widget-container">
                            <div class="widget-block">
                                <div class="widget-content box-padding">
                                    <form id="stepy_form" class=" form-horizontal left-align form-well">
                                        <fieldset title="Step 1">
                                            <legend>description one</legend>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">Username</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" name="name" type="text"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">Email Address</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" name="email" type="email"/>
                                                </div>
                                            </div>
                                        </fieldset>
                                        <fieldset title="Step 2">
                                            <legend>description two</legend>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">First Name</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input type="text" placeholder="First Name" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">Last Name</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input type="text" placeholder="Last Name" class="form-control">
                                                </div>
                                            </div>
                                        </fieldset>
                                        <fieldset title="Step 3">
                                            <legend>description three</legend>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">Text Input</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <input type="text" placeholder="Text Input" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">Checkbox</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <label class="checkbox">
                                                        <input type="checkbox" value="">
                                                        Option one is this and that—be sure to include why it's great </label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-2 col-sm-2 control-label">Radio</label>
                                                <div class="col-md-6 col-sm-6">
                                                    <label class="radio">
                                                        <input type="radio" name="optionsRadios" value="option1" checked>
                                                        Option one is this and that—be sure to include why it's great </label>
                                                </div>
                                            </div>
                                        </fieldset>
                                        <button type="submit" class="finish btn btn-info btn-extend"> Finish!</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer class="sticky-footer">
            2014 &copy; AdminEx by ThemeBucket
        </footer>
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

<script>
    /*=====STEPY WIZARD====*/
    $(function() {
        $('#default').stepy({
            backLabel: 'Previous',
            block: true,
            nextLabel: 'Next',
            titleClick: true,
            titleTarget: '.stepy-tab'
        });
    });
    /*=====STEPY WIZARD WITH VALIDATION====*/
    $(function() {
        $('#stepy_form').stepy({
            backLabel: 'Back',
            nextLabel: 'Next',
            errorImage: true,
            block: true,
            description: true,
            legend: false,
            titleClick: true,
            titleTarget: '#top_tabby',
            validate: true
        });
        $('#stepy_form').validate({
            errorPlacement: function(error, element) {
                $('#stepy_form div.stepy-error').append(error);
            },
            rules: {
                'name': 'required',
                'email': 'required'
            },
            messages: {
                'name': {
                    required: 'Name field is required!'
                },
                'email': {
                    required: 'Email field is requerid!'
                }
            }
        });
    });
</script>

</body>
</html>
