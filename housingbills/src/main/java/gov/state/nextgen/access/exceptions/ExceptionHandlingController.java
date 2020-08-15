package gov.state.nextgen.access.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j(topic="exception")
public class ExceptionHandlingController  {

	
	@ExceptionHandler(Exception.class)
	public void  generalException(Exception e){
		System.out.println("General Exception Called");
		
	}
	
	@ExceptionHandler(ApplicationException.class)
	public void applicationException(ApplicationException e){
		System.out.println("Application Exception called");
		
	}

	@ExceptionHandler({RuntimeException.class})
	public void runtimeException(RuntimeException e) {
		System.out.println("Runtime Exception called");
	}
	
	@ExceptionHandler({FwException.class})
	public void runtimeException(FwException e) {
		System.out.println("Framework Exception called");
	}
	
	@ExceptionHandler({EligibilityScreenerException.class})
	public void eligibilityScreenerException(EligibilityScreenerException e) {
		System.out.println("Eligibility screener exception "+e.getMessage());
	}

}

