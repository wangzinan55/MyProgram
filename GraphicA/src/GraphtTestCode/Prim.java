package GraphtTestCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Prim {
	
	/**
	 * 图的类
	 * 
	 */
	class WeightedGraph {
		private ArrayList<Node> nodes = new ArrayList<>();
		private ArrayList<Edge> edges = new ArrayList<>();

		public ArrayList<Node> getNodes() {
			return nodes;
		}

		public void setNodes(ArrayList<Node> nodes) {
			this.nodes = nodes;
		}

		public ArrayList<Edge> getEdges() {
			return edges;
		}

		public void setEdges(ArrayList<Edge> edges) {
			this.edges = edges;
		}

		public void addEdge(int start, int end, int weight) {
			Node source = nodes.get(start);
			Node target = nodes.get(end);
			
			Edge edge1 = new Edge(source, target, weight);
			source.addEdge(edge1);
			Edge edge2 = new Edge(target, source, weight);
			target.addEdge(edge2);
			edges.add(edge1);
		}

/*		public void addNode(Node node) {
			nodes.add(node);
		}*/

	}
	
	class Node {
		private String name;
		private ArrayList<Edge> edges = new ArrayList<>();


		public Node(String name) {

			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

		public void setedges(ArrayList<Edge> edges) {
			this.edges = edges;
		}
		
		public ArrayList<Edge> getedges() {
			return edges;
		}

		public void addEdge(Edge edge) {
			edges.add(edge);
		}

/*		boolean has(Node node) {
			for(Node n : nodes) {
				if(n==node)
					return true;
			}
			return false;
		}*/
		
		/*		@Override
		public boolean equals(Object obj) {                 
			if (this.name.equals(((Node) obj).getName())) {
				return true;
			} else {
				return false;
			}
		}*/
	}

	class Edge {
		private Node start;
		private Node end;
		private int weight;

		public Edge(Node start, Node end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
			
		}

		public void setStart(Node start) {
			this.start = start;
		}

		public Node getStart() {
			return start;
		}
		
		public void setEnd(Node end) {
			this.end = end;
		}
		
		public Node getEnd() {
			return end;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
		
		public int getWeight() {
			return weight;
		}

/*		@Override
		public boolean equals(Object obj) {
			if (((this.start.name.equals(((Edge) obj).start.name) && this.end.name
					.equals(((Edge) obj).end.name)) || this.start.name
					.equals(((Edge) obj).end.name)
					&& this.end.name.equals(((Edge) obj).start.name))
					&& this.weight == ((Edge) obj).weight) {
				return true;
			} else {
				return false;
			}
		}*/

	}



	/**
	 * 
	 * @param G
	 *            : 要求最小生成树的图
	 * @return：最小生成树
	 */
	public WeightedGraph prim(WeightedGraph G) {
		
		WeightedGraph tree = new WeightedGraph();
		
		// 将起始点放入最小生成树中
		tree.nodes.add(G.nodes.get(0));
		tree.edges.add(new Edge(G.nodes.get(0), G.nodes.get(0), 0));
		
		// 通过循环加边，直到图的所有顶点在最小生成树中
		while (tree.nodes.size() != G.nodes.size()) { //如果所有的顶点都在最小生成树中，跳出循环
			Edge minimumEdge = new Edge(null, null, Integer.MAX_VALUE);			
			for (Node n : tree.nodes) { // 找出不在最小生成树中最小的边(该边满足一个顶点在最小生成树中，一个顶点不在最小生成树中)
				for (Edge e : n.edges) {  //外に出るエッジ
					if (e.weight < minimumEdge.weight  //外に出るエッジから最小のエッジを選択する
							&& !tree.nodes.contains(e.getEnd())) {
						minimumEdge = e;
					}
				}
			}
			//将不在最小生成树中最小的边加入到最小生成树中
			tree.edges.add(minimumEdge);
			//将该边不在最小生成树的顶点加入到最小生成树中
			tree.nodes.add(minimumEdge.end);
		}
		return tree;// 返回最小生成树
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
	 * 驱动函数，通过从txt中读取的数据，构建图的邻接矩阵和顶点数组
	 * 
	 * @param result
	 *            ：从txt中读取的数据
	 * @return
	 */
	public String[] findNodesEdges(String result) {
		WeightedGraph t = new WeightedGraph();
		Prim prim = new Prim();

		// for循环：从result中提取图的邻接矩阵、顶点数组
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// 读取顶点数据
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.nodes.add(new Node(node));
				}
				if (element.length == 3) {// 读取邻接矩阵
					int from = Integer.parseInt(element[0]);
					int to = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);
					t.addEdge(from, to, weight);
				}
			}
		}

		WeightedGraph tree = prim.prim(t);// 调用方法得到结果
		String[] path = new String[tree.nodes.size()];
		for (int i = 0; i < path.length; i++) {
			path[i] = tree.edges.get(i).end.getName() + " "
					+ tree.edges.get(i).start.getName() + " "
					+ tree.edges.get(i).weight;
		}
		return path;// 返回结果
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
	
/*	public static void main (String args[]) throws IOException{

		Prim prim= new Prim();
	  	File testFileName=new File("./Graph/graphprim.txt");
	 	File OutFileName=new File("./Graph/primout1.txt");

	 	String result=prim.readFile(testFileName);//read the file
		String[] G=prim.findNodesEdges(result);//find nodes and edges from input string
		String[] path= prim.prim(G); 
		
		System.out.println("minimum spanning tree");
		for (int i=0; i< path.length; i++){
			System.out.println(path[i]);
		}

		prim.writeFile(OutFileName, path);   
	    
		
   }*/

}