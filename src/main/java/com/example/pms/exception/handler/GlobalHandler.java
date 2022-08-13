package com.example.pms.exception.handler;

import com.example.pms.enums.EnumExceptions;
import com.example.pms.exception.GettingDataFailedException;
import com.example.pms.exception.InternalException;
import com.example.pms.exception.InvalidRequestDataException;
import com.example.pms.response.RespStatus;
import com.example.pms.response.Response;
import com.example.pms.util.NumberFunctions;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.example.pms.util.LogUtil.response;

@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(GlobalHandler.class);

    private final Environment env;


    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response internalException(InternalException exception){
        int randomNumber = NumberFunctions.getRandomNumber();
        log.error(response(EnumExceptions.INTERNAL_EXCEPTION.getMessage()) + " " + randomNumber, exception);

        return Response.builder()
                .status(RespStatus.builder()
                        .statusCode(EnumExceptions.INTERNAL_EXCEPTION.getCode())
                        .statusMessage(EnumExceptions.INTERNAL_EXCEPTION.getMessage())
                        .build())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public Response invalidRequestDataException(InvalidRequestDataException exception){
        log.error(response(EnumExceptions.INVALID_REQUEST_DATA.getMessage()), exception);

        return Response.builder()
                .status(RespStatus.builder()
                        .statusCode(EnumExceptions.INVALID_REQUEST_DATA.getCode())
                        .statusMessage(EnumExceptions.INVALID_REQUEST_DATA.getMessage())
                        .build())
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response gettingDataFailedException(GettingDataFailedException exception){
        log.error(response(EnumExceptions.GETTING_DATA_FAILED.getMessage()), exception);

        return Response.builder()
                .status(RespStatus.builder()
                        .statusCode(EnumExceptions.GETTING_DATA_FAILED.getCode())
                        .statusMessage(EnumExceptions.GETTING_DATA_FAILED.getMessage())
                        .build())
                .build();
    }

}
