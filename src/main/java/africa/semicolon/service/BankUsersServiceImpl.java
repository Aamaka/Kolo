package africa.semicolon.service;

import africa.semicolon.data.models.BankUsers;
import africa.semicolon.data.repositories.BankUserRepository;
import africa.semicolon.dto.requests.*;
import africa.semicolon.dto.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankUsersServiceImpl implements BankUsersService{

    @Autowired
    private BankUserRepository bankUserRepository;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        BankUsers users = new BankUsers();
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setEmail(request.getEmail());
        users.setAddress(request.getAddress());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setOccupation(request.getOccupation());

        BankUsers saved = bankUserRepository.save(users);

        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setMessage(saved.getFirstName()+
                "'s Registration Successful !!!");
        registerResponse.setAccountNumber("your account number");
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public DepositResponse deposit(DepositRequest request) {
        return null;
    }

    @Override
    public TransferResponse transfer(TransferRequest request) {
        return null;
    }

    @Override
    public WithdrawResponse withdraw(WithdrawRequest request) {
        return null;
    }

    @Override
    public CheckBalanceResponse checkBalance(CheckBalanceRequest request) {
        return null;
    }


}
