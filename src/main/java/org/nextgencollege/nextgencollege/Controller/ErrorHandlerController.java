package org.nextgencollege.nextgencollege.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ErrorHandlerController implements ErrorController {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNull(NullPointerException nothing) {
        Map<String, Object> nullPointerError = new HashMap<>();
        nullPointerError.put("Error", "Value Not Present In Database !!!!!");
        nullPointerError.put("ErrorMsg", nothing);
        return new ResponseEntity<>(nullPointerError, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethod(HttpRequestMethodNotSupportedException method) {
        Map<String, Object> methodError = new HashMap<>();
        methodError.put("Error", "Please Check The Requested Method  !!!!!");
        methodError.put("ErrorMsg", method.getMessage());
        return new ResponseEntity<>(methodError, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleDuplicate(SQLIntegrityConstraintViolationException duplicate) {
        Map<String, Object> duplicateError = new HashMap<>();
        duplicateError.put("Error", "Please Check The Book ID  !!!!!");
        log.error("ErrorMsg : "+ duplicate.getLocalizedMessage());
        return new ResponseEntity<>(duplicateError, HttpStatus.BAD_GATEWAY);
    }

}
