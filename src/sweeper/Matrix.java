package sweeper;

class Matrix {
    private Box[][] matrix;

    Matrix(Box defaultBox) {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCords())
            matrix[coord.x][coord.y] = defaultBox;
    }

    Box get(Coord coord) {
        if (Ranges.inRange (coord))
        return matrix[coord.x][coord.y];// Нудные в матрцие координаты
        return null;
    }

    void set(Coord coord, Box box) {
        if (Ranges.inRange (coord))
        matrix[coord.x][coord.y] = box;//передаем значение в геттер
    }
}