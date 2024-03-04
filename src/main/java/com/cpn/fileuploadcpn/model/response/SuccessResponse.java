package com.cpn.fileuploadcpn.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(builderMethodName = "hiddenBuilder")
public class SuccessResponse<T>  {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private T data;
    protected Boolean errorStatus;
    @Setter(AccessLevel.PROTECTED)
    protected String status;
    protected String message;
    protected String timestamp;

    public static <T> SuccessResponseBuilder builder(T data) {
        return hiddenBuilder()
                .status("OK")
                .errorStatus(false)
                .data(data)
                .message("")
                .timestamp(dateTimeFormatter.format(OffsetDateTime.now()));
    }

    public static SuccessResponseBuilder builderSuccess() {
        return hiddenBuilder()
                .status("OK")
                .errorStatus(false)
                .message("")
                .timestamp(dateTimeFormatter.format(OffsetDateTime.now()));
    }

    public static SuccessResponseBuilder builderFail(String error) {
        return hiddenBuilder()
                .status("FAIL")
                .errorStatus(true)
                .message(error)
                .timestamp(dateTimeFormatter.format(OffsetDateTime.now()));
    }
}