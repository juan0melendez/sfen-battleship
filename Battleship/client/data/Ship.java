package client.data;

import java.awt.Point;

public class Ship
{
	private int length;
	private boolean direction; //true=down , false = right
	private Point coords;
	
	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public boolean isDirection()
	{
		return direction;
	}

	public void setDirection(boolean direction)
	{
		this.direction = direction;
	}

	public Point getCoords()
	{
		return coords;
	}

	public void setCoords(Point coords)
	{
		this.coords = coords;
	}

	
	public Ship(int length, boolean direction, Point coords)
	{
		this.length = length;
		this.direction = direction;
		this.coords = coords;
		
	}
	
	
	
}
