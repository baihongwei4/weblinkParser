package weblinkparser.base;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class HwbWindow extends JFrame {
    private int mWidth = 480;
    private int mHeight = 640;
    private int mHorizentalPadding = 10;
    private int mVerticalPadding = 5;

    private String mAppName;
    private String mVersion;
    private String mPlatform;

    private String mAppIconFileName = "gpac.jpg";

    private int mAccHeight = 0;

    @Override
    public void pack() {
        initLayout();
        super.pack();
    }

    public void setTitle(String appName, String version, String platform) {
        mAppName = appName;
        mVersion = version;
        mPlatform = platform;
    }

    /*
     * Change title for notification for completion
     */
    public void updateTitleCompletionNotification(boolean isShowCompletion) {
        setTitle(getTitleString(isShowCompletion));
    }

    @Override
    public Component add(Component comp) {
        int height = (int) comp.getPreferredSize().getHeight();
        int width = mWidth - 36;
        mAccHeight += mVerticalPadding;
        comp.setBounds(mHorizentalPadding, mAccHeight, width, height);
        Component component = super.add(comp);
        mAccHeight += height;
        updateHeight();
        return component;
    }

    public void setHorizentalPadding(int horizentalPadding) {
        mHorizentalPadding = horizentalPadding;
    }

    public void setVerticalPadding(int verticalPadding) {
        mVerticalPadding = verticalPadding;
    }

    private String getTitleString(boolean isShowCompletion) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mAppName != null ? mAppName : "Unknown App");
        stringBuilder.append(" v" + mVersion + " ");
        stringBuilder.append((mPlatform != null ? " (" + mPlatform + ")" : ""));
        return stringBuilder.toString();
    }

    private String getAppIcon() {
        return "res" + File.separator + mAppIconFileName;
    }

    public void setAppIconFileName(String appIconFileName) {
        mAppIconFileName = appIconFileName;
    }

    private void initLayout() {
        updateHeight();
        setCenterDisplay();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(getTitleString(false));

        Image icon = Toolkit.getDefaultToolkit().getImage(getAppIcon());
        setIconImage(icon);

        setLayout(null);
    }

    private void updateHeight() {
        mHeight = mAccHeight + 5 * mHorizentalPadding;
        setPreferredSize(new Dimension(mWidth, mHeight));
        setMinimumSize(new Dimension(mWidth, mHeight));
    }

    private void setCenterDisplay() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (mHeight > screenSize.getHeight()) {
            mHeight = (int) screenSize.getWidth();
        }
        if (mWidth > screenSize.getWidth()) {
            mWidth = (int) screenSize.getWidth();
        }

        this.setLocation((int) ((screenSize.getWidth() - mWidth) / 2), (int) ((screenSize.getHeight() - mHeight) / 2));
    }
}
