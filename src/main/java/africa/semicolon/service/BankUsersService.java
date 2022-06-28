package africa.semicolon.service;

import africa.semicolon.dto.requests.*;
import africa.semicolon.dto.responses.*;
public interface BankUsersService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login (LoginRequest request);
    DepositResponse deposit(DepositRequest request);
    TransferResponse transfer (TransferRequest request);
    WithdrawResponse withdraw (WithdrawRequest request);
    CheckBalanceResponse checkBalance (CheckBalanceRequest request);

}
