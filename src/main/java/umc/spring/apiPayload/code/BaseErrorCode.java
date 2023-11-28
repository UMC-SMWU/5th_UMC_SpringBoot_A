package umc.spring.apiPayload.code;

public interface BaseErrorCode {
    // ErrorReason에서 ErrorReasonDTO로 바꿈
    public ErrorReasonDTO getReason();
    public ErrorReasonDTO getReasonHttpStatus();
}