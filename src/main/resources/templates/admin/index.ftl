<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <style>
        .welcome {
            text-align: center;
            font-size: 60px;
            margin-top: 15%;
            font-weight: lighter;
            /*color: #00FF66;*/
        }
    </style>
</head>
<body>
<div>
    <div class="adminHeader">
        <div class="adminLogo">
            <a href="/admin/index">
                <img class="adminImg" src="/img/default.png">
            </a>
        </div>
        <!--<div class="adminNav">
            <a class="adminText" href="javascript:void(0)">课程</a>
            <a class="adminText" href="javascript:void(0)">讲师</a>
            <a class="adminText" href="javascript:void(0)">公司</a>
            <a class="adminText" href="javascript:void(0)">广告</a>
        </div>-->
        <div class="adminTitle">
            <span class="adminText" id="pageTitle"></span>
        </div>
        <div class="adminButton">
            <a class="adminText" href="/exit">退出</a>
        </div>
        <div class="floatClear"></div>
    </div>
    <div class="adminContent">
        <div class="adminLeft">
            <div class="adminText">
                <a href="javascript:void(0)" onclick="writePage(this,'course')">课程管理</a>
            </div>
            <div class="adminText">
                <a href="javascript:void(0)" onclick="writePage(this,'teacher')">讲师管理</a>
            </div>
            <div class="adminText">
                <a href="javascript:void(0)" onclick="writePage(this,'companyAbout')">公司简介</a>
            </div>
            <div class="adminText">
                <a href="javascript:void(0)" onclick="writePage(this,'companyProfile')">关于我们</a>
            </div>
            <div class="adminText">
                <a href="javascript:void(0)" onclick="writePage(this,'banner')">广告图</a>
            </div>
        </div>
        <div class="adminRight">
        <#--<p class="welcome">您好我叫练束梅</p>-->
        </div>
    </div>
</div>

<script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/layer/layer.js"></script>
<script type="text/javascript" src="/js/webutils.js"></script>
<script>
    // 改变页面
    function writePage(em,type) {
        $("#pageTitle").text(em.text)
        if (type=='banner'){
            getBannerModifyPage()
        } else if (type=='teacher'){
            getTeacherListPage()
        } else if (type=='course'){
            getCourseListPage()
        } else if (type=='companyAbout'){
            getCompanyAboutUsPage()
        } else if (type=='companyProfile'){
            getCompanyProfilePage()
        }
    }


    // 广告图
    function getBannerModifyPage() {
        var url = "/admin/bannerModify";
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    // 公司简介
    function getCompanyProfilePage() {
        var url = "/admin/companyProfile";
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    // 关于我们
    function getCompanyAboutUsPage() {
        var url = "/admin/companyAboutUs";
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    // 关于我们
    function getCourseListPage() {
        var url = "/admin/courseList";
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    // 关于我们
    function getTeacherListPage() {
        var url = "/admin/teacherList";
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }
</script>
</body>
</html>
