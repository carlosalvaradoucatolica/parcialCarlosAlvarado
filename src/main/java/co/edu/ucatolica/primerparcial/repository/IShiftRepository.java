package co.edu.ucatolica.primerparcial.repository;

import co.edu.ucatolica.primerparcial.model.Shift;
import co.edu.ucatolica.primerparcial.util.ShiftTypes;
import co.edu.ucatolica.primerparcial.util.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IShiftRepository extends JpaRepository<Shift,Integer> {

    public Optional<Integer> calculateEta(ShiftTypes type);


}
