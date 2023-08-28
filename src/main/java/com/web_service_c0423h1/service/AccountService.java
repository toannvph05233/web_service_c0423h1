package com.web_service_c0423h1.service;

import com.web_service_c0423h1.model.Account;
import com.web_service_c0423h1.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;

    public List<Account> getAll(){
        return (List<Account>) iAccountRepo.findAll();
    }
    public List<Account> findAllByUsernameContaining(String username){
        return iAccountRepo.findAllByUsernameContaining(username);
    }

    public Account save(Account account){
        return iAccountRepo.save(account);
    }
    public void delete(int id){
         iAccountRepo.deleteById(id);
    }
    public Account findById(int id){
        return iAccountRepo.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(username,account.getPassword(),roles);
    }
}
