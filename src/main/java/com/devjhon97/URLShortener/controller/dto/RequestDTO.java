package com.devjhon97.URLShortener.controller.dto;

import jakarta.validation.constraints.Size;

public record RequestDTO(
        @Size(min = 8, max = 1000, message = "URL must have between 15 and 1000 characters!")
        String url) {
}
