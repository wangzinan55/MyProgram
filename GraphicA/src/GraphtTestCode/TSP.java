package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TSP {
	public ArrayList<String> tsp(WeightedGraph G) {
		ArrayList<String> answer = new ArrayList<String>();// ��Ž��
		int[][] edges = G.edges;// �õ�ͼ�ľ���

		int[] visitedLabels = new int[edges.length];// ����Ѿ����ʵĶ���
		int[] visitedLength = new int[edges.length + 1];// ����Ѿ����ʵĶ�������һ������������̾���

		visitedLabels[0] = 0;// ���ȷ��ʶ�����
		visitedLength[0] = 0;// ��һ�����㵽�Լ��ľ���Ϊ0

		/**
		 * ����ʼ�ڵ��⣬����edges.length���ڵ㲻�ϱ�����
		 */
		for (int i = 1; i < visitedLabels.length; i++) { // for-1-begin,
			int minDistance = Integer.MAX_VALUE;// ��ʼ���������ľ����е���СֵΪ����intֵ
			int temp = 0;// ��ű���Ҫ���ʵĳ���

			/**
			 * �ҳ�����δ�����ʳ���������һ�����ʳ��еľ�����̵ĳ���
			 */
			for (int j = 1; j < visitedLabels.length; j++) { // for-2-begin

				boolean flage = false;// �ж϶���j�Ƿ񱻷��ʹ�

				for (int j2 = 0; j2 < i; j2++) {// for-3-begin���ж϶���j �Ƿ��Ѿ����ʹ�

					if (visitedLabels[j2] == j) {// ���j�����ʹ�������ѭ��
						flage = true;
						break;
					}
				}// for-3-end

				/**
				 * ����jû�з��ʹ����ҳ�����δ�����ʳ���������һ�����ʳ��еľ�����̵ĳ���
				 */
				if (flage == false
						&& edges[j][visitedLabels[i - 1]] < minDistance) {

					temp = j;// ���ڸ�С�ľ��뵽��δ�����ʵĳ��У����±���Ҫ���ʵĳ���
					minDistance = edges[j][visitedLabels[i - 1]];// ���������
				}

			}// for-2-end
			visitedLabels[i] = temp;
			visitedLength[i] = minDistance;
		}// for-1-end

		// ��ʽ��������
		answer.add(G.labels[0] + " " + G.labels[0] + " " + 0);
		for (int i = 1; i < visitedLabels.length; i++) {
			answer.add(G.labels[visitedLabels[i]] + " "
					+ G.labels[visitedLabels[i - 1]] + " " + visitedLength[i]);
		}
		// �յ㷵�����
		answer.add(G.labels[visitedLabels[0]] + " "
				+ G.labels[visitedLabels[visitedLabels.length - 1]] + " "
				+ edges[0][visitedLabels[visitedLabels.length - 1]]);

		return answer;// ���ؽ��
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
	public ArrayList<String> findTSP(String result) {
		WeightedGraph t = new WeightedGraph(5);// ����һ������5�������ͼ

		// forѭ������result����ȡͼ���ڽӾ��󡢶�������
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// ��ȡ��������
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					// if (index < t.labels.length) {
					t.setLabel(index, node);
					// }
				}
				if (element.length == 3) {// ��ȡ�ڽӾ���
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);

					// if (source < t.edges.length && target < t.edges.length) {
					t.addEdgeWeight(source, target, weight);
					// }
				}
			}
		}
		ArrayList<String> path = tsp(t);// ���÷����õ����
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
			edges[target][source] = w;
		}

		// ��ȡͼָ��λ�õ��ڽӾ���
		public int getEdgeWeight(int source, int target) {
			return edges[source][target];
		}
	}

}
