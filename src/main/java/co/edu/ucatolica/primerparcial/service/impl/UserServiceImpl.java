package co.edu.ucatolica.primerparcial.service.impl;

import co.edu.ucatolica.primerparcial.dto.UserResponseDTO;
import co.edu.ucatolica.primerparcial.model.User;
import co.edu.ucatolica.primerparcial.repository.IUserRepository;
import co.edu.ucatolica.primerparcial.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    IUserRepository iUserRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public UserResponseDTO addUser(User user) {

        iUserRepository.save(mapper.map(user, User.class));
        return new UserResponseDTO("Usuario creado exitosamente");
    }

    @Override
    public User persistUser(User user) {
        return iUserRepository.save(user);
    }
}
