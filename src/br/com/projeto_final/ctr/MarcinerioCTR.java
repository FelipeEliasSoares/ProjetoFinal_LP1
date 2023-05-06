/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_final.ctr;


import java.sql.ResultSet;
import br.com.projeto_final.dao.MarcineiroDAO;
import br.com.projeto_final.dto.MarcineiroDTO;
import br.com.projeto_final.dao.ConexaoDAO;
/**
 *
 * @author Aluno
 */
public class MarcinerioCTR {
    
    MarcineiroDAO marcineiroDAO = new MarcineiroDAO();
    
    public MarcinerioCTR() {
    }
    
    public String inserirMarcinerio(MarcineiroDTO marcineiroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (marcineiroDAO.inserirMarcineiro(marcineiroDTO)) {
                return "Marcinerio Cadastrado com Sucesso!!!";
            } else {
                return "Marcineio NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Marcinerio NÃO Cadastrado";
        }
    }//Fecha o método inserirFornecedor
    
    
    public String alterarMarcineiro(MarcineiroDTO marcineiroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (marcineiroDAO.alterarMarcineiro(marcineiroDTO)) {
                return "Marcinerio Alterado com Sucesso!!!";
            } else {
                return "Marcinerio NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Marcinerio NÃO Alterado!!!";
        }
    }//Fecha o método alterarFornecedor

    
    /**
     * Método utilizado para controlar o acesso ao método excluirFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirMarcinerio(MarcineiroDTO marcineiroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (marcineiroDAO.alterarMarcineiro(marcineiroDTO)) {
                return "Marcineiro Excluído com Sucesso!!!";
            } else {
                return "Marcinerio NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Marcineio NÃO Excluído!!!";
        }
    }//Fecha o método excluirMarcinerio

    
    public ResultSet consultarMarcinerio(MarcineiroDTO marcineiroDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = marcineiroDAO.consultarMarcineirio(marcineiroDTO, opcao);
        return rs;
    }//Fecha o método consultarMarcinerio
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}
