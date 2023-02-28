//      let reason = document.querySelectorAll(".reason");
//
//      reason.addEventHandler(onclick, function () {
//        document.querySelector(input[(type = "radio")].checked);
//      });



$(() => {

      $(".reason").click(function() {
            console.log($(this).prev());
            $(this).prev().prop('checked', true);
      });
});