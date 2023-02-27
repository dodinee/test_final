

$(() => {
  $(".mentionbtn").click(function () {
	  
    if ($(this).parent().parent().next().css("display") == "none") {
	    
		$(this).children().attr('value', "☓ 닫기");
	    $(this).parent().parent().next().show('normal');
		
    } else {
		
    	$(this).parent().parent().next().hide('normal');
		$(this).children().attr('value', "↪︎답글달기");
  }
  });
});




$(() => {
	$(".btns").children('input[name=reportcmt]').click(function() {

		$('input[name=check]').prop('checked', false);

		if($(".mdcontainer").css('display') == 'none'){
			$(".mdcontainer").show('normal').css('display', 'flex');			
		}
		else{
			$(".mdcontainer").hide('fast');			
		}
	});
	
	$(".mdcancle").click(function(){
		
		$(".mdcontainer").hide('fast');
	});
});




$(() => {
	
$(".modifycmt").click(function() {
	
		let cd = $(this).parent().children('input[name=commentCd]').val();
		let target = $(this).parent().next();
	
	
		if(target.prop('contenteditable') == 'true'){
			
			target.next().children(".updatebtn").hide();
			target.removeAttr('contenteditable');
			target.toggleClass("update", false);
			
		}else{

			target.next().children(".updatebtn").show();
			target.attr('contenteditable', true);
			target.toggleClass("update", true);
			target.focus();
		}
		
		$(".updatebtn").click(function() {
			
				
		$("#updatecmt").children('input[name="current"]').attr('value', window.location.href);
		$("#updatecmt").children('input[name="contents"]').attr('value', $(this).parent().prev().text());
		$("#updatecmt").children('input[name="commentCd"]').attr('value', cd);
		$("#updatecmt").submit();
		});
			
	});
});

/*
			// window.keypress(function(e){
   //          if(e.which === 13) {
   //              e.preventDefault();
   //              $(this).blur();
   //          }
   //      }); */

/*
$(".modifycmt").click(function() {

		let origin = $(this).parent().next();
		let content = origin.text();
	
		console.log('content=', content);
		let target = $(this).parent().next();
	
		if(origin.is("div")){

			target.next().show();
			target.replaceWith("<textarea class='comment'>"+ content + "</textarea>");
			target = $(this).parent().next();
			
		}else{
			target.next().hide();
			target.replaceWith('<div class="comment">' + content + '</div>');

		}
		

		target.css({
			"border-radius" : "10px",
			"border" : " solid rgb(78, 197, 61)",
			"background-color" : "rgb(0, 0, 0, 0)",
			"text-indent" : "0",
			"font-size" : "12px",
			"resize" : "none"}
		);
});
*/




$(() => {
	
	$(".deletecmt").click(function() {
		
		let cd = $(this).parent().children('input[name=commentCd]').val();
		
		$(".delcontainer").children('input[name=commentCd]').attr('value', cd);
		$(".delcontainer").children('input[name=current]').attr('value', window.location.href);
		$("#delete").attr('action', '/DeleteComment');
		
		if($(".delcontainer").css('display') == 'none'){
			$(".delcontainer").show('normal').css('display', 'grid');			
		}
		else{
			$(".delcontainer").hide('fast');			
		}
	});
	
	$(".delcancle").click(function() { 
		$(".delcontainer").hide('fast');
	});
	
});


$(() => {
	
	$(".reportcmt").click(function() {
		
		let cd = $(this).parent().children('input[name=commentCd]').val();
		
		$(".mdcontainer").children('input[name=current]').attr('value', window.location.href);
		$(".mdcontainer").children('input[name=targetCd]').attr('value', cd);
		$(".mdcontainer").children('input[name=targetGb]').attr('value', 'COMMENT');
	});
	
	$(document).addEventListener("click", e => {
    
    if(!$(".mdcontainer").is(e.target)) {
        $(".mdcontainer").hide('middle');
    }
	});
});



$(() => {
	
	
	$(window).scroll(function(){
    
    if( $(this).scrollTop() < 200 ){
      $(".totop").hide('normal');
    }
    else{
      $(".totop").show('normal');
    }
    
  });

	$(".tocmt").click(function() {
	
	 document.getElementById('cmtwrite').scrollIntoView({behavior : 'smooth'});
	});
	
	$(".totop").click(function() {
		
		window.scrollTo({top : 0, behavior: 'smooth'}); 
	})
});




/*d아 신고 ㅡㅡ 
$(() => {
	
	$(".mdreport").click(function() {
		
		var form = $("#report");

					form.attr("method", "POST");
					form.attr("action", "<c:url value="/Report" />");

					form.submit();
	}
})

*/



/*	
$(() => {
	$(".cancle").click(function () {
		$(".mentionwrite").hide();
	});
});
*/
