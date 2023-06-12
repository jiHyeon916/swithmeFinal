package com.kh.swithme.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.swithme.admin.model.dao.AdminDao;
import com.kh.swithme.admin.model.vo.QNAReply;
import com.kh.swithme.board.model.vo.Board;
import com.kh.swithme.common.model.vo.PageInfo;
import com.kh.swithme.member.model.vo.Member;
import com.kh.swithme.member.model.vo.QNA;

@Service
public class AdminServiceImpl implements AdminService {

   @Autowired
   private AdminDao adminDao;
   
   @Autowired
   private SqlSessionTemplate sqlSession;
   
   
   
   
   //지현
   
   //회원들의 count조회(페이징)
   @Override
   public int selectMemberCount() {
      return adminDao.selectMemberCount(sqlSession);
   }
   
   //회원들 모두 조회(페이징)
   @Override
   public ArrayList<Member> adminMemberList(PageInfo pi) {
      return adminDao.adminMemberList(sqlSession, pi);
   }
   //검색한 키워드가 포함된 결과 count(페이징)
   @Override
   public int selectMemberSearchCount(HashMap<String, String> map) {
      return adminDao.selectMemberSearchCount(sqlSession, map);
   }
   //검색 결과 페이징
   @Override
   public ArrayList<Member> selectMemberSearchList(HashMap<String, String> map, PageInfo pi) {
      return adminDao.selectMemberSearchList(sqlSession, map,pi);
   }
   //회원 상태 조회
   @Override
   public Member memberStatus(String memberId) {
      return adminDao.memberStatus(sqlSession,memberId);
   }
   //회원정지해제
   @Override
   public int memberStopFree(String memberId) {
      return adminDao.memberStopFree(sqlSession,memberId);
   }

   // 회원 정지
   @Override
   public int memberStop(String memberId) {
      return adminDao.memberStop(sqlSession,memberId);
   }

   //회원 디테일 조회정보(select)
	@Override
	public ArrayList<Board> memberDetailInfo(String memberId) {
		return adminDao.memberDetailInfo(sqlSession, memberId);
	}
	   
	   
	
	// 이유진 ----------------------------------------
	
	// 문의글 리스트 조회 + 페이징처리
	// 모든 문의글 수 가져오기
	@Override
	public int selectQnaListCount(String qnaStatus) {
		return adminDao.selectQnaListCount(sqlSession, qnaStatus);
	}

	// 모든 문의글 리스트 조회
	@Override
	public ArrayList<QNA> selectQnaList(PageInfo pi, String qnaStatus) {
		return adminDao.selectQnaList(sqlSession, pi, qnaStatus);
	}
	
	// 문의글 답변 INSERT
	@Override
	public int insertQnaReply(QNAReply qr) {
		return adminDao.insertQnaReply(sqlSession, qr);
	};
	
	// 문의글 답변 목록 출력
	@Override
	public ArrayList<QNAReply> selectQnaReply(int qnaNo) {
		return adminDao.selectQnaReply(sqlSession, qnaNo);
	};
	
	// 문의글 답변여부 상태변화
	@Override
	public int qnaStatusUpdate(int qnaNo) {
		return adminDao.qnaStatusUpdate(sqlSession, qnaNo);
	};
	
	
	// 문의글 답변 삭제
	@Override
	public int qnaReplyDelete(int qnaNo) {
		return adminDao.qnaReplyDelete(sqlSession, qnaNo);
	};
   
   
   
   
}