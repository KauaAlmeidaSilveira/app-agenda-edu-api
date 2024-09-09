package com.agendaedu.schedule_service.domain.course;

public enum CourseDegree {
    INFANTIL("infantil"),
    FUNDAMENTAL("fundamental"),
    MEDIO("medio");

    private final String degree;

    CourseDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return this.degree;
    }
}
