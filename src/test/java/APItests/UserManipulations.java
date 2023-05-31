package APItests;

public final class UserManipulations {

         public String name;
         public String pass="Password123";

         public UserManipulations(String name){
             this.name = name;
         }
         public UserManipulations(String name, String password) {this.name= name; this.pass=password;}

// DEV users:
    public static UserManipulations devUserWithoutSubscription() {
        return new UserManipulations("natacha_beaudoin@icloud.com");
   }

    public static UserManipulations devUserWithSubscrition() {
        return new UserManipulations("tbeliveau@munsar.ca");
    }

    public static UserManipulations devUserWithExpiredLicence(){
             return new UserManipulations("");
         }
    public static UserManipulations devUserWithoutLicence(){
        return new UserManipulations("");
    }

    // QA users:
    public static UserManipulations qaUserWithoutSubscribtion() {
        return new UserManipulations("natacha_beaudoin@icloud.com");
    }

    public static UserManipulations qaUserWithSubscribtion() {
        return new UserManipulations("tatyana.bunimovich@tc.tc");
    }

    public static UserManipulations qaUserWithExpiredLicence(){
        return new UserManipulations("antonellabattaglia@sympatico.ca");
    }
    public static UserManipulations qaUserWithoutLicence(){

             return new UserManipulations("khensousleila9@gmail.com");
    }

    //Admin User:
    public static UserManipulations AdminUser(){
             return new UserManipulations("info@orsign.com", "jSBORM7DM4q!");
    }
 }

