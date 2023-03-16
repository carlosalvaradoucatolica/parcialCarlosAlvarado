package co.edu.ucatolica.primerparcial.model;

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
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String turn;
    @NotNull
    private LocalDateTime dateTime;
    @ManyToOne
    private User user;
}
