package APItests;

public class EnvironmentPath {
    public static String dev() {
        return "https://attestata.axamit.com";
    }

    public static String devBilling() {
        return "https://attestata.axamit.com/fr/billing-and-invoices";
    }
    public static String qa() {
        return "https://qa-attestata.axamit.com";
    }

    public static String prod() {
        return "https://attestata.com";
    }
    public static String adminDev(){
        return "http://192.168.31.60:8091";
    }

    public static String adminQA(){
        return "http://192.168.31.63:8091";
    }
}
