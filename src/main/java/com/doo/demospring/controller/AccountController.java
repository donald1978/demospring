package com.doo.demospring.controller;

import com.doo.demospring.account.Account;
import com.doo.demospring.account.AccountRepository;
import com.doo.demospring.util.MyInterceptor;
import com.vladmihalcea.hibernate.query.SQLExtractor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EntityManager entityManager;

    @PostMapping("/account")
    public String setAccount(){
        Account account = new Account();
        account.setUsername("leesanghwa");
        account.setPassword("pass");


        Session session = entityManager.unwrap(Session.class).getSessionFactory()
                .withOptions()
                .interceptor(new MyInterceptor())
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        account.setUsername("sky");
        transaction.commit();
        session.close();



        return "OK";
    }
}
