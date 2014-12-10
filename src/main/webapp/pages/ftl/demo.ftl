<html>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="/bootstrap/css/popkit-base.css" rel="stylesheet" media="screen" />
    <link rel="stylesheet" type="text/css" media="screen" href="/bootstrap/css/bootstrap-select.css">
<body>

<div class="wrap">
<#include "/pages/common/head.ftl" />
    <div class="container">
        <form method="post" action="/mobile/apitools/editRuleConfSubmit" id="editRuleConfSubmit" class="form-horizontal">
            <div class="panel panel-info">
                <div class="panel-heading">${panelName}</div>
                <div class="panel-body">
                    <div class="form-group form-horizontal row col-md-offset-1">
                        <div class="container">
                            <div class="col-sm-8">
                                <input name="url" type="text" class="form-control text-left" id="url" value=""
                                       placeholder="请输入要编码或解码的URL" required/>
                            </div>
                            <input type="checkbox" id="isEncode" name="isEncode"
                                   value="1" class="checkbox" onclick="encodeUrl(this)"
                                    />h5 URL编码
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group form-horizontal row col-md-offset-1">
                            <label class="control-label col-sm-1 text-left">文件MD5:</label>
                            <div class="col-sm-8">
                                <input name="icon" type="text" class="form-control text-left" id="icon"
                                       value="" placeholder="上传文件" required/>
                            </div>
                            <div class="col-sm-3">
                                <div id="personFile">
                                    <input type="file" name="upload" id="upload">
                                    <input type="button" class="btn-primary"
                                           onclick="ajaxFileUpload()" value="计算文件MD5值" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <label class="text-left" id="originURL"></label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="pull-right col-sm-1">
                    <button type="submit" class="btn btn-primary" id="submit-btn-form">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

<#include "/pages/common/foot.ftl" />
<script src="/bootstrap/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap/js/ajaxfileupload.js"></script>
<script type="text/javascript">
    var H5Prefix = "popkit://web?url=";
    function encodeUrl(obj) {
        var origin = $('#url').val();
        $('#originURL').html(origin);
        if (obj.checked) {
            var tmp = "";
            if (origin.indexOf("%") > 0) {
                // 说明可能已经编码过了，再尝试一次解码过程
                tmp = decodeURIComponent(origin);
                if (tmp.indexOf("%") == -1) {
                    $('#url').val( H5Prefix + encodeURIComponent(tmp));
                } else {
                    alert("给出的url似乎已经编码过了!")
                    $('#url').val( H5Prefix + origin);
                }
            } else { // 重未进行过编码
                $('#url').val( H5Prefix + encodeURIComponent(origin));
            }
        } else {
            if (origin.indexOf("url=") > 0) {
                sp = origin.split("url=");
                if (sp.length >= 2) {
                    $('#url').val(decodeURIComponent(sp[1]));
                }
            } else {
                $('#url').val(decodeURIComponent(origin));
            }
        }
    }

    function ajaxFileUpload() {
        $.ajaxFileUpload({
                    url             : '/upload', //需要链接到服务器地址
                    secureuri       : false,
                    fileElementId   : 'upload', //文件选择框的id属性
                    dataType        : 'json', //服务器返回的格式
                    data            : {server : 'popkit.org', path : '/server/data'},
                    success     : function(data,status) //相当于java中try语句块的用法
                    {
                        if (data.status == "success" && data.md5.length != 0) {
                            $('#icon').val(data.md5);
                        } else {
                            alert(data.info);
                        }
                    },
                    error : function(data, status, e) //相当于java中catch语句块的用法
                    {
                        $('#__content__').html('添加失败');
                    }
                }
        );
    }
</script>
</body>
</html>  