package com.devops.onlineshopbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "A product with this name not found!")
public class ProductNotFoundException extends RuntimeException  {

}
