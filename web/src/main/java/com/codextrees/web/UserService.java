package com.codextrees.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
    
    public void processOAuthPostLogin(String username) {
        User existUser = userRepository.getUserByUsername(username);
        
        if (existUser == null) {

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(false);  
            newUser.setRole(Role.USER);	
            userRepository.save(newUser);        
        }
         
    }
    
    public void enableMailNotification(String username) {
    	User user = userRepository.getUserByUsername(username);
    	userRepository.changeMailNotification(true,user.getId());
    }
    public void disableMailNotification(String username) {
    	User user = userRepository.getUserByUsername(username);
    	userRepository.changeMailNotification(false,user.getId());
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
 
}