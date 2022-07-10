package africa.semicolon.dto.requests;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositRequest {

    private String accountNumber;

    private int amount;

}
