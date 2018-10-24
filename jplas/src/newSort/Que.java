package newSort;

import java.util.LinkedList;

/*public class Que {
	private Queue queue = new LinkedList();
	public void push(Object str){
		queue.add(str);
	}
	public Object pop(){
		return queue.poll();
	}
}
*/
public class Que {
	private LinkedList queue = new LinkedList();
	public void push(Object str){
		queue.add(str);
	}
	public Object pop(){
		return queue.poll();
	}
}