package principal.daos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;
	@Column
	private int codigo;
	
	
	public Integer getId() {
		// TODO Auto-generated method stub
	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
