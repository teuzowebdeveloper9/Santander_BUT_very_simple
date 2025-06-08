package santander.simple.DTOs;


import santander.simple.entitys.User;

import java.math.BigDecimal;
import java.util.UUID;


public record TransactionDTO(BigDecimal amount, UUID sender, UUID receiver) { }

