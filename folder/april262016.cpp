#include <iostream>
#include <algorithm>

// do the following for remaining n-1 jobs
// if the current job can fit in the current result sequence
// without missing the deadline, add current job to the result.
using namespace std;
struct Job {
	char id; // job id
	int deadline; //deadline of job
	int profit; // profit if job is over before or on deadline
};

// comparison function for sorting all jobs according to profit
bool comparison(Job a, Job b) {
	return (a.profit > b.profit);
}

// returns minimum number of platforms required
void printJobScheduling(Job arr[], int n) {
	// acoording to decreasing order of profit
	sort(arr,arr+n,comparison);
	int result[n]; // to store result (sequence of jobs)
	bool slot[n]; // to keep track of free time slots

	// initilize all slots to be free
	for (int i=0;i<n;i++) {
		slot[i] = false;
	}
	// iterate through all given jobs
	for (int i=0;i<n;i++) {
		// find a free slot for this job
		// from the last possible slot
		for (int j=min(n,arr[i].deadline)-1;j>=0;j--) {
			// free slot found
			if (slot[j] == false) {
				result[j] = i; // add this job to result
				slot[j] = true; // make the slot occupied
				break;
			}
		}
	}
}

// counting number of ways to proceed..
// O (n^3)
int printCountRec(int dist) {
	// base case:
	if (dist < 0) return 0;
	if (dist == 0) return 1;

	return printCountRec(dist-1) + printCountRec(dist-2)
	+ printCountRec(dist - 3);
}

// dp:
int printCountdp(int dist) {
	int count[dist+1];
	count[0] = 1, count[1] = 1, count[2] = 2;

	// fill the count array in bottom up manner
	for (int i=3;i<=dist;i++) {
		count[i] = count[i-1] + count[i-2] + count[i-3];
	}
	return count[dist];
}
