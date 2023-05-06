package br.com.projeto_final.dto;

public class MaterialDTO {
    private String nome_material, desc_material, cod_bar_material;
    private double p_custo_material;
    private int id_material;

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }
    
    public String getNome_material() {
        return nome_material;
    }

    public void setNome_material(String nome_material) {
        this.nome_material = nome_material;
    }

    public String getDesc_material() {
        return desc_material;
    }

    public void setDesc_material(String desc_material) {
        this.desc_material = desc_material;
    }

    public String getCod_bar_material() {
        return cod_bar_material;
    }

    public void setCod_bar_material(String cod_bar_material) {
        this.cod_bar_material = cod_bar_material;
    }

    public double getP_custo_material() {
        return p_custo_material;
    }

    public void setP_custo_material(double p_custo_material) {
        this.p_custo_material = p_custo_material;
    }



      
}
