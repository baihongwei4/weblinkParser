package weblinkparser;

import weblinkparser.base.HwbVerticalFixedLayout;
import weblinkparser.base.HwbVerticalFlexibleLayout;
import weblinkparser.base.HwbWindow;
import weblinkparser.domain.WebLinkParseUseCase;

import javax.swing.*;

public class GUI extends HwbWindow {
    private JTextArea textIn;
    private JTextArea textOut;
    private JButton button;

    private WebLinkParseUseCase useCase = new WebLinkParseUseCase();

    public GUI(String[] args) {
        initController();
        initLayout();
        initListener();
    }

    private void initController() {
    }

    private void initListener() {
        button.addActionListener(e -> {
            String output = useCase.parse(textIn.getText());
            textOut.setText(output);
        });
    }

    private void initLayout() {
        setTitle(Config.APP_NAME, Config.VERSION, Config.OS);

        setAppIconFileName(Config.ICON);

        initFileListLayout();

        initTaskListLayout();

        initControlLayout();

        JLabel label = new JLabel("");
        add(label);
    }

    private void initFileListLayout() {
        textIn = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(textIn);

        HwbVerticalFlexibleLayout layout = new HwbVerticalFlexibleLayout();
        layout.setMaxHeight(200);
        layout.add(jScrollPane);
        add(layout);
    }

    private void initTaskListLayout() {
        textOut = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(textOut);

        HwbVerticalFlexibleLayout layout = new HwbVerticalFlexibleLayout();
        layout.setMaxHeight(200);
        layout.add(jScrollPane);
        add(layout);
    }

    private void initControlLayout() {
        HwbVerticalFixedLayout layout = new HwbVerticalFixedLayout();
        layout.setHeight(28);
        button = new JButton("Parse");
        layout.add(button);
        add(layout);
    }
}
