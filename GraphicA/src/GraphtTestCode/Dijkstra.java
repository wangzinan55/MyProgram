package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dijkstra {

	public String[] dijkstra(WeightedGraph G, int begin) {
		int[][] edges = G.edges;// �õ�ͼ�ľ���

		boolean[] visited = new boolean[edges.length]; // ��ǵ�ǰ�ö�������·���Ƿ��Ѿ����,true��ʾ�����

		int[] shortDistance = new int[edges.length]; // ��Ŵ�begin�������������̾���
		int[] lastV = new int[edges.length];// ��Ŵ�begin��������������·������һ��
		int[] v = new int[edges.length];// ���ʸ����˳��

		shortDistance[0] = 0;// ��ʼ�ڵ㵽�Լ�����̾�����һ��Ϊ0
		for (int i = 0; i < v.length; i++) {

		}
		visited[begin] = true;// true��ʾ��������·��
		v[0] = begin;// ���ȷ�����ʵ��
		lastV[0] = begin;
		int sum = 0;
		for (sum = 1; sum < edges.length; sum++) // ��ȥ��ʼ���⣬��ʣedges.length-1�����㣬���Թ�����edges.length-1��
		{

			int temp = -1; // ѡ�������ʼ�����ʼ������ĵ� temp������
			// �ҳ���ʱ����ʼ�������̵ĵ㣬�Ҿ����Ϊ distance����ʼΪ����intֵ
			int distance = Integer.MAX_VALUE;
			for (int i = 0; i < edges.length; i++) {
				if (visited[i] == false && edges[begin][i] < distance) {
					distance = edges[begin][i];
					temp = i;
				}

			}
			v[sum] = temp;// �ôη��ʵĵ�Ϊ G.labels[temp]

			shortDistance[sum] = distance;// ��̾���Ϊdistance��

			visited[temp] = true;// ��Ǹõ��Ѿ�����

			// ���¼���ĵ���룬����ͨ���õ� ��ʼ�㵽��������ľ��룬�������ֵ���бȽ�
			for (int i = 0; i < edges.length; i++) {
				if (visited[i] == false&& edges[begin][temp] + edges[temp][i] < edges[begin][i]) {
					if (edges[begin][temp] != Integer.MAX_VALUE
							&& edges[temp][i] != Integer.MAX_VALUE) {//��֤����ֵ����Ϊ�������int�����ֵ��
						edges[begin][i] = edges[begin][temp] + edges[temp][i];// ���֮ǰ�Ľ���������ڵģ����³�ʼ�㵽�õ�ľ���
						lastV[i] = temp;
					}
				}

			}

		}

		String[] path = new String[edges.length]; // ��Ŵ�begin��������������·�����ַ�����ʾ
		// ��ʽ��������
		for (int i = 0; i < edges[begin].length; i++) {
			path[i] = G.labels[v[i]] + " " + G.labels[lastV[v[i]]] + " "
					+ shortDistance[i];
		}
		return path;
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
	public void writeFile(File file, String[] path) throws IOException {
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
		fw.close();// �رջ�����
	}

	/**
	 * ����������ͨ����txt�ж�ȡ�����ݣ�����ͼ���ڽӾ���Ͷ�������
	 * 
	 * @param result
	 *            ����txt�ж�ȡ������
	 * @return
	 */
	public String[] findShortPath(String result) {
		WeightedGraph t = new WeightedGraph(6);// ����һ������6�������ͼ

		// forѭ������result����ȡͼ���ڽӾ��󡢶�������
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// ��ȡ��������
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.setLabel(index, node);
				}
				if (element.length == 3) {// ��ȡ�ڽӾ���
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);
					t.addEdgeWeight(source, target, weight);
				}
			}
		}
		String[] path = dijkstra(t, 0);// ���÷����õ����
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
			for (int i = 0; i < edges.length; i++) {
				for (int j = 0; j < edges.length; j++) {
					edges[i][j] = Integer.MAX_VALUE;// ����������֮��ľ����ʼ��Ϊint���͵����ֵ�������
				}
			}
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
