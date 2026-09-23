/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.entity;

/**
 *
 * @author moise
 */
public class Perfil {
    private String nome;
    private String descricao;
    private boolean imutavel;
    private String imagemUrl;
    
    public Perfil(){
        
    }
    public Perfil(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public boolean getImutavel(){
        return imutavel;
    }
    public void setImutavel(boolean imutavel){
        this.imutavel = imutavel;
    }
    
    public String getImagemUrl(){
        return imagemUrl;
    }
    public void setImagemUrl(String imagemUrl){
        this.imagemUrl = imagemUrl;
    }
}
