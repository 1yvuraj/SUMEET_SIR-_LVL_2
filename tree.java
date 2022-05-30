<----------------class 1-------------------->
//left view
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        if(root==null)return new ArrayList<>();
        while (list.size() > 0) {
            int size=list.size();
            for (int i = 0; i<size; i++) {
                Node node = list.removeFirst();
                if (i == 0) ans.add(node.data);
                if (node.left != null) {
                    list.addLast(node.left);
                }
                if (node.right != null) {
                    list.addLast(node.right);
                }
            }
        }
        return ans;
    }
}
//right view
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       ArrayList<Integer> ans = new ArrayList<>();
       LinkedList<TreeNode> list = new LinkedList<>();
       list.addLast(root);
       if(root==null)return new ArrayList<>();
       while (list.size() > 0) {
           int size=list.size();
           for (int i = 0; i<size; i++) {
               TreeNode node = list.removeFirst();
               if (i == size-1) ans.add(node.val);
               if (node.left != null) {
                   list.addLast(node.left);
               }
               if (node.right != null) {
                   list.addLast(node.right);
               }
           }
       }
       return ans;
   }
}
//top view
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class pair{
        Node node;
        int cn;
        pair(Node node,int cn)
        {
            this.node=node;
            this.cn=cn;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        int min=(int)1e9;
        int max=-(int)1e9;
        
        LinkedList<pair>list=new LinkedList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        list.addLast(new pair(root,0));
        if(root==null)return ans;
        while(list.size()>0)
        {
            
                pair p=list.removeFirst();
                if( !map.containsKey(p.cn))
                {map.put(p.cn,p.node.data);
                  min=Math.min(min,p.cn);
                  max=Math.max(max,p.cn);
                }
                if(p.node.left!=null)
                {
                     list.addLast(new pair(p.node.left,p.cn-1));
                }
                if(p.node.right!=null)
                {
                    list.addLast(new pair(p.node.right,p.cn+1));
                }
            
        }
         for(int i=min;i<=max;i++)
         {
             ans.add(map.get(i));
         }
       
        return ans;
        
    }
}
//bottom view
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class pair{
        Node node;
        int cn;
        pair(Node node,int cn)
        {
            this.node=node;
            this.cn=cn;
        }
    }
    static ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        int min=(int)1e9;
        int max=-(int)1e9;
        
        LinkedList<pair>list=new LinkedList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        list.addLast(new pair(root,0));
        if(root==null)return ans;
        while(list.size()>0)
        {
            int size=list.size();
            pair p=list.removeFirst();
             map.put(p.cn,p.node.data);
                  min=Math.min(min,p.cn);
                  max=Math.max(max,p.cn);
                
                if(p.node.left!=null)
                {
                     list.addLast(new pair(p.node.left,p.cn-1));
                }
                if(p.node.right!=null)
                {
                    list.addLast(new pair(p.node.right,p.cn+1));
                }
            
        }
         for(int i=min;i<=max;i++)
         {
             ans.add(map.get(i));
         }
       
        return ans;
        
    }
}
//levelorderlinewise
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode>list=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        list.addLast(root);
        if(root==null)return ans;
        while(list.size()>0)
        {
            int size=list.size();
            ArrayList<Integer>main=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=list.removeFirst();
                 main.add(node.val);
                if(node.left!=null)
                {
                    list.addLast(node.left);
                }
                if(node.right!=null)
                {
                    list.addLast(node.right);
                }
                
                    
            }
            ans.add(main);
            
            
        }
        
        return ans;
    }
}
//lolw
public static void levelOrderLW(Node node) {
    // write your code here

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    queue.add(null);

    while(queue.size() > 0){
        Node temp = queue.remove();

        if(temp != null){
          System.out.print(temp.data + " ");

          if(temp.left != null){
              queue.add(temp.left);
          }

          if(temp.right != null){
              queue.add(temp.right);
          }
        } else {
          System.out.println();

          if(queue.size() > 0){
            queue.add(null);
          }
        }
    }

//revrse level order
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
         ArrayList<Integer>main=new ArrayList<>();
         LinkedList<Node>ans=new LinkedList<>();
         ans.addLast(node);
        while(ans.size()>0)
        {
            int size=ans.size();
            for(int i=0;i<size;i++)
            {
                Node p=ans.removeFirst();
                main.add(p.data);
                if(p.right!=null)
                {
                    ans.addLast(p.right);
                }
                 if(p.left!=null)
                {
                    ans.addLast(p.left);
                }
            }
        }
        Collections.reverse(main);
        return main;
        
    }
}     
<----------------class 2--------------------> 
gfg 
class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static class pair{
        Node node;
        int h;
        pair(Node node,int h)
        {
            this.node=node;
            this.h=h;
        }
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
       LinkedList<pair>list=new LinkedList<>();
       HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
       int min =(int)1e9;
       int max=-(int)1e9;
       list.add(new pair(root,0));
       while(list.size()>0)
       {
           pair p=list.removeFirst();
           if(!map.containsKey(p.h))
           {
               map.put(p.h, new ArrayList<>());
               map.get(p.h).add(p.node.data);

           }else{
            map.get(p.h).add(p.node.data);
           }
           min=Math.min(min,p.h);
           max=Math.max(max,p.h);
           if(p.node.left!=null)
           {
               list.addLast(new pair(p.node.left,p.h-1));
           }
           if(p.node.right!=null)
           {
               list.addLast(new pair(p.node.right,p.h+1));
           }
       }
       ArrayList<Integer>main=new ArrayList<>();
       for(int i=min;i<=max;i++)
       {
        ArrayList<Integer>ans=map.get(i);
        for(int j=0;j<ans.size();j++)
        {
            main.add(ans.get(j));
        }
       }
       return main;

    }
}
//leetcode
class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static class pair implements Comparable<pair>{
        TreeNode node;
        int h;
        int d;
        pair(TreeNode node,int h,int d)
        {
            this.node=node;
            this.h=h;
            this.d=d;
        }
         // this - other means increasing
        // other - this means decreasing
        public int compareTo(pair other){
            if(this.d == other.d){
                return this.node.val - other.node.val;
            } else {
                return this.d - other.d;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    
       LinkedList<pair>list=new LinkedList<>();
       HashMap<Integer,PriorityQueue<pair>>map=new HashMap<>();
       int min =(int)1e9;
       int max=-(int)1e9;
       list.add(new pair(root,0,1));
       while(list.size()>0)
       {
           pair p=list.removeFirst();
           if(!map.containsKey(p.h))
           {
               map.put(p.h, new PriorityQueue<>());
               map.get(p.h).add(p);

           }else{
            map.get(p.h).add(p);
           }
           min=Math.min(min,p.h);
           max=Math.max(max,p.h);
           if(p.node.left!=null)
           {
               list.addLast(new pair(p.node.left,p.h-1,p.d+1));
           }
           if(p.node.right!=null)
           {
               list.addLast(new pair(p.node.right,p.h+1,p.d+1));
           }
       }
       List<List<Integer>>ans=new ArrayList<>();
       for(int i=min;i<=max;i++)
       {
        PriorityQueue<pair>p=map.get(i);
        ArrayList<Integer>a=new ArrayList<>();
        while(p.size()>0)
        {
            a.add(p.remove().node.val);
        }
        ans.add(a);
       }
       return ans;

    }
}
//gfg diginal
class Tree
{     int max=-(int)1e9;
      public ArrayList<Integer> diagonal(Node root)
      {
        HashMap<Integer,ArrayList<Integer>>ans=new HashMap<>();
        help(root,0,ans);
        ArrayList<Integer>a=new ArrayList<>();
        for(int i=0;i<=max;i++)
        {
            ArrayList<Integer>p=ans.get(i);
            for(int j=0;j<p.size();j++)
            {
                
                a.add(p.get(j));
            } 
        }
        return a;
      }
      public void help(Node root,int level,HashMap<Integer,ArrayList<Integer>>map)
      {
          if(root==null)return ;
         if(!map.containsKey(level))
         {
             map.put(level,new ArrayList<>());
             map.get(level).add(root.data);
         }
         else{
            map.get(level).add(root.data);
         }
         max=Math.max(max,level);
         help(root.left,level+1,map);
         help(root.right,level,map);
      }
}

//bfs digonal
class Tree
{     int max=-(int)1e9;
      public static class pair{
          Node node;
          int level;
          pair(Node node, int level){
              this.node=node;
              this.level=level;
          }
      }
      public ArrayList<Integer> diagonal(Node root)
      {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        LinkedList<pair>list=new LinkedList<>();
        list.addLast(new pair(root,0));
        while(list.size()>0)
        {
            pair p=list.removeFirst();
            if(!map.containsKey(p.level))
            {
                map.put(p.level,new ArrayList<>());
                map.get(p.level).add(p.node.val);
 
            }else{
                map.get(p.level).add(p.node.val);
            }
            max=Math.max(max,p.level);
            if(p.node.left!=null)
            {
                list.addLast(new pair(p.node.left,p.level+1));
            }
            if(p.node.right!=null)
            {
                list.addLast(new pair(p.node.right,p.level));
            }
        }
        ArrayList<Integer>a=new ArrayList<>();
        for(int i=0;i<=max;i++)
        {
            ArrayList<Integer>p=ans.get(i);
            for(int j=0;j<p.size();j++)
            {
                
                a.add(p.get(j));
            } 
        }
        return a;

      }
      
}
// Binary Tree Coloring Game
class Solution {
    int ls=0;
    int rs=0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,n,x);
        int others=n-ls-rs-1;
        int max=Math.max(others,Math.max(ls,rs));
        return max>n/2;
        
    }
     public int  size(TreeNode root, int n, int x) {
        if(root==null)return 0;
        int left=size(root.left,n,x);
        int right=size(root.right,n,x);
        if(root.val==x)
        {
            ls=left;
            rs=right;
        }
        return left+right+1;
         
    }
}
<----------------class 3--------------------> 
//morisis in
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                }
                if (p.right == cur) {
                    p.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
//morisis pre
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode p = cur.left;  
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    ans.add(cur.val);
                    p.right = cur;
                    cur = cur.left;
                }
                if (p.right == cur) {
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}

