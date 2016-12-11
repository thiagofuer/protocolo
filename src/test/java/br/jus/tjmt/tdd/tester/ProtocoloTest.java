package br.jus.tjmt.tdd.tester;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import br.jus.tjmt.controller.rest.ProtocoloController;
import br.jus.tjmt.controller.rest.model.ProtocoloResponse;
import br.jus.tjmt.tdd.WeldJUnit4Runner;
import br.jus.tjmt.tdd.dao.util.GsonUtil;
import br.jus.tjmt.tdd.dao.util.HttpUtil;

@RunWith(WeldJUnit4Runner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProtocoloTest {

	private HttpClient httpClient = HttpClientBuilder.create().build();
	private HttpUtil httpUtil = new HttpUtil();
	
	@Test
	public void a_listagemComarca(){
		try {
			HttpGet request = httpUtil.getNewJsonHttpGet(ProtocoloController.class, "listarTodasComarcas");
			HttpResponse response = httpClient.execute(request);
			httpUtil.printResponse(response);
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		} catch (IOException e) {
			System.out.println("Erro ws listarTodasComarcas");
		}
	}

	@Test
	public void b_listagemClasseProcessual(){
		try {
			HttpGet request = httpUtil.getNewJsonHttpGet(ProtocoloController.class, "listarTodasClassesProcessuais");
			HttpResponse response = httpClient.execute(request);
			httpUtil.printResponse(response);
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		} catch (IOException e) {
			System.out.println("Erro ws listarTodasClassesProcessuais");
		}
	}
	
	@Test
	public void c_testeProtocoloValido(){
		try {
			HttpPost request = httpUtil.getNewJsonHttpPost(ProtocoloController.class, "protocolar/1/1");
			HttpResponse response = httpClient.execute(request);
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
			String responseJson = httpUtil.parseResponseToString(response);
			ProtocoloResponse protocoloResponse = GsonUtil.getJsonSerializer().fromJson(responseJson, ProtocoloResponse.class);
			Assert.assertTrue(protocoloResponse.isDistribuicaoRealizada());
			System.out.println("processo protocoloado na vara:"+protocoloResponse.getNomeVara()+" e numero: "+protocoloResponse.getNumeroUnico());
			
		} catch (IOException e) {
			System.out.println("Erro ws protocolar valido");
		}
	}	
	
	/**
	 * 
	 * Tenta protocolar um processo em uma comarca inválida e checa se o sistema esta tratando
	 */
	@Test
	public void d_testeProtocoloInValido(){
		try {
			HttpPost request = httpUtil.getNewJsonHttpPost(ProtocoloController.class, "protocolar/666/666");
			HttpResponse response = httpClient.execute(request);
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
			String responseJson = httpUtil.parseResponseToString(response);
			ProtocoloResponse protocoloResponse = GsonUtil.getJsonSerializer().fromJson(responseJson, ProtocoloResponse.class);
			Assert.assertFalse(protocoloResponse.isDistribuicaoRealizada());
		} catch (IOException e) {
			System.out.println("Erro ws protocolar invalido");
		}
	}
	
}
