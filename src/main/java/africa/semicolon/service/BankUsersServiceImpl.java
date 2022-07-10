package africa.semicolon.service;

import africa.semicolon.data.models.BankUser;
import africa.semicolon.data.repositories.BankUserRepository;
import africa.semicolon.dto.requests.*;
import africa.semicolon.dto.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BankUsersServiceImpl implements BankUsersService{

    @Autowired
    private BankUserRepository bankUserRepository;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if(bankUserRepository.existsByEmail(request.getEmail()))throw new IllegalArgumentException("Account already exist");
        BankUser users = new BankUser();
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setEmail(request.getEmail());
        users.setAddress(request.getAddress());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setOccupation(request.getOccupation());
        users.setPassword(request.getPassword());

        String accountNumber = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        accountNumber = accountNumber.substring(1, 10);

        users.setAccountNumber(accountNumber);

        BankUser saved = bankUserRepository.save(users);

        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setMessage(saved.getFirstName()+
                "'s Registration Successful !!!");


        registerResponse.setAccountNumber("Your account number is " + saved.getAccountNumber());
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<BankUser> user = bankUserRepository.findByEmail(request.getEmail());
            if(user.isPresent()) {
                if (user.get().getPassword().equals(request.getPassword())) {
                    LoginResponse response = new LoginResponse();
                    response.setMessage("Welcome back " + user.get().getFirstName() + " " + user.get().getLastName()
                            +" "+"your balance is " + user.get().getBalance());
                    return response;
                }

            }
        throw  new NullPointerException("Account does not exist");
    }

    @Override
    public DepositResponse deposit(DepositRequest request) {
        Optional<BankUser> users = bankUserRepository.findByEmail(request.getEmail());
        if(users.isPresent()){
            DepositResponse response = new DepositResponse();
            if(request.getAmount() > 0){
                users.get().setBalance(users.get().getBalance() + request.getAmount());

                response.setMessage(users.get().getFirstName() + " "+ request.getAmount()+" was deposited to your account,  your balance is "+
                        users.get().getBalance());
//                response.setDate(LocalDateTime.parse(DateTimeFormatter.ofPattern("EEEE, dd/MM/ yyyy,  hh:mm, a").
//                        format(users.get().getTime())));

                response.setBalance(users.get().getBalance() + response.getBalance());
                bankUserRepository.save(users.get());

                return response;
            }else {
                throw new IllegalArgumentException("Invalid amount");
            }

        }
        throw new IllegalArgumentException("email does not exist");
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
