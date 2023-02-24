package APItests;

public class UserManipulations {

         String name;
         String pass;

         public UserManipulations(String name){
             this.name = name;
             this.pass = "Password123";
         }


    public static void devUserWithoutSubscription(String name) {
        UserManipulations devUserWithoutSubscription = new UserManipulations("natacha_beaudoin@icloud.com");
   }






    public void devUserWithSubscrition(){
       userName= "tbeliveau@munsar.ca";
        password ="Password123";
        return;

    }
    public void qaUserWithoutSubscribtion(){
        userName = "natacha_beaudoin@icloud.com";
        password ="Password123";
        return;
    }
    public void qaUserWithSubscribtion(){
        userName = "tatyana.bunimovich@tc.tc";
        password ="Password123";
        return;
    }}

