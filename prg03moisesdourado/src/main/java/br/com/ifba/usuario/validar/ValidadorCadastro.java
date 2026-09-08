/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;

/**
 *
 * @author moise
 */
public class ValidadorCadastro {
   
    public static boolean contemPalavraProibida(String texto){
        //array
        String palavrasProibidas[] = {"admin", "teste", "root", "senha123"};
        
        for (String palavra : palavrasProibidas){
            if (palavra.equals(texto) == true)
                return true;
        }
    return false;
    }
}
