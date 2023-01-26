package com.doo.demospring.util;

import com.doo.demospring.account.Account;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class MyInterceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("=== sql ============================================================");
        System.out.println(sql);
        return super.onPrepareStatement(sql);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("======= onSave =============================================");

        return super.onSave(entity, id, state, propertyNames, types);
    }


    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("==== onLoad =====================================");
        return super.onLoad(entity, id, state, propertyNames, types);
    }
}
