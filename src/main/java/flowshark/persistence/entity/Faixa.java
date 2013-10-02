/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flowshark.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author João Paulo
 */
@Entity
@Table(name = "faixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faixa.findAll", query = "SELECT f FROM Faixa f"),
    @NamedQuery(name = "Faixa.findByCodigo", query = "SELECT f FROM Faixa f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Faixa.findByNumero", query = "SELECT f FROM Faixa f WHERE f.numero = :numero"),
    @NamedQuery(name = "Faixa.findByTitulo", query = "SELECT f FROM Faixa f WHERE f.titulo = :titulo"),
    @NamedQuery(name = "Faixa.findByDuracao", query = "SELECT f FROM Faixa f WHERE f.duracao = :duracao")})
public class Faixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracao")
    private int duracao;
    @JoinColumn(name = "artista", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Artista artista;
    @JoinColumn(name = "album", referencedColumnName = "codigo")
    @ManyToOne
    private Album album;

    public Faixa() {
        artista = new Artista();
        album = new Album();
    }

    public Faixa(Integer codigo) {
        this.codigo = codigo;
    }

    public Faixa(Integer codigo, String titulo, int duracao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faixa)) {
            return false;
        }
        Faixa other = (Faixa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flowshark.persistence.entity.Faixa[ codigo=" + codigo + " ]";
    }
    
}
