$(function () {

    //globalVariable();
    togglemenu();
    lodingbackground();
    initializationMonitoringEvents();
    chooseMenu();
});


window.tokenparam = $("meta[name='_csrf']").attr("content");
window.headerparam = $("meta[name='_csrf_header']").attr("content");
window.screenHeight = $(window).height();
window.screenWidth = $(window).width();
window.aspectRatio = screenWidth / screenHeight;
window.effectStartsArr = ["../img/specialEffectsImg/stars/1.png", "../img/specialEffectsImg/stars/2.png", "../img/specialEffectsImg/stars/3.png", "../img/specialEffectsImg/stars/4.png",
    "../img/specialEffectsImg/stars/5.png", "../img/specialEffectsImg/stars/6.png", "../img/specialEffectsImg/stars/7.png", "../img/specialEffectsImg/stars/8.png", "../img/specialEffectsImg/stars/9.png"];

window.effectheartArr = ["../img/specialEffectsImg/heart/heart1.svg", "../img/specialEffectsImg/heart/heart2.svg", "../img/specialEffectsImg/heart/heart3.svg", "../img/specialEffectsImg/heart/heart4.svg",
    "../img/specialEffectsImg/heart/heart5.svg", "../img/specialEffectsImg/heart/heart6.svg", "../img/specialEffectsImg/heart/heart7.svg", "../img/specialEffectsImg/heart/heart8.svg",
    "../img/specialEffectsImg/heart/heart9.svg", "../img/specialEffectsImg/heart/heart10.svg", "../img/specialEffectsImg/heart/heart11.svg", "../img/specialEffectsImg/heart/heart12.svg"];

window.effectrandomArr = ["../img/specialEffectsImg/random/random1.svg", "../img/specialEffectsImg/random/random2.svg",
    "../img/specialEffectsImg/random/random3.svg", "../img/specialEffectsImg/random/random4.svg",
    "../img/specialEffectsImg/random/random5.svg", "../img/specialEffectsImg/random/random6.svg",
    "../img/specialEffectsImg/random/random7.svg", "../img/specialEffectsImg/random/random8.svg",
    "../img/specialEffectsImg/random/random9.svg", "../img/specialEffectsImg/random/random10.svg",
    "../img/specialEffectsImg/random/random11.svg", "../img/specialEffectsImg/random/random12.svg",
    "../img/specialEffectsImg/random/random13.svg", "../img/specialEffectsImg/random/random14.svg",
    "../img/specialEffectsImg/random/random15.svg", "../img/specialEffectsImg/random/random16.svg",
    "../img/specialEffectsImg/random/random17.svg"];


function chooseMenu() {

    if (aspectRatio < 1) {
        $(".gifmenu").hide();
        $(".annularmenu").show();
        $(".maindiv2").css("width", "100%");
        $(".maindiv2").css("left", "0px");
        $(".maindiv2").css("z-index", "989");
        $(".inputtextdiv").css("width", "100%");

    }

    if (screenHeight < 400) {

        $(".menuimgdiv").css("margin", (screenHeight - 150) / 15 + "px");

    }

}


/*需要初始化监听的事件*/
function initializationMonitoringEvents() {


    $(".headimgdiv").mousedown(function () {
        $(this).css({"width": "60px", "height": "60px"});
        $(".headimg").css({"width": "60px", "height": "60px"});
    });

    $(".headimgdiv").mouseup(function () {
        $(this).css({"width": "50px", "height": "50px"});
        $(".headimg").css({"width": "50px", "height": "50px"});
    });

    $(".headimg").dblclick(function () {
        $(".headimgForm").submit();
    });


    var musicSource = $("#musicSource")[0];
    $("#musiccontroller").click(function () {

        if (musicSource.paused && $(this).hasClass("musicPlay")) {
            $(".layui-anim").addClass("layui-anim-scale");
            musicSource.play();
        } else if (!musicSource.paused && $(this).hasClass("musicPause")) {
            $(".layui-anim").removeClass("layui-anim-scale");
            musicSource.pause();
        } else {
            $(".layui-anim").removeClass("layui-anim-scale");
            musicSource.pause();
        }
        $(this).toggleClass("musicPause musicPlay");

    });


};


/*需要初始化拖拽的元素*/
window.onload = function () {//即在加载的过程中执行下面的代码
    if (document.readyState == "complete") {//complete加载完成
        dragFunc("removablediv");
        dragFunc2("maindiv1", "headimgdiv");
    }
};

/*第一种拖拽*/
function dragFunc(id) {
    var Drag = document.getElementById(id);
    Drag.onmousedown = function (event) {
        var ev = event || window.event;
        event.stopPropagation();
        var disX = ev.clientX - Drag.offsetLeft;
        var disY = ev.clientY - Drag.offsetTop;
        document.onmousemove = function (event) {
            var ev = event || window.event;
            Drag.style.left = ev.clientX - disX + "px";
            Drag.style.top = ev.clientY - disY + "px";
            Drag.style.cursor = "move";
        };
    };
    Drag.onmouseup = function () {
        document.onmousemove = null;
        this.style.cursor = "default";
    };
};


