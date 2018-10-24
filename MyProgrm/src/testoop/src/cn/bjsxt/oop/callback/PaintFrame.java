package testoop.src.cn.bjsxt.oop.callback;

public class PaintFrame {
	public static void drawFrame(IMyFrame f){
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息线");
		
		//画窗口
		f.paint();  //此处相当于一个钩子，前面都类似于一个模板，全不变   
		
		System.out.println("启动缓存，增加效率");
		
		
	}
	 public static void main(String[] args){
		drawFrame(new GameFrame01());
	}
}

class GameFrame01 implements IMyFrame{  //实现接口
	public void paint(){
		System.out.println("GameFrame01.paint()");
		System.out.println("画窗口");
	}
}


