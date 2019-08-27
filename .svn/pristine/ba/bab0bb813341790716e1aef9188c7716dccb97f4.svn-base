package com.tvscs.lms.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.tvscs.lms.model.CustomErrorResponse;
import com.tvscs.lms.util.StatusCodes;


@RestControllerAdvice
public class CustomGlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);
	
	@ExceptionHandler({EmployeeNotFoundException.class,RegionNotFoundException.class,DepartmentNotFoundException.class})
	public ResponseEntity<CustomErrorResponse> getCustomExceptionHandler(RuntimeException exception, WebRequest webRequest) {
		CustomErrorResponse cErrorResponse = CustomErrorResponse.getErrorObject(StatusCodes.EMP_NOT_FOUND, 
				exception.getMessage());
		logger.info(" Custom Exception handler "+cErrorResponse);
		return new ResponseEntity<CustomErrorResponse>(cErrorResponse,HttpStatus.OK);

	}

	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
	public ResponseEntity<CustomErrorResponse> hadleBadRequest(){
		CustomErrorResponse cErrorResponse = CustomErrorResponse.getErrorObject(StatusCodes.INVALID_REQUEST_DATA, 
				StatusCodes.getInstance().REQUESTERROR);
		return new ResponseEntity<CustomErrorResponse>(cErrorResponse,HttpStatus.UNPROCESSABLE_ENTITY);	
	}
	
	@ExceptionHandler(InvalidAccessKeyException.class)
	public ResponseEntity<CustomErrorResponse> handelEmptyResultSetException(Exception exception){
		CustomErrorResponse cErrorResponse = CustomErrorResponse.getErrorObject(StatusCodes.getInstance().COD_ER, 
				exception.getMessage());
		return new ResponseEntity<CustomErrorResponse>(cErrorResponse,HttpStatus.OK);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleDataNotFoundException(Exception exception){
		CustomErrorResponse cErrorResponse = CustomErrorResponse.getErrorObject(StatusCodes.NO_DATA_FOUND, 
				 exception.getMessage());
		return new ResponseEntity<CustomErrorResponse>(cErrorResponse,HttpStatus.OK);
	}
	
	@ExceptionHandler(ServiceNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleServiceLayerErrors(Exception exception){
		CustomErrorResponse cErrorResponse = CustomErrorResponse.getErrorObject(StatusCodes.SERV_UNAVAILABLE, 
				 exception.getMessage());
		return new ResponseEntity<CustomErrorResponse>(cErrorResponse,HttpStatus.OK);
	}
	
}
