$(function () {
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
});