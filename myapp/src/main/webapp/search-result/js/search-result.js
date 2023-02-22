const mountainInfo = $(".mountain-info .wrap");
const recruit = $(".recruit .wrap");
const review = $(".review .wrap");

/**
 * @param {String} itemTitle - 제목
 * @param {String} itemContent - 내용
 * @param {String} itemImgPath - 이미지 경로
 * @param {String} itemPath - 상세페이지 경로
 * @returns
 */
const item = (title, content, imgPath, movePath) => ` 
<div class="item">
<a id="itemPath" href="${movePath}">
  <div class="item-info">
    <h3 id="itemTitle">${title}</h3>
    <div class="itemDetail">
      <p id="itemContent">
      ${content}
      </p>
      <img id="itemImg" src="${imgPath}" alt="img" />
    </div>
  </div>
</a>
</div>
`;

// Test Code

const {title, context, imgPath, movePath} = {
  title: "한라산",
  context: "대한민국에서 가장 큰 섬인 제주도에 있으며 대한민국의 실효 지배 영토 내의 최고봉이자 가장 높은 산(해발 1,947m). 대한민국의 국립공원 중 하나다. 국립공원 전역이 유네스코 세계유산으로 지정되었다. 그리고 대한민국의 실효지배 영토 내 해상 활화산이다. 이름을 풀이하면 운한(雲漢: 은하수, 또는 높은 하늘)을 당긴다(拏)는 뜻으로 은하수를 붙잡을 정도로 높은 산이라는 뜻이다. 금강산, 지리산과 함께 대한민국 삼신산(三神山) 중 하나로 꼽힌다.",
  imgPath: "https://w.namu.la/s/f553141bf9eb9cc4f8ef70ba366cc8975303129cae0b29915dc4a052a5f9c6289d8582b327f27e3a308a6cd6b94a12852b563d32b79a7a71b06455d8d1131f09ac3df03ba236afaf4787643e67fbc9fca6ae8cf8df6533071a955023a51bf0c8e3be973ff2f514077df78a6719793041",
  movePath: "#"
}

for (let i = 0; i < 3; i++) {
  mountainInfo.innerHTML += item(title, context, imgPath, movePath);
} // for