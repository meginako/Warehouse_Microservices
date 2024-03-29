package app.exception;

import app.common.exception.BaseRuntimeException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseRuntimeException {

    public ResourceNotFoundException(String id) {
        super("Resource with " + id + " not found", HttpStatus.NOT_FOUND);
    }
}

