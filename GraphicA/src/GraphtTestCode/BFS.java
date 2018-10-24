package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	/**
	 * �÷���ʵ����BFS�㷨
	 * @param G
	 * @param begin
	 * @return
	 */
	public String[] bfs(WeightedGraph G, int begin) {
		int[][] edges = G.edges;// �õ�ͼ�ľ���
		String[] answer = new String[edges.length]; // ��Ź�����ȷ��ʵı�
		boolean[] visited = new boolean[edges.length]; // ��ǵ�ǰ�ö����Ƿ񱻷��ʣ�true��ʾ������
		for (int i = 0; i < visited.length; i++) {// ��ʼʱ�ڵ㶼û�б����ʣ����ȫΪfalse
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();// �������У��ӵ�һ�����㿪ʼ���������ڽڵ�

		queue.add(begin);// ���ȷ��ʶ���begin
		visited[begin]=true;//����begin�����ʣ����Ϊtrue
		answer[0] = G.labels[begin] + " " + G.labels[begin];//�����ʶ���begin��·�����뵽�����
		int temp=1;//����ж��ٸ����㱻����
		while (!queue.isEmpty()) {
			int out=queue.poll();//�Ӷ�����ȡ��һ������
			for (int i = 0; i < edges.length; i++) {
				if (edges[out][i]==1&&visited[i]==false) { //���Ӷ��е����Ķ�����ö������·�����Ҹö���δ������
					answer[temp] = G.labels[i] + " " + G.labels[out];// �����ʶ���begin��·�����뵽�����
					temp++;//�����ʵĶ�������1
					queue.add(i);
				}
			}
		}
		return answer;
	}

	/**
	 * �Ӹ�����txt�ļ��ж�ȡ����
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String readFile(File file) throws IOException {
		//���巽ʽ��ȡtxt
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			StringBuilder sb = new StringBuilder();//����һ���ַ�����������Ŷ�ȡ������
			String line = br.readLine();//��txt�ļ��ж�ȡһ������

			while (line != null) {//���ж�ȡtxt�ļ��е�����
				sb.append(line);//����ȡ��������ӵ�sb
				sb.append("\n");//��sb�����һ�����з�

				line = br.readLine();//��ȡtxt�ļ��е���һ��

			}
			return sb.toString();//����һ���ַ���string
		} finally {
			br.close();//�رջ�����
		}
	}

	/**
	 * ��ָ���ļ���д������
	 * @param file
	 * @param path
	 * @throws IOException
	 */
	public void writeFile(File file, String[] path) throws IOException {
		/**
		 * ���ָ���ļ������ڣ������ļ�
		 */
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//���巽ʽ��txtд����
		BufferedWriter fw = new BufferedWriter(new FileWriter(file));
		fw.write("sele_node " + "pre_node ");//��txt�ļ�д����
		fw.newLine();//��txt�л���
		System.out.print("sele_node " + "pre_node ");
		System.out.println();
		/**
		 * ͨ��ѭ����txt������д������
		 */
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
			if (i == path.length - 1) {
				fw.write(path[i] + " ");
			} else {
				fw.write(path[i] + " ");
				fw.newLine();
			}
		}
		System.out.println();
		System.out.println("Write File Successfully");
		fw.close();//�رջ�����
	}

	/**
	 * ����������ͨ����txt�ж�ȡ�����ݣ�����ͼ���ڽӾ���Ͷ�������
	 * @param result ����txt�ж�ȡ������
	 * @return
	 */
	public String[] findBFS(String result) {
		WeightedGraph t = new WeightedGraph(8);//����һ������8�������ͼ
		boolean flage = false;
		
		//forѭ������result����ȡͼ���ڽӾ��󡢶�������
		for (String w : result.split("\n", 0)) {
			if (w.equals("source target weight")) {//׼����ȡ�ڽӾ��������
				flage = true;
			}
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (flage == false) {//��ȡ��������
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.setLabel(index, node);
				}
				if (flage == true) {//��ȡ�ڽӾ���
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					t.addEdgeWeight(source, target, 1);
				}
			}
		}
		String[] path = bfs(t, 0);//����bfs�����õ����
		return path;//���ؽ��
	}

	/**
	 * ͼ����
	 * 
	 */
	class WeightedGraph {

		public int[][] edges; // ͼ���ڽӾ���
		public String[] labels;// ͼ�Ķ�������

		/**
		 * ���캯��
		 * 
		 * @param n
		 *            ��ͼ�Ķ�����
		 */
		public WeightedGraph(int n) {
			edges = new int[n][n];
			labels = new String[n];
		}

		// ��ȡͼ�Ķ�����
		public int size() {
			return labels.length;
		}

		// ��ʼ��ͼָ��λ�ö���
		public void setLabel(int vertex, String label) {
			labels[vertex] = label;
		}

		// ��ȡͼָ��λ�ö���
		public Object getLabel(int vertex) {
			return labels[vertex];
		}

		// ��ʼ��ͼָ��λ�õ��ڽӾ���
		public void addEdgeWeight(int source, int target, int w) {
			edges[source][target] = w;
		}

		// ��ȡͼָ��λ�õ��ڽӾ���
		public int getEdgeWeight(int source, int target) {
			return edges[source][target];
		}
	}

}
