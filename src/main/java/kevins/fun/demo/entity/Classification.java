package kevins.fun.demo.entity;


import kevins.fun.demo.entity.shared.BaseTree;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cms_classifications")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_classifications"))
})
public class Classification extends BaseTree {

    @Column(length = 128)
    private String name;

    private String description;

    private String cover;

    private Boolean active = true;

    @Column(name = "add_member_id", length = 32)
    private String addMemberId;

    @Column(name = "upd_member_id", length = 32)
    private String updMemberId;

    @Column(length = 32)
    private String classification;

    @Column(name = "classification_id")
    private String classificationId;

    private Boolean deleted = false;

    @Column(name = "del_member_id", length = 32)
    private String delMemberId;

    @Column(name = "id_departments")
    private Long idDepartments;
}
