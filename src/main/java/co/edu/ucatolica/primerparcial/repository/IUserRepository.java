package co.edu.ucatolica.primerparcial.repository;

import co.edu.ucatolica.primerparcial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
