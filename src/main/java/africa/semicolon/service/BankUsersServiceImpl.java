package africa.semicolon.service;

import africa.semicolon.data.models.BankUsers;
import africa.semicolon.data.repositories.BankUserRepository;
import africa.semicolon.dto.requests.*;
import africa.semicolon.dto.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        users.setPassword(request.getPassword());

        BankUsers saved = bankUserRepository.save(users);

        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setMessage(saved.getFirstName()+
                "'s Registration Successful !!!");
        registerResponse.setAccountNumber("Your account number is ...");
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<BankUsers> user = bankUserRepository.findByEmail(request.getEmail());
            if(user.isPresent()) {
                if (user.get().getPassword().equals(request.getPassword())) {
                    LoginResponse response = new LoginResponse();
                    response.setMessage("Welcome back " + user.get().getFirstName() + " " + user.get().getLastName());
                    return response;
                }

            }
        throw  new NullPointerException("Account does not exist");
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
