
package bindinds.custom.selenium;

public class Dimension {
	public final int width;
	public final int height;

	public Dimension(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Dimension)) {
			return false;
		}

		Dimension other = (Dimension) o;
		return other.width == width && other.height == height;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", width, height);
	}

	@Override
	public int hashCode() {
		return width << 12 + height;
	}
}
