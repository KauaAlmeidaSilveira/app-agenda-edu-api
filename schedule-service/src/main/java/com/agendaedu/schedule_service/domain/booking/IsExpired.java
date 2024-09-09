package com.agendaedu.schedule_service.domain.booking;

public enum IsExpired {
    FALSE("False"),
    TRUE("True");

    private final String status;

    IsExpired(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
