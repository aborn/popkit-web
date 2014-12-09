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
                    <div class="col-sm-8">
                        <input name="url" type="text" class="form-control text-left" id="url" value="" placeholder="url" required/>
                    </div>

                    <div>
                        ${info}
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

<#include "/pages/common/head.ftl" />
<script src="/bootstrap/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>  