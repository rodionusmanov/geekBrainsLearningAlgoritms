package homeworkAlgs07;

import java.util.Objects;

public class Vertex {
    private String label;
    private boolean isVisited;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void unVisited() {
        this.isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

}
