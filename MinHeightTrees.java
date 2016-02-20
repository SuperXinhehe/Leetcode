import java.util.*;

public class MinHeightTrees {
	HashMap<Integer,LinkedList<Integer>> graph;
	HashMap<Integer,Boolean> marked;
	HashMap<Integer,Integer> prev;
	//HashMap<Integer,LinkedList<Integer>> distTo;
	// input n number of nodes
	// and edges as two-dimensional array
	public List<Integer> getMinHeightRoot(int n, int[][] edges) {
		List<Integer> roots = new ArrayList<Integer>();
		graph = new HashMap<Integer,LinkedList<Integer>>();
		//distTo = new HashMap<Integer,LinkedList<Integer>>();
		// construct the graph as hashmap for later use
		for(int[] edge: edges) {
			if(!graph.containsKey(edge[0])) {
				graph.put(edge[0],new LinkedList(Arrays.asList(edge[1])));
			}
			else {
				LinkedList<Integer> adj = graph.get(edge[0]);
				adj.add(edge[1]);
				graph.put(edge[0],adj);
			}
			if(!graph.containsKey(edge[1])) {
				graph.put(edge[1],new LinkedList(Arrays.asList(edge[0])));
			}
			else {
				LinkedList<Integer> adj2 = graph.get(edge[1]);
				adj2.add(edge[0]);
				graph.put(edge[1],adj2);
			}
		}
		// for each node find the furthest distance to other point using bfs
		HashMap<Integer,Integer> maxDists = new HashMap<Integer,Integer>();
		int curMax;
		int dis;
		// record the maximum distance to another node in this graph
		for(int i=0;i<n;i++) {
			curMax = Integer.MIN_VALUE;
			for(int j=0;j<n;j++) {
				if(j!=i) {
					dis = bfs(i,j);
					if(dis > curMax) {
						curMax = dis;
					}
				}
			}
			maxDists.put(i,curMax);
		}
		int minDis = Collections.min(maxDists.values());
		for(Map.Entry<Integer,Integer> entry: maxDists.entrySet()) {
			if(entry.getValue().equals(minDis)) {
				roots.add(entry.getKey());
			}
		}
		return roots;
	}
	// if the distance from bfs greater than curMax discard..
	public int bfs(int source,int target) {
		prev = new HashMap<Integer,Integer>();
		marked = new HashMap<Integer,Boolean>();
		List<Integer> directions = new LinkedList<Integer>();
		Integer curNode = source;
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.offer(source);
		marked.put(source,true);
		while(!q.isEmpty()) {
			curNode = q.poll();
			if(curNode == target) {
				break;
			}
			else {
				for(Integer node: graph.get(curNode)) {
					if(!marked.containsKey(node)) {
						q.add(node);
						marked.put(node,true);
						prev.put(node,curNode);
					}
				}
			}
		}
		if(!curNode.equals(target)) {
			return -1;
		}
		// find the path
		for(Integer node=target;node!=null;node = prev.get(node)) {
			directions.add(node);
		}
		return directions.size();
	}
	public static void main(String args[]) {
		MinHeightTrees htree = new MinHeightTrees();
		int[][] graph = new int[][] {
			{0,3},
			{1,3},
			{2,3},
			{4,3},
			{5,4}
		};
		List<Integer> out = htree.getMinHeightRoot(6,graph);
		System.out.println(out.toString());
	}
}