package com.test.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDAOImpl implements AOPDAO {

	@Override
	public void list() {

		System.out.println("AOPDAOImpl.list()");
		
	}

	@Override
	public void add() {

		System.out.println("AOPDAOImpl.add()");
		
	}

	@Override
	public void view() {

		System.out.println("AOPDAOImpl.view()");
		
	}

}
