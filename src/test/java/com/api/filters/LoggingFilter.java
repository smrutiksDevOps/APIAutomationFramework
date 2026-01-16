package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	
	private static final Logger logger= LogManager.getLogger(LoggingFilter.class);
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		LogRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec); //this allows to continue the request after interseption . here request is going to executed
		LogResponse(response);
		
		return response; //response for assertion in test
	}
	
	public void LogRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE_URI:"+ requestSpec.getBaseUri());
		logger.info("Request Header:"+ requestSpec.getHeaders());
		logger.info("Request Body:"+ requestSpec.getBody());
	}
	
	public void LogResponse(Response response) {
		logger.info("Status code:"+ response.getStatusCode());
		logger.info("Response body:"+ response.getBody().asPrettyString());
		logger.info("Response header:"+ response.getHeaders());
	}
}
