package africa.semicolon.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {


    private String message;
    private String accountNumber;
}
