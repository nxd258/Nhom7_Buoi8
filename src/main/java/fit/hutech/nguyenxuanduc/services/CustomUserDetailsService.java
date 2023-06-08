package fit.hutech.nguyenxuanduc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements
UserDetailsService {
@Autowired
private UserRepository userRepository;
@Override
public UserDetails loadUserByUsername(String username)
throws UsernameNotFoundException
{
User u = userRepository.getUserByUsername(username);
if (u == null) {
throw new UsernameNotFoundException("Could not find
user");
}
Set<GrantedAuthority> authorities = u.getRoles().stream()
.map((role) -> new

SimpleGrantedAuthority(role.getName()))
.collect(Collectors.toSet());
return new
org.springframework.security.core.userdetails.User(

username,
u.getPassword(),
authorities
);
}
}