

/* 글 수정 ----- 이거 작성폼으로 이동해서 수정하는걸로 해야할 듯  */


$(() => { /* 탑, 코멘트 버튼 스크롤 이벤트 */
	
	$(window).scroll(function(){
    
    if( $(this).scrollTop() < 200 ){
      $(".top").hide('normal');
    }
    else{
      $(".top").show('normal');
    }
    
  });

	$(".cmt").click(function() {
	
	 document.getElementById('cmtwrite').scrollIntoView({behavior : 'smooth'});
	});
	
	$(".top").click(function() {
		
		window.scrollTo({top : 0, behavior: 'smooth'}); 
	});
});






