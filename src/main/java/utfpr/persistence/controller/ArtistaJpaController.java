/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import flowshark.persistence.entity.Artista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author João Paulo
 */
public class ArtistaJpaController extends JpaController {
    
    public List<Artista> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
            cq.from(Artista.class);
            TypedQuery<Artista> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void remove(Integer codigo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Artista artista = em.find(Artista.class, codigo);
            em.getTransaction().begin();
            em.remove(artista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void save(Artista artista) {

        EntityManager em = null;
        try {
            em = getEntityManager();   
            em.getTransaction().begin();
            em.persist(artista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
