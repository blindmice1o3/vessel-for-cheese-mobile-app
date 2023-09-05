package com.jackingaming.vesselforcheesemobileapp.models;

import java.time.LocalDateTime;

public class LocalDateTimeDTO {
    private LocalDateTime localDateTime;

    public LocalDateTimeDTO() {
    }

    public LocalDateTimeDTO(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
