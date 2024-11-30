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
// --------登录成功显示用户名-----
/*$(window).on("load", function () {
    let cookie = getCookie('username');
    if (cookie) {  // 如果有这个cookie，登陆过
        $(".login-after").css("display", "block");
        $(".login-before").css("display", "none");
        $(".welcome").html(cookie)
        getGoodsInfo()
    } else {
        $(".login-after").css("display", "none");
        $(".login-before").css("display", "block");
    }
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
// ----划出一段距离返回顶部------
$(window).on("scroll", function () {
    if ($(window).scrollTop() > 600) {
        $(".backtop").fadeIn(500)
    } else {
        $(".backtop").fadeOut(500)
    }
})
$(".backtop").on("click", function () {
    $("html,body").animate({  // 让body和html回到顶部
        scrollTop: 0
    }, 1000)
})
// ---------------------------------
// ------------搜索切换按钮--------------
$(".header-buttom .sousuo").on("click", function () {
    $("html,body").scrollTop("0")
    $("html,body").css("overflow", "hidden")
    $(".header-buttom-bg .header1").hide();
    $(".header-buttom-bg .header-sousuo").show(500);
})
$(".header-sousuo .quxiao").on("click", function () {
    $("html,body").css("overflow", "visible")
    setTimeout(function () {
        $(".header-buttom-bg .header-sousuo").hide(0);
        $(".header-buttom-bg .header1").show();
    }, 500)
})
// -------------头部导航功能---------------
$(".header-top-right .line").hover(function () {
    $(this).find("ul").show()

}, function () {
    $(this).find("ul").hide()
})
// ----------放大镜--------------
//放大镜移入移除
$(".product-gallery-img").hover(function () {
    $(".cloud-zoom").show()
    $(".product-magnifier").show()
}, function () {
    $(".cloud-zoom").hide()
    $(".product-magnifier").hide()
})
//计算移动距离
$(".product-gallery-img").on("mousemove", function (e) {
    let l = e.pageX - $(".product-gallery-img").offset().left - $(".cloud-zoom").outerWidth() / 2;
    let t = e.pageY - $(".product-gallery-img").offset().top - $(".cloud-zoom").outerHeight() / 2;
    if (l <= 0) {
        l = 0
    }
    if (l > $(".product-gallery-img").innerWidth() - $(".cloud-zoom").outerWidth()) {
        l = $(".product-gallery-img").innerWidth() - $(".cloud-zoom").outerWidth()
    }
    if (t <= 0) {
        t = 0
    }
    if (t > $(".product-gallery-img").innerWidth() - $(".cloud-zoom").outerWidth()) {
        t = $(".product-gallery-img").innerWidth() - $(".cloud-zoom").outerWidth()
    }
    $(".cloud-zoom").css("left", l + "px")
    $(".cloud-zoom").css("top", t + "px")
    // 计算比例
    let lvx = $(".product-gallery-img").innerWidth() / $(".cloud-zoom").outerWidth()
    let lvy = $(".product-gallery-img").innerHeight() / $(".cloud-zoom").outerHeight()
    $(".product-magnifier").css("background-position-x", -lvx * l + "px")
    $(".product-magnifier").css("background-position-y", -lvy * t + "px")
})
// 点击图片放大镜左侧同步显示
$(".product-gallery-nav li").on("click", function () {
    // console.log(this);
    $(this).addClass("active").siblings("li").removeClass("active")
    $(".product-gallery-img").css("background-image", `url("${$(this).find("img").prop("src")}")`)
    $(".product-magnifier").css("background-image", `url("${$(this).find("img").prop("src")}")`);
})
// ----------商品详情与评论切换
$(".xinxi>p").on("click", function () {
    $(this).addClass("active").siblings().removeClass("active");
    let index = $(this).index()
    if (index == 0) {
        $(".shop-data").show()
        $(".view-bg").hide()
    } else if (index == 3) {
        getComment()
        $(".shop-data").hide()
        $(".view-bg").show()
    } else {
        $(".shop-data").show()
        $(".view-bg").hide()
    }
})
// ----------页面中点击效果-------
$(".pro-right .you-same").on("click", function () {
    $(this).addClass("active2").siblings().removeClass("active2")
})

// -----------点击加入购物车----------------
/*$(".function .addcart").on("click", function () {
    addShoppingCart()
})*/

