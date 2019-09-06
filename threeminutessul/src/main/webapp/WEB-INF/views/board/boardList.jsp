<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="co.worker.threeminutessul.util.JavaUtil"  %>
<% 
	String sessionUserSeq = (String)session.getAttribute("userSeq");
	pageContext.setAttribute("sessionUserSeq",sessionUserSeq);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,minimal-ui" />
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
    
    <!-- 우성환 css -->
    <link rel="stylesheet" href="resources/css/sh.css" />
    
	<!-- 파비콘 -->
	<link rel="shortcut icon" href="resources/favicon.gif" type="image/x-icon">
	<link rel="icon" href="resources/favicon.gif" type="image/x-icon">
</head>
<!-- 임시 회원가입 모달 -->
<div class="modal fade" id="join_form" tabindex="-1" role="dialog" aria-labelledby="join_form" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header p-4">
				<h4 class="mx-auto font-tit font-weight-bold">회원가입</h4>
			</div>
			<form action="/threeminutessul/userjoin.tmssul" method="POST" encType="multipart/form-data">
				<div class="modal-body px-4 py-0">
					<div class="form-group">
						<input type="text" class="form-control" id="id123" aria-describedby="아이디" placeholder="id" name="userid"
							required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password1" placeholder="password" name="userpw" required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="nick" aria-describedby="닉네임" placeholder="닉네임" name="nickname"
							required>
					</div>
					<div class="form-group">
						<div class="custom-file" id="customFile">
							<input type="file" accept="image/*" class="custom-file-input" id="join-file-input" name="input_file"
								required aria-describedby="ProfileUpload">
							<label class="custom-file-label text-secondary" for="exampleInputFile" required>
								프로필 사진
							</label>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="container-fluid">
						<div class="row">
							<div class="col-6">
								<button type="button" class="btn btn-outline-secondary mx-auto col-12 mb-4" data-dismiss="modal"
									data-toggle="modal" data-target="#login_form">로그인</button>
							</div>
							<div class="col-6">
								<button type="submit" class="btn btn-primary mx-auto col-12 mb-4">가입신청</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- 임시 로그인 모달 -->
