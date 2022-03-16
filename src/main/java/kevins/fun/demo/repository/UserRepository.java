package kevins.fun.demo.repository;

import kevins.fun.demo.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, QueryByExampleExecutor<User>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);
}
