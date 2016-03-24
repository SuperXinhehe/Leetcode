#include<vector>
using namespace std;

class ReItinerary {
 public:
  vector<string> findItinerary(vector<pair<string, string>> tickets) {
   vector<string> ans;
   int n = tickets.size();
   //key, value pair added to g..
   for(int i=0;i<n;++i) {
    g[tickets[i].first].insert(tickets[i].second);
   }
   dfs("JFK",ans);
   reverse(ans.begin(),ans.end());
   return ans;
  }
 private:
  void dfs(string u,vector<string> &ans) {
   while(g[u].size()) {
    string v = *g[u].begin();
    g[u].erase(g[u].begin());
    dfs(v,ans);
   }
   ans.push_back(u);

   }
 private:
  unordered_map<string,multiset<string>> g;


};
