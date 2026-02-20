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

---

## How to Recognize Patterns (Keyword Triggers)

When reading a problem, look for these **keywords** in the description:

### Greedy → Sort first, then pick the best option at each step
**Trigger words:** "minimize total", "maximize count", "assign", "match", "schedule"
```
Ask yourself:
1. Can I make a locally optimal choice that doesn't hurt the global answer?
2. Does sorting the input make the choice obvious?
3. Can I prove swapping any two choices won't improve things? (exchange argument)
```
**Examples from Bolt:**
- "Match riders to drivers to **minimize** total distance" → Sort both, pair 1-to-1
- "**Maximize** trips completed with limited battery" → Sort trips shortest first
- "Move scooters to **minimize** moves needed" → Just sum deficits

### Heap (Priority Queue) → "K best/worst", "nearest", "next available"
**Trigger words:** "K nearest", "K largest", "top K", "closest", "next available"
```
Ask yourself:
1. Do I need the top/bottom K elements? → Min/Max heap of size K
2. Do I need to repeatedly pick the smallest/largest? → Min/Max heap
3. Is there a queue where items have priority? → Heap
```
**Examples from Bolt:**
- "Find **K nearest** drivers" → Max-heap of size K
- "Find **top K** parking zones" → Min-heap of size K
- "Which technician is free **next**?" → Min-heap tracking free times

### HashMap → "count", "frequency", "group by", "lookup", "duplicate"
**Trigger words:** "how many", "most frequent", "group", "unique", "duplicate"
```
Ask yourself:
1. Do I need to count occurrences? → HashMap<key, count>
2. Do I need fast lookup by key? → HashMap<key, value>
3. Do I need to check for duplicates? → HashSet
```
**Examples from Bolt/Wise:**
- "Find **most popular** route" → HashMap route→count
- "Peak usage **hour**" → int[24] frequency array (fixed-size HashMap)
- "Check for **duplicate** transaction IDs" → HashSet

### Graph (BFS/Dijkstra) → "network", "connected", "path", "convert through"
**Trigger words:** "shortest path", "network", "convert", "connected", "reachable"
```
Ask yourself:
1. Are edges unweighted? → BFS
2. Are edges weighted (positive)? → Dijkstra
3. Can I model the problem as nodes + edges? → Graph
```
**Examples from Bolt/Wise:**
- "Shortest travel time in road **network**" → Dijkstra (weighted edges)
- "Convert USD to JPY **through** intermediate currencies" → BFS on graph

### Math / Business Rules → "calculate", "tiers", "brackets", "formula"
**Trigger words:** "fee", "price", "discount", "multiplier", "tier", "bracket"
```
Ask yourself:
1. Is there a formula? → Just implement it carefully.
2. Are there tiers/brackets? → if-else chain, process each bracket.
3. Is the order of operations important? → Watch for: surge → discount → minimum.
```
**Examples from Bolt/Wise:**
- "Calculate fare with base + per km + per min + surge + discount" → Careful math
- "Tiered fee: first 100 at 0.5%, next 900 at 0.4%..." → Bracket calculation
- "Surge multiplier based on ratio tiers" → Piecewise linear function

### Sliding Window / Queue → "within time window", "rate limit", "last N"
**Trigger words:** "per window", "last N seconds", "rate limit", "stream"
```
Ask yourself:
1. Am I tracking elements within a fixed-size window? → Sliding window
2. Do old items expire over time? → Queue (remove from front)
```
**Examples from Wise:**
- "Allow max N requests within **window** of T seconds" → Queue as sliding window

### Simulation → "process events in order", "what happens next"
**Trigger words:** "process", "queue of tasks", "serve", "schedule", "wait time"
```
Ask yourself:
1. Is this simulating a real-world process? → Walk through events in order
2. Is there a server processing items? → Single-server queue
3. Are there multiple servers? → Heap tracking server availability
```
**Examples from Bolt:**
- "Scooters arrive for maintenance, one technician" → Sort arrivals, simulate queue

---

## Decision Flowchart

```
Read the problem → What do they want?

  "Find K best/nearest/top"
      → HEAP (min or max of size K)

  "Minimize/maximize total" + "assign/match"
      → GREEDY (sort first, then pair)

  "Shortest path"
      → Weighted? DIJKSTRA : BFS

  "Count occurrences / frequency / group"
      → HASHMAP

  "Subarray sum / contiguous range"
      → SLIDING WINDOW or PREFIX SUM

  "Calculate fee/price with tiers"
      → MATH (if-else brackets)

  "Can I make it? How many ways?"
      → DP (check overlapping subproblems)

  "Is input sorted? Find pair?"
      → TWO POINTERS

  "Process events in time order"
      → SIMULATION (sort + walk through)

  "Within time window / rate limit"
      → QUEUE as SLIDING WINDOW
```

---

## Practice: Match the Pattern

Before looking at the solution, try to identify the pattern:

| Problem | Hint (what triggers it) | Pattern |
|---------|------------------------|---------|
| "Find 3 nearest drivers to passenger" | "K nearest" | ??? |
| "Convert USD to JPY through EUR" | "convert through" | ??? |
| "Calculate fee: first 100 at 0.5%..." | "tier/bracket" | ??? |
| "Match riders to drivers, min total distance" | "minimize + match" | ??? |
| "Find peak usage hour" | "count/frequency" | ??? |
| "Allow max 5 requests per 10 seconds" | "per window" | ??? |
| "Shortest path in road network (weighted)" | "shortest path + weighted" | ??? |
| "Maximize trips with limited battery" | "maximize + assign" | ??? |

<details>
<summary>Click to reveal answers</summary>

| Problem | Pattern |
|---------|---------|
| K nearest drivers | **Heap** (max-heap of size K) |
| Convert through currencies | **BFS/Graph** |
| Tiered fee | **Math** (bracket calculation) |
| Match riders-drivers | **Greedy + Sort** |
| Peak usage hour | **HashMap / Array counting** |
| Rate limiting | **Sliding Window / Queue** |
| Shortest path weighted | **Dijkstra** |
| Maximize trips | **Greedy + Sort** |

</details>

