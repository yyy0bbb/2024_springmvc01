package com.ict.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.bbs.vo.BbsVO;
import com.ict.bbs.vo.CommVO;

@Repository
public class BbsDAOImpl implements BbsDAO{
	
	
	@Autowired 
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<BbsVO> getBbsList() {
		
		return sqlSessionTemplate.selectList("bbs.list");
	}

	@Override
	public int getBbsInsert(BbsVO bvo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("bbs.insert", bvo);
	}

	@Override
	public BbsVO getBbsDetail(String b_idx) {
		return sqlSessionTemplate.selectOne("bbs.detail", b_idx);
	}

	@Override
	public int getBbsDelete(String b_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("bbs.delete", b_idx);
	}

	@Override
	public int getBbsUpdate(BbsVO bvo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("bbs.update", bvo);
	}

	@Override
	public int getHitUpdate(String b_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("bbs.hitupdate", b_idx);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("bbs.count");
	}

	@Override
	public List<BbsVO> getBbsList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("limit", limit);
		map.put("offset", offset);
		
		// 함수가 2개라서 변환해줘야 한다.
		return sqlSessionTemplate.selectList("bbs.pageList", map);
	}

	@Override
	public List<CommVO> getCommentList(String b_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("bbs.clist", b_idx);
	}

	@Override
	public int getCommentInsert(CommVO cvo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("bbs.cinsert",cvo);
	}

	@Override
	public int getCommentDelete(String c_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("bbs.cdelete", c_idx);
	}

}
