package com.shopkeeperbilling.structure;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public enum HttpResponseCode {
    OK(200, "OK"),UNAUTHORIZED(401, "Unauthorized");
    int value;
    String reasonPhrase;

    public static HttpResponseCode value(int code) {
        return HttpResponseCode.value(code);
    }
}