// ----------加入购物车后弹出框功能--------
/*$(".towhere .addcart").on("click", function () {
    setTimeout(function () {
        window.location.href = "./index.html"
    }, 1000)
})*/
/*$(".towhere .ordernow").on("click", function () {
    setTimeout(function () {
        window.location.href = "./shopingcart.html"
    }, 1000)
})*/

//---在首页点击商品跳入该商品详情----
//---将该商品有关信息渲染在页面-----
/*function getGoodsInfo() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsInfo.php",
        processData: true,
        data: {
            "goodsId": getSessData("shop-id")
        },
        success: function (data) {
            let res = JSON.parse(data);
            $(".pro-left .product-gallery-img").css("background-image", `url(${res.beiyong1})`);
            $(".pro-left .product-magnifier").css("background-image", `url(${res.beiyong1})`);
            for (i = 0; i < 5; i++) {
                for (let key in res) {
                    $(".product-gallery-nav li").eq(i).find("img").prop("src", res["beiyong" + (i + 1)]);
                    $(".shop-color .shop-col").eq(i).find("img").prop("src", res["beiyong" + (i + 1)]);
                    $(".shop-data img").eq(i).prop("src", res["beiyong" + (i + 7)]);
                }
            }
            $("#shop-id").html(res.goodsId);
            $(".pro-right .shop-name").html(res.goodsName);
            $(".pro-right .shop-price").html(res.goodsPrice);
        }
    })
}*/

// --------------点击加入购物车---------
/*function addShoppingCart() {
    $.ajax({
        type: "POST",
        url: "../goodsAndShoppingCart/addShoppingCart.php",
        processData: true,
        data: {
            "vipName": getCookie('username'),
            "goodsId": $("#shop-id").html(),
            "goodsCount": $("#num").html()
        },
        success: function (data) {
            console.log(data);
            // let res = JSON.parse(data);
            if (data == "1") {
                $(".shopname").html($(".shop-name").html())
                setInterval(function () {
                    $(".towhere").css("display", "block")
                }, 500)
            } else {
                alert("加入失败")
            }
        }
    })
}*/
// ---------------数量加功能--------
$(".function").on("click", "#addnum", function () {
    let num = $(this).parent().prev().html()
    num++
    $(this).parent().prev().html(num)
})
// ---------------数量减功能--------
$(".function").on("click", "#minnum", function () {
    let num = $(this).parent().prev().html()
    num--
    if (num < 1) {
        num = 1
    }
    $(this).parent().prev().html(num)
})

// ==========发表评论===============
/*$(".shopview .fasong").on("click", function () {
    addCommentd()
    getComment()
})*/
// -------添加商品评论-------


/*function addCommentd() {
    $.ajax({
        type: "POST",
        url: "../goodsAndShoppingCart/addComment.php",
        processData: true,
        data: {
            "vipName": getCookie('username'),
            "goodsId": $("#shop-id").html(),
            "content": $("#content").val()
        },
        dataType: "json",
        success: function (data) {
            console.log(data);
            // let res = JSON.parse(data);

        }
    })
}*/


/*function getComment() {
    console.log($("#shop-id").html());
    $.ajax({
        type: "get",
        url: "../goodsAndShoppingCart/getComment.php",
        processData: true,
        data: {
            "goodsId": $("#shop-id").html(),
            "pageCount": "20",
            "pageIndex": "1"
        },
        dataType: "json",
        success: function (msg) {
            let arrdata = JSON.parse(msg.data);
            str = ""
            for (i = 0; i < arrdata.length; i++) {
                str += `<ul><li>
                <div><span>用户名：</span>
                    <p class="vipname">${arrdata[i].vipName}</p>
                </div>
                <div><span>评论内容：</span>
                    <p class="content">${arrdata[i].content}</p>
                </div>
                </li>
                <li><div><span>发表于：</span>
                <p class="time">${arrdata[i].commentTime}</p></div>
                </li></ul>`
            }
            $(".viewcontent").html(str)
        }
    })
}*/


