<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Students Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="all-students">All Students</a></li>
					<li><a href="new-student">New Student</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>


		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to student Manager</h1>
				</div>
			</div>
		</c:when>

		
		<c:when test="${mode=='MODE_STUDENTS' }">
			<div class="container text-center" id="studentsDiv">
				<h3>My Students</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>StudentId:</th>
								<th>Firstname:</th>
								<th>Lastname;</th>
								<th>Year Level:</th>
								<th></th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="student" items="${students}">
								<tr>
									<td>${student.studentId}</td>
									<td>${student.firstname}</td>
									<td>${student.lastname}</td>
									<td>${student.yearLevel}</td>
									<td><a
										href="update-student?studentId=${student.studentId}"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a
										href="delete-student?studentId=${student.studentId}"> <span
											class="glyphicon glyphicon-trash"></span>
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
				<h3>Manage Strudent</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-student">
					<input type="hidden" name="studentId" value="${student.studentId}" />

					<div class="form-group">
						<label class="control-label col-sm-3">Firstname:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="firstname"
								value="${student.firstname }" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Lastname:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="lastname"
								value="${student.lastname }" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Finished:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="yearLevel" value="${student.yearLevel }" />
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