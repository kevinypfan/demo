package kevins.fun.demo.repository;

import kevins.fun.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository("CmsTagRepository")
public interface TagRepository extends CrudRepository<Tag, Long>, QueryByExampleExecutor<Tag>, JpaSpecificationExecutor<Tag> {
}
