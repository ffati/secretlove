
$(function() {

    lodingbackground();
    inintsomething();
    lodinghidden();

});


function musicSwitch(){

    var switchbar=$("#musicSource");

    $(".musicSwitch").click(function () {



    })


};


layui.use(['form'], function() {
    var form = layui.form


    form.on('submit(laysearchbutton)', function(data){

        $(".mainsearchform").submit();


    });

});

//初始准备
function inintsomething() {

    //输入框
    $(".searchinput").focus(function (){
        var tipslength=$(".searchinput").val();
        if (tipslength.length==0){
            $(".toolTips").text("请输入你的名字或昵称搜索哦");
            $(".toolTips").show();
        } else {
            $(".toolTips").text("按回车键或点击右边按钮以搜索");
            $(".toolTips").show();
        }

    });

    $(".searchinput").blur(function (){

        $(".toolTips").css('display','none');

    });

    $(".searchinput").on('input propertychange',function (){

        $(".toolTips").text("按回车键或点击右边按钮以搜索");
    });

    /*主页搜索*/
    $(".searchinput").keypress(function (e) {

        var searchlength=$(".searchinput").val();
        if (e.which == 13&&searchlength.length>0) {
            $(".mainsearchform").submit();
        }
    });



};
/*等待界面图片*/
function lodinghidden() {

    document.onreadystatechange = function () {//即在加载的过程中执行下面的代码
        if(document.readyState=="complete"){//complete加载完成

            $(".lodingdiv").slideUp(2000);
        }
    };

};
/*随机图片*/
function lodingbackground() {

    randombackground("lodingdiv");

};





/*    new Effect({
        //特效图片，多张图片时传入数组，单个图片时传入字符串
        effectUrl: ["../img/stars/1.png", "../img/stars/2.png", "../img/stars/3.png", "../img/stars/4.png",
            "../img/stars/5.png", "../img/stars/6.png", "../img/stars/7.png", "../img/stars/8.png", "../img/stars/9.png"],
        //特效旋转，1/true为旋转，0/false为不旋转
        rotate: 1,
        //特效方向，left/right/up/down
        direction: "up"
    });*/