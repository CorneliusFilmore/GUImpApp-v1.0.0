package app.mp;

import javax.swing.*;
import java.util.Vector;

/**
 * Class that contains the model of the list and method connected to them
 */

public class ListModel extends AbstractListModel {

    private static final long serialVersionUID = 1L;
    Vector<Object> v = new Vector<Object>();

    public void SimpleListModel() { }
    public void SimpleListModel(Object[] objects) {
        for(int i = 0; i < objects.length; i++) {
            v.addElement(objects[i]);
        }
    }

    public Object getElementAt(int index) { return v.elementAt(index); }
    public int getSize() { return v.size(); }
    public void add(int index, Object object) {
        v.insertElementAt(object, index);
        fireIntervalAdded(this,index,index);
    }
    public void add(Object object) {
        add(getSize(),object);
    }
    public void remove(int index) {
        v.removeElementAt(index);
        fireIntervalRemoved(this, index, index);
    }
}
