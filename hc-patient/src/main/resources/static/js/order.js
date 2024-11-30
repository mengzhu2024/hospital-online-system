// ------------主页js相关功能
// ---------头部跳转--------------
// ------登录注册跳转--------
/*$(".toLogin").on("click", function () {
    let href = location.href;
    setSessData("lochref", href)
    setTimeout(function () {
        window.location.href = "./login.html"
    }, 1000)
})*/
/*$(".toRegist").on("click", function () {
    setTimeout(function () {
        window.location.href = "./register.html"
    }, 1000)
})*/
// ----------跳转首页--------------
/*$(".toindex").on("click", function () {
    setTimeout(function () {
        window.location.href = "./index.html"
    }, 1000)
})*/
// ------------两个购物车入口---------
/*$(".shoppinp-card").on("click", function () {
    let cookie = getCookie('username');
    if (cookie) {
        setTimeout(function () {
            window.location.href = "./shopingcart.html"
        }, 1000)
    } else {
        window.location.href = "./login.html"
    }
})*/
// --------登录成功显示用户名-----
/*$(window).on("load", function () {
    // 存储当前页地址，可实现从当前页登录返回当前页
    setSessData("lochref", location.href)
    let cookie = getCookie('username');
    if (cookie) {  // 如果有这个cookie，登陆过
        $(".login-after").css("display", "block");
        $(".login-before").css("display", "none");
        $(".welcome").html(cookie)
        // --------------将数据库内容渲染到购物车---------
        addShoppingCart()
    } else {
        $(".login-after").css("display", "none");
        $(".login-before").css("display", "block");
    }
})*/
// -------退出--------
/*$(".tuichu").on("click", function () {
    delCookie("username");
    location.reload()
})*/



// ========================================
// -------将数据库内容渲染到购物车---------
/*function addShoppingCart() {
    $.ajax({
        type: "get",
        url: "../goodsAndShoppingCart/getShoppingCart.php",
        processData: true,
        data: {
            "vipName": getCookie('username')
        },
        dataType: "json",
        success: function (data) {
            let str = "";
            let count = 0;
            let money = 0;
            data.forEach(function (intm, index) {
                str += `<ul>
                    <li class="shop-img"><img src="${intm.beiyong6}"></li>
                    <li class="shop-name">${intm.goodsName}</li>
                    <li class="inpur-num">x<span>${intm.goodsCount}</span> </li>
                    <li class="xiaoji">￥ ${parseInt(intm.goodsPrice) * intm.goodsCount}</li>
                </ul>`
                count += intm.goodsCount / 1
                money += parseInt(intm.goodsPrice) * intm.goodsCount      
            })
            $(".left main").html(str)
            $("#money").html(money)
        }
    })
}*/

// ---------收货信息------------
$(".car-list .address").on("click", function () {
    $(".location").css("display", "block")
})

/*$(".quxiao").on("click", function () {
    $(".location").css("display", "none")
})
$(".queren").on("click", function () {
    $("#newaddress .name").html($(".location .name").val())
    $("#newaddress .addr").html($(".location #place").val())
    $("#newaddress .phone").html($(".location .phone").val())
    $(".location").css("display", "none")
    // $(".address").css("display", "none")
    // $("section").css("display", "block")
})*/

// ------------书写地址-----------
$("#place").on("input", function () {
    $.ajax({
        type: "get",
        url: 'https://map.baidu.com/su',
        data: {
            wd: $("#place").val(),
            cid: "233",
            type: "0"
        },
        // 支持跨域访问
        dataType: 'jsonp',
        success: function (data) {
            console.log(data);
            let arr = data.s
            let str = ""
            for (i = 0; i < 5; i++) {
                str += `<li>${arr[i].split("$").join("").split("233")[0]}</li>`
                console.log(str);
            }
            $(".location ul").html(str)
        }
    })
})
// -----------点击地址获取---------
/*$(".location").on("click", "li", function () {
    $("#place").val($(this).html())
    $(".location ul").css("display", "none")
})*/
// -------提交订单跳转------------
/*
$(".right .account").on("click", function () {
    setTimeout(function () {
        window.location.href = "counter.html"
    }, 500)
})*/
