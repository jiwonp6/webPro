package com.lec.ex;
// �������� : &&(and), ||(or) 
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		
		// &&������ ������ F�� ���� ����X
		boolean result = ((i>j) && (++j>h));//i>j�� F�̹Ƿ� j ����X
		System.out.println("result="+result+"\t j="+j);
		
		// ||������ ������ T�̸� ���� ����X -> ��, �����Ű���� ���� F�� ��ƾ� �� 
		result = ((i<j) || (++j>h));
		System.out.println("result="+result+"\t j="+j);	
	}
}
