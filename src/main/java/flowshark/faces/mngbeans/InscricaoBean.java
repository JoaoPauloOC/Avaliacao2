/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.faces.mngbeans;

import flowshark.persistence.entity.Inscricao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;
import utfpr.persistence.controller.InscricaoJpaController;

/**
 *
 * @author João Paulo
 */
@ManagedBean
@SessionScoped
public class InscricaoBean extends PageBean {

    private Inscricao inscricao;
    private ListDataModel<Inscricao> inscricaoDataModel;
    
    /**
     * Creates a new instance of InscricaoBean
     */
    public InscricaoBean() {
    
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
    
    public ListDataModel<Inscricao> getInscricaoDataModel(){
        InscricaoJpaController ctl = new InscricaoJpaController();
        if(inscricaoDataModel==null){
            inscricaoDataModel = new ListDataModel<Inscricao>(ctl.findAll());
        }
        return inscricaoDataModel;
    }
    
    public String alterarAction(){
        inscricao = inscricaoDataModel.getRowData();
        return "formulario";
    }
    
    public String salvarAlteracoesAction(){
        InscricaoJpaController ctl = new InscricaoJpaController();
        ctl.save(inscricao);
        return "inicio";
    }
    
}
