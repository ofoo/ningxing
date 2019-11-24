<div class="panel">
    <div class="panelBody">
        <form id="dataForm">
            <div class="formInput">
                <span>讲师名称：</span>
                <input type="text" name="name" value="${(teacher.name)!}">
            </div>
            <div class="formInput">
                <span>讲师图片：</span>
                <div class="upload">
                    <div class="uploadUrl">
                        <input type="hidden" id="fileUrl" name="url" value="${(teacher.url)!}">
                        <input type="hidden" id="fileUrl" name="id" value="${(teacher.id)!}">
                    </div>
                    <div class="uploadBtn">
                        <a href="javascript:void(0);" class="file">
                            选择文件
                            <input type="file" id="file" onchange="addImg()" accept="image/jpeg,image/png"
                                   multiple="multiple">
                        </a>
                    </div>
                    <div class="uploadFile">
                        <#if (teacher.url)??&&teacher.url!=''>
                            <img src="${(teacher.url)!}" class="imgPreview" height="400px">
                        </#if>
                    </div>
                </div>
            </div>
            <input type="button" value="提交" onclick="saveTeacher()">
            <input type="button" value="返回" onclick="getTeacherListPage()">
        </form>
    </div>
</div>
<script>
    function addImg() {
        uploadImg("teacher", "400px");
    }
    function saveTeacher() {
        $.ajax({
            url: "/admin/ajax/teacherSave",
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