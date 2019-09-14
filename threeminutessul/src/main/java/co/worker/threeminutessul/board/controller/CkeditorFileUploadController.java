package co.worker.threeminutessul.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.JsonObject;

import co.worker.threeminutessul.util.FileBean;
import co.worker.threeminutessul.util.fileupload.FileUploadUtil;



@Controller
public class CkeditorFileUploadController {

	@RequestMapping(value="/boardImageUpload.tmssul", method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public String fileUpload(HttpServletRequest req, HttpServletResponse resp, HttpSession session,
                 MultipartHttpServletRequest multiFile,Model model,FileBean filebean) throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		String userid = (String)session.getAttribute("userid");
		String userSeq = (String)session.getAttribute("userSeq");
		
		CommonsMultipartFile file = filebean.getUpload();
		if(file != null){
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())){
				System.out.println(file.getContentType());
				if(file.getContentType().toLowerCase().startsWith("image/")){
					try{
						
						String fileOrgName = file.getOriginalFilename();
						byte[] bytes = file.getBytes();
						//첨부파일 저장될 경로
						String uploadPath = session.getServletContext().getRealPath("/resources/boardUpload");
						
						uploadPath = uploadPath +"\\"+userid;
						
						File uploadFolder = new File(uploadPath);
						
						//fileName = UUID.randomUUID().toString();
						if(!uploadFolder.exists()){
							uploadFolder.mkdirs();
						}
						String filename = FileUploadUtil.getFileName(uploadPath,fileOrgName);
						String filePath = uploadPath+"\\"+filename;
						
						File saveFile = new File(uploadPath,filename);
						
						//파일 이동
						file.transferTo(saveFile);
//						
//						out = new FileOutputStream(new File(filePath));
//                        out.write(bytes);
                        resp.setCharacterEncoding("UTF-8");
                		resp.setContentType("text/html; charset=utf-8");
                        printWriter = resp.getWriter();
                        String fileUrl = req.getContextPath() + "/resources/boardUpload/"+userid+"/"+ filename;
                        
                        
                        // json 데이터로 등록
                        // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
                        // 이런 형태로 리턴이 나가야함.
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", filename);
                        json.addProperty("url", fileUrl);
                        
                        printWriter.println(json);
                    }catch(IOException e){
                        e.printStackTrace();
                    }finally{
                        if(out != null){
                            out.close();
                        }
                        if(printWriter != null){
                            printWriter.close();
                        }		
					}
				}
			}
		}
		return null;
	}	
	
}