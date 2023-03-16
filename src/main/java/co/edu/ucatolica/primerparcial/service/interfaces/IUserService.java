package co.edu.ucatolica.primerparcial.service.interfaces;

import co.edu.ucatolica.primerparcial.dto.UserResponseDTO;
import co.edu.ucatolica.primerparcial.model.User;


public interface IUserService {

    UserResponseDTO addUser(User user);

}
