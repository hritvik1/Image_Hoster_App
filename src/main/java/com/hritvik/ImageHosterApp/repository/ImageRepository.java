package com.hritvik.ImageHosterApp.repository;

import com.hritvik.ImageHosterApp.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class ImageRepository {

    @PersistenceUnit(unitName = "imageapp")
    private EntityManagerFactory entityManagerFactory;

    public void createImage(Image newImage) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newImage);
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
