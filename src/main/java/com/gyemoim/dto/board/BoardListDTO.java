package com.gyemoim.dto.board;


import lombok.Data;

@Data
public class BoardListDTO {// 어떤 유형으로 검색하는지 저장하는 type과 검색 내용인 keyword 를 추가
    private int bid;
    private String name;
    private String title;
    private String views;
    private String content;
    private String writeDate;

    // 검색필터
    private String type;// 검색 타입
    private String keyword;// 검색 내용

}
