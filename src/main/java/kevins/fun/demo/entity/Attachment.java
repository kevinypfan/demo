package kevins.fun.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "CmsAttachment")
@Data
@Table(name = "cms_attachments")
@EntityListeners(AuditingEntityListener.class)
public class Attachment {

    @Id
    @Column(name = "attachment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachmentId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private String filename;

    private String type;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(name = "date_add")
    @CreatedDate
    private Timestamp dateAdd;

    @Column(name = "date_upd")
    @LastModifiedDate
    private Timestamp dateUpd;

    @Column(name = "add_member_id", length = 32)
    private String addMemberId;

    @Column(name = "upd_member_id", length = 32)
    private String updMemberId;

    private Integer position;
}
