function showUserName() {
    var info=document.getElementById("123");
    info.innerHTML="用户名是由字母数字下划线组成";

}
function register() {
    window.location.href='http://www.baidu.com';
}
function formReset()
{
    document.getElementById("userName").reset();
    document.getElementById("password").reset();
    document.getElementById("password").reset();
}
function resetImage(){
        var img=document.getElementById("checkImage");
        img.onclick=function () {
            var time = new Date().getTime();
            img.src="/Task/checkCodeServlet?"+time;
        }
}
