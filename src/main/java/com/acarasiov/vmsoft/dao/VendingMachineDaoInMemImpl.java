package com.acarasiov.vmsoft.dao;

import com.acarasiov.vmsoft.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    Map<Integer, Item> items;

    public VendingMachineDaoInMemImpl() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Item item = mapper.readValue(new File("D:\\projects\\input.json"), Item.class);
        items = new HashMap<>();
        for (int i = 0; i < item.getItems().size(); i++) {
            item.getItems().get(i).setItemId(i);
            items.put(item.getItems().get(i).getItemId(), item.getItems().get(i));
        }

    }

    @Override
    public void vendItem(Item item) {
        int inventoryChange = item.getAmount();
        inventoryChange--;
        item.setAmount(inventoryChange);
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItemById(int itemId) {
        return items.get(itemId);
    }
}
