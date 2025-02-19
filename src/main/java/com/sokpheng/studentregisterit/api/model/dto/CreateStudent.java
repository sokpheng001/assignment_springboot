package com.sokpheng.studentregisterit.api.model.dto;

import lombok.Builder;

@Builder
public record CreateStudent(
        String name,
        String email,
        String password
) {
}
