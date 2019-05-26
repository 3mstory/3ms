<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>3분썰 - 익명 썰 게시판</title>
	<link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
		integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!-- 임시 회원가입 모달 -->
<div class="modal fade" id="join_form" tabindex="-1" role="dialog" aria-labelledby="join_form" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header p-4">
				<h4 class="mx-auto font_tit font-weight-bold">회원가입</h4>
			</div>
			<div class="modal-body px-4 py-0">
				<form>
					<div class="form-group mb-4">
						<input type="text" class="form-control" id="id" aria-describedby="아이디" placeholder="id">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password" placeholder="password">
					</div>
					<div class="form-group mb-4">
						<input type="text" class="form-control" id="nick" aria-describedby="닉네임" placeholder="닉네임">
					</div>
					<div class="form-group mb-4">
						<input type="file" class="btn btn-outline-secondary form-control-file" id="file_input">
					</div>
					<button type="button" class="btn btn-outline-secondary mx-auto col-12 mb-4" data-dismiss="modal"
						data-toggle="modal" data-target="#login_form">로그인하러가기</button>
					<button type="submit" class="btn btn-primary mx-auto col-12 mb-4">가입신청</button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- 임시 로그인 모달 -->
<div class="modal fade" id="login_form" tabindex="-1" role="dialog" aria-labelledby="login_form" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content ">
			<div class="modal-header p-4">
				<h4 class="mx-auto font_tit font-weight-bold">로그인</h4>
			</div>
			<div class="modal-body px-4 py-0">
				<form>
					<div class="form-group mb-4">
						<input type="text" class="form-control" id="id" aria-describedby="아이디" placeholder="id">
					</div>
					<div class="form-group">
						<input type="password" class="form-control " id="password" placeholder="password">
					</div>
					<div class="container my-4">
						<div class="row">
							<button type="button" class="btn btn-outline-secondary mx-auto col-4" data-dismiss="modal"
								data-toggle="modal" data-target="#join_form" aria-label="join">회원가입</button>
							<button type="submit" class="btn btn-primary mx-auto col-4" data-dismiss="modal"
								aria-label="login">로그인</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<body style="height:100vh; background-color: #E9EBEE">
	<nav class="navbar navbar-expand-sm navbar-light bg-white fixed-top">
		<div class="container flex-sm-column">
			<a class="navbar-brand mx-auto p-0 font_header" href="#"><span class="font_color_main">3</span>분썰</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse " id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" data-toggle="modal" data-target="#login_form" href="#">임시로그인버튼</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#">연애</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">공포</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">19</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid smooth-scroll" id="cont">
		<c:forEach items="${list}" var="vo">
			<div class="card my-3" id="card_${vo.boardSeq}">
				<div class="card-header">
					<div class="row">
						<img class="rounded-circle px-2"
							src="https://user-images.githubusercontent.com/14171723/38237327-ea8234e0-3761-11e8-8524-b42d30e8d834.png"
							width="50px" height="50px" alt="프로필이미지">
						<div class="col d-flex flex-column justify-content-center">
							<div class="row d-block card-info-main text-bolder">${vo.writer}</div>
							<div class="row d-block text-secondary card-info-sub">${vo.regdate}</div>
						</div>
					</div>
				</div>
	
				<div class="card-body">
					<div class="card-title font-weight-bold text-truncate">
						${vo.title}
					</div>
					<div class="card-text card-preview on">
						이곳은 미리보기가 표시되는 곳입니다. 앞 세줄 정도를 미리 보여주고 나머지 내용은 궁금하면 클릭해 ...
					</div>
					<div class="collapse card-text mb-4 card-collapse">
						<p class="card-contents mb-4">
							${vo.content}
						</p>
						<div class="row card-btn-area justify-content-center">
							<div class="btn btn-outline-dark mx-4 d-flex flex-column justify-content-center">
								<i class="d-block far fa-grin-squint-tears fa-2x"></i>
								<p>${vo.likey}</p>
							</div>
							<div class="btn btn-outline-dark mx-4 p-2 d-flex flex-column justify-content-center">
								<i class="far fa-trash-alt fa-2x"></i>
								<p>${vo.hate}</p>
							</div>
						</div>
						
						<div class="card-reply-area">
							<div class="card-reply-header mt-4">
								<span class="reply-tit text-dark font-weight-bolder">
									댓글<span class="reply-cnt font_color_main">&nbsp;4</span>개
								</span>
							</div>
							<div class="card-reply-body">
								<ul class="card-replys">
									<li class="reply-item my-1">
										<button type="button" class="btn btn-outline-secondary writer py-0 px-1 align-top">simsimjae</button>
										<span>이것은 첫번째 댓글입니다. 깔깔깔깔 너무 재밌어요 한번 더 연재해주시면 감사하겠습니다.</span>
									</li>
									<li class="reply-item my-1">
										<button type="button" class="btn btn-outline-secondary writer py-0 px-1 align-top">simsimjae</button>
										<span>이것은 세번째 댓글입니다. 너무 재미 없으니까 이 글 빨리 삭제시켜주세요</span>
									</li>
									<li class="reply-item my-1">
										<button type="button" class="btn btn-outline-secondary writer py-0 px-1 align-top">simsimjae</button>
										<span>이것은 세번째 댓글입니다. 너무 재미 없으니까 이 글 빨리 삭제시켜주세요</span>
									</li>
								</ul>
							</div>
						</div>
	
					</div>
				</div>
				<button type="button" class="card-btn btn w-100" data-toggle="collapse" data-target="#card_${vo.boardSeq} .card-collapse">
					<i class="fas fa-chevron-down"></i>
				</button>
				
			</div>
		</c:forEach>

		<!-- <div class="card my-3" id="card2">
			<div class="card-header">
				<div class="row">
					<img class="rounded-circle px-2"
						src="https://user-images.githubusercontent.com/14171723/38237327-ea8234e0-3761-11e8-8524-b42d30e8d834.png"
						width="50px" height="50px" alt="프로필이미지">
					<div class="col d-flex flex-column justify-content-center">
						<div class="row d-block card-info-main text-bolder">하루종일롤만함</div>
						<div class="row d-block text-secondary card-info-sub">12시간전</div>
					</div>
				</div>
			</div> 

			<div class="card-body">
				<div class="card-title font-weight-bold text-truncate">
					하루종일 롤만하다가 기절할뻔한 이야기
				</div>
				<div class="card-text card-preview on">
					이곳은 미리보기가 표시되는 곳입니다. 앞 세줄 정도를 미리 보여주고 나머지 내용은 궁금하면 클릭해 ...
				</div>
				<div class="collapse card-text mb-4 card-collapse">
					<p class="card-contents mb-4">
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
						이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.이곳에 그 다음 내용들이 보이게 됩니다.
					</p>
					<div class="row card-btn-area justify-content-center">
						<div class="btn btn-outline-dark mx-4 d-flex flex-column justify-content-center">
							<i class="d-block far fa-grin-squint-tears fa-2x"></i>
							<p>5,000</p>
						</div>
						<div class="btn btn-outline-dark mx-4 p-2 d-flex flex-column justify-content-center">
							<i class="far fa-trash-alt fa-2x"></i>
							<p>1,200</p>
						</div>
					</div>
				</div>
			</div>
			<button type="button" class="card-btn btn w-100" data-toggle="collapse" data-target="#card2 .card-collapse">
				<i class="fas fa-chevron-down"></i>
			</button>
		</div> -->

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="resources/js/common.js"></script>
</body>

</html>		
