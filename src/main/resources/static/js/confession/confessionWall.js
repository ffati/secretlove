


layui.use('flow', function(){
    var flow = layui.flow;
    var pages=0;

    $.ajax({
        type: 'post',
        url: '/confession/totalPage',
        headers: {//请求头
            Accept: "application/json; charset=utf-8",
            "X-CSRF-TOKEN": tokenparam  //这是获取的token
        },
        dataType: 'json',
        async:false,
        success:function (data) {
            pages=data;
        }

    })


    flow.load({
        elem: '#gridpic' //流加载容器
        //,scrollElem: '#LAY_demo1' //滚动条所在元素，一般不用填，此处只是演示需要。
        ,done: function(page, next) { //执行下一页的回调
            var lis = [];


            $.ajax({
                type: 'post',
                url: '/confession/findForPage',
                headers: {//请求头
                    Accept: "application/json; charset=utf-8",
                    "X-CSRF-TOKEN": tokenparam  //这是获取的token
                },
                dataType: 'json',
                data : {"page":page},
                async:false,//按照js顺序执行
                success: function(res) {
                    layui.each(res, function (index, item) {
                        lis.push('<div class="grid__item"  style="display: inline-block;z-index: 999">' +
                            '                            <span class="grid__link pater" href="#">' +
                            '                                <img onclick="magnification(this,event)" src="/pictureServer/vicitorConfessionWallPictureUtil?pictureName='+item.backgroundImagSrc+'" class="pater__img "/>' +
                            '                                <div class="pater__content">' +
                            '                                    <h2 class="pater__title showellipsis" aria-label="fullstory">for<br><span class="showellipsis receiver">'+item.receiver+'</span></h2>' +
                            '                                    <p class="pater__desc showellipsis content">'+item.content+'</p>' +
                            '                                    <span class="pater__call">'+item.joinTime+'</span>' +
                            '                                </div>' +
                            '                            </span>' +
                            '                        </div>');
                    });

                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < pages);

                },
            });
        }
    });
});
