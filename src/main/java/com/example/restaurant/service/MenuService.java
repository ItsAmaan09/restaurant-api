package com.example.restaurant.service;

import com.example.restaurant.model.MenuItem;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repository;

    public List<MenuItem> getItem() {
        return repository.findAll();
    }

    public MenuItem addItem(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    public MenuItem updateItem(int id, MenuItem menuItem) {
        return repository.findById(id).map(item -> {
            item.setName(menuItem.getName());
            item.setPrice(menuItem.getPrice());
            repository.save(item);
            return item;
        }).orElse(null);
    }

    public String deleteItem(int id) {
        repository.deleteById(id);
        return "Delete Successfully!";
    }
}
