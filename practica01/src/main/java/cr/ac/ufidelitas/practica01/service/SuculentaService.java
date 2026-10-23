package cr.ac.ufidelitas.practica01.service;

import cr.ac.ufidelitas.practica01.model.Suculenta;
import cr.ac.ufidelitas.practica01.repository.SuculentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuculentaService {

    private final SuculentaRepository suculentaRepository;

    public SuculentaService(SuculentaRepository suculentaRepository) {
        this.suculentaRepository = suculentaRepository;
    }

    public List<Suculenta> listarSuculentas() {
        return suculentaRepository.findAll();
    }

    public Optional<Suculenta> buscarPorId(Integer id) {
        return suculentaRepository.findById(id);
    }

    public Suculenta guardar(Suculenta suculenta) {
        return suculentaRepository.save(suculenta);
    }

    public void eliminar(Integer id) {
        suculentaRepository.deleteById(id);
    }
}
