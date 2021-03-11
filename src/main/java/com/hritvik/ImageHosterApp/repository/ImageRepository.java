package com.hritvik.ImageHosterApp.repository;

import com.hritvik.ImageHosterApp.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

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

    public List<Image> getAllImages() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Image> query = entityManager.createQuery("SELECT p from Image p", Image.class);
        List<Image> resultList = query.getResultList();
        return resultList;
    }
}
