package cr.ac.ufidelitas.practica01.controller;

import cr.ac.ufidelitas.practica01.model.Suculenta;
import cr.ac.ufidelitas.practica01.service.SuculentaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/suculentas")
public class SuculentaController {

    private final SuculentaService suculentaService;

    public SuculentaController(SuculentaService suculentaService) {
        this.suculentaService = suculentaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("suculentas", suculentaService.listarSuculentas());
        return "suculentas/listado";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("suculenta", new Suculenta());
        model.addAttribute("titulo", "Registrar suculenta");
        model.addAttribute("accion", "/suculentas/guardar");
        return "suculentas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("suculenta") Suculenta suculenta,
                          BindingResult resultado,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        if (resultado.hasErrors()) {
            model.addAttribute("titulo", suculenta.getIdSuculenta() == null
                    ? "Registrar suculenta" : "Editar suculenta");
            model.addAttribute("accion", "/suculentas/guardar");
            return "suculentas/formulario";
        }

        suculentaService.guardar(suculenta);
        redirectAttributes.addFlashAttribute("mensaje", "La suculenta se guardó correctamente.");
        return "redirect:/suculentas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model,
                         RedirectAttributes redirectAttributes) {
        return suculentaService.buscarPorId(id).map(suculenta -> {
            model.addAttribute("suculenta", suculenta);
            model.addAttribute("titulo", "Editar suculenta");
            model.addAttribute("accion", "/suculentas/guardar");
            return "suculentas/formulario";
        }).orElseGet(() -> {
            redirectAttributes.addFlashAttribute("error", "No se encontró la suculenta solicitada.");
            return "redirect:/suculentas";
        });
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (suculentaService.buscarPorId(id).isPresent()) {
            suculentaService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "La suculenta se eliminó correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("error", "No se encontró la suculenta solicitada.");
        }
        return "redirect:/suculentas";
    }
}
