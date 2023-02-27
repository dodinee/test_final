const mountainInfoTemplate = (mountainName, text, favoriteCount) => `
<div class="item">
<img src="./img/gray.png" alt="img" />
<h3 id="mountainName">${mountainName}</h3>
<p id="text">${text}</p>
<form action="#" method="get">
  <button
    type="submit"
    name="favorite"
    value="true"
    class="favorite"
  ></button>
  <span class="favorite-count">${favoriteCount}</span>
</form>
</div>`;

// 메인페이지 - 산정보, 모집, 후기 글 목록 위에서
// 휠 스크롤 시 가로 슬라이드 구현
$$(".mountain-info .wrap").addEventListener("wheel", (e) => {
  e.preventDefault();
  e.currentTarget.scrollLeft += e.deltaY;
});

$$(".recruit .wrap").addEventListener("wheel", (e) => {
  e.preventDefault();
  e.currentTarget.scrollLeft += e.deltaY * 2;
});

$$(".review .wrap").addEventListener("wheel", (e) => {
  e.preventDefault();
  e.currentTarget.scrollLeft += e.deltaY * 2;
});