package vo;

public class ProductVO {
	private int apple_cnt;
	private int banana_cnt;
	private int Hanla_cnt;
	
	
	
	public ProductVO(int apple_cnt, int banana_cnt, int hanla_cnt) {
		this.apple_cnt = apple_cnt;
		this.banana_cnt = banana_cnt;
		this.Hanla_cnt = hanla_cnt;
	}
	public int getApple_cnt() {
		return apple_cnt;
	}
	public void setApple_cnt(int apple_cnt) {
		this.apple_cnt += apple_cnt;
	}
	public int getBanana_cnt() {
		return banana_cnt;
	}
	public void setBanana_cnt(int banana_cnt) {
		this.banana_cnt += banana_cnt;
	}
	public int getHanla_cnt() {
		return Hanla_cnt;
	}
	public void setHanla_cnt(int hanla_cnt) {
		this.Hanla_cnt +=hanla_cnt;
	}
	
	
}
