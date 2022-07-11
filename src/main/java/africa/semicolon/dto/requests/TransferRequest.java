package africa.semicolon.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private String senderAccount;
    private String receiverAccount;
    private int amount;
    private String password;

}
