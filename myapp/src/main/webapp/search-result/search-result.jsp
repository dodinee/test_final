

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>통합검색결과페이지</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="search-result/ico/favicon.ico"
	type="image/x-icon" />
<link rel="icon" href="search-result/ico/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="search-result/css/header.css" />
<link rel="stylesheet" href="search-result/css/search-result.css" />
<script src="search-result/js/header.js" type="text/javascript" defer></script>
<script src="search-result/js/search-result.js" type="text/javascript" defer></script>
</head>
<body>
	<!-- Top Menu -->
	<header>
		<!-- <div class="logo"> -->
			<a href="/IndexController">Wego</a>
		<!-- </div> -->
		<nav>
			<ul class="navbar">
				<li><a href="#">산정보</a></li>
				<li><a href="#">등산후기</a></li>
				<li><a href="#">랭킹</a></li>
				<li><a href="#">모집</a></li>
			</ul>
		</nav>
		<div class="user">
			<!-- 로그인 상태 => 현재 display: none; 상태 -->
			<img id="userImg" class="user-profile-img"
				src="https://picsum.photos/id/684/600/400" alt="회원 프로필 이미지" />
			<!-- 비로그인 상태 -->
			<button class="login-btn"></button>
			<div class="menubar">
				<ul>
					<li><a href="mypage/mypage.jsp">마이페이지</a></li>
					<li><a href="#">알림</a></li>
					<li><a href="#">문의하기</a></li>
					<li class="text-red"><a href="#">로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="search-bar">
			<form action="/SearchController" method="get">
				<button class="search-icon" type="submit"></button>
				<input type="text" name="q" id="search" value=""
					placeholder="Search" />
				<button class="cancel" type="reset"></button>
			</form>
		</div>
	</header>
	<!-- Contents -->
	<div class="container">
		<div class="out-line">
			<div class="mountain-info">
				<div class="info-title">
					<h2>❤️ 산 ❤️</h2>
					<a href="#" class="more">더보기</a>
				</div>
				<div class="wrap">
				<c:forEach items="${listS}" var="s">
				<div>${s.name}</div>
				<div>${s.reason}</div>
				<div>${s.overview}</div>
				<%-- <div>${s.details}</div> --%>
				</c:forEach>
				</div>
			</div>
			<hr />
			<div class="recruit">
				<div class="info-title">
					<h2>❤️ 모집 글 ❤️</h2>
					<a href="#" class="more">더보기</a>
				</div>
				<div class="wrap">
				<c:forEach items="${listP}" var="p">
				<div>${p.title}</div>
				<div>${p.contents}</div>
				</c:forEach>
				</div>
			</div>
			<hr />
			<div class="review">
				<div class="info-title">
					<h2>❤️ 후기 글 ❤️</h2>
					<a href="#" class="more">더보기</a>
				</div>
				<div class="wrap">
				<c:forEach items="${listR}" var="r">
				<div>${r.title}</div>
				<div>${r.contents}</div>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
