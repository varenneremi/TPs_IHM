package homeFinder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import rangeSlider.RangeSliderUI;

@SuppressWarnings("serial")
public class Map extends JPanel {

	RangeSliderUI nbRooms, price;
	ArrayList<Home> homes = new ArrayList<Home>();
	
	public Map (RangeSliderUI nbRooms, RangeSliderUI price, ArrayList<Home> homes) {
		this.nbRooms = nbRooms;
		this.price = price;
		this.homes = homes;
		setPreferredSize(new Dimension(800, 800));
	}
	
	public void paint(Graphics g) {
		ArrayList<Home> list1 = new ArrayList<Home>();
		ArrayList<Home> list2 = new ArrayList<Home>();
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.GRAY);
		g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);
		
		g.setColor(Color.RED);
		list1 = checkPrice(price);
		list2 = checkNbRooms(nbRooms, list1);
		
		for (int i = 0; i < list2.size(); i ++) {
			g.fillRect(list2.get(i).x, list2.get(i).y, 10, 10);
		}
	}

	public ArrayList<Home> checkPrice(RangeSliderUI slider) {
		int price;
		ArrayList<Home> list = new ArrayList<Home>();
		int min = slider.getModel().getValue(false);
		int max = slider.getModel().getValue(true);
		for (int i = 0; i < homes.size(); i ++) {
			price = homes.get(i).getPrice();
			if ((price >= min) && (price <= max)) {
				list.add(homes.get(i));
			}
		}

		return list;
	}

	public ArrayList<Home> checkNbRooms(RangeSliderUI slider, ArrayList<Home> l) {
		int nb;
		ArrayList<Home> list = new ArrayList<Home>();
		int min = slider.getModel().getValue(false);
		int max = slider.getModel().getValue(true);
		for (int i = 0; i < l.size(); i ++) {
			nb = l.get(i).getRooms();
			if ((nb >= min) && (nb <= max))
				list.add(l.get(i));
		}
		return list;
	}
}
