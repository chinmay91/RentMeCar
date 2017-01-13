package com.rentmecar.controller.rest.utility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/errors")
public class ApplicationRestExceptions {


    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @RequestMapping("resourcenotfound")
    protected JSONResponse resourceNotFound(HttpServletRequest request) throws Exception {
        return new JSONResponse("404", "Resource not found", "Requested Resource not found");
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @RequestMapping("forbidden")
    public JSONResponse forbidden(HttpServletRequest request) throws Exception {
        return new JSONResponse("403", "Forbidden", "Not authorized to access the resource");
    }
    
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @RequestMapping("unauthorized")
    public JSONResponse unAuthorised(HttpServletRequest request) throws Exception {
        return new JSONResponse("401", "Unauthorized", "Provided authentication details incorrect");
    }
}




// http://stackoverflow.com/questions/22783583/how-can-i-get-spring-security-to-return-a-401-response-as-a-json-format
// http://stackoverflow.com/questions/22783583/how-can-i-get-spring-security-to-return-a-401-response-as-a-json-format