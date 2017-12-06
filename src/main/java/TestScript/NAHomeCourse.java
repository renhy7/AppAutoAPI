package TestScript;

import java.util.Arrays;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunction.Common;
import CommonFunction.SuperTestClass;
import Logger.Dailylog;
import TestData.CommonData;
import TestData.HomeCourseData;

public class NAHomeCourse extends SuperTestClass {
	
	
	@Test
	public void NAHomeCourseTest(){
		
			String response = Common.sendPost(HomeCourseData.getUrl() , "id="+CommonData.getUserId(userMobile)+"&x="+HomeCourseData.getLongitude()+"&y="+HomeCourseData.getLatitude());
			JSONObject jsonResponse = JSONObject.fromObject(response);
			Dailylog.logInfo("NAHomeCourse case response data:"+response);
			
			JSONArray responseCommon =  jsonResponse.getJSONArray("common");
			String commonId[] = new String[responseCommon.size()];
		    for(int i = 0; i< responseCommon.size();i++){
		    	String str = responseCommon.getString(i);
		    	JSONObject obj = JSONObject.fromObject(str);
		    	Dailylog.logInfo("NAHomeCourse case commonId:"+obj.get("id"));
		    	commonId[i] = obj.get("id").toString();
		    }				
			JSONArray responseRecomme = jsonResponse.getJSONArray("recomme");
			String recommeId[] = new String[responseRecomme.size()];
			for(int i = 0; i < responseRecomme.size(); i++){
				String str = responseRecomme.getString(i);
				JSONObject obj = JSONObject.fromObject(str);
				Dailylog.logInfo("NAHomeCourse case recommeId:"+obj.getString("id"));
				recommeId[i] = obj.getString("id").toString();
			}
			for(int i = 0 ; i< commonId.length; i++){
				Dailylog.logInfo("commonId:"+commonId[i]);
			}
			for(int j = 0; j< recommeId.length;j++){
				Dailylog.logInfo("recommeId:"+recommeId[j]);
			}
			Arrays.sort(commonId);
			Arrays.sort(recommeId);
			System.out.println(Arrays.equals(commonId, recommeId));
			Assert.assertTrue(Arrays.equals(commonId, recommeId), "commonId != recommeId");
			
	}

}
