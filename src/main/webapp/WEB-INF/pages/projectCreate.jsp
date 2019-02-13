<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>WELCOME USER : <c:out value="${user.login}"></c:out></h1>
        <h2>PROJECT CREATE:</h2>
        <form:form method="POST" action="/taskmanager/project-create" modelAttribute="project">
            <span>
                <form:label path="name">NAME:</form:label>
                <form:input path="name"/>
            </span>
            <form:hidden path="id"/>
            <p>
                <input name="save-button" type="submit" value="SAVE" />
            </p>
        </form:form>
    </body>
</html>