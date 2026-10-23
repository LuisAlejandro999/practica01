package cr.ac.ufidelitas.practica01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "suculenta")
public class Suculenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;

    @NotBlank(message = "El nombre común es obligatorio.")
    @Size(max = 100)
    @Column(name = "nombre_comun", nullable = false, length = 100)
    private String nombreComun;

    @NotBlank(message = "El nombre científico es obligatorio.")
    @Size(max = 150)
    @Column(name = "nombre_cientifico", nullable = false, length = 150)
    private String nombreCientifico;

    @NotBlank(message = "La familia es obligatoria.")
    @Size(max = 100)
    @Column(name = "familia", nullable = false, length = 100)
    private String familia;

    @NotBlank(message = "Indique el color principal.")
    @Size(max = 50)
    @Column(name = "color_principal", nullable = false, length = 50)
    private String colorPrincipal;

    @NotNull(message = "Indique la altura en centímetros.")
    @Min(value = 1, message = "La altura debe ser al menos 1 cm.")
    @Column(name = "altura_cm", nullable = false)
    private Integer alturaCm;

    @NotNull(message = "Indique el precio estimado.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo.")
    @Column(name = "precio_estimado", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioEstimado;

    @NotBlank(message = "Seleccione el nivel de riego.")
    @Size(max = 30)
    @Column(name = "nivel_riego", nullable = false, length = 30)
    private String nivelRiego;

    @NotBlank(message = "La URL de imagen es obligatoria.")
    @Size(max = 500)
    @Column(name = "ruta_imagen", nullable = false, length = 500)
    private String rutaImagen;

    public Suculenta() {
    }

    public Integer getIdSuculenta() {
        return idSuculenta;
    }

    public void setIdSuculenta(Integer idSuculenta) {
        this.idSuculenta = idSuculenta;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Integer getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(Integer alturaCm) {
        this.alturaCm = alturaCm;
    }

    public BigDecimal getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(BigDecimal precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public String getNivelRiego() {
        return nivelRiego;
    }

    public void setNivelRiego(String nivelRiego) {
        this.nivelRiego = nivelRiego;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
