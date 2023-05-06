/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_final.dto;

/**
 *
 * @author Felipe
 */
public class ProjetoDTO {
        private int id_proj;
        private int id_material;
        private String nome_proj;
        private String descricao_proj;

        public int getId_proj() {
            return id_proj;
        }

        public void setId_proj(int id_proj) {
            this.id_proj = id_proj;
        }

        public int getId_material() {
            return id_material;
        }

        public void setId_material(int id_material) {
            this.id_material = id_material;
        }

        public String getNome_proj() {
            return nome_proj;
        }

        public void setNome_proj(String nome_proj) {
            this.nome_proj = nome_proj;
        }

        public String getDescricao_proj() {
            return descricao_proj;
        }

        public void setDescricao_proj(String descricao_proj) {
            this.descricao_proj = descricao_proj;
        }

}
