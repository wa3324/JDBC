import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class MySQLDemo {
	public static void main(String[] args) {
		Connection conn = null;
		String sql;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建student数据库
		String url = "jdbc:mysql://localhost:3306/myschool";
		String user = "root";
		String password = "wa3324";
		// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
        // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
		try {
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// or:
        // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        // or：
        // new com.mysql.jdbc.Driver();
		System.out.println("成功加载MySQL驱动程序");
		try {
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url,user,password);
			 // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			sql = "select studentno,studentname,gradeid from student where gradeid=2";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("学号\t姓名\t年级");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
