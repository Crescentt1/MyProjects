import java.awt.*;

public class Function_Color {

    GUI gui;

    public Function_Color(GUI gui){

        this.gui = gui;

    }

    public void changeColor(String color){

        switch (color){

            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                break;

            case "Blue":

                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.white);
                break;

            case "Red":
                gui.window.getContentPane().setBackground(Color.red);
                gui.textArea.setBackground(Color.red);
                gui.textArea.setForeground(Color.yellow);
                break;

            case "Gold":
                gui.window.getContentPane().setBackground(new Color(255,200,11));
                gui.textArea.setBackground(new Color(255,200,11));
                gui.textArea.setForeground(new Color(155,85,40));
                break;

        }

    }
}
