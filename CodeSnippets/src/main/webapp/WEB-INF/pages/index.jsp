<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>

        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap-theme.min.css">
	<!--  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
		<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../resources/prism.css">
<script src="../resources/prism.js"></script>
</head>
 <body>
 
 <div class="container">
    <div class="jumbotron">
<h1>Code Snippets</h1>
<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et</p>
    </div>
    
    <pre class="line-numbers" data-line="7">
<code class="language-java">

	public class HelloWorld{
	
	//contructor
	public HelloWord(){
	System.out.println("Hello World!");
	}
	}

</code>
</pre>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<p>Welcome : ${pageContext.request.userPrincipal.name} 
                 | <a href="<c:url value="/logout" />" > Logout</a></p>  
	</c:if>
	
	    </div>
 
</body>
</html>