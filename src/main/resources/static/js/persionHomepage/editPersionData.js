

var userid=$(".userIdInput").val();

$(".nickNameButton").click(function () {
    $(".nickNameDiv").hide();
    $(".editNickname").show();
    $(".nickNameButton").hide();
    $(".nickNameSubmit").show();
});

$(".nickNameSubmit").click(function () {

    var dataString={};
    dataString.userId=userid;
    dataString.nickName=$(".editNickname").val();
    console.log(dataString);
    ajaxcommon("post","/user/modifyData",dataString,true,false)

});


$(".headSculptureImgbutton").click(function () {
    $(".headSculptureImg").hide();
    $(".headSculptureImgDiv").hide();
    $(".headSculptureImgUpdate").show();

});

$(".personalHomepageImageButton").click(function () {
    $(".personalHomepageImage").hide();
    $(".personalHomepageImageDiv").hide();
    $(".personalHomepageImageUpdate").show();

});


layui.use(['form','layer','upload'], function() {
    var layer = layui.layer //弹层
        , upload = layui.upload //上传

    upload.render({
        elem: '#headImgDiv'
        ,accept: 'image' //普通文件
        ,field:'file'
        ,exts: 'jpg|png|jpeg' //图片格式
        ,size:'2000'
        ,method: 'POST'
        ,data:{userId:function(){
                return $(".userIdInput").val();
            }
            ,type:"headImg"}
        ,headers:{"X-CSRF-TOKEN":tokenparam}
        ,url: '/personal/uploadPicture' //改成您自己的上传接口
        ,done: function(res){
            layer.msg('上传成功');
            layui.$('#headImgView').removeClass('layui-hide').find('img').attr('src', '/fileService/showHeadSculpture?imgpath='+res.individuationMessage);
            console.log(res)
        }
        ,error: function(){
            //请求异常回调
        }
    });


    upload.render({
        elem: '#bgImgDiv'
        ,accept: 'image' //普通文件
        ,field:'file'
        ,exts: 'jpg|png|jpeg' //图片格式
        ,size:'9000'
        ,method: 'POST'
        ,data:{userId:function(){
                return $(".userIdInput").val();
            }
            ,type:"personalbgImg"}
        ,headers:{"X-CSRF-TOKEN":tokenparam}
        ,url: '/personal/uploadPicture' //改成您自己的上传接口
        ,done: function(res){
            layer.msg('上传成功');
            layui.$('#bgImgView').removeClass('layui-hide').find('img').attr('src', '/fileService/showHeadSculpture?imgpath='+res.individuationMessage);
            console.log(res)
        }
    });

});


