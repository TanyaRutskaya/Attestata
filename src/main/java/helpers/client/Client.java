//package helpers.client;
//
//import helpers.owner.api.ApiConfig;
//import helpers.owner.api.ApiProvider;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//
//public class Client {
//    public static String getDevUrl() {
//        return "https://attestata.axamit.com";
//    }
//
//    public static String getQaUrl() {
//        return "https://qa-attestata.axamit.com";
//    }
//
//
//    public static String profileMeetingCalendar() {
//        return "/api/profile/calendar";
//    }
//
//    public static String userProfile() {
//        return "/api/profile";
//    }
//
//    private ApiConfig apiConfig;
//    private ApiProvider apiProvider = new ApiProvider(apiConfig);
//
//    protected io.restassured.specification.RequestSpecification getSpec() {
//        return new RequestSpecBuilder()
//                .setContentType(ContentType.JSON)
//                .setBaseUri(apiProvider.getBaseURL())
//                .build();
//    }
//
//}
