package TestData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CommonFunction.Common;

public class CommonData {
	public static  Connection connection = null;
	public static Common common = new Common();
	
	public static  String getUserId(String mobile){
		String userId = null;
		String sql = "SELECT id from passenger where mobile = "+mobile+";";
		connection = common.getMysqlConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while(res.next()){
				userId = res.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

}
