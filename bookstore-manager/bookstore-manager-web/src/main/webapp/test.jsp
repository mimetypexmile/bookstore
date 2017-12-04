<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/23
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
    <button id="delete">删除</button>

    <button id="addOrder">添加订单</button>
</body>
<script src="js/jquery-1.12.4.min.js"></script>

<script>
    $("#addOrder").click(function () {
        alert("ook");
        var books = [];
        var counts = [];
        var book1 ={"id":123,"bookname":"xzl","price":200};
        var book2 ={"id":1234,"bookname":"xzl1111","price":2002};
        counts.push(1);
        counts.push(2);
        books.push(book1);
        books.push(book2);

        $.post(
            'order/bookOrder',
            {'books[]':books,"count[]":counts},
            function (data) {
                alert(data);
            },
            'json'
        );
    });

</script>


<script>
    $("#delete").click(function () {
       var ids =[];
       ids.push(1);
       ids.push(2);
       $.post(
           'book/delete/batch',
           {'ids[]':ids},
           function (data) {
               alert(data);
           },
           'json'
       );
    });

</script>

</html>
