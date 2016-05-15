public class May142016 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Height(root)==-1) return false;
        return true;
    }
    public int Height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int hl = Height(root.left);
        int hr = Height(root.right);
        if(hl == -1 || hr == -1) return -1;
        if (Math.abs(hl-hr) > 1) return -1;
        int h = 1 + Math.max(hl,hr);
        return h; 
    }

    // next permutation
    // scan from right to left and find the first element that is
    // less than its previous one 
    public void nextPermutation(int[] input) {
        int p = 0;
        for (int i=input.length-2;i>=0;i--) {
            if (input[i] < input[i+1]) {
                p = i;
                break;
            }
        }
        // if (p==0) {
        //     reverse(input,0,input.length-1);
        // }
        // else {
            reverse(input,p,p+1);
            reverse(input,p+1,input.length-1);
        // }
    }
    public void reverse (int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }

    public int LongestConsecutive(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
        for (int e: nums) {
            set.add(e);
        }
        for (int e:nums) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count,max);
        }
        return max;
    }

    public int LongestConsecutive2(int[] num) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int n: num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n-1)) ? map.get(n-1) : 0;
                int right = (map.containsKey(n+1)) ? map.get(n+1) : 0;
                // sum : length of the sequence in is in
                int sum = left + right + 1;
                map.put(n, sum);
                // keep track of the max length
                res = Math.max(res, max);
                // extend the length to the boundary(s)
                // of the sequence 
                map.put(n - left, sum);
                map.put(n + right, sum);

            }
            else {
                continue;
            }
        }
        return res;
    }

    // max height of bst
    public int MaxHeightBST (TreeNode root) {
        if(root==null) return 0;
        int lh = MaxHeightBST(root.left);
        int rh = MaxHeightBST(root.right);
        return (lh > rh) ? lh + 1: rh + 1;
    }
    // finding the maximum depth of a binary tree using 
    // post-order traversal use bfs
    public int MaxDepthBST (TreeNode root) {
        if (!root) return 0;
        Stack<TreeNode> stack;
        s.push(root);
        int maxDepth = 0;
        TreeNode prev = null;
        while (!s.isEmpty()) {
            TreeNode curr = s.top();

        }
    }

    // print the tree in order levels
    public void printLevelBST (TreeNode root) {
        if (!root) return;
        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currentLevel.addLast(root)
        while (!currentLevel.isEmpty()) {
            TreeNode head = currentLevel.removeFirst();
            currentLevel.pop();
            if (head) {
                System.out.print(head.val+" ");
                nextLevel.addLast(root.left);
                nextLevel.addLast(root.right);
            }
            if (currentLevel.isEmpty()) {
                System.out.println();
                LinkedList<TreeNode> temp = nextLevel;
                nextLevel = currentLevel;
                currentLevel = temp;
            }
        }   
    }

    public static void main (String[] args) {
        May142016 may = new May142016();
        TreeNode root = 
        may.printLevelBST(root);
    }
}