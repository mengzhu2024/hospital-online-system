// 登录注册页面主要功能
//点击注册切换注册页
/*$("#login").on("click", function () {
    setTimeout(function () {
        location.href = "../html/login.html"
    }, 1500)
})*/
//---------账号部分-------------------
//1、验证账号格式是否正确
var regflag1 = false;
var regUser = /^1[3456789]\d{9}$/;
$(".put-0").on("blur", function () {
    if (!regUser.test($(this).val())) {
        $(this).next().css("display", "block")
    } else {
        $(this).next().css("display", "none")
        regflag1 = true;
    }
})

//验证账号格式是否正确
var regflag4 = false;
var regUsername = /^[0-9a-zA-Z_]{5,20}$/;
$(".put-3").on("blur", function () {
    if (!regUsername.test($(this).val())) {
        $(this).next().css("display", "block")
    } else {
        $(this).next().css("display", "none")
        regflag4 = true;
    }
})

//2、验证密码格式是否正确
var regflag2 = false;
var regPass = /^\w{4,8}$/;
$(".put-1").on("blur", function () {
    if (!regPass.test($(this).val())) {
        $(this).parent().next().css("display", "block")
    } else {
        $(this).parent().next().css("display", "none")
        regflag2 = true;
    }
})
//3、验证密码是否与上次一样
var regflag3 = false;
$(".put-2").on("blur", function () {
    if ($(this).val() != $(".put-1").val()) {
        $(this).parent().next().css("display", "block")
    } else {
        $(this).parent().next().css("display", "none")
        regflag3 = true;
    }
})

//4、点击眼睛查看密码
$(".eye1").on("click", function () {
    $(this).css("display", "none").next().css("display", "block");
    $(this).prev().prop("type", "text");
})
$(".eye2").on("click", function () {
    $(this).css("display", "none").prev().css("display", "block");
    $(this).prev().prev().prop("type", "password");
})
// -----验证是否为空-----------
var flag = false;
$("form").on("input", ".put", function () {
    if (($(".put-0").val() == "") || ($(".put-1").val() == "") || ($(".put-2").val() == "") || ($(".put-3").val() == "") || ($(".put-4").val() == "")) {
        $(".button").css("background", "#eba7aa");
    } else {
        $(".button").css("background", "#ca141d");
        flag = true
    }
})
// ----------验证账号是否可用---------------

//验证用户名是否存在
let nameflag = false;
//用户失去一次焦点，向后端发送请求，查看输入的内容是否在数据库中存在
/*$(".put-0").on("blur", function () {
    $.ajax({
        type: "get",
        url: "../goodsAndShoppingCart/checkUser.php",
        processData: true,
        data: {
            "username": $(this).val()
        },
        success: function (data) {
            if (data == "1") {
                $(".exist").css("display", "none")
                nameflag = true;
            } else {
                $(".exist").css("display", "block")
            }
        }
    })
})*/
//如果不存在，执行注册
/*$(".button").on("click", function () {
    if (regflag1 && regflag2 && regflag3 && regflag4 && nameflag && flag) {
        $.ajax({
            type: "post",
            url: "../goodsAndShoppingCart/addUser.php",
            processData: true,
            data: {
                "username": $("#name").val(),
                "userpass": $("#pass").val()
            },
            success: function (data) {
                //success：表示注册成功  fail：表示注册失败
                if (data == "success") {
                    location.href = "../html/login.html";
                } else {
                    alert("注册失败");
                }
            }
        })
    }
})*/