//bst me replace two value to sai karna tha
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                if(prev != null && prev.val > cur.val) {
                    if(n1 == null) {
                        n1 = prev;
                        n2 = cur;
                    } else {
                        n2 = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                }
                if(p.right == cur){
                    if (prev != null && prev.val > cur.val) {
                        if (n1 == null) {
                            n1 = prev;
                            n2 = cur;
                        } else {
                            n2 = cur;
                        }
                    }
                    prev = cur;
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
        
    }
}
//x given uska next
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public Node inorderSuccessor(Node root, Node x) {
        Node cur = root;
        Node prev = null;
        Node ans = null;
        while (cur != null) {
            if (cur.left == null) {
                if (prev == x) {
                    ans = cur;
                }
                prev = cur;
                cur = cur.right;
            } else {
                Node p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                }
                if (p.right == cur) {
                    if (prev == x) {
                        ans = cur;
                    }
                    prev = cur;
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
       
    }
}

class Solution {
    public class Pair{
        int val;
        int ans;

        Pair(int v,int a){
            val = v;
            ans = a;
        }
    }
    public Pair helper(Tree node){
        if(node==null){
            return new Pair(Integer.MIN_VALUE,0);
        }
        Pair l = helper(node.left);
        Pair r = helper(node.right);

        int ans = l.ans + r.ans;
        int mx = Math.max(node.val,Math.max(l.val,r.val));

        if(node.val>=l.val && node.val>=r.val){
            ans++;
        }
        return new Pair(mx,ans);
    }
    public int solve(Tree root) {
       Pair a = helper(root);

       return a.ans;
    }
}

class Solution {
    public class pair{
        int sum;
        int ans;

        pair(int sum,int ans){
            this.sum = sum;
            this.ans = ans;
        }
    }
    public pair helper(Tree node){
        if(node==null){
            return null;
        }
        pair l = helper(node.left);
        pair r = helper(node.right);
         if(l!=null && r!=null ){
        if( l.sum%2==1 && r.sum%2==0 || l.sum%2==0 && r.sum%2==1)
        {
            return new pair(l.sum+r.sum+node.val,l.ans+r.ans+1);
        }
          return new pair(l.sum+r.sum+node.val,l.ans+r.ans);
        }else if(l==null && r==null){
        return new pair(node.val,0);
        }else{
           return l==null? new pair(r.sum+node.val,r.ans):new pair(l.sum+node.val,l.ans);
        }
       
    }
    public int solve(Tree root) {
         if(root==null) return 0;
       pair a = helper(root);

       return a.ans;
    }
}
<----------------class 4--------------------> 

public static void iterativePrePostInTraversal(Node node) {
    // write your code here
    LinkedList<Pair>list=new LinkedList<>();
    list.addFirst(new Pair(node,0));
    String pre="";
    String in="";
    String post="";
    
    while(list.size()>0)
    {
        Pair top=list.getFirst();
        if(top.state==0)
        {
           pre+=top.node.data+" ";
           if(top.node.left!=null)
           {
               Pair l=new Pair(top.node.left,0);
               list.addFirst(l);
           }
            
        }else if(top.state==1)
        {
            in+=top.node.data+" ";
           if(top.node.right!=null)
           {
               Pair r=new Pair(top.node.right,0);
               list.addFirst(r);
           }
        }else{
            post+=top.node.data+" ";
            list.removeFirst();
        }
        top.state++;
    }
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
    
  }
  //built tree from pre ans in
  //https://pepcoding.com/resources/online-java-foundation/binary-tree/iterative-pre-post-in-binary-tree-official/ojquestion
  class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
            
        }
        return contruct(0,preorder.length-1,0,inorder.length-1,inorder,preorder,map);
    }
    public TreeNode contruct(int pl,int ph,int il,int ih,int[]inorder,int []preorder,HashMap<Integer,Integer>map) {
        if(pl>ph || il>ih)return null;
        TreeNode node=new TreeNode();
        node.val=preorder[pl];
        int idx=map.get(preorder[pl]);
        int lhs=map.get(preorder[pl])-il;
        node.left=contruct(pl+1,pl+lhs,il,idx-1,inorder,preorder,map);
        node.right=contruct(pl+lhs+1,ph,idx+1,ih,inorder,preorder,map);
        return node;
    }
}
//built tree from in and post
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode retVal = buildTreeRec(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return retVal;
    }
    
    public TreeNode buildTreeRec(int[] inorder, int[] postorder, int postlo, int posthi, int inlo, int inhi){
        if(postlo > posthi || inlo > inhi){
            return null;
        }
        
        TreeNode node = new TreeNode();
        
        int idx = inlo;
        while(idx <= inhi){
            if(inorder[idx] == postorder[posthi]){
                break;
            }
            idx++;
        }
        
        int rhs = inhi - idx;
        
        node.val = postorder[posthi];
        node.left = buildTreeRec(inorder, postorder, postlo, posthi - rhs - 1, inlo, idx - 1);
        node.right = buildTreeRec(inorder, postorder, posthi - rhs, posthi - 1, idx + 1, inhi);
        
        return node;
    }
}
//https://leetcode.com/problems/count-complete-tree-nodes/
//compelte hai ya nhi
//Count Complete Tree Nodes
//agar full binery tree to formula 2^ht+1-1;
//ab hum dono taraf se hieght le ke upper formula lga de ge
//per same nhi to har point me compelte wala seen kare ge
//tc-logn*logn
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        TreeNode ln=root.left;
        int lnc=0;
        while(ln!=null)
        {
            ln=ln.left;
            lnc++;
            
        }
         TreeNode rn=root.right;
        int rnc=0;
        while(rn!=null)
        {
            rn=rn.right;
            rnc++;
            
        }
        if(rnc==lnc)return (1<<(lnc+1))-1;
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
}
//0(n)
class Solution {
    int ans = 0;

