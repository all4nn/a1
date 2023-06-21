package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MedicamentoDAO {
	
	private EntityManager em;
	private EntityManagerFactory emf;

	
	public MedicamentoDAO() {
		emf = Persistence.createEntityManagerFactory("a1_db");
		em = emf.createEntityManager();
	}
	
	public Medicamento buscarPorId(Integer id) {
		Medicamento medicamento = em.find(Medicamento.class, id);
		return medicamento;
	}

	
	public List<Medicamento> listar() {
		List<Medicamento> lista = em.createQuery("from Medicamento", Medicamento.class).getResultList();
		return lista;
	}

	
	public Integer salvar(Medicamento medicamento) {
		em.getTransaction().begin();
		em.persist(medicamento);
		em.getTransaction().commit();
		return medicamento.getId();

	}

	
	public Integer atualizar(Medicamento medicamento) {
		em.getTransaction().begin();
		em.merge(medicamento);
		em.getTransaction().commit();
		return medicamento.getId();
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
