const $ = (selector) => document.querySelector(selector);

// test button click event
$(".test").addEventListener("click", () => {
  $(".modal-window").style.display = "flex";
});

// modal-window close event
$(".bunttons .cancle").addEventListener("click", () => {
  $(".modal-window").style.display = "none";
});

// sample code
$(".cancle + button").addEventListener("click", (e) => {
  if (e.target.innerText == "로그인") {
    $(".modal-window").style.display = "none";
    $(".test").innerText = "로그아웃";
    $(".cancle + button").innerText = "로그아웃";
    // $(".cancle + button").name = "login";
    $("#text").innerHTML = "로그아웃 하시겠습니까?";
  } else {
    $(".modal-window").style.display = "none";
    $(".test").innerText = "로그인";
    $(".cancle + button").innerText = "로그인";
    // $(".cancle + button").name = "logout";
    $("#text").innerHTML = "로그인이 필요합니다.<br>로그인하시겠습니까?";
  }
});
