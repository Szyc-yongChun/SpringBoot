package aa.mine.Entity;

public class ErrorInfo<TM,TD> {

	public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private TM message;
    private String url;
    private TD data;
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public TM getMessage() {
		return message;
	}
	public void setMessage(TM message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public TD getData() {
		return data;
	}
	public void setData(TD data) {
		this.data = data;
	}
   
    
}
