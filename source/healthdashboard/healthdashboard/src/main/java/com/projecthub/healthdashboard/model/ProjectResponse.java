package com.projecthub.healthdashboard.model;

public record ProjectResponse(
        String name,
        String status,
        int progress,
        String start,
        String deadline
) {}
