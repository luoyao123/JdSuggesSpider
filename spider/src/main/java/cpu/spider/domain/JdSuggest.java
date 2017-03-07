package cpu.spider.domain;

public class JdSuggest {
	private long id;
	private String key;
	private String data;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", key=" + key + ", data=" + data + "]";
	}
	
}
