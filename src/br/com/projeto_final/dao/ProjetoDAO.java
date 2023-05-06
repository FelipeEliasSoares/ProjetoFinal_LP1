package br.com.projeto_final.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.projeto_final.dto.ClienteDTO;
import br.com.projeto_final.dto.MarcineiroDTO;
import br.com.projeto_final.dto.MaterialDTO;
import br.com.projeto_final.dto.MaterialDTO;
import br.com.projeto_final.dto.ProjetoDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;



/**
 *
 * @author Felipe
 */
public class ProjetoDAO {
    
    public  ProjetoDAO(){
    
    }
    
    private ResultSet rs = null;
    
    Statement stmt = null;
    Statement stmtl = null; 
    
    MaterialDTO materialDTO = new MaterialDTO();
    
public boolean inserirProjeto(ProjetoDTO projetoDTO, MarcineiroDTO marceneiroDTO, JTable materiais) {
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        stmtl = ConexaoDAO.con.createStatement();

        // Insere o projeto
        String comando1 = "INSERT INTO projeto (nome_proj, descricao_proj, id_mar) VALUES ('"
                + projetoDTO.getNome_proj() + "', '"
                + projetoDTO.getDescricao_proj() + "', "
                + marceneiroDTO.getId_mar() + ")";
        stmt.executeUpdate(comando1, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
        rs.next();

        // Insere os materiais do projeto na tabela material_projeto
        for(int cont=0; cont < materiais.getRowCount(); cont++){
            String comando2 = "INSERT INTO material_projeto (id_proj, id_material, qtd_mp) VALUES ("
                    + rs.getInt("id_proj") + ", "
                    + materiais.getValueAt(cont, 0) + ", "
                    + materiais.getValueAt(cont, 2) + ")";
            stmtl.executeUpdate(comando2);
        }

        ConexaoDAO.con.commit();

        stmt.close();
        stmtl.close();
        rs.close();
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}//fecha metodo Inserir
    
public boolean alterarProjeto(ProjetoDTO projetoDTO, MarcineiroDTO marceneiroDTO, JTable materiais) {
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        stmtl = ConexaoDAO.con.createStatement();

        // Altera o projeto
        String comando1 = "UPDATE projeto SET nome_proj = '"
                + projetoDTO.getNome_proj() + "', descricao_proj = '"
                + projetoDTO.getDescricao_proj() + "', id_mar = "
                + marceneiroDTO.getId_mar() + " WHERE id_proj = " + projetoDTO.getId_proj();
        stmt.executeUpdate(comando1);

        // Deleta todos os materiais do projeto na tabela material_projeto
        String comando2 = "DELETE FROM material_projeto WHERE id_proj = " + projetoDTO.getId_proj();
        stmtl.executeUpdate(comando2);

        // Insere os novos materiais do projeto na tabela material_projeto
        for(int cont=0; cont < materiais.getRowCount(); cont++){
            String comando3 = "INSERT INTO material_projeto (id_proj, id_material, qtd_mp) VALUES ("
                    + projetoDTO.getId_proj() + ", "
                    + materiais.getValueAt(cont, 0) + ", "
                    + materiais.getValueAt(cont, 2) + ")";
            stmtl.executeUpdate(comando3);
        }

        ConexaoDAO.con.commit();

        stmt.close();
        stmtl.close();
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}//Metodo alterar

public boolean excluirProjeto(int id_proj) {
    try {
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();

        // Exclui os materiais do projeto da tabela material_projeto
        String comando1 = "DELETE FROM material_projeto WHERE id_proj = " + id_proj;
        stmt.executeUpdate(comando1);

        // Exclui o projeto da tabela projeto
        String comando2 = "DELETE FROM projeto WHERE id_proj = " + id_proj;
        stmt.executeUpdate(comando2);

        ConexaoDAO.con.commit();

        stmt.close();
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}

public ResultSet consultarProjeto(ProjetoDTO projetoDTO, int opcao) {
    try {
        // Chama o método que está na classe ConexaoDAO para abrir o banco de dados
        ConexaoDAO.ConectDB();
        // Cria o Statement que é responsável por executar alguma coisa no banco de dados
        stmt = ConexaoDAO.con.createStatement();
        // Comando SQL que será executado no banco de dados
        String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT p.*, mp.qtd_mp, m.* " +
                              "FROM projeto p " +
                              "INNER JOIN material_projeto mp ON p.id_proj = mp.id_proj " +
                              "INNER JOIN material m ON mp.id_material = m.id_material " +
                              "WHERE p.nome_proj ILIKE '" + projetoDTO.getNome_proj() + "%' "+
                              "ORDER BY p.nome_proj";
                    break;
                case 2:
                    comando = "SELECT m.*, p.nome_proj, p.descricao_proj, mp.qtd_mp, f.id_fornecedor, f.nome_fornecedor " +
                              "FROM material_projeto mp " +
                              "INNER JOIN material m ON mp.id_material = m.id_material " +
                              "INNER JOIN projeto p ON mp.id_proj = p.id_proj " +
                              "LEFT JOIN fornecedor f ON m.id_fornecedor = f.id_fornecedor " +
                              "WHERE m.id_material = " + projetoDTO.getId_material();
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
}
