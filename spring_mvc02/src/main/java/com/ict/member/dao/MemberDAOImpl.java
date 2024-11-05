package com.ict.member.dao;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public MemberVO getMemberLogIn(String m_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("member.login", m_id);
	}



}
