package com.intership.project.controller;

import com.intership.project.model.Collection;
import com.intership.project.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionRestController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public List<Collection> getAllCollections() {
        return collectionService.getAllCollections();
    }

    @PostMapping
    public Collection createCollection(@RequestBody Collection collection) {
        return collectionService.createCollection(collection);
    }

    @PutMapping("/{id}")
    public Collection updateCollection(@PathVariable Long id, @RequestBody Collection collectionDetails) {
        return collectionService.updateCollection(id, collectionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCollection(@PathVariable Long id) {
        collectionService.deleteCollection(id);
    }
}