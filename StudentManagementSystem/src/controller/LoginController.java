package controller;

import java.sql.ResultSet;
import model.DBSearch;
import view.LoginView;
import view.mainview;


public class LoginController {
 
    public static void login(String usname,String psd){
        
        try {
            
            String username = null;
            String password = null;
            
            ResultSet rs = new DBSearch().searchLogin(usname);
            
            while (rs.next()){
            
                username = rs.getString("usname");
                password = rs.getString("password");
            }
            if(username !=null && password !=null){
            
            if(username.equals(usname) && password.equals(psd)){
            
            System.out.println("Login Succesfull");
            
            loginview.getFrames()[0].dispose();
            
            new mainview().setVisible(true);
           
            }
            
            }
        } catch (Exception e) {
        }
        
        
    }


}
