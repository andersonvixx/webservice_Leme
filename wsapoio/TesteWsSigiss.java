package com.santana.easy.manager.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cadastros.nfe.NFECliente;

//import cadastros.nfe.NFECliente;

public class TesteWsSigiss {
	
	public static void main( String args[] ){
		
		final int EMITIR_NOTA = 1;
		final int IMPRESSO_PDF = 2;
		final int CANCELAR_NOTA = 3;
		final int PEGAR_XML = 4;
		final int ENVIAR_NOTA = 5;
		final int EMITIR_NOTA_XML_TEXTO = 6;
		final int EMITIR_NOTA_JSON = 7;
		final int EMITIR_NOTA_XML = 8;
		final int PEGAR_LANC_TOMADOR = 9;
		final int PEGAR_LANCS_ESCRITURADOS = 10;
		final int ENVIA_ARQUIVO_MOVIMENTO = 11;
		final int ENVIA_ARQUIVO_MOVIMENTO_XMLJSON = 12;
		final int ENVIAR_MOVIMENTO_JSON = 13;
		final int ENVIAR_MOVIMENTO_XML = 14;
		
		int opcao = 12;
		
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target("http://localhost:8081/wssigissweb");
		WebTarget resourceWebTarget = webTarget.path("rest");
		
		String login = "{ \"login\":\"00000000000000\","  +
				 "       \"senha\":\"teste\"}"; 
		
		WebTarget putWeblogin = resourceWebTarget.path("login");
		Invocation.Builder putInvocationBuilderlogin = putWeblogin.request( MediaType.APPLICATION_JSON );
		Response acesso = putInvocationBuilderlogin.post( Entity.entity( login, MediaType.APPLICATION_JSON ) );

		if ( acesso.getStatus() == 200 ) {
			
			switch ( opcao ) {
				
			case EMITIR_NOTA: 

					NFECliente nfe = new NFECliente();
		
					nfe.setCnpj_cpf_prestador( "09226398000153" ); //10897485000111
					nfe.setPessoa_destinatario( "F" );
					nfe.setCnpj_cpf_destinatario( "00796631506" );//36331782796 
					nfe.setIe_destinatario( "isento" );
					nfe.setIm_destinatario( "isento" );
					nfe.setRazao_social_destinatario( "JOSE TESTE ME" );
					nfe.setEndereco_destinatario( "R JOAO BISSOTTO FILHO" );
					nfe.setNumero_ende_destinatario( "1728" );
					nfe.setComplemento_ende_destinatario( "CASA 48" );
					nfe.setBairro_destinatario( "Ortizes" );
					nfe.setCep_destinatario( "13275410" );
					nfe.setCidade_destinatario( "Valinhos" );
					nfe.setUf_destinatario( "SP" );
					nfe.setExterior_dest( "0" );
					nfe.setPais_destinatario( "Brasil" );
					nfe.setData_emissao( "18/10/2019" );
					nfe.setforma_de_pagamento( "30 DDL" );
					nfe.setFone_destinatario( "(19) 0000-0000");
					nfe.setEmail_destinatario( "suporte@sigissweb.com" );
					nfe.setDescricao( "CAÇULA ÃÓ   \r\n" + 
							" VIDA LOCA" );
					nfe.setId_codigo_servico( "1.07" );
					nfe.setCancelada( "N" );
					nfe.setValor_inss( "N" );
					nfe.setValor_nf( "1230,75" );
					nfe.setDeducao( "0,00" );
					nfe.setValor_servico( "1230,75" );
					nfe.setAliq_iss( "2.0000000000" );
					nfe.setValor_iss( "138,87" );
					nfe.setSistema_gerador( "ATA" );
					nfe.setRps( "111" );
					nfe.setSerie_rps( "RP" );
					nfe.setIss_retido( "N" );
					nfe.setAliq_iss( "0,00" );
					nfe.setValor_iss( "0,00");
					nfe.setBc_pis( "0,00" );
					nfe.setAliq_pis( "0,00" );
					nfe.setValor_pis( "0,00" );
					nfe.setBc_cofins( "0,00" );
					nfe.setAliq_cofins( "0,00" );
					nfe.setValor_cofins( "0,00" );
					nfe.setBc_csll( "0,00" );
					nfe.setAliq_csll( "0,00" );
					nfe.setValor_csll( "0,00" );
					nfe.setBc_irrf( "0,00" );
					nfe.setAliq_irrf( "0,00" );
					nfe.setValor_irrf( "0,00" );
					nfe.setBc_inss( "0,00" );
					nfe.setAliq_inss( "0,00" );
					nfe.setValor_inss( "0,00" );
		
					// Gera o xml se caso precisar ******/
				/*	StringWriter sw = new StringWriter();
			        try {
			            JAXBContext carContext = JAXBContext.newInstance( NFECliente.class );
			            Marshaller carMarshaller = carContext.createMarshaller();
			            carMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			            carMarshaller.marshal(nfe, sw);
			            System.out.println( sw.toString() );
			        } catch (JAXBException e) {
			            throw new RuntimeException(e);
			        } */
		
					WebTarget putWeb = resourceWebTarget.path( "nfes" );
		
					Invocation.Builder putInvocationBuilder = putWeb.request( MediaType.APPLICATION_XML );
					putInvocationBuilder.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta = putInvocationBuilder.put( Entity.entity( nfe, MediaType.APPLICATION_XML ) );
		
					if ( resposta.getStatus() == 200 ) {
		
						/*NFECliente resp = resposta.readEntity( NFECliente.class );			
		
						final StringWriter out = new StringWriter();
						JAXBContext context = null;
		
						try {
		
							context = JAXBContext.newInstance( resp.getClass() );
				            Marshaller marshaller = context.createMarshaller();
				            marshaller.setProperty(
				                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
				                    Boolean.TRUE
				            );
		
				            marshaller.marshal( resp, new StreamResult( out ) );
		
						} catch (PropertyException e) {
				            e.printStackTrace();
				        } catch (JAXBException e) {
				            e.printStackTrace();
				        }*/
		
						String resp = resposta.readEntity( String.class );
						String numeronf =  resp.substring( resp.indexOf( "<numero_nf>" ) + 11, resp.indexOf( "</numero_nf>" ) );
						
						System.out.println( numeronf + "\n" + resp.toString() );
						
					}else{
						
						System.out.println( resposta.readEntity( String.class ) );
					
					}
					
					break;
					
				case EMITIR_NOTA_JSON:
					
					String str = "{\"cnpj_cpf_prestador\":\"aqui cnpj do prestador\"," +
						    "\"exterior_dest\":\"0\"," +
						    "\"cnpj_cpf_destinatario\":\"aqui cnpj do tomador\"," +
						    "\"pessoa_destinatario\":\"F\"," +
						    "\"ie_destinatario\":\"\"," +
						    "\"im_destinatario\":\"\"," +
						    "\"razao_social_destinatario\":\"JOSÉ TESTE ME\"," +
						    "\"endereco_destinatario\":\"R TESTE 2\"," +
						    "\"numero_ende_destinatario\":\"1728\"," +
						    "\"complemento_ende_destinatario\":\"CASA 248\"," +
						    "\"bairro_destinatario\":\"Ortizes\"," +
						    "\"cep_destinatario\":\"13275410\"," +
						    "\"cidade_destinatario\":\"Valinhos\"," +
						    "\"uf_destinatario\":\"SP\"," +
						    "\"pais_destinatario\":\"Brasil\"," +
						    "\"fone_destinatario\":\"(19) 0000-0000\"," +
						    "\"email_destinatario\":\"suporte@sigissweb.com\"," +
						    "\"valor_nf\":\"954,75\"," +
						    "\"deducao\":\"0,00\"," +
						    "\"valor_servico\":\"800,75\"," +
						    "\"data_emissao\":\"01/05/2019\"," +
						    "\"forma_de_pagamento\":\"\"," +
						    "\"descricao\":\"FORMATAÇÃO DE PC" +   
						    "LIMPEZA GERAL DO PC\"," +
						    "\"id_codigo_servico\":\"10.01\"," +
						    "\"cancelada\":\"N\"," +
						    "\"iss_retido\":\"N\"," +
						    "\"aliq_iss\":\"3,00\"," +
						    "\"valor_iss\":\"20,00\"," +
						    "\"bc_pis\":\"0,00\"," +
						    "\"aliq_pis\":\"0,00\"," +
						    "\"valor_pis\":\"0,00\"," +
						    "\"bc_cofins\":\"0,00\"," +
						    "\"aliq_cofins\":\"0,00\"," +
						    "\"valor_cofins\":\"0,00\"," +
						    "\"bc_csll\":\"0,00\"," +
						    "\"aliq_csll\":\"0,00\"," +
						    "\"valor_csll\":\"0,00\"," +
						    "\"bc_irrf\":\"0,00\"," +
						    "\"aliq_irrf\":\"0,00\"," +
						    "\"valor_irrf\":\"0,00\"," +
						    "\"bc_inss\":\"0,00\"," +
						    "\"aliq_inss\":\"0,00\"," +
						    "\"valor_inss\":\"0,00\"," +
						    "\"sistema_gerador\":\"Colocar o nome do seu programa\"," +
						    "\"serie_rps\":\"RP\"," +
						    "\"rps\":\"28450\"}";
					
					WebTarget putWeb7 = resourceWebTarget.path( "nfes" );
					Invocation.Builder putInvocationBuilder7 = putWeb7.request( MediaType.APPLICATION_JSON );
					//putInvocationBuilder7.header( "AUTHORIZATION", "Bearer " + acesso.readEntity( String.class ) );
					putInvocationBuilder7.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta7 = putInvocationBuilder7.post( Entity.entity( str, MediaType.APPLICATION_JSON ) );
					
					if ( resposta7.getStatus() == 200 ){
						
						String resp = resposta7.readEntity( String.class );
						String numeronf =  resp.substring( resp.indexOf( "<numero_nf>" ) + 11, resp.indexOf( "</numero_nf>" ) );
						
						System.out.println( numeronf + "\n" + resp.toString() ); 
					
					}else{
						
						System.out.println( resposta7.readEntity( String.class ) );
					
					}
					
					break;
					
				case EMITIR_NOTA_XML_TEXTO: //texto

					//StringBuilder strBuilder = new StringBuilder();
					
					//strBuilder.append(
					
					String str2 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" +
						"<notafiscal>" +
					    "<cnpj_cpf_prestador>05649712000150</cnpj_cpf_prestador>" +
					    "<exterior_dest>0</exterior_dest>" +
					    "<cnpj_cpf_destinatario>36331782796</cnpj_cpf_destinatario>" +
					    "<pessoa_destinatario>F</pessoa_destinatario>" +
					    "<ie_destinatario></ie_destinatario>" +
					    "<im_destinatario></im_destinatario>" +
					    "<razao_social_destinatario>JOÃO ALBERTO SILVA</razao_social_destinatario>" +
					    "<endereco_destinatario>R JOAO BISSOTTO FILHO</endereco_destinatario>" +
					    "<numero_ende_destinatario>1728</numero_ende_destinatario>" +
					    "<complemento_ende_destinatario>CASA 48</complemento_ende_destinatario>" +
					    "<bairro_destinatario>Ortizes</bairro_destinatario>" +
					    "<cep_destinatario>13275410</cep_destinatario>" +
					    "<cidade_destinatario>Valinhos</cidade_destinatario>" +
					    "<uf_destinatario>SP</uf_destinatario>" +
					    "<pais_destinatario>Brasil</pais_destinatario>" +
					    "<fone_destinatario>(19) 0000-0000</fone_destinatario>" +
					    "<email_destinatario>suporte@sigissweb.com</email_destinatario>" +
					    "<valor_nf>1230,75</valor_nf>" +
					    "<deducao>0,00</deducao>" +
					    "<valor_servico>1230,75</valor_servico>" +
					    "<data_emissao>29/10/2019</data_emissao>" +
					    "<forma_de_pagamento></forma_de_pagamento>" +
					    "<descricao>TESTE AÇÃO ÁGUA \r\n asçdksaçdk askdçaskdç </descricao>" +
					    "<id_codigo_servico>7.02</id_codigo_servico>" +
					    "<cancelada>N</cancelada>" +
					    "<iss_retido>N</iss_retido>" +
					    "<aliq_iss>0,00</aliq_iss>" +
					    "<valor_iss>0,00</valor_iss>" +
					    "<bc_pis>0,00</bc_pis>" +
					    "<aliq_pis>0,00</aliq_pis>" +
					    "<valor_pis>0,00</valor_pis>" +
					    "<bc_cofins>0,00</bc_cofins>" +
					    "<aliq_cofins>0,00</aliq_cofins>" +
					    "<valor_cofins>0,00</valor_cofins>" +
					    "<bc_csll>0,00</bc_csll>" +
					    "<aliq_csll>0,00</aliq_csll>" +
					    "<valor_csll>0,00</valor_csll>" +
					    "<bc_irrf>0,00</bc_irrf>" +
					    "<aliq_irrf>0,00</aliq_irrf>" +
					    "<valor_irrf>0,00</valor_irrf>" +
					    "<bc_inss>0,00</bc_inss>" +
					    "<aliq_inss>0,00</aliq_inss>" +
					    "<valor_inss>0,00</valor_inss>" +
					    "<sistema_gerador>WINSIGAA</sistema_gerador>" +
					    "<serie_rps>RP</serie_rps>" +
					    "<rps>21</rps>" +
					    "</notafiscal>";
					    //);
					
					//GenericEntity<StringBuilder> entidade2 = new GenericEntity<StringBuilder>( strBuilder ) {};
					

					WebTarget putWeb6 = resourceWebTarget.path( "nfes" );
					Invocation.Builder putInvocationBuilder6 = putWeb6.request();
					putInvocationBuilder6.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta6 = putInvocationBuilder6.post( Entity.entity( str2, MediaType.TEXT_XML ) );
					
					//WebTarget putWeb6 = resourceWebTarget.path("nfes");
					//Invocation.Builder putInvocationBuilder6 = putWeb6.request();
					//Response resposta6 = putInvocationBuilder6.put( Entity.entity( entidade, MediaType.APPLICATION_JSON_TYPE ) );

					if ( resposta6.getStatus() == 200 ) {
						
						String resp = resposta6.readEntity( String.class );
						String numeronf =  resp.substring( resp.indexOf( "<numero_nf>" ) + 11, resp.indexOf( "</numero_nf>" ) );
						
						System.out.println( numeronf + "\n" + resp.toString() );
					
					}else{
						
						System.out.println( resposta6.readEntity( String.class ) );
					
					}
					
					break;
					
				case EMITIR_NOTA_XML: //aplication XML

					//StringBuilder strBuilder = new StringBuilder();
					
					//strBuilder.append(
					
					String str3 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" +
						"<notafiscal>" +
					    "<cnpj_cpf_prestador>10663809000157</cnpj_cpf_prestador>" +
					    "<exterior_dest>0</exterior_dest>" +
					    "<cnpj_cpf_destinatario>39570134000183</cnpj_cpf_destinatario>" +
					    "<pessoa_destinatario>J</pessoa_destinatario>" +
					    "<ie_destinatario>1321</ie_destinatario>" +
					    "<im_destinatario>3423</im_destinatario>" +
					    "<razao_social_destinatario>JOÃO ALBERTO SILVA LTDA</razao_social_destinatario>" +
					    "<endereco_destinatario>R JOAO BISSOTTO FILHO</endereco_destinatario>" +
					    "<numero_ende_destinatario>1728</numero_ende_destinatario>" +
					    "<complemento_ende_destinatario>CASA 48</complemento_ende_destinatario>" +
					    "<bairro_destinatario>Ortizes</bairro_destinatario>" +
					    "<cep_destinatario>13275410</cep_destinatario>" +
					    "<cidade_destinatario>Valinhos</cidade_destinatario>" +
					    "<uf_destinatario>SP</uf_destinatario>" +
					    "<pais_destinatario>Brasil</pais_destinatario>" +
					    "<fone_destinatario>(19) 0000-0000</fone_destinatario>" +
					    "<email_destinatario>suporte@sigissweb.com</email_destinatario>" +
					    "<valor_nf>1230,75</valor_nf>" +
					    "<deducao>0,00</deducao>" +
					    "<valor_servico>1230,75</valor_servico>" +
					    "<data_emissao>01/11/2019</data_emissao>" +
					    "<forma_de_pagamento>10 ddl</forma_de_pagamento>" +
					    "<descricao>TESTE TESTE \r\n" +   
					    "BOLSA E/OU DESCONTO CONCEDIDO 0,00% - VALOR A PAGAR R$ 1.295,80</descricao>" +
					    "<id_codigo_servico>1.05</id_codigo_servico>" +
					    "<cancelada>N</cancelada>" +
					    "<iss_retido>N</iss_retido>" +
					    "<aliq_iss>0,00</aliq_iss>" +
					    "<valor_iss>0,00</valor_iss>" +
					    "<bc_pis>0,00</bc_pis>" +
					    "<aliq_pis>0,00</aliq_pis>" +
					    "<valor_pis>0,00</valor_pis>" +
					    "<bc_cofins>0,00</bc_cofins>" +
					    "<aliq_cofins>0,00</aliq_cofins>" +
					    "<valor_cofins>0,00</valor_cofins>" +
					    "<bc_csll>0,00</bc_csll>" +
					    "<aliq_csll>0,00</aliq_csll>" +
					    "<valor_csll>0,00</valor_csll>" +
					    "<bc_irrf>0,00</bc_irrf>" +
					    "<aliq_irrf>0,00</aliq_irrf>" +
					    "<valor_irrf>0,00</valor_irrf>" +
					    "<bc_inss>0,00</bc_inss>" +
					    "<aliq_inss>0,00</aliq_inss>" +
					    "<valor_inss>0,00</valor_inss>" +
					    "<sistema_gerador>sigissweb</sistema_gerador>" +
					    "<serie_rps>RP</serie_rps>" +
					    "<rps>12</rps>" +
					    "</notafiscal>";
					    //);
					
					//GenericEntity<StringBuilder> entidade2 = new GenericEntity<StringBuilder>( strBuilder ) {};
					

					WebTarget putWeb9 = resourceWebTarget.path( "nfes" );
					Invocation.Builder putInvocationBuilder9 = putWeb9.request();
					putInvocationBuilder9.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta9 = putInvocationBuilder9.post( Entity.entity( str3, MediaType.APPLICATION_XML ) );
					
					//WebTarget putWeb6 = resourceWebTarget.path("nfes");
					//Invocation.Builder putInvocationBuilder6 = putWeb6.request();
					//Response resposta6 = putInvocationBuilder6.put( Entity.entity( entidade, MediaType.APPLICATION_JSON_TYPE ) );

					if ( resposta9.getStatus() == 200 ) {
						
						String resp = resposta9.readEntity( String.class );
						String numeronf =  resp.substring( resp.indexOf( "<numero_nf>" ) + 11, resp.indexOf( "</numero_nf>" ) );
						
						System.out.println( numeronf + "\n" + resp.toString() );
					
					}else{
						
						System.out.println( resposta9.readEntity( String.class ) );
					
					}
					
					break;
				
				case IMPRESSO_PDF: 

					WebTarget getWeb = resourceWebTarget.path( "nfes/nfimpressa/4/serie/E" );
					Invocation.Builder getInvocationBuilder = getWeb.request();
					getInvocationBuilder.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta2 = getInvocationBuilder.get();

					if ( resposta2.getStatus() == 200 ) {

						File res = resposta2.readEntity( File.class );

						File downloadfile = new File( "f:/" + resposta2.getHeaderString( "Content-Disposition" ) );  
						res.renameTo( downloadfile );

						FileWriter fr;

						try {

							fr = new FileWriter( res );
							fr.flush();

						} catch (IOException e) {
							e.printStackTrace();
						}

					}else{
						
						System.out.println( resposta2.readEntity( String.class ) );
					
					}
					
					break;
					
				case CANCELAR_NOTA:
					
					WebTarget getWeb2 = resourceWebTarget.path( "nfes/cancela/2/serie/NFD/motivo/\"teste\"" );
					Invocation.Builder getInvocationBuilder2 = getWeb2.request();
					getInvocationBuilder2.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta3 = getInvocationBuilder2.get();

					if ( resposta3.getStatus() == 200 ) {
						
						System.out.println( resposta3.readEntity( String.class ) );
						
						
					}else{
						
						System.out.println( resposta3.readEntity( String.class ) );
					
					}
					
					break;
					
				case PEGAR_XML:
					
					WebTarget getWeb3 = resourceWebTarget.path( "nfes/pegaxml/10707/serierps/NFS" );
					Invocation.Builder getInvocationBuilder3 = getWeb3.request();
					getInvocationBuilder3.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta4 = getInvocationBuilder3.get();

					if ( resposta4.getStatus() == 200 ) {
						
						System.out.println( resposta4.readEntity( String.class ) );
						
						
					}else{
						
						System.out.println( resposta4.readEntity( String.class ) );
					
					}
					
					break;
					
				case ENVIAR_NOTA:
					
					WebTarget getWeb4 = resourceWebTarget.path( "nfes/envianf/73/serie/E/comcopiaprestador/N" );
					Invocation.Builder getInvocationBuilder4 = getWeb4.request();
					getInvocationBuilder4.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta5 = getInvocationBuilder4.get();

					if ( resposta5.getStatus() == 200 ) {
						
						System.out.println( resposta5.readEntity( String.class ) );
						
					}else{
						
						System.out.println( resposta5.readEntity( String.class ) );
					
					}
					
					break;
				
				case PEGAR_LANC_TOMADOR:
					
					WebTarget getWeb5 = resourceWebTarget.path( "lancamentos/pegaservicostomados/05261176000110/mes/10/ano/2017" );
					Invocation.Builder getInvocationBuilder5 = getWeb5.request();
					getInvocationBuilder5.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta8 = getInvocationBuilder5.get();

					if ( resposta8.getStatus() == 200 ) {
						
						System.out.println( resposta8.readEntity( String.class ) );
						
					}else{
						
						System.out.println( resposta8.readEntity( String.class ) );
					
					}
					
					break;
					
				case PEGAR_LANCS_ESCRITURADOS:
					
					WebTarget getWeb6 = resourceWebTarget.path( "lancamentos/pegalancamentosescriturados/05261176000110/mes/10/ano/2017/tipo/P" );
					Invocation.Builder getInvocationBuilder6 = getWeb6.request();
					getInvocationBuilder6.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					Response resposta10 = getInvocationBuilder6.get();

					if ( resposta10.getStatus() == 200 ) {
						
						System.out.println( resposta10.readEntity( String.class ) );
						
					}else{
						
						System.out.println( resposta10.readEntity( String.class ) );
					
					}
					
					break;
					
				case ENVIA_ARQUIVO_MOVIMENTO:
					
					String caminhoArquivo = "f:" + File.separator + "100.txt"; 
					File novoArquivo = new File(caminhoArquivo); 
					FileInputStream arq = null;
					
					try {
						arq = new FileInputStream(novoArquivo);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					WebTarget getWeb14 = resourceWebTarget.path( "lancamentos" );
					Invocation.Builder getInvocationBuilder14 = getWeb14.request();
					getInvocationBuilder14.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta11 = getInvocationBuilder14.put( Entity.entity( arq, MediaType.TEXT_PLAIN ) );

					if ( resposta11.getStatus() == 200 ) {
						
						System.out.println( resposta11.readEntity( String.class ) );
						
					}else{
						
						System.out.println( resposta11.readEntity( String.class ) );
					
					}
					
					break;
					
				case ENVIA_ARQUIVO_MOVIMENTO_XMLJSON:
					
					//String caminhoArquivo2 = "C:\\Users\\REGINALDO\\Desktop\\LANCAMENTOS_LOTE_20210621032437.xml"; 
					String caminhoArquivo2 = "C:\\Users\\REGINALDO\\Desktop\\MOVIMENTACAO.JSON";
					File novoArquivo2 = new File( caminhoArquivo2 ); 
					FileInputStream arq2 = null;
					
					try {
						arq2 = new FileInputStream( novoArquivo2 );
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					WebTarget getWeb7 = resourceWebTarget.path( "lancamentos" );
					Invocation.Builder getInvocationBuilder7 = getWeb7.request();
					getInvocationBuilder7.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta14 = getInvocationBuilder7.post( Entity.entity( arq2, MediaType.APPLICATION_XML + "; CHARSET=ISO-8859-1" ) );

					if ( resposta14.getStatus() == 200 ) {
						
						System.out.println( resposta14.readEntity( String.class ) );
						
					}else{
						
						System.out.println( resposta14.readEntity( String.class ) );
					
					}
					
					break;
					
				case ENVIAR_MOVIMENTO_JSON: //aplication JSON
					
					String str4 = "{" +
								      "\"LANCAMENTOS\": { " +
									    "\"DECLARANTE\": { " +
									        "\"CNPJ_CPF_DECL\": \"19383614000128\", " +
									        "\"NOME_DECL\": \"RODA PESADA MANUTENCAO DE SISTEMAS E EQUIPAMENTOS LTDA EPP\", "+
									        "\"NOME_FANTASIA_DECL\": \"RODA PESADA\", " +
									        "\"ENDERECO_DECL\": \"RUA JORGE MEDEIROS\", " +
									        "\"NUMERO_ENDE_DECL\": \"362\", " +
									        "\"COMPLEMENTO_DECL\": \"\", " +
									        "\"BAIRRO_DECL\": \"LOTEAMENTO INDUSTRIAL\", " +
									        "\"CIDADE_DECL\": \"Sumaré\", " +
									        "\"UF_DECL\": \"SP\", " + 
									        "\"CEP_DECL\": \"13178542\", " +
									        "\"IE_DECL\": \"111211212121\", " +
									        "\"IM_DECL\": \"43211212\", " +
									        "\"EMAIL_DECL\": \"teste@teste.com.br\", " +
									        "\"FONE_DECL\": \"(19) 0000-0000\" " +
									      "}, " +
									      "\"LANCAMENTO\": [ " +
									      "   { " +
									            "\"DESTINATARIO\": { " +
												   "\"CNPJ_CPF_DEST\": \"65445329000101\", " +
												   "\"NOME_DEST\": \"MARTINS LIVE ME\", " +
												   "\"IE_DEST\": \"222211112222\", " +
												   "\"IM_DEST\": \"1111222\", " +
												   "\"ENDERECO_DEST\": \"RUA RIO DAS PARDO\", " +
												   "\"NUMERO_DEST\": \"125\", " +
												   "\"COMPLEMENTO_DEST\": \"\", " +
												   "\"FONE_DEST\": \"(19) 0000-0000\", " +
												   "\"CEP_DEST\": \"13050000\", " +
												   "\"ESTRANGEIRO\": \"0\", " +
												   "\"BAIRRO_DEST\": \"JARDIM DO TREVO\", " +
												   "\"CIDADE_DEST\": \"Campinas\", " +
												   "\"UF_DEST\": \"SP\", " +
												   "\"PAIS_DEST\": \"Brasil\", " +
												   "\"EMAIL_DEST\": \"\" " +
									            "}," +
									            "\"TOMAPREST\": \"T\", " +
									            "\"REGIME\": \"O\", " +
									            "\"MES\": \"12\", " +
									            "\"ANO\": \"2021\", " +
									            "\"MOVIMENTO\": \"S\", " +
 									            "\"NUM_DOCU_FISCAL\": \"3567\", " +
									            "\"SERIE_DOCU_FISCAL\": \"U\", " +
									            "\"DATA\": \"01/12/2021\", " +
									            "\"CANCELADA\": \"N\", " +
									            "\"VALOR_DOCU_FISCAL\": \"254,0000\", " +
									            "\"DEDUCOES_LEGAIS\": \"0,0000\", " +
									            "\"VALOR_SERVICOS\": \"254,0000\", " +
									            "\"ALIQUOTA\": \"0,0000000000\", " +
									            "\"VALOR_IMPOSTO\": \"0,0000\", " +
									            "\"RETENCAO\": \"N\", " +
									            "\"ID_CODIGO_SERVICO\": \"14.01\" " +
									         "}," +
									         "{" +
									            "\"DESTINATARIO\": { " +
									               "\"CNPJ_CPF_DEST\": \"79406684000186\", " +
									               "\"NOME_DEST\": \"SINCE MULTIMIDIA ME\", " +
									               "\"IE_DEST\": \"\", " +
									               "\"IM_DEST\": \"12456\", " +
									               "\"ENDERECO_DEST\": \"RUA SÃO PAULO\", " +
									               "\"NUMERO_DEST\": \"325\", " +
									               "\"COMPLEMENTO_DEST\": \"\", " +
									               "\"FONE_DEST\": \"\", " +
									               "\"CEP_DEST\": \"13180000\", " +
									               "\"ESTRANGEIRO\": \"0\", " +
									               "\"BAIRRO_DEST\": \"JARDIM RESIDENCIAL MONTE BELO\", " +
									               "\"CIDADE_DEST\": \"Hortolândia\", " +
									               "\"UF_DEST\": \"SP\", " +
									               "\"PAIS_DEST\": \"Brasil\", " +
									               "\"EMAIL_DEST\": \"\" " +
									            "}," +
									            "\"TOMAPREST\": \"T\", " +
									            "\"REGIME\": \"O\", " +
									            "\"MES\": \"12\", " +
									            "\"ANO\": \"2021\", " +
									            "\"MOVIMENTO\": \"S\", " +
									            "\"NUM_DOCU_FISCAL\": \"1781\", " +
									            "\"SERIE_DOCU_FISCAL\": \"U\", " +
									            "\"DATA\": \"07/12/2021\", " +
									            "\"CANCELADA\": \"N\", " +
									            "\"VALOR_DOCU_FISCAL\": \"1456,5500\", " +
									            "\"DEDUCOES_LEGAIS\": \"0,0000\", " +
									            "\"VALOR_SERVICOS\": \"1456,5500\", " +
									            "\"ALIQUOTA\": \"0,0000000000\", " +
									            "\"VALOR_IMPOSTO\": \"0,0000\", " +
									            "\"RETENCAO\": \"N\", " +
									            "\"ID_CODIGO_SERVICO\": \"7.02\" " +
									         "} " +									         
									      "]" +
									   "}" +
									"}";
					
					WebTarget putWeb12 = resourceWebTarget.path( "lancamentos" );
					Invocation.Builder putInvocationBuilder12 = putWeb12.request();
					putInvocationBuilder12.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta12 = putInvocationBuilder12.post( Entity.entity( str4, MediaType.APPLICATION_JSON + "; CHARSET=ISO-8859-1" ) );
					
					if ( resposta12.getStatus() == 200 ) {
						
						System.out.println( resposta12.readEntity( String.class ) );
					
					}else{
						
						System.out.println( resposta12.readEntity( String.class ) );
					
					}
					
					break;
					
				case ENVIAR_MOVIMENTO_XML: //aplication XML
					
					StringBuilder str5 = new StringBuilder();
					
					str5.append( "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" +
								"<LANCAMENTOS> " +
								"  <DECLARANTE> " +
								"      <CNPJ_CPF_DECL>19383614000128</CNPJ_CPF_DECL> " +
								"      <NOME_DECL>RODA PESADA MANUTENCAO DE SISTEMAS E EQUIPAMENTOS LTDA EPP</NOME_DECL> " +
								"      <NOME_FANTASIA_DECL>RODA PESADA</NOME_FANTASIA_DECL> " +
								"      <ENDERECO_DECL>RUA JORGE MEDEIROS</ENDERECO_DECL> " +
								"      <NUMERO_ENDE_DECL>362</NUMERO_ENDE_DECL> " +
								"      <COMPLEMENTO_DECL/> " +
								"      <BAIRRO_DECL>LOTEAMENTO INDUSTRIAL</BAIRRO_DECL> " +
								"      <CIDADE_DECL>Sumaré</CIDADE_DECL> " +
								"      <UF_DECL>SP</UF_DECL> " +
								"      <CEP_DECL>13170000</CEP_DECL> " +
								"      <IE_DECL>111211212121</IE_DECL> " +
								"      <IM_DECL>43211212</IM_DECL> " +
								"      <EMAIL_DECL>teste@teste.com.br</EMAIL_DECL> " +
								"      <FONE_DECL>(19) 0000-0000</FONE_DECL> " +
								"  </DECLARANTE> " +	
								"  <LANCAMENTO> " +
								"    <DESTINATARIO> " +
								"      <CNPJ_CPF_DEST>65445329000101</CNPJ_CPF_DEST> " +
								"      <NOME_DEST>MARTINS LIVE ME</NOME_DEST> " +
								"      <IE_DEST>222211112222</IE_DEST> " +
								"      <IM_DEST>1111222</IM_DEST> " +
								"      <ENDERECO_DEST>RUA RIO DAS PARDO</ENDERECO_DEST> " +
								"      <NUMERO_DEST>125</NUMERO_DEST> " +
								"      <COMPLEMENTO_DEST /> " +
								"      <FONE_DEST>(19) 0000-0000</FONE_DEST> " +
								"      <CEP_DEST>13050000</CEP_DEST> " +
								"      <ESTRANGEIRO>0</ESTRANGEIRO> " +
								"      <BAIRRO_DEST>JARDIM DO TREVO</BAIRRO_DEST> " +
								"      <CIDADE_DEST>Campinas</CIDADE_DEST> " +
								"      <UF_DEST>SP</UF_DEST> " +
								"      <PAIS_DEST>Brasil</PAIS_DEST> " +
								"      <EMAIL_DEST /> " +
								"    </DESTINATARIO> " +
								"    <TOMAPREST>T</TOMAPREST> " +
								"    <REGIME>O</REGIME> " +
								"    <MES>12</MES> " +
								"    <ANO>2021</ANO> " +
								"    <MOVIMENTO>S</MOVIMENTO> " +
								"    <NUM_DOCU_FISCAL>3567</NUM_DOCU_FISCAL> " +
								"    <SERIE_DOCU_FISCAL>U</SERIE_DOCU_FISCAL> " +
								"    <DATA>01/12/2021</DATA> " +
								"    <CANCELADA>N</CANCELADA> " +
								"    <VALOR_DOCU_FISCAL>254,0000</VALOR_DOCU_FISCAL> " +
								"    <DEDUCOES_LEGAIS>0,0000</DEDUCOES_LEGAIS> " +
								"    <VALOR_SERVICOS>254,0000</VALOR_SERVICOS> " +
								"    <ALIQUOTA>0,0000000000</ALIQUOTA> " +
								"    <VALOR_IMPOSTO>0,0000</VALOR_IMPOSTO> " +
								"    <RETENCAO>N</RETENCAO> " +
								"    <ID_CODIGO_SERVICO>14.01</ID_CODIGO_SERVICO> " +
								"  </LANCAMENTO> " +
								"  <LANCAMENTO> " +
								"  	 <DESTINATARIO> " +
								"        <CNPJ_CPF_DEST>79406684000186</CNPJ_CPF_DEST> " +
								"        <NOME_DEST>SINCE MULTIMIDIA ME</NOME_DEST> " +
								"        <IE_DEST /> " +
								"        <IM_DEST>12456</IM_DEST> " +
								"        <ENDERECO_DEST>RUA SÃO PAULO</ENDERECO_DEST> " +
								"        <NUMERO_DEST>325</NUMERO_DEST> " +
								"        <COMPLEMENTO_DEST /> " +
								"        <FONE_DEST /> " +
								"        <CEP_DEST>13180000</CEP_DEST> " +
								"        <ESTRANGEIRO>0</ESTRANGEIRO> " +
								"        <BAIRRO_DEST>JARDIM RESIDENCIAL MONTE BELO</BAIRRO_DEST> " +
								"        <CIDADE_DEST>Hortolândia</CIDADE_DEST> " +
								"        <UF_DEST>SP</UF_DEST> " +
								"        <PAIS_DEST>Brasil</PAIS_DEST> " +
								"        <EMAIL_DEST /> " +
								"      </DESTINATARIO> " +
								"    <TOMAPREST>T</TOMAPREST> " +
								"    <REGIME>O</REGIME> " +
								"    <MES>12</MES> " +
								"    <ANO>2021</ANO> " +
								"    <MOVIMENTO>S</MOVIMENTO> " +
								"    <NUM_DOCU_FISCAL>1781</NUM_DOCU_FISCAL> " +
								"    <SERIE_DOCU_FISCAL>U</SERIE_DOCU_FISCAL> " +
								"    <DATA>07/12/2021</DATA> " +
								"    <CANCELADA>N</CANCELADA> " +
								"    <VALOR_DOCU_FISCAL>1456,5500</VALOR_DOCU_FISCAL> " +
								"    <DEDUCOES_LEGAIS>0,0000</DEDUCOES_LEGAIS> " +
								"    <VALOR_SERVICOS>1456,5500</VALOR_SERVICOS> " +
								"    <ALIQUOTA>0,0000000000</ALIQUOTA> " +
								"    <VALOR_IMPOSTO>0,0000</VALOR_IMPOSTO> " +
								"    <RETENCAO>N</RETENCAO> " +
								"    <ID_CODIGO_SERVICO>7.02</ID_CODIGO_SERVICO> " +
								"  </LANCAMENTO> " +  
								"</LANCAMENTOS>" ); 
							
					WebTarget putWeb13 = resourceWebTarget.path( "lancamentos" );
					Invocation.Builder putInvocationBuilder13 = putWeb13.request();
					putInvocationBuilder13.header( "AUTHORIZATION", acesso.readEntity( String.class ) );
					
					Response resposta13 = putInvocationBuilder13.post( Entity.entity( str5.toString(), MediaType.APPLICATION_XML) );
					
					if ( resposta13.getStatus() == 200 ) {
						
						System.out.println( resposta13.readEntity( String.class ) );
					
					}else{
						
						System.out.println( resposta13.readEntity( String.class ) );
					
					} 
					
					break;
					
				} // fim switch
			
		}else{
			
			System.out.println( acesso.readEntity( String.class ) );
		
		}

	} 

}
