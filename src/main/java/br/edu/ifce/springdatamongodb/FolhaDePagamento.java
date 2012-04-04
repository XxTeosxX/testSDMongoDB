package br.edu.ifce.springdatamongodb;

import br.edu.ifce.springdatamongodb.dominio.Colaborador;
import br.edu.ifce.springdatamongodb.dominio.FolhaPagamento;
import br.edu.ifce.springdatamongodb.dominio.OcorrenciaFolha;
import br.edu.ifce.springdatamongodb.dominio.TipoOcorrencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class FolhaDePagamento{
	
	@Autowired
	MongoOperations mongoOperations;
	
	public void run() {
            if (mongoOperations.collectionExists(FolhaPagamento.class)) {
                mongoOperations.dropCollection(FolhaPagamento.class);
            }
            mongoOperations.createCollection(FolhaPagamento.class);
		
            // criação de objetos
            //Criando o objeto tipo data tbm é necessario o objeto dataFormat para poder passar a data recebendo de uma string.
            Date data=null;
            SimpleDateFormat dataFormat = new SimpleDateFormat("MM/yyyy", new Locale("pt", "BR"));
        
            try {
                data = dataFormat.parse("12/2012");
            }catch(ParseException ex){
                ex.getMessage();
            }
        
        
            FolhaPagamento folha = new FolhaPagamento(data);

            folha.inserirColaboradores(new Colaborador(100, "Manoel Claudino"                , "Av 13 de Maio 2081"              , "8867-1020", "Benfica"        , "60020-060" , "124543556-89"  , 4500.00f));
            folha.inserirColaboradores(new Colaborador(200, "Carmelina da Silva"             , "Avenida dos Expedicionários 1200", "3035-1280", "Aeroporto"      , "60530-020" , "301789435-54"  , 2500.00f));
            folha.inserirColaboradores(new Colaborador(300, "Gurmelina Castro e Silva"       , "Av João Pessoa 1020"             , "3235-1089", "Damas"          , "60330-090" , "50245632-76"   , 3000.00f));
            folha.inserirColaboradores(new Colaborador(400, "Joao do Espirito Renovado"      , "Av Bezerra de Menezes 1243"      , "3227-8765", "Monte castelo"  , "60650-450" , "124543556-89"  , 1200.00f));
            folha.inserirColaboradores(new Colaborador(500, "Setembrino dos Santos Cordeiro" , "Av Jovita Feitosa 810"           , "3227-3250", "Parquelandia"   , "60120-060" , "245324356-87"  , 2500.00f));                

            String msg1= "Provento",msg2="Desconto";
            for (Colaborador col : folha.getColaboradores()){
                for (int i = 0; i<10; i++){
                    if (i%2==0){
                        col.inserirOcorrencias(new OcorrenciaFolha (msg1,(int) (Math.random() * 100), TipoOcorrencia.P ));
                    }else{
                        col.inserirOcorrencias(new OcorrenciaFolha (msg2,(int) (Math.random() * 150), TipoOcorrencia.D ));
                    }
                }
            }
        
            // fim da criação de objetos

            //salvando
            mongoOperations.insert(folha);

            //pesquisa
            List <FolhaPagamento> folha_resultado = mongoOperations.findAll(FolhaPagamento.class);


            ///teste Opcional par mostrar colaboradores
            for (FolhaPagamento f: folha_resultado){
                for (Colaborador col:  f.getColaboradores()){
                    System.out.println("Colaborador : " + col);
                    col.setSalarioAtual(1000f);
                }
            }

            mongoOperations.updateFirst(new Query(Criteria.where("totalDescontos").is(0)),
		Update.update("totalDescontos", 1000000), FolhaPagamento.class);
           

         
         
         //delete
            mongoOperations.remove(folha);


            // teste para provar que deletou  
                List<FolhaPagamento> results = mongoOperations.findAll(FolhaPagamento.class);
                System.out.println("Resultados: " + results);
            }

}
