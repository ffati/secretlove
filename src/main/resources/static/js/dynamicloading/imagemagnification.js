
$(function() {

    //magnification();
});

    $(".showpicdiv").click(function(){
        $('.showpicdiv').empty();
        $('.showpicwindow').hide();

    })

function magnification(thisobj) {

console.log($(thisobj));

/*
        console.log($(thisobj).offset().top);
        console.log($(thisobj).offset().left);
*/

        //var imgurl=$(thisobj).css('backgroundImage').split("(\"")[1].split("\")")[0];
        var imgurl=$(thisobj).attr('src');
        var scheight=$(window).height();
        var scwidth=$(window).width();
        var finalpicwidth=scwidth*0.5;
        var finalpicheight=scheight*0.8;
        var halfscwidth=scwidth/2;

        var picwidth= $(thisobj)[0].naturalWidth;
        var picheight=$(thisobj)[0].naturalHeight;
        var proportion=picwidth/picheight;

        console.log('图片比例--'+proportion);

        /*计算margintop*/
        var picnowheight=Math.round(finalpicwidth/proportion);
        var picnowmargintop=Math.round((scheight-picnowheight)/2);

        var langpicmargintop=Math.round((scheight-finalpicheight)/2);


        var langpicmarginpx=langpicmargintop+'px';
        var margintoppx=picnowmargintop+'px';

        $('.showpicwindow').show();
        $('.showpicwindow').animate({
            opacity:'1',
        });


        if(proportion>1 &&finalpicheight<scheight||proportion<1 &&finalpicwidth>halfscwidth){

            $('.showpicdiv').html('<img class="picturecontent" src='+imgurl+' style="width:'+picwidth+'px;align-items: center;position: absolute;"/>');

            $('.picturecontent').css('top',$(thisobj).offset().top);
            $('.picturecontent').css('left',$(thisobj).offset().left);
            $('.picturecontent').animate({
                top:margintoppx,
                left:'0px',
                width:'100%',
                opacity:'0.8',


            },"slow");


        }else if(proportion<1 &&finalpicwidth<halfscwidth||proportion>1 &&finalpicheight>scheight){
            $('.showpicdiv').html('<img class="picturecontent" src='+imgurl+' style="height: '+picheight+'px;align-items: center;position: absolute;"/>');
            $('.picturecontent').css('top',$(thisobj).offset().top);
            $('.picturecontent').css('left',$(thisobj).offset().left);
            $('.picturecontent').animate({

                top:'0px',
                left:'0px',
                height:'100%',
                opacity:'0.8',

            },"slow");

        }




}