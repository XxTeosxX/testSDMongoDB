/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.springdatamongodb.dominio;


import java.util.ArrayList;


public class Colaborador {
    
    private int codigo;
    private String nome,endereco,telefone,bairro,cep,cpf;
    float salarioAtual;
    
    ArrayList<OcorrenciaFolha> listaOcorrencia = new ArrayList<OcorrenciaFolha>();
    
    public Colaborador(){
        super();
    }
    
    public Colaborador(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        
    }
    
    public Colaborador(int codigo, String nome, String endereco, String telefone, String bairro, String cep, String cpf, float salarioAtual) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cep = cep;
        this.cpf = cpf;
        this.salarioAtual = salarioAtual;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioAtual() {
        return salarioAtual;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public ArrayList<OcorrenciaFolha> getListaOcorrencia (){
    	return listaOcorrencia ;
    	
    } 
    //fim gets

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioAtual(float salarioAtual) {
        this.salarioAtual = salarioAtual;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setOcorrencias (ArrayList<OcorrenciaFolha> listaOcorrencia ){
    	this.listaOcorrencia = listaOcorrencia ; 
    	
    }
    
    //fim dos sets
    
    
    public void inserirOcorrencias(OcorrenciaFolha ocorrencia) {
        listaOcorrencia.add(ocorrencia);
   }
    
    @Override
	public String toString() {
		return "Colaborador [id=" + codigo + ", name=" + nome + ", CPF=" + cpf
				+ ", endereco=" + endereco + ", telefone=" + telefone 
				+ ", bairro=" + bairro + ", CEP=" + cep
				+ ", ocorrencias=" + listaOcorrencia + "]";
	}
        
}
