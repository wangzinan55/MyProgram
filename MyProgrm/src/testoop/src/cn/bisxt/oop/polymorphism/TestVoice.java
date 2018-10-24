package testoop.src.cn.bisxt.oop.polymorphism;

public class TestVoice {
	public static void testAnimalVoice(Animal m){
		m.voice();
		if(m instanceof Cat){    //判断m是不是属于Cat
			((Cat) m).catchMouth();  //强制转换
		}
	}

	
    public static void main(String[] args){
    	Cat a = new Cat();
    	Dog b = new Dog();
    	Pig c = new Pig();
    	testAnimalVoice(a);
    	testAnimalVoice(b);
    	testAnimalVoice(c);
    	
    }
}

