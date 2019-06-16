package co.worker.threeminutessul.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class NewPageAction {
	
	/**
	 * response 객체랑 자바스크립트에서 취할 액션이담긴 코드를 String으로 파라미터 전달하면
	 * 난 그걸 서버수준에서 새페이지만들고 액션했다가 history.back할거임.
	 * @param resp
	 * @param actionCode
	 * @throws IOException
	 */
	public static void action(HttpServletResponse resp, String actionCode) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<script>");
		writer.println(actionCode);
		writer.println("</script>");
		writer.close();
	}
	
}
