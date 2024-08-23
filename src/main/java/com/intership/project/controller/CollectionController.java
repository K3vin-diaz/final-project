package com.intership.project.controller;

import com.intership.project.model.Collection;
import com.intership.project.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public String getAllCollections(Model model) {
        model.addAttribute("collections", collectionService.getAllCollections());
        return "collections/collection";
    }

    @GetMapping("/{id}")
    public String getCollectionById(@PathVariable Long id, Model model) {
        model.addAttribute("collection", collectionService.getCollectionById(id));
        return "collections/collection";
    }

    @GetMapping("/create")
    public String createCollectionForm(Model model) {
        model.addAttribute("collectionForm", new Collection());
        return "collections/create";
    }

    @PostMapping("/create")
    public String createCollection(@ModelAttribute("collectionForm") Collection collection) {
        collectionService.createCollection(collection);
        return "redirect:/collections";
    }

    @GetMapping("/edit/{id}")
    public String editCollectionForm(@PathVariable Long id, Model model) {
        model.addAttribute("collectionForm", collectionService.getCollectionById(id));
        return "collections/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCollection(@PathVariable Long id, @ModelAttribute("collectionForm") Collection collectionDetails) {
        collectionService.updateCollection(id, collectionDetails);
        return "redirect:/collections";
    }

    @PostMapping("/delete/{id}")
    public String deleteCollection(@PathVariable Long id) {
        collectionService.deleteCollection(id);
        return "redirect:/collections";
    }
}