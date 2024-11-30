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
    } else {
        $(".login-after").css("display", "none");
        $(".login-before").css("display", "block");
    }
})*/
// -------退出--------
$(".tuichu").on("click", function () {
    delCookie("username");
    location.reload()
})
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
    // $("html,body").css("overflow", "hidden")
    $(".header-buttom-bg .header1").hide();
    $(".header-buttom-bg .header-sousuo").show(500);
})
$(".header-sousuo .quxiao").on("click", function () {
    $(".inputsousuo").val('');
})

/*$(".header-sousuo .quxiao").on("click", function () {
    $("html,body").css("overflow", "visible")
    setTimeout(function () {
        $(".header-buttom-bg .header-sousuo").hide(0);
        $(".header-buttom-bg .header1").show();
    }, 500)
})*/
// -------------头部导航功能---------------
$(".header-top-right .line").hover(function () {
    $(this).find("ul").show()
}, function () {
    $(this).find("ul").hide()
})
// ---------------秒杀倒计时------------------
/*let shi = document.querySelector(".shi")
let fen = document.querySelector(".fen")
let miao = document.querySelector(".miao ")
setInterval(function () {
    let time = getCountDown("2022/7/17")
    miao.innerHTML = time.miao;
    fen.innerHTML = time.fen;
    shi.innerHTML = time.shi;
}, 1000)*/
// ----------轮播图-----------------
var mySwiper = new Swiper('.swiper-container', {
    direction: 'horizontal', // 垂直切换选项
    loop: true, // 循环模式选项
    autoplay: true,
    // 如果需要分页器
    pagination: {
        el: '.swiper-pagination',
    },
    // 如果需要前进后退按钮
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
    // 如果需要滚动条
    scrollbar: {
        el: '.swiper-scrollbar',
    },
})
// ------二级菜单-----------

