package thread;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lambda Expression Example");

        // JButtonを生成し、addActionListenerメソッドにラムダ式を直接渡してframeに追加
        frame.add(new JButton("Click Me") {{ addActionListener(e -> System.out.println("Button clicked in a lambda expression")); }});

        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


