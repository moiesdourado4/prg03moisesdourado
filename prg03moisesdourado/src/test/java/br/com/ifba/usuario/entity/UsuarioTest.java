/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.ifba.usuario.validar.ValidadorUsuario;
/**
 *
 * @author moise
 */
public class UsuarioTest {
    @Test
    public void deveAutenticarQuandoCredenciaisCorretas(){
        //Arrange
        Usuario usuario = new Usuario ("Moises", "12345678900",
                                        "moises", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("moises", "senha123");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaIncorreta(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678900",
                                        "moises", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("moises", "senhaErrada");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoLoginIncorreto(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678900", 
                                        "moises", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("Moises", "senha123");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCamposPreenchidos(){
        //Arrange
        Usuario usuario = new Usuario();
        usuario.setNome("Moises Dourado");
        usuario.setCpf("12345678909");
        usuario.setGenero("Masculino");
        usuario.setDataNascimento("12/06");
        usuario.setTelefone("74");
        usuario.setEmail("moisesdourado@gmail.com");
        usuario.setLogin("Moises");
        usuario.setSenha("Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCamposNaoEstaoPreenchidos(){
        //Arrange
        Usuario usuario = new Usuario("", "", "", "");
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhasIguais(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678909", "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhasDiferentes(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678909", "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha12@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCpfValido(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678909", "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getCpf());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCpfInvalido(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "00000000000", "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getCpf());
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhaForte(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678909", "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaFraca(){
        //Arrange
        Usuario usuario = new Usuario("Moises", "12345678909", "moises", "Senha123");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertFalse(resultado);
    }
}
