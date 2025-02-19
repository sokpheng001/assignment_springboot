package com.sokpheng.studentregisterit.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder

public record RespondStudent(
        String uuid,
        String name,
        String email,
        String profile
) {
}