    public int countNodes(TreeNode root) {
        help(root);
        return ans;
    }
    public void help(TreeNode root) {
        if (root == null) return;
        ans++;
        help(root.left);
        help(root.right);
    }
}
//Sum of Two Numbers in BSTs
class Solution {
    public boolean solve(Tree root1, Tree root2, int target) {
        if(root1 == null || root2  == null){
            return false;
        }
        if(root1.val+root2.val ==target){
            return true;
        }
        if(root1.val + root2.val < target){
          return solve(root1.right,root2,target) || solve(root1,root2.right,target);
        }else{
            return solve(root1.left,root2,target) || solve(root1,root2.left,target);
        }

    }
}
  <----------------class 5--------------------> 
  //max sum root to leaf
  class Solution
{
    public static int maxPathSum(Node root)
    {
       return help(root);
    }
     public static int help(Node root)
    {
        if(root==null)
        {
            return 0;
        }
       
      int l= help(root.left);
      int r= help(root.right);
      return Math.max(l,r)+root.data;
    }
}
//ak test case me tut jai ga jab ak line ho
//is lia ye kara
class Solution
{
    public static int maxPathSum(Node root)
    {
       return help(root);
    }
     public static int help(Node root)
    {
        if(root.left!=null && root.right!=null){
            int l=help(root.left);
            int r=help(root.right);
            return Math.max(l,r)+root.data;
        }
        else if(root.left!=null)
        {
            int l=help(root.left);
            return l+root.data;
        }else if(root.right!=null)
        {
             int r=help(root.right);
            return r+root.data;
        }else{
            return root.data;
        }
    }
}
//onemore approch
class Solution
{
    static int max;
    public static int maxPathSum(Node root)
    {
       max=-(int)1e9;
       help(root,0);
       return max;
    }
     public static void help(Node root,int ans)
    {   if(root==null)return ;
        if(root.left==null && root.right==null)max=Math.max(max,ans+root.data);
        help(root.right,ans+root.data);
        help(root.left,ans+root.data);
    }
}
//root to any node max sum

