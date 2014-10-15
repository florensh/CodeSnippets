<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>


<link rel="stylesheet" href="../resources/prism.css">
<script src="../resources/prism.js"></script>
</head>
 
<h1>Code Snippets</h1>
<h2>Hello ${name}</h2>


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
		<h2>Welcome : ${pageContext.request.userPrincipal.name} 
                 | <a href="<c:url value="/logout" />" > Logout</a></h2>  
	</c:if>
	
	
 
</body>
</html>