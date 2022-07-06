package africa.semicolon.data.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document("Bank")
public class BankUsers {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String address;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String occupation;

    private String AccountNumber;

    @Id
    private String id;

    @NonNull
    private String password;

    private BigInteger balance;

}
