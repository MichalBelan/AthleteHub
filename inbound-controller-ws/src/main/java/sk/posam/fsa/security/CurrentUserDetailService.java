package sk.posam.fsa.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sk.posam.fsa.dto.UserDto;

@Service
public class CurrentUserDetailService {

//    public UserDto getCurrentUser() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDto user) {
//            return user;
//        }
//        throw new IllegalStateException("No valid user in context");
//    }
//
//    public String getUserEmail() {
//        return getCurrentUser().getEmail();
//    }

    public String getUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof String email) {
            return email;
        }
        throw new IllegalStateException("No valid email in context");
    }
}
