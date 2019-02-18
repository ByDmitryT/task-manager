<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Task Manager</title>
    </head>
    <body>
        <h1>WELCOME USER : <c:out value="${user.login}"></c:out></h1>
        <h2>TASKS PROJECT <c:out value="${project.name}"/>:</h2>
        <p>
            <a href="/taskmanager/project-list">PROJECTS</a>
        </p>
        <table border="1" cellpadding="5" cellspacing="1" style="width:100%">
        	<tbody>
        	    <tr>
        	        <td style="text-align:center;width:30px">
        	            <p>#</p>
        	        </td>
                    <td>
                        <p>NAME</p>
                    </td>
                    <td>
                        <p>DESCRIPTION</p>
                    </td>
                    <td>
                        <p>PROJECT NAME</p>
                    </td>
                    <td>
                        <p>STATUS</p>
                    </td>
                    <td>
                        <p>CREATED DATE</p>
                    </td>
                    <td style="text-align:center;width:100px" />
                    <td style="text-align:center;width:100px" />
        	    </tr>
        	    <c:forEach var="task" items="${tasks}" varStatus="loop">
        	        <tr>
                        <td style="text-align:center">
                            <p><c:out value="${loop.count}"/></p>
                        </td>
                        <td>
                            <p><c:out value="${task.name}"/></p>
                        </td>
                        <td>
                            <p><c:out value="${task.description}"/></p>
                        </td>
                        <td>
                            <p><c:out value="${task.project.name}"/></p>
                        </td>
                        <td>
                            <p><c:out value="${task.status}"/></p>
                        </td>
                        <td>
                            <p><fmt:formatDate value="${task.created}" pattern="yyyy-MM-dd HH:mm:ss" /><p>
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