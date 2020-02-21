window.requestAnimFrame = (function(callback) {
    return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
        function(callback) {
            window.setTimeout(callback, 1000 / 60);
        };
})();

var requestId, jolttime;

var c = document.getElementById('canv');
var $ = c.getContext('2d');

var s = 18; //grid square size
var mv = 10; //moving areas
var sp = 1; //move speed
var clm = 23; //columns
var rw = 10; //rows
var x = []; //x array
var y = []; //y array
var X = []; //starting X array
var Y = []; //starting Y array

c.width  = c.offsetWidth;
c.height = c.offsetHeight;

for (var i = 0; i < clm * rw; i++) {
    x[i] = ((i % clm) - 0.5) * s;
    y[i] = (Math.floor(i / clm) - 0.5) * s;
    X[i] = x[i];
    Y[i] = y[i];
}
var t = 0;

function jolt() {
    $.fillRect(0, 0, c.width, c.height);

    for (var i = 0; i < clm * rw; i++) {
        if (i % clm != clm - 1 && i < clm * (rw - 1) - 1) {
            $.fillStyle = "hsla(0,0,0,1)";
            $.strokeStyle = "#95D384";
            $.lineWidth = 1;
            $.beginPath();
            $.moveTo(x[i], y[i]);
            $.lineTo(x[i + 1], y[i + 1]);
            $.lineTo(x[i + clm + 1], y[i + clm + 1]);
            $.lineTo(x[i + clm], y[i + clm]);
            $.closePath();
            $.stroke();
            $.fill();
        }
    }
    for (var i = 0; i < rw * clm; i++) {
        if ((x[i] < X[i] + mv) && (x[i] > X[i] - mv) && (y[i] < Y[i] + mv) && (y[i] > Y[i] - mv)) {
            x[i] = x[i] + Math.floor(Math.random() * (sp * 2 + 1)) - sp;
            y[i] = y[i] + Math.floor(Math.random() * (sp * 2 + 1)) - sp;
        } else if (x[i] >= X[i] + mv) {
            x[i] = x[i] - sp;
        } else if (x[i] <= X[i] - mv) {
            x[i] = x[i] + sp;
        } else if (y[i] >= Y[i] + mv) {
            y[i] = y[i] - sp;
        } else if (y[i] <= Y[i] + mv) {
            y[i] = y[i] + sp;
        }
    }
    //controls time of electric shake> when counter equals 0, it will reset for 5s then start again.
    if (t % c.width == 0) {
        jolttime = setTimeout('jolt()', 5);
        t++;
    } else {
        jolttime = setTimeout('jolt()', 5);
        t++;
    }
}

function start() {
    if (!requestId) {
        requestId = window.requestAnimFrame(jolt);
    }
}

function stop() {
    if (requestId) {
        clearTimeout(jolttime);
        window.cancelAnimationFrame(requestId);
        requestId = undefined;
    }
}

document.querySelector('a.link--asiri').addEventListener('mouseenter', start);
document.querySelector('a.link--asiri').addEventListener('mouseleave', stop);

// For Demo purposes only (show hover effect on mobile devices)
[].slice.call( document.querySelectorAll('.grid a') ).forEach( function(el) {
    el.onclick = function() { return false; }
} );
