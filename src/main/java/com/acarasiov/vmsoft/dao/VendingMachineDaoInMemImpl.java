package com.acarasiov.vmsoft.dao;

import com.acarasiov.vmsoft.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoInMemImpl implements VendingMachineDao {
    List<Item> items ;

    public VendingMachineDaoInMemImpl() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Item item = mapper.readValue(new File("D:\\projects\\Test\\src\\input.json"), Item.class);
        items = item.getItems();

    }

    @Override
    public void vendItem(Item item) {
        int inventoryChange = item.getAmount();
        inventoryChange--;
        item.setAmount(inventoryChange);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    @Override
    public Item getItemById(int itemId) {
        if(itemId<=0){
            return null;
        }
        itemId--;
        return items.get(itemId);
    }
}
