package pl.javastart.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.javastart.model.TodoTask;

/**
 * Session Bean implementation class TaskRepository
 */
@Stateless
@LocalBean
public class TaskRepository {

    
	@PersistenceContext
	private EntityManager em;
	
    public TaskRepository() {}
    
    
    public void add(TodoTask task) {
    	em.persist(task);
    }
    
    public void remove(TodoTask task) {
    	em.remove(task);
    }
    
    public List<TodoTask> getAll() {
    	TypedQuery<TodoTask> query = em.createNamedQuery("TodoTask.findAll", TodoTask.class);
    	List<TodoTask> list =  query.getResultList();
    	return list;
    }
    

}
