package Bai1;

 public class User {
     private  String userName;
     private String role;
     private String email;

     public User(String userName, String role, String email) {
         this.userName = userName;
         this.role = role;
         this.email = email;
     }

     public String getUserName() {
         return userName;
     }

     public String getRole() {
         return role;
     }

     public String getEmail() {
         return email;
     }

     @Override
     public String toString() {
         return "User{username='" + userName + "', role='" + role + "', email='" + email + "'}";
     }
 }
