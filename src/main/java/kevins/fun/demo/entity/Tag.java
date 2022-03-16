package kevins.fun.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cms_tags")
public class Tag {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(length = 128)
    private String name;

    @Column(length = 8)
    private String color = "000000";

    @Column(name = "id_parent")
    private Integer idParent;

    private String description;

    private String cover;

    @Column(name = "level_depth")
    private Integer levelDepth = 0;

    @Column(name = "date_add")
    @CreatedDate
    private Date dateAdd;

    @Column(name = "date_upd")
    @LastModifiedDate
    private Date dateUpd;

    private Integer position;

    @Column(name = "is_root")
    private Boolean isRoot;

    private String path;

    @Column(name = "add_member_id", length = 32)
    private String addMemberId;

    @Column(name = "upd_member_id", length = 32)
    private String updMemberId;
}
