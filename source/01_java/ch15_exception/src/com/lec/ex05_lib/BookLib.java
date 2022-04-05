package com.lec.ex05_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkoutDate;
	private byte state;	//대출중(1) or 대출가능(0)
	
//생성자	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	//BookLib book = new BookLib("89a-01", "java", "홍길동");
	//book.CheckOut("신길동") : 도서상태 확인 -> 대출로직 -> 도서상태출력
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state==STATE_BORROWED) {
			throw new Exception(bookTitle +"도서는 *대출중* 입니다.");	//강제로 예외 발생
		}
		//대출로직
		this.borrower = borrower;
		checkoutDate = new Date();
		state = STATE_BORROWED;
		//java 도서가 대출되었습니다. 대출인 : 신길동 대출일 : 2022-04-04(2주내에 반납하세요.)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		System.out.println("\""+bookTitle+"\" 도서가 대출되었습니다.");
		System.out.println("대출인 : "+borrower+"/대출일 : "+sdf.format(checkoutDate)+"(2주내로 반납하세요.)");
	}
	//book.checkIn() : 도서상태 확인 -> 연체여부 확인 -> (if. 연체O : 연체료납부y/n) -> 반납로직 -> 상태출력
	@Override
	public void checkIn() throws Exception {
		 if(state==STATE_NORMAL) {
			 throw new Exception(bookTitle +"도서는 대출중이 아닙니다.");
		 }
		 //연체여부 확인 checkOutDate ~ 현재까지 14일이내인지 여부 확인
		Date now = new Date();
		long diff = now.getTime() - checkoutDate.getTime();	//대출시점부터 현재까지의 밀리세컨즈
		long day = diff/(1000*60*60*24);
		//연체여부 확인
		if(day > 14) {	//연체O
			System.out.println("<연체료는 일일 100원 부과됩니다> \n내셔야할 연체료는 "+(day-14)*100+"원");
			Scanner sc = new Scanner(System.in);
			System.out.println("연체료를 납부하셨나요?(y/n)");
			if(! sc.next().equalsIgnoreCase("y")) {	//연체료를 냈다고 y(Y)를 입력하지않은 경우
				System.out.println("연체료를 납부하셔야 반납처리가 가능합니다. 연체료를 납부해주세요.");
				return;	//void이므로 return만 써야함.
			}
		}
		//연체X -> 반납로직 바로 수행
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"도서가 *반납*되었습니다.");
//toString
	}
	//sysout(book) -> 책번호:89ㅁ-01 책이름:java 저자:홍길동 대출가능
	//			   -> 책번호:89ㅁ-01 책이름:java 저자:홍길동 대출중(대출일:2022-04-18(월))
	@Override
	public String toString() {
		String msg = "책번호:"+bookNo+" 책이름:"+bookTitle+" 저자:"+writer;
		msg += (state == STATE_NORMAL) ? " (대출가능) " : " (대출중) ";
		if(state == STATE_BORROWED) {
			//빌린시점 + 14일
			SimpleDateFormat sdf = new SimpleDateFormat("대출일:yyyy-MM-dd(E)");
			msg += sdf.format(checkoutDate);
		}
		return msg;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
}

