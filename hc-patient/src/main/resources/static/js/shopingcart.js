// ------------主页js相关功能
// ------登录注册跳转--------
/*$(".toLogin").on("click", function () {
    let href = location.href;
    setSessData("lochref", href);
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
// -------退出--------
/*$(".tuichu").on("click", function () {
    delCookie("username");
    location.reload()
})*/
$(".header-top-right .line").hover(function () {
    $(this).find("ul").show()

}, function () {
    $(this).find("ul").hide()
})
// --------登录成功显示用户名-----
/*$(window).on("load", function () {
    let cookie = getCookie('username');
    if (cookie) {  // 如果有这个cookie，登陆过
        $(".login-after").css("display", "block");
        $(".login-before").css("display", "none");
        $(".welcome").html(cookie)
        // ---------将数据库内容渲染到购物车---------
        addShoppingCart()
       
    } else {
        $(".login-after").css("display", "none");
        $(".login-before").css("display", "block");
        $(".noshopping").css("display", "block");
    }
})*/
// ----------购物车相关功能------------
// -----------修改购物车-------------
// -----------数量加功能--------
/*$("main").on("click", ".addnum", function () {
    let index= $(this).index(".addnum")
    let num = $(this).prev().val()
    num++
    $(this).prev().val(num)
    // --------修改数据库内容------
    /!*updateGoodsCount(index)
    addShoppingCart()*!/
})*/
// -----------数量减功能--------
/*$("main").on("click", ".minnum", function () {
    let index= $(this).index(".minnum")
    let num = $(this).next().val()
    num--
    if (num < 1) {
        num = 1
    }
    $(this).next().val(num)
    // --------修改数据库内容------
    /!*updateGoodsCount(index)
    addShoppingCart()*!/
})*/
// --------====-删除功能-------------
/*
$(".car-content").on("click", ".delshop", function () {
    let index= $(this).index(".delshop")
    deleteGoods(index)
    addShoppingCart()
})
*/

// ----------购物车多选单选功能------------
$("#check").on("click", function () {
    //先获取当前点击元素的状态 true/false
    let flag = $(this).prop('checked');
    $(".check").prop("checked", $(this).prop('checked')); //把点击元素的状态设置给下面所有的check
    if (!flag) {
        $(".check").removeClass('actv')
    } else {
        $(".check").addClass('actv')
    }
    getCheckData()

})
//-----给每一个选框添加点击事件------------
$("main").on("click",".check",function () {
    // console.log($(".check").eq(0).prop("checked"));
    $(this).toggleClass('actv')
    if ($(".check").length == $(".actv").length) {
        $("#check").prop("checked", true)
    } else {
        $("#check").prop("checked", false)
    }
    getCheckData()
})
//-----通过选框改变结算数据----------------
function getCheckData(){
    let count = 0;
    let money = 0;
    for (i = 0; i < $(".check").length; i++) {
        // console.log($(".check")[i].prop("checked"));
        if ($(".check").eq(i).prop("checked") == true) {
            count += $(".num").eq(i).val() / 1
            money += ($(".xiaoji").eq(i).html().split(" ")[1]) / 1
        }
    }
    $("#count").html(count)
    $("#money").html("¥ " + money.toFixed(2))
}
// -------------立即结算跳转订单页-------------
/*$(".cat-tool .account").on("click",function(){
   setTimeout(function(){
    window.location.href="./order.html"
   },500)
})*/
// ========================================
// -------将数据库内容渲染到购物车-----------
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
            if (data.length == 0) {
                $(".car-content main").html("")
                $(".noshopping").css("display", "block");
            } else {
                let str = "";
                let count = 0;
                let money = 0;
                data.forEach(function (intm, index) {
                    str += `<ul>
                <input type="checkbox" class="check actv">
                <b class="shop-img"><img src="${intm.beiyong6}"></b>
                <p class="shop-name">${intm.goodsName}</p>
                <div class="price">￥ ${intm.goodsPrice}</div>
                <div class="inpur-num">
                    <div class="minnum">-</div>
                    <input type="text" class="num" value="${intm.goodsCount}">
                    <div class="addnum">+</div>
                </div>
                <div class="xiaoji">￥ ${parseInt(intm.goodsPrice) * intm.goodsCount}</div>
                <div class="delshop">删除</div>
                <span class="shop-id">${intm.goodsId}</span>
                </ul>`
                    count += intm.goodsCount / 1
                    money += parseInt(intm.goodsPrice) * intm.goodsCount
                    $(".car-content main").html(str)
                })
                $("#check").prop("checked", true)
                $(".check").prop("checked", true)
                $("#count").html(count)
                $("#money").html("¥ " + money)
            }
        }
    })
}*/
// ----------修改购物车数量------------
/*function updateGoodsCount(i) {
    $.ajax({
        type: "get",
        url: "../goodsAndShoppingCart/updateGoodsCount.php",
        processData: true,
        data: {
            "vipName": getCookie('username'),
            "goodsId": $(".shop-id").eq(i).html(),
            "goodsCount": $(".num").eq(i).val()
        },
        dataType: "json",
        success: function (data) {
            console.log(data);
        }
    })
}*/
// ------------删除购物车-----------
/*function deleteGoods(i) {
    $.ajax({
        type: "get",
        url: "../goodsAndShoppingCart/deleteGoods.php",
        processData: true,
        data: {
            "vipName": getCookie('username'),
            "goodsId": $(".shop-id").eq(i).html(),
        },
        dataType: "json",
        success: function (data) {
            console.log(data);
        }
    })
}*/



