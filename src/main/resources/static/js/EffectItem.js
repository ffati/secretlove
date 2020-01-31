(function() {
        var EffectItem = window.EffectItem = function(ctx, url, rotate, direction) {
                this.ctx = ctx;
                this.url = url;
                this.rotate = rotate;
                this.direction = direction;
                this.death = false;
                this.init();
            }
        ;
        EffectItem.prototype.init = function() {
            this.windowW = document.documentElement.clientWidth;
            this.windowH = document.documentElement.clientHeight;
            this.x = 0;
            this.y = 0;
            this.goToX = 0;
            this.goToY = 0;
            this.moveX = 0;
            this.moveY = 0;
            this.speedX = 0;
            this.speedY = 0;
            this.rotateDeg = 0;
            this.opacity = 1;
            if (this.direction == "down" || this.direction == "up") {
                this.x = Math.random() * this.windowW;
                if (this.direction == "down") {
                    this.y = this.windowH;
                }
                ;this.goToX = 200 * Math.random() - 100;
                this.moveX = this.goToX / 350;
                this.speedY = this.windowH / 350;
                if (this.direction == "down") {
                    this.speedY = -this.speedY;
                }
                ;
            } else if (this.direction == "left" || this.direction == "right") {
                this.y = Math.random() * this.windowH;
                if (this.direction == "right") {
                    this.x = this.windowW;
                }
                ;this.goToY = 200 * Math.random() - 100;
                this.moveY = this.goToY / 350;
                this.speedX = this.windowW / 350;
                if (this.direction == "right") {
                    this.speedX = -this.speedX;
                }
                ;
            }
            ;this.w = 25 + Math.random() * 10;
            this.h = this.w;
            //console.log(this.w + "," + this.h)
        }
        ;
        EffectItem.prototype.update = function() {
            this.x = this.x + this.moveX + this.speedX;
            this.y = this.y + this.moveY + this.speedY;
            if (this.rotate) {
                this.rotateDeg += 360 / 100 * Math.PI / 180;
                if (this.rotateDeg >= 360) {
                    this.rotateDeg = 0;
                }
                ;
            }
            ;this.opacity -= 1 / 350;
            if (this.direction == "left" && (this.x > (this.windowW + this.w))) {
                this.death = true;
            } else if (this.direction == "right" && (this.x < -this.w)) {
                this.death = true;
            } else if (this.direction == "up" && (this.y > (this.windowH + this.y))) {
                this.death = true;
            } else if (this.direction == "down" && (this.y < -this.h)) {
                this.death = true;
            }
            ;
        }
        ;
        EffectItem.prototype.render = function() {
            this.ctx.save();
            this.ctx.translate(this.x + this.w / 2, this.y + this.h / 2);
            this.ctx.rotate(this.rotateDeg);
            this.ctx.globalAlpha = this.opacity;
            this.ctx.drawImage(this.url, -this.w / 2, -this.h / 2, this.w, this.h);
            this.ctx.restore();
        }
        ;
    }
)();
