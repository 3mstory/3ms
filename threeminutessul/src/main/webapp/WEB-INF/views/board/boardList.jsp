<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body style="height:100vh; background-color: #E9EBEE">
	<nav class="navbar navbar-expand-sm navbar-light bg-white fixed-top">
		<div class="container flex-sm-column">
			<a class="navbar-brand mx-auto p-0" href="#"><span>3</span>분썰</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse " id="navbarNav">
				<ul class="navbar-nav">
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

		<div class="card my-3" id="card1">
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

					<div class="container-fluid my-4 card-reply">
						<div class="row card-reply-header pb-2">
							<h5>댓글 0개</h5>
						</div>
						<div class="card-reply-body">
							<p class="nickname">익명123</p>
							<p class="contents pl-2">안녕하세요 이것은 댓글입니다.</p>
						</div>
					</div>

				</div>
			</div>
			<button type="button" class="card-btn btn w-100" data-toggle="collapse" data-target="#card1 .card-collapse">
				<i class="fas fa-chevron-down"></i>
			</button>
		</div>

		<div class="card my-3" id="card2">
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
		</div>

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="resources/js/common.js"></script>
</body>

</html>