function isMobile() {
    return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
}

function adjustSizeByDevice(){
	if (isMobile()) {
	    // 모바일이면 실행될 코드 들어가는 곳
	} else {
	    // 모바일이 아니면 실행될 코드 들어가는 곳
	    $('.container-fluid').width("1000px");
	    $('.container-fluid').attr('margin','0 auto;');
	}
}