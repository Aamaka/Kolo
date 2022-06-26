package africa.semicolon.data.repositories;

import africa.semicolon.data.models.BankUsers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankUserRepository extends MongoRepository<BankUsers, String> {

}
