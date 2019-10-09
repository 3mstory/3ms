package co.worker.threeminutessul.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.worker.threeminutessul.user.dao.UserDaoIF;
import co.worker.threeminutessul.user.model.UserVO;
import co.worker.threeminutessul.user.service.UserServiceIF;
import co.worker.threeminutessul.util.loginsecure.SHA256Util;

@Service
public class UserServiceImpl implements UserServiceIF{
	
	@Autowired
	private UserDaoIF dao;

	@Override
	public int insertNewUser(UserVO vo,MultipartFile profile) {
		//암호화 처리.
		vo.setUserpw(SHA256Util.encrptSHA256(vo.getUserpw()));
		vo.setProfile(profile.getOriginalFilename());
		return dao.insertNewUser(vo);
	}

	@Override
	public int duplicateIdCheck(String inputId) {
		return dao.duplicateIdCheck(inputId);
	}
}
