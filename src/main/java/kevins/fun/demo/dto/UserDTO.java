package kevins.fun.demo.dto;

import kevins.fun.demo.entity.Role;
import kevins.fun.demo.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    private List<RoleDTO> roles = new ArrayList<>();

    public UserDTO() {
    }


    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
        this.tokenExpired = user.isTokenExpired();

//        for(Role role : user.getRoles()) {
//            RoleDTO roleDTO = new RoleDTO();
//            roleDTO.setName(role.getName());
//            roles.add(roleDTO);
//        }
    }
}
