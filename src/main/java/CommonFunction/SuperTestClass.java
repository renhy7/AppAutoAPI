package CommonFunction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class SuperTestClass {
	public String loginType;
	public String userMobile;
	
	@BeforeClass 
	@Parameters({"userMobile","loginType"})
	public void setup(String userMobile, String loginType){
		this.userMobile = userMobile;
		this.loginType = loginType;
	}		

}
