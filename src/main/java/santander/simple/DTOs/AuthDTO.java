package santander.simple.DTOs;


import jakarta.validation.constraints.NotBlank;

public record AuthDTO(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        String document,
        String email) {
}
