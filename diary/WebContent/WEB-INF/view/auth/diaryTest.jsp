<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>diary </title>
    <!-- HTML5 Shim and Respond.js IE9 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="description" content="CodedThemes">
    <meta name="keywords" content="flat ui, admin  Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
    <meta name="author" content="CodedThemes">
    <!-- Favicon icon -->
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon">
    <!-- Google font--><link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800" rel="stylesheet">
    <!-- Required Fremwork -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap/css/bootstrap.min.css">
    <!-- themify-icons line icon -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/icon/themify-icons/themify-icons.css">
    <!-- ico font -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/icon/icofont/css/icofont.css">
    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/jquery.mCustomScrollbar.css">
<style>
th{
	height: 40px;
	background: #F5A9BC;
	text-align: center;
	text-transform: uppercase;
	line-height: 20px;
	border: none !important;
	padding: 10px 6px;
	color: #fff;
	font-size: 13px;
}
td:hover{
	background: #FAFAFA;
}
td{
	height: 100px;
	width: 14%;
	
}

</style>
</head>

<body>
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
                                                        <h4>Diary</h4>
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
                                   
                                    <!-- Page-header end -->
									<c:set var="totalCell" value="${diaryMap.startBlank+diaryMap.endDay+diaryMap.endBlank}"></c:set>
									
									
                                    <div class="page-body">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>${diaryMap.currentYear}년 ${diaryMap.currentMonth+1}월</h5>
                                                        <span><a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.currentYear}&targetMonth=${diaryMap.currentMonth-1}">이전달</a>
		
																<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.currentYear}&targetMonth=${diaryMap.currentMonth+1}">다음달</a>
														</span>
                                                        <div class="card-header-right">
                                                            <ul class="list-unstyled card-option" style="width: 35px;">
                                                                <li class=""><i class="icofont icofont-simple-left"></i></li>
                                                                <li><i class="icofont icofont-maximize full-card"></i></li>
                                                                <li><i class="icofont icofont-minus minimize-card"></i></li>
                                                                <li><i class="icofont icofont-refresh reload-card"></i></li>
                                                                <li><i class="icofont icofont-error close-card"></i></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="card-block">
                                                            <table class="table">
																<tr><!-- i-diaryMap.startBlank: 전체셀에서 비어있는 셀을 빼고 0이하의 수는 보여주지 않는다. -->
																	<th>일</th>
																	<th>월</th>
																	<th>화</th>
																	<th>수</th>
																	<th>목</th>
																	<th>금</th>
																	<th>토</th>
																</tr>
																<tr>
																	<c:forEach var="i" begin="1" end="${totalCell}" step="1">
																		<c:set var="num" value="${i-diaryMap.startBlank}"></c:set>
																		<td>
																			<c:if test="${num > 0 && num <= diaryMap.endDay}"><!-- db에는 달을 +1해서 넘겨줘야한다. -->
																				<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.currentYear}&month=${diaryMap.currentMonth+1}&day=${num}">${num}</a>
																				<div>
																					<c:forEach var="todo" items="${diaryMap.todoList}">
																						<!-- todoDate와 num가 일치하면 일정을 보여준다. -->
																						<c:if test="${todo.todoDate == num}">
																							<div style="background-color:${todo.todoFontColor}">
																								<a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${todo.todoNo}">${todo.todoTitle}</a>
																							</div>
																							<!-- todoOne상세정보 - 수정 - 삭제 -->
																						</c:if>
																					</c:forEach>
																				</div>
																			</c:if>
																			<!-- 뒤에 비어있는 셀 -->
																			<c:if test="${num <= 0 || num > diaryMap.endDay}">
																				&nbsp;
																			</c:if>	
																		</td>
																		<!-- 일주일이 지나면 다음줄로 간다. -->
																		<c:if test="${i%7 == 0 }">
																			</tr><tr>
																		</c:if>
																	</c:forEach>
																	 
																</tr>
															</table>
                                                       
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <!-- dday -->
                                    <div class="page-body">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>Dday List</h5>
                                                        <div class="card-header-right">
                                                            <ul class="list-unstyled card-option" style="width: 35px;">
                                                                <li class=""><i class="icofont icofont-simple-left"></i></li>
                                                                <li><i class="icofont icofont-maximize full-card"></i></li>
                                                                <li><i class="icofont icofont-minus minimize-card"></i></li>
                                                                <li><i class="icofont icofont-refresh reload-card"></i></li>
                                                                <li><i class="icofont icofont-error close-card"></i></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="card-block">
                                                      <table class="table">
															<tr>
																<th>todoDate</th>
																<th>todoTile</th>
																<th>dday</th>
															</tr>
															<c:forEach var="m" items="${diaryMap.ddayList}">
																<tr>
																	<td class="dday">${m.todoDate}</td>
																	<td><a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${m.todoNo}">${m.todoTitle}</a></td>
																	<td>-${m.dday}</td>
																</tr>
															</c:forEach>
														</table>      
                                                       
                                                    </div>
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
<!-- classie js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/classie/classie.js"></script>
<!-- Custom js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/script.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/pcoded.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/demo-12.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
</body>

</html>
