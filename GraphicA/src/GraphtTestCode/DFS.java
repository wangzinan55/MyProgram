package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class DFS {

	public ArrayList<String> dfs(WeightedGraph G, int begin) {
		int[][] edges = G.edges;// �õ�ͼ�ľ���
		ArrayList<String> answer = new ArrayList<String>(); // ��Ź�����ȷ��ʵı�
		boolean[] visited = new boolean[edges.length]; // ��ǵ�ǰ�ö����Ƿ񱻷��ʣ�true��ʾ������
		for (int i = 0; i < visited.length; i++) {// ��ʼʱ�ڵ㶼û�б����ʣ����Ϊfalse
			visited[i] = false;
		}
		int[] tmpArr = new int[edges.length]; // ��Ƕ����ջʱ�����ڷ��ʵ����ڶ���
		Stack<Integer> stack = new Stack<Integer>();// �������У��ӵ�һ�����㿪ʼ���������ڽڵ�

		stack.push(begin);// ���ȷ��ʶ���begin
		visited[begin] = true;// ����begin�����ʣ����Ϊtrue
		answer.add(G.labels[begin] + " " + G.labels[begin]);// �����ʶ���begin��·�����뵽�����
		while (!stack.isEmpty()) {
			int out = stack.pop();
			if (visited[out] == false) {// ����ö���δ������
				answer.add(G.labels[out] + " " + G.labels[tmpArr[out]]);// �����ʶ���begin��·�����뵽�����
				visited[out] = true;// ���ö�����Ϊ�ѷ���״̬
			}
			for (int i = edges.length - 1; i >= 0; i--) {
				if (edges[out][i] == 1 && visited[i] == false) { // ���Ӷ��е����Ķ�����ö������·�����Ҹö���δ������
					stack.push(i);
					tmpArr[i]=out;
				}
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
	public void writeFile(File file, ArrayList<String> s) throws IOException {
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
		fw.write("sele_node " + "pre_node ");// ��txt�ļ�д����
		fw.newLine();// ��txt�л���
		System.out.print("sele_node " + "pre_node ");
		System.out.println();
		/**
		 * ͨ��ѭ����txt������д������
		 */
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
			if (i == s.size() - 1) {
				fw.write(s.get(i) + " ");
			} else {
				fw.write(s.get(i) + " ");
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
	public ArrayList<String> findDFS(String result) {
		WeightedGraph t = new WeightedGraph(8);// ����һ������8�������ͼ
		boolean flage = false;
		// forѭ������result����ȡͼ���ڽӾ��󡢶�������
		for (String w : result.split("\n", 0)) {
			if (w.equals("source target weight")) {// ׼����ȡ�ڽӾ��������
				flage = true;
			}
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (flage == false) {// ��ȡ��������
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.setLabel(index, node);
				}
				if (flage == true) {// ��ȡ�ڽӾ���
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					// int weight = Integer.parseInt(1);
					t.addEdgeWeight(source, target, 1);
				}
			}
		}
		ArrayList<String> path = dfs(t, 0);// ����dfs�����õ����
		return path;// ���ؽ��
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
