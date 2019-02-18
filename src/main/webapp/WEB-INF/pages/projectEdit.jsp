<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>WELCOME USER : <c:out value="${user.login}"></c:out></h1>
        <h2>PROJECT EDIT:</h2>
        <form:form method="POST" action="/taskmanager/project-save" modelAttribute="project">
            <table cellpadding="10">
                <tbody>
                    <tr>
                        <td>
                            <form:label path="name">NAME:</form:label>
                        </td>
                        <td>
                            <form:input path="name"/>
                        </td>
                    </tr>
                        <td>
                            <input name="save-button" type="submit" value="SAVE" />
                        <form:hidden path="id"/>
        </form:form>
    </body>
</html>