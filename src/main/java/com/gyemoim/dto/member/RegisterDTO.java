package com.gyemoim.dto.member;

public class RegisterDTO {
  String email; //이메일
  String password; //패스워드
  String name; //이름
  String ssn; //주민등록번호
  String phone; //전화번호
  String address; //주소
  String addresscode;// 우편번호
  String addressdetail;// 상세주소

  public String getAddresscode() {
    return addresscode;
  }

  public void setAddresscode(String addresscode) {
    this.addresscode = addresscode;
  }

  public String getAddressdetail() {
    return addressdetail;
  }

  public void setAddressdetail(String addressdetail) {
    this.addressdetail = addressdetail;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


}
