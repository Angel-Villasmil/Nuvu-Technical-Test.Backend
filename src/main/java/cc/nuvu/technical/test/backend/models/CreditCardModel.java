package cc.nuvu.technical.test.backend.models;

import java.util.Calendar;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "credit_card")
public class CreditCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCredit_Card", unique = true, nullable = false)
	private Long id;
    
    @Column(name = "Bank", nullable = false)
	private String bank;
    
    @Column(name = "BIN", nullable = false)
	private String bin;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ExpiryDate", nullable = false)
    private Calendar expiryDate;
    
    @Column(name = "Cardholder", nullable = false)
	private String cardholder;
	
    @Column(name = "Brand", nullable = false)
	private String brand;
    
    @Column(name = "CVV", nullable = false)
	private String cvv;
    
    @JoinColumn(name = "fk_idCustomer", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CustomerModel customer;
    
}