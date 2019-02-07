package educationalmanagementsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 管理类
 * @author stone
 *
 */
public class Manager {
	
	Scanner input = new Scanner(System.in);
	Teacher teacher = new Teacher("王校长","admin", "123456", 0, 30, "0810245", "北京");
	Student[] students = new Student[15];
	Friend[] friends = new Friend[14];
	private int stuSize;					//记录现有学生数量
	/**
	 * 初始化学生信息
	 */
	public Manager() {
		
		students[0] = new Student(1023694, "123456", "诸葛孔明", 1, 29, "0808005", "卧龙坡");
		friends[0] = new Friend(1023694);				//为每个同学分配一个好友类
		students[1] = new Student(1157621, "123456", "刘备", 1, 25,"0805762", "河北");
		friends[1] = new Friend(1157621);
		students[2] = new Student(1854265,"123581","李白",1,23,"0745216","长安");
		friends[2] = new Friend(1854265);
		students[3] = new Student(1354685,"123000","王昭君",0,21,"0946123","匈奴");
		friends[3] = new Friend(1354685);
		students[4] = new Student(1574169,"000456","令狐冲",1,26,"0895412","华山");
		friends[4] = new Friend(1574169);
		students[5] = new Student(1222547,"456777","貂蝉",0,22,"0855246","成都");
		friends[5] = new Friend(1222547);
		students[6] = new Student(1854126,"888888","吕布",1,25,"0245687","内蒙古");
		friends[6] = new Friend(1854126);
		students[7] = new Student(1788514,"111111","小乔",0,20,"0801111","安徽");
		friends[7] = new Friend(1788514);
		students[8] = new Student(1788515,"222222","大乔",0,21,"0802222","安徽");
		friends[8] = new Friend(1788515);
		stuSize = 9 ;
		
	}
	/**
	 * 登录界面
	 */
	public void loginUI() {
		System.out.println("******************用户登录*****************");
		System.out.println("*\t\t1.学生登录\t\t*");
		System.out.println("*\t\t2.老师登录\t\t*");
		System.out.println("*\t\t3.退\t出\t\t*");
		System.out.println("******************************************");
		System.out.print("请输入登录选项：");
		int no = (int)setNumber();		
		switch (no) {
		case 1:
			System.out.print("请输入账号：");
			long sno = input.nextLong();
			System.out.print("请输入密码：");
			String password = input.next();
			//验证学生账号
			if(stuConfirm(sno,password) != -1) {
				System.out.println("学生登录成功！");
				System.out.println(students[stuConfirm(sno,password)].getName()+"，欢迎你！");
				//验证成功，加载学生菜单
				studentMenu(sno);
			}else {
				//验证不通过，打印提示信息
				System.out.println("账号或者密码错误！");
			}
			break;
		
		case 2:
			System.out.print("请输入账号：");
			String userName = input.next();
			System.out.print("请输入密码：");
			String teaPassword = input.next();
			//验证教师账号
			if(teacher.getUserName().equals(userName) && teacher.getPassword().equals(teaPassword)) {
				System.out.println("老师登录成功!");
				System.out.println(teacher.getName()+"，欢迎你！");
				//验证成功，加载教师菜单
				teacherMenu();
			}else {
				//验证不通过，打印提示信息
				System.out.println("账号或者密码错误！");
			}
			break;
		
		case 3:
			System.out.println("欢迎下次使用！");
			break;
			
		default:
			System.out.println("您的输入有误，请重新输入！");
			break;
		}
	}
	/**
	 * 学生端功能菜单
	 */
	private void studentMenu(long sno) {
		int flag = 1;
		do {
			System.out.println("***************欢迎使用教务管理系统***************");
			System.out.println("*\t1.查询个人信息");
			System.out.println("*\t2.修改密码");
			System.out.println("*\t3.查询同学信息");
			System.out.println("*\t4.添加好友");
			System.out.println("*\t5.显示我的所有好友信息");
			System.out.println("*\t6.保存好友信息");
			System.out.println("*\t7.给好友留言");
			System.out.println("*\t8.查看我的留言板");
			System.out.println("*\t9.删除好友");
			System.out.println("*\t10.修改好友备注");
			System.out.println("*\t0.按任意键退出");
			System.out.println("***********************************************");
			System.out.print("请输入选项：");
			int num = (int)setNumber();
			switch (num) {
			case 1:
				showMe(sno);
				break;
			case 2:
				alterPassword(sno);
				break;
			case 3:
				showStudent(sno);
				break;
			case 4:
				addFriend(sno);
				break;
			case 5:
				showMyFriends(sno);
				break;
			case 6:
				System.out.println("**************保存好友信息***************");
				break;
			case 7:
				System.out.println("**************给好友留言***************");
				break;
			case 8:
				System.out.println("**************查看我的留言板***************");
				break;
			case 9:
				//System.out.println("**************删除好友***************");
				delFriend(sno);
				break;
			case 10:
				System.out.println("**************修改好友备注***************");
				break;
			case 0:
				input.next();
				flag--;
				System.out.println("欢迎下次使用！");
				break;
			default:
				System.out.println("您的输入有误，请重新输入！");
				break;
			}
			System.out.print("是否继续（Y/N）：");
			if(input.next().equalsIgnoreCase("N") ) {
				flag--;
				System.out.println("欢迎下次使用！");
			}
		}while(flag != 0);
	}
	/**
	 * 删除好友
	 * @param sno
	 */
	private void delFriend(long sno) {
		System.out.println("****************好友列表****************");
		showMyFriends(sno);	
		System.out.print("请输入您要删除的好友QQ号：");
		long delFriendQQ = setNumber();
		int k = searchStu(sno);
		//定义是否找到好友QQ号的布尔值，初始值为false
		boolean flag = false;
		for(int i = 0; i < friends[k].getFriendsSize(); i++) {
			if(friends[k].getFriendsNO(i) == delFriendQQ) {
				//找到好友QQ号，改初始值为true
				flag = true;
			}
			//布尔值改变后，将后面的好友信息往前移一位
			if(flag == true && i < friends[k].getFriendsSize()-1) {
				friends[k].setFriendsNO(friends[k].getFriendsNO(i+1), i);
				friends[k].setNote(friends[k].getNote(i+1), i);
			}
		}
		if(flag == true) {
			System.out.println("已删除！");
			//将原先位置最后一位好友信息置为空
			friends[k].setNote(null, friends[k].getFriendsSize()-1);
			friends[k].setFriendsSize(friends[k].getFriendsSize()-1);
			System.out.println("-------------------删除后的信息如下------------------");
			showMyFriends(sno);	
		}else {
			System.out.println("您输入的QQ号有误！");
		}
	}
	/**
	 * 查询好友信息
	 * @param sno
	 */
	private void showMyFriends(long sno) {
		int k = searchStu(sno);
		//定义该同学是否有好友的布尔值，初始值为false
		boolean flag = false;
		for(int i = 0; i < friends[k].getFriendsSize(); i++) {
			//进入for循环说明已经添加有好友，打印好友信息栏，并将布尔值改为true
			if(i == 0) {
				System.out.println("好友QQ号\t好友备注\t姓名\t性别\t年龄\t电话\t住址");
				flag = true;
			}
			//好友QQ号
			long friendQQ = friends[k].getFriendsNO(i);
			//好友备注
			String note = friends[k].getNote(i);
			//姓名
			String name = students[searchStu(friendQQ)].getName();
			//性别
			int friendSex = students[searchStu(friendQQ)].getSex();
			String sex;
			if(friendSex == 0) {
				sex = "女";
			}else {
				sex = "男";
			}
			//年龄
			int age = students[searchStu(friendQQ)].getAge();
			//电话
			String tel = students[searchStu(friendQQ)].getTel();
			//住址
			String address = students[searchStu(friendQQ)].getAddress();
			//打印好友信息
			System.out.println(friendQQ+"\t"+note+"\t"+name+"\t"+sex+"\t"+age+"\t"+tel+"\t"+address);
		}
		//没有好友，打印提示信息
		if(flag == false) {
			System.out.println("您还没有添加好友！");
		}
	}
	/**
	 * 添加好友
	 * @param sno
	 */
	private void addFriend(long sno) {
		System.out.println("***************未添加的同学列表***************");
		showSchoolmate(sno,"notFriends");
		System.out.print("请输入您要添加好友的QQ号：");
		long friendNO = setNumber();
		int i = searchStu(sno);
		int k = searchStu(friendNO);
		if(k == i) {
			System.out.println("不能添加自己！");
		}else if(k != -1) {
			//定义一个是否已经添加该好友的布尔值，初始值为false
			boolean flag = false;
			//遍历好友列表
			for(int j = 0; j < friends[i].getFriendsSize(); j++) {
				if(friendNO == friends[i].getFriendsNO(j)) {
					//已存在该好友，改变布尔值为true
					flag = true;
					break;
				}
			}
			//为存在该好友则添加
			if(flag == false) {
				friends[i].setFriendsNO(friendNO, friends[i].getFriendsSize());
				System.out.print("好友备注：");
				friends[i].setNote(input.next(), friends[i].getFriendsSize());
				friends[i].setFriendsSize(friends[i].getFriendsSize()+1);
				System.out.println("添加成功！");
				System.out.println("----------------添加后的好友关系如下--------------");
				showSchoolmate(sno,"all");
			}else {			//已存在该好友，则打印提示信息
				System.out.println("该QQ号已是您的好友！");
			}
		}else {
			System.out.println("您输入的QQ号有误！");
		}
	}
	/**
	 * 学生端查询学生信息
	 * @param sno
	 */
	private void showStudent(long sno) {
		System.out.println("**************查询同学信息***************");
		System.out.println("*\t1.查询所有同学信息");
		System.out.println("*\t2.根据指定编号查询单个同学信息");
		System.out.println("*\t3.根据姓名模糊查询同学信息");
		System.out.println("*\t4.根据地址模糊查询同学信息");
		System.out.println("*\t5.根据年龄段查询同学信息");
		System.out.println("*\t6.退出查询");
		System.out.println("***************************************");
		System.out.print("请输入查询选项：");
		int num = (int) setNumber();
		switch (num) {
		case 1:
			showSchoolmate(sno, "all");
			break;
		case 2:
			relySno("student");    
			break;
		case 3:
			relyName("student");
			break;
		case 4:
			relyAddress("student");
			break;
		case 5:
			relyAgeRange("student");
			break;
		case 6:
			break;
		default:
			System.out.println("您输入的选项编号有误！请重新输入");
			break;
		}
	}
	/**
	 * 选择类型展示同学信息（可以选择加载全部同学信息和不是好友的同学信息）
	 * @param sno
	 * @param type	（all或者notFriends）
	 */
	private void showSchoolmate(long sno, String type) {
		int k = searchStu(sno);
		System.out.println("******************查询同学信息*********************");
		System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址\t好友");
		String sex;
		for(int i = 0; i < stuSize; i++) {
			if(students[i].getSex() == 0) {
				sex = "女";
			}else {
				sex = "男";
			}
			String isFriend = "×";
			//查询QQ号是否在好友列表里
			for(int j = 0; j < friends[k].getFriendsSize();j++) {
				if(friends[k].getFriendsNO(j) == students[i].getSno()) {
					isFriend = "️√";
				}
			}
			//跳过选择加载类型为未添加且已经是好友，和自己的信息
			if((type.equals("notFriends") && isFriend.equals("️√")) || i==k) {
				continue;
			}
			System.out.println(students[i].getSno()+"\t"+students[i].getName()+"\t"+sex+"\t"
					+students[i].getAge()+"\t"+students[i].getTel()+"\t"+students[i].getAddress()+"\t"+isFriend);
		}
	}
	/**
	 * 学生端修改密码
	 * @param sno
	 */
	private void alterPassword(long sno) {
		int i = searchStu(sno);
		System.out.print("请输入您的原始密码：");
		String oldPassword = input.next();
		System.out.print("请输入新的密码：");
		String newPassword1 = input.next();
		System.out.print("请输入新的密码：");	
		String newPassword2 = input.next();
		if(!students[i].getPassword().equals(oldPassword)) {
			System.out.println("您输入的旧密码不对！");
		}else if(!newPassword1.equals(newPassword2)){
			System.out.println("您输入的两次新密码不一致！");
		}else {
			System.out.println("修改成功！");
		}
	}
	/**
	 * 学生端展示个人信息
	 * @param sno
	 */
	private void showMe(long sno) {
		System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址");
		showMessage(searchStu(sno), "student");
	}
	/**
	 * 教师端功能菜单
	 */
	private void teacherMenu() {
		int flag = 1;
		do {
			System.out.println("***************欢迎使用教务管理系统***************");
			System.out.println("*\t1.添加学生信息");
			System.out.println("*\t2.查询学生信息");
			System.out.println("*\t3.修改学生信息");
			System.out.println("*\t4.删除学生信息");
			System.out.println("*\t5.保存学生信息");
			System.out.println("*\t6.加载学生信息");
			System.out.println("*\t0.按任意键退出");
			System.out.println("***********************************************");
			System.out.print("请输入选项：");
			int num = (int)setNumber();
			switch (num) {
			case 1:
				addStudent();
				break;
			case 2:
				showStudent();
				break;
			case 3:
				alterStudent();
				break;
			case 4:
				delStudent();
				break;
			case 5:
				System.out.println("**************保存学生信息***************");
				break;
			case 6:
				System.out.println("**************加载学生信息***************");
				break;
			case 0:
				input.next();
				flag--;
				System.out.println("欢迎下次使用！");
				break;
			default:
				System.out.println("您的输入有误，请重新输入！");
				break;
			}
			System.out.print("是否继续（Y/N）：");
			if(input.next().equalsIgnoreCase("N") ) {
				flag--;
				System.out.println("欢迎下次使用！");
			}
		}while(flag != 0);
	}
	/**
	 * 删除学生信息
	 */
	private void delStudent() {
		System.out.println("****************删除学生信息*****************");
		showAll("teacher");
		System.out.print("请输入您要删除的QQ号：");
		long sno = setNumber();
		//找出要删除的QQ号的位置，其后面的学生信息往前移一位
		for(int i = searchStu(sno); i < stuSize-1; i++) {
			students[i] = students[i+1];
		}
		students[searchStu(sno)] = null;		//最后一个置为空
		stuSize--;
		System.out.println("--------------删除后的信息如下：---------------");
		showAll("teacher");
	}
	/**
	 * 修改学生信息
	 */
	private void alterStudent() {
		System.out.println("****************修改学生信息*****************");
		showAll("teacher");
		System.out.print("请输入您要修改的QQ号：");
		long sno = setNumber();
		int i = searchStu(sno);
		if(i != -1) {
			System.out.print("请输入新的QQ号：");
			students[i].setSno(setNumber());
			System.out.print("请输入新的密码：");
			students[i].setPassword(input.next());
			System.out.print("请输入新的姓名：");
			students[i].setName(input.next());
			System.out.print("请输入新的性别（0代表女，1代表男）：");
			students[i].setSex(setSexNumber());
			System.out.print("请输入新的年龄：");
			students[i].setAge(setAgeNumber());
			System.out.print("请输入新的电话：");
			students[i].setTel(input.next());
			System.out.print("请输入新的地址：");
			students[i].setAddress(input.next());
			System.out.println("--------------修改后的信息如下：---------------");
			showAll("teacher");
		}else {
			System.out.println("您输入的QQ号有误！");
		}
	}
	/**
	 * 设置年龄数字
	 * @return	0到100内的整数
	 */
	private int setAgeNumber() {
		int age;
		while(true) {								//死循环
			try {
				age = input.nextInt();				
				if(age > 100 || age < 0)	
					throw new MyInputMismatchException("输入有误！");		
				break;								//输入的值范围在0到100就结束死循环
			} catch (InputMismatchException e) {
				System.out.print("请输入一个数字：");
				input = new Scanner(System.in);		//输入不是数字的值，就重新输入
			} catch (MyInputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.print("请输入0到100的数字：");
				input = new Scanner(System.in);		//输入数字的值不在1到100范围内，就重新输入
			}
		}
		return age;
	}
	/**
	 * 查询学生信息功能模块
	 */
	private void showStudent() {
		System.out.println("**************查询学生信息***************");
		System.out.println("*\t1.查询所有学生信息");
		System.out.println("*\t2.根据指定编号查询单个学生信息");
		System.out.println("*\t3.根据姓名模糊查询学生信息");
		System.out.println("*\t4.根据地址模糊查询学生信息");
		System.out.println("*\t5.根据年龄段查询学生信息");
		System.out.println("*\t6.退出查询");
		System.out.println("***************************************");
		System.out.print("请输入查询选项：");
		int num = (int) setNumber();
		switch (num) {
		case 1:
			showAll("teacher");
			break;
		case 2:
			relySno("teacher");
			break;
		case 3:
			relyName("teacher");
			break;
		case 4:
			relyAddress("teacher");
			break;
		case 5:
			relyAgeRange("teacher");
			break;
		case 6:
			break;
		default:
			System.out.println("您输入的选项编号有误！请重新输入");
			break;
		}
	}
	/**
	 * 根据年龄段查询学生信息
	 * @param role	不同的身份，展示的信息不一样
	 */
	private void relyAgeRange(String role) {
		System.out.print("请输入起始年龄：");
		int startAge = (int)setNumber();
		System.out.print("请输入终止年龄：");
		int endAge = (int)setNumber();
		//定义是否有学生的年龄在该年龄段的布尔值变量，初始值为false
		boolean flag = false;
		for (int i = 0; i < stuSize; i++) {
			if(students[i].getAge() >= startAge && students[i].getAge() <= endAge) {
				if(flag == false) {
					if(role.equals("teacher")) {
						System.out.println("QQ\t姓名\t密码\t性别\t年龄\t电话\t住址");
					}else {
						System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址");
					}
					//第一次找到在该年龄段的学生，改变布尔值为true
					flag = true;
				}
				showMessage(i,role);
			}
		}
		if(flag == false) {
			System.out.println("找不到该年龄段的学生信息！");
		}
	}
	/**
	 * 根据地址模糊查询学生信息
	 * @param role	不同的身份，展示的信息不一样
	 */
	private void relyAddress(String role) {
		System.out.print("请输入地址：");
		String address = input.next();
		//定义是否有学生的地址属于该地址的布尔值变量，初始值为false
		boolean flag = false;
		for (int i = 0; i < stuSize; i++) {
			if(students[i].getAddress().equals(address)) {
				if(flag == false) {
					if(role.equals("teacher")) {
						System.out.println("QQ\t姓名\t密码\t性别\t年龄\t电话\t住址");
					}else {
						System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址");
					}
					//第一次找到在该地址的学生，改变布尔值为true
					flag = true;
				}
				showMessage(i,role);
			}
		}
		if(flag == false) {
			System.out.println("找不到该地址的学生信息！");
		}
	}
	/**
	 * 根据姓名模糊查询学生信息
	 * @param role	不同的身份，展示的信息不一样
	 */
	private void relyName(String role) {
		System.out.print("请输入学生姓名：");
		//定义是否有学生的姓名是该姓名的布尔值变量，初始值为false
		boolean flag = false;
		String name = input.next();
		for (int i = 0; i < stuSize; i++) {
			if(students[i].getName().equals(name)) {
				if(flag == false) {
					if(role.equals("teacher")) {
						System.out.println("QQ\t姓名\t密码\t性别\t年龄\t电话\t住址");
					}else {
						System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址");
					}
					//第一次找到在该姓名的学生，改变布尔值为true
					flag = true;
				}
				showMessage(i,role);				
			}
		}
		if(flag == false) {
			System.out.println("找不到该学生信息！");
		}
	}
	/**
	 * 辨别输入的值是否为数字，如果不是，直到输入的值为数字时，才结束
	 * @return	返回数字
	 */
	private long setNumber() {
		long num;
		while(true) {
			try {
				num = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.print("请输入一个数字：");
				input = new Scanner(System.in);
			} 
		}
		return num;
	}
	/**
	 * 根据指定编号查询单个学生信息
	 * @param role	不同的身份，展示的信息不一样
	 */
	private void relySno(String role) {
		//System.out.println("**********根据指定编号查询单个学生信息***********");
		System.out.print("请输入学生编号：");
		long sno = setNumber();
		if(searchStu(sno) != -1) {
			if(role.equals("teacher")) {
				System.out.println("QQ\t姓名\t密码\t性别\t年龄\t电话\t住址");
			}else {
				System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址");
			}
			showMessage(searchStu(sno),role);
		}else {
			System.out.println("该学生编号不存在！");
		}
	}
	/**
	 * 根据传入的下标值，查找学生信息
	 * @param no
	 * @param role	不同的身份，查询到的信息不一样
	 */
	private void showMessage(int no, String role) {
		String message = null;
		String sex;
		if(students[no].getSex() == 0) {
			sex = "女";
		}else {
			sex = "男";
		}
		if(role.equals("teacher")) {
			message = students[no].getSno()+"\t"+students[no].getName()+"\t"+students[no].getPassword()
					+"\t"+sex+"\t"+students[no].getAge()+"\t"+students[no].getTel()+"\t"+students[no].getAddress();
		}
		if(role.equals("student")) {
			message = students[no].getSno()+"\t"+students[no].getName()+"\t"+sex+"\t"
					+students[no].getAge()+"\t"+students[no].getTel()+"\t"+students[no].getAddress();
		}
		System.out.println(message);
	}
	/**
	 * 根据学生编号查找其下标值
	 * @param sno
	 * @return	其下标值，找不到返回-1
	 */
	private int searchStu(long sno) {
		for(int i=0;i<stuSize;i++) {
			if(students[i].getSno() == sno) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 展示全部学生信息
	 * @param role	不同的身份，展示的信息不一样
	 */
	private void showAll(String role) {
		System.out.println("****************查询所有学生信息****************");
		if(role.equals("teacher")) {
			System.out.println("QQ\t姓名\t密码\t性别\t年龄\t电话\t住址");
			for(int i=0;i<stuSize;i++) {
				showMessage(i,"teacher");
			}
			System.out.println("*********************************************");
		}
		if(role.equals("student")) {
			System.out.println("QQ\t姓名\t性别\t年龄\t电话\t住址\t好友");
		}
	}
	/**
	 * 添加学生信息
	 */
	private void addStudent() {
		System.out.println("**************添加学生信息***************");
		System.out.print("请输入QQ号：");
		long sno = input.nextLong();
		if(searchStu(sno) != -1) {
			System.out.print("请输入密码：");
			String password = input.next();
			System.out.print("请输入姓名：");
			String name = input.next();
			System.out.print("请输入性别（0代表女，1代表男）：");
			int sex = setSexNumber();
			System.out.print("请输入年龄：");
			int age = input.nextInt();
			System.out.print("请输入电话号码：");
			String tel = input.next();
			System.out.print("请输入地址：");
			String address = input.next();
			students[stuSize] = new Student(sno, password, name, sex, age, tel, address);
			stuSize++;
			System.out.println("添加成功！");
		}else {
			System.out.println("该QQ号已存在！");
		}
	}
	/**
	 * 设置正确的性别编号
	 * @return	0或者1
	 */
	private int setSexNumber() {
		int sex;
		while(true) {								//死循环
			try {
				sex = input.nextInt();
				if(sex > 1 || sex < 0)				//输入的值不是0或者1就自定义抛出异常
					throw new MyInputMismatchException("输入有误！");		
				break;								//输入0或者1就结束死循环
			} catch (InputMismatchException e) {
				System.out.print("请输入一个数字：");
				input = new Scanner(System.in);		
			} catch (MyInputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.print("请输入0或者1（0代表女，1代表男）：");
				input = new Scanner(System.in);
			}
		}
		return sex;
	}
	/**
	 * 学生身份验证
	 * @param sno
	 * @param password
	 * @return	验证不通过返回-1，通过则返回其下标值
	 */
	private int stuConfirm(long sno,String password) {
		for(int i = 0;i < stuSize;i++) {
			if(students[i].getSno() == sno && students[i].getPassword().equals(password)) {
				return i;
			}
		}
		return -1;
	}
}
