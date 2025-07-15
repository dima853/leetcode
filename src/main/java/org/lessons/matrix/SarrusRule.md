### **Sarrus Rule: Detailed explanation**

**The Sarrus rule** is a method of calculating the determinant **only for 3×3** matrices. It is easy to remember and convenient for manual calculations.

---

## **The formula of the Sarrus rule**
For the matrix
$$
A = \begin{pmatrix}
a & b & c \\
d & e & f \\
g & h & i
\end{pmatrix}
$$  
its determinant is calculated as follows:

$$
\det(A) = aei + bfg + cdh - ceg - bdi - afh
$$

### **How to remember?**
1. **The first three terms (`+`)** — products of elements on the main diagonals (with the repetition of the first two columns).
2. **The following three terms (`−`)** — products of elements on side diagonals.

---

## **Graphical representation**
We add the first two columns to the right of the matrix:

$$
\begin{array}{|ccc|cc}
\hline
a & b & c & a & b \\
d & e & f & d & e \\
g & h & i & g & h \\
\hline
\end{array}
$$

### **1. Terms with a `+` sign (main diagonals)**
1. **`aei`** — diagonal ↘ (a → e → i)
2. **`bfg`** — shifted ↘ (b → f → g)
3. **`cdh`** — shifted ↘ (c → d → h)

### **2. Terms with the `−` sign (side diagonals)**
4. **`−ceg`** — diagonal ↙ (c → e → g)
5. **`−bdi`** — shifted ↙ (b → d → i)
6. **`−afh`** — shifted ↙ (a → f → h)

---

## **Calculation example**
Let's say the matrix is:
$$
B = \begin{pmatrix}
1 & 2 & 3 \\
4 & 5 & 6 \\
7 & 8 & 9
\end{pmatrix}
$$

We apply the Sarrus rule:

1. **Add the first two columns**:
   $$
   \begin{array}{|ccc|cc}
   \hline
   1 & 2 & 3 & 1 & 2 \\
   4 & 5 & 6 & 4 & 5 \\
   7 & 8 & 9 & 7 & 8 \\
   \hline
   \end{array}
   $$

2. **Calculating the terms**:
- **`+ (1·5·9)`** = 45
    - **`+ (2·6·7)`** = 84
    - **`+ (3·4·8)`** = 96
    - **`− (3·5·7)`** = −105
    - **`− (2·4·9)`** = −72
    - **`− (1·6·8)`** = −48

3. **To summarize**:
   $$
   \det(B) = 45 + 84 + 96 - 105 - 72 - 48 = 0
   $$

**Conclusion**: The determinant is **0** This means that the matrix is **degenerate** (has no inverse).

---

## **When does the Sarrus rule apply?**
- **Only for 3×3** matrices (for large sizes, row/column decomposition or the Gauss method is used).
- Convenient for **fast manual calculations**.

---

## **Java code for calculating the Sarrus rule**
```java
public class SarrusRule {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int det = calculateDeterminant(matrix);
        System.out.println("Determinant: " + det); // Outputs 0
    }
    
    public static int calculateDeterminant(int[][] m) {
// Sarrus Rule:
        return m[0][0]*m[1][1]*m[2][2]  // aei
             + m[0][1]*m[1][2]*m[2][0]  // bfg
             + m[0][2]*m[1][0]*m[2][1]  // cdh
             - m[0][2]*m[1][1]*m[2][0]   // -ceg
             - m[0][1]*m[1][0]*m[2][2]   // -bdi
             - m[0][0]*m[1][2]*m[2][1];  // -afh
    }
}
```

**Output:**  
The Sarrus rule is a fast way to calculate the determinant **3×3**, but other methods are needed for large matrices.