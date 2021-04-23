package gdu.diary.vo;

public class Todo {
	private int todoNo;
	private int memberNo;
	private String todoDate;
	private String stodoTitle;
	private String todoContent;
	private String todoFontColor;
	
	public int getTodoNo() {
		return todoNo;
	}
	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}
	public String getStodoTitle() {
		return stodoTitle;
	}
	public void setStodoTitle(String stodoTitle) {
		this.stodoTitle = stodoTitle;
	}
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
	public String getTodoFontColor() {
		return todoFontColor;
	}
	public void setTodoFontColor(String todoFontColor) {
		this.todoFontColor = todoFontColor;
	}
	
	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", memberNo=" + memberNo + ", todoDate=" + todoDate + ", stodoTitle="
				+ stodoTitle + ", todoContent=" + todoContent + ", todoFontColor=" + todoFontColor + "]";
	} 
	
	
}
