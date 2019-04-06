function checkNewPassword() {
    var newPassword = document.getElementById("newPassword").value;
    var newPasswordStateSpan = document.getElementById("newPasswordStateSpan");
    var newPasswordStateDiv = document.getElementById("newPasswordStateDiv");
    var reg=/^.{6,20}$/i;
    if (reg.test(newPassword)) {
        newPasswordStateSpan.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        newPasswordStateDiv.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        newPasswordStateSpan.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        newPasswordStateDiv.setAttribute("class","form-group has-error has-feedback");
        return false;
    }
}

function checkNewPassword1() {
    var newPassword = document.getElementById("newPassword").value;
    var newPassword1 = document.getElementById("newPassword1").value;
    var newPasswordStateSpan1 = document.getElementById("newPasswordStateSpan1");
    var newPasswordStateDiv1 = document.getElementById("newPasswordStateDiv1");
    if (null!=newPassword && null!=newPassword1 && newPassword==newPassword1 && ""!=newPassword1) {
        newPasswordStateSpan1.setAttribute("class","glyphicon glyphicon-ok form-control-feedback");
        newPasswordStateDiv1.setAttribute("class","form-group has-success has-feedback");
        return true;
    }else {
        newPasswordStateSpan1.setAttribute("class","glyphicon glyphicon-remove form-control-feedback");
        newPasswordStateDiv1.setAttribute("class","form-group has-error has-feedback");
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
    // var newPassword = checkNewPassword();
    // var newPassword1 = checkNewPassword1();
    var age = checkAge();
    var email = checkEmail();
    if( age && email ){
        return true;
    }else{
        return false;
    }
}
