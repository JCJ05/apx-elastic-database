package com.bbva.pglu.lib.rccm.impl;

import com.bbva.pglu.dto.elastic.customer.AddressDTO;
import com.bbva.pglu.dto.elastic.customer.CustomerDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/**
 * The PGLURCCMImpl class...
 */
public class PGLURCCMImpl extends PGLURCCMAbstract {


	private static final Logger LOGGER = LoggerFactory.getLogger(PGLURCCMImpl.class);
	private static final String ELASTIC_NAME = "api.elastic.name";
	private static final String ELASTIC_HOST = "api.elastic.host";
	private static final String ELASTIC_PORT = "api.elastic.port";
	private static final String ELASTIC_INDEX = "api.elastic.index";
	private static final String OPERATION_DOC = "_doc";
	private static final String OPERATION_SEARCH = "_search";

	@Override
	public void execute() {

	}

	@Override
	public CustomerDTO executeSearchCustomer(String customerId) {
		String response = callElasticConnection(OPERATION_SEARCH, getSearchJson(customerId));

		Gson gson = new GsonBuilder().create();
		JsonElement hits = new JsonParser().parse(response).getAsJsonObject().get("hits");
		JsonElement hits_array = new JsonParser().parse(hits.toString()).getAsJsonObject().get("hits");
		JsonElement hits_element = hits_array.getAsJsonArray().get(0);
		JsonElement  source = new JsonParser().parse(hits_element.toString()).getAsJsonObject().get("_source");
		LOGGER.info("[APX_PGLU] Hits_Element {}",hits_element);
		LOGGER.info("[APX_PGLU] Source {}",source);

		CustomerDTO customerDTO = gson.fromJson(source,CustomerDTO.class);
		return customerDTO;
	}

	@Override
	public String executeCreateCustomer(CustomerDTO customer) {
		return callElasticConnection(OPERATION_DOC, getCreateJson(customer));
	}
	private String callElasticConnection(String operacion, String str_json){
		LOGGER.info("[APX] Method call executeCustomer");
		//Headers for the request
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
		//Json de Consulta/Creacion
		String json = str_json;
		//Request object
		HttpEntity<String> httpRequest = new HttpEntity<>(json,httpHeaders);
		//Invoke the service and get the response in a String object
		String DBName = applicationConfigurationService.getProperty(ELASTIC_NAME);
		Map<String,String> elasticConnection = getElasticConnection(DBName, operacion);

		LOGGER.debug("[APX] is uriVariables: {}",elasticConnection);
		LOGGER.debug("├->ELASTIC_API_DB: {}", DBName);
		LOGGER.debug("├->requestHttpEntity: {}",httpRequest);
		LOGGER.debug("└->uriVariables: {}",elasticConnection.entrySet().toArray());

		String post = this.internalApiConnector.postForObject(DBName, httpRequest, String.class, elasticConnection);
		LOGGER.debug("Post Result: {}",post);
		return post;
	}
	private Map<String,String> getElasticConnection(String DBName, String operacion){
		LOGGER.info("[APX] private method call getConnectionVariables");
		Map<String, String> uriVariables = new HashMap<>();

		String elasticUrlApi = applicationConfigurationService.getProperty("api.connector.{0}.url".replace("{0}",DBName));
		String index = applicationConfigurationService.getProperty(ELASTIC_INDEX);
		String host = applicationConfigurationService.getProperty(ELASTIC_HOST);
		String name = applicationConfigurationService.getProperty(ELASTIC_NAME);
		String port = applicationConfigurationService.getProperty(ELASTIC_PORT);

		LOGGER.info("[APX] Uri of elastic is {}",elasticUrlApi);
		LOGGER.info("[APX] Index of elastic is {}",index);
		LOGGER.info("[APX] Host is {}",host);
		LOGGER.info("[APX] Name is {}",name);
		LOGGER.info("[APX] Port is {}",port);
		LOGGER.info("[APX] Routing is {}","?routing="+name);

		uriVariables.put("ELASTIC_SEARCH_URL", elasticUrlApi);
		uriVariables.put("host",host);
		uriVariables.put("index",index);
		uriVariables.put("name",name);
		uriVariables.put("port",port);
		uriVariables.put("operation", getOperation(operacion));
		uriVariables.put("urlQueryParams", "?routing="+name);

		return uriVariables;
	}

	private String getOperation (String operacion){
		if(operacion.equals(OPERATION_DOC)) return OPERATION_DOC;
		else if(operacion.equals(OPERATION_SEARCH)) return OPERATION_SEARCH;
		return "_count";
	}
	private String getSearchJson (String customerId){
		return "{\n" +
				"\t\"query\": {\n" +
				"\t\t\"match\": {\n" +
				"\t\t\t\"customer_id\": \"" + customerId + "\"" +
				"\t\t}\n" +
				"\t}\n" +
				"}";
	}
	private String getCreateJson (CustomerDTO customerDTO){
		//LOGGER.debug("CreateJson tostringclass: {}",customerDTO.toStringClass());
		AddressDTO addressDTO = customerDTO.getAddress_str();
		return "{" +
				"\"address_str\":" + addressDTO.toString() +
				",\"audit_date\":\"" + customerDTO.getAudit_date() + '\"' +
				",\"creation_date\":\"" + customerDTO.getCreation_date() + '\"' +
				",\"creation_user_id\":\"" + customerDTO.getCreation_user_id() + '\"' +
				",\"customer_id\":\"" + customerDTO.getCustomer_id() + '\"' +
				",\"customer_last_name\":\"" + customerDTO.getCustomer_last_name() + '\"' +
				",\"customer_leaving_date\":\"" + customerDTO.getCustomer_leaving_date() + '\"' +
				",\"customer_name\":\"" + customerDTO.getCustomer_name() + '\"' +
				",\"user_audit_id\":\"" + customerDTO.getUser_audit_id() + '\"' +
				",\"years_cust_age_number\":\"" + customerDTO.getYears_cust_age_number() + '\"' +
				'}';
	}


}
