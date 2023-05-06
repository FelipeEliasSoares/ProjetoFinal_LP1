/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_final.ctr;


import br.com.projeto_final.dao.ConexaoDAO;
import br.com.projeto_final.dao.ProjetoDAO;
import br.com.projeto_final.dto.MarcineiroDTO;
import br.com.projeto_final.dto.ProjetoDTO;
import br.com.projeto_final.dto.MaterialDTO;
import java.sql.ResultSet;
import javax.swing.JTable;
/**
 *
 * @author Felipe
 */
public class ProjetoCTR {
    ProjetoDAO projetoDAO = new ProjetoDAO();
    
    public ProjetoCTR(){
    
    }
    
    
    public String inserirProjeto(ProjetoDTO projetoDTO, MarcineiroDTO marceneiroDTO, JTable material){
        try {
            if(projetoDAO.inserirProjeto(projetoDTO, marceneiroDTO, material)){
                return "Projeto Cadastrada com Sucesso!!!";
            }else{
                return "Projeto NÂO Cadastrada!!!";
            }
            
        }//fecha try 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Projeto NÂO Cadastrada";
        }
    }//Fecha o metodo inserirVenda
    
    
    public String  AlterarProjeto(ProjetoDTO projetoDTO, MarcineiroDTO marceneiroDTO, JTable material){
        try {
            if(projetoDAO.inserirProjeto(projetoDTO, marceneiroDTO, material)){
                return "Projeto Alterado com Sucesso!!!";
            }else{
                return "Projeto NÂO Alterado!!!";
            }
            
        }//fecha try 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Projeto NÂO Alterado";
        }
    }//Fecha o metodo inserirVenda
    
    
    //public String excluirProjeto(ProjetoDTO projetoDTO) {
        //try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            //if (projetoDAO.excluirProjeto(projetoDTO)) {
                //return "Projeto Excluído com Sucesso!!!";
            //} else {
                //return "Projeto NÃO Excluído!!!";
            //}
        //} //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        //catch (Exception e) {
            //System.out.println(e.getMessage());
            //return "Projeto NÃO Excluído!!!";
        //}
    //}//Fecha o método excluirProjeto
    
    
    public ResultSet consultarProjeto(ProjetoDTO projetoDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = projetoDAO.consultarProjeto(projetoDTO, opcao);
        return rs;
    }//Fecha o método consultarProduto
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//fecha closeDB
}
