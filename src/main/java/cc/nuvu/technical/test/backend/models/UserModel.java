package cc.nuvu.technical.test.backend.models;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", unique = true, nullable = false)
	private Long id;
    
    @Column(name = "Username", nullable = false)
	private String name;
    
    @Column(name = "Password", nullable = false)
	private String password;
	
    @Column(name = "Email", nullable = false)
	private String email;
}
