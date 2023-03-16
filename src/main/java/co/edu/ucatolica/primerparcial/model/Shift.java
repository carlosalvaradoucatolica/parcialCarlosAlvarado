package co.edu.ucatolica.primerparcial.model;

import co.edu.ucatolica.primerparcial.util.ShiftTypes;
import co.edu.ucatolica.primerparcial.util.UserTypes;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "shift")
@NamedQuery(name = "Shift.calculateEta",
        query = "select sum(i.eta) as eta from Shift i where i.type = ?1")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Integer eta;
    @NotNull
    private Boolean finished = false;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ShiftTypes type;

    @ManyToOne
    private User user;


    public Shift(LocalDateTime createdAt, Integer eta, Boolean finished, ShiftTypes type, User user) {
        this.createdAt = createdAt;
        this.eta = eta;
        this.finished = finished;
        this.type = type;
        this.user = user;
    }

    public Shift() {

    }
}
