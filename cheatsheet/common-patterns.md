# Common Algorithm Patterns

Quick reference for the most used patterns in coding interviews.

---

## 1. Two Pointers

**Use when:** Sorted arrays, pair finding, partitioning.

```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == target) { left++; right--; }
    else if (sum < target) left++;
    else right--;
}
```

## 2. Sliding Window

**Use when:** Subarray/substring problems, contiguous sequences.

```java
// Variable-size window
int left = 0;
for (int right = 0; right < n; right++) {
    // expand: add arr[right]
    while (/* window invalid */) {
        // shrink: remove arr[left]
        left++;
    }
    // update answer
}
```

## 3. Binary Search

**Use when:** Sorted data, search space reduction.

```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## 4. BFS

**Use when:** Shortest path (unweighted), level-order traversal.

```java
Queue<Integer> queue = new LinkedList<>();
Set<Integer> visited = new HashSet<>();
queue.offer(start);
visited.add(start);

while (!queue.isEmpty()) {
    int node = queue.poll();
    for (int neighbor : graph.getOrDefault(node, List.of())) {
        if (visited.add(neighbor)) queue.offer(neighbor);
    }
}
```

## 5. DFS

**Use when:** Connectivity, cycle detection, exhaustive search.

```java
void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
    visited.add(node);
    for (int neighbor : graph.getOrDefault(node, List.of())) {
        if (!visited.contains(neighbor)) dfs(graph, neighbor, visited);
    }
}
```

## 6. Dynamic Programming

**Use when:** Overlapping subproblems, optimal substructure.

```java
// Bottom-up
int[] dp = new int[n + 1];
dp[0] = base;
for (int i = 1; i <= n; i++) {
    dp[i] = /* recurrence using dp[i-1], dp[i-2], etc. */;
}
```

**Framework:** Define state -> Find relation -> Set base cases -> Determine order -> Optimize space.

## 7. Greedy

**Use when:** Local optimal leads to global optimal.

```java
// Interval scheduling: sort by end time, pick non-overlapping
Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
int count = 1, end = intervals[0][1];
for (int i = 1; i < intervals.length; i++) {
    if (intervals[i][0] >= end) { count++; end = intervals[i][1]; }
}
```

## 8. Monotonic Stack

**Use when:** Next greater/smaller element, histogram problems.

```java
Stack<Integer> stack = new Stack<>();
for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        result[stack.pop()] = arr[i];
    }
    stack.push(i);
}
```

## 9. Union-Find

**Use when:** Connected components, cycle detection in undirected graphs.

```java
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]); // path compression
    return parent[x];
}
boolean union(int x, int y) {
    int rx = find(x), ry = find(y);
    if (rx == ry) return false;
    if (rank[rx] < rank[ry]) parent[rx] = ry;
    else if (rank[rx] > rank[ry]) parent[ry] = rx;
    else { parent[ry] = rx; rank[rx]++; }
    return true;
}
```

## 10. Prefix Sum

**Use when:** Range sum queries, subarray sums.

```java
long[] prefix = new long[n + 1];
for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + arr[i];
// sum of [l, r] = prefix[r+1] - prefix[l]
```

---

## Pattern Selection Guide

```
Sorted array, find pair         -> Two Pointers
Contiguous subarray/substring   -> Sliding Window
Sorted / search space           -> Binary Search
Shortest path (unweighted)      -> BFS
Connectivity / traversal        -> DFS
Counting / optimization         -> Dynamic Programming
Local -> global optimal         -> Greedy
Next greater/smaller            -> Monotonic Stack
Group / connect elements        -> Union-Find
Range sums / updates            -> Prefix Sum
Top K / streaming               -> Heap (Priority Queue)
Matching brackets / nesting     -> Stack
```
