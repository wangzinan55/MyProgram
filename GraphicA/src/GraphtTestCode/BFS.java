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
	 * 该方法实现了BFS算法
	 * @param G
	 * @param begin
	 * @return
	 */
	public String[] bfs(WeightedGraph G, int begin) {
		int[][] edges = G.edges;// 得到图的矩阵
		String[] answer = new String[edges.length]; // 存放广度优先访问的边
		boolean[] visited = new boolean[edges.length]; // 标记当前该顶点是否被访问，true表示被访问
		for (int i = 0; i < visited.length; i++) {// 开始时节点都没有被访问，标记全为false
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();// 构建队列，从第一个顶点开始搜索其相邻节点

		queue.add(begin);// 首先访问顶点begin
		visited[begin]=true;//顶点begin被访问，标记为true
		answer[0] = G.labels[begin] + " " + G.labels[begin];//将访问顶点begin的路径存入到结果中
		int temp=1;//标记有多少个顶点被访问
		while (!queue.isEmpty()) {
			int out=queue.poll();//从队列中取出一个顶点
			for (int i = 0; i < edges.length; i++) {
				if (edges[out][i]==1&&visited[i]==false) { //当从队列弹出的顶点与该顶点间有路径，且该顶点未被访问
					answer[temp] = G.labels[i] + " " + G.labels[out];// 将访问顶点begin的路径存入到结果中
					temp++;//被访问的顶点增加1
					queue.add(i);
				}
			}
		}
		return answer;
	}

	/**
	 * 从给定的txt文件中读取数据
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String readFile(File file) throws IOException {
		//缓冲方式读取txt
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			StringBuilder sb = new StringBuilder();//创建一个字符串变量，存放读取的数据
			String line = br.readLine();//从txt文件中读取一行数据

			while (line != null) {//逐行读取txt文件中的数据
				sb.append(line);//将读取的数据添加到sb
				sb.append("\n");//向sb中添加一个换行符

				line = br.readLine();//读取txt文件中的下一行

			}
			return sb.toString();//返回一个字符串string
		} finally {
			br.close();//关闭缓冲区
		}
	}

	/**
	 * 向指定文件中写入数据
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
				e.printStackTrace();
			}
		}
		
		//缓冲方式向txt写数据
		BufferedWriter fw = new BufferedWriter(new FileWriter(file));
		fw.write("sele_node " + "pre_node ");//向txt文件写数据
		fw.newLine();//在txt中换行
		System.out.print("sele_node " + "pre_node ");
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
		fw.close();//关闭缓冲区
	}

	/**
	 * 驱动函数，通过从txt中读取的数据，构建图的邻接矩阵和顶点数组
	 * @param result ：从txt中读取的数据
	 * @return
	 */
	public String[] findBFS(String result) {
		WeightedGraph t = new WeightedGraph(8);//创建一个含有8个顶点的图
		boolean flage = false;
		
		//for循环：从result中提取图的邻接矩阵、顶点数组
		for (String w : result.split("\n", 0)) {
			if (w.equals("source target weight")) {//准备读取邻接矩阵的数据
				flage = true;
			}
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (flage == false) {//读取顶点数据
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.setLabel(index, node);
				}
				if (flage == true) {//读取邻接矩阵
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					t.addEdgeWeight(source, target, 1);
				}
			}
		}
		String[] path = bfs(t, 0);//调用bfs方法得到结果
		return path;//返回结果
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
		}

		// 获取图指定位置的邻接矩阵
		public int getEdgeWeight(int source, int target) {
			return edges[source][target];
		}
	}

}
