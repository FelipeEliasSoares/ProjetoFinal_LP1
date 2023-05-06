/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_final.dto;


/**
 *
 * @author Aluno
 */
public class MarcineiroDTO {
    private String nome_mar, cpf_mar, tel_mar;
    private int id_mar;

    public int getId_mar() {
        return id_mar;
    }

    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    public String getNome_mar() {
        return nome_mar;
    }

    public void setNome_mar(String nome_mar) {
        this.nome_mar = nome_mar;
    }

    public String getCpf_mar() {
        return cpf_mar;
    }

    public void setCpf_mar(String cpf_mar) {
        this.cpf_mar = cpf_mar;
    }

    public String getTel_mar() {
        return tel_mar;
    }

    public void setTel_mar(String tel_mar) {
        this.tel_mar = tel_mar;
    }

}
