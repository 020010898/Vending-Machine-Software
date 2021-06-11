package com.acarasiov.vmsoft.service;

import com.acarasiov.vmsoft.dao.VendingMachineDao;
import com.acarasiov.vmsoft.dao.VendingMachineDaoInMemImpl;
import com.acarasiov.vmsoft.exception.NoItemException;
import com.acarasiov.vmsoft.exception.NoItemIdException;
import com.acarasiov.vmsoft.exception.NoMoneyException;
import com.acarasiov.vmsoft.model.Change;
import com.acarasiov.vmsoft.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    private BigDecimal balance;
    private int itemChoice;
    private Change change;
    private String textMessage;

//    public VendingMachineServiceImpl() throws IOException {
//        dao = new VendingMachineDaoInMemImpl();
//    }

    @Autowired
    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
        balance = new BigDecimal("0.00");
        itemChoice = 0;
        change = null;
        textMessage = null;
    }

    private void validateItemAmount(Item item) throws NoItemException {
        if (item.getAmount() == 0) {
            throw new NoItemException("SOLD OUT!");
        }
    }

    private void validateSufficientFunds(Item item, BigDecimal userMoneySelection) throws NoMoneyException {
        BigDecimal value = item.getItemPrice();
        if (value.compareTo(userMoneySelection) > 0) {
            BigDecimal whatTheyOwe = value.subtract(balance);
            throw new NoMoneyException("Please deposit : $" + whatTheyOwe);
        }
    }

    private void validateId(Item item) throws NoItemIdException {
        if (item == null || itemChoice == 0) {
            throw new NoItemIdException("No such item");
        }
    }

    @Override
    public void vendItem() {
        try {
            Item item = dao.getItemById(itemChoice);
            validateId(item);
            BigDecimal cost = item.getItemPrice();
            validateItemAmount(item);
            validateSufficientFunds(item, balance);
            BigDecimal changeReturned = balance.subtract(cost);
            Change daChangeReturned = new Change(changeReturned);
            change = daChangeReturned;
            balance = new BigDecimal("0.00");
            dao.vendItem(item);
            textMessage = "Thank You!";
        } catch (NoItemException | NoMoneyException | NoItemIdException ex) {
            textMessage = ex.getMessage();
        }
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public Item getItemById(int itemId) throws FileNotFoundException, NoItemException {
        validateItemAmount(dao.getItemById(itemId));
        return dao.getItemById(itemId);

    }

    @Override
    public void addMoney(String amount) {
        switch (amount) {
            case "dollar":
                balance = balance.add(new BigDecimal("1.00"));
                break;
            case "quarter":
                balance = balance.add(new BigDecimal("0.25"));
                break;
            case "dime":
                balance = balance.add(new BigDecimal("0.10"));
                break;
            case "nickel":
                balance = balance.add(new BigDecimal("0.05"));
                break;
            default:
        }
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void returnChange() {
        Change theirChange = new Change(balance);
        change = theirChange;
        balance = new BigDecimal("0.00");
        itemChoice = 0;
        textMessage = null;
    }

    @Override
    public String getTextMessage() {
        return textMessage;
    }

    @Override
    public Change getChange() {
        return change;
    }

    @Override
    public int getItemChoice() {
        return itemChoice;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public void setChange(Change change) {
        this.change = change;
    }

    @Override
    public void setItemChoice(int itemChoice) {
        this.itemChoice = itemChoice;
    }
}
