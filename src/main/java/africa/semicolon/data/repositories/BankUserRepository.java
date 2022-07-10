package africa.semicolon.data.repositories;

import africa.semicolon.data.models.BankUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankUserRepository extends MongoRepository<BankUser, String> {

    Optional<BankUser> findByEmail(String email);

    boolean existsByEmail(String email);
//    BankUsers findByEmail(String email);

//    boolean existsByEmail(String email);
}
