
let deleteModal = function(){

	const backdrop = document.createElement('div');
	backdrop.classList.add('modalbackground');
	document.body.appendChild(backdrop);
	
	$(".delcontainer").show('normal').css('display', 'grid');
			
		$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
			if($(".delcontainer").has(e.target).length === 0){
				$(".delcontainer").hide('fast');
				backdrop.remove();
			}
		});
			
		$(document).keydown(function(e){/* esc입력시 닫기 */
	   		var code = e.keyCode || e.which;

	   		if (code == 27) {
	       		$(".delcontainer").hide('fast');
				backdrop.remove();
  			}
		});		
		
		$(".delcancle").click(function() { /* 취소 클릭 시 닫기  */
			$(".delcontainer").hide('fast');
			backdrop.remove();
		});
};


$(() => { /* 삭제 관련 */
	
	$(".deletecmt").click(function() {
		
		deleteModal();
		
		/* 삭제 폼 속성 설정 */
		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		
//		$(".delcontainer").children("#targetGb").attr('value', "COMMENT");
		$(".delcontainer").children("#targetCd").attr('value', commentCd);
		
		/* 댓글 삭제 post 전송 */
		$(".del").click(function(){
		
			$.ajax({
				url : "/DeleteComment",
				type : "POST",
				data : 
				{
					targetCd : $(this).siblings("#targetCd").val()
				},
				success : function(data){
					
					alert("댓글이 삭제되었습니다.");
				},
				error : function(){
		 			alert("댓글 삭제  오류남");  /* 나중에 고쳐  */
				}
			});
		});
	});
	
	$(".deleteRv").click(function() {
		
		
		deleteModal();
		
		
		$(".del").click(function(){
		
			$.ajax({
				url : "/Delete",
				type : "POST",
				data : 
				{	
					targetGb : $(this).siblings("#targetGb").val(),
					targetCd : $(this).siblings("#targetCd").val()
				},
		
				success : function(data){
					alert("글이 삭제되었습니다.");
					location.reload();
				},
				error : function(){
		 			alert("글 삭제  오류남");  /* 나중에 고쳐  */
				}
			});
		
		});
	});
});


// let deleteModal = function(){


	
// };


// $(() => { /* 삭제 관련 */

	
// 	$(".deletecmt").click(function() {
		
// 		const backdrop = document.createElement('div');
// 		backdrop.classList.add('modalbackground');
// 		document.body.appendChild(backdrop);
	
// 		$(".delcontainer").show('normal').css('display', 'grid');	

		
// 		$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
			
// 			if($(".delcontainer").has(e.target).length === 0){
// 				$(".delcontainer").hide('fast');
// 				backdrop.remove();
// 			}
// 		});

		
// 		$(document).keydown(function(e){ /* esc입력시 닫기 */
// 	    	var code = e.keyCode || e.which;
 
// 	    	if (code == 27) {
// 		   		$(".delcontainer").hide('fast');
// 				backdrop.remove();
// 	   		}
// 		});		

		
// 		$(".delcancle").click(function() { /* 취소 클릭 시 닫기  */
// 			$(".delcontainer").hide('fast');
// 			backdrop.remove();
// 		});


		
// 		/* 삭제 폼 속성 설정 */
// 		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		
// 		$(".delcontainer").children("#targetCd").attr('value', commentCd);
		
// 		/* 댓글 삭제 post 전송 */
// 		$(".del").click(function(){
		
// 			$.ajax({
// 				url : "/DeleteComment",
// 				type : "POST",
// 				data : 
// 				{
// 					targetCd : $(this).siblings("#targetCd").val()
// 				},
// 				success : function(data){
					
// 					alert("댓글이 삭제되었습니다.");
// 				},
// 				error : function(){
// 		 			alert("댓글 삭제  오류남");  /* 나중에 고쳐  */
// 				}
// 			});
// 		});
// 	});
	
// 	$(".deleteRv").click(function() {

// 		const backdrop = document.createElement('div');
// 		backdrop.classList.add('modalbackground');
// 		document.body.appendChild(backdrop);
	
// 		$(".delcontainer").show('normal').css('display', 'grid');	

		
// 		$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
			
// 			if($(".delcontainer").has(e.target).length === 0){
// 				$(".delcontainer").hide('fast');
// 				backdrop.remove();
// 			}
// 		});

		
// 		$(document).keydown(function(e){ /* esc입력시 닫기 */
// 	    	var code = e.keyCode || e.which;
 
// 	    	if (code == 27) {
// 		   		$(".delcontainer").hide('fast');
// 				backdrop.remove();
// 	   		}
// 		});		

		
// 		$(".delcancle").click(function() { /* 취소 클릭 시 닫기  */
// 			$(".delcontainer").hide('fast');
// 			backdrop.remove();
// 		});
		
// 		$(".del").click(function(){
		
// 			$.ajax({
// 				url : "/Delete",
// 				type : "POST",
// 				data : 
// 				{	
// 					targetGb : $(this).siblings("#targetGb").val(),
// 					targetCd : $(this).siblings("#targetCd").val()
// 				},
		
// 				success : function(data){
// 					alert("글이 삭제되었습니다.");
// 					location.reload();
// 				},
// 				error : function(){
// 		 			alert("글 삭제  오류남");  /* 나중에 고쳐  */
// 				}
// 			});
		
// 		});
// 	});
// });