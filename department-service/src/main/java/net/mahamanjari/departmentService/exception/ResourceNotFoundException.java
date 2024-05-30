package net.mahamanjari.departmentService.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException{

    private String message;

    public ResourceNotFoundException(String message){
        this.message = message;
    }

}
