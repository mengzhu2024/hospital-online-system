function ajax(options) {  //options--->对象
    let xhr = new XMLHttpRequest();
    if (options.type.toLowerCase() == 'get') {
        xhr.open("get", options.url + "?" + options.data);//携带请求参数到后端
        xhr.send()
    }
    if (options.type.toLowerCase() == 'post') {
        xhr.open("post", options.url);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        // post请求需要把请求参数写在 send中，但是不能带"""
        xhr.send(options.data);
    }
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            options.success(xhr.responseText);
        }
    }
}
// 获取指定键名的cookie值得
function getCookie(key) {
    let cookie = document.cookie; //'username=zhangsan; password=123456'
    var arr = cookie.split("; "); // ["username=zhangsan","password=123456",...]
    for (let i = 0; i < arr.length; i++) {
        //  arr[i] --- >  "username=zhangsan"   或者  "password=123456"
        let item = arr[i].split("=");  // item[0] -->键     item[1]---》值
        if (item[0] == key) {
            return item[1]; // 返回结果， 终止函数
        }
    }
    return "";
}
// 设置cookie的
function setCookie(key, value, day) {
    // let date = new Date(); //当前本地时间
    // date.setDate(date.getDate() + day);  // 修改日期对象
    // document.cookie = key + '=' + value + ';expires=' + date;
    let d = new Date();
    d.setDate(d.getDate() + day); // 修改过期时间   d是一个时间对象，7天后的日期对象
    document.cookie = key+'='+value+';expires=' + d;
}
// 删除cookie的
function delCookie(key) {
    setCookie(key, "", -1);
}
//localStorage数据存储技术
//存储
function setLocalData(key, data) {
    localStorage.setItem(key, JSON.stringify(data));
  }
  //获取 
  function getLocalData(key) {
    var collection = localStorage.getItem(key);
    if (collection != null) {
      return JSON.parse(collection);
    } else {
      return [];
    }
  }
    //删除
    function delLocalData(key) {
        sessionStorage.removeItem(key);
      }
      //清空
      function delLocalData() {
        sessionStorage.clear();
      }
//sessionStorage数据存储技术
//存储
function setSessData(key, data) {
    sessionStorage.setItem(key, JSON.stringify(data));
  }
  //获取 
  function getSessData(key) {
    var collection = sessionStorage.getItem(key);
    if (collection != null) {
      return JSON.parse(collection);
    } else {
      return [];
    }
  }
  //删除
  function delSessData(key) {
    sessionStorage.removeItem(key);
  }
  //清空
  function delSessData() {
    sessionStorage.clear();
  }
  
/*  
  url:
  data: {"username":"张三","userpass":"123456" }
  success: function(msg){}
*/
function $jsonp(options,x) {
    var oScrc = document.createElement('script');
    //  window[fn]:将fn函数挂载在全局作用域下
    // 将传入的函数 转为window对象下
    var fn = 'myfn'+Math.random().toString().replace('.','');
    // fn随机函数名
    window[fn] = options.success;
    oScrc.src = options.url + '?'+x+'=' + fn+'&' + getParams(options.data);
    document.body.appendChild(oScrc);
    oScrc.onload = function () {
        this.remove();
    }
}
// 将js对象{}转为字符串拼接的形式  username=zhangsa&password=12345
function getParams(obj){
    var arr = [];
    for(var k in obj){
      arr.push(k+'='+obj[k]);
    }
    return arr.join('&');
}
// -------------倒计时-----------------------
function getCountDown(str) {
    let date = new Date(); //只要new出来的都是object
    let date1 = new Date(str)
    let seconds = (date1.getTime() - date.getTime()) / 1000; //现在时间距离618这个时间亳秒差
    //换算成xx天xx小时xx分钟xx秒
    let yum = parseInt(seconds % 60);// 还剩多少秒(除不尽，余下的就是剩余的秒数)
    let yuf = parseInt(seconds / 60 % 60);// 还剩多少分(除不尽，余下的就是剩余的分)
    let yuh = parseInt(seconds / 60 / 60 % 24)
    // var yut = parseInt(seconds / 60 / 60 / 24)
    yuh = yuh < 10 ? "0" + yuh : yuh;
    yuf = yuf < 10 ? "0" + yuf : yuf;
    yum = yum < 10 ? "0" + yum : yum;
    let objtime = { "shi": yuh, "fen": yuf, "miao": yum }
    return objtime;
}
