package com.pj.cherrypick.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 에러 페이지를 커스터마이징 하는 에러 컨트롤러는 반드시 ErrorController 인터페이스를 구현해야 한다!
public class WebErrorController implements ErrorController{

	    @GetMapping("/error")
	    public String handleError(HttpServletRequest request) {
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	        if(status != null){
	            int statusCode = Integer.valueOf(status.toString());

	            if(statusCode == HttpStatus.NOT_FOUND.value()) {
	                return "error/404";
	            } else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	            	return "error/403";
	            } else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            	return "error/500";
	            } else {
	                return "error/error";
	            }
	        }

	        return "error/error";
	    }
}
