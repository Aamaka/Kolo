package africa.semicolon.data;

import africa.semicolon.data.models.BankUser;
import africa.semicolon.dto.requests.RegisterRequest;
import africa.semicolon.dto.responses.RegisterResponse;

public class Mapper {
    public static void map(RegisterRequest request, BankUser users) {
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setEmail(request.getEmail());
        users.setAddress(request.getAddress());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setOccupation(request.getOccupation());
        users.setPassword(request.getPassword());
    }

    public static void map(BankUser saved, RegisterResponse registerResponse) {
        registerResponse.setMessage(saved.getFirstName()+
                "'s Registration Successful !!!");
        registerResponse.setAccountNumber("Your account number is " + saved.getAccountNumber());
    }
}