<div class="modal fade" id="login_form" tabindex="-1" role="dialog" aria-labelledby="login_form" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content ">
			<div class="modal-header p-4">
				<h4 class="mx-auto font-tit font-weight-bold">로그인</h4>
			</div>
			<div class="modal-body px-4 py-0">
				<form action="/threeminutessul/loginok.tmssul" method="POST">
					<div class="form-group mb-4">
						<input type="text" class="form-control" id="userid" name="userid" required aria-describedby="아이디"
							placeholder="id">
					</div>
					<div class="form-group">
						<input type="password" class="form-control " id="userpw" required name="userpw" placeholder="password">
					</div>
					<div class="container my-4">
						<div class="row">
							<button type="button" class="btn btn-outline-secondary mx-auto col-5" data-dismiss="modal"
								data-toggle="modal" data-target="#join_form" aria-label="join">회원가입</button>
							<button type="submit" class="btn btn-primary mx-auto col-5" aria-label="login">로그인</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<body style="background-color: #E9EBEE; height:100%; overflow-x:hidden!important;">
	<nav class="navbar navbar-expand-sm navbar-light bg-white fixed-top">
		<div class="container flex-sm-column">
			<a class="navbar-brand mx-auto p-0 font-header" href="#"><span class="font-color-main">3</span>분썰</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse " id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" data-toggle="modal" data-target="#login_form" href="#">임시로그인버튼</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/threeminutessul/logoutOk.tmssul">로그아웃</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/threeminutessul/boardAdd.tmssul">임시게시판 글쓰기</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">연애</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">공포</a></li>
					<li class="nav-item"><a class="nav-link" href="#">19</a></li>
				</ul>
			</div>
		</div>

	</nav>
	<div class="nvbar-hr"></div>
	<!--본문-->
	<div class="container-fluid" id="cont">
		<div class="accordion" id="brd-acdn">
			<c:forEach items="${list}" var="vo">
				<div class="card" id="card_${vo.boardSeq}">
					<div class="card-header">
						<div class="row">
							<img class="rounded-circle px-2" src="resources/files/${vo.userid}/${vo.profile}" width="50px"
								height="50px" onError="this.src='resources/files/default.PNG'">
							<div class="col d-flex flex-column justify-content-center">
								<div class="row d-block font-tit"><c:out value="${vo.writer}" escapeXml="true"/></div>
								<div class="row d-block text-secondary card-info-sub"><c:out value="${vo.regdate}" escapeXml="true"/></div>
							</div>
						</div>
					</div>

					<div class="card-body">
						<div class="card-title font-weight-bold text-truncate">
							<c:out value="${vo.title}" escapeXml="true"/>
						</div>
						
						<div class="collapse card-collapse card-text" data-parent="#brd-acdn">
							<p class="card-contents mb-4">
								<c:if test="${sessionUserSeq == vo.userSeq}">
									<div style="text-align:right">
										<!-- <input type="button" id="updateBtn" value="수정" class="btn btn-info btn-xs"/> -->
										<a href="/threeminutessul/boardUpdate.tmssul?boardSeq=${vo.boardSeq}" id="updateBtn">수정</a>
									</div>
								</c:if>
							</p>
							<div class="row card-btn-area justify-content-center">
								<div class="btn btn-outline-dark mx-4 d-flex flex-column justify-content-center">
									<i class="d-block far fa-grin-squint-tears fa-2x likeyhate">
										<input type="hidden" id="hdboardSeq" value="${vo.boardSeq}" />
										<input type="hidden" id="hdtype_${vo.boardSeq}" value="1" />
									</i>
									<p class="card-btntx left likecount"></p>
								</div>
								<div class="btn btn-outline-dark mx-4 p-2 d-flex flex-column justify-content-center">
									<i class="far fa-trash-alt fa-2x likeyhate"> <input type="hidden" id="hdboardSeq"
											value="${vo.boardSeq}" /> <input type="hidden" id="hdtype_${vo.boardSeq}" value="2" />
									</i>
									<p class="card-btntx right hatecount"></p>
								</div>
							</div>

							<div class="card-reply-area">
								<div class="card-reply-header mt-4">
									<span class="reply-tit text-dark font-weight-bolder">
										댓글&nbsp;<span id="commentCount_${vo.boardSeq}" class="reply-cnt font-color-main"></span>개
									</span>
								</div>
								<div class="card-reply-body">
									<ul id="commentList_${vo.boardSeq}" class="card-replys">
										<!-- 댓글영역 -->
									</ul>
								</div>
							</div>
							<div class="input-group card-reply-input mt-3">
								<input type="text" class="form-control" placeholder="닉네임 클릭시 지정 댓글 가능">
								<span class="card-reply-mention"></span>
								<div class="input-group-append">
									<button class="btn btn-outline-secondary reply_submit_btn" type="button" id="button-addon2"><i
											class="far fa-paper-plane"></i></button>
								</div>
							</div>
						</div>
					</div>
					<button type="button" class="card-btn btn w-100 collapsed" data-toggle="collapse"
						data-target="#card_${vo.boardSeq} .card-collapse">
						<i class="fas fa-chevron-down"></i> <i class="fas fa-chevron-up"></i>
						<div class="d-flex justify-content-center">
							<div class="spinner-border text-primary" style="display: none;" role="status">
								<span class="sr-only">Loading...</span>
							</div>
						</div>
					</button>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Floating Action Button-->
	<div class="zoom">
		<a href="/threeminutessul/boardAdd.tmssul" id="zoomBtn" class="zoom-fab zoom-btn-mid"><i
				class="fas fa-pencil-alt"></i></a>
	</div>
	<script id="cardTemplate" type="text/x-jsrender">
		<div class="card" id="card_{{:boardSeq}}">
				<div class="card-header">
					<div class="row">
							<img class="rounded-circle px-2"
							src="resources/files/{{:userid}}/{{:profile}}" width="50px"
							height="50px" onerror="this.src='resources/files/default.PNG'">
						<div class="col d-flex flex-column justify-content-center">
							<div class="row d-block font-tit">{{:writer}}</div>
							<div class="row d-block text-secondary card-info-sub">{{:regdate}}</div>
						</div>
					</div>
				</div>
				<div class="card-body">
					<div class="font-weight-bold text-truncate">
							{{:title}}
					</div>
					<div class="collapse card-text card-collapse" data-parent="#brd-acdn">
						<p class="card-contents mb-4">
						</p>
						<div class="row card-btn-area justify-content-center">
							<div class="btn btn-outline-dark mx-4 d-flex flex-column justify-content-center">
								<i class="d-block far fa-grin-squint-tears fa-2x">
										<input type="hidden" id="hdboardSeq" value="{{:boardSeq}}" />
										<input type="hidden" id="hdtype_{{:boardSeq}}" value="1" />
								</i>
								<p class="card-btntx left likecount">5,000</p>
							</div>
							<div class="btn btn-outline-dark mx-4 p-2 d-flex flex-column justify-content-center">
								<i class="far fa-trash-alt fa-2x">
										<input type="hidden" id="hdboardSeq" value="{{:boardSeq}}" />
										<input type="hidden" id="hdtype_{{:boardSeq}}" value="2" />
								</i>
								<p class="card-btntx right hatecount">1,200</p>
							</div>
						</div>

						<div class="card-reply-area">
							<div class="card-reply-header mt-4">
									<span class="reply-tit text-dark font-weight-bolder">
										댓글&nbsp;<span id="commentCount_{{:boardSeq}}" class="reply-cnt font-color-main"></span>개
									</span>
							</div>
							<div class="card-reply-body">
								<ul id="commentList_{{:boardSeq}}" class="card-replys">
									<li class="card-reply-item my-1">
										<button type="button"
											class="btn btn-outline-secondary writer py-0 px-1 align-top">{{:nickname}}</button>
										<span>{{:content}}</span>
									</li>
								</ul>
							</div>
						</div>
						<div class="input-group card-reply-input mt-3">
							<input type="text" class="form-control" placeholder="닉네임 클릭시 지정 댓글 가능">
							<span class="card-reply-mention"></span>
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button" id="button-addon{{:boardSeq}}"><i
										class="far fa-paper-plane"></i></button>
							</div>
						</div>
					</div>
				</div>
				<button type="button" class="card-btn btn w-100 collapsed" data-toggle="collapse"
					data-target="#card_{{:boardSeq}} .card-collapse">
					<i class="fas fa-chevron-down"></i>
					<i class="fas fa-chevron-up"></i>
					<div class="d-flex justify-content-center">
						<div class="spinner-border text-primary" style="display:none" role="status">
							<span class="sr-only">Loading...</span>
						</div>
					</div>
				</button>
			</div>
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="resources/js/jsrender.js"></script>
	<script src="resources/js/common.js"></script>
	
	<!-- 우성환 js 파일 -->
	<script src="resources/js/common_sh.js"></script>
	
	<script id="replyTemplate" type="text/x-jsrender">
		<li class="card-reply-item my-1">
			<button type="button"
				class="btn btn-outline-secondary writer py-0 px-1 align-top">{{:nickname}}</button>
			<span>{{:content}}</span>
		</li>
	</script>
	<script id="toastTemplate" type="text/x-jsrender">
		<div class="toast vote-toast" role="alert" aria-live="assertive" aria-atomic="true" class="toast" data-delay="1000"
			data-autohide="true">
			<div class="toast-body">
				{{:content}}
			</div>
		</div>
	</script>
	
	<script type="text/javascript">

		/* 댓글 언급 기능 */
		$(".accordion").on('click', '.card-replys button', function () {
			var cardClpse = $(this).closest('.card-collapse');
			var replyMention = cardClpse.find('.card-reply-mention');
			var replyInput = cardClpse.find('.card-reply-input input');
			replyMention.text('@' + $(this).text());
			var mentionSize = replyMention.outerWidth();
			var inpXpad = replyInput.css('padding-right').substr(0, 2);
			var totalPadLft = Number(inpXpad) + mentionSize;
			replyMention.show();
			replyInput.removeAttr('placeholder');
			replyInput.css('padding-left', totalPadLft + 'px');
		});
		$('.accordion').on('click', '.card-reply-mention', function (e) {
			var mention = $(this).toggle();
			var input = mention.siblings('input');
			input.css('padding-left', input.css('padding-right'));
		})
	</script>
</body>

</html>