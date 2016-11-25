<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Employees Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-employer"> New Employer</a></li>
					<li><a href="all-employees"> All Employees</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>


		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Employer Manager</h1>
				</div>
			</div>
		</c:when>



		<c:when test="${mode=='MODE_EMPLOYEES'}">
			<div class="container text-center" id="employeesDiv">
				<h3>My Employees</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>employer Number</th>
								<th>Birth Date</th>
								<th>firstname</th>
								<th>lastName</th>
								<th>Gender</th>
								<th>Hire Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="employer" items="${employees}">
								<tr>
									<td>${employer.empNo}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${employer.birthDate}" /></td>
									<td>${employer.firstName}</td>
									<td>${employer.lastName}</td>
									<td>${employer.gender==true?"F":"M"}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${employer.hireDate}" /></td>


									<td><a href="update-employer?empNo=${employer.empNo}">
											<span class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-employer?empNo=${employer.empNo}">
											<span class="glyphicon glyphicon-trash"></span>
									</a></td>



								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>





		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Employer</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-employer">
					<input type="hidden" name="empNo" value="${employer.empNo}" />

					<div class="form-group">
						<label class="control-label col-sm-3">Birth Date:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="birthDate"
								value="${employer.birthDate}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Firstname:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="firstName"
								value="${employer.firstName }" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Lastname:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="lastName"
								value="${employer.lastName}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Finished:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="gender" value="true" />
							<div class="col-sm-1">F</div>
							<input type="radio" class="col-sm-1" name="gender" value="false"
								checked="checked" />
							<div class="col-sm-1">M</div>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Hire Date:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="hireDate"
								value="${employer.hireDate}" />
						</div>
					</div>



					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>

		</c:when>

	</c:choose>

	<script type="text/javascript" src="/static/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js">
		
	</script>
</body>
</html>