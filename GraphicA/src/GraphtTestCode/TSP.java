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
		ArrayList<String> answer = new ArrayList<String>();// 存放结果
		int[][] edges = G.edges;// 得到图的矩阵

		int[] visitedLabels = new int[edges.length];// 存放已经访问的顶点
		int[] visitedLength = new int[edges.length + 1];// 存放已经访问的顶点遇上一个定顶点间的最短距离

		visitedLabels[0] = 0;// 首先访问顶点零
		visitedLength[0] = 0;// 第一个顶点到自己的距离为0

		/**
		 * 初开始节点外，共有edges.length个节点不断被访问
		 */
		for (int i = 1; i < visitedLabels.length; i++) { // for-1-begin,
			int minDistance = Integer.MAX_VALUE;// 初始任意两点间的距离中的最小值为最大的int值
			int temp = 0;// 存放本次要访问的城市

			/**
			 * 找出所有未被访问城市中与上一个访问城市的距离最短的城市
			 */
			for (int j = 1; j < visitedLabels.length; j++) { // for-2-begin

				boolean flage = false;// 判断顶点j是否被访问过

				for (int j2 = 0; j2 < i; j2++) {// for-3-begin，判断顶点j 是否已经访问过

					if (visitedLabels[j2] == j) {// 如果j被访问过，跳出循环
						flage = true;
						break;
					}
				}// for-3-end

				/**
				 * 顶点j没有访问过，找出所有未被访问城市中与上一个访问城市的距离最短的城市
				 */
				if (flage == false
						&& edges[j][visitedLabels[i - 1]] < minDistance) {

					temp = j;// 存在更小的距离到达未被访问的城市，更新本次要访问的城市
					minDistance = edges[j][visitedLabels[i - 1]];// 更新最距离
				}

			}// for-2-end
			visitedLabels[i] = temp;
			visitedLength[i] = minDistance;
		}// for-1-end

		// 格式化输出结果
		answer.add(G.labels[0] + " " + G.labels[0] + " " + 0);
		for (int i = 1; i < visitedLabels.length; i++) {
			answer.add(G.labels[visitedLabels[i]] + " "
					+ G.labels[visitedLabels[i - 1]] + " " + visitedLength[i]);
		}
		// 终点返回起点
		answer.add(G.labels[visitedLabels[0]] + " "
				+ G.labels[visitedLabels[visitedLabels.length - 1]] + " "
				+ edges[0][visitedLabels[visitedLabels.length - 1]]);

		return answer;// 返回结果
	}

	/**
	 * 从给定的txt文件中读取数据
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));// 缓冲方式读取txt
		try {
			StringBuilder sb = new StringBuilder();// 创建一个字符串变量，存放读取的数据
			String line = br.readLine();// 从txt文件中读取一行数据

			while (line != null) {// 逐行读取txt文件中的数据
				sb.append(line);// 将读取的数据添加到sb
				sb.append("\n");// 向sb中添加一个换行符

				line = br.readLine();// 读取txt文件中的下一行

			}
			return sb.toString();// 返回一个字符串string
		} finally {
			br.close();// 关闭缓冲区
		}
	}

	/**
	 * 向指定文件中写入数据
	 * 
	 * @param file
	 * @param path
	 * @throws IOException
	 */
	public void writeFile(File file, ArrayList<String> answer)
			throws IOException {
		/**
		 * 如果指定文件不存在，创建文件
		 */
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedWriter fw = new BufferedWriter(new FileWriter(file));// 缓冲方式向txt写数据
		fw.write("sele_node " + "pre_node " + "weight");// 向txt文件写数据
		fw.newLine();// 在txt中换行
		System.out.print("sele_node " + "pre_node " + "weight");
		System.out.println();
		/**
		 * 通过循环向txt中逐行写入数据
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
		fw.close();// 关闭缓冲区
	}

	/**
	 * 驱动函数，通过从txt中读取的数据，构建图的邻接矩阵和顶点数组
	 * 
	 * @param result
	 *            ：从txt中读取的数据
	 * @return
	 */
	public ArrayList<String> findTSP(String result) {
		WeightedGraph t = new WeightedGraph(5);// 创建一个含有5个顶点的图

		// for循环：从result中提取图的邻接矩阵、顶点数组
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// 读取顶点数据
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					// if (index < t.labels.length) {
					t.setLabel(index, node);
					// }
				}
				if (element.length == 3) {// 读取邻接矩阵
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);

					// if (source < t.edges.length && target < t.edges.length) {
					t.addEdgeWeight(source, target, weight);
					// }
				}
			}
		}
		ArrayList<String> path = tsp(t);// 调用方法得到结果
		return path;// 返回结果
	}

	/**
	 * 图的类
	 * 
	 */
	class WeightedGraph {

		public int[][] edges; // 图的邻接矩阵
		public String[] labels;// 图的顶点数组

		/**
		 * 构造函数
		 * 
		 * @param n
		 *            ：图的顶点数
		 */
		public WeightedGraph(int n) {
			edges = new int[n][n];
			labels = new String[n];
		}

		// 获取图的定点数
		public int size() {
			return labels.length;
		}

		// 初始化图指定位置顶点
		public void setLabel(int vertex, String label) {
			labels[vertex] = label;
		}

		// 获取图指定位置顶点
		public Object getLabel(int vertex) {
			return labels[vertex];
		}

		// 初始化图指定位置的邻接矩阵
		public void addEdgeWeight(int source, int target, int w) {
			edges[source][target] = w;
			edges[target][source] = w;
		}

		// 获取图指定位置的邻接矩阵
		public int getEdgeWeight(int source, int target) {
			return edges[source][target];
		}
	}

}
