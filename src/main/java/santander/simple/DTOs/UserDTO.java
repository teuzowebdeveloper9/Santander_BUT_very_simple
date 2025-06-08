package santander.simple.DTOs;

import santander.simple.Enums.TypeAcount;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, BigDecimal balance,
                      String document, String email, String password, TypeAcount typeAcount) {
}