class Solution
{
    public static int maxPathSum(Node root)
    {
       return help(root);
    }
     public static int help(Node root)
    {
        if(root.left!=null && root.right!=null){
            int l=help(root.left);
            int r=help(root.right);
            int ldash=Math.max(0,l.data);
            int rdash=Math.max(0,r.data);
            return Math.max(ldash,rdash)+root.data;
        }
        else if(root.left!=null)
        {
            int l=help(root.left);
            int ldash=Math.max(0,l.data);
            return ldash+root.data;
        }else if(root.right!=null)
        {
             int r=help(root.right);
             int rdash=Math.max(0,r.data);
            return rdash+root.data;
        }else{
            return root.data;
        }
    }
}
//another approch
class Solution
{
    static int max;
    public static int maxPathSum(Node root)
    {
       max=-(int)1e9;
       help(root,0);
       return max;
    }
     public static int  help(Node root,int ans)
    {   if(root==null)return 0;
        
        int l=help(root.right,ans+root.data);
        int r=help(root.left,ans+root.data);
        int ldash=Math.max(0,l);
        int rdash=Math.max(0,r);
        return Math.max(ldash,rdash)+root.data;
    }
}
//max sum any node to any node
class Solution {
    int max = -(int) 1e9;
    public int maxPathSum(TreeNode root) {
        max = -(int) 1e9;
        help(root);
        return max;
    }
    public int help(TreeNode root) {
        if (root == null) return 0;
        int l = help(root.left);
        int r = help(root.right);
        int ldash = Math.max(0, l);
        int rdash = Math.max(0, r);
        int sumNTN = ldash + rdash + root.val;
        max = Math.max(max, sumNTN);
        return Math.max(ldash, rdash) + root.val;
    }
}
//if not static
class Solution
{ 
    public int maxPathSum(TreeNode root) {
        int[]max=new int[1];
        max[0]=-(int)1e9;
        help(root,max);
         
        return max[0];
    }
    public int help(TreeNode root,int[]max) {
        if (root == null) return 0;
        int l = help(root.left,max);
        int r = help(root.right,max);
        int ldash = Math.max(0, l);
        int rdash = Math.max(0, r);
        int sumNTN = ldash + rdash + root.val;
        max[0] = Math.max(max[0], sumNTN);
        return Math.max(ldash, rdash) + root.val;
    }
}
//leaf to leaf(purely wla)
class Solution
{
     static int max=-(int)1e9;
    public static int maxPathSum(Node root)
    {
        max=-(int)1e9;

        
        
            help(root);
            return max;
        
       
    }
     public static int help(Node root)
    {
        if(root.left!=null && root.right!=null){
            int l=help(root.left);
            int r=help(root.right);
            max=Math.max(max,l+r+root.data);
            return Math.max(l,r)+root.data;
        }
        else if(root.left!=null)
        {
            int l=help(root.left);
           
            return l+root.data;
        }else if(root.right!=null)
        {
             int r=help(root.right);
            
            return r+root.data;
        }else{
            return root.data;
        }
    }
}
//leaf to leaf(gfg)(Becouse in gfg consider root with one child early)
class Solution
{
     static int max=-(int)1e9;
    public static int maxPathSum(Node root)
    {
        max=-(int)1e9;
        if(root.left!=null && root.right!=null) 
        {
            help(root);
            return max;
        }else{
            int val=help(root);
            return Math.max(max,val);
        }
       
    }
     public static int help(Node root)
    {
        if(root.left!=null && root.right!=null){
            int l=help(root.left);
            int r=help(root.right);
            max=Math.max(max,l+r+root.data);
            return Math.max(l,r)+root.data;
        }
        else if(root.left!=null)
        {
            int l=help(root.left);
           
            return l+root.data;
        }else if(root.right!=null)
        {
             int r=help(root.right);
            
            return r+root.data;
        }else{
            return root.data;
        }
    }
}

