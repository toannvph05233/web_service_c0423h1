package com.web_service_c0423h1.controller;

import com.web_service_c0423h1.model.Account;
import com.web_service_c0423h1.service.AccountService;
import com.web_service_c0423h1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return new ResponseEntity<>(accountService.save(account), HttpStatus.NOT_FOUND);
    }
}
