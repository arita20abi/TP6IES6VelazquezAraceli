package air.edu.ies6.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Docente {
	@Column
	private String nombre;
	@Column
    private String apellido;
    @Id
    private String dni;
    @Column
    private String barrio;
    @Column
    private String calle;
    @Column
    private String numero;
    @Column
    private String localidad;
    @Column
    private String telefono;
    @Column
    private String gmail;
    @Column
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;   
    @Column
    private int edad;
    @Column
    private Boolean estado;
    
    public Docente() {
    }
    //constructor 
    public Docente(String nombre, String apellido, String dni, String barrio, String calle, String numero,String localidad, String telefono, String gmail, LocalDate fechaNacimiento, int edad,Boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.barrio = barrio;
        this.calle = calle;
        this.numero= numero;
        this.localidad = localidad;
        this.telefono = telefono;
        this.gmail = gmail;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.estado= estado;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	

	
	
}
