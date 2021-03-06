<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <nav class="navbar header-navbar pcoded-header">
      <div class="navbar-wrapper">

          <div class="navbar-logo">
              <a class="mobile-menu" id="mobile-collapse" href="#!">
                  <i class="ti-menu"></i>
              </a>
              <a class="mobile-search morphsearch-search" href="#">
                  <i class="ti-search"></i>
              </a>
              <a href="${pageContext.request.contextPath}/login">
              	&nbsp;&nbsp;&nbsp;&nbsp;<img class="img-fluid" src="${pageContext.request.contextPath}/assets/images/diaryW.png" alt="Theme-Logo" />
              </a>
              <a class="mobile-options">
                  <i class="ti-more"></i>
              </a>
          </div>

          <div class="navbar-container container-fluid">
              <ul class="nav-left">
                  <li>
                      <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a></div>
                  </li>
                  
                  <li>
                      <a href="#!" onclick="javascript:toggleFullScreen()">
                          <i class="ti-fullscreen"></i>
                      </a>
                  </li>
              </ul>
               <ul class="nav-right">
                  
              	<li class="user-profile header-notification">
                      <a href="#!">
                          <span>${sessionMember.memberId}</span>
                          <i class="ti-angle-down"></i>
                      </a>
                      <ul class="show-notification profile-notification">
                         
                          <li>
                              <a href="${pageContext.request.contextPath}/auth/modifyMember">
                                  <i class="ti-lock"></i> 비밀번호 수정
                              </a>
                          </li>
                          <li>
                              <a href="${pageContext.request.contextPath}/auth/logout">
                                  <i class="ti-layout-sidebar-left"></i> Logout
                              </a>
                          </li>
                      </ul>
                  </li>
              </ul>
          </div>
      </div>
  </nav>