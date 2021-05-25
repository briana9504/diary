<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="pcoded-navbar">
     <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
     <div class="pcoded-inner-navbar main-menu">
         <div class="">
             <div class="main-menu-header">
                 <div class="user-details">
                     <span>${sessionMember.memberId}</span>       
                 </div>
             </div>
         </div>
        
         <div class="pcoded-navigatio-lavel" data-i18n="nav.category.navigation">메뉴</div>
         <ul class="pcoded-item pcoded-left-item">
             <li class="">
                 <a href="${pageContext.request.contextPath}/login">
                     <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                     <span class="pcoded-mtext" data-i18n="nav.dash.main">home</span>
                     <span class="pcoded-mcaret"></span>
                 </a>
             </li>
             <li class="">
                 <a href="${pageContext.request.contextPath}/auth/diary">
                     <span class="pcoded-micon"><i class="ti-calendar"></i><b>a</b></span>
                     <span class="pcoded-mtext" data-i18n="nav.dash.main">다이어리</span>
                     <span class="pcoded-mcaret"></span>
                 </a>
             </li>
             <li class="">
                 <a href="${pageContext.request.contextPath}/auth/logout">
                     <span class="pcoded-micon"><i class="ti-layout-sidebar-left"></i><b>a</b></span>
                     <span class="pcoded-mtext" data-i18n="nav.dash.main">로그아웃</span>
                     <span class="pcoded-mcaret"></span>
                 </a>
             </li>
             <li class="">
                 <a href="${pageContext.request.contextPath}/auth/removeMember">
                     <span class="pcoded-micon"><i class="ti-power-off"></i><b>a</b></span>
                     <span class="pcoded-mtext" data-i18n="nav.dash.main">회원탈퇴</span>
                     <span class="pcoded-mcaret"></span>
                 </a>
             </li>
             
         </ul>
     </div>
 </nav>