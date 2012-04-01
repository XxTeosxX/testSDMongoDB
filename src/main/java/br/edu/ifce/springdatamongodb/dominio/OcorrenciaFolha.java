/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.springdatamongodb.dominio;


public class OcorrenciaFolha{
    
    double valor;
    String descricao;
    TipoOcorrencia tipoOcorrencia;
    
    public OcorrenciaFolha(String descricao, double valor, TipoOcorrencia tipoOcorrencia) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipoOcorrencia = tipoOcorrencia;
    }


    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
        
    
}
