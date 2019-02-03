package educationalmanagementsystem;

/**
 * 教师类
 * @author stone
 *
 */
public class Teacher {
	private String name;	
	private String userName;		//用户名
	private String password;		//密码
	private int sex;				//性别（0代表女，1代表男）
	private int age;				//年龄
	private String tel;				//电话
	private String address;			//地址
	
	public Teacher(String name,String userName, String password, int sex, int age, String tel, String address) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
}
