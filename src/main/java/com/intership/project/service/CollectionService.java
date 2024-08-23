package com.intership.project.service;


import com.intership.project.model.Collection;
import com.intership.project.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection createCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    public Collection updateCollection(Long id, Collection collectionDetails) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Collection not found"));

        collection.setName(collectionDetails.getName());
        collection.setDescription(collectionDetails.getDescription());
        // Actualiza otros campos según sea necesario

        return collectionRepository.save(collection);
    }

    public void deleteCollection(Long id) {
        collectionRepository.deleteById(id);
    }
}