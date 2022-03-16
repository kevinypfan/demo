package kevins.fun.demo.dto;

import kevins.fun.demo.entity.Role;
import kevins.fun.demo.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    List<UserDTO> users = new ArrayList<>();
    public RoleDTO() {
    }
//    public RoleDTO(Role role) {
//        this.name = role.getName();
//        for(User user : role.getUsers()) {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setId(user.getId());
//            userDTO.setFirstName(user.getFirstName());
//            userDTO.setLastName(user.getLastName());
//            users.add(userDTO);
//        }
//    }

}
