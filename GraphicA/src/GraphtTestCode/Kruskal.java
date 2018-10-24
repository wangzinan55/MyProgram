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

	// 构造函数
	public Kruskal(int n) {
		super();
		
	}

	public ArrayList<String> kruskal(WeightedGraph G) {
		ArrayList<String> answer = new ArrayList<String>();// 存放结果

		ArrayList<Vertex> vertexs = G.vertexs;// 得到图的顶点
		ArrayList<Side> sides = G.sides;// 得到图的边

		// 存放对应顶点所在连通图标识,如果两个顶点的值不同，说明两个顶点在最小生成树中不存在路径，即不连通
		int[] isConnected = new int[vertexs.size()];
		int tempNum = 1;// 通过对顶点赋值，表示是否存在边或者是否联通，如果两个顶点值相同，说明他们之间联通，
		for (int i = 0; i < sides.size(); i++) {
			Side side = sides.get(i);
			int from = side.vertex1.number;// 边的起点
			int to = side.vertex2.number;// 边的终点
			if (isConnected[from] == 0 && isConnected[to] == 0) {// 两个顶点都不在生成树中
				isConnected[from] = tempNum;
				isConnected[to] = tempNum;
				tempNum++;
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			} else if (isConnected[from] > 0 && isConnected[to] > 0
					&& isConnected[from] != isConnected[to]) {// 两个顶点都在生成树中，且不连通
				int tmp = isConnected[to];
				for (int m = 0; m < isConnected.length; m++) {// 将两个不连通的量连接起来（与to连通的也要更新temp值）
					if (isConnected[m] == tmp) {
						isConnected[m] = isConnected[from];
					}
				}
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			} else if (isConnected[from] == 0 && isConnected[to] != 0) {// 一个在生成树，另一个不在生成树中
				isConnected[from] = isConnected[to];
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			} else if (isConnected[from] != 0 && isConnected[to] == 0) {// 一个在生成树，另一个不在生成树中
				isConnected[to] = isConnected[from];
				answer.add(side.vertex1.name + "," + side.vertex2.name);
			}

			// 检查图的顶点是否都已在生成树中
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
	public ArrayList<String> findKruskal(String result) {
		ArrayList<Vertex> vertexs = new ArrayList<Vertex>();// 存放图的顶点
		ArrayList<Side> sides = new ArrayList<Side>();// 存放图的边
		// for循环：从result中提取图的顶点和边
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// 读取顶点数据
					int index = Integer.parseInt(element[0]);
					String node = element[1];

					vertexs.add(new Vertex(node, index));
				}
				if (element.length == 3) {// 读取图的边
					int source = Integer.parseInt(element[0]);
					int target = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);
					sides.add(new Side(vertexs.get(source),
							vertexs.get(target), weight));
				}
			}
		}

		WeightedGraph t = new WeightedGraph(vertexs, sides);// 创建图
		ArrayList<String> path = kruskal(t);// 调用方法得到结果
		return path;// 返回结果
	}

	/**
	 * 图的类
	 * 
	 */
	class WeightedGraph {
		private ArrayList<Vertex> vertexs;//图的点集
		private ArrayList<Side> sides;//图的边集

		
	//图的构造函数，初始化图的点集、图的边集，并对图的边排序
		public WeightedGraph(ArrayList<Vertex> vertexs, ArrayList<Side> sides) {
			super();
			this.vertexs = vertexs;
			this.sides = sides;

			// 对边按照边长由小到大排序（重写Comparator方法）
			Collections.sort(sides, new Comparator<Side>() {
				@Override
				public int compare(Side s1, Side s2) {
			
					if (s1.length > s2.length) {//边长小的在前
						return 1;
					} else if (s1.length == s2.length) {// 边长相同，起点序号小的在前
						if (s1.vertex1.number >= s2.vertex1.number) {
							return 1;
						} else {
							return -1;
						}

					} else {//边长大在后
						return -1;
					}
				}
			});
		}

	}
	// 边类
	class Side {
		private Vertex vertex1;// 边的顶点1
		private Vertex vertex2;// 边的顶点2
		private int length;// 边长

		//初始化一条边
		public Side(Vertex vertex1, Vertex vertex2, int length) {
			super();
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			this.length = length;
		}
	}

	// 顶点类
	class Vertex {
		private String name;// 顶点的name
		private int number;// 顶点的序号

		//初始化图的一个顶点
		public Vertex(String name, int number) {
			super();
			this.name = name;
			this.number = number;
		}

	}

}
