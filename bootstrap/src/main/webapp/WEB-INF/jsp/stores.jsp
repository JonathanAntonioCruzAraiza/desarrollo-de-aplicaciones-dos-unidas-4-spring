<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Stores Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="all-stores">All Stores</a></li>
					<li><a href="new-stor">New Stor</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>


		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to stor Manager</h1>
				</div>
			</div>
		</c:when>

		
		<c:when test="${mode=='MODE_STORES'}">
			<div class="container text-center" id="sotresDiv">
				<h3>My Storess</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
							    <th>Stor Id</th>
								<th>Stor name:</th>
								<th>Stor address:</th>
								<th>city:</th>
								<th>state:</th>
								<th></th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="stor" items="${stores}">
								<tr>
									<td>${stor.storId}</td>
									<td>${stor.storName}</td>
									<td>${stor.storAddress}</td>
									<td>${stor.city}</td>
									<td>${stor.state}</td>
									
									<td><a
										href="update-stor?storId=${stor.storId}"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a
										href="delete-stor?storId=${stor.storId}"> <span
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
				<h3>Manage Stor</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-stor">
					<input type="hidden" name="storeId" value="${stor.storId}" />

					<div class="form-group">
						<label class="control-label col-sm-3">stor name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="storName"
								value="${stor.storName}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">City:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="storAddress" value="${stor.storAddress}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">City:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="city" value="${stor.city}" />
						</div>
					</div>
						<div class="form-group">
						<label class="control-label col-sm-3">State:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="state" value="${stor.state}" />
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