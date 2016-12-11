package br.jus.tjmt.tdd.dao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.BasicResponseHandler;

public class HttpUtil {
	
	private ResponseHandler<String> handler = new BasicResponseHandler();
	
	private String protocolo = "http";
	private String host = "localhost";
	private String porta = "8080";
	private String appName = "protocolo";
	private String applicationPath = "ws"; 
	private final StringBuilder webServiceURL = new StringBuilder(); //Stringbuilder para concatenar as strings que montam o endereço do Webservice a ser chamado
	
	public HttpUtil(){
		webServiceURL.append(protocolo).append("://").append(host).append(":").append(porta).append("/").append(appName).append("/").append(applicationPath);
	}
	
	private String getRequestURL(Class<?> resourceClass, final String methodName){
		StringBuilder url = new StringBuilder( webServiceURL.toString() );
		String resourcePath = resourceClass.getAnnotation(javax.ws.rs.Path.class).value();
		url.append("/").append(resourcePath).append("/").append( methodName );
		System.out.println(url);
		return url.toString(); 
	}

	
	public HttpPost getNewJsonHttpPost(Class<?> resourceClass,  final String methodName){
		HttpPost request = new HttpPost(getRequestURL(resourceClass, methodName));
		request.addHeader("content-type", MediaType.APPLICATION_JSON);
		return request;
	}

	public HttpGet getNewJsonHttpGet(Class<?> resourceClass,  final String methodName){
		HttpGet request = new HttpGet(getRequestURL(resourceClass, methodName));
		request.addHeader("content-type", MediaType.APPLICATION_JSON);
		return request;
	}

	public HttpPut getNewJsonHttpPut(Class<?> resourceClass,  final String methodName){
		HttpPut request = new HttpPut(getRequestURL(resourceClass, methodName));
		request.addHeader("content-type", MediaType.APPLICATION_JSON);
		return request;
	}

	public HttpDelete getNewJsonHttpDelete(Class<?> resourceClass,  final String methodName){
		HttpDelete request = new HttpDelete(getRequestURL(resourceClass, methodName));
		request.addHeader("content-type", MediaType.APPLICATION_JSON);
		return request;
	}
	
	public void printResponse(HttpResponse response){
		try {
			System.out.println( handler.handleResponse(response) );
		} catch (IOException e) {
			System.err.println("Não foi possivel printar a responsa da requisição");
		}
	}
	
	public String parseResponseToString(HttpResponse response){
		try{
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) 
				result.append(line);
			return result.toString();
		}catch(IOException e){
			return "";
		}
	}
	
}
