package com.poly.lab5.service;

import com.poly.lab5.entity.Item;
import com.poly.lab5.ultis.DB;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class L5_ShoppingCartServiceImpl implements L5_ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();//map is list is saved by key and value

    @Override
    public Item add(Integer id) {
        Item item = map.get(id); //find and get item by id
        if (item == null) {
            Item dbItem = DB.items.get(id); // get original data
            item = new Item(dbItem.getId(), dbItem.getName(), dbItem.getPrice(), 1);
            map.put(id, item); //if item with id doesn't exist, this method will help creating a new item
        }else {
            item.setQty(item.getQty() + 1);//if item with id existed, this method will update quanlity
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
        //get data in map, then convert to IntStream of stream(Soe- to processing collections by functional programming style)
        //Item::getQty = item -> item.getQty(), and item is got from Stream<Item> converted from map.values(Collection<Item>)
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();
        //i is parameter got from Stream<Item> converted from map.values(Collection<Item>)
    }
}
