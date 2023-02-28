package com.gyemoim.service.member;

import com.gyemoim.dao.member.MemberMypageDAO;
import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.MypageDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberMypageServiceImpl implements MemberMypageService {
   @Inject
    private MemberMypageDAO memberMypageDAO;

    //마이페이지 뷰
    @Override
    public MemberVO view(Integer uno) {
        System.out.println("회원정보 띄우기");
        MemberVO memberVO = null;
        try {
            memberVO = memberMypageDAO.view(uno);
        }catch (Exception e){
         e.printStackTrace();
         memberVO  = null;
        }
        return memberVO;
    }
    //마이페이지 수정

    @Override
    public void update(MypageDTO mypageDTO) throws Exception {
        System.out.println("회원정보 수정하기");
        memberMypageDAO.update(mypageDTO);
    }

    //마이페이지 삭제


    @Override
    public void delete(MemberVO memberVO) throws Exception {
        memberMypageDAO.delete(memberVO);
    }
}
