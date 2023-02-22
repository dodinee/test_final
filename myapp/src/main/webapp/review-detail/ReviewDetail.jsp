<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include> --%>
<jsp:include page="../header/index.jsp"></jsp:include>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="review-detail/js/header.js" defer></script>
<script src="review-detail/js/default.js" defer></script>
<script src="review-detail/js/review-detail.js" defer></script>
<link rel="stylesheet" href="review-detail/css/default.css"
	type="text/css" />
<link rel="stylesheet" href="review-detail/css/index.css"
	type="text/css" />
<link rel="stylesheet" href="review-detail/css/reviewDetail.css?After"
	type="text/css" />

<!-- <script type="text/javascript">
	$(document).ready(
			function() {

				$(".hide").hide();

				$("#increaseRecommends").click(
						function() {

							var form = $("#increaseRecommendsForm");

							form.attr("method", "POST");
							form.attr("action",
									"<c:url value="/increaseRecommends" />");

							form.submit();
						});

				$("#writeReplyBtn").click(function() {
					var form = $("#writeReplyForm");

					form.attr("method", "POST");
					form.attr("action", "<c:url value="/doWriteReply" />");

					form.submit();

				});

				/*새로 생긴 엘리먼트에 접근하는 방법*/
				$("body").on("click", "#writeReplyBtn", function() {
					var form = $("#writeReplyForm");

					form.attr("method", "POST");
					form.attr("action", "<c:url value="/doWriteReply" />");

					form.submit();

				});

				$(".writeReReply").click(
						function() {
							// 현재 클릭한 것(this)의 부모, 부모, 부모 하면은 table이 나온다.
							var table = $(this).parent().parent().parent();

							var groupId = table.children(":eq(1)").children(
									":eq(0)").html();
							var parentReplyId = table.children(":eq(1)")
									.children(":eq(1)").html();
							var depth = table.children(":eq(2)").children(
									":eq(0)").html();
							var orderNo = table.children(":eq(2)").children(
									":eq(1)").html();
							var replyId = table.children(":eq(3)").children(
									":eq(0)").html();

							$("#depth").val(parseInt(depth) + 1);
							$("#parentReplyId").val(replyId);
							$("#groupId").val(groupId);
							$("#orderNo").val(orderNo);
							$("#replyId").val(replyId);

							var form = $("#formWrapper").html();
							$("#formWrapper").detach();

							/*댓글달기 눌렀다가 다른 댓글달기 눌렀을 때 활성화*/
							if (form == undefined) {
								$(".formAppender").each(function(index, data) {
									if (data.innerHTML != "") {
										form = data.innerHTML;
									}
								});
								$(".formAppender").html("");
							}

							var formAppender = table.parent().parent()
									.children(":eq(1)");
							formAppender.html(form);
							formAppender.show();
						});

			});
</script> -->
</head>


<body>

	<div class="container">
		<div class="header">
			<div class="mnt">🌱 ${r.sanName} 🌱</div>
			<div class="title">️${r.title}</div>
			<div class="dt">
				<fmt:formatDate pattern="MM-dd HH:mm" value="${r.createdDt}"></fmt:formatDate>
			</div>
		</div>
		<div class="contents">
			<img
				src="data:image/jpeg;base64,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"
				alt="" class="userpic" />
			<div class="username">${r.nickname}</div>
			<div class="like">
				<input type="button" />♥︎
			</div>
			<div class="content">${r.contents}</div>
		</div>
		<div class="cnt">댓글 (${listC.size()})</div>
		<c:forEach items="${listC}" var="c">
			<div class="cmtcontainer">
				<c:choose>
					<c:when test="${c.mentionCd != 0}">
						<div class="comments mention">
					</c:when>
					<c:otherwise>
						<div class="comments">
					</c:otherwise>
				</c:choose>
				<div class="cmtuser">${c.nickname }</div>
				<div class="cmtdate">
					<fmt:formatDate pattern="MM-dd HH:mm" value="${c.createdDt}"></fmt:formatDate>
				</div>
				<div class="btns">
					<input type="submit" name="modify" value="수정" /> <input
						type="submit" name="delete" value="삭제" /> <input type="submit"
						name="report" value="신고" />
				</div>
				<div class="comment">${c.contents}</div>
				<div class="mentionbtn">
					<input type="submit" name="mention" value="↪︎답글달기" />
				</div>
			</div>
	</div>
				<!-- 실험  -->
				<c:if test="${c.mentionCd == 0}">
				<div class="mentionwrite">
				<div class="cmtwrite">
					<textarea  name="contents"></textarea>
					<input type="button" value="등록" id="insert"> 
					<input type="reset" value="취소" id="cancle">
				</div>
				</div>
					</c:if>
				<!-- 실험  -->
	</c:forEach>
	<form action="/InsertComment" method="POST">
		<input type="hidden" name="targetGb" value="SAN_REVIEW"> <input
			type="hidden" name="targetCd" value="${r.sanReviewCd}"> <input
			type="hidden" name="userCd" value="${sessionScope.sessionId}">
		<div class="cmtwrite">
			<textarea name="contents"></textarea>
			<input type="submit" value="등록" id="insert"> <input
				type="reset" value="취소" id="cancle">
		</div>
	</form>
	</div>
</body>

</html>
