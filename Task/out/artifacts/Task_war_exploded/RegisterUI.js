function checkName() {//校验用户名规则
    var userName = document.getElementById("userName").value;
    var userNameState = document.getElementById("userNameState");
    var reg=/^[a-z0-9]\w{2,15}$/i;
    if (reg.test(userName)){
        userNameState.innerHTML="√";
        return true;
    }else {
        userNameState.innerHTML="×,由字母数字下划线组成的3-16位字符，下划线不能在首位";
        return false;
    }
}

function checkPassword() {
    var password = document.getElementById("password").value;
    var passwordState = document.getElementById("passwordState");
    var reg=/^.{6,20}$/i;
    if (reg.test(password)) {
        passwordState.innerHTML="√";
        return true;
    }else {
        passwordState.innerHTML="×,由6-20位字符组成"
        return false;
    }
}

function checkPassword1() {
    var password = document.getElementById("password").value;
    var password1 = document.getElementById("password1").value;
    var password1State = document.getElementById("password1State");
    if (password == password1 && ""!=password1) {
        password1State.innerHTML="√";
        return true;
    }else {
        password1State.innerHTML="×,请检查"
        return false;
    }
}