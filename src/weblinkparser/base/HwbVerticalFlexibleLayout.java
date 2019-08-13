package weblinkparser.base;

import weblinkparser.Debug;

import javax.swing.*;
import java.awt.*;

public class HwbVerticalFlexibleLayout extends JPanel {
    private JScrollPane mJScrollPane;
    private JPanel mContentPane;

    public HwbVerticalFlexibleLayout() {
        initLayout();
    }

    public void setMinHeight(int minHeight) {
        setMinimumSize(new Dimension(0, minHeight));
        setPreferredSize(new Dimension(0, minHeight));
    }

    public void setMaxHeight(int maxHeight) {
        mJScrollPane.setPreferredSize(new Dimension(0, maxHeight));
        mJScrollPane.setMaximumSize(new Dimension(0, maxHeight));
    }

    private void initLayout() {
        mContentPane = new JPanel();
        mJScrollPane = new JScrollPane(mContentPane);
        mJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setLayout(new BorderLayout());
        add(mJScrollPane, BorderLayout.CENTER);
        if (Debug.DEBUG) {
            setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        if (Debug.DEBUG) {
            mJScrollPane.setBorder(BorderFactory.createLineBorder(Color.PINK));
            mContentPane.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
        mContentPane.setLayout(new BoxLayout(mContentPane, BoxLayout.Y_AXIS));
    }

    @Override
    public Component add(Component comp) {
        mContentPane.add(comp);
        return comp;
    }

    @Override
    public void removeAll() {
        mContentPane.removeAll();
    }
}
