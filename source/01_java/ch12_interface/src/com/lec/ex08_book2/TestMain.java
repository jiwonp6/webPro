package com.lec.ex08_book2;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890��-1010-1��", "java", "ȫ�浿"), 
							new BookLib("110��-5268-2��", "oracle", "�ű浿"),
							new BookLib("120��-8695-3��", "mysql", "�ڱ浿")};
		CDLib[] cds = { new CDLib("c01", "java_cd", "a01"), 
						new CDLib("c02", "ITtrend", null),
						new CDLib("c03", "jsp", "a02") 	};
		Scanner sc = new Scanner(System.in);
		int fn;		//��ɹ�ȣ(1:����, 2:�ݳ�, 3:ålist, 0:����)
		int idx;	//�����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		String bTitle, cTitle, borrower, checkOutDate;
	//do~while��
		do {
			System.out.println("1:����, 2:CD����, 3:å�ݳ�, 4:CD�ݳ�, 5:list, 0:����");
			fn = sc.nextInt();	
	//switch��
			switch (fn) {
			case 1:
				System.out.println("�����ϰ��� �ϴ� å�̸� : ");
				bTitle = sc.next();
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				}else {	
					if(books[idx].getState()==BookLib.STATE_BORROWED) {	//����Ұ��� ����
						System.out.println("���� �������� �����Դϴ�.");
					}else {
						System.out.println("���� �����մϴ�.");
						System.out.println("�����ڴ� : ");
						borrower = sc.next();
						System.out.println("�������� : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.println("�����ϰ��� �ϴ� CD�̸� : ");
				cTitle = sc.next();
				for(idx=0; idx<cds.length; idx++) {
					if(cTitle.equals(cds[idx].getCdTitle())) {
						break;
					}
				}
				if(idx==cds.length) {
					System.out.println("���� �������� ���� CD�Դϴ�.");
				}else {	
					if(cds[idx].getState()==CDLib.STATE_BORROWED) {
						System.out.println("���� �������� CD�Դϴ�.");
					}else {	
						System.out.println("���� �����մϴ�.");
						System.out.println("�����ڴ� : ");
						borrower = sc.next();
						System.out.println("�������� : ");
						checkOutDate = sc.next();
						cds[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 3:
					System.out.println("�ݳ��� å�̸���? ");
					bTitle = sc.next();
					for(idx=0; idx<books.length; idx++) {
						if(bTitle.equals(books[idx].getBookTitle())){
							break;
						}
					}
					if(idx == books.length) {
						System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
					}else {	
						books[idx].checkIn();
					}
				break;
			case 4:
				System.out.println("�ݳ��� CD�̸���? ");
				cTitle = sc.next();
				for(idx=0; idx<cds.length; idx++) {	//Ȯ��for�� ���� �ε����� ������ �� ����
					if(cTitle.equals(cds[idx].getCdTitle())){
						break;
					}
				}
				if(idx == cds.length) {
					System.out.println("�ش� CD�� �� �������� CD�� �ƴմϴ�.");
				}else {	
					cds[idx].checkIn();
				}
				break;
			case 5:
				System.out.println("\t===å list===");
				for(BookLib book : books) {
					book.printState();				
				}
				System.out.println("\t===Cd list===");
				for(CDLib cd : cds) {
					cd.printState();
				}
				break;
			}
		}while(fn!=0);
			System.out.println("bye");	
		}
	
	}

