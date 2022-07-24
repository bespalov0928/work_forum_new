package ru.work.forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.work.forum.model.User;
import ru.work.forum.persistence.UserStore;

@Service("us erDetailsServiceImpl")
public class USerDetailsServiceImpl implements UserDetailsService {
    private final UserStore userStore;

    @Autowired
    public USerDetailsServiceImpl(UserStore userStore) {
        this.userStore = userStore;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userStore.findByUsername(username);
        if (user==null){
            return (UserDetails) new UsernameNotFoundException("User doesn`t exist");
        }
        return SecurityUser.fromUser(user);

    }
}
