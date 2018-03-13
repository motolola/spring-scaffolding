<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/fontawesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<title>Yahoo!!</title>
</head>
<body>
<%@ include file="parts/navigation.jspf" %>

<div class="container">

<h1>Hi ${name}, Add ToDo</h1>

<form:form action="" method="post" commandName="todo">
<form:hidden path="id"/>
<form:hidden path="user" />
<fieldset class="form-group">
<form:label path="desc">Description</form:label>
<form:input path="desc" type="text" class="form-control" required="required" />
<form:errors path="desc" class="text-warning" ></form:errors>
</fieldset>
<fieldset class="form-group">
<form:label path="targetDate">Date</form:label>
<form:input path="targetDate" type="text" class="form-control" required="required" />
<form:errors path="targetDate" class="text-warning" ></form:errors>
</fieldset>
<input class="btn btn-success" type="submit" value="Add">
</form:form>
</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>