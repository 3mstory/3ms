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

});