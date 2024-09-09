package com.agendaedu.schedule_service.domain.booking;

public enum IsDisabled {
    FALSE("False"),
    TRUE("True");

    private final String status;

    IsDisabled(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
