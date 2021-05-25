<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>login </title>
    <!-- HTML5 Shim and Respond.js IE9 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="CodedThemes">
    <meta name="keywords" content=" Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
    <meta name="author" content="CodedThemes">
    <!-- Favicon icon -->
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon">
    <!-- Google font-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800" rel="stylesheet">
    <!-- Required Fremwork -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap/css/bootstrap.min.css">
    <!-- themify-icons line icon -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/icon/themify-icons/themify-icons.css">
    <!-- ico font -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/icon/icofont/css/icofont.css">
    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/jquery.mCustomScrollbar.css">
</head>
<body>
<!-- 로그인 전: 로그인, 회원가입만 있음 -->
<c:if test="${sessionMember == null}">
	
    <section class="login p-fixed d-flex text-center bg-primary common-img-bg">
        <!-- Container-fluid starts -->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <!-- Authentication card start -->
                    <div class="login-card card-block auth-body mr-auto ml-auto">
                        <form action="${pageContext.request.contextPath}/login" method="post" class="md-float-material">
                            <div class="text-center">
                                <img src="assets/images/auth/logo-dark.png" alt="logo.png">
                            </div>
                            <div class="auth-box">
                                <div class="row m-b-20">
                                    <div class="col-md-12">
                                        <h3 class="text-left txt-primary">로그인</h3>
                                    </div>
                                </div>
                                <hr/>
	                                <div class="input-group">
	                                    <input type="email" name="memberId" class="form-control" placeholder="Your Email Address">
	                                    <span class="md-line"></span>
	                                </div>
	                                <div class="input-group">
	                                    <input type="password"  name="memberPw" class="form-control" placeholder="Password">
	                                    <span class="md-line"></span>
	                                </div>                
	                                <div class="row m-t-25 text-left">
	                                    <div class="col-sm-7 col-xs-12">
	                                        
	                                    </div>
	                                    <div class="col-sm-5 col-xs-12 forgot-phone text-right">
	                                        <a href="${pageContext.request.contextPath}/addMember" class="text-right f-w-600 text-inverse"> 회원가입</a>
	                                    </div>
	                                </div>
	                                <div class="row m-t-30">
	                                    <div class="col-md-12">
	                                        <button type="submit" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">로그인</button>
	                                    </div>
	                                </div>
                     
                                <hr/>
                                <div class="row">
                                    <div class="col-md-10">
                                        <p class="text-inverse text-left m-b-0"><b>Thank you and enjoy Diary.</b></p>
                                    </div>
                                    <div class="col-md-2">
                                        <img src="assets/images/auth/Logo-small-bottom.png" alt="small-logo.png">
                                    </div>
                                </div>

                            </div>
                        </form>
                        <!-- end of form -->
                    </div>
                    <!-- Authentication card end -->
                </div>
                <!-- end of col-sm-12 -->
            </div>
            <!-- end of row -->
        </div>
        <!-- end of container-fluid -->
    </section>
</c:if>
<!-- 로그인 후 -->
<c:if test="${sessionMember != null}">
    
    <!-- Pre-loader end -->
    <div id="pcoded" class="pcoded">
        <div class="pcoded-overlay-box"></div>
        <div class="pcoded-container navbar-wrapper">
			<!-- 상단메뉴 -->
           <div>
				<jsp:include page="/WEB-INF/view/inc/topMenu.jsp"></jsp:include>
			</div>

            <div class="pcoded-main-container">
                <div class="pcoded-wrapper">
                	<!-- side 메뉴 -->
		            <div>
						<jsp:include page="/WEB-INF/view/inc/sideMenu.jsp"></jsp:include>
					</div>
                    <div class="pcoded-content">
                        <div class="pcoded-inner-content">

                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-header start -->
                                    <div class="page-header card">
                                        <div class="row align-items-end">
                                            <div class="col-lg-8">
                                                <div class="page-header-title">
                                                    <div class="d-inline">
                                                        <h4>HOME</h4>
                                                        <span>${sessionMember.memberId} 님 반값습니다.</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="page-header-breadcrumb">
                                                    <ul class="breadcrumb-title">
                                                        <li class="breadcrumb-item">
                                                            <a href="index.html">
                                                                <i class="icofont icofont-home"></i>
                                                            </a>
                                                        </li>
                                                        <li class="breadcrumb-item"><a href="#!">Pages</a>
                                                        </li>
                                                        <li class="breadcrumb-item"><a href="#!">Sample page</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>
                            <div id="styleSelector">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<div class="fixed-button">
		<a href="https://codedthemes.com/item/guru-able-admin-template/" target="_blank" class="btn btn-md btn-primary">
		  <i class="fa fa-shopping-cart" aria-hidden="true"></i> Upgrade To Pro
		</a>
	</div>
</c:if>
  
    <!-- Warning Section Ends -->
    <!-- Required Jquery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/popper.js/popper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap/js/bootstrap.min.js"></script>
    <!-- jquery slimscroll js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-slimscroll/jquery.slimscroll.js"></script>
    <!-- modernizr js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/modernizr/modernizr.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/modernizr/css-scrollbars.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/common-pages.js"></script>
	 <!-- classie js -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/classie/classie.js"></script>
	<!-- Custom js -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/script.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/pcoded.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/demo-12.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
</body>

</html>
