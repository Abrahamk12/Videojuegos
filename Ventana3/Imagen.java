import javax.swing.*;

public class Imagen extends JLabel implements Runnable {

	ImageIcon icon;
	String url, url2;

	public Imagen(String url, String url2) {
		this.url = url;
		this.url2 = url2;
		icon = new ImageIcon(this.getClass().getResource(url));
		setIcon(icon);
	}

	public void run() {
		for(int x = 10; x <= 250; x+=3) {
			if((x % 2) != 0) {
				icon = new ImageIcon(this.getClass().getResource(url2));
			} else {
				icon = new ImageIcon(this.getClass().getResource(url));
}
			setIcon(icon);
			setBounds(x,40,42,42);

			try {
				Thread.sleep(100);
			} catch(Exception e) {}
		
		} //end while
	} //end run

}