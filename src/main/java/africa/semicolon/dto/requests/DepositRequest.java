package africa.semicolon.dto.requests;

import africa.semicolon.data.models.BankUser;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositRequest {

    private String email;

    private String accountNumber;

    private int amount;

}
