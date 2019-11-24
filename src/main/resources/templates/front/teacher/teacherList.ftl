<#if type!='append'>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>讲师列表</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div id="e">
    <div class="header">
        <div class="logo">
            <img src="/img/default.png" class="img">
        </div>
        <div class="nav">
            <a href="/">首页</a>
            <a href="#a">公司简介</a>
            <a href="/front/courseList">课程列表</a>
            <a href="javascript:void(0)">讲师列表</a>
            <a href="#d">关于我们</a>
        </div>
        <div class="floatClear"></div>
    </div>
    <div class="middle">
        <div class="listContent" id="main">
            <#list pageInfo.list as teacher>
            <div class="listCard">
                <img src="${(teacher.url)!}">
                <div class="info">
                    <h2>${(teacher.name)}</h2>
                    <p class="text">
                        撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大撒打发士大夫撒旦飞洒地方阿斯蒂芬撒撒飞洒地方夫撒打发士大撒打发士大夫撒旦飞洒地方阿斯蒂芬撒撒飞洒地方</p>
                </div>
                <div class="floatClear"></div>
            </div>
            </#list>
        <#--<div class="paging">
            <#if !pageInfo.isFirstPage>
                <input type="button" onclick="getCourseList(${pageInfo.prePage})" value="<">
            </#if>
            <#list pageInfo.navigatepageNums as num>
                <#if pageInfo.pageNum==num>
                    <input type="button" class="current" value="${num}">
                <#else>
                    <input type="button" onclick="getCourseList(${num})" value="${num}">
                </#if>
            </#list>
            <#if !pageInfo.isLastPage>
                <input type="button" onclick="getCourseList(${pageInfo.nextPage})" value=">">
            </#if>
        </div>-->
        </div>
    </div>
    <div class="footer">
        <p class="text">Copyright 2019 by 练束梅</p>
    </div>
</div>
<form id="dataForm">
    <input type="hidden" name="pageNum" id="pageNum" value="${pageInfo.pageNum}">
    <input type="hidden" name="type" value="append">
    <input type="hidden" id="pages" value="${pageInfo.pages}">
</form>

<script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/js/webutils.js"></script>
<script>
    $(function () {
        //加载分页
        window.onscroll = function () {
            if (checkScrollSlide()) {
                var pageNum = $("#pageNum").val();
                $("#pageNum").val(++pageNum);
                var pages = $("#pages").val();
                if (pageNum <= pages) {
                    var url = "/front/teacherList";
                    getTextData(url,function(data){
                        $("#main").append(data);
                    })
                }
            }
        }
    })
</script>
</body>
</html>
<#else>
    <#list pageInfo.list as teacher>
            <div class="listCard">
                <img src="${(teacher.url)!}">
                <div class="info">
                    <h2>${(teacher.name)}</h2>
                    <p class="text">
                        撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大夫撒打发士大撒打发士大夫撒旦飞洒地方阿斯蒂芬撒撒飞洒地方夫撒打发士大撒打发士大夫撒旦飞洒地方阿斯蒂芬撒撒飞洒地方</p>
                </div>
                <div class="floatClear"></div>
            </div>
    </#list>
</#if>