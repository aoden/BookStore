package com.tdt.bookstore.dao;

import java.io.Serializable;

/**
 * 
 * @author aoden
 *
 * @param <T> The entity type
 * @param <K> The entity's id type
 */
public interface PagingDao<T,K extends Serializable> extends DAO<T,K>{

	/**
	 * find total pages with given limit
	 * @param limit the number of items per page
	 * @return number of pages if input limit < 0 or exception the method returns null
	 */
	Long findTotalPages(Integer limit);
	/**
	 * Find total pages with given total and limit
	 * @param recordCount number of records
	 * @param limit number of items per page
	 * @return  number of pages
	 */
	Long findTotalPages(Long recordCount, Integer limit);
}
