

    window.onload = function () {//即在加载的过程中执行下面的代码
        if (document.readyState == "complete") {//complete加载完成
            $(".heartlodingdiv").fadeOut();
        }
    };


function togglelilke(){

    document.body.classList.toggle('liked');

    var hidetime=setTimeout(function(){
        console.log("1");
        $(".enterkey").css("display","none");
        console.log("2");
    },1500);

};


$("#boxes").click(function(){

    $(".card").toggleClass("hidecard showcard");


});


$(window).resize(function(){
    let scheight=$(window);
    let scwidth=$(window);
    let bl=scwidth/scheight;
    if(bl>1){
        let wscheight=$(window).height()*0.5;
        let wscwidth=$(window).width()*0.48;
        $(".slides").css("width",wscwidth);
        $(".slides").css("height",wscheight);
        $(".slideinnertext").css("width",wscwidth);
    }else{
        let wscheight=$(window).height()*0.5;
        let wscwidth=$(window).width();
        $(".slides").css("width",wscwidth);
        $(".slides").css("height",wscheight);
        $(".slideinnertext").css("width",wscwidth);

    }


});



var boxes = document.querySelectorAll('#boxes > div');
[].forEach.call(boxes, box => {
    box.addEventListener('mousemove', e => {
        document.body.style.setProperty(
            '--bg-color',
            box.style.getPropertyValue('--color')
        );

        var size = parseInt(getComputedStyle(box).width);

        // scaling
        var x = size * .3 * .7 + .7 * e.offsetX;
        var y = size * .3 * .7 + .7 * e.offsetY;

        box.style.setProperty('--x', x);
        box.style.setProperty('--y', y);
        box.style.setProperty('--size', size);
    });
});


$(".banner").banner($(".banner").find("img"),{
    but:false,    // 左右按钮默认为true
    butahidden:true,    // 是否自动隐藏左右按钮默认隐藏
    list:false,  // 导航按钮
    index:2,    //初始从第几个开始默认为0
    autoPlay:true,  // 自动轮播默认为true
    delayTiem:2000,  // 延迟时间默认为2000
    moveTime:500    // 远动时间默认为300
});

    new Effect({
    //特效图片，多张图片时传入数组，单个图片时传入字符串
    effectUrl: effectrandomArr,
    //特效旋转，1/true为旋转，0/false为不旋转
    rotate: 1,
    //特效方向，left/right/up/down
    direction: "up"
});


