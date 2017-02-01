package com.rentmecar.controller.rest.utility;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(FileNotFoundException.class)
	@ResponseBody JSONResponse handleLanguageException(HttpServletRequest req, Exception ex) {
		JSONResponse fruitErrorMessage=new JSONResponse("error", ex.getMessage(), ex.getClass().toString());
		return fruitErrorMessage;
	} 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	@ResponseBody JSONResponse applicationErrorMessage(HttpServletRequest req, Exception ex) {
		JSONResponse fruitErrorMessage=new JSONResponse("error", ex.getMessage(), ex.getClass().toString());
		return fruitErrorMessage;
	} 

}