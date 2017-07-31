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

public class Tp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tp2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("servletTurnJsp.jsp").forward(request, response);
		String name1 =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		String age1 =new String(request.getParameter("url").getBytes("ISO8859-1"),"UTF-8");
		
		
try {
			
	    	Connection con = null; //定义一个MYSQL链接对象
	        Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root"); //链接本地MYSQL 
	    	Statement stmt; //创建声明
	        stmt = con.createStatement();
	       
	         
	        //插入
	        stmt.executeUpdate("INSERT INTO testform (name, age) VALUES ('" + name1 + "','" + age1 + "')");
            ResultSet res = stmt.executeQuery("select LAST_INSERT_ID()");
            int ret_id;
            if (res.next()) {
                ret_id = res.getInt(1);
                System.out.print(ret_id);
            }
            System.out.println("yes6");
            //删除
            String sql = "DELETE FROM testform WHERE age = 12";
            long deleteRes = stmt.executeUpdate(sql); //如果为0则没有进行删除操作，如果大于0，则记录删除的条数
            System.out.print("DELETE:" + deleteRes);
           
            //查询
            String selectSql = "SELECT * FROM testform";
            ResultSet selectRes = stmt.executeQuery(selectSql);
            while (selectRes.next()) { //循环输出结果集
              String username = selectRes.getString("name");
              String password = selectRes.getString("age");
              System.out.print("\r\n\r\n");
              System.out.print("名字:" + username + "，年龄:" + password);
          }
	    } catch (Exception e) {
	        System.out.print("MYSQL ERROR:" + e.getMessage());
	    }
		
	}
	
	// 处理 POST 方法请求的方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	
	
}
}