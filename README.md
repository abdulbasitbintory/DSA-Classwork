# DSA-Classwork (Java)

Coursework repository for practicing **Data Structures & Algorithms** in Java. Each topic is implemented as a separate class/file inside `src/`.

## Topics Included

### Stack
A stack is a **LIFO (Last-In, First-Out)** data structure where the most recently added element is removed first. Typical operations are `push`, `pop`, and `peek`, and stacks are commonly used for function call tracking, undo functionality, expression evaluation, and backtracking problems.

### Queue
A queue is a **FIFO (First-In, First-Out)** data structure where the earliest inserted element is removed first. Standard operations include `enqueue`, `dequeue`, and `front/peek`. Queues are useful for scheduling tasks, buffering data, and breadth-first search (BFS) traversals in graphs/trees.

### Linked List
A linked list stores elements in **nodes connected by pointers/references**, allowing efficient insertions and deletions compared to arrays (especially at the beginning or middle). Each node typically holds data and a reference to the next node. It’s a common building block for other structures like stacks, queues, and hash table chaining.

### Doubly Linked List
A doubly linked list is a linked list where each node has references to both the **next** and **previous** nodes. This enables traversal in both directions and makes certain operations (like deleting a known node) easier, at the cost of extra memory and additional pointer updates during insertions/deletions.

### Hash Map
A hash map stores key-value pairs and provides **average O(1)** time for insert, lookup, and delete by using a hash function to map keys into indices/buckets. Collisions are typically handled using techniques like chaining or open addressing. Hash maps are widely used for counting, indexing, caching, and fast membership checks.

### Binary Search Tree
A Binary Search Tree (BST) is a binary tree where for each node, values in the **left subtree are smaller** and values in the **right subtree are larger** (based on a chosen ordering). This property enables efficient searching, insertion, and deletion (average O(log n) when balanced), and supports ordered traversals like in-order traversal to produce sorted output.

### Binary Search Tree (Recursion)
BST operations can also be implemented recursively by leveraging the tree’s structure: each step chooses the left or right subtree based on comparison. Recursive implementations are often shorter and easier to reason about for traversal, insertion, and search, though deep or unbalanced trees can increase recursion depth and risk stack overflow.

### Searching
Searching algorithms locate a target value within a collection. Basic searching may include linear search (scan each element) and more efficient methods like binary search when data is sorted. Understanding time complexity and preconditions (like sorted order) is key to choosing the right approach.

### Searching (Recursion)
Recursive searching expresses the problem in smaller subproblems, such as searching a subrange of an array or descending into subtrees. Recursive binary search is a common example, where each call halves the search space. This approach is clean conceptually, but involves call-stack overhead compared to iterative versions.

### Sorting
Sorting rearranges elements into a defined order (e.g., ascending). Different sorting algorithms trade off speed, memory usage, and stability. Learning sorting builds intuition about complexity (O(n²) vs O(n log n)), partitioning, recursion, and how algorithm choice affects performance on different input patterns.

## Project Structure

```txt
DSA-Classwork/
├─ src/
│  ├─ BinarySearchTree.java
│  ├─ BinarySearchTreeRecursion.java
│  ├─ DoublyLinkedList.java
│  ├─ HashMap.java
│  ├─ LinkedList.java
│  ├─ Queue.java
│  ├─ Searching.java
│  ├─ SearchingRecursion.java
│  ├─ Sorting.java
│  └─ Stack.java
└─ out/ (build output)
