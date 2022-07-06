package africa.semicolon.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositRequest {
    private String email;
    private String accountNumber;
    private int amount;

}
