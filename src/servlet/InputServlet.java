package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>メンバー登録</title>");
		out.println("</head>");
		out.println("<a href=\"/input_member/InputServlet\">メンバー登録</a>");
		out.println("<a href=\"/input_member/DeleteServlet\">メンバー全削除</a>");
		out.println("<a href=\"/input_member/SelectServlet\">メンバー表示</a>");
		out.println("	<h1>メンバー登録</h1>");
		out.println("	<body>");
		out.println("	<form action=\"/input_member/InsertServlet\"  method=\"post\">");
		out.println("名前：<input type=\"text\" name=\"name\"><br>");
		out.println("性別：男<input type=\"radio\" name=\"gender\" value=\"0\">女<input type=\"radio\" name=\"gender\" value=\"1\"><br>");
		out.println("出身：<input type=\"text\" name=\"birthplace\"><br>");
		out.println("ひとこと：<input type=\"text\" name=\"memo\" ><br>");
		out.println("<input type=\"submit\"value=\"登録\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>	");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
