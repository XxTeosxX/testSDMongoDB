/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifce.springdatamongodb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main( String[] args ) {
            System.out.println("Bootstrapping Folha de Pagamento");
            ConfigurableApplicationContext context = null;
            // use @Configuration using Java:
            context = new ClassPathXmlApplicationContext("bootstrap.xml");

            // use XML application context:
            //context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");

            FolhaDePagamento folha = context.getBean(FolhaDePagamento.class);
            folha.run();
        
            System.out.println( "DONE!" );
	}
}
