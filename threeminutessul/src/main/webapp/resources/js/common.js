$(function () {
  //auto resize textarea
  $('#card_write').on('keyup', function () {
    var text = $('#card_write').val(),
      matches = text.match(/\n/g),
      breaks = matches ? matches.length : 2;
    console.log(breaks);
    $('#card_write').attr('rows', breaks + 2);
  });
  //컨텐츠 패딩
  var padding = $('.navbar').outerHeight(true) + 'px';
  $('#cont').css('padding-top', padding);
  // $('.card-btn').on('click', function (e) {
  //   $('.card-preview').toggleClass('on');
  // });

  $('.card-btn').on('click', function (e) {
    var topoffset = $('.navbar').outerHeight();
    var target = $(this).parents('.card');
    $('html, body').animate({
      scrollTop: target.offset().top - topoffset
    }, 200);
  });

  $(".custom-file-input").on("change", function () {
    var fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  });

});