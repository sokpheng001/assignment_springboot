package com.sokpheng.studentregisterit.api.model.dto;

import lombok.Builder;

@Builder
public record UpdateStudent(
        String name,
        String email,
        String profile
) {
}
