package co.worker.threeminutessul.user.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.worker.threeminutessul.user.model.UserVO;
import co.worker.threeminutessul.user.service.UserServiceIF;
import co.worker.threeminutessul.util.NewPageAction;
import co.worker.threeminutessul.util.fileupload.FileUploadUtil;

@Controller
public class UserController {

	@Autowired
	private UserServiceIF service;

	@RequestMapping(value = "/userJoinPage.tmssul", method = { RequestMethod.GET })
	public String join(HttpServletRequest req, HttpServletResponse resp) {
		
		return "userJoinPage";
	}
	
	@GetMapping(value = "idduplcheck.tmssul", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> idduplcheck(HttpServletRequest req, HttpServletResponse resp,HttpSession session, String inputId){
		//아이디 중복체크
		return service.duplicateIdCheck(inputId) == 1 
				? new ResponseEntity<>("duplicate",HttpStatus.OK)
				: new ResponseEntity<>("ok",HttpStatus.OK);
	}

	@RequestMapping(value = "/userjoin.tmssul", method = { RequestMethod.POST })
	public void userJoinPage(HttpServletRequest req, HttpServletResponse resp,HttpSession session, UserVO vo) throws Exception {
		
		req.setCharacterEncoding("UTF-8");

		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;
		MultipartFile profile = multi.getFile("input_file"); // input태그의 name값 대입.
		/*
			System.out.println(profile.getName()); // input태그 name값
			System.out.println(profile.getOriginalFilename()); // 첨부파일 원본명
			System.out.println(profile.getSize()); // 파일 사이즈
			System.out.println(profile.getContentType()); // MIME(파일 종류)
		*/
		int result =0;
		result = service.insertNewUser(vo,profile);
		//profile 업로드 처리
		if (!profile.isEmpty()) {
			// 첨부파일 저장될 폴더 경로 (id별로 폴더만들것임)
			// 3. a.zip -> a_1.zip -> a_2.zip
			String rootPath = req.getSession().getServletContext().getRealPath("resources/files");
			
			//폴더생성.
			File uploadFolder = new File(rootPath,vo.getUserid());
			System.out.println(uploadFolder.exists());
			if(!uploadFolder.exists()) {
				uploadFolder.mkdir();
			}
			String uploadPath = rootPath+"\\"+vo.getUserid();
			
			System.out.println(uploadPath); // 저장될 파일의 경로
			
			String filename = FileUploadUtil.getFileName(uploadPath, profile.getOriginalFilename());
			File file = new File(uploadPath + "\\" + filename);
			// 스프링이 받아놓은 첨부파일을 임시 폴더에서 우리가 희망하는 폴더에 이동하기.(Was가 temp라는 임시폴더에 저장해논걸 files 폴더로
			// 이동시켜야함)
			profile.transferTo(file); // 실제 파일 이동.(temp -> files)
		}
		String actionCode="";
		if (result == 1) {
			actionCode="alert('회원가입이 완료되었습니다. 로그인해주시기 바랍니다.');"
					+ "location.href='/threeminutessul/boardList.tmssul';";
			NewPageAction.action(resp, actionCode);
		} else {
			// 가입실패(일로 들어올 확률 거의 없음)
			actionCode="alert('서버에서 오류가 발생했습니다. 잠시후 다시 시도해주세요.'); history.back();";
			NewPageAction.action(resp, actionCode);
		}
	}
}
