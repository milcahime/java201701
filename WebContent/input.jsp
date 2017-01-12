<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー登録</title>
</head>
<a href="input.jsp">メンバー登録</a>
<a href="delete.jsp">メンバー全削除</a>
<a href="select.jsp">メンバー表示</a>
<h1>メンバー登録</h1>
<body>
<form action="insert.jsp"  method="post">
名前：<input type="text" name="name"><br>
性別：男<input type="radio" name="gender" value="0">女<input type="radio" name="gender" value="1"><br>
出身：<input type="text" name="birthplace"><br>
ひとこと：<input type="text" name="memo" ><br>
<input type="submit"value="登録">
</form>
</body>
</html>