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
    @Override
    public void write(BoardWriteDTO dto) throws Exception{
        System.out.println("들어와라 쫌"+dto);
        sqlSession.insert(namespace + "BoardWriteMapper.write", dto);
        //return session.selectOne(namespace +".write", dto);
    }

    @Override
    public void addAttach(String fileName) throws Exception {
        System.out.println("첨부파일" + fileName);
        sqlSession.insert(namespace + "BoardWriteMapper.addAttach", fileName);
    }

    /*수정페이지*/
    @Override
    public void modify(BoardWriteDTO dto) throws Exception {
        sqlSession.update(namespace + "BoardWriteMapper.modify", dto);

    }


}
