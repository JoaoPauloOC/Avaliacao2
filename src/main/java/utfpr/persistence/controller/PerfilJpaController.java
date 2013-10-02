package utfpr.persistence.controller;

import flowshark.persistence.entity.Perfil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class PerfilJpaController extends JpaController {

    public PerfilJpaController() {
    }

    public List<Perfil> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Perfil> cq = cb.createQuery(Perfil.class);
            cq.from(Perfil.class);
            TypedQuery<Perfil> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
