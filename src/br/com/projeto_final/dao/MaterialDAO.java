package br.com.projeto_final.dao;
/**
 *
 * @author Andre Luis Gobbi Primo/Ivan Oliveira Lopes
 */

import br.com.projeto_final.dao.ConexaoDAO;
import java.sql.*;
import br.com.projeto_final.dto.MaterialDTO;
import br.com.projeto_final.dto.FornecedorDTO;

public class MaterialDAO {
    
    /**
     * Método construtor da classe
     */
    public MaterialDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    

     
    public boolean inserirMaterial(MaterialDTO materialDTO, FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into material (nome_material, desc_material, cod_bar_material, "
                    + "p_custo_material, id_for) values ( "
                    + "'" + materialDTO.getNome_material()+ "', "
                    + "'" + materialDTO.getDesc_material()+ "', "
                    + "'" + materialDTO.getCod_bar_material()+ "', "
                    + materialDTO.getP_custo_material()+ ", "
                    + fornecedorDTO.getId_for()+ ") ";
            
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
    }//Fecha o método inserirProduto
    
    
    public boolean alterarMaterial(MaterialDTO materialDTO, FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update material set "
                    + "nome_material = '" + materialDTO.getNome_material()+ "', "
                    + "desc_material = '" + materialDTO.getDesc_material()+ "', "
                    + "cod_bar_material = '" + materialDTO.getCod_bar_material()+ "', "
                    + "p_custo_material = " + materialDTO.getP_custo_material()+ ", "
                    + "id_for = " + fornecedorDTO.getId_for()+ " "
                    + "where id_material = " + materialDTO.getId_material();
                       
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
    }//Fecha o método alterarProduto
    
    
    /**
     * Método utilizado para excluir um objeto produtoDTO no banco de dados
     *
     * @param produtoDTO que vem da classe ProdutoCTR
     * @return Um boolean
     */
    public boolean excluirMaterial(MaterialDTO materialDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from material where id_material = " 
                             + materialDTO.getId_material();

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
    }//Fecha o método excluirProduto
    
        
    
public ResultSet consultarMaterial(MaterialDTO materialDTO, int opcao) {
    try {
        // Chama o método que está na classe ConexaoDAO para abrir o banco de dados
        ConexaoDAO.ConectDB();
        // Cria o Statement que é responsável por executar alguma coisa no banco de dados
        stmt = ConexaoDAO.con.createStatement();
        // Comando SQL que será executado no banco de dados
        String comando = "";
        switch (opcao) {
            case 1:
                comando = "SELECT m.* " +
                          "FROM material m " +
                          "WHERE m.nome_material ILIKE '" + materialDTO.getNome_material() + "%' " +
                          "ORDER BY m.nome_material";
                break;
            case 2:
                comando = "SELECT m.*, f.nome_for, f.id_for " +
                          "FROM material m, fornecedor f " +
                          "WHERE m.id_for = f.id_for AND " +
                          "m.id_material = " + materialDTO.getId_material();
                break;
        }
        // Executa o comando SQL no banco de dados
        rs = stmt.executeQuery(comando.toUpperCase());
        return rs;
    } catch (Exception e) {
        // Caso tenha algum erro no código acima é enviado uma mensagem no console com o que está acontecendo
        System.out.println(e.getMessage());
        return rs;
    }
}


    
}//Fecha classe MaterialDAO
