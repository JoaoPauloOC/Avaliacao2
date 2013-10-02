/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.faces.mngbeans;

import flowshark.persistence.entity.Artista;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.ArtistaJpaController;

/**
 *
 * @author João Paulo
 */
@ManagedBean
@RequestScoped
public class CadastroArtistasBean extends PageBean {
    
    private Artista artista;
    
    public CadastroArtistasBean(){
        artista = new Artista();
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    public String abrirNovoCadastroAction(){
        this.artista = new Artista();
        return "cadastroArtistas";
    }
    
    public String salvarArtistaAction(){
       ArtistaJpaController ctl = new ArtistaJpaController();
       ctl.save(artista);
       return "inicio";
    }
    
}
