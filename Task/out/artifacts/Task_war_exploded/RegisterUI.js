function checkName() {//校验用户名规则
    var userName = document.getElementById("userName").value;
    var userNameStateSpan = document.getElementById("userNameStateSpan");
    var userNameStateDiv = document.getElementById("userNameStateDiv");
    var reg=/^[a-z0-9]\w{2,15}$/i;
    if (reg.test(userName)){
        userNameStateSpan.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        userNameStateDiv.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        userNameStateSpan.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        userNameStateDiv.setAttribute("class","form-group has-error has-feedback");
        return false;
    }
}

function checkPassword() {
    var password = document.getElementById("password").value;
    var passwordStateSpan = document.getElementById("passwordStateSpan");
    var passwordStateDiv = document.getElementById("passwordStateDiv");
    var reg=/^.{6,20}$/i;
    if (reg.test(password)) {
        passwordStateSpan.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        passwordStateDiv.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        passwordStateSpan.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        passwordStateDiv.setAttribute("class","form-group has-error has-feedback");
        return false;
    }
}

function checkPassword1() {
    var password = document.getElementById("password").value;
    var password1 = document.getElementById("password1").value;
    var passwordStateSpan1 = document.getElementById("passwordStateSpan1");
    var passwordStateDiv1 = document.getElementById("passwordStateDiv1");
    if (null!=password && null!=password1 && password==password1 && ""!=password1) {
        passwordStateSpan1.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        passwordStateDiv1.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        passwordStateSpan1.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        passwordStateDiv1.setAttribute("class","form-group has-error has-feedback");
        return false;
    }
}

//检查邮箱
function checkEmail(){
    var email = document.getElementById("email").value;
    var emailStateSpan = document.getElementById("emailStateSpan");
    var emailStateDiv = document.getElementById("emailStateDiv");

    //编写邮箱的正则       13456@qq.com  13456@qq.net  13456@qq.com.cn
    var reg = /^[a-z0-9]\w+@[a-z0-9]+(\.[a-z]{2,3}){1,2}$/i;
    if(reg.test(email) || email==null ||email==""){
        emailStateSpan.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        emailStateDiv.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        emailStateSpan.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        emailStateDiv.setAttribute("class","form-group has-error has-feedback");
        return false;
    }
}

function checkAge(){
    var age = document.getElementById("age").value;
    var ageStateSpan = document.getElementById("ageStateSpan");
    var ageStateDiv = document.getElementById("ageStateDiv");

    var reg = /^[0-9]{0,2}$/i;
    if(reg.test(age) || null==age){
        ageStateSpan.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        ageStateDiv.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        ageStateSpan.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        ageStateDiv.setAttribute("class","form-group has-error has-feedback");
        return false;
    }
}

function checkAll(){
    var userName = checkName();
    var password = checkPassword();
    var password1 = checkPassword1();
    var age = checkAge();
    var email = checkEmail();
    if(userName && password && password1 && age && email ){
        return true;
    }else{

        return false;
    }
}
