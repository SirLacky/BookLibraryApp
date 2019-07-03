<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Online Library</title>
</head>
<body>

<h1>Choose option: </h1>



<form:form method="post" action="/isbn" modelAttribute="form">
    Find Book by ISBN:<br>
    <form:input path="isbn"/>
    <button type="submit">Find</button>
</form:form>
<hr>
<form:form method="post" action="/category" modelAttribute="form">
    Find Book by Category:<br>
    <form:input path="category"/>
    <button type="submit">Find</button>
</form:form>
<hr>
<form:form method="post" action="/rating" modelAttribute="form">
    Check authors rating:<br>
    <form:input path="author"/>
    <button type="submit">Find</button>
</form:form>
<hr>

</body>
</html>