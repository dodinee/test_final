<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../header/index.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>We Go - 메인페이지</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="main/ico/favicon.ico" type="image/x-icon" />
<link rel="icon" href="main/ico/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="main/css/header.css" type="text/css" />
<link rel="stylesheet" href="main/css/index.css" type="text/css" />
<script src="main/js/header.js" type="text/javascript" defer></script>
</head>
<body>
	
	<div class="container">
		<div class="rank">
			<h2>Rank</h2>
			<div class="rankers">
				<!-- 한우물왕 -->
				<div class="deep-king">
					<h3 class="title">한우물왕</h3>
					<div class="ranker-img">
						<div class="king-img"></div>
						<div class="mountain-img"></div>
					</div>
				</div>
				<!-- 제일높왕 -->
				<div class="high-king">
					<h3 class="title">제일높왕</h3>
					<div class="ranker-img">
						<div class="king-img"></div>
						<div class="mountain-img"></div>
					</div>
				</div>
				<!-- 참대왕 -->
				<div class="true-king">
					<h3 class="title">참대왕</h3>
					<div class="ranker-img">
						<div class="king-img"></div>
						<div class="mountain-img"></div>
					</div>
				</div>
				<!-- 후기왕 -->
				<div class="review-king">
					<h3 class="title">후기왕</h3>
					<div class="ranker-img">
						<div class="king-img"></div>
						<div class="mountain-img"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="mountain-info">
			<h2>❤️ 산 ❤️</h2>
			<div class="wrap">
				<c:forEach items="${listS}" var="s">
					<div class="item">
						<img src="main/img/gray.png" alt="img" />
						<h3 id="mountainName">${s.name }</h3>
						<p id="text">${s.reason}</p>
						<form action="#" method="get">
							<button type="submit" name="favorite" value="true"
								class="favorite"></button>
							<span class="favorite-count">${s.likeCnt}</span>
						</form>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="recruit">
			<h2>❤️ 모집 글 ❤️</h2>
			<div class="wrap">
				<c:forEach items="${listP}" var="p">
					<div class="item">
						<div class="user-info">
							<img src="main/img/gray.png" alt="img" /> <span id="userName">${p.nickname }</span>
						</div>
						<hr />
						<p id="title">${p.title}</p>
						<img src="main/img/gray.png" alt="img" />
						<div class="recruit-data">
							<h3 id="mountainName">${p.sanName}</h3>
							<p>
								날짜: <span id="date"><fmt:formatDate pattern="yy-MM-dd"
									value="${p.partyYmd}"></fmt:formatDate></span>
							</p>
							<p>
								시간: <span id="time"><fmt:formatDate pattern="HH:mm"
									value="${p.partyTime}"></fmt:formatDate></span>
							</p>
							<p>
								참여 인원: <span id="memberCount">${p.userCnt}/${p.partyMax}</span>
							</p>
						</div>
						<form action="#" method="get">
							<button type="submit" name="favorite" value="true"
								class="favorite"></button>
							<span class="favorite-count">${p.likeCnt }</span>
						</form>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="review">
			<h2>❤️ 후기 글 ❤️</h2>
			<div class="wrap">
				<c:forEach items="${listR}" var="r">
					<div class="item">
						<div class="top-info">
							<div class="user-info">
								<img src="main/img/gray.png" alt="img" /> <span id="userName">${r.nickname}</span>
							</div>
							<span id="mountainName">${r.sanName}</span>
						</div>
						<hr />
						<img src="main/img/gray.png" alt="img" />
						<p id="title">${r.title }</p>
						<p id="text">${r.contents }</p>
						<div class="bottom-info">
							<form action="#" method="get">
								<button type="submit" name="favorite" value="true"
									class="favorite"></button>
								<span class="favorite-count">${r.likeCnt }</span>
							</form>
							<span id="date"><fmt:formatDate pattern="yy-MM-dd HH:mm"
									value="${n.createdDt}"></fmt:formatDate></span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
