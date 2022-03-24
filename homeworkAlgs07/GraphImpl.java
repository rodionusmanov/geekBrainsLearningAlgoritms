package homeworkAlgs07;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final int adjSize;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.adjSize = maxVertexCount;
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String nextLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(nextLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }


    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    if (adjMatrix[j][i] > 0) {
                        sb.append("  <-(").append(adjMatrix[i][j]).append(")->  ").append(vertexList.get(j));
                    } else {
                        sb.append("  (").append(adjMatrix[i][j]).append(")->  ").append(vertexList.get(j));
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void depthFirstSearch(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Города не существует " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearestUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        clearPasses();
    }


    private Vertex getNearestUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setIsVisited(true);
    }

    @Override
    public void breadthFirstSearch(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Города не существует " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearestUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        clearPasses();
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setIsVisited(true);
    }

    private void clearPasses() {
        for (int i = 0; i < vertexList.size(); i++) {
            vertexList.get(i).unVisited();
        }
    }

    public void findShortestPath(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        ArrayList<Integer> currentWay = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pathsArray = new ArrayList<>();
        findWay(startIndex, finishIndex, currentWay, pathsArray);

        if (pathsArray.size() == 0) {
            System.out.printf("Путь от города %s до города %s не найден %n", startLabel, finishLabel);
        } else {
            System.out.printf("Кратчайший путь от города %s до города %s проходит по маршруту:%n", startLabel, finishLabel);
            ArrayList<Integer> bestWay = pathsArray.get(0);
            int minDistance = 0;
            for (int i = 0; i < bestWay.size() - 1; i++) {
                minDistance += adjMatrix[bestWay.get(i)][bestWay.get(i + 1)];
            }
            if (pathsArray.size() != 1) {
                int currentDistance = 0;
                for (int i = 1; i < pathsArray.size(); i++) {
                    currentWay = pathsArray.get(i);
                    currentDistance = 0;
                    for (int j = 0; j < currentWay.size() - 1; j++) {
                        currentDistance += adjMatrix[currentWay.get(j)][currentWay.get(j + 1)];
                    }
                    if (currentDistance < minDistance) {
                        minDistance = currentDistance;
                        bestWay = currentWay;
                    }
                }
            }
            printBestPath(bestWay, minDistance);
        }

    }

    private void printBestPath(ArrayList<Integer> bestWay, int minDistance) {
        for (int i = 0; i < bestWay.size(); i++) {
            if (i != 0) {
                System.out.print(" -> " + vertexList.get(bestWay.get(i)));
            } else {
                System.out.print(vertexList.get(bestWay.get(i)));
            }
        }
        System.out.println();
        System.out.println("Необходимо преодолеть дистанцию: " + minDistance);
    }

    private void findWay(int currentIndex, int finishIndex, ArrayList<Integer> currentWay, ArrayList<ArrayList<Integer>> pathsArray) {
        currentWay.add(currentIndex);
        if (currentIndex == finishIndex) {
            pathsArray.add((ArrayList<Integer>) currentWay.clone());
            currentWay.remove(currentWay.size() - 1);
        } else {
            for (int i = 0; i < adjSize; i++) {
                if (!currentWay.contains(i) && adjMatrix[currentIndex][i] > 0) {
                    findWay(i, finishIndex, currentWay, pathsArray);
                }
            }
            currentWay.remove(currentWay.size() - 1);
        }
    }
}
