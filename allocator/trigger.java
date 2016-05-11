package allocator;

public class trigger {
	
	
	public static void test()
	{
		
	javax.swing.SwingUtilities.invokeLater(new Runnable() { 
        public void run() { 
        	ProgressBarDemo shoot = new ProgressBarDemo();
        	shoot.createAndShowGUI(); 
        } 
    });
	}

}
