package cr.ac.ufidelitas.practica01.repository;

import cr.ac.ufidelitas.practica01.model.Suculenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuculentaRepository extends JpaRepository<Suculenta, Integer> {
}
