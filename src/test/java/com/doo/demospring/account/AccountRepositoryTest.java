package com.doo.demospring.account;

import com.doo.demospring.util.HibernateUtility;
import com.doo.demospring.util.MyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void crud(){
        Account account = new Account();
        account.setUsername("sanghwa");
        account.setPassword("pass");

//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);


        Session session = HibernateUtility.getSessionFactory()
                .withOptions()
                .interceptor(new MyInterceptor())
                .openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Save Account");
        // saving an Object
//        session.save(account);
        session.persist(account);
        tx.commit();

//        Session session = entityManager.unwrap(Session.class);
//        session.getSessionFactory().withOptions()
//                .interceptor(new MyInterceptor())
//                .openSession();
//        session.save(account);

        TypedQuery<Account> query = entityManager.createQuery("SELECT p FROM Account AS p", Account.class);
        List<Account> accounts = query.getResultList();
        accounts.forEach(System.out::println);
        assertThat(accounts.size()).isEqualTo(1);


    }

    @Test
    public void crud2(){
        Account account = new Account();
        account.setUsername("lee");
        account.setPassword("pass");

        accountRepository.save(account);

        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts.size()).isEqualTo(1);

    }

}