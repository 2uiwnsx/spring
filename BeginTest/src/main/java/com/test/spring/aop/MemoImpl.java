package com.test.spring.aop;

public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {

		System.out.println("메모 등록: " + memo);
		
	}

	@Override
	public String read(int seq) throws Exception {
		
		if (seq < 10) {
			
			System.out.println("메모 내용");
			
		} else {
			
			throw new Exception("존재하지 않는 메모");
			
		}

		return "메모 읽기 완료";
		
	}

	@Override
	public boolean edit(int seq, String memo) {

		System.out.println("메모 수정: " + memo);
		
		return true;
		
	}

	@Override
	public boolean del(int seq) {

		System.out.println("메모 삭제: " + seq);
		
		return true;
		
	}

}
