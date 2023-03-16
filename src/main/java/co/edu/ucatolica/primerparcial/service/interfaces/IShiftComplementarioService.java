package co.edu.ucatolica.primerparcial.service.interfaces;

import co.edu.ucatolica.primerparcial.model.User;
import co.edu.ucatolica.primerparcial.util.Response;
import org.springframework.http.ResponseEntity;

public interface IShiftComplementarioService {
    public ResponseEntity<Response> newComplementarioShift(User appUser);
}
