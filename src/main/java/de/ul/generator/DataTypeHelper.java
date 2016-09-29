/**
 *
 */
package de.ul.generator;


import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * @author Thorsten Kamann <thorsten.kamann@googlemail.com>
 */
public class DataTypeHelper {
	private static EMap ptd = null;
	private static EMap td = null;
	private static EMap tw = null;

	public static String getDataTypeName(Type type, String spec){
		return spec+":"+type.getName();
	}
	
	public static boolean equalsParameterDirection(Parameter parameter, String kind){
		return parameter.getDirection().equals(ParameterDirectionKind.get(kind));
	}

	/**
	 * Calculates the type to return
	 * @param parameter The parameter modelled as return type
	 * @return The name of the type to return or <code>null</code>
	 * if no type is defined as return type
	 */
	public static String getReturnType(Parameter parameter){
		String rt = "";

		if ((parameter == null) || (parameter.getType().getName().equals("void")))
			return "void";
		
		if (parameter.getType() instanceof org.eclipse.uml2.uml.PrimitiveType){
			rt = parameter.getType().getName();
			if (rt.equals("Boolean"))
				return "boolean";
			else return rt;
		}
		String pkgName = Helper.getFQNPackageName(parameter.getType());
		return pkgName == null || pkgName.equals("") ? parameter.getType().getName() : pkgName + 
		"." + parameter.getType().getName();
	}
	
	public static String getCollectionTypeName(MultiplicityElement element){
		String ctn;
		
		if (element.isUnique()){
			if (element.isOrdered()){
				ctn = "java.util.SortedSet";
			}else{
				ctn = "java.util.Set";
			}
		}else{
			ctn = "java.util.List";
		}
		
		
		
		return ctn;
	}

	/**
	 * Returns the name of the visibility of a property. Special handling of
	 * visibility package.
	 * @param property The property to return the visibility from
	 * @return The name of the visibility of the given property
	 */
	public static String getVisibilityName(Property property){
		VisibilityKind vis;

		vis = property.getVisibility();

		if (vis.getName().equalsIgnoreCase("package")){
			return "";
		}
		return vis.getName();
	}

	/**
	 * @param operation The operation to get the visibility name from
	 * @return The visibility name of the given operation
	 */
	public static String getVisibilityName(Operation operation){
		VisibilityKind vis;

		vis = operation.getVisibility();

		if (vis.getName().equalsIgnoreCase("package")){
			return "";
		}
		return vis.getName();
	}

	/**
	 * @param property The property the default value to calculate for
	 * @return The default value of the given type
	 */
	public static String getDefaultValue(Property property){
		ValueSpecification vs = property.getDefaultValue();
		
		if (vs == null){
			return getDefaultValue(property.getType());
		}else{
			if (property.getType() == null){
				return vs.stringValue();
			}else if (property.getType().getName().equals("String")){
				return "\""+vs.stringValue()+"\"";
			}else if (property.getType().getName().equals("Integer")){
				return vs.integerValue()+"";
			}else if (property.getType().getName().equals("Boolean")){
				return vs.booleanValue()+"";
			}
			if (vs.stringValue() != null)
				return vs.stringValue();
			else
				return getDefaultValue(property.getType());
		}
	}
	
	/**
	 * Normalizing the DefaultValue of a property. If the DefaultValue starts with 
	 * <code>${</code> and ends with <code>}</code> then an empty string will be returned.
	 * @param property The property the normalized default value to calculate for
	 * @return The normalized default value of the given type
	 */
	public static String getNormalizedDefaultValue(Property property){
		String dv;
		
		if (property == null){
			return "null";
		}
		dv = getDefaultValue(property);
		
		int start = dv.indexOf("${");		
		int end = -1;
		if (start > -1){
			end = dv.indexOf("}", start);
		}
		
		if (start > -1 && end > start){
			dv = "";
			if (property.getType() != null && 
					property.getType().getName().equals("String")){
				dv = "\"\"";
			}			
		}
		
		return dv;
	}

	/**
	 * @param type The type the default value to calculate for
	 * @return The default value of the given type
	 */
	public static String getDefaultValue(Type type){
		String value = "null";
		if (type == null || StringUtils.isEmpty(type.getName())){
			return value;
		}

		if (type instanceof PrimitiveType){
			if (getPrimitiveTypeDefaults().containsKey(type.getName().toLowerCase())){
				value = (String) getPrimitiveTypeDefaults().get(type.getName().toLowerCase());
			}
		}
		return value;
	}
	
	/**
	 * @param type The type the default value to calculate for
	 * @return The default value of the given type
	 */
	public static String getWrapperClassForPromitivyTypes(Type type, final String value){

		if (type instanceof PrimitiveType){
			if (getTypeWrapper().containsKey(type.getName().toLowerCase())){
				String wrapper = (String) getTypeWrapper().get(type.getName().toLowerCase());
				return "new "+wrapper+"("+value+")";
			}
		}
		return value;
	}

	/**
	 * 
	 * @param element The element typed by the Stereotype
	 * @param stereoTypeName The name of the stereotype to get the
	 * TaggedValue from
	 * @param name The name of the TaggedValue
	 * @param type The datatype of the TaggedValue
	 * @return The value (already casted to his type) of a TaggedValue
	 */
	public static Object getTaggedValue(Element element,
			String stereoTypeName, String name, String type){
		Object tv = null;
		EList stereotypes = null;

		stereotypes = element.getAppliedStereotypes();
		for (Iterator iter = stereotypes.iterator(); iter.hasNext();) {
			Stereotype stereotype = (Stereotype) iter.next();
			if (stereotype.getName().equalsIgnoreCase(stereoTypeName)){
				try{
					tv = element.getValue(stereotype, name);
				}catch (Exception ex){
					tv = getTypeDefaults().get(type);
				}
				break;
			}
		}
		return tv;
	}

	/**
	 * Creates the <code>EMap</code> with the defaults for all PrimitiveTypes.
	 * @return The <code>EMap</code> with the defaults
	 */
	private static EMap getPrimitiveTypeDefaults(){
		if (ptd == null){
			ptd = new BasicEMap();
			ptd.put("int", "0");
			ptd.put("short", "0");
			ptd.put("double", "0");
			ptd.put("float", "0");
			ptd.put("long", "0");
			ptd.put("boolean", "false");
			ptd.put("byte", new Byte("0").byteValue()+"");
			ptd.put("char", new String("' '"));
		}
		return ptd;
	}

	/**
	 * Creates the <code>EMap</code> with the defaults for common types.
	 * The defaults are wrapped (int - Integer; double - Double and so on).
	 * @return The <code>EMap</code> with the defaults
	 */
	private static EMap getTypeDefaults(){
		if (td == null){
			td = new BasicEMap();
			td.put("int", new Integer(0));
			td.put("short", new Short("0"));
			td.put("double", new Double(0d));
			td.put("long", new Long(0l));
			td.put("boolean", new Boolean(false));
			td.put("byte", new Byte("0"));
			td.put("char", new Character(' '));
		}
		return td;
	}
	
	/**
	 * Creates the <code>EMap</code> with the wrapper for  PrimitiveTypes.
	 * @return The <code>EMap</code> with the wrapper names
	 */
	private static EMap getTypeWrapper(){
		if (tw == null){
			tw = new BasicEMap();
			tw.put("int", "Integer");
			tw.put("short", "Short");
			tw.put("double", "Double");
			tw.put("long", "Long");
			tw.put("boolean", "Boolean");
			tw.put("byte", "Byte");
			tw.put("char", "Character");
		}
		return tw;
	}
}
