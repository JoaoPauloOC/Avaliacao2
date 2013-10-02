/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.faces.mngbeans;

import flowshark.persistence.entity.Album;
import flowshark.persistence.entity.Artista;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.AlbumJpaController;
import utfpr.persistence.controller.ArtistaJpaController;

/**
 *
 * @author João Paulo
 */

@ManagedBean
@RequestScoped
public class CadastroAlbunsBean extends PageBean {
    
    private Album album;
    
    public CadastroAlbunsBean(){
        album = new Album();
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public String abrirNovoCadastroAction(){
        this.album = new Album();
        return "cadastroAlbuns";
    }
    
    public String salvarAlbumAction(){
        /*Map<String, String> retorno = new HashMap<>();
        PerfilJpaController ctlPerfis = new PerfilJpaController();
        ArrayList<Perfil> perfis = new ArrayList<>(ctlPerfis.findAll());
        
        for(Perfil perfil : perfis){
            retorno.put(perfil.getDescricao(), perfil.getCodigo().toString());
        }*/
        
       AlbumJpaController ctl = new AlbumJpaController();
       ctl.save(album);
       return "inicio";
    }
    
    public List<Artista> getArtistas(){
        List<Artista> artistas;
        try {
            ArtistaJpaController ctl = new ArtistaJpaController();
            artistas = ctl.findAll();
        } catch (Exception e) {
            artistas = new ArrayList<>(0);
            log("Lista de idiomas", e);
        }
        return artistas;
    }
    
}
