package Qase;
import com.google.gson.internal.LinkedTreeMap;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class GetCaseTest {
    private int planId ;
    private List cases=null;
    private HashMap result =null;
    private double caseId;

    @BeforeTest
    public void getTestPlanId() {
    ResponseBody body = given().queryParam(QaseAPIRequests.getTestPlan())
            .header("Token", "498fb3fd1772c5aa4d580efd256c02abf89bf9c9b3d10546bcbb0b5b29a3b197")
            .get(QaseAPIRequests.getTestPlan())
            .body();
    result = body.jsonPath().getObject("result", HashMap.class);
    planId = (int) result.get("id");
    cases = (List)result.get("cases");
    for (Object element:cases){
        HashMap element2=(HashMap) element;
        caseId = (int)element2.get("case_id");
        System.out.println(caseId);

        for (int i=0; i<caseId; i++){

        }

    }
}
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
//        for (int i=0; i < createTestRun().size; i++) {
//            run the cases one by one;
//            }
//    }


}
