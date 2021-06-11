package com.acarasiov.vmsoft.dao;

import com.acarasiov.vmsoft.model.Item;

import java.util.List;

public interface VendingMachineDao {

    public void vendItem(Item item);

    public List<Item> getAllItems();

    public Item getItemById(int itemId);
}
