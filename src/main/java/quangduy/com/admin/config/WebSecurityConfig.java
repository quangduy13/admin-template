package quangduy.com.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import quangduy.com.admin.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailService userDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();

        //Login Form
        http.authorizeRequests()
                .and().formLogin()
                .loginPage("/login")//
                .loginProcessingUrl("/app-login") // Submit URL
                .usernameParameter("username")//
                .passwordParameter("password")
                .defaultSuccessUrl("/authorization")//
                .failureUrl("/login?error=true")//

                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);

    }


}
