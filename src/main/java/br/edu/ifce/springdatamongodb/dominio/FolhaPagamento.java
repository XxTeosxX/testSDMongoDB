/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.springdatamongodb.dominio;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FolhaPagamento {
	
	@Id
    private String id;
	
    private float totalDescontos;
    private float totalProventos;
    private Date data;
    
    ArrayList<OcorrenciaFolha> ocorrencias = new ArrayList<OcorrenciaFolha>(); 
    ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    
    public FolhaPagamento(){
    	super();
    }
    
    public FolhaPagamento(Date data){
    	this.data = data;
    }
    
    public FolhaPagamento(Date data, ArrayList<Colaborador> colaboradores){
        this.data = data;
        this.colaboradores = colaboradores;	
    }
    
    //Fim dos contrutores
    

    
    public void inserirColaboradores(Colaborador colaborador) {
        this.colaboradores.add(colaborador);
    }
    
    public void inserirOcorrencias(OcorrenciaFolha ocorrencia) {
        this.ocorrencias.add(ocorrencia);
    }
    
    //fim dos inserir
    
    public ArrayList<Colaborador> getColaboradores (){
        return colaboradores;
    }
    
    public ArrayList<OcorrenciaFolha> getOcorrencias (){
        return ocorrencias;
    }

    public Date getData() {
        return data;
    }
    

    public double getTotalDescontos() {
        return totalDescontos;
    }

    public double getTotalProventos() {
        return totalProventos;
    }
    
    public String getID(){
    	return id;
    }
    
    // fim gets

    public void setData( Date data) {
        this.data = data;
    }

    public void setTotalDescontos(float totalDescontos) {
        this.totalDescontos = totalDescontos;
    }

    public void setTotalProventos(float totalProventos) {
        this.totalProventos = totalProventos;
    }
    
    public void setId(String id){
    	this.id= id;
    }
    
    public void setOcorrencias (    ArrayList<OcorrenciaFolha> ocorrencias ){
    	this.ocorrencias = ocorrencias;
    	
    }
    
    public void setColaboradores ( ArrayList<Colaborador> colaboradores  ){
    	this.colaboradores = colaboradores;
    	
    }
    
    //fim sets
        
}
