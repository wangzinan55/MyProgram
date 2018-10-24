package testoop.src.cn.bjsxt.oop.callback;

public class MyFrame {
	public void paint(){
		System.out.println("把窗口自己画出来");
	}
}


//可以不用继承，而直接使用接口
interface IMyFrame{
	void paint();
}