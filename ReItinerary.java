import java.util.*;

public class ReItinerary {
	public LinkedHashMap<String,List<String>> hm = new LinkedHashMap<String,List<String>>();
	public List<String> findItinerary (String[][] tickets) {
		List<String> ans = new ArrayList<String>();
		for(int i=0;i<tickets.length;i++) {
			List<String> l;
			if(hm.containsKey(tickets[i][0])) {
				l = hm.get(tickets[i][0]);
			}
			else {
				l = new ArrayList<String>();
			}
			l.add(tickets[i][1]);
			hm.put(tickets[i][0],l);
		}
		// output a list from dfs function...
		ans = dfs("JFK",ans);
		// reverse the ans list...
		Collections.reverse(ans);
		return ans;
	}

	public List<String> dfs (String source, List<String> ans) {
		List<String> l = hm.get(source);
		System.out.println("adding :"+source);
		if(l==null) {
			ans.add(source);
			return ans;
		}
		ans.forEach(ele->System.out.print(ele));
		// System.out.println("....ans list:");
		while(!l.isEmpty()) {
			String v = l.get(0);
			System.out.println(v);
			l.remove(0);
			ans = dfs(v,ans);
		}
		ans.add(source);
		return ans;
	}

	public static void main(String[] args) {
		ReItinerary ri = new ReItinerary();
		String[][] tickets = {
			{"MUC","LHR"},
			{"JFK","MUC"},
			{"SFO","SJC"},
			{"LHR","SFO"}
		};
		List<String> out = ri.findItinerary(tickets);
		out.forEach(ele->System.out.print(ele+" "));
	}
}
