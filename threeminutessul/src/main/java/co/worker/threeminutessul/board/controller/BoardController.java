package co.worker.threeminutessul.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.util.FileBean;
import co.worker.threeminutessul.util.fileupload.FileUploadUtil;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceIF service;

	@RequestMapping(value = "/boardList.tmssul", method = { RequestMethod.GET })
	public String boardList(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		List<BoardVO> list = service.getBoard();
		/*JSONArray jsonArr = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject json = new JSONObject();
			json.put("seq", vo.getBoardSeq());
			json.put("content",vo.getContent());
			jsonArr.add(json);
		}*/
		//req.setAttribute("jsonlist", jsonArr);
		req.setAttribute("list",list);
		return "board/boardList";
	}
	
	@RequestMapping(value = "/boardAdd.tmssul", method = { RequestMethod.GET })
	public String boardAdd(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws IOException {
		/*if(session.getAttribute("userid")==null 
				|| session.getAttribute("userid").equals("")) {
			//로그인안했으면 튕겨내야함.
			String actionCode = "alert('로그인을 먼저 진행해주시기 바랍니다.'); history.back();";
			//String actionCode = "alert('로그인을 먼저 진행해주시기 바랍니다.'); history.back();";
			NewPageAction.action(resp, actionCode);
			return null;
		};*/
		return "board/boardAdd";
		//로그인을 먼저 진행해주시기 바랍니다.
	}
	
	@RequestMapping(value = "/boardImageUpload.tmssul", method = { RequestMethod.POST })
	@ResponseBody
	public JSONObject boardImageUpload(FileBean filebean, HttpServletRequest req, HttpServletResponse resp,Model model,HttpSession session) throws Exception {
		JSONObject json = new JSONObject();//filebean.getUpload());
		
		CommonsMultipartFile uploadFile = filebean.getUpload();
		String filename = uploadFile.getFileItem().getName();
		String userid = (String)session.getAttribute("userid");
		String userSeq = (String)session.getAttribute("userSeq");
		String actionCode="";
		String uploadPath="";
		//파일업로드
		

		//MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;
		//MultipartFile uploadImage = multi.getFile(filename);
		/*
		System.out.println(profile.getName()); // input태그 name값
		System.out.println(profile.getOriginalFilename()); // 첨부파일 원본명
		System.out.println(profile.getSize()); // 파일 사이즈
		System.out.println(profile.getContentType()); // MIME(파일 종류)
		*/
		//profile 업로드 처리
		if (!uploadFile.isEmpty()) {
			
			// 첨부파일 저장될 폴더 경로 (id별로 폴더만들것임)
			// 3. a.zip -> a_1.zip -> a_2.zip
			String rootPath = req.getSession().getServletContext().getRealPath("resources/boardUpload");
			
			//폴더생성.
			File uploadFolder = new File(rootPath,userid);
			System.out.println(uploadFolder.exists());
			if(!uploadFolder.exists()) {
				uploadFolder.mkdir();
			}
			
			// 저장될 파일의 경로
			uploadPath = rootPath+"\\"+userid;
			
			filename = FileUploadUtil.getFileName(uploadPath, uploadFile.getOriginalFilename());
			File file = new File(uploadPath + "\\" + filename);
			// 스프링이 받아놓은 첨부파일을 임시 폴더에서 우리가 희망하는 폴더에 이동하기.(Was가 temp라는 임시폴더에 저장해논걸 files 폴더로
			// 이동시켜야함)
			uploadFile.transferTo(file); // 실제 파일 이동.(temp -> files)
		}
		
	
		/*if (result == 1) {
			actionCode="alert('회원가입이 완료되었습니다. 로그인해주시기 바랍니다.');"
					+ "location.href='/threeminutessul/boardList.tmssul';";
			NewPageAction.action(resp, actionCode);
		} else {
			// 가입실패(일로 들어올 확률 거의 없음)
			actionCode="alert('서버에서 오류가 발생했습니다. 잠시후 다시 시도해주세요.'); history.back();";
			NewPageAction.action(resp, actionCode);
		}*/
		
		json.put("url", uploadPath); //여기에 업로드된 경로 넣기.
		
		return json;
		
	}
	
	@RequestMapping(value = "/boardAddOk.tmssul", method = { RequestMethod.POST })
	public void boardAddOk(HttpServletRequest req, HttpServletResponse resp, HttpSession session, BoardVO vo) throws Exception {
		
	}
	
}
