<h2><a href="https://www.geeksforgeeks.org/problems/circular-prime-number0230/1">Circular Primes</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18.6667px;">Given an integer<strong> n</strong>, find all circular prime numbers<strong> </strong>less than n.&nbsp;</span><span style="font-size: 18.6667px;">A prime number is called a circular prime if all rotations of its digits are also prime numbers.</span></p>
<p><span style="font-size: 18.6667px;"><strong>Note: </strong>A rotation is obtained by moving the last digit of a number to the front. For example, the rotations of 197 are 197, 719, and 971.</span></p>
<p><strong><span style="font-size: 18px;">Examples:</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">n = 4
<strong>Output: </strong>[2, 3]
<strong>Explanation: </strong>2 and 3 are the circular prime number less than 4.</span>
</pre>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">n = 197
</span><span style="font-size: 18px;"><strong>Output: </strong>[2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131]<br><strong>Explanation: </strong>All the numbers in the output are circular primes less than 197. For example:
13 -&gt; rotations: 13, 31 (both prime)
113 -&gt; rotations: 113, 311, 131 (all prime)
197 is not included because the problem asks for circular primes less than 197.</span></pre>
<p><span style="font-size: 18px;"><strong style="font-size: 18px;">Constraints:</strong><br><span style="font-size: 18px;">2<strong> </strong>≤&nbsp;n </span><span style="font-size: 18px;">≤</span><span style="font-size: 18px;"> 10<sup>5</sup></span></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Mathematics</code>&nbsp;<code>Prime Number</code>&nbsp;