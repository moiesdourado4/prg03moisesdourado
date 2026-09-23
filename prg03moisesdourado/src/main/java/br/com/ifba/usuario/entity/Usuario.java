/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.status.model.Status;
import br.com.ifba.usuario.interfaces.Autenticavel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author moise
 */
public class Usuario implements Autenticavel{
    //Atributos
    private Pessoa pessoa;
    private List<Perfil> perfis;
    private Perfil perfilAtivo;
    private Status status;
    
    private String nomeUsuario;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private LocalDateTime criadoEm;
    private LocalDateTime ultimoLogin;
    
    //Métodos
    public Usuario(){
        
    }
    public Usuario(Pessoa pessoa, String login, String senha){
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.perfis = new ArrayList<>();
        this.status = Status.INATIVO;
        this.criadoEm = LocalDateTime.now();
    }

    public Pessoa getPessoa(){
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    
    public List<Perfil> getPerfis(){
        return perfis;
    }
    public void setPerfis(List<Perfil> perfis){
        this.perfis = perfis;
    }
    
    public Perfil getPerfilAtivo(){
        return perfilAtivo;
    }
    public void setPerfilAtivo(Perfil perfilAtivo){
        this.perfilAtivo = perfilAtivo;
    }
    
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public LocalDateTime getCriadoEm(){
        return criadoEm;
    }
    public void setCriadoEm(LocalDateTime criadoEm){
        this.criadoEm = criadoEm;
    }
    
    public LocalDateTime getUltimoLogin(){
        return ultimoLogin;
    }
    public void setUltimoLogin(LocalDateTime ultimoLogin){
        this.ultimoLogin = ultimoLogin;
    }
    /*private boolean senhaValida(String senha){
        return this.senha.equals(senha);
    }*/
    
    @Override
    public boolean autenticar(String login, String senha){
        if (this.login.equals(login) && this.senha.equals(senha)){
            return true;
        }
        else{
            return false;
        }
        //return this.login.equals(login) && senhaValida(senha);
    }
    
    public void adicionarPerfilALista(Perfil perfil){
        this.perfis.add(perfil);
    }
}
