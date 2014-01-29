<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="shortcut icon" href="images/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/books.css"/>
	<meta content="text/html; charset=UTF8" http-equiv="content-type">
		<title>index</title>
		<style type="text/css">
		 .menuAnchor {
		 	text-decoration: none;
		 	color: black;
		 }
		 .hdiv{
		 	width: 100px;
		 }
		 .outerContainer {
	    	display: table;
	    	width: 99%; 
	    	height:70px;
	    	overflow: hidden;
	    	border:1px solid green;
		}
		.outerContainer .innerContainer {
		    display: table-cell;
		    vertical-align: middle;
		    /* width: 100%; */
		    margin: 0 auto;
		}
		</style>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>	
		<script type="text/javascript">
		$(document).ready(function(){
			$(".hdiv").hover(function() {
				$(this).stop(true, false).animate({ width: "150px" });
			}, function() {
				$(this).stop(true, false).animate({ width: "100px" });
			});
			
			$("#search").keyup(function(e) {
				if (e.keyCode == 13) {
					$.ajax({
						type : 'GET',
						url  : 'https://api.duckduckgo.com/',
						data : {
							q : $(this).val(),
							format : 'json',
							pretty : 1
						},
						jsonpCallback : 'jsonp',
						dataType : 'jsonp'
						}).then(function(data) {populateTable(data);});
					}else{
						$("#resultTable").html('');
					}
				});

			});
			
			function populateTable(data) {
				console.log(data);
				if(data.RelatedTopics.length!=0){
					var str = '';
					var gstr = '';
					var array = data.RelatedTopics;
				    for (var i = 0; i < array.length; i++) {
				        if(array[i].hasOwnProperty('Text')){
				        	
				        	str += loadResults(array[i]);
				        	
				        }else{
				        	gstr += '<div><h1>'+array[i].Name+'</h1></div>';
				        	var subTopics = array[i].Topics;
				        	for (var j = 0; j < subTopics.length; j++) {
				        		gstr += loadResults(subTopics[j]);
				        	}
				        }
				    }
					
					$("#resultTable").css("visibility", "visible");
					$("#resultTable").html("");
					$("#resultTable").html(str+gstr);
					
				}else{
					//TO DO
				}
			}
			
			function loadResults(arr){
				var resStr = '';
				resStr +='<div class=\"outerContainer\"><div class=\"innerContainer\"><div>';
				resStr +='<img src=\"'+arr.Icon.URL+'\" style=\"vertical-align: middle;display:inline-block;\"/>';
				resStr += '<p style=\"display:inline-block;\">'+arr.Result+'</p></div></div></div>'; 
	        	return resStr;
			}
		</script>
	</head>
	<body ><!-- style="background: url('images/graph.png');background-repeat: repeat;" -->
		<a href="http://www.springsource.org/">
			<!-- <img style="border: 0px solid; width: 1221px; height: 130px;" src="images/banner4.jpg" alt=""> -->
			<img style="border: 0px solid;" src="images/banner4.jpg" alt=""></a>
		<br/><br/>
		<div>
			<div class="hdiv" style="background: #ccc;"><s:a cssClass="menuAnchor" href="user/userLogin.action">Login</s:a></div>
			<div class="hdiv" style="background: #999;"><s:a cssClass="menuAnchor" href="user/register.action">Register</s:a></div>
			<div class="hdiv" style="background: #666;"><s:a cssClass="menuAnchor" href="admin/adminLogin.action">Admin Login</s:a></div>
			<div class="hdiv" style="background: #fff;"><s:a cssClass="menuAnchor" href="configman/main.action">Configuration Management</s:a></div>
		</div>
		<br/>
		<br/>
		<br/>
		<div align="center">
			<input type="text" id="search" value="" style="width: 300px;"/><br/>
			<button id="searchbtn">Search</button>
		</div>
		<div id="resultTable" align="center" style="visibility: hidden;"></div>
	</body>
</html>