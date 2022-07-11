package africa.semicolon.service;

import africa.semicolon.data.models.BankUser;
import africa.semicolon.data.repositories.BankUserRepository;
import africa.semicolon.dto.requests.*;
import africa.semicolon.dto.responses.*;
import africa.semicolon.exceptions.AccountException;
import africa.semicolon.exceptions.InvalidAmountException;
import africa.semicolon.exceptions.InvalidDetailsException;
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
        if(bankUserRepository.existsByEmail(request.getEmail()))throw new AccountException("Account already exist");
        BankUser users = new BankUser();
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setEmail(request.getEmail());
        users.setAddress(request.getAddress());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setOccupation(request.getOccupation());
        users.setPassword(request.getPassword());

        String accountNumber = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        accountNumber = accountNumber.substring(1, 11);

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
        throw  new AccountException("Account does not exist");
    }

    @Override
    public DepositResponse deposit(DepositRequest request) {
        Optional<BankUser> users = bankUserRepository.findByAccountNumber(request.getAccountNumber());
        if(users.isPresent()){
            DepositResponse response = new DepositResponse();
            if(request.getAmount() > 0){
                users.get().setBalance(users.get().getBalance() + request.getAmount());

                response.setMessage(users.get().getFirstName() + " "+ request.getAmount()+" was deposited to your account,  your balance is "+
                        users.get().getBalance());

                response.setBalance(users.get().getBalance() + response.getBalance());
                bankUserRepository.save(users.get());

                return response;
            }else {
                throw new InvalidAmountException("Invalid amount");
            }

        }
        throw new AccountException("Account does not exist");
    }

    @Override
    public TransferResponse transfer(TransferRequest request) {
        Optional<BankUser> users = bankUserRepository.findByAccountNumber(request.getSenderAccount());
        if (users.isPresent()){
            if(users.get().getPassword().equals(request.getPassword())){
                Optional<BankUser> user = bankUserRepository.findByAccountNumber(request.getReceiverAccount());
                if (user.isPresent()){
                    if (request.getAmount() > 0 && request.getAmount() < users.get().getBalance()){
                        users.get().setBalance(users.get().getBalance() - request.getAmount());
                        user.get().setBalance(user.get().getBalance() + request.getAmount());
                    }
                }
            }

        }
        return null;
    }



    @Override
    public WithdrawResponse withdraw(WithdrawRequest request) {
        Optional<BankUser> user = bankUserRepository.findByAccountNumber(request.getAccountNumber());
        if (user.isPresent()){
            if (user.get().getPassword().equals(request.getPassword())){
                if (request.getAmount() > 0 && request.getAmount() <= user.get().getBalance()){
                    user.get().setBalance(user.get().getBalance() - request.getAmount());
                }
                else {
                    throw new InvalidAmountException("invalid amount");
                }
            }
            else {
                throw new InvalidDetailsException("invalid details");
            }

            WithdrawResponse response = new WithdrawResponse();
            response.setMessage("Txn : Debit" + "," + "amount : "+ request.getAmount());
            response.setAccountBalance(user.get().getBalance());
            bankUserRepository.save(user.get());
            return response;
        }

        throw new AccountException("Account does not exist");
    }

    @Override
    public CheckBalanceResponse checkBalance(CheckBalanceRequest request) {
        Optional<BankUser> user = bankUserRepository.findByAccountNumber(request.getAccountNumber());
        if(user.isPresent()){
            if (user.get().getPassword().equals(request.getPassword())){
                CheckBalanceResponse response = new CheckBalanceResponse();
                response.setMessage(user.get().getFirstName().toUpperCase() +" your account balance is: "+ user.get().getBalance());
                return response;
            }
            else throw new InvalidDetailsException("invalid details");
        }

        throw new AccountException("Account does not exist");
    }

}
