<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>Modal Window</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="login-out-check/modal-window.css" type="text/css"/>
    <script src="login-out-check/modal-window.js" type="text/javascript" defer></script>
  </head>
  <body>
    <!-- test button -->
    <button type="button" class="test">로그인</button>
<!--     <p>
      최초 1회 클릭 시 쿼리스트링 확인<br />
      두번째 클릭부터는 js로 이벤트 조작
    </p> -->
    <!-- logout -->
    <div class="modal-window">
      <p id="text">
        로그인이 필요합니다.<br />
        로그인하시겠습니까?
      </p>
      <form action="#" class="bunttons">
        <button type="reset" class="cancle">취소</button>
        <button type="submit" name="logout">로그인</button>
        <!-- 이거 취소면 그냥 닫는거니까 로그인클릭만 a태그로 보내버리기 되나? -->
      </form>
    </div>
  </body>
</html>
