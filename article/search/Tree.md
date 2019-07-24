# 查找

[数据结构图形化](https://www.cs.usfca.edu/~galles/visualization/Algorithms.html)
[visualgo](https://visualgo.net/zh)

|数据结构|优点|缺点|
| -- |-- | -- |
|顺序查找 无序链表| 小型问题 | 数量多的情况下很慢 |
|二分查找 有序数组| 查找效率高，空间占用 | 插入操作慢(resize) |
|二叉查找树| 实现简单 | 性能最坏可能很大，链接需要额外空间 |
|平衡二叉树查找树(红黑树)| 最优的查找插入效率 | 链接需要额外空间 |
|散列表 Hash| 快速查找插入 | 需要计算数据的hash，无法进行有序性(排序之类)操作，链接需要额外空间 |

## 符号表

### 无序链表

最简单的选择是链表，每个节点存储一个键值对。

1. 插入
    - ![put](put1.gif)
2. 查找符号 5
    - ![search](search5.gif)
3. 查找符号 92
    - ![search](search92.gif)
4. 删除符号 69
    - ![delete69](delete69.gif)

#### 实现

```java
public class SequentialSearchST<Key, Value> {
    private int n;           // 键值对总数
    private Node first;      // the linked list of key-value pairs

    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    // 找到指定节点，找到则更新其值，否则插入
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        first = delete(first, key);
    }

    // 递归找到并删除
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
```

### 有序数组 -- 二分查找

使用基于二分查找实现的符号表使用的数据结构是一对平行的数组，一个存储键一个存储值，可以高效的实现`get()`等操作。

1. 线性查找
    - ![linear](linear779.gif)
2. 二分查找
    - ![binary](binary779.gif)

其核心是`rank()`方法，它返回的是小于给定键值的键的数量。
- 对于`get()`，只要键存在，`rank()`方法就能找到它。
- 对于`put()`，需要将`rank()`后边的键值向后移动一格。
- 动态调整数组，使 1/4 < (元素个数/数组长度)

#### 实现

```java

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    /**
     * 实现动态调整数组
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   

    // 对数组的大小进行调整
    // 创建新的capacity大小的数组，将原数组复制进去
    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 包含key
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // 通过key得到value
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        if (isEmpty()) return null;
        int i = rank(key); 
        // 只是返回比key小的个数
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    } 

    // 返回比key小的键的个数
    // 因为所有的key都是已经排好序的，二分查找key
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null"); 

        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 

    // 插入并调整大小
    public void put(Key key, Value val)  {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        // key存在，更改值
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // 调整数组大小为两倍
        if (n == keys.length) resize(2*keys.length);

        // 后边的元素从将要插入的地方后移一格
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++; // 元素个数
    } 

    // 删除并调整
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        int i = rank(key);

        // key不存在
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        // 后边的元素从key的位置向前移动一格
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--; // 元素个数
        keys[n] = null;  // 防止对象游离(内存泄漏)
        vals[n] = null;

        // 当元素个数只有1/4数组个数的时候， 缩小一半
        if (n > 0 && n == keys.length/4) resize(keys.length/2);
    }
}

```

### 总结

一般情况下二分是比顺序查找要快的。但是二分没法做到高效插入(删除)。

|数据结构|查找(最坏)|插入(最坏)|查找(平均)|插入(平均)|
| -- |-- | -- | -- | -- |
|顺序查找 无序链表| N | N | N/2 | N |
|二分查找 有序数组| lgN | 2N | lgN | N |


## 查找树

### 二叉查找树 Binary Search Tree

一个典型的二叉树

![treesample](btreesample.png)

1. 查找（与二分查找几乎一致）
    1. 如果树是空的，查找未命中。对于未命中的查找，终点是空节点。
    2. 被查找的键和根节点的键相同，查找命中
    3. 递归地在子树中查找
        - 被查找的键较小则选择左子树
        - 较大选择右子树
    4. 最好、平均、最坏情况 ![BSTpossibilities](BSTpossibilities.png)
2. 插入（和查找类似）
    1. 树是空的，返回含有该键值的新结点
    2. 被查找的键小于根节点的键，在左子树中插入该键，否则在右边
    3. 随机插入的情况 ![insert-key-random-order.gif](insert-key-random-order.gif)
3. 得到树的最小值
    1. 相当于得到结点的最左子结点
    2. 递归得到左子节点直到左子节点的左子树为空
3. 删除
    1. 删除最大最小值
        - 最小：深入根节点的左子节点直到遇到空连接，然后将指向该节点的链接指向该节点的右子树
        - 删除最大是删除最小的相反操作
    2. 删除： 删除结点x后用它的后继结点代替（其右子树的最小结点）
        > 最早由 T. Hibbard 在1962年解决了这个难题
    3. 随机插入删除 ![insert-delete-key-random.gif](insert-delete-key-random.gif)
4. 实际上在结点的选择上是随机的，但是在经历足够长的时间插入删除后最终会变为N的时间复杂度

#### 例子

- 随机序列 `15,41,69,60,4,61,5,57,90,94,56,85,33,47,76,14,64`
    1. 创建/插入
        - ![put](random-put-btree.gif)
    2. 查找 `10,33,56,55`
        - ![search](search-from-random.gif)
    3. 得到最大最小值
        - ![bst-get-max.gif](bst-get-max.gif)
        - ![bst-get-min.gif](bst-get-min.gif)
    4. 删除最小
        - ![deletemin](bst-delete-min.gif)
    5. 删除 41
        - ![delete](bst-delete.gif)
    6. 从随机序列中删除 `5,14,90,69,41`
        - ![delete](delete-from-random.gif)
- 顺序序列
    1. 创建/插入 顺序序列 `1,2,3,4,5,6,7,8,9,10`
        - ![put](sequential-put-btree.gif)
    2. 从顺序序列中删除 `10, 5, 1`
        - ![delete](sequential-delete-btree.gif)
    3. 查找 相当于线性查找 `5, 11`
        - ![search](sequential-search-btree.gif)
    4. 相当于链表

#### 实现

```java
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // 根节点

    private class Node {
        private Key key;           // key排序
        private Value val;         // 数据
        private Node left, right;  // 左右子树
        private int size;          // 孩子的个数

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    // 和二分查找类似
    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calledput() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

    // 插入
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1); // 空节点直接新建
        int cmp = key.compareTo(x.key); // 大的往右，小的往左
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right); // 更新size
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    // 深入根节点的左子节点直到遇到空连接，然后将指向该节点的链接指向该节点的右子树
    // 返回删除后的头结点
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left); 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key); // 从左右子树中找到结点
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { // 删除结点x后，用其右子树的最小结点代替
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    // 比key小的数量
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); // key在右子树中：左子树的size + 1（跟结点）+ key在以右孩子为跟的树中的rank
        else              return size(x.left); 
    } 

    public int height() {
        return height(root);
    }
    private int height(Node x) { // 树的高度
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}
```

#### 二叉查找树的性能

|数据结构|查找(最坏)|插入(最坏)|查找(平均)|插入(平均)|
| :--- | :--: | :--: | :--: | :--: |
|顺序查找 无序链表| N | N | N/2 | N |
|二分查找 有序数组| lgN | 2N | lgN | N |
|二叉查找树| N | N | 1.39lgN | 1.39lgN |


## 平衡查找树 (Balanced search trees)

### 2-3 查找树

2–3树由约翰·霍普克洛夫特于1970年发明

下面是一个典型的2-3 树，维持了完美的平衡，每个到根节点的路径长度一致。
![2-3tree](2-3-tree-sample.png)
可以看到2结点和普通二叉搜索树一样。3结点的最左全部小于该节点，中间的在两结点之间，右边的全部大于该节点。

查找十分简单，与二叉搜索树类似。

2-3的操作，将临时的4节点分裂成2-3节点
![Splitting a temporary 4-node in a 2-3 tree (summary)](Splitting-temporary-4-node-in-a-2-3-tree.png)

分裂4结点到3结点时其他的子节点并没有受到影响，只作用于其结点及父节点。
![2-3-tree-Splitting-4-node.png](2-3-tree-Splitting-4-node.png)

使用随机值构造的2-3数
![Typical-23-tree-random-keys.png](Typical-23-tree-random-keys.png)

插入数据 `[3, 1, 5, 4, 2, 9, 10, 8, 7, 6]`
![2-3-tree-insertion-random.gif](2-3-tree-insertion-random.gif)

尽管可以用不同数据结构表示2结点或3结点，但是太复杂了，要维护好几种不同的结点但是2-3，其间的各种转换可能更耗时，但红黑树可以，红黑基于2-3树。

### 红黑树 Red-Black Trees --> 左倾红黑树

#### 简介

它在1972年由鲁道夫·贝尔发明，被称为"对称二叉B树"，它现代的名字源于 Leo J. Guibas 和 Robert Sedgewick 于1978年写的一篇论文。Robert Sedgewick在2008年的论文[Left-leaning Red-Black Trees](http://www.cs.princeton.edu/~rs/talks/LLRB/LLRB.pdf)中将设计出左倾红黑树，它红黑树的变体，并保证对操作相同渐近的复杂性，但被设计成更容易实现。
![Robert Sedgewick](Robert-Sedgewick.png)

红黑树中将树的链接分为两种类型：
1. 红链接将两个结点连接起来构成 3结点
2. 黑链接则是2-3树中的普通链接

使用这种方法的好处是不用修改就可以用标准二叉查找树的`get()`方法，对任意 2-3树 只要对结点进行转换，就能得到一个红黑树。

定义：
1. 红链接均为左链接
2. 没有任何一个结点同时和两个红链相连
3. 该树是**完美的黑色平衡**的，任意叶子节点到根节点的黒链接的数量相同

#### 将2-3树表示为红黑树
![2-3-tree-to-red-black-tree.png](2-3-tree-to-red-black-tree.png)

红黑树将红色的水平就是23数
![red-black-tree-horizontal-red-links-is-2-3-tree.png](red-black-tree-horizontal-red-links-is-2-3-tree.png)

#### 颜色表示

![red-black-tree-red-black.png](red-black-tree-red-black.png)

```java
private static final boolean RED = true; // 定义全局变量
private static final boolean BLACK = false;

private class Node {
    Key key;
    Value val;
    Node left, right; // 子树
    int N; // 子树的数量
    boolean color; // color of link from
    // parent to this node
    Node(Key key, Value val, int N, boolean color) {
        this.key = key;
        this.val = val;
        this.N = N;
        this.color = color;
    }
}
private boolean isRed(Node x) {
    if (x == null) return false;
    return x.color == RED;
}
```

#### 旋转

将红色的右链接转换为左链接叫左旋。
![rotate-left-anim.gif](rotate-left-anim.gif)
将红色的左链接转换为右链接叫右旋。
![rotate-right-anim.gif](rotate-right-anim.gif)

红黑树的三种操作及代码
![red-black-tree-3-operations.png](red-black-tree-3-operations.png)

#### 插入



红黑树三种操作间的转换
![3-operations-turn.png](3-operations-turn.png)

插入255个随机数
![Insert 255 keys in a red-black BST in random order](Insert-red-blackBST-random-order.gif)

插入255个升序的数
![Insert 255 keys in a red-black BST in ascending order](Insert-red-blackBST-ascending-order.gif)

插入255个降序的数
![Insert 255 keys in a red-black BST in descending order](Insert-red-blackBST-descending-order.gif)

### 删除

删除策略（适用于2-3和2-3-4树）
- 不变：当前节点不是2节点
- 必要时引入4节点
- 从最底部删除key（叶子节点）
- 在向上走的途中消除4节点

##### 删除最大

删除最大
![delete](deleteMax23.gif)

##### 删除最小

删除最小
![delete](deleteMin23.gif)

##### 随机删除
随机删除
![delete](deleteRandom23.gif)

#### 代码

```java
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;     // 跟结点

    private class Node {
        private Key key; 
        private Value val;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    } 

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    // 查找 和二叉查找树一致
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

   /***************************************************************************
    *  Red-black tree insertion.
    ***************************************************************************/

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        root = put(root, key, val);
        root.color = BLACK;
        // assert check();
    }

    // insert the key-value pair in the subtree rooted at h
    private Node put(Node h, Key key, Value val) { 
        if (h == null) return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val); 
        else if (cmp > 0) h.right = put(h.right, key, val); 
        else              h.val   = val;

        // fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

   /***************************************************************************
    *  Red-black tree deletion.
    ***************************************************************************/

    /**
     * Removes the smallest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) { 
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }


    /**
     * Removes the largest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) { 
        if (isRed(h.left))
            h = rotateRight(h);

        if (h.right == null)
            return null;

        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);

        h.right = deleteMax(h.right);

        return balance(h);
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) { 
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) { 
        // assert get(h, key) != null;

        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }

    // 右旋 将红色的左链接转换为右链接叫右旋
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    //左旋 将红色的右链接转换为左链接叫左旋
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    //h的两个自连接颜色相同且到h的颜色与子链接颜色不同
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    // 
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.right.left)) { 
            h.right = rotateRight(h.right); 
            h = rotateLeft(h); // 
            flipColors(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left)) { 
            h = rotateRight(h); // 右旋
            flipColors(h); // 变色
        }
        return h;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }


    public int height() { // 树的高度 和二分查找一致
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        // assert x != null;
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) { 
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }

    // 和二分查找一致 比key小的数量
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    // 和二分查找一致 比key小的数量
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); // key在右子树中：左子树的size + 1（跟结点）+ key在以右孩子为跟的树中的rank
        else              return size(x.left); 
    }
}
```

### 总结

|数据结构|查找(最坏)|插入(最坏)|查找(平均)|插入(平均)|
| :--- | :--: | :--: | :--: | :--: |
|顺序查找 无序链表| N | N | N/2 | N |
|二分查找 有序数组| lgN | 2N | lgN | N |
|二叉查找树| N | N | 1.39lgN | 1.39lgN |
|2-3树 红黑树| 2lgN | 2lgN | 1.00lgN | 1.00lgN |

### B树，B-树，B+树，B*树

1. B树(Binary search tree) 
    - 二叉搜索树
2. B-树
    - 是一种多路搜索树，并不是二叉的
    - 数据库索引技术里大量使用B-树和B+树的数据结构
3. B+树
    - B+树是B-树的一个升级版，相对于B-树来说B+树更充分的利用了节点的空间，让查询速度更加稳定，其速度完全接近于二分法查找
    - B+跟B-树不同B+树的非叶子节点不保存关键字记录的指针，只进行数据索引，这样使得B+树每个非叶子节点所能保存的关键字大大增加
    - B+树叶子节点保存了父节点的所有关键字记录的指针，所有数据地址必须要到叶子节点才能获取到。所以每次数据查询的次数都一样
    - B+树叶子节点的关键字从小到大有序排列，左边结尾数据都会保存右边节点开始数据的指针
4. B*树
    - B*树是B+树的变种，在B+树的非根和非叶子结点再增加指向兄弟的指针


- B树
    - 二叉树，每个结点只存储一个关键字，等于则命中，小于走左结点，大于走右结点；
- B-树
    - 多路搜索树，每个结点存储M/2到M个关键字，非叶子结点存储指向关键字范围的子结点；所有关键字在整颗树中出现，且只出现一次，非叶子结点可以命中
- B+树
    - 在B-树基础上，为叶子结点增加链表指针，所有关键字都在叶子结点中出现，非叶子结点作为叶子结点的索引；B+树总是到叶子结点才命中
- B*树
    - 在B+树基础上，为非叶子结点也增加链表指针，将结点的最低利用率从1/2提高到2/3；


## 散列表


## ~~平衡查找树 AVL Trees (Balanced binary search trees)~~

- 随机序列 `15,41,69,60,4,61,5,57,90,94,56,85,33,47,76,14,64`
    1. 创建/插入
        - ![put](AVL_random-put.gif)
    2. 从随机序列中删除 `5,14,90,69,41`
        - ![delete](AVL_delete-from-random.gif)
    3. 查找 `10,33,56,55`
        - ![search](AVL_search-from-random.gif)
- 顺序序列
    1. 创建/插入 顺序序列 `1,2,3,4,5,6,7,8,9,10`
        - ![put](AVL_sequential-put.gif)
    2. 从顺序序列中删除 `10, 5, 1`
        - ![delete](AVL_sequential-delete.gif)
    3. 查找 相当于线性查找 `5, 11`
        - ![search](AVL_sequential-search.gif)