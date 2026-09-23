/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.status.model.Status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.ifba.usuario.validar.ValidadorUsuario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author moise
 */
public class UsuarioTest {
    @Test
    public void deveAutenticarQuandoCredenciaisCorretas(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("moises", "senha123");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaIncorreta(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678900", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("moises", "senhaErrada");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoLoginIncorreto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("Moises", "senha123");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCamposPreenchidos(){
        //Arrange
        Usuario usuario = new Usuario();
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Perfil perfilMotorista = new Perfil ("Motorista", "Pessoa responsável para executar o serviço.");
        Perfil perfilPassageiro = new Perfil ("Passageiro", "Pessoa que utiliza o serviço de transporte.");
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(perfilMotorista);
        perfis.add(perfilPassageiro);
        
        usuario.setPessoa(pessoa);
        usuario.setPerfilAtivo(perfilPassageiro);
        usuario.setNomeUsuario("Moises D");
        usuario.setTelefone("74");
        usuario.setEmail("moises.dourado@outlook.com");
        usuario.setLogin("Moises");
        usuario.setSenha("Senha123@");
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setUltimoLogin(LocalDateTime.now());
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCamposNaoEstaoPreenchidos(){
        //Arrange
        Pessoa pessoa = new Pessoa ("", "", "", "");
        Usuario usuario = new Usuario(pessoa, "", "");
        usuario.setNomeUsuario("");
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhasIguais(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhasDiferentes(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha12@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCpfValido(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getPessoa().getCpf());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCpfInvalido(){
        //Arrange
        Pessoa pessoa = new Pessoa("00000000000", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getPessoa().getCpf());
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhaForte(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaFraca(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void aoAdicionarPerfilAlistaCresce(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        Perfil perfil = new Perfil("Passageiro", "Aquele que utiliza o serviço");
        
        //Act
        int tamanhoListaOriginal = usuario.getPerfis().size();
        usuario.adicionarPerfilALista(perfil);
        int tamanhoListaAtualizado = usuario.getPerfis().size();
        boolean resultado = tamanhoListaAtualizado > tamanhoListaOriginal;
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void objetoCriadoNasceComStatusCorreto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        Status status = Status.INATIVO;
        
        //Act
        boolean resultado = usuario.getStatus() == status;
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void objetoNasceComStatusCorreto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
        Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
        Status status = Status.INATIVO;
        
        //Assert
        assertEquals(usuario.getStatus(), status);
    }
    
    @Test
    public void oObjetoRelacionadoEdevolvidoPeloGetter(){
       //Arrange
       Pessoa pessoa = new Pessoa("12345678909", "Moises Dourado", "12/06", "Masculino");
       Usuario usuario = new Usuario(pessoa, "moises", "Senha123@");
       
       //Act
       Pessoa pessoa2 = usuario.getPessoa();
       
       //Assert
       assertEquals(pessoa, pessoa2);
       
         
    }
}