$(".menu").on("mouseover", ".menulist", function () {
    $(this).find(".list-2").show()
})
$(".menu").on("mouseout", ".menulist", function () {
    $(this).find(".list-2").hide()
})
$(".menu").on("mouseout", ".list-2", function () {
    $(this).hide()
})
// ---------二级菜单数据----------
/*let menuData = {
    "手机": [{ "img": "../images/imagedata/menu1-1.png", "text": "Mate系列" },
    { "img": "../images/imagedata/menu1-2.png", "text": "P系列" },
    { "img": "../images/imagedata/menu1-3.png", "text": "nova系列" },
    { "img": "../images/imagedata/menu1-4.png", "text": "畅享系列" },
    { "img": "../images/imagedata/menu1-5.png", "text": "华为认证二手机系列" }],
    "电脑": [{ "img": "../images/imagedata/menu2-1.png", "text": "MateBook X系列" },
    { "img": "../images/imagedata/menu2-2.png", "text": "显示器" },
    { "img": "../images/imagedata/menu2-3.png", "text": "MateBook系列" },
    { "img": "../images/imagedata/menu2-4.png", "text": "台式机" },
    { "img": "../images/imagedata/menu2-5.png", "text": "MateBook D系列" },
    { "img": "../images/imagedata/menu2-6.png", "text": "打印机" },
    { "img": "../images/imagedata/menu2-7.png", "text": "MateBook E系列" },
    { "img": "../images/imagedata/menu2-8.png", "text": "配件" },
    { "img": "../images/imagedata/menu2-9.png", "text": "商用电脑" },
    { "img": "../images/imagedata/menu2-10.png", "text": "电脑包" }],
    "平板": [{ "img": "../images/imagedata/menu3-1.jpg", "text": "MatePad Pro系列" },
    { "img": "../images/imagedata/menu3-2.jpg", "text": "MatePad系列" },
    { "img": "../images/imagedata/menu3-3.jpg", "text": "墨水平板" },
    { "img": "../images/imagedata/menu3-4.jpg", "text": "M系列和畅享平板" },
    { "img": "../images/imagedata/menu3-5.jpg", "text": "MateBook E系列" },
    { "img": "../images/imagedata/menu3-6.jpg", "text": "商用平板" },
    { "img": "../images/imagedata/menu3-7.jpg", "text": "配件" }],
    "智慧屏": [{ "img": "../images/imagedata/menu4-1.jpg", "text": "智慧屏V系列" },
    { "img": "../images/imagedata/menu4-2.jpg", "text": "华为智慧屏 SEMEMC" },
    { "img": "../images/imagedata/menu4-3.jpg", "text": "华为智慧屏 SE" },
    { "img": "../images/imagedata/menu4-4.jpg", "text": "智慧屏S系列" },
    { "img": "../images/imagedata/menu4-5.jpg", "text": "学习智慧屏" },
    { "img": "../images/imagedata/menu4-6.jpg", "text": "商用智慧屏" },
    { "img": "../images/imagedata/menu4-7.jpg", "text": "配件" },
    { "img": "../images/imagedata/menu4-8.jpg", "text": "办公协作大屏" }],
    "穿戴": [{ "img": "../images/imagedata/menu5-1.jpg", "text": "经典全能" },
    { "img": "../images/imagedata/menu5-2.jpg", "text": "专业极致" },
    { "img": "../images/imagedata/menu5-3.jpg", "text": "VR" },
    { "img": "../images/imagedata/menu5-1.jpg", "text": "经典全能" },
    { "img": "../images/imagedata/menu5-2.jpg", "text": "专业极致" },
    { "img": "../images/imagedata/menu5-3.jpg", "text": "VR" },
    { "img": "../images/imagedata/menu5-1.jpg", "text": "经典全能" },
    { "img": "../images/imagedata/menu5-2.jpg", "text": "专业极致" },
    { "img": "../images/imagedata/menu5-3.jpg", "text": "VR" }],
    "耳机音响": [{ "img": "../images/imagedata/menu6-1.jpg", "text": "智能眼镜" },
    { "img": "../images/imagedata/menu6-2.jpg", "text": "颈带式耳机" },
    { "img": "../images/imagedata/menu6-3.jpg", "text": "智能音箱" },
    { "img": "../images/imagedata/menu6-1.jpg", "text": "智能眼镜" },
    { "img": "../images/imagedata/menu6-2.jpg", "text": "颈带式耳机" },
    { "img": "../images/imagedata/menu6-3.jpg", "text": "智能音箱" },
    { "img": "../images/imagedata/menu6-1.jpg", "text": "智能眼镜" },
    { "img": "../images/imagedata/menu6-2.jpg", "text": "颈带式耳机" },
    { "img": "../images/imagedata/menu6-1.jpg", "text": "智能眼镜" },
    { "img": "../images/imagedata/menu6-2.jpg", "text": "颈带式耳机" },
    { "img": "../images/imagedata/menu6-3.jpg", "text": "智能音箱" },
    { "img": "../images/imagedata/menu6-1.jpg", "text": "智能眼镜" },
    { "img": "../images/imagedata/menu6-2.jpg", "text": "颈带式耳机" },
    { "img": "../images/imagedata/menu6-3.jpg", "text": "智能音箱" }],
    "门锁路由": [{ "img": "../images/imagedata/menu7-1.jpg", "text": "精品路由" },
    { "img": "../images/imagedata/menu7-2.jpg", "text": "华为智能门锁" },
    { "img": "../images/imagedata/menu7-3.jpg", "text": "全屋WIFI" },
    { "img": "../images/imagedata/menu7-1.jpg", "text": "精品路由" },
    { "img": "../images/imagedata/menu7-3.jpg", "text": "全屋WIFI" },
    { "img": "../images/imagedata/menu7-1.jpg", "text": "精品路由" },
    { "img": "../images/imagedata/menu7-2.jpg", "text": "华为智能门锁" },
    { "img": "../images/imagedata/menu7-3.jpg", "text": "全屋WIFI" }],
    "配件": [{ "img": "../images/imagedata/menu8-1.jpg", "text": "摄像机&镜头" },
    { "img": "../images/imagedata/menu8-2.jpg", "text": "个人电脑配件" },
    { "img": "../images/imagedata/menu8-3.jpg", "text": "电脑包" },
    { "img": "../images/imagedata/menu8-2.jpg", "text": "个人电脑配件" },
    { "img": "../images/imagedata/menu8-3.jpg", "text": "电脑包" },
    { "img": "../images/imagedata/menu8-2.jpg", "text": "个人电脑配件" },
    { "img": "../images/imagedata/menu8-3.jpg", "text": "电脑包" }],
    "生态产品": [{ "img": "../images/imagedata/menu9-1.jpg", "text": "运动健身" },
    { "img": "../images/imagedata/menu9-2.jpg", "text": "健身保健" },
    { "img": "../images/imagedata/menu9-3.jpg", "text": "个护美妆" },
    { "img": "../images/imagedata/menu9-2.jpg", "text": "健身保健" },
    { "img": "../images/imagedata/menu9-3.jpg", "text": "个护美妆" },
    { "img": "../images/imagedata/menu9-2.jpg", "text": "健身保健" },
    { "img": "../images/imagedata/menu9-3.jpg", "text": "个护美妆" }],
    "家用电器": [{ "img": "../images/imagedata/menu10-1.jpg", "text": "扫地清洁" },
    { "img": "../images/imagedata/menu10-2.jpg", "text": "空气净化器" },
    { "img": "../images/imagedata/menu10-3.jpg", "text": "厨电卫浴" },
    { "img": "../images/imagedata/menu10-2.jpg", "text": "空气净化器" },
    { "img": "../images/imagedata/menu10-3.jpg", "text": "厨电卫浴" },
    { "img": "../images/imagedata/menu10-2.jpg", "text": "空气净化器" },
    { "img": "../images/imagedata/menu10-3.jpg", "text": "厨电卫浴" },
    { "img": "../images/imagedata/menu10-2.jpg", "text": "空气净化器" },
    { "img": "../images/imagedata/menu10-3.jpg", "text": "厨电卫浴" }],
    "美食酒饮": [{ "img": "../images/imagedata/menu11-1.jpg", "text": "甄选美酒" },
    { "img": "../images/imagedata/menu11-2.jpg", "text": "严选良食" },
    { "img": "../images/imagedata/menu11-3.jpg", "text": "进口生鲜" },
    { "img": "../images/imagedata/menu11-1.jpg", "text": "甄选美酒" },
    { "img": "../images/imagedata/menu11-2.jpg", "text": "严选良食" },
    { "img": "../images/imagedata/menu11-3.jpg", "text": "进口生鲜" },
    { "img": "../images/imagedata/menu11-1.jpg", "text": "甄选美酒" },
    { "img": "../images/imagedata/menu11-2.jpg", "text": "严选良食" },
    { "img": "../images/imagedata/menu11-3.jpg", "text": "进口生鲜" }],
    "增值服务": [{ "img": "../images/imagedata/menu12-1.jpg", "text": "花币卡" },
    { "img": "../images/imagedata/menu12-2.jpg", "text": "手机延保" },
    { "img": "../images/imagedata/menu12-3.jpg", "text": "平板延保" },
    { "img": "../images/imagedata/menu12-1.jpg", "text": "花币卡" },
    { "img": "../images/imagedata/menu12-2.jpg", "text": "手机延保" },
    { "img": "../images/imagedata/menu12-3.jpg", "text": "平板延保" },
    { "img": "../images/imagedata/menu12-1.jpg", "text": "花币卡" },
    { "img": "../images/imagedata/menu12-2.jpg", "text": "手机延保" },
    { "img": "../images/imagedata/menu12-3.jpg", "text": "平板延保" },
    { "img": "../images/imagedata/menu12-1.jpg", "text": "花币卡" },
    { "img": "../images/imagedata/menu12-2.jpg", "text": "手机延保" },
    { "img": "../images/imagedata/menu12-3.jpg", "text": "平板延保" }]
}*/
// --------------渲染二级菜单---------------
/*let str1 = ""
for (let key1 in menuData) {
    str1 += `<div class="menulist">
            <div class="list-1">
                <div class="text">${key1}</div>
                <div class="iconfont icon-youjiantou"></div>
            </div>
            <div class="list-2">`
    for (i = 0; i < menuData[key1].length; i++) {
        str1 += `<dl>
                  <dt><img src="${menuData[key1][i].img}"></dt>
                  <dd>${menuData[key1][i].text}</dd>
              </dl>`
    }
    str1 += `</div></div>`
    $('.menu').html(str1)
}*/
// ==========加载完请求数据==========
$(window).on("load", function () {
    // getGoodsType()//商品类型
    // getPronews() //新品
    // getProspike() //秒杀
    // getProtimel() //限时
    // getProbaokuan()//爆款
    // getProshouji() //手机
    // getPropingban() //平板
    // getProbijibeng()//笔记本
})
// -----------新品商品-------------
function getPronews() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "001",
            "count": "4"
        },
        dataType: "json",
        success: function (data) {
            let str2 = ""
            data.forEach(function (item, index) {
                str2 += `<div class="news">
                <span class="shop-id">${item.goodsId}</span>
                <img src="${item.goodsImg}">
                </div>`

            })
            $(".pro-new").html(str2)
        }
    })
}

