<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/jsp-decorator.tld" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html>
<head>	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginstyle.css">
    <script type="text/javascript">
        function inputFocus(i) {
            if (i.value == i.defaultValue) { i.value = ""; i.style.color = "#000"; }
        }
        function inputBlur(i) {
            if (i.value == "") { i.value = i.defaultValue; i.style.color = "#888"; }
        }
    </script>
 </head>   
 <body>
<div id="wrapper">
  <h1>Tab Login & Sign Up Forms</h1>
  <div id="container">
	<section class="tabs">
		<input id="tab-1" type="radio" name="radio-set" class="tab-selector-1"  />
		<span for="tab-1" class="tab-label-1">Signup</span>

		<input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" checked="checked"/>
		<span for="tab-2" class="tab-label-2">Login</span>

		<input id="tab-3" type="radio" name="radio-set" class="tab-selector-3" />
		<span for="tab-3" class="tab-label-3">Forget Password</span>
	
		<div class="clear-shadow"></div>
		
		<div id="content">
			<div class="content-1">
				<p>
					<a href="#" class="media tw">Twitter</a><a href="#" class="media fb">Facebook</a>
				</p>	
				<form  action="Registration" autocomplete="on"  method="post">
				  <p>
					<label for="usernamesignup" class="uname" data-icon="u">Your username</label>
					<input class="field" name="usernamesignup" required="required" type="text" value="myusername" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p>
					<label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
					<input class="field" name="emailsignup" required="required" type="email"  value="myusername@gmail.com" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p>
					<label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
					<input class="field" name="passwordsignup" required="required" type="password" value="mypassword" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p>
					<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
					<input class="field" name="passwordsignup_confirm" required="required" type="password" value="mypassword" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p class="signin button">
					<input type="checkbox" required="required" /> I agree with terms and conditions 
					<input type="submit" value="Sign up"/>
				  </p>
				</form>
			</div>
			<div class="content-2">
				<p>
					<a href="#" class="media tw">Facebook</a><a href="#" class="media fb">Twitter</a>
				</p>
				<form  action="Login" autocomplete="on" method="post">
				  <p>
					<label for="username" class="uname" data-icon="u" > Your email or username </label>
					<input class="field" name="username" required="required" type="text" value="myusername or myusername@gmail.com" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p>
					<label for="password" class="youpasswd" data-icon="p"> Your password </label>
					<input class="field" name="password" required="required" type="password" value="mypassword" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p class="keeplogin">
					<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> Keep me logged in
					<input type="submit" value="Login" />
				  </p>
				</form>
			</div>
			<div class="content-3">
				<form  action="" autocomplete="on"  method="post">
				  <p>
					<label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
					<input class="field" name="emailsignup" required="required" type="email" value="myusername@gmail.com" style="color:#888;" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
				  </p>
				  <p class="signin button">
					<input type="submit" value="Get New Password"/>
				  </p>
				</form>
			</div>
			
		</div>
	</section>
  </div>
</div>
</body>
</html>
