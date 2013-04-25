package ProjectInformaticaPackage;

public class SimpleDynamicArray implements IDynamicArray {    //�� �� ���� ����� ���� ���������� �� ��������� �������, ���� �� �����������. ��� ������ ��� ���������� ����������� ������������.
	private int defaultsize = 1;
	private Object[] simplearray = new Object[defaultsize];
	private int size = simplearray != null ? simplearray.length : 0;
	private int currentposition = -1;

	private void resize(int newsize) {
		Object[] newArray = new Object[newsize];
		int limit = size < newsize ? size : newsize;
		for (int i = 0; i < limit; i++)
			newArray[i] = simplearray[i];
		currentposition = limit - 1;
		size = newsize;
		simplearray = newArray;
	}

	public int size() {
		return currentposition + 1;
	}

	public boolean isEmpty() {
		if (currentposition == -1)
			return true;
		return false;
	}

	public boolean contains(Object o) {
		for (int i = 0; i < currentposition + 1; i++)
			if (simplearray[i].equals(o))
				return true;
		return false;
	}

	public Object[] toArray() {
		if (currentposition == -1)
			return null;
		return simplearray;
	}

	public boolean add(Object e) {
		if (currentposition + 1 > size - 1) {
			this.resize(this.size() + 1);
			currentposition++;
			simplearray[currentposition] = e;
			return true;
		}
		currentposition++;
		simplearray[currentposition] = e;
		return true;
	}

	public boolean remove(Object o) { // ������� ��� �������, ������ o
		for (int i = 0; i < currentposition + 1; i++)
			if ((simplearray[i] != null) && (simplearray[i].equals(o))) {
				simplearray[i] = null;
				if (i == currentposition)
					currentposition--;
				return true;
			}
		return false;
	}

	/*public Object remove(int index) {
		Object a = new Object();
		if ((index > currentposition) || (index < 0)) {
			System.out.println("��� ������ ������� � �������");
			return null;
		}

		try {

			if (simplearray[index] instanceof Human)
				a = ((Human) simplearray[index]).clone();
			else {
				if (simplearray[index] instanceof Animal)
					a = ((Animal) simplearray[index]).clone();
				else
					return null;
			}

		} catch (CloneNotSupportedException e) {
			System.out.println("������ �� ����� ���� �������������.");
		}

		simplearray[index] = null;
		if (index == currentposition + 1) {
			currentposition--;
		}
		return a;
	}
	*/

	public void clear() {
		for (int i = 0; i < size; i++)
			simplearray[i] = null;
		this.currentposition = -1;
	}

	public Object get(int index) {

		if ((index > currentposition) || (index < 0)) {
			System.out.println("��� ������ ������� � �������");
			return null;
		}
		return simplearray[index];
	}

	/*public Object set(int index, Object element) {
		Object a = new Object();
		if ((index > currentposition) || (index < 0)) {
			System.out.println("��� ������ ������� � �������");
			return null;
		}
		try {

			if (simplearray[index] instanceof Human)
				a = ((Human) simplearray[index]).clone();
			else {
				if (simplearray[index] instanceof Animal)
					a = ((Animal) simplearray[index]).clone();
				else
					return null;
			}

		} catch (CloneNotSupportedException e) {
			System.out.println("������ �� ����� ���� �������������.");
		}
		simplearray[index] = element;
		return a;
	}
*/
	public int indexOf(Object o) { // ���� ������ ���������
		for (int i = 0; i <= currentposition; i++)
			if (simplearray[i].equals(o))
				return i;
		return -1;
	}

	public int getcurrentposition() {
		return currentposition;
	}
}
