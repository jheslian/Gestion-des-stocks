package window;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Frame(){
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 700,500 );
        this.setLocationRelativeTo( null );
        JPanel container =  (JPanel)this.getContentPane();
        container.setLayout( new BorderLayout() );
        this.setVisible( true );

    }
}
