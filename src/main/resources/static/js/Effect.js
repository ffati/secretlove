(function() {
        var Effect = window.Effect = function(json) {
                this.timer = null;
                var EffectCanvas = document.getElementById("EffectCanvas");
                if (EffectCanvas) {
                    document.body.removeChild(EffectCanvas);
                }
                ;if (typeof json.effectUrl == "object") {
                    this.effectUrl = json.effectUrl;
                } else if (/\&\&\&/g.test(json.effectUrl)) {
                    this.effectUrl = json.effectUrl.split("&&&");
                } else if (/\[.*\]/g.test(json.effectUrl)) {
                    this.effectUrl = JSON.parse(json.effectUrl);
                } else {
                    try {
                        this.effectUrl = json.effectUrl.split(",");
                    } catch (err) {}
                    ;
                }
                ;this.imageArr = [];
                this.effectsArr = [];
                this.num = 35;
                this.json = json;
                this.init();
            }
        ;
        Effect.prototype.init = function() {
            this.canvas = document.createElement("canvas");
            this.canvas.id = "EffectCanvas";
            this.windowW = document.documentElement.clientWidth;
            this.windowH = document.documentElement.clientHeight;
            this.canvas.width = this.windowW;
            this.canvas.height = this.windowH;
            this.canvas.style.position = "fixed";
            this.canvas.style.top = "0px";
            this.canvas.style.left = "0px";
            this.canvas.style.zIndex = "995";
            this.canvas.style.pointerEvents = "none";
            document.body.appendChild(this.canvas);
            this.ctx = this.canvas.getContext("2d");
            var self = this;
            var picsum = 0;
            for (var i = 0; i < this.effectUrl.length; i++) {
                this.imageArr.push(new Image());
                this.imageArr[i].src = this.effectUrl[i];
                this.imageArr[i].onload = function() {
                    picsum++;
                    if (picsum == self.effectUrl.length) {
                        self.initTimer();
                    }
                    ;
                }
                ;
            }
            ;
        }
        ;
        Effect.prototype.initTimer = function() {
            var self = this;
            var imgIdx = parseInt(Math.random() * this.imageArr.length);
            this.effectsArr.push(new EffectItem(this.ctx,this.imageArr[imgIdx],this.json.rotate,this.json.direction));
            this.timer = setInterval(function() {
                self.ctx.clearRect(0, 0, self.windowW, self.windowH);
                self.num--;
                if (self.num <= 0) {
                    self.num = 35;
                    var imgIdx = parseInt(Math.random() * self.imageArr.length);
                    self.effectsArr.push(new EffectItem(self.ctx,self.imageArr[imgIdx],self.json.rotate,self.json.direction));
                }
                ;for (var i = 0; i < self.effectsArr.length; i++) {
                    if (self.effectsArr[i].death) {
                        self.effectsArr.splice(i, 1);
                    }
                    ;self.effectsArr[i].update();
                    self.effectsArr[i].render();
                }
                ;
            }, 10);
        }
        ;
    }
)();
