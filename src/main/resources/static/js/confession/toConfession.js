

$(function() {
    toConfessionLodingbackground();

});



function toConfessionLodingbackground() {

    randombackground("confessionBackgroundimg")

};



layui.use(['form','upload'], function() {
    var upload = layui.upload //上传
        , form = layui.form


    upload.render({
        elem: '#uploaddiv'
        ,accept: 'images' //图片
        ,exts: 'jpg|png|jpeg' //图片格式
        ,url: '/confession/uploadPicture'
        ,field:'background'
        ,size:5000
        ,headers:{"X-CSRF-TOKEN":tokenparam}
        /*            ,auto:false
                    ,bindAction:'.submitbutton'*/
        ,done: function(res){
            layer.msg('上传成功');
            layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src',  '/pictureServer/vicitorConfessionWallPictureUtil?pictureName='+res.individuationMessage);
            layui.$('.backgroundImagSrc').val(res.individuationMessage);

        }
    });



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
        /*            ,content: function(value){
                        layedit.sync(editIndex);
                    }*/
    });

    form.on('submit(laysubmitbutton)', function(data) {

        ajaxForForm("submitbutton", "post", "/confession/insertOneFeeling", "feelingform", true);
    });

});

