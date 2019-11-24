<#if pageInfo.pages == 0>
<div class="panel">
    <div class="panelBody">
        <input class="inlineInput marginBottom20" type="button" onclick="addCourse()" value="添加">
        <p class="hintText">暂无数据</p>
    </div>
</div>
<#else>
<div class="panel">
    <form id="dataForm">
        <input type="hidden" name="pageNum" id="pageNum">
        <div class="panelHeader">
            <input type="text" name="name" class="inlineInput" placeholder="请输入课程名称" value="${name!}">
            <input class="inlineInput" type="button" value="搜索" onclick="getCourseList(1)">
        </div>
        <div class="panelBody">
            <input class="inlineInput marginBottom20" type="button" onclick="addCourse()" value="添加">
            <input class="inlineInput marginBottom20" type="button" onclick="updateCourse()" value="修改">
            <input class="inlineInput marginBottom20" type="button" onclick="deleteCourse()" value="删除">
            <table>
                <thead>
                <tr>
                    <th width="5%">
                        <input type="checkbox" onclick="allCheck(this)">
                    </th>
                    <th>课程名称</th>
                    <th>添加时间</th>
                </tr>
                </thead>
                <tbody>
            <#list pageInfo.list as course>
            <tr>
                <td>
                    <input type="checkbox" class="checkbox" value="${course.id}" name="ids">
                </td>
                <td>${(course.name)!}</td>
                <td>${course.addTime?string('yyyy-MM-dd hh:mm:ss')}</td>
            </tr>
            </#list>
                </tbody>
            </table>
        </div>
        <div class="panelFooter">
            <div class="pageData">
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
            </div>
            <p class="pageInfo floatClear">共${pageInfo.pages}页</p>
        </div>
    </form>
</div>
</#if>
<script>
    function addCourse() {
        var url = "/admin/courseModify";
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    function updateCourse() {
        var length = $(".checkbox:checked").length;
        if (length == 0) {
            layer.msg("请选择要修改的数据");
            return;
        }
        var id = $(".checkbox:checked")[0].value;
        var url = "/admin/courseModify?id=" + id;
        getText(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    function deleteCourse(){
        var length = $(".checkbox:checked").length;
        if (length == 0) {
            layer.msg("请选择要删除的数据");
            return;
        }
        layer.confirm('确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                url: "/admin/ajax/courseDelete",
                type: "post",
                data: $("#dataForm").serialize(),
                dataType: "json",
                success: function (data) {
                    if (data.status) {
                        layer.msg(data.msg,{
                            time: 1000 //1秒关闭（如果不配置，默认是3秒）
                        },function(){
                            getCourseListPage();
                        });
                    }
                },
                error: function () {
                    layer.msg("操作失败");
                }
            });
        });
    }

    function getCourseList(pn) {
        $("#pageNum").val(pn);
        var url = "/admin/courseList";
        getTextData(url, function (data) {
            $(".adminRight").html(data);
        })
    }

    // 全选
    function allCheck(em) {
        $(".checkbox").prop('checked', $(em).prop('checked'));
    }
</script>