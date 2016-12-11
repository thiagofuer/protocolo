package br.jus.tjmt.tdd.tester;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import br.jus.tjmt.controller.rest.ProtocoloController;
import br.jus.tjmt.tdd.WeldJUnit4Runner;
import br.jus.tjmt.tdd.dao.util.HttpUtil;

@RunWith(WeldJUnit4Runner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProtocoloTest {

	private HttpClient httpClient = HttpClientBuilder.create().build();
	private HttpUtil httpUtil = new HttpUtil();
	
	@Test
	public void a_listagemComarca(){
		try {
			System.out.println("listagem");
			HttpGet request = httpUtil.getNewJsonHttpGet(ProtocoloController.class, "listarTodasComarcas");
			HttpResponse response = httpClient.execute(request);
			httpUtil.printResponse(response);
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		} catch (IOException e) {
			System.out.println("Erro ws listarTodasPessoa");
		}
	}
	
}
