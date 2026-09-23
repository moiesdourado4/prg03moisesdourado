/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pessoa.entity;

/**
 *
 * @author moise
 */
public class Pessoa {
    private String cpf;
    private String nomeCompleto;
    private String dataNascimento;
    private String genero;
    
    public Pessoa(){
        
    }
    public Pessoa(String cpf, String nomeCompleto, String dataNascimento, String genero){
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getNomeCompleto(){
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }
    
    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
}
