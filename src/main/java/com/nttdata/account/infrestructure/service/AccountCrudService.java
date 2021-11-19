package com.nttdata.account.infrestructure.service;

import com.nttdata.account.domain.Account;
import com.nttdata.account.infrestructure.model.dao.AccountDao;
import com.nttdata.account.infrestructure.repository.AccountCrudRepository;
import com.nttdata.account.model.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class AccountCrudService implements AccountRepository {


    @Autowired
    private AccountCrudRepository accountCrudRepository;



    @Override
    public Flux<Account> findAll() {
        return accountCrudRepository.findAll().map(accountDao -> getAccount(accountDao));
    }

    @Override
    public Mono<Account> findById(Long id) {
        return accountCrudRepository.findById(id).map(accountDao -> getAccount(accountDao));
    }

    @Override
    public Mono<Account> save(Account account) {
        return accountCrudRepository.save(getAccountDao(account)).map(this::getAccount);
    }

    @Override
    public Mono<Account> update(Long id, Account account) {
        return accountCrudRepository.save(getAccountDao(account)).map(this::getAccount);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return accountCrudRepository.deleteById(id);
    }



    public Account getAccount(AccountDao accountDao){
        Account account = new Account();
        account.setId(accountDao.getId());
        account.setBalance(accountDao.getBalance());
        account.setCoin(accountDao.getCoin());
        account.setCustomer(accountDao.getCustomer());
        account.setTyperAccount(accountDao.getTyperAccount());
        account.setDate(LocalDateTime.now().toLocalDate());
        return account;
    }


    public AccountDao getAccountDao(Account account){
        AccountDao accountDao = new AccountDao();
        accountDao.setId(account.getId());
        accountDao.setBalance(account.getBalance());
        accountDao.setCoin(account.getCoin());
        accountDao.setCustomer(account.getCustomer());
        accountDao.setTyperAccount(account.getTyperAccount());
        accountDao.setDate(LocalDateTime.now().toLocalDate());
        return accountDao;
    }

}
