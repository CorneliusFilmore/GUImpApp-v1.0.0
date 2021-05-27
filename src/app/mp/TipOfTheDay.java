package app.mp;

import com.l2fprod.common.swing.JTipOfTheDay;
import com.l2fprod.common.swing.tips.DefaultTip;
import com.l2fprod.common.swing.tips.DefaultTipModel;
import java.awt.*;

/**
 * Class that contains the Tip of the day
 */

public class TipOfTheDay extends JTipOfTheDay {
    DefaultTipModel tipModel = new DefaultTipModel();

    TipOfTheDay() {

        tipModel.add(new DefaultTip("Tip 1", "Making mistakes in coding is very common and it’s completely acceptable in programming." +
                " You will find a lot of errors in your code at the beginning so it’s good to use debuggers to find out errors, impacts on your" +
                " result and check where you have made the mistake. You will save a lot of time using a debugger or a tool to fix the errors" +
                " in your code."));
        tipModel.add(new DefaultTip("Tip 2", "One of the best ways to understand programming easily and quickly is teaching." +
                " Teaching to someone, sharing your knowledge, doing discussions with other programmers will make you a better programmer" +
                " quickly. Teaching to someone is teaching to yourself too, so if you are able to teach to somebody that means you truly " +
                "understand the concepts."));

        this.setModel(tipModel);
        this.setCurrentTip(1);
        this.setSize(new Dimension(300,100));
        this.setVisible(true);
        this.showDialog(this);
    }
}

