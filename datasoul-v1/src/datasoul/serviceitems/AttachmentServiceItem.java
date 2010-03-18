/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datasoul.serviceitems;

import datasoul.util.ObjectManager;
import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class AttachmentServiceItem extends GenericAttachmentServiceItem {


    public AttachmentServiceItem(){
        super();
    }

    public AttachmentServiceItem(String filename, InputStream is) throws IOException{
        super(filename, is);
    }

    @Override
    public void showItem(){
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ObjectManager.getInstance().getDatasoulMainForm(),
                    "Error launching file:"+" "+filename+"\n"+ex.getLocalizedMessage());
        }
    }
}
