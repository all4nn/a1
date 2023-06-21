package principal.daos;

import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PacienteDAO {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public Paciente buscarPorId(Integer id) {
		Paciente paciente = em.find(Paciente.class, id);
		return paciente;
	}

	public List<Paciente> listar() {
		List<Paciente> Paciente = em.createQuery("from Paciente", Paciente.class).getResultList();
		return Paciente;
	}

	public Integer salvar(Paciente paciente) {
		em.getTransaction().begin();
		em.persist(paciente);
		em.getTransaction().commit();
		return paciente.getId();

	}
	
	public Integer atualizar(Paciente paciente) {
		em.getTransaction().begin();
		em.merge(paciente);
		em.getTransaction().commit();
		return paciente.getId();
	}
	
	public void apagar(Integer id) {
		Paciente p = em.find(Paciente.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}

	public void close() {
		em.close();
		emf.close();
		
	}

}