//targetsum from all node
class Solution {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        ans=0;
        help1(root,targetSum);
        return ans;
    }
    public void help2(TreeNode root, int sum,int targetSum) {
        if(root==null)return;
        if(sum+root.val==targetSum)ans++;
        help2(root.left,sum+root.val,targetSum);
        help2(root.right,sum+root.val,targetSum);
        
    }
     public void help1(TreeNode root,int targetSum) {
        if(root==null)return;
        help2(root,0,targetSum);
        help1(root.left,targetSum);
        help1(root.right,targetSum);
        
    }
}

  <----------------class 6--------------------> 
  //Path Sum III
  class Solution {
    int main = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        main = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        help1(root, root.val, targetSum, map);
        return main;
    }
    public void help1(TreeNode root, int sum, int targetSum, HashMap<Integer, Integer> map) {
        if (root == null) return;
        if (map.containsKey(sum - targetSum)) {
            main+=map.get(sum - targetSum);
        }
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        if(root.left!=null)
        help1(root.left, sum + root.left.val,targetSum, map);
        if(root.right!=null)
        help1(root.right, sum + root.right.val,targetSum, map);
        if (map.get(sum) == 1) {
            map.remove(sum);
        } else {
            map.put(sum, map.get(sum) - 1);
        }
    }
}
//bst from preorder
class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, -(int) 1e9, (int) 1e9);
    }
    public TreeNode help(int[] preorder, int si, int e) {
        if (idx == preorder.length) {
            return null;
        } else if (preorder[idx] > si && preorder[idx] < e) {
            TreeNode node = new TreeNode(preorder[idx]);
            idx++;
            node.left = help(preorder, si, node.val);
            node.right = help(preorder, node.val, e);
            return node;
        } else {
            return null;
        }
    }
}


  <----------------class 7--------------------> 
  //multiple by mirror
  //https://practice.geeksforgeeks.org/problems/image-multiplication0627/1#
  class Solution {
    long mod=1000000007;
    long ans=0;
   public long imgMultiply(Node root)
   {
      
      ans=(ans%mod+root.data*root.data)%mod;
      help(root.left,root.right);
      return ans;
      
   }
   public void help(Node n1,Node n2)
   {
       if(n1==null || n2==null)return;
       ans=(ans%mod+n1.data*n2.data)%mod;
      help(n1.left,n2.right);
       help(n1.right,n2.left);
      
      
   }
}
//Populating Next Right Pointers in Each Node
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// ex
// Input: root = [1,2,3,4,5,6,7]
// Output: [1,#,2,3,#,4,5,6,7,#]
//are linewise connect karna hai
class Solution {
    public Node connect(Node root) {
        help(root);
        return root;
        
    }  
     public void help(Node root) {
        if (root==null || root.left == null) return ;
        
        // up down approach, all the process before the recursive function
        // for nodes share same root, simply assign the next of right node to left node
        root.left.next = root.right;
        
        // for nodes not sharing same root，we need to find out if the root have next, 
        // if it does，point the next node to the left node of root.next
        if (root.next != null)
        root.right.next = root.next.left;
        
        // recursive function
        connect(root.right);
        connect(root.left);
        
    }  
    
}
//is valid bst
class Solution {
    public class pair{
        boolean isbst=true;
        Long max=Long.MIN_VALUE;
        Long min=Long.MAX_VALUE;
        pair(boolean isbst,long max,long min)
        {
            this.isbst=isbst;
            this.max=max;
            this.min=min;
        }
       
    }
    public boolean isValidBST(TreeNode root) {
       pair ans= help(root);
        return ans.isbst;
    }
     public pair help(TreeNode root) {
         if(root==null)
         {
             pair ans=new pair(true,Long.MIN_VALUE,Long.MAX_VALUE);
             return ans;
         }
         pair l=help(root.left);
         pair r=help(root.right);
         boolean b=(l.isbst)&&(r.isbst)&&(root.val>l.max&&root.val<r.min);
          long ma=Math.max(root.val,Math.max(l.max,r.max));
          long mn=Math.min(root.val,Math.min(l.min,r.min));
         
         
         return new pair(b,ma,mn);
    }
}
//all zero node remove
class Solution {
    public Tree solve(Tree root) {
        help(root);
        return root;
    }
    public Tree help(Tree root) {
        if(root==null)return null;
        root.left=help(root.left);
         root.right=help(root.right);
         if(root.left==null && root.right==null && root.val==0)return null;
         return root;
        
    }
}
//are leave at same level
class Solution {
    int y=-1;
    
