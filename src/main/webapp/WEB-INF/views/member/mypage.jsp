<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Page Content-->
<section class="py-5">
  <div class="container px-5 my-5">
    <div class="row gx-5">
      <div class="col-lg-3">

        <div>
          <!-- Sidebar-->
          <div class="ms-3">
            <div class="border-end bg-white">
              <div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
              <div class="list-group list-group-flush">
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Dashboard</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Shortcuts</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Overview</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
              </div>
            </div>
          </div> <!--border-end bg-white-->
        </div> <!-- ms-3-->
        <!--sidebar 여기까지-->
      </div>


      <!-- col-lg-3의 자식-->
      <div class="col-lg-9">
        <article><!--본문 시작-->
          <!-- Post title-->
          <h1 class="fw-bolder mb-1">마이 페이지</h1>
          <!-- 일반회원 기본 노출 -->
          <form action="/member/mypage/update" method="post">
            <!--마이페이지-->
            <div id="personInfo">
              <!--테이블 형식으로 보여줄거니까 table시작-->
              <table class="person-tb">
                <tbody>
                <tr>
                  <th>회원번호</th>
                  <td>
                    <input type="text"
                           name="uNo"
                           id="uNo"
                           value="${my.getUNo()}"
                           class="form-control"
                           readonly="readonly">
                  </td>
                </tr>

                <tr>
                  <th>이름</th>
                  <td>
                    <input type="text"
                           name="name"
                           id="name"
                           value="${my.name}"
                           class="form-control">
                  </td>
                </tr>

                <tr>
                  <th>아이디</th>
                  <td>
                    <input type="text"
                           name="email"
                           id="email"
                           value="${my.email}"
                           class="form-control"
                           readonly="readonly">
                  </td>
                </tr>

                <tr>
                  <th>비밀번호</th>
                  <td>
                    <input type="password"
                           name="password"
                           id="password"
                           class="form-control "
                           value=""
                           placeholder="비밀번호는 4~16자로 입력해 주세요.">
                  </td>
                </tr>

                <tr>
                  <th>비밀번호 확인</th>
                  <td>
                    <input type="password"
                           name="password2"
                           id="password2"
                           class="form-control "
                           value="">
                  </td>
                </tr>

                <tr>
                  <th>주민등록번호</th>
                  <td>
                    <input type="text"
                           name="ssn"
                           id="ssn"
                           value="${my.ssn}"
                           readonly="readonly"
                           style="background-color: #e9ecef;border: 1px solid #ced4da;">

                  </td>
                </tr>

                <tr>
                  <th>휴대폰</th>
                  <td>
                    <input type="text" id="phone" name="phone" value="${my.phone}">
                  </td>
                </tr>

                <tr>
                  <th>은행</th>
                  <td>
                    <div>
                      <select name="bankName" id="bankName">
                        <option value="">은행명</option>
                        <option value="KEB하나">KEB하나</option>
                        <option value="SC제일">SC제일</option>
                        <option value="국민">국민</option>
                        <option value="신한">신한</option>
                        <option value="우리">우리</option>
                        <option value="농협">농협</option>
                        <option value="토스">토스</option>
                        <option value="카카오">카카오뱅크</option>
                      </select>
                      <input type="text"
                             name="bankAccountNumber"
                             value="${my.bankAccountNumber}(${my.bankName})"
                             placeholder="'-'를 빼고 입력해주세요."
                             style="width:70%" ;>
                    </div>
                  </td>
                </tr>

                <tr>
                  <th>신용등급</th>
                  <td>
                    <input type="text"
                           name="creditRating"
                           id="creditRating"
                           value="${my.creditRating}"
                           class="form-control"
                           readonly="readonly">
                  </td>
                </tr>

                <tr>
                  <th>추가이율</th>
                  <td>
                    <input type="text"
                           name="plusRate"
                           id="plusRate"
                           value="${my.plusRate}"
                           class="form-control"
                           readonly="readonly">
                  </td>
                </tr>

                <tr>
                  <th>무단이탈횟수</th>
                  <td>
                    <input type="text"
                           name="count"
                           id="count"
                           value="${my.count}"
                           class="form-control"
                           readonly="readonly">
                  </td>
                </tr>

                <tr>
                  <th>가입일</th>
                  <td>
                    <input type="text"
                           name="enrollDate"
                           id="enrollDate"
                           value="${my.enrollDate}"
                           class="form-control"
                           readonly="readonly">
                  </td>
                </tr>

                <!--주소-->
                <tr>
                  <th>주소</th>
                  <td>
                    <input type="text"
                           name="address"
                           class="postcodify_postcode5"
                           placeholder="우편번호">
                    <button type="button" id="postcodify_search_button" class="btn btn-primary">주소검색</button>
                    <span class="input_area">
                                        <input type="text" name="address" class="form-control postcodify_address"
                                               placeholder="주소">
                                        <input type="text" name="address" class="form-control postcodify_address"
                                               placeholder="상세주소">
                                    </span>
                  </td>
                </tr>
                </tbody>
              </table>
              <div class="btnArea join-footer py-5">
                <button type="submit" value="수정하기" class="btn btn-primary btn-lg px-4 me-sm-3"
                        onclick="location.href='write.jsp'"/>
                수정하기</button>
              </div>
            </div>
          </form>
        </article>
      </div>
    </div>
  </div>
</section>


