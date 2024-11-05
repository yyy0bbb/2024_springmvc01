package com.ict.member.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.member.dao.MemberDAO;
import com.ict.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	

	@Override
	public MemberVO getMemberLogIn(String m_id) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.getMemberLogIn(m_id);
	}



	
	
}