    public boolean solve(Tree root) {
       return help(root,0); 

    }
    public boolean help(Tree root,int level) {
        if(root==null)return true;
        if(root.left==null && root.right==null)
        {
            if(y==-1)
            {
                 y=level;
                 return true;
            }
            return y==level;
        }
        boolean l=help(root.left,level+1);
        boolean r= help(root.right,level+1);
        return l&&r;
        

    }
}

//up right low likha hai hume chalte jana or ans btana last kya aye ga
class Solution {
    
    public int solve(Tree root, String[] moves) {
         return s(root,moves);
         
    }
    public int s(Tree root, String[] moves) {
        Stack<Tree>stack=new Stack<>();
        Tree cur=root;
        stack.push(root);
        for(int i=0;i<moves.length;i++)
        {
            if(moves[i].charAt(0)=='R')
            {
                if(cur.right!=null){
                    cur=cur.right;
                     stack.push(cur);
                }  
            }
            else if(moves[i].charAt(0)=='L'){
                if(cur.left!=null){
                    cur=cur.left;
                
                stack.push(cur);
                }
            }
            else if(moves[i].charAt(0)=='U'){
                stack.pop();
                if(stack.size()>0){
                    cur=stack.peek();
                }
            }
        }
        return cur.val;
    }
}
//sum avg of subtree of tree
class Solution {
    public static class pair{
        int maxsum;
        int count;
        double avg;
        pair(int maxsum,int count,double avg)
        {
            this.maxsum=maxsum;
            this.count=count;
            this.avg=avg;
        } 
    }
    public double solve(Tree root) {
        pair ans=help(root);
        return ans.avg;
    }
    public pair help(Tree root) {
        if(root==null){
           pair p=new pair(0,0,0.0); 
           return p;
        }
        pair l=help(root.left);
        pair r=help(root.right);
        int maxsum=l.maxsum+r.maxsum+root.val;
        int c=l.count+r.count+1;
        double avg=Math.max((maxsum/(double)c),Math.max(l.avg,r.avg));
        return new pair(maxsum,c,avg);
    }
}
//bst bana 
// Given a sorted list nums of size n, construct a binary search tree b
// Taking nums[k] as the root where k = floor(n / 2).
// Recursively constructing the left subtree using the list nums[:k]
// Recursively constructing the right subtree using the list nums[k + 1:]

class Solution {
    public Tree solve(int[] nums) {
        
        return solve(nums,0,nums.length);
    }
    public Tree solve(int[] nums,int start,int end) {
        if(start==end)
        {
            return null ;
        }
        int mid=(start+end)/2;
      Tree node=new Tree(nums[mid]);
      node.left=solve(nums,start,mid);
     node.right=solve(nums,mid+1,end);
     return node;

    }
}


