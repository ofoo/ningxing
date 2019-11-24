<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div id="e">
    <div class="header">
        <div class="logo">
            <img src="/img/default.png" class="img">
        </div>
        <div class="nav">
            <a href="javascript:void(0)">首页</a>
            <a href="#a">公司简介</a>
            <a href="/front/teacherList">课程列表</a>
            <a href="/front/teacherList">讲师列表</a>
            <a href="#d">关于我们</a>
        </div>
        <div class="floatClear"></div>
    </div>
    <div class="middle">
        <div class="banner">
            <#if (banner.url)??&&banner.url!=''>
                <img src="${banner.url}">
            <#else>
                <img src="/img/default.png">
            </#if>
        </div>
        <div class="content">
            <div class="card">
                <p class="title" id="a">公司简介</p>
                <#if profile??>
                    <#if (profile.url)??&&profile.url!=''>
                        <img class="img floatLeft marginRight" src="${profile.url}">
                    <#else>
                        <img class="img floatLeft marginRight" src="/img/default.png">
                    </#if>
                    <p class="text">${(profile.content)!}</p>
                <#else>
                <img class="img floatLeft marginRight" src="/img/default.png">
                <p class="text">
                    啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫</p>
                </#if>
                <div class="floatClear"></div>
            </div>
            <div class="floatClear"></div>
            <div class="card">
                <p class="title" id="b">课程介绍</p>
                <div class="list backgroundColor">
                    <#list courseList as course>
                    <div class="floatLeft item">
                        <img src="${(course.url)!}" style="width: 100%;height: 200px">
                        <p>${(course.name)!}</p>
                    </div>
                    </#list>
                    <#if courseList??&&courseList?size < 0>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                    </#if>
                    <div class="floatClear"></div>
                </div>
            </div>
            <div class="floatClear"></div>
            <div class="card">
                <p class="title" id="c">讲师团队</p>
                <div class="list backgroundColor">
                    <#list teacherList as teacher>
                    <div class="floatLeft item">
                        <img src="${(teacher.url)!}" style="width: 100%;height: 200px">
                        <p>${(teacher.name)!}</p>
                    </div>
                    </#list>
                    <#if teacherList??&&teacherList?size < 0>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                        <div class="floatLeft item">
                            <img src="/img/default.png" style="width: 100%;height: 200px">
                            <p>练束梅</p>
                        </div>
                    </#if>
                    <div class="floatClear"></div>
                </div>
            </div>
            <div class="floatClear"></div>
            <div class="card">
                <p class="title" id="d">关于我们</p>
                <#if about??>
                    <#if (about.url)??&&about.url!=''>
                        <img class="img floatRight marginLeft" src="${about.url}">
                    <#else>
                        <img class="img floatRight marginLeft" src="/img/default.png">
                    </#if>
                    <p class="text">${(about.content)!}</p>
                <#else>
                    <img class="img floatRight marginLeft" src="/img/default.png">
                    <p class="text">
                        啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫啊手动阀手动阀手动阀撒打发士大夫</p>
                </#if>
                <div class="floatClear"></div>
            </div>
        </div>
    </div>
    <div class="footer">
        <p class="text">Copyright 2019 by 练束梅</p>
    </div>
</div>
</body>
</html>