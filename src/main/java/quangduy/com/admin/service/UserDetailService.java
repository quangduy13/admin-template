package quangduy.com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quangduy.com.admin.dao.IUserInfoDao;
import quangduy.com.admin.entity.UserInfo;

import java.util.Arrays;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUserInfoDao userInfoDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoDao.getActiveUser(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        UserDetails userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(authority));


        return userDetails;
    }
}
