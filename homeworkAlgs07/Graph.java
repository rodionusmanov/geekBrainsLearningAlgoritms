package homeworkAlgs07;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String nextLabel, int distance);

    int getSize();

    void display();

    void depthFirstSearch(String startlabel);

    void breadthFirstSearch(String startLabel);

    void findShortestPath(String startLabel, String finishLabel);
}
