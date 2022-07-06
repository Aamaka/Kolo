package africa.semicolon.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositRequest {
    private String firstName;
    private String lastName;
    private BigDecimal amount;
    private String accountNumber;
    private String email;
}
