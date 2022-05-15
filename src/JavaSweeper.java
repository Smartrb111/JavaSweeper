import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {
    private Game game;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    private JPanel panel;

    private JavaSweeper() {
        game = new Game(COLS, ROWS);
        game.start();
        setImages();
        initPanel();
        initFrame();
    }

    public static void main(String[] args) {
        new JavaSweeper().setVisible(true);//Для отображения окна
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCords()) {
                    g.drawImage((Image) game.getBox(coord).image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaSweeper");//имя
        setLocationRelativeTo(null);// окно по центру
        setResizable(false);//размер не изменяется
        setVisible(true);//Форму становится видно
        setIconImage(getImage("icon"));//устанвока иконки
        pack();
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name());//СОздание функции для перебора картинок
        }
    }

    private Image getImage(String name) {
        String filename = name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }
}
