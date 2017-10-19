<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/fontawesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<title>Yahoo!!</title>
</head>
<body>
<div class="container"> 


Hi ${name}, Your Todos are ... <br>
<table class="table table-striped table-hover">
<tr>
<th>USER <i class="fa fa-building" aria-hidden="true"></i></th>
<th>Description</th>
<th>Date</th>
<th>Status</th>
<th></th>
</tr>

<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.user}</td>
<td>${todo.desc}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td>
<a type="button" class="btn btn-danger" 
		href="/delete-todo?id=${todo.id}">Delete</a>
</td>
</tr>

</c:forEach>

</table>

<br>
<div>
<a class="btn btn-success" href="/add-todo">Add</a>
</div>


</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>