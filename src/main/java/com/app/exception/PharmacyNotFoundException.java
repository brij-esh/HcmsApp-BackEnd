package com.app.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PharmacyNotFoundException extends Exception {
    public PharmacyNotFoundException(){
        log.info("Pharmacy Not found");
    }
}
