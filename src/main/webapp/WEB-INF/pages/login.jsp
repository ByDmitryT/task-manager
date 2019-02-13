<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Task Manager</title>
 </head>
 <body>
    <h3 style="color:#aaaaaa; font-style:italic"><cite><span style="font-size:48px">TASKMANAGER</span></cite></h3>
    <form action="login" method="post" name="login-form">
        <p>USERNAME:&nbsp;<input name="username" type="text" /></p>
        <p>PASSWORD:&nbsp;<input name="password" type="password" /></p>
        <input name="login-button" type="submit" value="LOGIN" />
    </form>
    <p>&nbsp;</p>
 </body>
</html>