package by.boiko.crm.service.impl;


import by.boiko.crm.model.Worker;
import by.boiko.crm.model.enums.WorkerRoles;
import by.boiko.crm.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private WorkerService workerService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Worker worker = workerService.findByLogin(login);
        HashSet<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(WorkerRoles.USER.name()));
        roles.add(new SimpleGrantedAuthority(WorkerRoles.ADMIN.name()));
        roles.add(new SimpleGrantedAuthority(WorkerRoles.ANONYMOUS.name()));
        return new org.springframework.security.core.userdetails.User(worker.getLogin(), worker.getPassword(), roles);
    }
}
