package com.app.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DoctorNotFoundException extends Exception {
    public DoctorNotFoundException(){
        log.info("Doctor Not found");
    }
}
