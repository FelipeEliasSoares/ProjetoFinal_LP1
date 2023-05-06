package br.com.projeto_final.ctr;
/**
 *
 * @author Andre Luis Gobbi Primo/Ivan Oliveira Lopes
 */

import java.sql.ResultSet;
import br.com.projeto_final.dto.FornecedorDTO;
import br.com.projeto_final.dto.MaterialDTO;
import br.com.projeto_final.dao.MaterialDAO;
import br.com.projeto_final.dao.ConexaoDAO;

public class MaterialCTR {
    
    MaterialDAO materialDAO = new MaterialDAO();
    
    /**
     * Método construtor da classe
     */
    public MaterialCTR() {
    }

    
    
    public String inserirMaterial(MaterialDTO materialDTO, FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (materialDAO.inserirMaterial(materialDTO, fornecedorDTO)) {
                return "Material Cadastrado com Sucesso!!!";
            } else {
                return "Material NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Material NÃO Cadastrado";
        }
    }//Fecha o método inserirProduto
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarProduto da
 classe MaterialDAO
     * @param produtoDTO, que vem da classe da página (VIEW)
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarMaterial(MaterialDTO materialDTO, FornecedorDTO fornecedorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (materialDAO.alterarMaterial(materialDTO, fornecedorDTO)) {
                return "Material Alterado com Sucesso!!!";
            } else {
                return "Material NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Material NÃO Alterado!!!";
        }
    }//Fecha o método alterarProduto

    
    /**
     * Método utilizado para controlar o acesso ao método excluirProduto da
 classe MaterialDAO
     * @param produtoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirMaterial(MaterialDTO materialDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (materialDAO.excluirMaterial(materialDTO)) {
                return "Material Excluído com Sucesso!!!";
            } else {
                return "Material NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Excluído!!!";
        }
    }//Fecha o método excluirProduto

    
    /**
     * Método utilizado para controlar o acesso ao método consultarProduto da
 classe MaterialDAO
     * @param produtoDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do produto e fornecedor
     */
    public ResultSet consultarMaterial(MaterialDTO materialDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = materialDAO.consultarMaterial(materialDTO, opcao);
        return rs;
    }//Fecha o método consultarProduto
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
    
}//Fecha classe ProdutoCTR
