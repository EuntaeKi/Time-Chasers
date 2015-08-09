import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import javax.swing.*;

/** @see http://stackoverflow.com/questions/4148336 */
public class CellTest extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("CellTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        frame.setSize(1000, 1000);
        for (Digit d : Digit.digits) {
            frame.add(new CellTest(d));
        }
        //frame.pack();
        frame.setVisible(true);
    }

    CellTest(Digit digit) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.setBackground(new Color(0x00e0e0));

        JLabel candidates = new JLabel("123456789");
        candidates.setHorizontalAlignment(JLabel.CENTER);
        this.add(candidates, BorderLayout.NORTH);

        JDigit cellValue = new JDigit(digit);
        add(cellValue, BorderLayout.CENTER);
    }
}

class JDigit extends JButton {

    private static final int SIZE = 128;
    private static final int BASE = SIZE / 32;
    private static final Font FONT = new Font("Serif", Font.BOLD, SIZE);
    private JPopupMenu popup = new JPopupMenu();
    private Digit digit;
    private Image image;
    private int width, height;

    public JDigit(Digit digit) {
        this.digit = digit;
        this.image = getImage(digit);
        this.setPreferredSize(new Dimension(64, 64));
        this.setBackground(new Color(0xe0e000));
        this.setForeground(Color.black);
        this.setBorderPainted(false);
      //  this.setAction(new ButtonAction());
        this.addFocusListener(new FocusHandler());
        for (Digit d : Digit.values()) {
            //Action select = new SelectAction(d);
           // JMenuItem item = new JMenuItem(select);
            getInputMap().put(KeyStroke.getKeyStroke(
                KeyEvent.VK_0 + d.value(), 0), d.toString());
            getInputMap().put(KeyStroke.getKeyStroke(
                KeyEvent.VK_NUMPAD0 + d.value(), 0), d.toString());
         //   getActionMap().put(d.toString(), select);
          //  popup.add(item);
        }
    }

    public Digit getDigit() {
        return digit;
    }

    public void setDigit(Digit digit) {
        this.digit = digit;
        this.image = getImage(digit);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();
        g.setColor(this.getBackground());
        int dx1 = w * width / height / 4;
        int dx2 = w - dx1;
        g.fillRect(dx1, 0, dx2 - dx1, h);
        g.drawImage(image,
            dx1, 0, dx2, h,
            0, 0, width, height, null);
        
        
        g.drawOval(0, 0, 300, 300);
        g.fillOval(0, 0, 300, 300);
        g.o
    }

    private Image getImage(Digit digit) {
        BufferedImage bi = new BufferedImage(
            SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(this.getForeground());
        g2d.setFont(FONT);
        FontMetrics fm = g2d.getFontMetrics();
        width = fm.stringWidth(digit.toString());
        height = fm.getAscent();
        g2d.drawString(digit.toString(), 0, height - BASE);
        g2d.dispose();
        return bi;
    }

   /* private class ButtonAction extends AbstractAction {
        //@Override
        public void actionPerformed(ActionEvent e) {
            popup.show(JDigit.this, getWidth() - width, getHeight() / 2);
        }
    }

    private class SelectAction extends AbstractAction {

        private Digit digit;

        public SelectAction(Digit digit) {
            this.digit = digit;
            this.putValue(Action.NAME, digit.toString());
        }

        //@Override
        public void actionPerformed(ActionEvent e) {
            setDigit(digit);
        }
    }*/

    private class FocusHandler implements FocusListener {

        private Color background = getBackground();

        //@Override
        public void focusGained(FocusEvent e) {
            setBackground(background.brighter());
        }

        //@Override
        public void focusLost(FocusEvent e) {
            setBackground(background);
        }
    }
}

enum Digit {

    EMPTY(0, " "), ONE(1, "1"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"),
    FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9");
    public static EnumSet<Digit> digits = EnumSet.range(Digit.ONE, Digit.NINE);
    private int i;
    private String s;

    Digit(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }

    public int value() {
        return i;
    }
}