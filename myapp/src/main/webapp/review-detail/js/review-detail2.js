

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
	 document.getElementById('content').focus();
	});
	
	$(".top").click(function() {
		
		window.scrollTo({top : 0, behavior: 'smooth'}); 
	});
});


$(() => { /* 글 수정  */
	
	$(".modifyRv").click(function() {
		
		$.ajax({
			url : "",
			type : "POST",
			data : 
			{
				targetGb : $("input[name='targetGb']").val(),
				targetCd : $("input[name='targetCd']").val(),
				userCd : 2,/* 나중에 바꿔야됨  */
				reportGb : $("input[name='check']:checked").val()
			},
			
			success : function(data){
				
				alert("신고 접수가 완료되었습니다.");
				location.reload();
			},
			error : function(){
			 	alert("신고에서 오류남");  /* 나중에 고쳐  */
			}
		});
	})	
	
})




