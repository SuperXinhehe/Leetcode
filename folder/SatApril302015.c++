
using namespace std;

int swap(int &a, int &b) {
	int temp = a;
	a = b;
	b = temp;
}
// counting number of inversions

int count(vector<int> v1, vector<int> v2) {
	vector<int> ind;
	for (int i=0;i<v2.size();i++) {
		ind[v2[i]] = i;
	}
	int count = 0;
	// if i<j and vi > vj then inversion
	for (int i=0;i<v1.size()-1;i++) {
		for (int j=i+1;j<v1.size();j++) {
			if(ind[v1[i]] > ind[v1[j]]) {
				count++;
			}
		}
	}
	return count;	
}

int main() {
	vector<vector<int>> arr(6,vector<int>(6));
	for (int arr_i = 0;arr_i < 6;arr_i++) {
		or (int arr_j=0;arr_j<6;arr_j++) {
			cin >> arr[arr_i][arr_j];
		}
	}
	int max = numeric_limits<int>::min();
	for (int i=0;i<4;i++) {
		for (int j=0;j<4;j++) {
			int out = sum(arr,i,j);
			if (max < out) max = out;
		}
	}
	cout << max << endl;
	return 0;

}