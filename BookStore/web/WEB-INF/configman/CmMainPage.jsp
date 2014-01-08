<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuration Management</title>
<style type="text/css">
#flotcontainer {
	width: 600px;
	height: 200px;
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%
		session = request.getSession(false);
		if (session.getAttribute("user") == null) {
			response.sendRedirect("configmanLogin.action");
		}
	%>
	<jsp:include page="cmheader.jsp" />
	<script type="text/javascript" src="../js/jquery.flot.min.js"></script>
	<script type="text/javascript" src="../js/jquery.flot.time.js"></script>
	<script type="text/javascript" src="../js/jquery.flot.axislabels.js"></script>
	<script>
		var data = [];
		var dataset;
		var totalPoints = 50;
		var updateInterval = 1000;
		var now = new Date().getTime();

		function GetData() {
			data.shift();
			while (data.length < totalPoints) {
				var y = Math.random() * 100;
				var temp = [ now += updateInterval, y ];
				data.push(temp);
			}
			
		}

		var options = { series : { lines : { show : true, lineWidth : 1.2, fill : true } },
						xaxis : { mode : "time", tickSize : [ 2, "second" ], tickFormatter : function(v, axis) {
							var date = new Date(v);
					if (date.getSeconds() % 20 == 0) {
						var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
						var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
						var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
						return hours + ":" + minutes + ":" + seconds;
					} else {
						return "";
					}
				},
				axisLabel : "Time",
				axisLabelUseCanvas : true,
				axisLabelFontSizePixels : 12,
				axisLabelFontFamily : 'Verdana, Arial',
				axisLabelPadding : 10
			},
			yaxis : {
				min : 0,
				max : 100,
				tickSize : 5,
				tickFormatter : function(v, axis) {
					if (v % 10 == 0) {
						return v + "%";
					} else {
						return "";
					}
				},
				axisLabel : "CPU loading",
				axisLabelUseCanvas : true,
				axisLabelFontSizePixels : 12,
				axisLabelFontFamily : 'Verdana, Arial',
				axisLabelPadding : 6
			},
			legend : {
				labelBoxBorderColor : "#fff"
			}
		};

		$(document).ready(function() {
			GetData();
			dataset = [ {
				label : "CPU",
				data : data
			} ];
			$.plot($("#flotcontainer"), dataset, options);
			function update() {
				GetData();
				$.plot($("#flotcontainer"), dataset, options)
				setTimeout(update, updateInterval);
			}
			update();
		});
	</script>
	<br/>
	<br/>
	<br/>
	<div id="flotcontainer"></div>
</body>
</html>