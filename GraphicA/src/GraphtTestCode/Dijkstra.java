package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dijkstra {

	public String[] dijkstra(WeightedGraph G, int begin) {
		int[][] edges = G.edges;// 得到图的矩阵

		boolean[] visited = new boolean[edges.length]; // 标记当前该顶点的最短路径是否已经求出,true表示已求出

		int[] shortDistance = new int[edges.length]; // 存放从begin到其他各点的最短距离
		int[] lastV = new int[edges.length];// 存放从begin到其他各点的最短路径的吓一跳
		int[] v = new int[edges.length];// 访问各点的顺序

		shortDistance[0] = 0;// 开始节点到自己的最短距离吓一跳为0
		for (int i = 0; i < v.length; i++) {

		}
		visited[begin] = true;// true表示已求出最短路径
		v[0] = begin;// 首先访问其实点
		lastV[0] = begin;
		int sum = 0;
		for (sum = 1; sum < edges.length; sum++) // 除去初始点外，还剩edges.length-1个顶点，所以共需求edges.length-1次
		{

			int temp = -1; // 选出距离初始顶点初始点最近的点 temp，带入
			// 找出此时到初始点距离最短的点，且距离记为 distance，初始为最大的int值
			int distance = Integer.MAX_VALUE;
			for (int i = 0; i < edges.length; i++) {
				if (visited[i] == false && edges[begin][i] < distance) {
					distance = edges[begin][i];
					temp = i;
				}

			}
			v[sum] = temp;// 该次访问的点为 G.labels[temp]

			shortDistance[sum] = distance;// 最短距离为distance；

			visited[temp] = true;// 标记该点已经访问

			// 把新加入的点带入，计算通过该点 初始点到其他个点的距离，与已求的值进行比较
			for (int i = 0; i < edges.length; i++) {
				if (visited[i] == false&& edges[begin][temp] + edges[temp][i] < edges[begin][i]) {
					if (edges[begin][temp] != Integer.MAX_VALUE
							&& edges[temp][i] != Integer.MAX_VALUE) {//保证两个值均不为正无穷大（int的最大值）
						edges[begin][i] = edges[begin][temp] + edges[temp][i];// 如果之前的结果大于现在的，更新初始点到该点的距离
						lastV[i] = temp;
					}
				}

			}

		}

		String[] path = new String[edges.length]; // 存放从begin到其他各点的最短路径的字符串表示
		// 格式化输出结果
		for (int i = 0; i < edges[begin].length; i++) {
			path[i] = G.labels[v[i]] + " " + G.labels[lastV[v[i]]] + " "
					+ shortDistance[i];
		}
		return path;
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
	public void writeFile(File file, String[] path) throws IOException {
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
		fw.close();// 关闭缓冲区
	}

	/**
	 * 驱动函数，通过从txt中读取的数据，构建图的邻接矩阵和顶点数组
	 * 
	 * @param result
	 *            ：从txt中读取的数据
	 * @return
	 */
	public String[] findShortPath(String result) {
		WeightedGraph t = new WeightedGraph(6);// 创建一个含有6个顶点的图

		// for循环：从result中提取图的邻接矩阵、顶点数组
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// 读取顶点数据
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.setLabel(index, node);
				}
				if (element.length == 3) {// 读取邻接矩阵
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);
					t.addEdgeWeight(source, target, weight);
				}
			}
		}
		String[] path = dijkstra(t, 0);// 调用方法得到结果
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
			for (int i = 0; i < edges.length; i++) {
				for (int j = 0; j < edges.length; j++) {
					edges[i][j] = Integer.MAX_VALUE;// 将所有两点之间的距离初始化为int类型的最大值（无穷大）
				}
			}
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
		}

		// 获取图指定位置的邻接矩阵
		public int getEdgeWeight(int source, int target) {
			return edges[source][target];
		}

	}
}
