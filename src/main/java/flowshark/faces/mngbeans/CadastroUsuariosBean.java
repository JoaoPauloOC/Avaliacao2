package flowshark.faces.mngbeans;

import flowshark.persistence.entity.Perfil;
import flowshark.persistence.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.PerfilJpaController;
import utfpr.persistence.controller.UsuarioJpaController;

@ManagedBean
@RequestScoped
public class CadastroUsuariosBean extends PageBean {
        
   private Usuario usuario;

    public CadastroUsuariosBean() {
       usuario = new Usuario();
    }      

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String abrirEdicaoAction(Usuario usuario){
        this.usuario = usuario;
        return "cadastroUsuarios";
    }
    
    public String abrirNovoCadastroAction(){
        this.usuario = new Usuario();
        return "cadastroUsuarios";
    }
    
    public String salvarUsuarioAction(){
        /*Map<String, String> retorno = new HashMap<>();
        PerfilJpaController ctlPerfis = new PerfilJpaController();
        ArrayList<Perfil> perfis = new ArrayList<>(ctlPerfis.findAll());
        
        for(Perfil perfil : perfis){
            retorno.put(perfil.getDescricao(), perfil.getCodigo().toString());
        }*/
        
       UsuarioJpaController ctl = new UsuarioJpaController();
       ctl.save(usuario);
       return "inicio";
    }
    
    /*public Map<String, String> getPerfis(){
        Map<String, String> retorno = new HashMap<>();
        PerfilJpaController ctl = new PerfilJpaController();
        ArrayList<Perfil> perfis = new ArrayList<>(ctl.findAll());
        
        for(Perfil perfil : perfis){
            retorno.put(perfil.getDescricao(), perfil.getCodigo().toString());
        }
        
        return retorno;
    }*/
    
    public List<Perfil> getPerfis(){
        List<Perfil> perfis;
        try {
            PerfilJpaController ctl = new PerfilJpaController();
            perfis = ctl.findAll();
        } catch (Exception e) {
            perfis = new ArrayList<>(0);
            log("Lista de idiomas", e);
        }
        return perfis;
    }
    
}