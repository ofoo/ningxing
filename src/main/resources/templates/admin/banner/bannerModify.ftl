<div class="panel">
    <div class="panelBody">
        <form id="dataForm">
            <div class="formInput">
                <span>广告图：</span>
                <div class="upload">
                    <div class="uploadUrl">
                        <input type="hidden" id="fileUrl" name="url" value="${(banner.url)!}">
                        <input type="hidden" id="fileUrl" name="id" value="${(banner.id)!}">
                    </div>
                    <div class="uploadBtn">
                        <a href="javascript:void(0);" class="file">
                            选择文件
                            <input type="file" id="file" onchange="addImg()" accept="image/jpeg,image/png"
                                   multiple="multiple">
                        </a>
                    </div>
                    <div class="uploadFile">
                        <#if (banner.url)??&&banner.url!=''>
                            <img src="${(banner.url)!}" class="imgPreview" height="400px">
                        </#if>
                    </div>
                </div>
            </div>
            <input type="button" value="提交" onclick="saveBanner()">
        </form>
    </div>
</div>
<script>
    function addImg() {
        uploadImg("banner", "400px");
    }

    function saveBanner() {
        $.ajax({
            url: "/admin/ajax/bannerModify",
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