<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta name="format-detection" content="telephone=no" />
<link rel="shortcut icon" href="header/ico/favicon.ico"
	type="image/x-icon" />
<link rel="icon" href="header/ico/favicon.ico" type="image/x-icon" />
<title>We go - 메인페이지</title>
<script src="https://kit.fontawesome.com/c88236e4f3.js"
	crossorigin="anonymous"></script>
<!-- 외부 제이쿼리 연동 1. 최신버전 jquery / 2. jquery-migrate 플러그인-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
<script src="header/js/default.js" type="text/javascript"></script>
<script src="header/js/header.js" type="text/javascript" defer></script>
<link rel="stylesheet" href="header/css/default.css" type="text/css" />
<link rel="stylesheet" href="header/css/index.css" type="text/css" />
<link rel="stylesheet"
	media="( min-width:701px ) and ( max-width:1000px )"
	href="header/css/tablet.css" type="text/css" />
<link rel="stylesheet" media="( min-width:0px ) and ( max-width:700px )"
	href="header/css/mobile.css" type="text/css" />
</head>

<body>
	<header>
		<div class="left">
			<h1>
				<a href="/IndexController">Wego</a>
			</h1>
			<a href="#a" class="all">all Menu</a>
			<div class="nav">
				<h2>Menu</h2>
				<nav>
					<ul>
						<li><a href="#a">산정보</a></li>
						<li><a href="#a">등산후기</a></li>
						<li><a href="#a">랭킹</a></li>
						<li><a href="#a">모집</a></li>
						<li id="myPage"><a href="#a">마이페이지</a></li>
					</ul>
				</nav>
				<div>
					<a href="#a" class="FAQ2"><i
						class="fa-solid fa-headset fa-2x"></i></a>
				</div>
				<a href="#a" class="close">Close</a>
			</div>
		</div>
		<!-- 알림과 프로필 -->
		<ul>
			<li><a href="#a" class="bell"><img
					src="mypage/svg/bell-regular.svg" alt="알림" /></a></li>
			<!-- 로그인 전  -->
			<li class="join"><a href="modal-window/sign-in/sign-in.html">Sign In</a></li>
			<!-- 로그인 후  -->
			<!-- <span class="user">
            <img
              id="userImg"
              src="https://picsum.photos/id/684/600/400"
              alt=""
            />
            <span class="menubar">
              <ul>
                <li><a href="./mypage.html">마이페이지</a></li>
                <li><a href="#">알림</a></li>
                <li><a href="#">문의하기</a></li>
                <li class="text-red"><a href="#">로그아웃</a></li>
              </ul>
            </span>
          </span> -->
		</ul>
		<div class="dim"></div>
		<!-- 검색바 -->
		<div class="search-bar-tag">
			<div class="search-bar">
				<form action="/SearchController" method="post">
					<button class="search-icon" type="submit"></button>
					<input type="text" name="q" id="search" value=""
						placeholder="Search" />
					<button class="cancel" type="reset"></button>
				</form>
			</div>
		</div>
	</header>

</body>
</html>
</html>
