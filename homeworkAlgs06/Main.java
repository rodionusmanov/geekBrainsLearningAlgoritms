package homeworkAlgs06;

import java.util.Random;

public class Main {
    private static final int NUMBER_OF_TREES = 10000;
    protected static int level = 0;
    public static void main(String[] args) {
        Random random = new Random();
        double unbalancedTrees = 0;
        for (int j = 0; j < NUMBER_OF_TREES; j++) {
            Tree<Integer> tree = new BalanceTree<>();
            for (int i = 0; i < 15; i++) {
                level = 1;
                tree.add(random.nextInt(51) - 25);
                if (level == 5){
                    break;
                };
//                System.out.println("Уровень " + level);
            }

            tree.display();
            if (BalanceTree.isBalancedTree((BalanceTree) tree)) {
                System.out.println("Дерево сбалансировано\n");
            } else {
                System.out.println("Дерево несбалансировано\n");
                unbalancedTrees = unbalancedTrees + 1.0;
            }
        }
        System.out.format("%.1f процентов несбалансированных деревьев ", unbalancedTrees / NUMBER_OF_TREES * 100);
    }
}
