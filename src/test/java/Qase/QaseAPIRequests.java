package Qase;

public class QaseAPIRequests {
    public static String getAllCases(){return "https://api.qase.io/v1/case/ATST";} //get
    public static String createNewTestRun(){return "https://api.qase.io/v1/run/ATST";} //post
    public static String getTestCase(){return " https://api.qase.io/v1/case/ATST/80";} //get
    public static String getTestPlan(){return "https://api.qase.io/v1/plan/ATST/4";}//get
    public static String recordResult(){return "https://api.qase.io/v1/result/ATST/31";}//post
}
