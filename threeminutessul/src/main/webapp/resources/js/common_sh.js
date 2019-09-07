function isMobile() {
    return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
}

function adjustSizeByDevice(){
	if (isMobile()) {
	    // 모바일이면 실행될 코드 들어가는 곳
		
		var bodySize = $("#cont").width();
		
		$("#categoryList").width(bodySize);
  		$("#title.form-control").width(bodySize);
  		
  		$("#title.form-control").css("margin-bottom","20");
	} else {
		
		
	    // 모바일이 아니면 실행될 코드 들어가는 곳
	    $('#cont').width("1000px");
	    $('#cont').css('margin','0 auto;');
	    
		  //화면영역 전체크기(위에서 모바일/PC 구분하니까 그 이후에) 잡고 select와 title 조절
  		var bodySize = $("#cont").width();
  		
  		$("#categoryList").width(bodySize*0.14);
  		$("#title").width(bodySize*0.8);
	    
	    $("#categoryList.form-control").css("display","inline-block");
	    $("#title.form-control").css("display","inline-block");
	}
}