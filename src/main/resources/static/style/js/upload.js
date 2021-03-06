/*function upload() {
    //alert(10);
    var fp = $("#file").val();
    //为了避免转义反斜杠出问题，这里将对其进行转换

    var re = /(\\+)/g;
    var fn = fp.replace(re, "#");
    //对路径字符串进行剪切截取
    var one = fn.split("#");
    //获取数组中最后一个，即文件名
    var two = one[one.length - 1];
    //再对文件名进行截取，以取得后缀名
    var three = two.split(".");
    //获取截取的最后一个字符串，即为后缀名
    var last = three[three.length - 1];
    last = last.toLowerCase();

    if (last != 'png' && last != 'jpg' && last != 'gif'
        && last != 'PNG' && last != 'JPG' && last != 'GIF') {
        alert("请上传png、jpg或者gif文件！");
        return;
    }
    $.ajaxFileUpload({
        url : '/upload', //需要链接到服务器地址
        secureuri : false,
        fileElementId : "file", //文件选择框的id属性
        dataType : 'text', //服务器返回的格式，可以是json
        success : function(rs) //相当于java中try语句块的用法
        {
            if (rs != "") {

                $('#img').html("<img src='"+rs+"' width='100' height='100'>");
                $("#drawings").val(rs);
            } else {
                alert('失败');
                //document.getElementById("msg"+m[1]).value="失败";
            }
        },
        error : function(data, status, e) //相当于java中catch语句块的用法
        {alert('失败');

        }
    });
}*/

function upload(){
layui.use('upload', function(){
    var upload = layui.upload;

    //执行实例
    var uploadInst = upload.render({
        elem: '#test1' //绑定元素
        ,url: '/upload' //上传接口
        ,accept:'images'
        ,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            layer.load(); //上传loading
        }
        ,done: function(res, index, upload){
            layer.closeAll('loading'); //关闭loading
            if (res.success==0){
                layer.msg(res.msg);
            }else {
                layer.msg(res.msg);
            }
        }
        ,error: function(index, upload){
            layer.closeAll('loading'); //关闭loading
        }
    });
});
}



