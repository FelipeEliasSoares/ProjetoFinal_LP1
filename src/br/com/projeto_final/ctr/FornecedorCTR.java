package br.com.projeto_final.ctr;
/**
 *
 * @author Andre Luis Gobbi Primo/Ivan Oliveira Lopes
 */

import java.sql.ResultSet;
import br.com.projeto_final.dto.FornecedorDTO;
import br.com.projeto_final.dao.FornecedorDAO;
import br.com.projeto_final.dao.ConexaoDAO;

public class FornecedorCTR {
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    /**
     * Método construtor da classe
     */
    public FornecedorCTR() {
    }

    
    
    /**
     * Método utilizado para controlar o acesso ao método inserirFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.inserirFornecedor(fornecedorDTO)) {
                return "Fornecedor Cadastrado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Cadastrado";
        }
    }//Fecha o método inserirFornecedor
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.alterarFornecedor(fornecedorDTO)) {
                return "Fornecedor Alterado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Alterado!!!";
        }
    }//Fecha o método alterarFornecedor

    
    /**
     * Método utilizado para controlar o acesso ao método excluirFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (fornecedorDAO.excluirFornecedor(fornecedorDTO)) {
                return "Fornecedor Excluído com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Excluído!!!";
        }
    }//Fecha o método excluirFornecedor

    
    /**
     * Método utilizado para controlar o acesso ao método consultarFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do fornecedor
     */
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }//Fecha o método consultarFornecedor
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
    
}//Fecha classe FornecedorCTR
