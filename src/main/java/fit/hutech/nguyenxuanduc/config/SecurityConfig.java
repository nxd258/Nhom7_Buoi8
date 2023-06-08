package fit.hutech.nguyenxuanduc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Autowired
private CustomUserDetailsService uds;
@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}
@Bean
public AuthenticationProvider authenticationProvider() {
DaoAuthenticationProvider authenticationProvider = new
DaoAuthenticationProvider();
authenticationProvider.setUserDetailsService(uds);
authenticationProvider.setPasswordEncoder(passwordEncoder());
return authenticationProvider;
}
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http
.authorizeRequests(authorize -> authorize
.requestMatchers("/home/**", "/login/**", "/logout/**").permitAll()
.requestMatchers("/products/**").hasAnyAuthority("USER", "SALES")
.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
.anyRequest().authenticated()
)
.formLogin(withDefaults())
.httpBasic(withDefaults())
.authenticationProvider(authenticationProvider());
return http.build();
}
}