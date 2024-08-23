package com.intership.project.controller;

import com.intership.project.model.Item;
import com.intership.project.service.ItemService;
import com.intership.project.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items/items";
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id));
        return "items/item";
    }

    @GetMapping("/create")
    public String createItemForm(@RequestParam Long collectionId, Model model) {
        model.addAttribute("itemForm", new Item());
        model.addAttribute("collectionId", collectionId);
        return "items/create";
    }

    @PostMapping("/create")
    public String createItem(@RequestParam Long collectionId, @ModelAttribute("itemForm") Item item) {
        item.setCollection(collectionService.getCollectionById(collectionId));
        itemService.createItem(item);
        return "redirect:/collections/" + collectionId;
    }

    @GetMapping("/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        model.addAttribute("itemForm", itemService.getItemById(id));
        return "items/edit";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, @ModelAttribute("itemForm") Item itemDetails) {
        itemService.updateItem(id, itemDetails);
        return "redirect:/items/" + id;
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        Long collectionId = item.getCollection().getId();
        itemService.deleteItem(id);
        return "redirect:/collections/" + collectionId;
    }
}