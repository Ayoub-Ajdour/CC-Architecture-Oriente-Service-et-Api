package ma.fpl.equipesecurity.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserDetailService implements UserDetailsService {
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String combinedUsername) throws UsernameNotFoundException {
    return null;
    }


}
