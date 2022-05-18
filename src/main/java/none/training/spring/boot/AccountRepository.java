package none.training.spring.boot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,String> {
     List<Account> findByOwnerLastName(String ownerLastName);
     List<Account> findByActiveFlagTrue();
     List<Account> findByActiveFlagTrueAndOwnerLastName(String ownerLastName);
     Optional<List<Account>> findByOwnerFirstNameContaining(String name);
}
