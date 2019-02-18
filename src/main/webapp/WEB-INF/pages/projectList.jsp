<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Task Manager</title>
    </head>
    <body>
        <h1>WELCOME USER : <c:out value="${user.login}"></c:out></h1>
        <h2>PROJECTS:</h2>
        <table border="1" cellpadding="5" cellspacing="1" style="width:100%">
        	<tbody>
        	    <tr>
                    <td style="text-align:center;width:30px" >
                        <p>#</p>
                    </td>
                    <td>
                        <p>NAME</p>
                    </td>
                    <td style="text-align:center;width:100px" />
                    <td style="text-align:center;width:100px" />
                </tr>
        	    <c:forEach var="project" items="${projects}" varStatus="loop">
        	        <tr>
                        <td style="text-align:center">
                            <p><c:out value="${loop.count}"/></p>
                        </td>
                        <td>
                            <a href="/taskmanager/task-list-by-project/${project.id}"><c:out value="${project.name}"/></a>
                        </td>
                        <td style="text-align:center">
                            <a href="/taskmanager/project-edit/${project.id}">
                                <button>EDIT</button>
                            </a>
                        </td>
                        <td style="text-align:center">
                             <a href="/taskmanager/project-remove/${project.id}">
                                <button>REMOVE</button>
                             </a>
                        </td>
                    </tr>
                </c:forEach>
        	</tbody>
        </table>
        <a href="/taskmanager/project-create">
            <button>CREATE</button>
        </a>
    </body>
</html>