package africa.semicolon.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositRequest {
    private String firstName;
    private String lastName;
    private int amount;
    private String accountNumber;
    private String email;
}
