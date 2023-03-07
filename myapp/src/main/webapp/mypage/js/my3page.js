
    let active = document.querySelectorAll('.content-header-menu-item');

    for (let i = 0; i < active.length; i++) {
        active[i].onclick = function () {
            let j = 0;
            while (j < active.length) {
                active[j++].className = 'content-header-menu-item';
            }
            active[i].className = 'content-header-menu-item active';
        };
    }

    var uploadbox = document.querySelector('.file-box');
    var profile = document.querySelector('.profile-image-button');
    profile.onclick = function(){
        uploadbox.classList.toggle('active');
    }
    var closebutton = document.querySelector('.closebutton');
    closebutton.onclick=function(){
        uploadbox.className = 'file-box';
    }
 


    var nickbox = document.querySelector('.nickname-box');
    var nameset = document.querySelector('.name-setting');
    nameset.onclick = function(){
        nickbox.classList.toggle('active');
    }
    var closebutton2 = document.querySelector('.closebutton2');
    closebutton2.onclick=function(){
        nickbox.className = 'nickname-box';
    }
 


    $('input[type="file"]').on('change', function(e){
        var fileName = e.target.files[0].name;
        if (fileName) {
          $(e.target).parent().attr('data-message', fileName);
        }
      });


      //아래의 코드는 무슨말인지 모르겠어서 검색이 필요함.
      $(document).on('drag dragstart dragend dragover dragenter dragleave drop', function(e) {
        if ($('input[type="file"]').length) {
          if (['dragover', 'dragenter'].indexOf(e.type) > -1) {
            if (window.dragTimeout)
              clearTimeout(window.dragTimeout);
            $('.file-upload').addClass('dragged');
          } else if (['dragleave', 'drop'].indexOf(e.type) > -1) {
            // Without the timeout, some dragleave events are triggered
            // when the :after appears, making it blink...
            window.dragTimeout = setTimeout(function() {
              $('.file-upload').removeClass('dragged');
            }, 100);
          }
        }
      });





    // $('input[type="file"]').on('change', function(e){
    //     var fileName = e.target.files[0].name;
    //     if (fileName) {
    //       $(e.target).parent().attr('data-message', fileName);
    //     }
    //   });
      
    //   $(document).on('drag dragstart dragend dragover dragenter dragleave drop', function(e) {
    //     if ($('input[type="file"]').length) {
    //       if (['dragover', 'dragenter'].indexOf(e.type) > -1) {
    //         if (window.dragTimeout)
    //           clearTimeout(window.dragTimeout);
    //         $('body').addClass('dragged');
    //       } else if (['dragleave', 'drop'].indexOf(e.type) > -1) {
    //         // Without the timeout, some dragleave events are triggered
    //         // when the :after appears, making it blink...
    //         window.dragTimeout = setTimeout(function() {
    //           $('body').removeClass('dragged');
    //         }, 100);
    //       }
    //     }
    //   });