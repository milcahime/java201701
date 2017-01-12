<%@ page contentType="text/html; charset=utf-8" import="java.sql.*" %>

<html>
<head>
<title>メンバー表示</title>
<style>
table{
	border-collapse:collapse;
}
td{
	border:solid 2px #666666;
	padding:5px;
}

</style>
</head>

<body>
<a href="input.jsp">メンバー登録</a>
<a href="delete.jsp">メンバー全削除</a>
<a href="select.jsp">メンバー表示</a>

<h1>メンバー表示</h1>

<table>
<tr>
<td>名前</td><td>性別</td><td>出身地</td><td>ひとこと</td>
</tr>

<%
    Class.forName("com.mysql.jdbc.Driver");

	Connection db=DriverManager.getConnection("jdbc:mysql://localhost/java?" +
        "user=root&useUnicode=true&characterEncoding=utf-8");
    Statement st=db.createStatement();
    //↓抽出したい内容を、セレクト文で書く
    
    ResultSet res = st.executeQuery("SELECT * FROM member");
    
	while(res.next()){
        out.println("<tr>");
        out.println("<td>" + res.getString("name") + "</td>");
        out.println("<td>" + res.getString("gender") + "</td>");
        out.println("<td>" + res.getString("birthplace") + "</td>");
        out.println("<td>" + res.getString("memo") + "</td>");
    }
    st.close();
    db.close();
    
%>
</table>

</body>
</html>