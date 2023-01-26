package com.doo.demospring.account;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class AccountLogger {
    @PrePersist
    public void preLogAddition(Object pc){
        System.out.println("=============  preLogAddition  ====================");
        String username = ((Account) pc).getUsername();
        System.out.println( username);
    }

    @PostPersist
    public void postLogAddition(Object pc){
        System.out.println("=============  postLogAddition  ====================");
        String username = ((Account) pc).getUsername();
        System.out.println( username);
    }
}
