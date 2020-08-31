package com.dxctraining.computermgt.computer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.computermgt.computer.entities.Computer;
import com.dxctraining.computermgt.exception.ComputerNotFoundException;

@Repository
public class ComputerDaoImpl implements IComputerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Computer save(Computer computer) {
		em.persist(computer);
		return computer;
	}
	
	@Override
	public Computer findComputerById(int id) {
		Computer computer = em.find(Computer.class, id);
		if (computer == null) {
			throw new ComputerNotFoundException("Computer not found");
		}
		return computer;
	}
	
	@Override
	public Computer update(Computer computer) {
		computer=em.merge(computer);
		return computer;
	}

	@Override
	public Computer remove(int id) {
		Computer computer = findComputerById(id);
		em.remove(computer);
		return computer;
	}
	@Override
	 public List<Computer> allComputers() {
     String jpaql="from Computer";
     TypedQuery<Computer>query=em.createQuery(jpaql,Computer.class);
     List<Computer>computerList=query.getResultList();
     return computerList;
 }

	@Override
	public List<Computer> allComputersBySupplier(int supplierId) {
		String jpaql = "from Computer where supplierId=:supplier";
		TypedQuery<Computer> query = em.createQuery(jpaql, Computer.class);
		query.setParameter("supplier", supplierId);
		List<Computer> computerList = query.getResultList();
		return computerList;
	}
}
