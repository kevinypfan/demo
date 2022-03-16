package kevins.fun.demo.entity.shared;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BaseTree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_parent")
    private Integer idParent;

    @Column(name = "level_depth")
    private Integer levelDepth = 0;

    private Integer position = 0;

    @Column(name = "is_root")
    private Boolean isRoot = false;

    @Column(columnDefinition="TEXT")
    private String path;

}
