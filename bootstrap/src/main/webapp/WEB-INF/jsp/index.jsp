<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Index Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/students">Students</a></li>
					<li><a href="/tasks">tasks</a></li>
					<li><a href="/stores">Stores</a></li>
					<li><a href="/employees">Employees</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
			<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to system</h1>
				</div>
			</div>
		</c:when>
	
	</c:choose>

	
	<script type="text/javascript" src="/static/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js">
		
	</script>
</body>
</html>