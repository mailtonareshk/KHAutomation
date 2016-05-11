package allocator;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Progress {

	private JProgressBar progressBar;
	
	public void Check()
	{
 for(int i = progressBar.getMinimum(); i <= progressBar.getMaximum(); i++){
    final int percent = i ;

    SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run() {
        progressBar.setValue(percent);

        }
    });
    try {
        Thread.sleep(50);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}
}
}	