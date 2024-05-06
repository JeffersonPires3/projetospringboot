@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cep;
    private String street;
    private String city;
    private String state;

    @ManyToOne
    private User user;

    // getters and setters
}
