/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_final.dao;
import java.sql.*;
import br.com.projeto_final.dto.MarcineiroDTO;
/**
 *
 * @author Aluno
 */
public class MarcineiroDAO {
    
    
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    public boolean inserirMarcineiro(MarcineiroDTO marcineiroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into marceneiro (nome_mar, cpf_mar, "
                    + "tel_mar) values ( "
                    + "'" + marcineiroDTO.getNome_mar()+ "', "
                    + "'" + marcineiroDTO.getCpf_mar()+ "', "
                    + "'" + marcineiroDTO.getTel_mar()+ "') ";
            
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }
    
    
    public boolean alterarMarcineiro(MarcineiroDTO marcineiroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update marceneiro set "
                + "nome_mar = '" + marcineiroDTO.getNome_mar()+ "', "
                + "cpf_mar = '" + marcineiroDTO.getTel_mar()+ "', "
                + "tel_mar = '" + marcineiroDTO.getTel_mar()+ "' "
                + "where id_mar = " + marcineiroDTO.getId_mar();
                 
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem 
          //no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método alterarMarcineiro
    
    
    public boolean excluirMarcineiro(MarcineiroDTO marcineiroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from marceneiro where id_mar = " 
                             + marcineiroDTO.getId_mar();


            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirMarcineiro
    
    
    public ResultSet consultarMarcineirio(MarcineiroDTO marcineiroDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select f.id_mar, f.nome_mar "+
                              "from marceneiro f "+
                              "where f.nome_mar ilike '" + marcineiroDTO.getNome_mar()+ "%' " +
                              "order by f.nome_mar";    
                break;
                case 2:
                    comando = "SELECT f.nome_mar, f.cpf_mar, f.tel_mar " +
                              "FROM marceneiro f " +
                              "WHERE f.id_mar = " + marcineiroDTO.getId_mar();

                break;
                
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarFornecedor
}
