package dev.l2j.tesla.gameserver.model;

public class RadarMarker
{
	public int _type, _x, _y, _z;

	public RadarMarker(int type, int x, int y, int z)
	{
		_type = type;
		_x = x;
		_y = y;
		_z = z;
	}

	public RadarMarker(int x, int y, int z)
	{
		_type = 1;
		_x = x;
		_y = y;
		_z = z;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + _type;
		result = prime * result + _x;
		result = prime * result + _y;
		result = prime * result + _z;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;

		if ((obj == null) || !(obj instanceof RadarMarker))
			return false;

		final RadarMarker other = (RadarMarker) obj;
		if ((_type != other._type) || (_x != other._x) || (_y != other._y) || (_z != other._z))
			return false;

		return true;
	}
}