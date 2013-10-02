/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.faces.mngbeans;

import flowshark.persistence.entity.Inscricao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.InscricaoJpaController;

/**
 *
 * @author João Paulo
 */
@ManagedBean
@RequestScoped
public class InscricaoBean extends PageBean {

    private ListDataModel<Inscricao> inscricaoDataModel;
    
    /**
     * Creates a new instance of InscricaoBean
     */
    public InscricaoBean() {
    
    }
    
    public ListDataModel<Inscricao> getInscricaoDataModel(){
        InscricaoJpaController ctl = new InscricaoJpaController();
        if(inscricaoDataModel==null){
            inscricaoDataModel = new ListDataModel<Inscricao>(ctl.findAll());
        }
        return inscricaoDataModel;
    }
    
    public String salvarAlteracoesAction(){
        return "inicio";
    }
    
}
