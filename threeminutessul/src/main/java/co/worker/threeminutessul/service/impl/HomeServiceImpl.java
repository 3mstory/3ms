package co.worker.threeminutessul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.dao.HomeDaoIF;
import co.worker.threeminutessul.service.HomeServiceIF;

@Service
public class HomeServiceImpl implements HomeServiceIF{
	
	@Autowired
	private HomeDaoIF dao;

	@Override
	public String auth(String id, String pw) {
		return dao.auth(id,pw);
	}
	
}
