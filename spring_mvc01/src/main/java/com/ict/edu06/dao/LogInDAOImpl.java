package com.ict.edu06.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu06.vo.LoginVO;


@Repository
public class LogInDAOImpl implements LoginDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


	@Override
	public LoginVO LoginChk(LoginVO lvo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("login.loginchk",lvo);
	}
	
	
	@Override
	public int LoginJoin(LoginVO lvo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("login.join", lvo);
	}

}
