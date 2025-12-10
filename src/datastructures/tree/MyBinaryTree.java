package datastructures.tree;

/**
 *  이진 트리라면 무조건 지원해야 하는 4가지 순회(Traversal)를 약속합니다.
 */
public interface MyBinaryTree<E> extends MyTree<E> {
    // DFS (깊이 우선 탐색)
    void preOrder();  // 전위 순회 (Root -> L -> R)
    void inOrder();   // 중위 순회 (L -> Root -> R)
    void postOrder(); // 후위 순회 (L -> R -> Root)

    // BFS (너비 우선 탐색)
    void levelOrder(); // 레벨 순회 (층별로 이동)
}