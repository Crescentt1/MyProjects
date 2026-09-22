import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GUI gui;

    public KeyHandler(GUI gui){
        this.gui = gui;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_Z)){

                gui.funcEdit.undo();
            }

        if((e.isControlDown()) && (e.getKeyCode() == KeyEvent.VK_Y)){

            gui.funcEdit.redo();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
