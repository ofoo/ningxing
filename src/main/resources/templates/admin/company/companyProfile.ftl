<div class="panel">
    <div class="panelBody">
        <form id="dataForm">
            <div class="formTextarea">
                <span>${name}：</span>
                <textarea name="content">${(company.content)!}</textarea>
            </div>
            <div class="formInput">
                <span>公司图片：</span>
                <div class="upload">
                    <div class="uploadUrl">
                        <input type="hidden" id="fileUrl" name="url" value="${(company.url)!}">
                        <input type="hidden" id="fileUrl" name="type" value="${type}">
                        <input type="hidden" id="fileUrl" name="id" value="${(company.id)!}">
                    </div>
                    <div class="uploadBtn">
                        <a href="javascript:void(0);" class="file">
                            选择文件
                            <input type="file" id="file" onchange="addImg()" accept="image/jpeg,image/png"
                                   multiple="multiple">
                        </a>
                    </div>
                    <div class="uploadFile">
                        <#if (company.url)?? && company.url!=''>
                            <img src="${(company.url)!}" class="imgPreview" height="400px">
                        </#if>
                    </div>
                </div>
            </div>
            <input type="button" value="提交" onclick="saveCompany()">
        </form>
    </div>
</div>
<script>
    function addImg() {
        uploadImg("company", "400px");
    }

    function saveCompany() {
        $.ajax({
            url: "/admin/ajax/companyProfile",
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