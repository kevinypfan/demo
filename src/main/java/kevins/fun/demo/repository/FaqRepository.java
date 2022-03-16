package kevins.fun.demo.repository;

import kevins.fun.demo.entity.Faq;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository("CmsFaqRepository")
public interface FaqRepository extends CrudRepository<Faq, Long>, QueryByExampleExecutor<Faq>, JpaSpecificationExecutor<Faq> {
}
