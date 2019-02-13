<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>WELCOME USER : <c:out value="${user.login}"></c:out></h1>
        <h2>TASK CREATE FOR PROJECT <c:out value="${project.name}"/>:</h2>
        <form:form method="POST" action="/taskmanager/task-create-for-project" modelAttribute="task">
            <span>
                <form:label path="name">NAME:</form:label>
                <form:input path="name"/>
            </span>
            <span>
                <form:label path="description">DESCRIPTION:</form:label>
                <form:input path="description"/>
            </span>
            <form:hidden path="id"/>
            <form:hidden path="project.id"/>
            <p>
                <input name="save-button" type="submit" value="SAVE" />
            </p>
        </form:form>
    </body>
</html>