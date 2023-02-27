<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script src="js/report.js" type="text/javascript" defer></script>
	<link rel="stylesheet" href="css/report.css" type="text/css" />
    <title>Document</title>
    
  </head>
  <body>
    <form action="#" method="post">
      <div class="container">
        <ul class="reasons">
          <li class="title">신고 사유 선택</li>
          <li class="check">
              <input type="radio" name="check" value="스팸" id="r1" />
              <label for="r1" class="reason">스팸 / 홍보글 입니다.</label>
              <span>✓</span>
          </li>
          <li class="check">
            <input type="radio" name="check" value="불법" id="r2" />
            <label for="r2" class="reason">불법 정보를 포함하고 있습니다.</label>
            <span>✓</span>
          </li>
          <li class="check">
            <input type="radio" name="check" value="음란물" id="r3" />
            <label for="r3" class="reason">음란물 / 청소년에게 유해한 내용입니다.</label>
            <span>✓</span>
          </li>
          <li class="check">
            <input type="radio" name="check" value="혐오" id="r4" />
            <label for="r4" class="reason">욕설 / 생명경시 / 혐오 표현입니다.</label>
            <span>✓</span>
          </li>
          <li class="check">
            <input type="radio" name="check" value="개인정보" id="r5" />
            <label for="r5" class="reason">개인정보 노출 게시물입니다.</label>
            <span>✓</span>
          </li>
        </ul>
        <div class="btn">
          <button type="submit" class="cancle" value="cancle">취소</button>
          <button type="submit" class="report" value="report">신고</button>
        </div>
      </div>
    </form>
    
  </body>
</html>
    