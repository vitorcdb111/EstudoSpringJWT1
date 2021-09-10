package com.api.testjwt.Jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usermodel1")
public class UserModel  implements Serializable {

    @Id
    @Column(name = "coduser")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codUser;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    public UserModel(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.email = userDTO.getEmail();
    }
}
