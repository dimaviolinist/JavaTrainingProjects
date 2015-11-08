

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/jsp-decorator.tld" prefix="decorator"%>
<!DOCTYPE html >
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><decorator:placeholder name='title'/></title>	

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/css/shop-homepage.css" rel="stylesheet" type="text/css">
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Yo Shop</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a href="test.jsp">About</a>
                    </li>
                    <li>
                        <a href="#">Account</a>
                    </li>
                    <li>
                        <a href="#">Contact us</a>
                    </li>
                    <li>
                        <a href="#">Languages: en</a>
                    </li>
                    <li>
                        <a href="#">Card: 0 items</a>
                    </li>
                    <li>
                        <a href="login.jsp">Login/Registration</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">   

        <div class="row">
            <div class="col-md-3">
                <a  href="index.jsp">
                	<img width="171" height="73" alt="" src="${pageContext.request.contextPath}/images/logo.jpg">
				</a>
				 <!-- CATEGORIES -->
                <div class="list-group">
                    <a href="#" class="list-group-item">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>
                </div>
            </div>

            <div class="col-md-9">  
            <!-- CENTER -->              

                <div class="container">	                	 
					<decorator:placeholder name="content"/>
					
<!--                     <div class="col-sm-2 col-lg-2 col-md-2"> -->
<!--                         <div class="thumbnail"> -->
<!--                             <img src="http://placehold.it/320x150" alt=""> -->
<!--                             <div class="caption"> -->
<!--                                 <h4 class="pull-right">$94.99</h4> -->
<!--                                 <h4><a href="#">Fifth Product</a> -->
<!--                                 </h4> -->
<!--                                 <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p> -->
<!--                             </div>        -->
<!--                         </div> -->
<!--                     </div> -->
                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->


    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>

</html>