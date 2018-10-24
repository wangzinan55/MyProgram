package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {

	// ���캯��
	public Kruskal(int n) {
		super();
		
	}

	public ArrayList<String> kruskal(WeightedGraph G) {
		ArrayList<String> answer = new ArrayList<String>();// ��Ž��

		ArrayList<Vertex> vertexs = G.vertexs;// �õ�ͼ�Ķ���
		ArrayList<Side> sides = G.sides;// �õ�ͼ�ı�

		// ��Ŷ�Ӧ����������ͨͼ��ʶ,������������ֵ��ͬ��˵��������������С�������в�����·����������ͨ
		int[] isConnected = new int[vertexs.size()];
		int tempNum = 1;// ͨ���Զ��㸳ֵ����ʾ�Ƿ���ڱ߻����Ƿ���ͨ�������������ֵ��ͬ��˵������֮����ͨ��
		for (int i = 0; i < sides.size(); i++) {
			Side side = sides.get(i);
			int from = side.vertex1.number;// �ߵ����
			int to = side.vertex2.number;// �ߵ��յ�
			if (isConnected[from] == 0 && isConnected[to] == 0) {// �������㶼������������
				isConnected[from] = tempNum;
				isConnected[to] = tempNum;
				tempNum++;
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			} else if (isConnected[from] > 0 && isConnected[to] > 0
					&& isConnected[from] != isConnected[to]) {// �������㶼���������У��Ҳ���ͨ
				int tmp = isConnected[to];
				for (int m = 0; m < isConnected.length; m++) {// ����������ͨ����������������to��ͨ��ҲҪ����tempֵ��
					if (isConnected[m] == tmp) {
						isConnected[m] = isConnected[from];
					}
				}
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			} else if (isConnected[from] == 0 && isConnected[to] != 0) {// һ��������������һ��������������
				isConnected[from] = isConnected[to];
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			} else if (isConnected[from] != 0 && isConnected[to] == 0) {// һ��������������һ��������������
				isConnected[to] = isConnected[from];
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			}

			// ���ͼ�Ķ����Ƿ�������������
			boolean flage = false;
			for (int k = 0; k < isConnected.length; k++) {
				if (isConnected[k] != isConnected[0]) {
					flage = false;
					break;
				} else {
					flage = true;
				}
			}
			if (flage == true) {
				break;
			}
		}
		return answer;
	}

	/**
	 * �Ӹ�����txt�ļ��ж�ȡ����
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));// ���巽ʽ��ȡtxt
		try {
			StringBuilder sb = new StringBuilder();// ����һ���ַ�����������Ŷ�ȡ������
			String line = br.readLine();// ��txt�ļ��ж�ȡһ������

			while (line != null) {// ���ж�ȡtxt�ļ��е�����
				sb.append(line);// ����ȡ��������ӵ�sb
				sb.append("\n");// ��sb�����һ�����з�

				line = br.readLine();// ��ȡtxt�ļ��е���һ��

			}
			return sb.toString();// ����һ���ַ���string
		} finally {
			br.close();// �رջ�����
		}
	}

	/**
	 * ��ָ���ļ���д������
	 * 
	 * @param file
	 * @param path
	 * @throws IOException
	 */
	public void writeFile(File file, ArrayList<String> answer)
			throws IOException {
		/**
		 * ���ָ���ļ������ڣ������ļ�
		 */
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedWriter fw = new BufferedWriter(new FileWriter(file));// ���巽ʽ��txtд����
		fw.write("sele_node " + "pre_node " + "weight");// ��txt�ļ�д����
		fw.newLine();// ��txt�л���
		System.out.print("sele_node " + "pre_node " + "weight");
		System.out.println();
		/**
		 * ͨ��ѭ����txt������д������
		 */
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
			if (i == answer.size() - 1) {
				fw.write(answer.get(i) + " ");
			} else {
				fw.write(answer.get(i) + " ");
				fw.newLine();
			}
		}
		System.out.println();
		System.out.println("Write File Successfully");
		fw.close();// �رջ�����
	}

	/**
	 * ����������ͨ����txt�ж�ȡ�����ݣ�����ͼ���ڽӾ���Ͷ�������
	 * 
	 * @param result
	 *            ����txt�ж�ȡ������
	 * @return
	 */
	public ArrayList<String> findKruskal(String result) {
		ArrayList<Vertex> vertexs = new ArrayList<Vertex>();// ���ͼ�Ķ���
		ArrayList<Side> sides = new ArrayList<Side>();// ���ͼ�ı�
		// forѭ������result����ȡͼ�Ķ���ͱ�
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// ��ȡ��������
					int index = Integer.parseInt(element[0]);
					String node = element[1];

					vertexs.add(new Vertex(node, index));
				}
				if (element.length == 3) {// ��ȡͼ�ı�
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);
					sides.add(new Side(vertexs.get(source),
							vertexs.get(target), weight));
				}
			}
		}

		WeightedGraph t = new WeightedGraph(vertexs, sides);// ����ͼ
		ArrayList<String> path = kruskal(t);// ���÷����õ����
		return path;// ���ؽ��
	}

	/**
	 * ͼ����
	 * 
	 */
	class WeightedGraph {
		private ArrayList<Vertex> vertexs;//ͼ�ĵ㼯
		private ArrayList<Side> sides;//ͼ�ı߼�

		
	//ͼ�Ĺ��캯������ʼ��ͼ�ĵ㼯��ͼ�ı߼�������ͼ�ı�����
		public WeightedGraph(ArrayList<Vertex> vertexs, ArrayList<Side> sides) {
			super();
			this.vertexs = vertexs;
			this.sides = sides;

			// �Ա߰��ձ߳���С����������дComparator������
			Collections.sort(sides, new Comparator<Side>() {
				@Override
				public int compare(Side s1, Side s2) {
			
					if (s1.length > s2.length) {//�߳�С����ǰ
						return 1;
					} else if (s1.length == s2.length) {// �߳���ͬ��������С����ǰ
						if (s1.vertex1.number >= s2.vertex1.number) {
							return 1;
						} else {
							return -1;
						}

					} else {//�߳����ں�
						return -1;
					}
				}
			});
		}

	}
	// ����
	class Side {
		private Vertex vertex1;// �ߵĶ���1
		private Vertex vertex2;// �ߵĶ���2
		private int length;// �߳�

		//��ʼ��һ����
		public Side(Vertex vertex1, Vertex vertex2, int length) {
			super();
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			this.length = length;
		}
	}

	// ������
	class Vertex {
		private String name;// �����name
		private int number;// ��������

		//��ʼ��ͼ��һ������
		public Vertex(String name, int number) {
			super();
			this.name = name;
			this.number = number;
		}

	}

}
