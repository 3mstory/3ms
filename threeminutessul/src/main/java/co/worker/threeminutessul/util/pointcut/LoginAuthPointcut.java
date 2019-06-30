package co.worker.threeminutessul.util.pointcut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.bridge.MessageUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import co.worker.threeminutessul.util.NewPageAction;

@Component
@Aspect
public class LoginAuthPointcut {
	
	@Pointcut("execution(* co.worker.threeminutessul.*.*.*Controller.*(..))")
	public void loginauth() {}
	
	@Before("loginauth()")
	public void commonAuth(JoinPoint joinPoint){
		Object[] obj = joinPoint.getArgs(); //request,response,session
		HttpSession session = (HttpSession)obj[2];
		try {
			if(session.getAttribute("userid")==null && session.getAttribute("userSeq")==null) {
				//로그인정보가 없으면 -> 쫓겨나야함. 로그인 페이지로.
				HttpServletRequest request = (HttpServletRequest)obj[0];
				HttpServletResponse response = (HttpServletResponse)obj[1];
				if(request.getRequestURL().toString().contains("/boardList.tmssul")
				 ||request.getRequestURL().toString().contains("/loginok.tmssul")
				 ||request.getRequestURL().toString().contains("/logoutOk.tmssul") 
				) {return;} //지금페이지가 mainpage면 괜찮다.
				
				String actionCode ="alert('로그인을 하고 진행해주시기 바랍니다.');";
				actionCode+="location.href='/threeminutessul/boardList.tmssul';";
				NewPageAction.action(response, actionCode);
			}//있으면 괜찮
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
