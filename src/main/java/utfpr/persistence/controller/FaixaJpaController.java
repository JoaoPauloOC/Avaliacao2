/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import flowshark.persistence.entity.Faixa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author João Paulo
 */
public class FaixaJpaController extends JpaController {
    
    public List<Faixa> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Faixa> cq = cb.createQuery(Faixa.class);
            cq.from(Faixa.class);
            TypedQuery<Faixa> q = em.createQuery(cq);
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
            Faixa faixa = em.find(Faixa.class, codigo);
            em.getTransaction().begin();
            em.remove(faixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void save(Faixa faixa) {

        EntityManager em = null;
        try {
            em = getEntityManager();   
            em.getTransaction().begin();
            em.persist(faixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
