package TestScript;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import TestData.HomeCourseData;
import CommonFunction.Common;
import CommonFunction.SuperTestClass;

public class NAHomeCourse extends SuperTestClass {
	
	@Test
	public void NAHomeCourseTest(ITestContext ctx){
		try{
			System.out.println(Common.sendPost(HomeCourseData.getUrl() , "id="+userMobile+"&x="+HomeCourseData.getLongitude()+"&y="+HomeCourseData.getLatitude()));
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}

}
