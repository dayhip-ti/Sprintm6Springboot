package cl.awakelab.sprint06.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador",nullable = false)
    private Integer idTrabajador;
    @Column(nullable = false,unique = true)
    private Integer run;
    @Column(length = 100,nullable = false)
    private String nombre;
    @Column(length = 100,nullable = false,name = "apellido_1")
    private String apellido1;
    @Column(length = 100,name = "apellido_2")
    private String apellido2;
    @Column(length = 100)
    private String email;
    //ID institucionPrevension
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //para poder escribir en formato Json
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision",nullable = false)
    private InstitucionPrevision institucionPrevision;
    //fin
    //ID institucionSalud
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //para poder escribir en formato Json
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud",nullable = false)
    private InstitucionSalud institucionSalud;
    //fin
    @Column(columnDefinition = "bigint")
    private Long telefono;
    //Conectando con Liquidacion
    @OneToMany(mappedBy = "trabajador",cascade = CascadeType.ALL)
    private List<Liquidacion> listarLiquidaciones;
    //Conectando con Empleado Muchos a muchos

    //private List<Empleador> listarEmpleadores;

    //emlazamos con trabajador Muchos a muchos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //para poder escribir en formato Json
    @ManyToMany
    @JoinTable(name = "empl_trab", //nombre de la tabla Detalle
            joinColumns = @JoinColumn(name = "id_trabajador", nullable = false), //nombre de mi campo id_emleador en BD
            inverseJoinColumns = @JoinColumn(name = "id_empleador",nullable = false)) //nombre de mi campo id_trabajado
    private List<Empleador> listarEmpleadores;
}
