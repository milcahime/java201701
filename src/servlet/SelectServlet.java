package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>メンバー表示</title>");
		out.println("<style>");
		out.println("table{");
		out.println("	border-collapse:collapse;");
		out.println("}");
		out.println("td{");
		out.println("	border:solid 2px #666666;");
		out.println("	padding:5px;");
		out.println("}");

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");
		out.println("<a href=\"/input_member/InputServlet\">メンバー登録</a>");
		out.println("<a href=\"/input_member/DeleteServlet\">メンバー全削除</a>");
		out.println("<a href=\"/input_member/SelectServlet\">メンバー表示</a>");


		out.println("<h1>メンバー表示</h1>");

		out.println("<table>");
		out.println("<tr>");
		out.println("<td>名前</td><td>性別</td><td>出身地</td><td>ひとこと</td>");
		out.println("</tr>");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		Connection db = null;
		try {
			db = DriverManager.getConnection("jdbc:mysql://localhost/java?" +
			        "user=root&useUnicode=true&characterEncoding=utf-8");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = db.createStatement();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		    
		ResultSet res = null;
		try {
			res = st.executeQuery("SELECT * FROM member");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		    

			
		try {
			while(res.next()){
				out.println("<tr>");
			    out.println("<td>" + res.getString("name") + "</td>");
			    out.println("<td>" + res.getString("gender") + "</td>");
			    out.println("<td>" + res.getString("birthplace") + "</td>");
			    out.println("<td>" + res.getString("memo") + "</td>");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			db.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");
	
	}


}
