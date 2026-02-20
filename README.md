# HackerRank Preparation — Java

Structured, topic-wise HackerRank solutions in Java for interview prep.
Topics are ordered by interview importance (most critical first).

Includes company-specific exam problems for **Bolt** (ride-hailing) and **Wise** (money transfer).

**Stack:** Java 17+ | Maven | JUnit 5

## Learning Strategy

### Phase 1: Foundation (Week 1-2)
Start with the highest-priority topics. For each problem:
1. **Read the problem** — understand input/output, constraints, edge cases.
2. **Try solving it yourself** for 20-30 min (even pseudocode counts).
3. **Read the Javadoc** — study the "Key insight" and approach in the code comment.
4. **Trace through the code** — run the test, add prints, understand each line.
5. **Re-solve from scratch** — close the file, write the solution yourself.
6. **Do it again tomorrow** — spaced repetition is key.

**Order:** Arrays → HashMaps → Strings → Sorting → Searching → DP

### Phase 2: Deep Dive (Week 3-4)
- Learn the **patterns** in `cheatsheet/common-patterns.md`.
- When you see a new problem, ask: "Which pattern does this match?"
- Focus on problems you got wrong — keep a "retry list".
- Time yourself: Easy < 15 min, Medium < 25 min, Hard < 40 min.

### Phase 3: Company Prep (Week 5+)
- Do the **Bolt** and **Wise** exams under timed conditions.
- Simulate a real HackerRank test: 60-90 min, no references.
- After each attempt, read the "HOW TO SOLVE" in the Javadoc.
- Focus on patterns the company cares about (see each company README).

### Daily Routine
```
Morning (30 min):  Review 2 problems from yesterday (spaced repetition)
Afternoon (1 hr):  Solve 2-3 new problems (try first, then check solution)
Evening (20 min):  Read cheatsheet patterns, write notes on what you learned
```

---

## Project Structure
```
src/main/java/com/prep/
├── arrays/               # 1. most asked in interviews
├── hashmaps/             # 2. constant lookup, frequency counting
├── strings/              # 3. manipulation, pattern matching
├── sorting/              # 4. foundation for many problems
├── searching/            # 5. binary search, search space
├── dynamicprogramming/   # 6. optimization, counting
├── trees/                # 7. BST, traversals
├── graphs/               # 8. BFS, DFS, connectivity
├── stacksandqueues/      # 9. parsing, monotonic stack
├── greedy/               # 10. interval, scheduling
├── linkedlists/          # 11. pointer manipulation
├── recursion/            # 12. backtracking, divide & conquer
├── math/                 # 13. number theory
└── bitmanipulation/      # 14. bitwise tricks
```

## How to Run

```powershell
mvn test                                        # run all tests
mvn test "-Dtest=com.prep.arrays.**"            # run topic tests
mvn test "-Dtest=com.prep.exams.bolt.**"        # run Bolt exam tests
mvn test "-Dtest=com.prep.exams.wise.**"        # run Wise exam tests
mvn exec:java "-Dexec.mainClass=com.prep.arrays.TwoSum"  # run single solution
```
> **Note (PowerShell):** Wrap the entire `-D...` in one quoted string, e.g. `"-Dtest=..."`. Otherwise `*` gets expanded by the shell.

## Problems

