/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade05.model;

/**
 *
 * @author moises
 */
public class Fatorial {
    private int num = 0;
    private int fatorial = 1;
    private String formula = "";
    
    public void setValor(int n){
        num = n;
        int f = 1;
        String s = "";
        //Caso seja 0 ou 1
        if (n == 0 || n == 1){
            f = 1;
            s = n + "! = ";
        } else {
            for(int i = n; i > 1; i--){
                f *= i;
                s += i + " x ";
            }
            s += "1 = ";
        }
        fatorial = f;
        formula = s;
    }
    
    public int getFatorial(){
        return fatorial;
    }
    
    public String getFormula(){
        return formula;
    }
}