// ---------点击跳转功能--------------
/*$(".pro-new").on("click", ".news", function () {
    setSessData("shop-id", $(this).find(".shop-id").html())
    setTimeout(function () {
        location.href = "./commodpage.html"
    }, 500)
})*/
// -----------限时秒杀功能------
function getProspike() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "002",
            "count": "4"
        },
        dataType: "json",
        success: function (data) {
            let str3 = ""
            data.forEach(function (item, index) {
                str3 += `<div class="box-spike box-1">
                <span class="shop-id">${item.goodsId}</span>
                <div class="pro-img"><img src="${item.goodsImg}"></div>
                <div class="miaosha">超级秒杀</div>
                <div class="info-1">
                    <div class="pro-name">${item.goodsName}</div>
                    <div class="pro-detail">${item.goodsType}</div>
                    <div class="price">￥ ${item.goodsPrice}</div>
                </div>
                </div>`

            })
            $(".pro-spike .content").append(str3)
        }
    })
}
// ------------点击跳转功能--------------
/*$("body").on("click", ".box-1", function () {
    setSessData("shop-id", $(this).find(".shop-id").html())
    setTimeout(function () {
        location.href = "./commodpage.html"
    }, 500)
})*/

// -----------限时购功能------
function getProtimel() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "003",
            "count": "5"
        },
        dataType: "json",
        success: function (data) {
            let str3 = ""
            data.forEach(function (item, index) {
                str3 += `<div class="box-timel box-1">
                <span class="shop-id">${item.goodsId}</span>
                <div class="pro-img"><img width="177" height="154" src="${item.goodsImg}"></div>
                <div class="info-1">
                    <div class="pro-name">${item.goodsName}</div>
                    <div class="pro-detail">${item.goodsType}</div>
                    <div class="price">￥ ${item.goodsPrice}</div>
                </div>
                </div>`

            })
            $(".timel-imit .content").prepend(str3)
        }
    })
}
// -----------爆款推荐功能------
function getProbaokuan() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "004",
            "count": "1"
        },
        dataType: "json",
        success: function (data) {
            let str4 = ""
            for (i = 0; i < 8; i++) {
                data.forEach(function (item, index) {
                    str4 += `<div class="list box-1">
                    <span class="shop-id">${item.goodsId}</span>
                    <div class="shop-img">
                        <img src="${item.goodsImg}">
                    </div>
                    <div class="text">
                        <div class="shoptext">
                            <div class="newshop">新品上市</div>
                            <div class="shopname">${item.goodsName}</div>
                        </div>
                        <div class="shop-price">￥ ${item.goodsPrice}</div>
                    </div>
                    </div>`
                })
            }
            $(".models .content").append(str4)
        }
    })
}
// -----------手机专区功能------
function getProshouji() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "005",
            "count": "1"
        },
        dataType: "json",
        success: function (data) {
            let str5 = ""
            for (i = 0; i < 8; i++) {
                data.forEach(function (item, index) {
                    str5 += `<div class="list box-1">
                    <span class="shop-id">${item.goodsId}</span>
                    <div class="shop-img">
                    <img src="${item.goodsImg}">
                    </div>
                    <div class="text">
                    <div class="shopname">${item.goodsName}</div>
                        <div class="pro">${item.goodsType}</div>
                        <div class="shop-price">￥ ${item.goodsPrice}</div>
                        <div class="shop-youhui">
                            <span>限时特惠</span>
                            <span>赠送积分</span>
                        </div>
                    </div>
                </div>`
                })
            }
            $(".phone .content").append(str5)
        }
    })
}
// -----------精品平板功能------
function getPropingban() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "006",
            "count": "1"
        },
        dataType: "json",
        success: function (data) {
            let str6 = ""
            for (i = 0; i < 8; i++) {
                data.forEach(function (item, index) {
                    str6 += `<div class="list box-1">
                    <span class="shop-id">${item.goodsId}</span>
                    <div class="shop-img">
                    <img src="${item.goodsImg}">
                    </div>
                    <div class="text">
                    <div class="shopname">${item.goodsName}</div>
                        <div class="pro">${item.goodsType}</div>
                        <div class="shop-price">￥ ${item.goodsPrice}</div>
                        <div class="shop-youhui">
                            <span>限时特惠</span>
                            <span>分期免息</span>
                        </div>
                    </div>
                </div>`
                })
            }
            $(".pingban .content").append(str6)
        }
    })
}
// -----------笔记本功能------
function getProbijibeng() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsListNew.php",
        processData: true,
        data: {
            "typeId": "007",
            "count": "1"
        },
        dataType: "json",
        success: function (data) {
            let str4 = ""
            for (i = 0; i < 8; i++) {
                data.forEach(function (item, index) {
                    str4 += `<div class="list box-1">
                    <span class="shop-id">${item.goodsId}</span>
                    <div class="shop-img">
                    <img src="${item.goodsImg}">
                    </div>
                    <div class="text">
                    <div class="shopname">${item.goodsName}</div>
                        <div class="pro">${item.goodsType}</div>
                        <div class="shop-price">￥ ${item.goodsPrice}</div>
                        <div class="shop-youhui">
                            <span>限时特惠</span>
                            <span>赠送积分</span>
                        </div>
                    </div>
                </div>`
                })
            }
            $(".bijibeng .content").append(str4)
        }
    })
}
// -------获取商品种类--------
/*
function getGoodsType() {
    $.ajax({
        url: "../goodsAndShoppingCart/getGoodsType.php",
        processData: true,
        data: {},
        dataType: "json",
        success: function (data) {
            data.forEach(function (item, index) {
                $(".tit-left").eq(index).html(item.goodsType)
            })
        }
    })
}
*/

/*
bannerGet()
function bannerGet() {
    $.ajax({
        type: "get",
        url: "../goodsAndShoppingCart/bannerGet.php",
        processData: true,
        data: {},
        dataType: "json",
        success: function (data) {
            str9 = ""
            data.forEach(function (item, index) {
                str9 += `<div class="swiper-slide"><img src="${item.img}"></div>`
            })
            $(".banner .swiper-wrapper").html(str9)
        }
    })
}
*/


$(".inputsousuo").on("input", function () {
    getSousuo()
})
function getSousuo() {
    $.ajax({
        type: "get",
        url: "https://www.baidu.com/sugrec",
        processData: true,
        data: {
            "prod": "pc",
            "wd": $(".inputsousuo").val()
        },
        dataType: "jsonp",
        success: function (data) {
            let msg = data.g;
            let str9 = ""
            for (i = 0; i < 6; i++) {
                str9 += `<a>${msg[i].q}</a>`
            }
            $(".header-sousuo .neirong").html(str9)
        }
    })
}
