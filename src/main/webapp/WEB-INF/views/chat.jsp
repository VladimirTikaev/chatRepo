<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<h2>Hello ${sender} jsp!</h2>
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

<h4>Add new message</h4>
 <form action="addMessage" method="post">
        <label>
            <input type="hidden" name="sender" value="${sender}">
            <input type="text" name="text"/>
            <button type="submit">Send</button>
        </label>
    </form>
     <form action="hello" method="get">
            <label>
                <button type="submit">Exit</button>
            </label>
        </form>

</body>

