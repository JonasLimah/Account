package model.entities;

import model.exception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;
    public Account(){

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void deposit(Double value){
        balance+=value;
    }
    public void withdraw(Double value) throws DomainException{
        if (value > getWithdrawLimit()){
            throw new DomainException("the amount exceeds withdraw limit ");
        } else if (value > getBalance()) {
            throw new DomainException("the amount exceeds the balance ");
        }else if (value < 0) {
            throw new DomainException("please review the amount");
        }
        balance-=value;
    }
}
