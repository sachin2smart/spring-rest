package in.sachinshinde.springrestdemo.model;

public class Message {

	private String content;

	public Message() {
		super();
	}

	public Message(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Message [content=" + content + "]";
	}
	
}
