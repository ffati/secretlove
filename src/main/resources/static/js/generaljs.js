

$(function() {
    togglemenu();
    dragFunc("removablediv");
});



/*第一种拖拽*/
function dragFunc(id) {
    var Drag = document.getElementById(id);
    Drag.onmousedown = function(event) {
        var ev = event || window.event;
        event.stopPropagation();
        var disX = ev.clientX - Drag.offsetLeft;
        var disY = ev.clientY - Drag.offsetTop;
        document.onmousemove = function(event) {
            var ev = event || window.event;
            Drag.style.left = ev.clientX - disX + "px";
            Drag.style.top = ev.clientY - disY + "px";
            Drag.style.cursor = "move";
        };
    };
    Drag.onmouseup = function() {
        document.onmousemove = null;
        this.style.cursor = "default";
    };
};


    /*第二种拖拽*/
    function dragFunc2(parentid,innerid){
        var oDiv=document.getElementById(innerid);
        var oParent=document.getElementById(parentid);
        var sent={l:0,r:oParent.offsetWidth-oDiv.offsetWidth,t:0,b:oParent.offsetHeight-oDiv.offsetHeight,n:10}
        drag(oDiv,sent);
    };

    function drag(obj,sent){var dmW=document.documentElement.clientWidth||document.body.clientWidth;var dmH=document.documentElement.clientHeight||document.body.clientHeight;var sent=sent||{};var l=sent.l||0;var r=sent.r||dmW-obj.offsetWidth;var t=sent.t||0;var b=sent.b||dmH-obj.offsetHeight;var n=sent.n||10;obj.onmousedown=function(ev){var oEvent=ev||event;var sentX=oEvent.clientX-obj.offsetLeft;var sentY=oEvent.clientY-obj.offsetTop;document.onmousemove=function(ev){var oEvent=ev||event;var slideLeft=oEvent.clientX-sentX;var slideTop=oEvent.clientY-sentY;if(slideLeft<=l){slideLeft=l;}
        if(slideLeft>=r){slideLeft=r;}
        if(slideTop<=t){slideTop=t;}
        if(slideTop>=b){slideTop=b;}
        obj.style.left=slideLeft+'px';obj.style.top=slideTop+'px';}
        document.onmouseup=function(){document.onmousemove=null;document.onmouseup=null;}
        return false;
        }
    }


function togglemenu() {

    $(".mainmenu").dblclick(function () {
        $(".mainmenu").toggleClass("showmenu hidemenu");
        $('.togglediv').animate({width:'toggle'},200);
    });

};