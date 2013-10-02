/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.faces.mngbeans;

import flowshark.persistence.entity.Album;
import flowshark.persistence.entity.Artista;
import flowshark.persistence.entity.Faixa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.AlbumJpaController;
import utfpr.persistence.controller.ArtistaJpaController;
import utfpr.persistence.controller.FaixaJpaController;

/**
 *
 * @author João Paulo
 */

@ManagedBean
@RequestScoped
public class CadastroFaixasBean extends PageBean{
    
    private Faixa faixa;
    private List<Album> albuns;
    
    public CadastroFaixasBean(){
        faixa = new Faixa();
        albuns = new ArrayList<Album>();
    }

    public Faixa getFaixa() {
        return faixa;
    }

    public void setFaixa(Faixa faixa) {
        this.faixa = faixa;
    }
    
    public String abrirNovoCadastroAction(){
        this.faixa = new Faixa();
        return "cadastroFaixas";
    }
    
    public String salvarFaixaAction(){
       FaixaJpaController ctl = new FaixaJpaController();
       ctl.save(faixa);
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
    
    public List<Album> getAlbuns(){
        return albuns;
    }
    
    public void changeListener(ValueChangeEvent vce){
        try {
            AlbumJpaController ctl = new AlbumJpaController();
            albuns = ctl.findByArtista(Integer.parseInt(vce.getNewValue().toString()));
        } catch (Exception e) {
            albuns = new ArrayList<>(0);
            log("Lista de idiomas", e);
        }
    }
    
}
