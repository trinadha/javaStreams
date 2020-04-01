import javaStreams.Node;

public class Learning {
	
	public static void main(String[] args) {

        Node rootNode = null;
        rootNode = addNode(rootNode, 10, true);
        rootNode = addNode(rootNode, 5, true);
        rootNode = addNode(rootNode, 20, true);
        rootNode = addNode(rootNode, 3, true);
        rootNode = addNode(rootNode, 8, true);
        rootNode = addNode(rootNode, 7, true);

        printTreePreOrder(rootNode);
        System.out.println();

        String str = serializeBinaryTree(rootNode);
        System.out.println(str);

        Node start = deserializeBinaryTree(str);
        printTreePreOrder(start);
    }

    //Serialize Binary Tree
    private static String serializeBinaryTree(Node rootNode) {
        if (rootNode == null) {
            return "null,";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rootNode.getData());
        sb.append(",");

        sb.append(serializeBinaryTree(rootNode.getLeft()));
        sb.append(serializeBinaryTree(rootNode.getRight()));
        return sb.toString();
    }

    //Deserialize Binary Tree
    public static Node deserializeBinaryTree(String data) {
        String[] temp = data.split(",");
        //return deserialize(temp, new int[] {0});
        return deserializeUsingStaticCounter(temp);
    }


    static int index;

    private static Node deserializeUsingStaticCounter(String[] data) {
        if (index > data.length || data[index].equals("null")) {
            index++;
            return null;
        }

        Node node = new Node(Integer.parseInt(data[index++]));
        node.setLeft(deserializeUsingStaticCounter(data));
        node.setRight(deserializeUsingStaticCounter(data));

        return node;
    }

    private static Node addNode(Node rootNode, int i, boolean isRootNode) {
        if (rootNode == null) {
            return new Node(i);
        } else {
            if (i > rootNode.getData()) {
                if (isRootNode) {
                    Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
                    rootNode.setRight(nodeToAdd);
                } else {
                    Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
                    rootNode.setLeft(nodeToAdd);
                }

            } else {
                if (isRootNode) {
                    Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
                    rootNode.setLeft(nodeToAdd);
                } else {
                    Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
                    rootNode.setRight(nodeToAdd);
                }
            }
        }
        return rootNode;
    }

    private static void printTreePreOrder(Node rootNode) {
        if (rootNode == null)
            return;
        System.out.print(rootNode.getData() + " ");
        printTreePreOrder(rootNode.getLeft());
        printTreePreOrder(rootNode.getRight());
    }
}
