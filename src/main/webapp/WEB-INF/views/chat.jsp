<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<h2>Hello ${sender123} jsp!</h2>
<table>
    <tr>
        <th>sender</th>
        <th>text</th>
    </tr>
      <c:forEach items="${messages}" var="chatList">
            <tr>
                <td>${chatList.time}</td>
                <td>${chatList.sender}</td>
                <td>${chatList.text}</td>
            </tr>
        </c:forEach>
</table>
</body>

