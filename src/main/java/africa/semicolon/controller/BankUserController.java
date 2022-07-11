package africa.semicolon.controller;
import africa.semicolon.dto.requests.*;
import africa.semicolon.dto.responses.*;
import africa.semicolon.service.BankUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankUserController {

    @Autowired
    private BankUsersService usersService;

    @PostMapping("/user/register")
    public RegisterResponse register (@RequestBody RegisterRequest request){
        return usersService.register(request);
    }

    @PostMapping("/user/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return usersService.login(request);
    }

    @PostMapping("/user/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest request){
        return usersService.deposit(request);
    }

    @PostMapping("/user/withdraw")
    public WithdrawResponse withdraw(@RequestBody WithdrawRequest request){
        return usersService.withdraw(request);
    }

    @PostMapping("/user/balance")
    public CheckBalanceResponse checkBalance(@RequestBody CheckBalanceRequest request){
        return usersService.checkBalance(request);
    }

    @PostMapping("/user/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest request){
        return usersService.transfer(request);
    }
}
