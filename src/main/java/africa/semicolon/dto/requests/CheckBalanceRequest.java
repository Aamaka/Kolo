package africa.semicolon.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckBalanceRequest {
    private String accountNumber;
    private String password;
}
