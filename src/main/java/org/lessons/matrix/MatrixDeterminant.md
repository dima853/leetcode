**Determinant of the matrix (determinant)** is a special numeric value that is calculated for **square matrices** (matrices where the number of rows is equal to the number of columns). It is important in linear algebra and is used:

1. **To check the reversibility of the matrix**:
- If the determinant is 0 0 → the matrix **is invertible** (there is an inverse matrix).
    - If determinant = 0 → matrix **is degenerate** (has no inverse).

2. **In solving systems of linear equations** (Kramer's method).

3. **To calculate the area/volume** in geometry (determinant of the transformation matrix).

---

### How is the determinant calculated?
#### For a 2x2 matrix:
$$
\text{If } A = \begin{pmatrix} a & b \\ c & d \end{pmatrix}, \text{then } \det(A) = ad - bc
$$

**Example**:
```java
int[][] matrix = {{4, 7}, {2, 6}};
int det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]; // 4*6 - 7*2 = 10
```

#### For a 3×3 matrix (Sarrus rule):
$$\text{If } A = \begin{pmatrix} a & b & c \\ d & e & f \\ g & h & i \end{pmatrix}, \text{then}$$

$$
\det(A) = aei + bfg + cdh - ceg - bdi - afh
$$

**Example**:
```java
int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
int det = matrix[0][0]*matrix[1][1]*matrix[2][2] 
        + matrix[0][1]*matrix[1][2]*matrix[2][0] 
        + matrix[0][2]*matrix[1][0]*matrix[2][1] 
        - matrix[0][2]*matrix[1][1]*matrix[2][0] 
        - matrix[0][1]*matrix[1][0]*matrix[2][2] 
        - matrix[0][0]*matrix[1][2]*matrix[2][1]; // 0 ( the matrix is degenerate)
```

---

### Determinant Properties:
1. **Determinant of the identity matrix ** = 1.
2. **Rearranging rows/columns** changes the sign of the determinant.
3. **Multiplying a string by a number** → the determinant is multiplied by this number.
4. **If two strings are the same** → determinant = 0.

---

### Code example for calculating the determinant (3×3):
```java
public class Determinant3x3 {
public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int det = calculateDeterminant(matrix);
        System.out.println("Matrix determinant: " + det); // Outputs 0
    }
    
    public static int calculateDeterminant(int[][] m) {
        return m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }
}
```

**Explanation**:
- The `calculateDeterminant` method uses the decomposition formula for the first line.
- For a 3×3 matrix, this is:
  $$
  \det(A) = a \cdot (ei - fh) - b \cdot (di - fg) + c \cdot (dh - eg)
  $$

---

### Important:
- For matrices of size > 3×3, **recursive methods** (row/column decomposition) or **Gauss algorithm** are used.
- The determinant exists **only for square matrices**!