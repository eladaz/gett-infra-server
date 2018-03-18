<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>404 Error</title>
</head>
    <body>
        <h1>Page Not Found</h1>
        <h3>Apologize, we could not find the page you were looking for:</h3>
            ${pageContext.errorData.requestURI}
    </body>
</html>
