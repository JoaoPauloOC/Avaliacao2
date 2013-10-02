/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import flowshark.persistence.entity.Inscricao;
import flowshark.persistence.entity.Inscricao_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author João Paulo
 */
public class InscricaoJpaController extends JpaController {
    
    public List<Inscricao> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            cq.from(Inscricao.class);
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Inscricao findByNumero(int numeroInscricao){
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.numero),numeroInscricao));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList().get(0);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Inscricao findByCpf(long cpf){
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.cpf),cpf));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList().get(0);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void save(Inscricao inscricao){
        EntityManager em = null;
        try {
            em = getEntityManager();
                
            // Recupera o usuario do BD
            Inscricao inscricaoBD = em.find(Inscricao.class, inscricao.getNumero());

            // Atualiza o usuario do BD com os dados da memoria
            inscricaoBD.setNome(inscricao.getNome());
            inscricaoBD.setCidade(inscricao.getCidade());
            inscricaoBD.setEstado(inscricao.getEstado());
            inscricaoBD.setCpf(inscricao.getCpf());

            em.getTransaction().begin();
            em.persist(inscricaoBD);
            em.getTransaction().commit();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
