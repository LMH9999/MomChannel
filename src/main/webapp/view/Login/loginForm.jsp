<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<%@ include file="../include/header.jsp"%>

<div class="content-login">
    <script>
        function validateForm(form){
            if(!form.memId.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            if (form.memPw.value == ""){
                alert("패스워드를 입력하세요.");
                return false;
            }
        }
    </script>
    <h2>로그인 페이지</h2>
    <form action="../../member/login.do" method="post" onsubmit="return validateForm(this);">
        아이디 : <input type="text" name="memId" /><br/>
        패스워드 : <input type ="password" name="memPw" /><br/>
        <input type="submit" value="로그인하기" />
    </form>
</div>

<%@ include file="../include/footer.jsp"%>