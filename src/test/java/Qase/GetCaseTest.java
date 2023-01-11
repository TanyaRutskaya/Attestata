package Qase;
import com.google.gson.internal.LinkedTreeMap;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class GetCaseTest {
    private double planId ;
    private List cases=null;
    private HashMap result =null;
    private double caseId;
    public static final String statusFAILED = "failed";
    public static final String statusPASSED = "passed";

//@BeforeTest
//    public void getTestPlanId() {
//    ResponseBody body = given().queryParam(QaseAPIRequests.getTestPlan())
//            .header("Token", "ba21bc5ee42c3d7fa07dc8b7f73d54769c79afd2")
//            .get(QaseAPIRequests.getTestPlan())
//            .body();
//    result = body.jsonPath().getObject("result", HashMap.class);
//    planId = (double) result.get("id");
//    cases = (List)result.get("cases");
//    for (Object element:cases){
//        LinkedTreeMap element2=(LinkedTreeMap) element;
//        caseId = (double)element2.get("case_id");
//        System.out.println(caseId);
//    }

//}
//@Test
//    public void CreateTestRun(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("title", "Test1TRU");
//        map.put("plan_id", planId);
//        ResponseBody responseBody=
//                given().baseUri(QaseAPIRequests.createNewTestRun())
//                        .accept(ContentType.JSON).
//                        contentType(ContentType.JSON).
//                        header("Token", "ba21bc5ee42c3d7fa07dc8b7f73d54769c79afd2").
//                        body(map).
//                        when().
//                        post().
//                        thenReturn().body();
//
//       System.out.println(responseBody.asPrettyString());
//    }

//    public void getCaseIdFromTestRun(){
//
//    }
    @Test
    public void failedTestRunRecord(){
       // Map<String, Object> map = new HashMap<>();
       // map.put("title", "Test1TRU");
       // map.put("plan_id", planId);
        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "ba21bc5ee42c3d7fa07dc8b7f73d54769c79afd2").
                        body("{\"case_id\":80,\"status\":\"failed\"}").
                        when().
                        post().
                        thenReturn().body();

        System.out.println(responseBody.asPrettyString());
    }
    public void passedTestRunRecord(){
        // Map<String, Object> map = new HashMap<>();
        // map.put("title", "Test1TRU");
        // map.put("plan_id", planId);
        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "ba21bc5ee42c3d7fa07dc8b7f73d54769c79afd2").
                        body("{\"case_id\":80,\"status\":\"failed\"}").
                        when().
                        post().
                        thenReturn().body();

        System.out.println(responseBody.asPrettyString());
    }

}
