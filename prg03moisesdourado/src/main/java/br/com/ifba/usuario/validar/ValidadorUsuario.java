/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;
import br.com.ifba.usuario.entity.Usuario;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author moise
 */
public class ValidadorUsuario {
    //verifica se os campos estão preenchidos
    public static boolean camposPreenchidos(Usuario usuario, String confirmarSenha){
        if (usuario.getPessoa().getNomeCompleto().isEmpty() || usuario.getPessoa().getCpf().isEmpty() || usuario.getPessoa().getGenero().isEmpty() || usuario.getPessoa().getDataNascimento().isEmpty() || 
            usuario.getTelefone().isEmpty() || usuario.getEmail().isEmpty() || usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty() || confirmarSenha.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    //verifica se as senhas são iguais
    public static boolean senhasIguais(Usuario usuario, String confirmarSenha){
        if(usuario.getSenha().equals(confirmarSenha) == false){
            return false;
        }
        else{
            return true;
        }
    }
    //verifica se o CPF é válido
    public static boolean cpfValido(String cpf){
        if (cpf == null){
            return false;
        }
        //Remove caracteres não numéricos(pontos, traços, espaços)
        cpf = cpf.replaceAll("\\D", "");
        
        //O CPF precisa ter exatamente 11 dígitos
        if (cpf.length() != 11){
            return false;
        }
        
        //Elimina CPFs com todos os dígitos iguais
        if (cpf.matches("(\\d)\\1{10}")){
            return false;
        }
        
        //Cálculo do primeiro dígito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++){
            int num = Character.getNumericValue(cpf.charAt(i));
            soma1 += num * (10 - i);
        }
        
        int resto1 = 11 - (soma1 % 11);
        int digito1 = (resto1 >= 10) ? 0 : resto1;
        
        //Se o 1º dígito não coincidir, nem precisa calcular o 2º
        if (digito1 != Character.getNumericValue(cpf.charAt(9))){
            return false;
        }
        
        //Calculo do 2º dígito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++){
            int num = Character.getNumericValue(cpf.charAt(i));
            soma2 += num * (11 - i);
        }
        
        int resto2 = 11 - (soma2 % 11);
        int digito2 = (resto2 >= 10) ? 0 : resto2;
        
        //Retorna true se o 2º dígito também for válido
        return digito2 == Character.getNumericValue(cpf.charAt(10));
            
    }
    //Regex para validar a força da senha
    private static final String REGEX_SENHA_FORTE = 
            "^(?=.*[0-9])" + //Pelo menos um dígito
            "(?=.*[a-z])" + //Pelo menos uma letra minúscula
            "(?=.*[A-Z])" + //Pelo menos uma letra maiúscula
            "(?=.*[@#$%^&+=!\\-_?])" + //Pelo menos um caracter especial
            "(?=\\S+$)" + //Sem espaços em branco
            ".{8,}$"; //Mínimo de 8 caracteres
    
    private static final Pattern PATTERN = Pattern.compile(REGEX_SENHA_FORTE);
    
    public static boolean senhaForte(String senha){
        if (senha == null){
            return false;
        }
        Matcher matcher = PATTERN.matcher(senha);
        return matcher.matches();
    }
}
