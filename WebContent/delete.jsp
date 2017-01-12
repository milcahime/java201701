<%@ page contentType="text/html; charset=utf-8" import="java.sql.*" %>

<html>
<head>
<title>メンバー全削除</title>
</head>

<body>
<a href="input.jsp">メンバー登録</a>
<a href="delete.jsp">メンバー全削除</a>
<a href="select.jsp">メンバー表示</a>

<h1>メンバー削除</h1>

<%
    Class.forName("com.mysql.jdbc.Driver");

	Connection db=DriverManager.getConnection("jdbc:mysql://localhost/java?" +
        "user=root&useUnicode=true&characterEncoding=utf-8");
    Statement st=db.createStatement();
    
	//実行したいSQL文を生成
	
	String sql = "DELETE FROM member ";

	//SQL文を実行
	st.execute(sql);
	
    st.close();
    db.close();
    
%>
<p>DELETE文を実行しメンバーを全削除しました</p>

</body>
</html>