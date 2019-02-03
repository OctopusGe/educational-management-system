package educationalmanagementsystem;

/**
 * 好友类
 * @author stone
 *
 */
public class Friend {
	private long myNO;							//自己的编号
	private long[] friendNO = new long[10];		//好友的编号
	private String[] note = new String[10];		//好友的备注
	private int friendsSize;					//好友数量
	//构造函数
	public Friend() {}
	public Friend(long myNO) {
		super();
		this.myNO = myNO;
	}
	//封装属性：好友的编号
	public long getFriendsNO(int no) {
		return friendNO[no];
	}
	public void setFriendsNO(long friendNO,int no) {
		this.friendNO[no] = friendNO;
	}
	//封装属性：好友备注
	public String getNote(int no) {
		return note[no];
	}
	public void setNote(String note,int no) {
		this.note[no] = note;
	}
	//封装属性：好友数量
	public int getFriendsSize() {
		return friendsSize;
	}
	public void setFriendsSize(int friendsSize) {
		this.friendsSize = friendsSize;
	}
	
}
