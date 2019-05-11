package com.acme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@Named
@ApplicationScoped
public class AccountService implements Serializable {

    private static final long serialVersionUID = 8832256367977986070L;
    private Map<Long, Account> accounts;

    @PostConstruct
    public void init() {
        accounts = new HashMap<Long, Account>();

        Account account = new Account(new Long(10224), "Madonna", new Date(),
                0.00);
        accounts.put(account.getId(), account);

        account = new Account(new Long(20570), "Janet Jackson", new Date(),
                -202757.14);
        accounts.put(account.getId(), account);

        account = new Account(new Long(24105), "Adelle", new Date(), 1314.44);
        accounts.put(account.getId(), account);

        account = new Account(new Long(11484), "Lady Gaga", new Date(), 2312.44);
        accounts.put(account.getId(), account);

        account = new Account(new Long(24133), "Christina Agulera", new Date(),
                53312.44);
        accounts.put(account.getId(), account);
        account = new Account(new Long(241331), "Adelle2", new Date(),
                53312.44);
        accounts.put(account.getId(), account);
    }

    public List<Account> getAccounts() {
        return new ArrayList<Account>(accounts.values());
    }

    public void delete(Account account) {
        accounts.remove(account.getId());
    }

    public void update(Account account) {
        accounts.put(account.getId(), account);
    }
}