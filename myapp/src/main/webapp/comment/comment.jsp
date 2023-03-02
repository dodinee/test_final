<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zerock.myapp.entity.Comment" %>
<%@page import= "java.util.List" %>
<%@page import= "java.util.ArrayList"%>
    
  <%
//   	List<Comment> listC = request.getParameter("listC");
//   	아 생각해보니까 이거 안되네..........
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items= var="c">
			<div class="cmtcontainer">
			
				<c:choose>
					<c:when test="${c.mentionCd == 0}">
						<div class="comments">
					</c:when>
					<c:otherwise>
						<div class="comments mention">
					</c:otherwise>
				</c:choose>
				
				<div class="cmtuser">${c.nickname }</div>
				<div class="cmtdate">
					<fmt:formatDate pattern="MM-dd HH:mm" value="${c.createdDt}"></fmt:formatDate>
				</div>
				<div class="btns">
					<input type="hidden" id= "targetComment" name="targetComment" value="${c.commentCd}">
					<input type="button" class="modifycmt" name="modifycmt" value="수정" /> 
					<input type="button" class="deletecmt" name="deletecmt" value="삭제" /> 
					<input type="button" class="reportcmt" name="reportcmt" value="신고" />
				</div>
				
				<div class="comment">${c.contents}</div>
				<c:if test="${c.mentionCd == 0}">
				<input type="button" class="mentionbtn" name="mentionbtn" value="↪ ︎답글" />
				</c:if>
				<div class="updatebtn">
					<input type="button" name="updatecls" value="취소" />
					<input type="button" name="updatecmt" value="수정" />
				</div>
			</div>
		</div>
	

				
		<!--  멘션 작성 폼  -->
		<c:if test="${c.mentionCd == 0}">
			<div class="mentionwrite">
				<div class="cmtwrite">
					<input type="hidden" id= "targetComment" name="targetComment" value="${c.commentCd}">
					<textarea  name="contents" placeholder="답글을 작성해주세요." required></textarea>
					<input type="button" value="등록" class="insert men"> 
					<input type="reset" value="취소" class="cancle">
				</div>
			</div>
		</c:if>			
	</c:forEach>
</body>
</html>