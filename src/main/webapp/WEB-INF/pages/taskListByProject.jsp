<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
    <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>WELCOME USER : <c:out value="${user.login}"></c:out></h1>
        <h2>TASKS PROJECT <c:out value="${project.name}"/>:</h2>
        <p>
            <a href="/taskmanager/project-list">PROJECTS</a>
        </p>
        <table border="1" cellpadding="1" cellspacing="1" style="width:800px">
        	<tbody>
        	    <c:forEach var="task" items="${tasks}" varStatus="loop">
        	        <tr>
                        <td style="text-align:center">
                            <p><c:out value="${loop.count}"/></p>
                        </td>
                        <td style="text-align:center">
                            <p><c:out value="${task.name}"/></p>
                        </td>
                        <td style="text-align:center">
                            <p><c:out value="${task.description}"/></p>
                        </td>
                        <td style="text-align:center">
                            <a href="/taskmanager/task-edit/${task.id}">
                                <button>EDIT</button>
                            </a>
                        </td>
                        <td style="text-align:center">
                             <a href="/taskmanager/task-remove/${task.id}">
                                <button>REMOVE</button>
                             </a>
                        </td>
                    </tr>
                </c:forEach>
        	</tbody>
        </table>
        <a href="/taskmanager/task-create-for-project/${project.id}">
            <button>CREATE</button>
        </a>
    </body>
</html>