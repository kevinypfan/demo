package kevins.fun.demo.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;


@Entity
@Data
@Table(name = "core_privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "privileges")
//    private Collection<Role> roles = new HashSet<>();
}