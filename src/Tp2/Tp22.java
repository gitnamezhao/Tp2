package Tp2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */

public class Tp22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tp22() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("DeleteData.jsp").forward(request, response);
		String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		System.out.println("ok1");
		
try {
			
	    	Connection con = null; //����һ��MYSQL���Ӷ���
	    	System.out.println("ok2");
	        Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL����
	        System.out.println("ok3");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root"); //���ӱ���MYSQL
	        System.out.println("ok4");
	    	Statement stmt; //��������
	        stmt = con.createStatement();
	       
	        
            //ɾ��
            String sql = "DELETE FROM testform WHERE name = '" + name + "'";
            long deleteRes = stmt.executeUpdate(sql); //���Ϊ0��û�н���ɾ���������������0�����¼ɾ��������
            System.out.print("DELETE:" + deleteRes);
           
            String selectSql = "SELECT * FROM testform";
            ResultSet selectRes = stmt.executeQuery(selectSql);
            while (selectRes.next()) { //ѭ����������
              String username = selectRes.getString("name");
              String password = selectRes.getString("age");
              System.out.print("\r\n\r\n");
              System.out.print("����:" + username + "������:" + password);
          }
	    } catch (Exception e) {
	        System.out.print("MYSQL ERROR:" + e.getMessage());
	    }
	   
	}
	
	// ���� POST ��������ķ���
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	
	
}
}