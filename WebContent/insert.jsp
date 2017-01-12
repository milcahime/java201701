<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html">

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String birthplace = request.getParameter("birthplace");
	String memo = request.getParameter("memo");
	
	System.out.println(name);
	System.out.println(gender);
	System.out.println(birthplace);
	System.out.println(memo);
	
	String errorMsg="";
	if(name==null||name.length()==0){
		errorMsg += "名前が入力されていません<br>";
	}
	if(gender==null||gender.length()==0){
		errorMsg +="性別が選択されていません<br>";
	}else{
		if(gender.equals("0")){gender="男性";}
		else if(gender.equals("1")){gender="女性";}
	}
	if(birthplace==null||birthplace.length()==0){
		errorMsg += "出身地が入力されていません<br>";
	}
	if(memo==null||memo.length()==0){
		errorMsg += "ひとことが入力されていません<br>";
	}
	
	if(errorMsg==null||errorMsg.length()==0){
	
    	Class.forName("com.mysql.jdbc.Driver");

		Connection db=DriverManager.getConnection("jdbc:mysql://localhost/java?" +
    	    "user=root&useUnicode=true&characterEncoding=utf-8");
    	Statement st=db.createStatement();

	    String sql = "INSERT INTO member(name,gender,birthplace,memo) VALUES(\""+name+"\",\""+gender+"\",\""+birthplace+"\",\""+memo+"\")";
   		//SQL文を実行
		st.execute(sql);
    
    	st.close();
    	db.close();
	}
	
	String msg = name + "さん("+gender +")を登録しました";
	if(errorMsg.length()!=0){
		msg = errorMsg;
	}
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メンバー登録結果</title>
</head>
<body>
<a href="input.jsp">メンバー登録</a>
<a href="delete.jsp">メンバー全削除</a>
<a href="select.jsp">メンバー表示</a>
<h1>メンバー登録結果</h1>
<p>
<%=msg %>
</p>
</body>
</html>