package com.gyemoim.controller.board;

import com.gyemoim.domain.board.AttachedVO;
import com.gyemoim.dto.board.BoardModifyDTO;
import com.gyemoim.service.board.BoardModifyService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class BoardModifyController {
    @Autowired
    private SqlSession sqlSession;
    @Inject
    private BoardModifyService boardModifyService;
    @Autowired
    private String uploadPath;
    String filePath = "/gyemoim/upload/";

    //원래 글, 첨부파일 끌어오기
    @RequestMapping(value = "/modify")
    public String modify(Model model, @RequestParam("bid") int bid) throws Exception {
        model.addAttribute("board", boardModifyService.modify(bid));
        model.addAttribute("attached", boardModifyService.attached(bid));
        return "board/modifyPage";
    }
    //글 수정하기
    @RequestMapping(value = "/modifyPost" ,method = RequestMethod.POST)
    public String modifyPost(BoardModifyDTO dto, RedirectAttributes request) throws Exception {
        System.out.println("들어오셨나요?");
        boardModifyService.modifyUpdate(dto);
        request.addFlashAttribute("message","Sucess!");
        return "redirect:/board/list";
    }

    // 원래 첨부파일 삭제하기
    @RequestMapping(value = "/removeImage" ,method = RequestMethod.POST)
        public ResponseEntity<String> removeImage(@RequestBody AttachedVO vo) {
            System.out.println("짜잔" + vo);
            ResponseEntity<String> entity = null;
            try {
                //딜리트 로직 타야함!!
                boardModifyService.deleteFile(vo.getFileName());
                entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
                System.out.println("여기도 쫌 찍혀줄래?" + vo + entity);
            } catch (Exception e) {
                e.printStackTrace();
                entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        return entity;
    }


        /*파일 다운로드(읽기페이지)*/
    @RequestMapping(value = "/fileDownload")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        //String path =  request.getSession().getServletContext().getRealPath("저장경로");
        String fileName =request.getParameter("fileName");
        String realFilename="";

        try {
            String browser = request.getHeader("User-Agent");
            //파일 인코딩
            if (browser.contains("MSIE") || browser.contains("Trident")
                    || browser.contains("Chrome")) {
                fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+",
                        "%20");
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException");
        }
        realFilename = uploadPath+filePath+ fileName;
        System.out.println(realFilename);

        File file1 = new File(realFilename);
        if (!file1.exists()) {
            return ;
        }

        // 파일명 지정
        response.setContentType("application/octer-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\"");
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(realFilename);
            System.out.println("여기도 찍혀줄래?");
            int ncount = 0;
            byte[] bytes = new byte[512];

            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            System.out.println("FileNotFoundException : " + e);
        }
    }

}
