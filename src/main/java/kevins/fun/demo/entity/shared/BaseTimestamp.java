package kevins.fun.demo.entity.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BaseTimestamp {
    @Column(name = "date_add")
    @CreatedDate
    private Timestamp dateAdd;

    @Column(name = "date_upd")
    @LastModifiedDate
    private Timestamp dateUpd;
}
