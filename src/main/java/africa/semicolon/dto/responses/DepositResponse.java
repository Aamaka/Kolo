package africa.semicolon.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositResponse {
    private String message;
    private LocalDateTime date = LocalDateTime.now();
}
