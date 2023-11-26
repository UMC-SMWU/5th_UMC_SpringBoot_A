package com.umc.spring.common.code;

public interface BaseErrorCode {

    public ErrorReason getReason();

    public ErrorReason getReasonHttpStatus();
}
