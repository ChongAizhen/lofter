package science.jiangqi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Chong AiZhen on 18-2-3,下午7:03.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/oauth/logout").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .logout().clearAuthentication(true).invalidateHttpSession(true).logoutUrl("/oauth/logout").logoutSuccessUrl("/oauth/login")
                .and()
                .formLogin().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(userDetailsService());
    }

    // 将 AuthenticationManager 注册为 bean , 方便配置 oauth server 的时候使用
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // 将 UserDetailService 注册为 bean , 方便配置 oauth server 的时候使用
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

}
