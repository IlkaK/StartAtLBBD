package main.java.ch.start.uebungen;

import java.math.BigDecimal;

public class FileEntry {
	
	BigDecimal positionNumber;
	String iban;
	BigDecimal quantity;
	String currency;
	String owner;
	BigDecimal orderNumber;
	String orderType;
	
	public String toString() {
		return "PositionNumber = " +positionNumber+", "+ "Iban = " +iban+ ", Quantity = " +quantity+ ", "
				+ "Currency = "+currency+ ", Owner = " +owner+ ", "
				+ "OrderNumber = " + orderNumber + ", OrderType = " + orderType;

	}
	

}
