package com.gyemoim.dao.board;

import com.gyemoim.dto.board.BoardWriteDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class BoardWriteDAOImpl implements BoardWriteDAO {
    @Inject
    private SqlSession sqlSession;
    private static String namespace = "com.gyemoim.dao.board.BoardWriteDAO";
    //글 쓰기
    @Override
    public void write(BoardWriteDTO dto) throws Exception{
        System.out.println("들어와라 쫌"+dto);
        sqlSession.insert(namespace + "BoardWriteMapper.write", dto);
        //return session.selectOne(namespace +".write", dto);
    }
    //첨부파일 쓰기
    @Override
    public void addAttachedName(String savedName) throws Exception {
        System.out.println("파일이름" + savedName);
        sqlSession.insert(namespace + "BoardWriteMapper.addAttachedName", savedName);
    }

}
