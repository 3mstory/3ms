package co.worker.threeminutessul.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import co.worker.threeminutessul.board.model.FileVO;
import co.worker.threeminutessul.util.FileBean;
import co.worker.threeminutessul.util.fileupload.FileUploadUtil;



@RestController
public class CkeditorFileUploadController {

	@RequestMapping(value="/boardImageUpload.tmssul", method=RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@Transactional
	public ResponseEntity<FileVO> fileUpload(HttpServletRequest req, HttpServletResponse resp, HttpSession session,
                 MultipartHttpServletRequest multiFile,Model model,FileBean filebean) throws Exception {
		
		FileVO resultVO = new FileVO();
		String userid = (String)session.getAttribute("userid");
		CommonsMultipartFile file = filebean.getUpload();
		
		if(file != null){
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())){
				System.out.println(file.getContentType());
				if(file.getContentType().toLowerCase().startsWith("image/")){
					try{
						
						String fileOrgName = file.getOriginalFilename();
						//첨부파일 저장될 경로
						String uploadPath = session.getServletContext().getRealPath("/resources/boardUpload"); // C:/ 이거
						String today = getFolder();
						String uploadFolderPath = uploadPath +"\\"+userid+"\\"+today;
						
						//make Folder
						File uploadFolder = new File(uploadFolderPath);
						
						if(!uploadFolder.exists()){
							uploadFolder.mkdirs();
						}
						//String filename = FileUploadUtil.getFileName(uploadPath, fileOrgName);
						
						String filename = UUID.randomUUID().toString()+"_"+FileUploadUtil.getFileName(uploadPath, fileOrgName);
						String filePath = uploadFolderPath+"\\"+filename;
						
						
						File saveFile = new File(uploadFolder, filename);
						
						//파일 이동
						file.transferTo(saveFile);
						
                        resp.setCharacterEncoding("UTF-8");
                		resp.setContentType("text/html; charset=utf-8");
                        String fileUrl = req.getContextPath() + "/resources/boardUpload/"+userid+"/"+today+"/"+ filename;
                        
                        
                        // json 데이터로 등록
                        // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
                        // 이런 형태로 리턴이 나가야함.
                        
                        resultVO.setUploaded(1);
                        resultVO.setFileName(filename);
                        resultVO.setUrl(fileUrl);
                        
                        return new ResponseEntity<>(resultVO, HttpStatus.OK);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
				}
			}
		}
		return null;
	}	
	
	/**
	 * 날짜별 폴더명을 생성하는 메소드
	 * @return
	 */
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator); 
	}
	
}