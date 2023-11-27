package com.umc.spring.temp.exception.handler;

import com.umc.spring.temp.apiPayload.code.BaseErrorCode;
import com.umc.spring.temp.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
