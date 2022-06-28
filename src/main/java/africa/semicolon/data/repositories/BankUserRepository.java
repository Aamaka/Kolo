package africa.semicolon.data.repositories;

import africa.semicolon.data.models.BankUsers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserRepository extends MongoRepository<BankUsers, String> {

    BankUsers findByEmail(String email);
}
