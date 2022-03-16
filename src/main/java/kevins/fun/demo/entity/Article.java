package kevins.fun.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name = "cms_articles")
public class Article implements Serializable {

    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(length = 128)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "plain_content", columnDefinition = "TEXT")
    private String plainContent;

    @Column(length = 128)
    private String cover;

    private Integer position = 0;

    private Boolean visible = true;

    @Column(name = "date_add")
    @CreatedDate
    private Date dateAdd;

    @Column(name = "date_upd")
    @LastModifiedDate
    private Date dateUpd;

    @Column(columnDefinition = "TEXT")
    private String path;

    private Boolean deleted = false;

    private Integer priority = 1;

    @Column(name = "publish_date")
    private Date publishDate;

    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Set<Attachment> attachments = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cms_article_tag_mappers",
            joinColumns = {
                    @JoinColumn(name = "article_id", referencedColumnName = "article_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id",
                            nullable = false, updatable = false)})
    private Set<Tag> tags = new HashSet<>();
}