$(document).ready(function ($) {
    let scheight=screenHeight;
    let scwidth=screenWidth;
    let bl=scwidth/scheight;
    if(bl>1){
        let wscheight=scheight*0.5;
        let wscwidth=scwidth*0.48;

        $(".maindiv2").css("left","20%");
        $(".maindiv2").css("width","60%");
        $(".slides").css("width",wscwidth);
        $(".slides").css("height",wscheight);
        $(".slider").css("width",wscwidth);
        $(".slideinnertext").css("width",wscwidth);
    }else{
        let wscheight=$(window).height()*0.5;
        let wscwidth=$(window).width();

        $(".maindiv2").css("left","0px");
        $(".maindiv2").css("width","100%");
        $(".slides").css("width",wscwidth);
        $(".slides").css("height",wscheight);
        $(".slideinnertext").css("width",wscwidth);
        $(".slider").css("width",wscwidth);
        $(".slider img").css("object-fit","contain");
    }

    if(scheight<550){
        $(".boxesbutton").css("width","10%");
    }

    var _SlideshowTransitions = [
        //{$Duration:1200,y:-0.3,$Cols:2,$SlideOut:true,$ChessMode:{$Column:12},$Easing:{$Top:$JssorEasing$.$EaseInCubic,$Opacity:$JssorEasing$.$EaseLinear},$Opacity:2},
        //{$Duration:1000,y:4,$Zoom:11,$Easing:{$Top:$JssorEasing$.$EaseInCubic,$Zoom:$JssorEasing$.$EaseInCubic,$Opacity:$JssorEasing$.$EaseOutQuad},$Opacity:2},
        {$Duration:1200,y:1,$Rows:2,$Zoom:1,$ChessMode:{$Row:15},$Easing:{$Top:$JssorEasing$.$EaseInCubic,$Zoom:$JssorEasing$.$EaseInCubic,$Opacity:$JssorEasing$.$EaseLinear},$Assembly:2049,$Opacity:2},
        //{$Duration:1500,x:-1,y:0.5,$Delay:60,$Cols:8,$Rows:4,$Formation:$JssorSlideshowFormations$.$FormationSquare,$Easing:{$Left:$JssorEasing$.$EaseSwing,$Top:$JssorEasing$.$EaseInWave},$Assembly:260,$Round:{$Top:1.5}},
        //{$Duration:600,x:-1,y:-1,$Delay:50,$Cols:8,$Rows:4,$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationZigZag,$ChessMode:{$Column:3,$Row:12},$Easing:{$Left:$JssorEasing$.$EaseInCubic,$Top:$JssorEasing$.$EaseInCubic,$Opacity:$JssorEasing$.$EaseOutQuad},$Assembly:1028,$Opacity:2},
        {$Duration:1000,x:-0.5,y:0.5,$Zoom:1,$Rotate:1,$SlideOut:true,$Easing:{$Left:$JssorEasing$.$EaseInCubic,$Top:$JssorEasing$.$EaseInCubic,$Zoom:$JssorEasing$.$EaseInCubic,$Opacity:$JssorEasing$.$EaseLinear,$Rotate:$JssorEasing$.$EaseInCubic},$Opacity:2,$Round:{$Rotate:0.5}},
        //{$Duration:1800,x:1,y:0.2,$Delay:30,$Cols:10,$Rows:5,$Clip:15,$During:{$Left:[0.3,0.7],$Top:[0.3,0.7]},$SlideOut:true,$Reverse:true,$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Easing:{$Left:$JssorEasing$.$EaseInOutSine,$Top:$JssorEasing$.$EaseOutWave,$Clip:$JssorEasing$.$EaseInOutQuad},$Assembly:2050,$Round:{$Top:1.3}},
        //{$Duration:1800,x:1,$Delay:30,$Cols:10,$Rows:5,$Clip:15,$During:{$Left:[0.3,0.7]},$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Easing:{$Left:$JssorEasing$.$EaseInOutExpo,$Clip:$JssorEasing$.$EaseInOutQuad},$Assembly:260,$Outside:true,$Round:{$Top:0.8}},
        //{$Duration:1800,x:1,$Delay:30,$Cols:10,$Rows:5,$Clip:15,$During:{$Left:[0.3,0.7]},$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Easing:{$Left:$JssorEasing$.$EaseInOutExpo,$Clip:$JssorEasing$.$EaseInOutQuad},$Assembly:260,$Outside:true,$Round:{$Top:0.8}},
        //{$Duration:1500,x:0.3,y:-0.3,$Delay:20,$Cols:8,$Rows:4,$Clip:15,$During:{$Left:[0.1,0.9],$Top:[0.1,0.9]},$SlideOut:true,$Formation:$JssorSlideshowFormations$.$FormationSwirl,$Easing:{$Left:$JssorEasing$.$EaseInJump,$Top:$JssorEasing$.$EaseInJump,$Clip:$JssorEasing$.$EaseOutQuad},$Assembly:260,$Outside:true,$Round:{$Left:0.8,$Top:2.5}},
        {$Duration:1200,x:2,y:1,$Cols:2,$Zoom:11,$Rotate:1,$ChessMode:{$Column:15},$Easing:{$Left:$JssorEasing$.$EaseInCubic,$Top:$JssorEasing$.$EaseInCubic,$Zoom:$JssorEasing$.$EaseInCubic,$Opacity:$JssorEasing$.$EaseOutQuad,$Rotate:$JssorEasing$.$EaseInCubic},$Assembly:2049,$Opacity:2,$Round:{$Rotate:0.7}},
        {$Duration:1000,$Rows:6,$Clip:4,$Move:true},
        //{$Duration:800,$Delay:150,$Cols:10,$Clip:1,$Move:true,$Formation:$JssorSlideshowFormations$.$FormationCircle,$Easing:$JssorEasing$.$EaseInBounce,$Assembly:264},
        {$Duration:600,x:-1,y:1,$Delay:30,$Cols:8,$Rows:4,$Formation:$JssorSlideshowFormations$.$FormationStraightStairs,$Easing:{$Left:$JssorEasing$.$EaseInQuart,$Top:$JssorEasing$.$EaseInQuart,$Opacity:$JssorEasing$.$EaseLinear},$Opacity:2}

    ];
    var options = {
        $AutoPlay: true,
        $SlideshowOptions: {
            $Class: $JssorSlideshowRunner$,
            $Transitions: _SlideshowTransitions,
            $TransitionsOrder: 1,
            $ShowLink: true
        },
        $ArrowNavigatorOptions: {
            $Class: $JssorArrowNavigator$
        },
        $BulletNavigatorOptions: {
            $Class: $JssorBulletNavigator$
        }
    };
    var jssor_slider1 = new $JssorSlider$('slider1_container', options);
});