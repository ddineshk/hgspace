$(document).ready(function(){
	$("a").click(function(){
		$(this).blur();
	});
	$("li").mouseover(function(){
		$(this).stop().animate({height:'100px'},{queue:false, duration:600, easing: 'bounce'})
	});
	
	$("li").mouseout(function(){
		$(this).stop().animate({height:'50px'},{queue:false, duration:600, easing: 'bounce'})
	});
	
});


function setQueryString()
{
	var param="";
	for(var i=0;i<arguments.length;i++)
	{
		param+=arguments[i]+'='+arguments[i+1];
		if(i!=arguments.length-2)
		{
			param+="&";
			i++;
		}else
		{
			break;
		}

	}
	return param;
}
function Seach()
{
  if(document.form1.seachstr.value=="")
  {
    alert('emty');
    return false;
  }else
  {
   document.form1.submit();
  }
}
function BooksPage(page,search,bookTypeId,searchstr)
{
  alert('page - '+page+' search - '+search+' bookTypeId - '+bookTypeId+' searchstr - '+searchstr);
  window.navigate('BooksPageAction.do?'+setQueryString('page',page,'search',search,'bookTypeId',bookTypeId,'seachstr',searchstr));
}
function printTime(time)
{
document.write(time.substring(0,4)+"-"+time.substring(4,6)+"-"+time.substring(6,8));
}
