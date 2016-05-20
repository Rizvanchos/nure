package ua.nure.ipz.zoo.model.enums;

public enum TicketType {
	
	CHILD(10), SCHOOL(10), STUDENT(15), STANDARD(30);
	
	private float price;

	private TicketType(float ticketPrice) {
		this.price = ticketPrice;
	}
	
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float ticketPrice){
		this.price = ticketPrice;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Price = " + getPrice();
	}
}
