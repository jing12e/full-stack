package com.jing.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
