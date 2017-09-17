package br.com.is.Address.Entity;
// Generated 13/09/2017 20:17:35 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cidade generated by hbm2java
 */
@Entity
@Table(name = "cidade",
        schema = "public"
)
public class Cidade implements java.io.Serializable {

    private int codigo;
    private Estado estado;
    private String nome;
    private Set<Endereco> enderecos = new HashSet<Endereco>(0);

    public Cidade() {
    }

    public Cidade(int codigo, Estado estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public Cidade(int codigo, Estado estado, String nome, Set<Endereco> enderecos) {
        this.codigo = codigo;
        this.estado = estado;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", unique = true, nullable = false)
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado", nullable = false)
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Column(name = "nome", length = 75)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade")
    public Set<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}