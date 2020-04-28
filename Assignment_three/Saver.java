
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {

	Class<?> klass; // class of any type
	Method[] method; // method of any kind
	String initialResult = "";
	int number = 0;

	public String save(Object o) {
		klass = o.getClass();
		method = klass.getMethods();

		
		if (klass.getAnnotation(Element.class) != null) {
			try {
				printHeader = true;
				initialResult += getSubNode(o);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			initialResult += "  <subnodes>   \n</node>";
			return initialResult;
		}

		return "No XML files found";
	}

	boolean printHeader;

	public String getSubNode(Object o)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object[] subnodes = null;
		for (Method m : method) {
			number++;
			SubElements se = m.getAnnotation(SubElements.class);
			ElementField ef = m.getAnnotation(ElementField.class);

			// check if contains elementField
			if (ef != null) {
				String value = m.invoke(o).toString();
				if (number == 1) {
					initialResult += "<node " + ef.name() + "=\"" + value + "\">\n  <subnodes>\n";
				} else {
					initialResult += "    " + "<node " + ef.name() + "=\"" + value + "\">\n";
				}
			}
			// check if contains subElements
			if (se != null) {
				subnodes = (Object[]) m.invoke(o);
			}

		}
		if (subnodes != null) {
			for (Object node : subnodes) {
				getSubNode(node);
			}
		}
		return initialResult;
	}

}
