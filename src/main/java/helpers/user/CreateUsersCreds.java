//package helpers.user;
//
//import com.github.javafaker.Faker;
//import helpers.constants.ConstantsURL;
//import helpers.owner.api.ApiConfig;
//import helpers.owner.api.ApiProvider;
//
//public class CreateUsersCreds {
//
//    private ApiConfig apiConfig;
//    private ApiProvider apiProvider = new ApiProvider(apiConfig);
//    private User user;
//
//    // Import Faker class for random user generating
//    static Faker faker = new Faker();
//
//    //DEV users
//    public static User getUserWithValidCredentialsInDEV() {
//        return new User("iva.sidorenko@axamit.ca", "Password123");
//    }
//
//    public static User getUserWithNotValidLoginInDEV() {
//        return new User("iva.sidorenko@axamit.caa", "Password123");
//    }
//
//    public static User getUserWithNotValidPasswordInDEV() {
//        return new User("iva.sidorenko@axamit.ca", "WRONGPASS!@#");
//    }
//
//    public static User getUserWithNotValidLoginAndPasswordInDEV() {
//        return new User("iva.sidorenko@axamit.caa", "WRONGPASS!@#");
//    }
//
//    public static User getUserWithEmptyLoginInDEV() {
//        return new User(null, "Password123");
//    }
//
//    public static User getUserWithEmptyPasswordInDEV() {
//        return new User("iva.sidorenko@axamit.ca", null);
//    }
//
//    public static User getUserWithEmptyLoginAndPasswordInDEV() {
//        return new User(null, null);
//    }
//
//    public static User getRandomUserInDEV() {
//        return new User(faker.internet().emailAddress(), faker.internet().password());
//    }
//
//    //QA users
//    public static User getUserWithValidCredentialsInQA() {
//        return new User("info@parscanada.com", "Password123");
//    }
//
//    public static User getUserWithNotValidLoginInQA() {
//        return new User("info@parscanadaa.com", "Password123");
//    }
//
//    public static User getUserWithNotValidPasswordInQA() {
//        return new User("info@parscanada.com", "Password1233");
//    }
//    public static User getUserWithNotValidLoginAndPasswordInQA() {
//        return new User("info@parscanadaa.com", "Password1233");
//    }
//
//    public static User getUserWithEmptyLoginInQA() {
//        return new User(null, "Password123");
//    }
//
//    public static User getUserWithEmptyPasswordInQA() {
//        return new User("iva.sidorenko@axamit.ca", null);
//    }
//
//    public static User getUserWithEmptyLoginAndPasswordInQA() {
//        return new User(null, null);
//    }
//
//    public static User getRandomUserInQA() {
//        return new User(faker.internet().emailAddress(), faker.internet().password());
//    }
//
//    // PROD users
//    public static User getUserWithValidCredentialsInPROD() {
//        return new User("sidorenko.evan@yandex.ru", "Password123");
//    }
//
//    public static User getUserWithNotValidLoginInPROD() {
//        return new User("sidorenko.evan@yandexx.ru", "Password123");
//    }
//
//    public static User getUserWithNotValidPasswordInPROD() {
//        return new User("sidorenko.evan@yandex.ru", "Password1234");
//    }
//    public static User getUserWithNotValidLoginAndPasswordInPROD() {
//        return new User("sidorenko.evan@yandex.rue", "Password1234");
//    }
//
//    public static User getUserWithEmptyLoginInPROD() {
//        return new User(null, "Password123");
//    }
//
//    public static User getUserWithEmptyPasswordInPROD() {
//        return new User("sidorenko.evan@yandexx.ru", null);
//    }
//
//    public static User getUserWithEmptyLoginAndPasswordInPROD() {
//        return new User(null, null);
//    }
//
//    public static User getRandomUserInPROD() {
//        return new User(faker.internet().emailAddress(), faker.internet().password());
//    }
//
//    public User getValidUser() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithValidCredentialsInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithValidCredentialsInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithValidCredentialsInQA();
//        }
//        throw new RuntimeException("No such environment");
//    }
//
//    public User getUserWithNotValidLogin() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidLoginInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidLoginInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidLoginInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//    public User getUserWithNotValidPassword() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidPasswordInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidPasswordInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidPasswordInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//    public User getUserWithNotValidLoginAndPassword() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidLoginAndPasswordInPROD() ;
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidLoginAndPasswordInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithNotValidLoginAndPasswordInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//    public User getUserWithEmptyLogin() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyLoginInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyLoginInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyLoginInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//    public User getUserWithEmptyPassword() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyPasswordInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyPasswordInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyPasswordInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//    public User getUserWithEmptyLoginAndPassword() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyLoginAndPasswordInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyLoginAndPasswordInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getUserWithEmptyLoginAndPasswordInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//    public User getRandomUser() {
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_PROD_URL)) {
//            return user = CreateUsersCreds.getRandomUserInPROD();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_DEV_URL)) {
//            return user = CreateUsersCreds.getRandomUserInDEV();
//        }
//        if (apiProvider.getBaseURL().contains(ConstantsURL.CONTAINS_QA_URL)) {
//            return user = CreateUsersCreds.getRandomUserInQA();
//        }
//        throw new RuntimeException("No such environment");
//
//    }
//
//}
