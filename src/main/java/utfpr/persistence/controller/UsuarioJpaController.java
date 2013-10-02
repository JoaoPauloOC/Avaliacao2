package utfpr.persistence.controller;

import flowshark.persistence.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioJpaController extends JpaController {

    public UsuarioJpaController() {
    }

    public List<Usuario> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            cq.from(Usuario.class);
            TypedQuery<Usuario> q = em.createQuery(cq);
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
            Usuario usuario = em.find(Usuario.class, codigo);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void save(Usuario usuario) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            // Se o codigo for -1 significa que eh um usuario novo
            //if (usuario.getCodigo() == -1) {
                
                em.getTransaction().begin();
                em.persist(usuario);
                em.getTransaction().commit();
            /*} else { // se nao eh uma atualizacao
                
                // Recupera o usuario do BD
                Usuario usuarioBD = em.find(Usuario.class, usuario.getCodigo());
                em.getTransaction().begin();
                
                // Atualiza o usuario do BD com os dados da memoria
                usuarioBD.setEmail(usuario.getEmail());
                usuarioBD.setNome(usuario.getNome());
                usuarioBD.setPerfil(usuario.getPerfil());
                usuarioBD.setSenha(usuario.getSenha());
                
                em.getTransaction().commit();
            }*/
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
