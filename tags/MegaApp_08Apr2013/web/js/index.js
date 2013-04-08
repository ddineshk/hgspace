$(document).ready(function(){
	$("a").click(function(){
		$(this).blur();
	});
	$("li.drop").mouseover(function(){
		$(this).stop().animate({height:'100px'},{queue:false, duration:600, easing: 'bounce'});
	});
	
	$("li.drop").mouseout(function(){
		$(this).stop().animate({height:'50px'},{queue:false, duration:600, easing: 'bounce'});
	});
	
});
