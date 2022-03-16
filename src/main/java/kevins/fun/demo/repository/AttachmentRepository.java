package kevins.fun.demo.repository;

import kevins.fun.demo.entity.Attachment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository("CmsAttachmentRepository")
public interface AttachmentRepository extends CrudRepository<Attachment, Long>, QueryByExampleExecutor<Attachment>, JpaSpecificationExecutor<Attachment> {
}
