package weblinkparser.base;

import weblinkparser.Debug;

import javax.swing.*;
import java.awt.*;

public class HwbVerticalFixedLayout extends JPanel {
    private int mHeight;

    public HwbVerticalFixedLayout() {
        initLayout();
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
        setPreferredSize(new Dimension(0, mHeight));
    }

    private void initLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        if (Debug.DEBUG) {
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
    }

    @Override
    public Component add(Component comp) {
        JPanel padding = new JPanel();
        super.add(padding);
        return super.add(comp);
    }

    public void addPaddingForAlignment() {
        JLabel widthLabelForPadding = new JLabel();
        widthLabelForPadding.setPreferredSize(new Dimension(300, 0));
        add(widthLabelForPadding);
    }
}
