package qreol.project.crm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contacts")
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Contact id", example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Contact type", example = "EMAIL")
    @Column(name = "contact_type")
    private ContactType type;

    @Schema(description = "Contact value", example = "stim@gmail.com")
    private String value;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }


}
