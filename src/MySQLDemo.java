import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class MySQLDemo {
	public static void main(String[] args) {
		Connection conn = null;
		String sql;
		// MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
        // ������������Ҫָ��useUnicode��characterEncoding
        // ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
        // �������֮ǰ��Ҫ�ȴ���student���ݿ�
		String url = "jdbc:mysql://localhost:3306/myschool";
		String user = "root";
		String password = "wa3324";
		// ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
        // ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
		try {
			Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// or:
        // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        // or��
        // new com.mysql.jdbc.Driver();
		System.out.println("�ɹ�����MySQL��������");
		try {
			// һ��Connection����һ�����ݿ�����
			conn = DriverManager.getConnection(url,user,password);
			 // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
			Statement stmt = conn.createStatement();
			sql = "select studentno,studentname,gradeid from student where gradeid=2";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("ѧ��\t����\t�꼶");
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
