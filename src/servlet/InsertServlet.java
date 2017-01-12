package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthplace = request.getParameter("birthplace");
		String memo = request.getParameter("memo");
		

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

			String sql = "INSERT INTO member(name,gender,birthplace,memo) VALUES(\""+name+"\",\""+gender+"\",\""+birthplace+"\",\""+memo+"\")";
	   		//SQL文を実行
			try {
				st.execute(sql);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	    
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			try {
				db.close();
			} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		String msg = name + "さん("+gender +")を登録しました";
		if(errorMsg.length()!=0){
			msg = errorMsg;
		}
		

		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>メンバー登録結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href=\"/input_member/InputServlet\">メンバー登録</a>");
		out.println("<a href=\"/input_member/DeleteServlet\">メンバー全削除</a>");
		out.println("<a href=\"/input_member/SelectServlet\">メンバー表示</a>");

		out.println("<h1>メンバー登録結果</h1>");
		out.println("<p>");
		out.println(msg);
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
