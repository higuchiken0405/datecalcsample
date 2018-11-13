<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String[] timeList = (String[]) request.getAttribute("timeList");
%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <% for(String time:timeList) { %>
            <%= time %><br><br>
        <% } %>
    </body>
</html>