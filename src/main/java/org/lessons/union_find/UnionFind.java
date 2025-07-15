package org.lessons.union_find;

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            // Всегда присоединяем большее к меньшему, чтобы корень был наименьшим
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10); // 10 элементов (0 до 9)

        uf.union(0, 1); // Объединяем элементы 0 и 1 в одну группу
        uf.union(2, 3); // Объединяем элементы 2 и 3 в одну группу
        uf.union(1, 2); // Объединяем элементы 1 и 2 в одну группу (теперь 0, 1, 2, 3 в одной группе)

        System.out.println(uf.find(0) == uf.find(3)); // true (0 и 3 в одной группе)
        System.out.println(uf.find(4) == uf.find(5)); // false (4 и 5 в разных группах)
    }
}
