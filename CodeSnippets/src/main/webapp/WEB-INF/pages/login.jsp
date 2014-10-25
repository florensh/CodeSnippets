<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring Security Form Login Tutorial</title>
        <link rel="stylesheet" href="http://localhost:8080/CodeSnippets/resources/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://localhost:8080/CodeSnippets/resources/bootstrap/css/bootstrap-theme.min.css">
				<link rel="stylesheet" href="http://localhost:8080/CodeSnippets/resources/custom.css">
	<!--  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
		<script src="http://localhost:8080/CodeSnippets/resources/bootstrap/js/bootstrap.min.js"></script>
				<script src="http://localhost:8080/CodeSnippets/resources/custom.js"></script>
    </head>
     
    <body>
    
    <!--  
    
    <section id="login">
        <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
        <h1>Login</h1>
        <form id="form" action="<c:url value='/login'/>" method="POST">
         
            <c:if test="${not empty param.error}">
                <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div>
            </c:if>
            <c:if test="${not empty param.out}">
                <div>You've logged out successfully.</div>
            </c:if>
            <c:if test="${not empty param.time}">
                <div>You've been logged out due to inactivity.</div>
            </c:if>
             
            Username:<br>
            <input type="text" name="username" value=""/><br><br>
            Password:<br>
            <input type="password" name="password" value=""/>
             
            <input value="Login" name="submit" type="submit"/>
        </form>
                	    </div>
    		</div> 
    	</div> 
    </div> 
    </section>
    
    -->
    
    
    
    
    

<section id="login">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="form-wrap">
                <h1>Log in with your email account</h1>

                    <form role="form" action="<c:url value='/login'/>" method="post" id="login-form" autocomplete="off">
                        <div class="form-group">
                            <label for="username" class="sr-only">Email</label>
                            <input type="email" name="username" id="username" class="form-control" placeholder="somebody@example.com">
                        </div>
                        <div class="form-group">
                            <label for="password" class="sr-only">Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <span class="character-checkbox" onclick="showPassword()"></span>
                            <span class="label">Show password</span>
                        </div>
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Log in">
                    </form>
                    <a href="javascript:;" class="forget" data-toggle="modal" data-target=".forget-modal">Forgot your password?</a>
                    <hr>
                </div>
            </div> <!-- /.col-xs-12 -->
        </div> <!-- /.row -->
    </div> <!-- /.container -->
</section>
<div class="modal fade forget-modal" tabindex="-1" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
 
    
    
    </body>
</html>