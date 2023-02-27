package APItests;

public final class UserManipulations {

         String name;
         String pass="Password123";

         public UserManipulations(String name){
             this.name = name;
         }


    public static UserManipulations devUserWithoutSubscription() {
        return new UserManipulations("natacha_beaudoin@icloud.com");
   }

    public static UserManipulations devUserWithSubscrition() {
        return new UserManipulations("tbeliveau@munsar.ca");
    }

    public static UserManipulations qaUserWithoutSubscribtion() {
        return new UserManipulations("natacha_beaudoin@icloud.com");
    }

    public static UserManipulations qaUserWithSubscribtion() {
        return new UserManipulations("tatyana.bunimovich@tc.tc");
    }

 }

