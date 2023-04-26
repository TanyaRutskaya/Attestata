package helpers.owner.api;


import org.aeonbits.owner.ConfigFactory;


public class ApiProvider {
    private ApiConfig apiConfig;

    public ApiProvider(ApiConfig apiConfig) {
        this.apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
    }

    public String getBaseURL() {
        String baseURL = apiConfig.getBaseURL();
        return baseURL;
    }


}
