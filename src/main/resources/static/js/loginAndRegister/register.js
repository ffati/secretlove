



layui.use(['form'], function() {
    var form = layui.form


    form.verify({
        inputlimit: function(value){

            if (value.length>30){
                return '太长啦';
            }
        }
        ,textarealimit: function(value){
            if(value.length < 5){
                return '太少啦';
            }
            if (value.length>500){
                return '如果有太多的话建议当面说哦';
            }
        }
        ,pass: [
            /^[\S]{6,12}$/
            ,'密码必须6到12位，且不能出现空格'
        ]

    });


    form.on('submit(layregistbutton)', function(data){

        ajaxForForm("registbutton","post","/user/registerUser", "registerform",true);
    });

});




$(".boysexradio").click(function () {
    $(this).toggleClass("chooseboy unchooseboy");
    $(this).toggleClass("choose unchoose");
    $(".girlsexradio").toggleClass("choosegirl unchoosegirl");
    $(".girlsexradio").toggleClass("unchoose choose");
    $("#hiddensexinput").val("1");
});

$(".girlsexradio").click(function () {
    $(".boysexradio").toggleClass("chooseboy unchooseboy");
    $(".boysexradio").toggleClass("choose unchoose");
    $(this).toggleClass("choosegirl unchoosegirl");
    $(this).toggleClass("unchoose choose");
    $("#hiddensexinput").val("0");
});

window.onload=function (ev) {
    var scheight=$(window).height();
    var scwidth=$(window).width();

    var marginleftpx=(scwidth-scwidth*0.4)/2+'px';

    $('.formdiv').css('top','-150px');
    $('.formdiv').css('left',marginleftpx);
    $('.formdiv').show();

    $('.formdiv').animate({
        top:'20%',
        opacity:'0.8',
    },"slow");

    $('.formdiv').animate({
        top:'15%',
    },200);
    $('.formdiv').animate({
        top:'20%',
    },300);
};


