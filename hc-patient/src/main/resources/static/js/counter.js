
$(".playtitle p").eq(0).on("click",function(){
    $(this).addClass("active1").siblings().removeClass("active1")
    $(".erweima").css("display","none")
    $(".playkind p").css("display","block")

})
$(".playtitle p").eq(1).on("click",function(){
    $(this).addClass("active1").siblings().removeClass("active1")
    $(".erweima").css("display","block")
    $(".playkind p").css("display","none")

})

$(".playkind p").on("click",function(){
    $(this).addClass("active2").siblings().removeClass("active2")
    
})
