package cc.nuvu.technical.test.backend.models;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer", unique = true, nullable = false)
	private Long id;
    
    @Column(name = "Name", nullable = false)
	private String name;
    
    @Column(name = "LastName", nullable = false)
	private String lastName;
	
    @Column(name = "Telephone", nullable = false)
	private String telephone;
    
    @Column(name = "Email", nullable = false)
	private String email;
	
    @Column(name = "StreetAddress", nullable = false)
	private String streetAddress;
    
}
