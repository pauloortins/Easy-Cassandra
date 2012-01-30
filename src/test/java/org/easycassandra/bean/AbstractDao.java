package org.easycassandra.bean;

import java.util.List;

import org.easycassandra.persistence.EasyCassandraManager;
import org.easycassandra.persistence.Persistence;

public abstract class AbstractDao<T> {
	
	   private Persistence persistence;
	   
	   @SuppressWarnings("rawtypes")
	   private Class baseClass;

	  
	    public AbstractDao(Class<T> baseClass) {
	    	this.baseClass=baseClass;
	        persistence = EasyCassandraManager.getPersistence("javabahia", "localhost", 9160);
	    }

	    public boolean insert(T bean) {


	        return persistence.insert(bean);

	    }

	    public boolean remove(T bean) {


	        return persistence.delete(bean);
	    }

	    public boolean removeFromRowKey(Object rowKey) {


	        return persistence.deleteByKeyValue(rowKey, baseClass);

	    }

	    public boolean update(T bean) {


	        return persistence.update(bean);

	    }

	    public T retrieve(Object id) {


	        return (T) persistence.findByKey(id, baseClass);


	    }

	    @SuppressWarnings("unchecked")
	    public List<T> listAll() {


	        return persistence.findAll(baseClass);

	    }

	    @SuppressWarnings("unchecked")
	    public List<T> listByIndex(Object index) {

	        return persistence.findByIndex(index, baseClass);

	    }

}
