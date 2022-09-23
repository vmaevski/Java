// 1. Описать класс для работы с бинарным деревом  
// 1.1 Реализовать три варианта обхода - ru.wikipedia.org/wiki/Обход_дерева#Прямой_обход_(NLR)
// 1.2 Сделать скобочную запись бинарного дерева

public class HW_S06_Binary_Tree {
    public static void main(String[] args) {
    // Создаём узлы  и присваиваем им значения:        
        Node root = new Node("F");
        Node l1 = new Node("B");
        Node r1 = new Node("G");
        Node l2l1 = new Node("A");
        Node r2l1 = new Node("D");
        Node r2r1 = new Node("I");
        Node l3r2l1 = new Node("C");
        Node r3r2l1 = new Node("E");
        Node l3r2r1 = new Node("H");
    // Делаем привязки узлов (строим дерево):
        root.left = l1;
        root.right = r1;
        l1.left = l2l1;
        l1.right = r2l1;
        r1.right = r2r1;
        r2l1.left = l3r2l1;
        r2l1.right = r3r2l1;
        r2r1.left = l3r2r1;

        System.out.println();
        System.out.println("Скобочная запись:");
        Tree_Passage.Bracket_Notation(root);
        System.out.println();

        System.out.println();
        System.out.println("Прямой обход (NLR):");
        Tree_Passage.Direct_Passage(root);  
        System.out.println();  
        
        System.out.println();
        System.out.println("Центрированный обход (LNR):");
        Tree_Passage.Centered_Passage(root);  
        System.out.println();  

        System.out.println();
        System.out.println("Обратный обход (LRN):");
        Tree_Passage.Reverse_Passage(root);  
        System.out.println(); 
        

    }
}

/**
 * InnerHW_S06_Binary_Tree
 */
class Node {
    public Node(String v){
        value = v;
    }
    String value;
    Node left;
    Node right;    
}

class Tree_Passage {

    static void Bracket_Notation(Node n) {
        if (n != null) {
            System.out.printf("%s", n.value);       
        }
        else{
            System.out.println("NULL");
        }
        if ((n.left != null)|(n.right != null)){
            System.out.printf("(");
            
            if (n.left != null) {
                Bracket_Notation(n.left);
            } else{
                System.out.printf("NULL");
            }
            System.out.printf(",");
            if (n.right != null) {
                Bracket_Notation(n.right);
            }  else{
                System.out.printf("NULL");
            } 
            System.out.printf(")");
        }

    }

    static void Direct_Passage(Node n) {
        if (n != null) {
            System.out.printf("%s", n.value);       
        }
        if (n.left != null) {
            System.out.printf(" -> ");
            Direct_Passage(n.left);
        }
        if (n.right != null) {
            System.out.printf(" -> ");
            Direct_Passage(n.right);
        } 
    }  
    
    static void Centered_Passage(Node n) {
        if (n != null) {
            if (n.left != null) {
                Centered_Passage(n.left);
            }
            System.out.printf("%s", n.value);
            System.out.printf(" -> ");
            if (n.right != null) {
                Centered_Passage(n.right);
            } 
        }
    }  

    static void Reverse_Passage(Node n) {
        if (n != null) {
        }
        if (n.left != null) {
            Reverse_Passage(n.left);
        }
        if (n.right != null) {
            Reverse_Passage(n.right);
        } 
        System.out.printf("%s", n.value);       
        System.out.printf(" -> ");
    }  

}    