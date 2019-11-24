<div class="panel">
    <div class="panelBody">
        <form id="dataForm">
            <div class="formInput">
                <span>课程名称：</span>
                <input type="text" name="name" value="${(course.name)!}">
            </div>
            <div class="formInput">
                <span>课程图片：</span>
                <div class="upload">
                    <div class="uploadUrl">
                        <input type="hidden" id="fileUrl" name="url" value="${(course.url)!}">
                        <input type="hidden" id="fileUrl" name="id" value="${(course.id)!}">
                    </div>
                    <div class="uploadBtn">
                        <a href="javascript:void(0);" class="file">
                            选择文件
                            <input type="file" id="file" onchange="addImg()" accept="image/jpeg,image/png"
                                   multiple="multiple">
                        </a>
                    </div>
                    <div class="uploadFile">
                        <#if (course.url)??&&course.url!=''>
                            <img src="${(course.url)!}" class="imgPreview" height="400px">
                        </#if>
                    </div>
                </div>
            </div>
            <input type="button" value="提交" onclick="saveCourse()">
            <input type="button" value="返回" onclick="getCourseListPage()">
        </form>
    </div>
</div>
<script>
    function addImg() {
        uploadImg("course", "400px");
    }
    function saveCourse() {
        $.ajax({
            url: "/admin/ajax/courseSave",
            type: "post",
            data: $("#dataForm").serialize(),
            dataType: "json",
            success: function (data) {
                if (data.status) {
                    layer.msg(data.msg);
                }
            },
            error: function () {
                layer.msg("操作失败");
            }
        });
    }
</script>