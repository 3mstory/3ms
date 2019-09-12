package co.worker.threeminutessul.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import co.worker.threeminutessul.login.model.LoginVO;
import co.worker.threeminutessul.login.service.LoginServiceIF;
import co.worker.threeminutessul.user.model.UserVO;
import co.worker.threeminutessul.util.JavaUtil;
import co.worker.threeminutessul.util.NewPageAction;

@Controller
public class LoginController {
	
	@Autowired
	private LoginServiceIF service;
	
	@RequestMapping(value = "/loginok.tmssul", method = { RequestMethod.POST })
	public void loginok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, LoginVO vo,Model model) throws Exception{
		//로그인 인증 갔다가.
		UserVO user = service.loginauth(vo);
		String actionCode = "";
		if(user != null) {//로그인 성공.
			session.setAttribute("userSeq", user.getUserSeq());
			session.setAttribute("userid", user.getUserid());
			session.setAttribute("nickname", user.getNickname());
			req.setAttribute("user", user);
			actionCode = "alert('환영합니다.'); location.href='/threeminutessul/boardList.tmssul';";
		}else {//로그인실패
			actionCode = "alert('회원정보가 없습니다.'); history.back();";
		}
		NewPageAction.action(resp, actionCode);
	}
	
	@RequestMapping(value = "/logoutOk.tmssul", method = { RequestMethod.GET })
	public void logoutOk(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws Exception {
		session.invalidate();
		String actionCode = "alert('로그아웃되었습니다.'); location.href='/threeminutessul/boardList.tmssul';";
		NewPageAction.action(resp, actionCode);
	}
}