### 1. Arrays
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [2D Array - DS](https://www.hackerrank.com/challenges/2d-array) | Easy | done |
| 2 | [Left Rotation](https://www.hackerrank.com/challenges/ctci-array-left-rotation) | Easy | done |
| 3 | [Sparse Arrays](https://www.hackerrank.com/challenges/sparse-arrays) | Medium | -- |
| 4 | [Array Manipulation](https://www.hackerrank.com/challenges/crush) | Hard | -- |
| 5 | [New Year Chaos](https://www.hackerrank.com/challenges/new-year-chaos) | Medium | -- |
| 6 | [Minimum Swaps 2](https://www.hackerrank.com/challenges/minimum-swaps-2) | Medium | -- |

### 2. HashMaps
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Ransom Note](https://www.hackerrank.com/challenges/ctci-ransom-note) | Easy | -- |
| 2 | [Two Strings](https://www.hackerrank.com/challenges/two-strings) | Easy | -- |
| 3 | [Sherlock and Anagrams](https://www.hackerrank.com/challenges/sherlock-and-anagrams) | Medium | -- |
| 4 | [Count Triplets](https://www.hackerrank.com/challenges/count-triplets-1) | Medium | -- |
| 5 | [Frequency Queries](https://www.hackerrank.com/challenges/frequency-queries) | Medium | -- |

### 3. Strings
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [CamelCase](https://www.hackerrank.com/challenges/camelcase) | Easy | -- |
| 2 | [Strong Password](https://www.hackerrank.com/challenges/strong-password) | Easy | -- |
| 3 | [Sherlock and Valid String](https://www.hackerrank.com/challenges/sherlock-and-valid-string) | Medium | -- |
| 4 | [Special String Again](https://www.hackerrank.com/challenges/special-palindrome-again) | Medium | -- |
| 5 | [Common Child](https://www.hackerrank.com/challenges/common-child) | Medium | -- |
| 6 | [Making Anagrams](https://www.hackerrank.com/challenges/ctci-making-anagrams) | Easy | -- |

### 4. Sorting
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Bubble Sort](https://www.hackerrank.com/challenges/ctci-bubble-sort) | Easy | -- |
| 2 | [Mark and Toys](https://www.hackerrank.com/challenges/mark-and-toys) | Easy | -- |
| 3 | [Comparator](https://www.hackerrank.com/challenges/ctci-comparator-sorting) | Medium | -- |
| 4 | [Fraudulent Activity](https://www.hackerrank.com/challenges/fraudulent-activity-notifications) | Medium | -- |
| 5 | [Counting Inversions](https://www.hackerrank.com/challenges/ctci-merge-sort) | Hard | -- |

### 5. Searching
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Ice Cream Parlor](https://www.hackerrank.com/challenges/ctci-ice-cream-parlor) | Easy | -- |
| 2 | [Pairs](https://www.hackerrank.com/challenges/pairs) | Medium | -- |
| 3 | [Triple Sum](https://www.hackerrank.com/challenges/triple-sum) | Medium | -- |
| 4 | [Minimum Time Required](https://www.hackerrank.com/challenges/minimum-time-required) | Medium | -- |
| 5 | [Maximum Subarray Sum](https://www.hackerrank.com/challenges/maximum-subarray-sum) | Hard | -- |

### 6. Dynamic Programming
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Max Array Sum](https://www.hackerrank.com/challenges/max-array-sum) | Medium | -- |
| 2 | [Abbreviation](https://www.hackerrank.com/challenges/abbr) | Medium | -- |
| 3 | [Candies](https://www.hackerrank.com/challenges/candies) | Medium | -- |
| 4 | [Decibinary Numbers](https://www.hackerrank.com/challenges/decibinary-numbers) | Hard | -- |
| 5 | [Coin Change](https://www.hackerrank.com/challenges/coin-change) | Medium | -- |

### 7. Trees
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Height of Binary Tree](https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree) | Easy | -- |
| 2 | [BST: Insertion](https://www.hackerrank.com/challenges/binary-search-tree-insertion) | Easy | -- |
| 3 | [Lowest Common Ancestor](https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor) | Easy | -- |
| 4 | [Huffman Decoding](https://www.hackerrank.com/challenges/tree-huffman-decoding) | Medium | -- |
| 5 | [Balanced Forest](https://www.hackerrank.com/challenges/balanced-forest) | Hard | -- |

### 8. Graphs
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [BFS: Shortest Reach](https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach) | Hard | -- |
| 2 | [DFS: Connected Cells](https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid) | Medium | -- |
| 3 | [Find Nearest Clone](https://www.hackerrank.com/challenges/find-the-nearest-clone) | Medium | -- |
| 4 | [Roads and Libraries](https://www.hackerrank.com/challenges/torque-and-development) | Medium | -- |

### 9. Stacks & Queues
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Balanced Brackets](https://www.hackerrank.com/challenges/balanced-brackets) | Medium | -- |
| 2 | [Queue Using Two Stacks](https://www.hackerrank.com/challenges/queue-using-two-stacks) | Medium | -- |
| 3 | [Largest Rectangle](https://www.hackerrank.com/challenges/largest-rectangle) | Medium | -- |
| 4 | [Min Max Riddle](https://www.hackerrank.com/challenges/min-max-riddle) | Medium | -- |
| 5 | [Poisonous Plants](https://www.hackerrank.com/challenges/poisonous-plants) | Hard | -- |

### 10. Greedy
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Minimum Absolute Difference](https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array) | Easy | -- |
| 2 | [Luck Balance](https://www.hackerrank.com/challenges/luck-balance) | Easy | -- |
| 3 | [Greedy Florist](https://www.hackerrank.com/challenges/greedy-florist) | Medium | -- |
| 4 | [Max Min](https://www.hackerrank.com/challenges/angry-children) | Medium | -- |
| 5 | [Reverse Shuffle Merge](https://www.hackerrank.com/challenges/reverse-shuffle-merge) | Hard | -- |

### 11. Linked Lists
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Insert a Node](https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list) | Easy | -- |
| 2 | [Reverse a Linked List](https://www.hackerrank.com/challenges/reverse-a-linked-list) | Easy | -- |
| 3 | [Detect a Cycle](https://www.hackerrank.com/challenges/ctci-linked-list-cycle) | Easy | -- |
| 4 | [Merge Two Sorted Lists](https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists) | Easy | -- |
| 5 | [Find Merge Point](https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists) | Easy | -- |
| 6 | [Doubly Linked List: Reverse](https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list) | Easy | -- |

### 12. Recursion
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Fibonacci Numbers](https://www.hackerrank.com/challenges/ctci-fibonacci-numbers) | Easy | -- |
| 2 | [Davis' Staircase](https://www.hackerrank.com/challenges/ctci-recursive-staircase) | Medium | -- |
| 3 | [Crossword Puzzle](https://www.hackerrank.com/challenges/crossword-puzzle) | Medium | -- |
| 4 | [Recursive Digit Sum](https://www.hackerrank.com/challenges/recursive-digit-sum) | Medium | -- |

### 13. Math
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Extra Long Factorials](https://www.hackerrank.com/challenges/extra-long-factorials) | Medium | -- |
| 2 | [Forming a Magic Square](https://www.hackerrank.com/challenges/magic-square-forming) | Medium | -- |
| 3 | [Best Divisor](https://www.hackerrank.com/challenges/best-divisor) | Easy | -- |
| 4 | [Restaurant](https://www.hackerrank.com/challenges/restaurant) | Easy | -- |

### 14. Bit Manipulation
| # | Problem | Difficulty | Status |
|---|---------|------------|--------|
| 1 | [Lonely Integer](https://www.hackerrank.com/challenges/lonely-integer) | Easy | -- |
| 2 | [Maximizing XOR](https://www.hackerrank.com/challenges/maximizing-xor) | Easy | -- |
| 3 | [Counter Game](https://www.hackerrank.com/challenges/counter-game) | Medium | -- |
| 4 | [Sum vs XOR](https://www.hackerrank.com/challenges/sum-vs-xor) | Easy | -- |
| 5 | [Flipping Bits](https://www.hackerrank.com/challenges/flipping-bits) | Easy | -- |
---

## Company Exams

Company-specific HackerRank-style problems in `src/main/java/com/prep/exams/`.

### Wise (Money Transfer)
| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 1 | Currency Converter | BFS / Graph | Medium |
| 2 | Transaction Validator | String / HashMap | Easy |
| 3 | Fee Calculator | Tiered Math | Medium |
| 4 | Rate Limiter | Sliding Window / Queue | Medium |
| 5 | Balance Tracker | HashMap | Easy |

### Bolt (Ride-Hailing)
| # | Problem | Pattern | Difficulty |
|---|---------|---------|------------|
| 1 | Nearest Driver | Heap / K Closest | Medium |
| 2 | Surge Pricing | Tiered Math | Easy |
| 3 | Ride Matching | Greedy / Sort | Medium |
| 4 | Trip Duration | Dijkstra | Medium |
| 5 | Fare Calculator | Math / Business Rules | Easy |
| 6 | Scooter Rebalancing | Greedy / Math | Medium |
| 7 | Scooter Battery Optimizer | Greedy / Sort | Medium |
| 8 | Scooter Parking Zones | HashMap / Heap (Top K) | Medium |
| 9 | Scooter Maintenance Scheduler | Queue Simulation / Heap | Medium |
| 10 | Scooter Fleet Analyzer | HashMap / Data Aggregation | Easy |

Run company exams:
```bash
mvn test -Dtest="com.prep.exams.wise.*"    # Wise only
mvn test -Dtest="com.prep.exams.bolt.*"    # Bolt only
```

---

## Resources

- [HackerRank Interview Preparation Kit](https://www.hackerrank.com/interview/interview-preparation-kit)
- [Big-O Cheat Sheet](https://www.bigocheatsheet.com/)
- [Visualgo](https://visualgo.net/)
- [NeetCode](https://www.youtube.com/c/NeetCode)
