package com.gyemoim.dto.member;

import lombok.Data;


@Data
public class MypageDTO {
    Integer uno;//회원번호
    String name; //이름
    String password; //비번
    String phone; //전화번호
    String bankName; //은행
    Integer bankAccountNumber; //계좌번호
    String address; //주소
    String addresscode;// 우편번호
    String addressdetail;// 상세주소

}
