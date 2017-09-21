package br.com.is.Person.Entity;
// Generated 18/09/2017 19:52:40 by Hibernate Tools 4.3.1

import br.com.is.iipwebs.Entity.Equipe;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pessoa generated by hbm2java
 */
@Entity
@Table(name = "pessoa",
         schema = "public"
)
public class Pessoa implements java.io.Serializable {

    private int codigo;
    private String nome;
    private String apelido;
    private String cpf;
    private String rg;
    private Date nascimento;
    private String orgexp;
    private Character genero;
    private Set<PossuiContato> possuiContatos = new HashSet<PossuiContato>(0);
    private Usuario usuario;
    private Set<Equipe> equipes = new HashSet<Equipe>(0);
    private Set<PossuiEndereco> possuiEnderecos = new HashSet<PossuiEndereco>(0);

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome, Date nascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Pessoa(int codigo, String nome, String apelido, String cpf, String rg, Date nascimento, String orgexp, Character genero, Set<PossuiContato> possuiContatos, Usuario usuario, Set<Equipe> equipes, Set<PossuiEndereco> possuiEnderecos) {
        this.codigo = codigo;
        this.nome = nome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.orgexp = orgexp;
        this.genero = genero;
        this.possuiContatos = possuiContatos;
        this.usuario = usuario;
        this.equipes = equipes;
        this.possuiEnderecos = possuiEnderecos;
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

    @Column(name = "nome", nullable = false, length = 75)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "apelido", length = 50)
    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Column(name = "cpf", length = 11)
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "rg", length = 15)
    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false, length = 13)
    public Date getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @Column(name = "orgexp", length = 10)
    public String getOrgexp() {
        return this.orgexp;
    }

    public void setOrgexp(String orgexp) {
        this.orgexp = orgexp;
    }

    @Column(name = "genero", length = 1)
    public Character getGenero() {
        return this.genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    public Set<PossuiContato> getPossuiContatos() {
        return this.possuiContatos;
    }

    public void setPossuiContatos(Set<PossuiContato> possuiContatos) {
        this.possuiContatos = possuiContatos;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    public Set<Equipe> getEquipes() {
        return this.equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    public Set<PossuiEndereco> getPossuiEnderecos() {
        return this.possuiEnderecos;
    }

    public void setPossuiEnderecos(Set<PossuiEndereco> possuiEnderecos) {
        this.possuiEnderecos = possuiEnderecos;
    }

}
