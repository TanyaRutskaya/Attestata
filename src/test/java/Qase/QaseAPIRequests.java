package Qase;

public class QaseAPIRequests {
    public static String getAllCases(){return "https://api.qase.io/v1/case/ATST";} //get
    public static String createTestRunResult(){return "https://api.qase.io/v1/result/ATST/{id}";} //post
    public static String createNewTestRun(){return " https://api.qase.io/v1/run/ATST";} //post
    public static String getTestCase(){return " https://api.qase.io/v1/case/ATST/{id}";} //get

}
