package com.hamza.walletapplication.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationErrorService {
    public ResponseEntity<?> validate(BindingResult result){
        if (result.hasErrors()){
            Map<String,String> errorMap = new HashMap<String, String>();
            for (FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());

            }
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
