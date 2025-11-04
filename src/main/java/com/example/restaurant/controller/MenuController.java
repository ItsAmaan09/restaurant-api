package com.example.restaurant.controller;

import com.example.restaurant.model.MenuItem;
import com.example.restaurant.repository.MenuRepository;
import com.example.restaurant.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("/all")
    public List<MenuItem> GetMenu() {
        return service.getItem();
    }

    @PostMapping("/add")
    public MenuItem AddItem(@RequestBody @Valid MenuItem menuItem) {
        return service.addItem(menuItem);
    }

    @PutMapping("/update/{id}")
    public MenuItem UpdateItem(@PathVariable int id, @RequestBody MenuItem menuItem) {
        return service.updateItem(id,menuItem);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteItem(@PathVariable int id) {
        return service.deleteItem(id);
    }
}