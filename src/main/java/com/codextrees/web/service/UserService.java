package com.codextrees.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.codextrees.web.models.Provider;
import com.codextrees.web.models.Role;
import com.codextrees.web.models.RoleType;
import com.codextrees.web.models.User;
import com.codextrees.web.repository.RoleRepository;
import com.codextrees.web.repository.UserRepository;


@Component
@Service

public class UserService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepo;
    
    public void processOAuthPostLogin(String username) {
    	User existUser = userRepository.getUserByUsername(username);
    	if (existUser == null) {
    		userRepository.save(getNewUser(username));
    	}
    }
    
    
    public User getNewUser(String username) {        	
        	Role roleUser = roleRepo.findByName(RoleType.USER);
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(false);	
            newUser.addRole(roleUser);
            return newUser;
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