<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="main">
    <p class="title">登录</p>
    <form id="dataForm">
        <div>
            <input class="input widthFull" type="text" placeholder="请输入用户名" name="name" value="练束梅">
        </div>
        <div>
            <input class="input widthFull" type="password" placeholder="请输入密码" name="password" value="123456">
        </div>
        <input class="input widthFull" type="button" onclick="useLogin()" value="登录">
    </form>
</div>

<script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/layer/layer.js"></script>
<script>
    function useLogin(){
        $.ajax({
            url: "/ajax/login",
            type: "post",
            data: $("#dataForm").serialize(),
            dataType: "json",
            success: function (data) {
                if (data.status){
                    location.href='/admin/index';
                }else{
                    layer.msg(data.msg,{
                        offset: '40%'
                    });
                }
            }
        });
    }
</script>
</body>
</html>