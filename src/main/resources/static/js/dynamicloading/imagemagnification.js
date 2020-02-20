
$(function() {

    //magnification();
});

    $(".showpicdiv").click(function(){
        $('.showpicdiv').empty();
        $('.showpicwindow').hide();

    })

function magnification(thisobj,event) {


$(".showcontent").text($(thisobj).parent().find(".content").text());
$(".showreceiver").text($(thisobj).parent().find(".receiver").text())

console.log($(thisobj));

        /*计算屏幕宽高*/
        //var imgurl=$(thisobj).css('backgroundImage').split("(\"")[1].split("\")")[0];
        var imgurl=$(thisobj).attr('src');
        var scheight=$(window).height();
        var scwidth=$(window).width();
        var finalpicwidth=scwidth*0.5;
        var finalpicheight=scheight*0.8;
        var halfscwidth=scwidth/2;
        /*图片宽高比*/
        var picwidth= $(thisobj)[0].naturalWidth;
        var picheight=$(thisobj)[0].naturalHeight;
        var proportion=picwidth/picheight;

        var scproportion=scwidth/scheight/2;

        /*计算margintop*/
        var picnowheight=Math.round(finalpicwidth/proportion);
        var picnowmargintop=Math.round((scheight-picnowheight)/2);
        /*计算marginleft*/
        var picnowheight=Math.round(finalpicwidth*proportion);
        var langpicmargintop=Math.round((halfscwidth-picnowheight)/2);


        var langpicmarginpx=langpicmargintop+'px';
        var margintoppx=picnowmargintop+'px';

        $('.showpicwindow').show();
        $('.showpicwindow').animate({
            //opacity:'0.5',
        });


        if(proportion>scproportion){

            $('.showpicdiv').html('<img class="picturecontent" src='+imgurl+' style="align-items: center;position: absolute;"/>');
            console.log("元素相对当前屏幕位置"+event.clientX);
            console.log("元素绝对位置"+$(thisobj).offset().left);

            $('.picturecontent').css('top',event.clientY+"px");
            $('.picturecontent').css('left',event.clientX+"px");
            console.log($(thisobj).offset().top+"---"+$(thisobj).offset().left);
            $('.picturecontent').animate({
                top:margintoppx,
                left:'0px',
                width:'100%',
                opacity:'0.8',
            },"slow");


        }else if(proportion<scproportion){

            $('.showpicdiv').html('<img class="picturecontent" src='+imgurl+' style="align-items: center;position: absolute;"/>');

            $('.picturecontent').css('top',event.clientY+"px");
            $('.picturecontent').css('left',event.clientX+"px");
            $('.picturecontent').animate({

                top:'0px',
                left:langpicmarginpx,
                height:'100%',
                opacity:'0.8',

            },"slow");

        }




}