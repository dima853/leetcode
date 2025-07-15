### **The transposed matrix: what is it?**

**The transposed matrix**\(A^T\) is a matrix obtained from the original \(A\) by replacing rows with columns. Formally:
$$
\text{If } A = \begin{pmatrix}
a_{11} & a_{12} & \cdots &a_{1n} \\
a_{21} & a_{22} & \cdots & a_{2n} \\
\vdots & \vdots & \ddots & \vdots \\
a_{m1} & a_{m2} & \cdots & a_{mn}
\end{pmatrix}, \text{then } A^T = \begin{pmatrix}
a_{11} & a_{21} & \cdots &a_{m1} \\
a_{12} & a_{22} & \cdots & a_{m2} \\
\vdots & \vdots & \ddots & \vdots \\
a_{1n} & a_{2n} & \cdots & a_{mn}
\end{pmatrix}.
$$

**Example**:
For the matrix
$$
A = \begin{pmatrix}
1 & 2 & 3 \\
4 & 5 & 6
\end{pmatrix},
$$
transposed version:
$$
A^T = \begin{pmatrix}
1 & 4 \\
2 & 5 \\
3 & 6
\end{pmatrix}.
$$

---

### **How can I check the symmetry?**
A matrix ** is symmetric** if \(A=A^T\). For example:
$$
B = \begin{pmatrix}
1 & 2 & 3 \\
2 & 5 & 6 \\
3 & 6 & 9
\end{pmatrix}, \quad B^T = \begin{pmatrix}
1 & 2 & 3 \\
2 & 5 & 6 \\
3 & 6 & 9
\end{pmatrix}.
$$
Here \(B=B^T\), so the matrix is symmetric.

---

### **The code for transposing in Java**
```java
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] transposed = transpose(matrix);
        System.out.println("Transposed matrix:");
        printMatrix(transposed);
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows]; // Swapping sizes

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j]; // Replacing rows with columns
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
```
**Output**:
```
The transposed matrix is:
1 4
2 5
3 6
```

---

### **Why is this important?**
1. **Symmetric matrices** are found in physics (stress tensors), machine learning (covariance matrices).
2. **Transposition** is used in:
- Solving systems of linear equations.
   - Fast Fourier Transform (FFT) algorithms.

---

### **Symmetry check (with formulas)**
A matrix \(A\) of size \(n\times n\) is symmetric if:
$$
\forall i,j \in \{1, \dots, n\}: \quad A_{i,j} = A_{j,i}.
$$
**Code**:
```java
public static boolean isSymmetric(int[][] matrix) {
if (matrix.length != matrix[0].length) return false; // Not square
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < i; j++) { // We check only the lower triangle
            if (matrix[i][j] != matrix[j][i]) {
                return false;
            }
        }
    }
    return true;
}
```

---

### **Result**
- **Transpose** — replacing rows by columns: \(A^T_{ij} = A_{ji}\).
- **A symmetric matrix** is equal to its transpose: \(A =A^T\).
- Formulas in `$$` and code with comments help to understand the essence of operations.