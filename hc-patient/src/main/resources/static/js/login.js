// 登录注册页面主要功能
//点击注册切换注册页
$("#regist").on("click", function () {
    setTimeout(function () {
        location.href = "../page/register.html"
    }, 1500)
})
//点击眼睛查看密码
$(".eye1").on("click", function () {
    $(this).css("display", "none").next().css("display", "block");
    $(this).prev().prop("type", "text");
})
$(".eye2").on("click", function () {
    $(this).css("display", "none").prev().css("display", "block");
    $(this).prev().prev().prop("type", "password");
});
//判断账号框和密码框是否为空
var flag = false;
$("form").on("input", ".put", function () {
    if (($(".put-0").val() == "") || ($(".put-1").val() == "")) {
        $(".button").css("background", "#eba7aa");
    } else {
        $(".button").css("background", "#ca141d");
        flag = true
    }
})
//点击登录按钮进行登录
/*$(".button").on("click", function () {
    if (flag) {
        $.ajax({
            type: "post",
            url: "../goodsAndShoppingCart/login.php",
            processData: true,
            data: {
                "username": $("#name").val(),
                "userpass": $("#pass").val()
            },
            success: function (data) {
                //success：表示注册成功  fail：表示注册失败
                if (data == "success") {
                   // 从哪来，回到那
                   location.href = getSessData("lochref")
                   //选择免登录，过期时间设置为7天
                   if ($(".login-checkbox").prop("checked")) {
                       setCookie("username", $("#name").val(), 7);
                       //可能此处传入本地库
                   } else {
                       document.cookie = `username=${$("#name").val()}`;
                   }
                } else {
                    $(".fail").css("display", "block")
                }
            }
        })
    }else{
        $(".fail").css("display", "block")
    }
})*/