/*第二种拖拽*/
function dragFunc2(parentClassName, innerClassName) {
    var oDiv = document.getElementsByClassName(innerClassName)[0];
    var oParent = document.getElementsByClassName(parentClassName)[0];
    var sent = {
        l: 0,
        r: oParent.offsetWidth - oDiv.offsetWidth,
        t: 0,
        b: oParent.offsetHeight - oDiv.offsetHeight,
        n: 10
    }
    drag(oDiv, sent);
};

function drag(obj, sent) {
    var dmW = document.documentElement.clientWidth || document.body.clientWidth;
    var dmH = document.documentElement.clientHeight || document.body.clientHeight;
    var sent = sent || {};
    var l = sent.l || 0;
    var r = sent.r || dmW - obj.offsetWidth;
    var t = sent.t || 0;
    var b = sent.b || dmH - obj.offsetHeight;
    var n = sent.n || 10;
    obj.onmousedown = function (ev) {
        var oEvent = ev || event;
        var sentX = oEvent.clientX - obj.offsetLeft;
        var sentY = oEvent.clientY - obj.offsetTop;
        document.onmousemove = function (ev) {
            var oEvent = ev || event;
            var slideLeft = oEvent.clientX - sentX;
            var slideTop = oEvent.clientY - sentY;
            if (slideLeft <= l) {
                slideLeft = l;
            }
            if (slideLeft >= r) {
                slideLeft = r;
            }
            if (slideTop <= t) {
                slideTop = t;
            }
            if (slideTop >= b) {
                slideTop = b;
            }
            obj.style.left = slideLeft + 'px';
            obj.style.top = slideTop + 'px';
        }
        document.onmouseup = function () {
            document.onmousemove = null;
            document.onmouseup = null;
        }
        return false;
    }
}


function togglemenu() {

    $(".mainmenu").dblclick(function () {
        $(".mainmenu").toggleClass("showmenu hidemenu");
        $('.togglediv').animate({width: 'toggle'}, 200);
    });

};


/*随机背景图片*/
function lodingbackground() {

    randombackground("backgroundimg");
    randombackground("scrollingBackgroundimg");

};


function randombackground(classstring) {

    var imgurl = 'url("/img/lodingbgpicture/lodingbgpicture';
    var imgnumber = Math.round(Math.random() * 16 + 1);
    var imgfinalurl = imgurl + imgnumber + '.jpg")';
    console.log(imgfinalurl);
    $("." + classstring).css('background-image', imgfinalurl);


};


function ajaxForForm(className, postOrGet, urlString, dateClassName, asyncValue, refresh ,redirectUrl) {

    //var transferDate=$("."+dateClassName).serialize();
    $("." + className).click(function () {
        $.ajax({
            type: postOrGet,
            url: urlString,
            headers: {//请求头
                Accept: "application/json; charset=utf-8",
                "X-CSRF-TOKEN": tokenparam  //这是获取的token
            },
            /*eforeSend: function(request) {      //使用beforeSend
                request.setRequestHeader(headerparam, tokenparam);
                request.setRequestHeader("Content-Type","application/json");*/
            dataType: 'json',
            data: $("." + dateClassName).serialize(),
            async: asyncValue,//按照js顺序执行
            /*processData: false,
            contentType: false,*/
            success: function (message) {
                if (refresh) {
                    layer.alert(message.information, function () {
                        window.location.reload();
                    });
                }else {
                    layer.msg(message.information);
                };

                if (redirectUrl.length>2){
                    window.location.href=redirectUrl;

                } ;
            },
            error: function () {
                layer.msg("发生意外!");
            }
        });
    })

}


function ajaxcommon(postOrGet, urlString, datastring, asyncValue, Refresh) {

    $.ajax({
        type: postOrGet,
        url: urlString,
        headers: {//请求头
            Accept: "application/json; charset=utf-8",
            "X-CSRF-TOKEN": tokenparam  //这是获取的token
        },
        /*eforeSend: function(request) {      //使用beforeSend
            request.setRequestHeader(headerparam, tokenparam);
            request.setRequestHeader("Content-Type","application/json");*/
        dataType: 'json',
        data: datastring,
        async: asyncValue,//按照js顺序执行
        /*processData: false,
        contentType: false,*/
        success: function (message) {
            if (Refresh) {
                layer.alert(message.information, function () {
                    window.location.reload();
                });
            } else {
                layer.msg(message.information);
            }

        },
        error: function () {
            layer.msg("发生意外!");
        }
    });

}


    /*json对象属性数量*/
    function getJsonLength(jsonData) {
        var jsonLength = 0;
        for (var item in jsonData) {
            jsonLength++;
        }
        return jsonLength;
    };


