package kevins.fun.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "CmsFaqEntity")
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name = "cms_faqs")
public class Faq {
    @Id
    @Column(name = "id_faqs")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFaqs;

    private String question;

    private String answer;

    @Column(name = "project_code", length = 3)
    private String projectCode;

    @Column(name = "date_add")
    @CreatedDate
    private Date dateAdd;

    @Column(name = "date_upd")
    @LastModifiedDate
    private Date dateUpd;

    @Column(name = "add_member_id", length = 32)
    private String addMemberId;

    @Column(name = "upd_member_id", length = 32)
    private String updMemberId;

    @Column(name = "del_member_id", length = 32)
    private String delMemberId;

    private Integer priority = 1;

    private boolean deleted = false;

    @Column(name = "id_departments")
    private Long idDepartments;

    public static Specification<Faq> searchQuery(String q) {
        return (root, query, builder) ->
                builder.or(builder.like(root.get("question"), "%" + q + "%"), builder.like(root.get("answer"), "%" + q + "%"));
    }

    public static Specification<Faq> questionLike(String q) {
        return (root, query, builder) ->
                builder.like(root.get("question"), "%" + q + "%");
    }

    public static Specification<Faq> answerLike(String q) {
        return (root, query, builder) ->
                builder.like(root.get("answer"), "%" + q + "%");
    }
}
