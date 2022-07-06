package africa.semicolon.controller;
import africa.semicolon.dto.requests.LoginRequest;
import africa.semicolon.dto.requests.RegisterRequest;
import africa.semicolon.dto.responses.LoginResponse;
import africa.semicolon.dto.responses.RegisterResponse;
import africa.semicolon.service.BankUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
}
