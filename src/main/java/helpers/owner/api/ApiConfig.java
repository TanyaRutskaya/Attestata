package helpers.owner.api;


import org.aeonbits.owner.Config;


public interface ApiConfig extends Config {

    @Key("baseURL")
    @DefaultValue("https://attestata.axamit.com")
    String getBaseURL();


}
