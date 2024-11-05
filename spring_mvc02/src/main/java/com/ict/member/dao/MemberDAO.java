package com.ict.member.dao;



import com.ict.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO getMemberLogIn(String m_id) throws Exception;
}
