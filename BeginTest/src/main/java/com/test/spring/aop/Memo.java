package com.test.spring.aop;

public interface Memo {

	void add(String memo);

	String read(int seq) throws Exception;

	boolean edit(int seq, String memo);

	boolean del(int seq);

}
