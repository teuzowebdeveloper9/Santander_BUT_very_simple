package santander.simple.DTOs;


import jakarta.validation.constraints.NotBlank;

public record AuthDTO(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String document,
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
