package educationalmanagementsystem;

/**
 * 学生类
 * @author stone
 *
 */
public class Student {
	private long sno;				//学号
	private String password;		//密码
	private String name;			//姓名
	private int sex;				//性别（0代表女，1代表男）
	private int age;				//年龄
	private String tel;				//电话
	private String address;			//地址
	//空的构造函数
	public Student() {
	}
	//有参构造函数
	public Student(long sno, String password, String name, int sex, int age, String tel, String address) {
		super();
		this.sno = sno;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}
	//封装属性：sno
	public long getSno() {
		return sno;
	}
	public void setSno(long sno) {
		this.sno = sno;
	}
	//封装属性：password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//封装属性：name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//封装属性：sex
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		if(sex > 1 || sex < 0) {
			System.out.println("您输入的性别编号不在范围内，请重新输入！");
		}else {
			this.sex = sex;
		}
	}
	//封装属性：age
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age >100 || age < 0) {
			System.out.println("您输入的年龄不在范围内，请重新输入！");
		}else {
			this.age = age;
		}
	}
	//封装属性：电话号码
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	//封装属性：地址
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
