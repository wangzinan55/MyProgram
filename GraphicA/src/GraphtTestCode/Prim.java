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
	 * ͼ����
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
	 *            : Ҫ����С��������ͼ
	 * @return����С������
	 */
	public WeightedGraph prim(WeightedGraph G) {
		
		WeightedGraph tree = new WeightedGraph();
		
		// ����ʼ�������С��������
		tree.nodes.add(G.nodes.get(0));
		tree.edges.add(new Edge(G.nodes.get(0), G.nodes.get(0), 0));
		
		// ͨ��ѭ���ӱߣ�ֱ��ͼ�����ж�������С��������
		while (tree.nodes.size() != G.nodes.size()) { //������еĶ��㶼����С�������У�����ѭ��
			Edge minimumEdge = new Edge(null, null, Integer.MAX_VALUE);			
			for (Node n : tree.nodes) { // �ҳ�������С����������С�ı�(�ñ�����һ����������С�������У�һ�����㲻����С��������)
				for (Edge e : n.edges) {  //��˳��륨�å�
					if (e.weight < minimumEdge.weight  //��˳��륨�å�������С�Υ��å����x�k����
							&& !tree.nodes.contains(e.getEnd())) {
						minimumEdge = e;
					}
				}
			}
			//��������С����������С�ı߼��뵽��С��������
			tree.edges.add(minimumEdge);
			//���ñ߲�����С�������Ķ�����뵽��С��������
			tree.nodes.add(minimumEdge.end);
		}
		return tree;// ������С������
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
	 * ����������ͨ����txt�ж�ȡ�����ݣ�����ͼ���ڽӾ���Ͷ�������
	 * 
	 * @param result
	 *            ����txt�ж�ȡ������
	 * @return
	 */
	public String[] findNodesEdges(String result) {
		WeightedGraph t = new WeightedGraph();
		Prim prim = new Prim();

		// forѭ������result����ȡͼ���ڽӾ��󡢶�������
		for (String w : result.split("\n", 0)) {
			if (!(w.equals("node node_Name") || w
					.equals("source target weight"))) {
				System.out.println(w);
				String[] element = w.split("\\s+");
				if (element.length == 2) {// ��ȡ��������
					int index = Integer.parseInt(element[0]);
					String node = element[1];
					t.nodes.add(new Node(node));
				}
				if (element.length == 3) {// ��ȡ�ڽӾ���
					int from = Integer.parseInt(element[0]);
					int to = Integer.parseInt(element[1]);
					int weight = Integer.parseInt(element[2]);
					t.addEdge(from, to, weight);
				}
			}
		}

		WeightedGraph tree = prim.prim(t);// ���÷����õ����
		String[] path = new String[tree.nodes.size()];
		for (int i = 0; i < path.length; i++) {
			path[i] = tree.edges.get(i).end.getName() + " "
					+ tree.edges.get(i).start.getName() + " "
					+ tree.edges.get(i).weight;
		}
		return path;// ���ؽ��
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