package com.example.bddruka.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_usuarios",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "rolId")
    )
    private Set<RolEntity> rolesUsuario;

}
