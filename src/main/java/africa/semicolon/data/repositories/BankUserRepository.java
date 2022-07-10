package africa.semicolon.data.repositories;

import africa.semicolon.data.models.BankUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankUserRepository extends MongoRepository<BankUser, String> {

    boolean existsByEmail(String email);
    Optional<BankUser> findByAccountNumber(String accountNumber);

    Optional<BankUser> findByEmail(String email);
}
