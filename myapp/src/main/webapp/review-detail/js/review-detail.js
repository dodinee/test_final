// let user = document.querySelector(".cmtuser");

// user.addEventListener("onclick", () => {});

// function onDisplay() {
//   document.querySelector(".mentionwrite").show();
// }
// function offDisplay() {
//   document.querySelector(".mentionwrite").hide();
// }

/*
$(".mentionbtn").addEventListener("onclick", () => {
  if ($(".mentionwrite").css("display") == none) {
    $(".mentionwrite").onDisplay();
  } else {
    $(".mentionwrite").offDisplay();
  }
});
*/

$(() => {
  $(".mentionbtn").click(function () {
    if ($(".mentionwrite").css("display") == "none") {
      $(".mentionwrite").show();
    } else {
      $(".mentionwrite").hide();
    }
  });
});

$(() => {
	$("#cancle").click(function () {
		$(".mentionwrite").hide();
	});
});
