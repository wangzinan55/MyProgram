package testoop.src.program_test;

import java.util.*;			

/**
 * �L�[���[�h�ƒl���Ǘ�����v���O����
 */

public class Memo {
    public static void main(String[] args) {
	HashMap<String,Object> map = new HashMap<String,Object>();
	Scanner scanner = new Scanner(System.in);
	while(true) {

	    // �L�[�{�[�h����P�s�ǂݍ��ށB
	    String line = scanner.nextLine();
	    Scanner s = new Scanner(System.in); 
	    
	    // �ǂݍ��񂾂P�s���̕������P�ꂲ�Ƃɕ�����B
	    String[] tokens = line.split(" ");

	    if(tokens[0].equals("add")) {
	    	String[] ss={s.next(),s.next()};
	    	map.put(ss[0],ss[1]);
	    	
		// �f�[�^��ǉ�����B
		System.out.println(ss[0]+"="+ss[1]);

	    } else if(tokens[0].equals("del")) {
	    	map.remove(s.next());
		// �f�[�^���폜����B
		System.out.println(map);

	    } else if(tokens[0].equals("get")) {
	    	
		// �f�[�^�����o���B
		System.out.println("Name="+map.get("Name"));
		System.out.println("Name="+map.get("Value"));
	

	    } else if(tokens[0].equals("list")) {
	    
		// �ꗗ��\������B
		System.out.println(map);

	    } else if(tokens[0].equals("quit")) {

		break; // ���[�v�𔲂���

	    }
	}
	System.out.println("�I��");
    }
}