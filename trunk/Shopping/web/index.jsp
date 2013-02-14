<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Shopping</title>
<!-- <script type="text/javascript" src="js/jquery-1.9.0.js"></script> -->
<script type="text/javascript">
/*$(document).ready(function() {
	$('a.login-window').click(function() {
		
		var loginBox = $(this).attr('href');

		$(loginBox).fadeIn(300);
		
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(300);
		
		return false;
	});
	
	$('a.close, #mask').click(function(){ 
	    $('#mask , .login-popup').fadeOut(300 , function(){$('#mask').remove();}); 
	    return false;
    });
});*/

</script>

</head>
<body>
	<c:if test="${not empty user}">
	    <c:redirect url="main.jsp"></c:redirect>
	</c:if>
	<form method="post" class="signin" action="login.do">
		<fieldset class="textbox">
			<label class="username"> 
				<span>Username&nbsp;&nbsp;</span> 
				<input id="userName" name="userName" value="" type="text" placeholder="Username"/>
			</label> <br/>
			<label class="password"> 
				<span>Password&nbsp;&nbsp;&nbsp;</span> 
				<input id="password" name="password" value="" type="password" placeholder="Password"/>
			</label>
			<br/>
			<input type="submit" value="Sign in" />
			<p>
				<a class="forgot" href="#">Forgot your password?</a>
			</p>
		</fieldset>
	</form>

	<%-- <div class="container">
		<div id="content">
			<div class="post">
				<div class="btn-sign">
					<a href="#login-box" class="login-window">Login / Sign In</a>
				</div>
			</div>
			<div id="login-box" class="login-popup">
				<a href="#" class="close"><img src="close_pop.png"
					class="btn_close" title="Close Window" alt="Close" /></a>
				<form method="post" class="signin" action="#">
					<fieldset class="textbox">
						<label class="username">
							<span>Username</span>
							<input id="username" name="username" value="" type="text" placeholder="Username">
						</label> 
						<label class="password"> 
							<span>Password</span> 
							<input id="password" name="password" value="" type="password" placeholder="Password">
						</label>
						<button class="submit button" type="button">Sign in</button>
						<p>
							<a class="forgot" href="#">Forgot your password?</a>
						</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div> --%>
</body>
</html>