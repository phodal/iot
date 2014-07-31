
<!DOCTYPE html lang="zh-cn">
<html>
  	<head>
	    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
	    <meta name="keywords" content="">
	    <meta name="description" content="">
	    <meta name="viewport" content="width=device-width, initial-scale=1">

	    <title>IOT</title>
		<link rel="stylesheet" type="text/css" href="<?= url('css/jquery.mobile-1.4.0.min.css') ?>" />
		<link rel="stylesheet" type="text/css" href="<?= url('css/jquery.mobile.structure-1.4.0.min.css') ?>" />
	</head>
<body>

<body>
	<div data-role="page">

		<div data-role="header" class="ui-bar ui-bar-b" class="jqm-header">
			<h1>基础控制</h1>
		</div>

		<div data-role="collapsible" data-collapsed="false">
			<h3>查看温度情况</h3>
		<div>
		<div id="Tchart" style="min-width:800px;width:100%;height:300px"></div>
		</div>
	</div>
	<div data-role="footer" class="ui-bar ui-bar-b" data-position="fixed">
		<h4>Power by Phodal</h4>
	</div>
</body>

<script type="text/javascript" src="<?= url('js/jquery-2.0.3.min.js
')?>"></script>
<script type="text/javascript" src="<?= url('js/jquery.mobile-1.4.0.min.js')?>"></script>
<script type="text/javascript" src="<?= url('js/highcharts.js')?>"></script>
<script type="text/javascript" src="<?= url('js/log.js') ?>"></script>
<script type="text/javascript" src="<?= url('js/exporting.js') ?>"></script>
<script type="text/javascript" src="<?= url('js/app.js')?>"></script>

</body>
</html>
