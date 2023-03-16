package co.edu.ucatolica.primerparcial.service.impl;

import co.edu.ucatolica.primerparcial.model.Shift;
import co.edu.ucatolica.primerparcial.model.User;
import co.edu.ucatolica.primerparcial.repository.IShiftRepository;
import co.edu.ucatolica.primerparcial.service.interfaces.IShiftPosService;
import co.edu.ucatolica.primerparcial.util.Response;
import co.edu.ucatolica.primerparcial.util.ShiftTypes;
import co.edu.ucatolica.primerparcial.util.UserTypes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ShiftPosServiceImpl implements IShiftPosService {
    private final Integer MINS_ETA = 30;
    private final UserTypes POS_USER_TYPE = UserTypes.POS;
    private final ShiftTypes POS_SHIFT_TYPE = ShiftTypes.PS;
    private final IShiftRepository shiftRepository;
    private final UserServiceImpl userService;

    @Override
    public ResponseEntity<Response> newPosShift(User user) {

        Optional<Integer> calculateEta = shiftRepository.calculateEta(POS_SHIFT_TYPE);
        Integer eta = 0;
        if(calculateEta.isPresent()){
            eta = calculateEta.get();
        }

        User userPersisted = userService.persistUser(user);
        Shift shift = new Shift(
                LocalDateTime.now()
                , eta
                , false
                , POS_SHIFT_TYPE
                , userPersisted
        );

        Shift shiftPersisted = shiftRepository.saveAndFlush(shift);

        return  new ResponseEntity<Response>(
                Response.builder()
                        .timeStampo(LocalDateTime.now())
                        .message("Turno creado exitosamente.")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of(
                                "turno",shiftPersisted
                                ,"usuario",userPersisted
                                , "consecutivo",shiftPersisted.getType().name().concat(shiftPersisted.getId().toString())
                        ))
                        .build()
                ,HttpStatus.CREATED
        );
    }
}
