
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author tien
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("Admin@123");
        
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
        System.out.println(encodedPassword); 
    }
    
}
