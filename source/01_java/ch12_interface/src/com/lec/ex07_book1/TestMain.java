package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Book[] books = {new Book("890��-1010-1��", "java", "ȫ�浿"), 
				new Book("110��-5268-2��", "oracle", "�ű浿"),
				new Book("120��-8695-3��", "mysql", "�ڱ浿")};
		Scanner sc = new Scanner(System.in);
		int fn;		//��ɹ�ȣ(1:����, 2:�ݳ�, 3:ålist, 0:����)
		int idx;	//�����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate;	//����ڿ��� ���� å�̸�, ������, ������
	//do~while��
		do {
			System.out.println("1:����, 2:�ݳ�, 3:ålist, 0:����");
			fn = sc.nextInt();	
	//switch��
			switch (fn) {
			case 1:	//���� : 1.å�̸��Է� 2.å��ȸ 3.���Ⱑ�ɿ���Ȯ�� 
								//4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
				//1.å�̸��Է�
				System.out.println("�����ϰ��� �ϴ� å�̸� : ");
				bTitle = sc.next();	//�����̽�����X
				//2.å��ȸ
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//å��ȸfor
				if(idx==books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				}else {	//books[idx] ������ ���� ó��
				//3.���Ⱑ�ɿ���Ȯ��
					if(books[idx].getState()==Book.STATE_BORROWED) {	//����Ұ��� ����
						System.out.println("���� �������� �����Դϴ�.");
					}else {	//���Ⱑ�ɻ���
						System.out.println("���� �����մϴ�.");
				//4.�������Է�
						System.out.println("�����ڴ� : ");
						borrower = sc.next();
				//5.�������Է�
						System.out.println("�������� : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2://�ݳ� : 1.å�̸� 2.å��ȸ 3.�ݳ�ó��
					//1.å�̸�
					System.out.println("�ݳ��� å�̸���? ");
					bTitle = sc.next();
					for(idx=0; idx<books.length; idx++) {	//Ȯ��for�� ���� �ε����� ������ �� ����
						if(bTitle.equals(books[idx].getBookTitle())){
							break;
						}
					}//2.å��ȸ
					if(idx == books.length) {
						System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
					}else {	//idx�� ã�� �� ��ġ
					//3.�ݳ�ó��
						books[idx].checkIn();
					}
				
				break;
			case 3:
				System.out.println("\t===å list===");
				for(Book book : books) {
					book.printState();				
				}
				break;
		}
		}while(fn!=0);
			System.out.println("bye");
		
	//while��
//		while(true) {
//			System.out.println("1:����, 2:�ݳ�, 3:ålist, 0:����");
//			fn = sc.nextInt();
//			if(fn==0) {
//				break;
//			}
			
		}
	
	}

