package cl.awakelab.sprint06.repository;

import cl.awakelab.sprint06.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario,Long> {
}
