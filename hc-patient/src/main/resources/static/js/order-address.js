
layui.use(['layer', 'laytpl','form'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var laytpl = layui.laytpl;
    var form = layui.form;

    var addressList = function () {
        $.get("/address/list", function (addresses) {
            laytpl($("#template1").html()).render(addresses, function (a) {
                $(".addressModel").html(a)
            });

            $(".address-list").on("click", ".tool", function () {
                $(".address-list .tool").removeClass("on");
                $(this).addClass("on");
            });

            $(".setdft").on("click", function () {
                var a = $(this);
                $.post("/address/default/" + a.attr("aid"), function (result) {
                    $(".col.col-4 .item").removeClass("active");
                    a.closest('.item').addClass("active");
                    layer.msg(result.msg)
                });
            });

            $(".del").on("click", function () {
                var a = $(this);
                $.post("/address/delete/" + a.attr("aid"), function (result) {
                    layer.msg(result.msg)
                    addressList();
                });
            });

            $(".edit").on("click", function () {
                var a = $(this);
                var i = a.attr("index");
                var address = addresses[i];
                var count = $("#count").html();
                $(".addressModel").html($("#template2").html());
                new Vue({
                    el: "#app",
                    data: function () {
                        return {
                            visible: false,
                            codeToText: elementChinaAreaData.codeToText,
                            pcaTextArr: elementChinaAreaData.pcaTextArr,
                            selectedOptions4: [address.province, address.city, address.area],
                        };
                    }
                });
                $("#count").html(count);
                form.val("newAddress", address);

                $("#cancel").on("click", function () {
                    addressList();
                });

                $("#save").on("click", function () {
                    var data = form.val("newAddress");
                    // console.log(data);
                    // console.log($("#area").html());
                    var a = JSON.parse($("#area").html());
                    data.province = a[0];
                    data.city = a[1];
                    data.area = a[2];

                    var flag = true;

                    $.each(data, function (index,item) {
                        if (!item && index != "id") {
                            flag = false;
                        }
                    });

                    if (!flag) {
                        layer.msg("请补全信息")
                        return false;
                    }

                    $.post("/address/save", data, function (result) {
                        layer.msg(result.msg);
                        addressList();
                    });
                });
            });

            $("#addAddress").on("click", function () {
                if (addresses.length >= 5) {
                    layer.msg("地址数量已达到上限")
                    return false;
                }
                var count = $("#count").html();
                $(".addressModel").html($("#template2").html());
                new Vue({
                    el: "#app",
                    data: function () {
                        return {
                            visible: false,
                            codeToText: elementChinaAreaData.codeToText,
                            pcaTextArr: elementChinaAreaData.pcaTextArr,
                            selectedOptions4: [],
                        };
                    }
                });

                $("#count").html(count);

                $("#cancel").on("click", function () {
                    addressList();
                });

                $("#save").on("click", function () {
                    var data = form.val("newAddress");
                    console.log(data);
                    console.log($("#area").html());
                    var a = JSON.parse($("#area").html());
                    data.province = a[0];
                    data.city = a[1];
                    data.area = a[2];

                    var flag = true;

                    $.each(data, function (index,item) {
                        if (!item && index != "id") {
                            flag = false;
                        }
                    });

                    if (!flag) {
                        layer.msg("请补全信息")
                        return false;
                    }

                    $.post("/address/save", data, function (result) {
                        layer.msg(result.msg);
                        addressList();
                    });
                });
            });
        });

    };
    addressList();
});