$(function () {
  //auto resize textarea
  $('#card_write').on('keyup', function () {
    var text = $('#card_write').val(),
      matches = text.match(/\n/g),
      breaks = matches ? matches.length : 2;
    $('#card_write').attr('rows', breaks + 2);
  });

  $('.card-collapse').on('shown.bs.collapse',function(){
    var topoffset = $('.navbar').outerHeight();
    var target = $(this).parents('.card');
    var tgmargin = target.css('margin-top').substr(-2,0);
    $('html, body').animate({
      scrollTop: target.offset().top - topoffset - tgmargin
    },0);
  });

  $(".custom-file-input").on("change", function () {
    var fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  });

  $(".card-reply-item").on('click','button',function(){
    var cardClpse = $(this).closest('.card-collapse');
    var replyMention = cardClpse.find('.card-reply-mention');
    var replyInput = cardClpse.find('.card-reply-input input');
    replyMention.text('@' + $(this).text());
    var mentionSize = replyMention.outerWidth();
    var inpXpad = replyInput.css('padding-right').substr(0,2);
    var totalPadLft = Number(inpXpad) + mentionSize;
    
    replyInput.removeAttr('placeholder');
    replyInput.css('padding-left',totalPadLft+'px');
  });

  /* 카드 컨텐츠 불러오기 예시 */
  $('.card-btn').click(function(){
    var card = $(this).closest('.card');
    var cardCont = card.find('.card-contents').text();
    var cardContArea = card.find('.card-collapse');
    var spinner = $(this).find('.spinner-border');
    var upBtn = $(this).find('.fa-chevron-up');
    var downBtn = $(this).find('.fa-chevron-down');
    if(cardCont.trim().length == 0){ //한번도 클릭한적 없다면
      cardContArea.hide();//카드 접힌 상태 유지하기
      $(this).find('i').hide();
      spinner.addClass('on');
      $.ajax({
        //경로입력
        url : 'https://jsonplaceholder.typicode.com/users',
        type : 'GET',
        data: card.attr('id').substr(4),
      }).done(function(data){
          console.log(data);
          var content = data[0].email; //이부분 커스텀해주면 될듯!!
          card.find('.card-contents').text(content);
          spinner.removeClass('on'); //스피너제거
          cardContArea.show();//카드 펼치기
          upBtn.show();
      });
    }else{
      upBtn.toggle();
      downBtn.toggle();
    }
  });


});