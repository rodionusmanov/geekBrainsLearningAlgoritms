package homeworkAlgs07;

public class Main {
    public static final int MAX_VERTEX_COUNT = 10;
    public static void main(String[] args) {
        Graph graph = new GraphImpl(MAX_VERTEX_COUNT);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Калуга");
        graph.addVertex("Рязань");
        graph.addVertex("Липецк");
        graph.addVertex("Орёл");
        graph.addVertex("Тамбов");
        graph.addVertex("Курск");
        graph.addVertex("Саратов");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 175);
        graph.addEdge("Москва", "Калуга", 164);
        graph.addEdge("Москва", "Рязань", 184);
        graph.addEdge("Тула", "Липецк", 219);
        graph.addEdge("Калуга", "Орёл", 173);
        graph.addEdge("Рязань", "Тамбов", 240);
        graph.addEdge("Липецк", "Воронеж", 108);
        graph.addEdge("Орёл", "Курск", 138);
        graph.addEdge("Тамбов", "Саратов", 340);
        graph.addEdge("Курск", "Воронеж", 208);
        graph.addEdge("Саратов", "Воронеж", 472);

        graph.display();

        System.out.println();

        System.out.println("Обход в ширину графа из методички:");
        graph.breadthFirstSearch("Москва");

        System.out.println();

        System.out.println("Обход в глубину графа из методички:");
        graph.depthFirstSearch("Москва");

        System.out.println();
        graph.findShortestPath("Москва", "Воронеж");

        graph.addEdge("Тула", "Орёл", 171);
        graph.addEdge("Тула", "Рязань", 145);
        graph.addEdge("Тула", "Калуга", 96);
        graph.addEdge("Калуга","Москва",  164);
        graph.addEdge("Калуга", "Тула", 96);
        graph.addEdge("Рязань", "Липецк", 225);
        graph.addEdge("Рязань","Тула",  145);
        graph.addEdge("Липецк", "Орёл", 242);
        graph.addEdge("Орёл", "Калуга", 173);
        graph.addEdge("Тамбов", "Орёл", 365);
        graph.addEdge("Курск","Орёл",  138);
        graph.addEdge("Воронеж","Саратов",  472);
        graph.addEdge("Воронеж","Тамбов",  194);
        graph.addEdge("Воронеж","Орёл",  259);

        System.out.println();
        graph.display();

        System.out.println();
        graph.findShortestPath("Воронеж", "Липецк");
    }
}
