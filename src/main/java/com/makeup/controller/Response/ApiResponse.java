package com.makeup.controller.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ApiResponse {
    private Boolean success = true;

    public ApiResponse(boolean success) {
        this.success = success;
    }
}
