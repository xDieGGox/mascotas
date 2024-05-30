package mascotas.mascotas.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Mascota{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascotas_codigo_mascota_seq")
    @SequenceGenerator(name = "mascotas_codigo_mascota_seq", sequenceName = "mascotas_codigo_mascota_seq", allocationSize = 1)
	private int codigo_mascota;
	private String especie;
	private String raza;
	private String nombre;
	
	
	//GETTERS AND SETTERS
	public int getCodigo_mascota() {
		return codigo_mascota;
	}
	public void setCodigo_mascota(int codigo_mascota) {
		this.codigo_mascota = codigo_mascota;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	///TO STRING
	@Override
	public String toString() {
		return "Mascota [codigo_mascota=" + codigo_mascota + ", especie=" + especie + ", raza=" + raza + ", nombre="
				+ nombre + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}