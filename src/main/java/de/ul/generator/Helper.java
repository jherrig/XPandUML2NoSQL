/**
 *
 */
package de.ul.generator;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

import org.apache.commons.lang.StringUtils;

/**
 * Helper class for the helper extension of the JavaBasic-Generator.
 * 
 * @author Thorsten Kamann <thorsten.kamann@googlemail.com>
 * @author Andr� Neumann <andre.v.neumann@gmx.de>
 * @since 1.0.0
 */
public class Helper {
	private static Log log = LogFactory.getLog("Fornax System-Log");
	private static Map annotationSourceKeyMap = null;
	
	public static void log (Object o) {
		log.debug(o!=null ? o.toString() : "<null>");
	}
	
	public static void log (Object o, String logMsg) {
		log.debug(logMsg+": "+o!=null ? o.toString() : "<null>");
	}
	
	/**
	 * Calculate the full qualified packagename of the given type
	 * @param type The <code>org.eclipse.uml2.uml.Type</code> to calculate the
	 * full qualified name for
	 * @return The full qualified name as <code>java.lang.String</code>
	 */
	public static String getFQNPackageName(Type type) {
		String pn = "";
		Package p = findNearestPackage(type);
		while (p != null) {
			pn = p.getName() + "." + pn;
			p = findNearestPackage(p);
		}
		if (pn.endsWith(".")) {
			pn = pn.substring(0, pn.length() - 1);
		}
		return pn;
	}
	
	/** Finds the nearest Package for the given element
	 * @param el The <code>org.eclipse.uml2.uml.Element</code> to find the
	 * nearest package for
	 * @return The nearest Package or null
	 */
	private static Package findNearestPackage(Element el){
		Element o = el.getOwner();
		while( !(o instanceof Package) && (o != null)) {
			o = o.getOwner();
		}
		if( o instanceof Package){
			if(o instanceof Model || o instanceof Profile) {
				return null;
			} else {
				return (Package)o;
			}
		} else {
			return null;
		}
	}
	/**
	 * Calculate the full qualified packagepath of the given type
	 * @param type The <code>org.eclipse.uml2.uml.Type</code> to calculate the
	 * full qualified path for
	 * @return The full qualified path as <code>java.lang.String</code>
	 */
	public static String getFQNPackagePath(Type type) {
		String path = getFQNPackageName(type);

		path = path.replaceAll("\\.", "/");
		return path;
	}

	/**
	 * Calculate the full qualified componentname of the given type
	 * @param type The <code>org.eclipse.uml2.uml.Type</code> to calculate the
	 * full qualified name for
	 * @return The full qualified name as <code>java.lang.String</code>
	 */
	public static String getFQNComponentName(Type type) {
		String pn = "";
		Component cp = null;
		// looking for start component
		if(type instanceof Component){
			cp = (Component)type;
		} else {
			cp = findNearestComponent(type);
		}
		// stepping up component hierarchy
		while (cp != null) {
			pn = cp.getName() + "." + pn;
			cp = findNearestComponent(cp);
		}

		if (pn.endsWith(".")) {
			pn = pn.substring(0, pn.length() - 1);
		}
		return pn;
	}

	/**
	 * Calculate the full qualified componentpath of the given type
	 * @param type The <code>org.eclipse.uml2.uml.Type</code> to calculate the
	 * full qualified path for
	 * @return The full qualified path as <code>java.lang.String</code>
	 */
	public static String getFQNComponentPath(Type type) {
		String path = getFQNComponentName(type);

		path = path.replaceAll("\\.", "/");
		return path;
	}

	/** Finds the nearest Component for the given element
	 * @param el The <code>org.eclipse.uml2.uml.Element</code> to find the
	 * nearest component for
	 * @return The nearest Component or null
	 */
	private static Component findNearestComponent(Element el){
		Element o = el.getOwner();
		while( !(o instanceof Component) && (o != null)) {
			o = o.getOwner();
		}
		if( o != null){
			return (Component)o;
		} else {
			return null;
		}
	}
	
	/**
	 * @param eObject The object to retrieve the id from
	 * @return The unique XMI-ID of the given element
	 */  
	public static String getXmiId (EObject eObject) {
		return ((XMLResource)eObject.eResource()).getID(eObject);
	}
	/**
	 * Collects all attributes the classifier and their interfaces have.
	 * @param classifier The classifier the attributes should be collected
	 * @return An <code>EList</code> with all collected attributes
	 */
	public static EList getAllAttributes(Classifier classifier){
		EList attributes = new UniqueEList();

		attributes.addAll(classifier.getAttributes());
		if (classifier instanceof org.eclipse.uml2.uml.Class){
			Class clazz = (Class) classifier;
			for (int i=0;i<clazz.getImplementedInterfaces().size();i++){
				attributes.addAll(getAllInterfaceAttributes((Interface) clazz.getImplementedInterfaces().get(i)));
			}
		}
		return attributes;
	}

	public static EList getAllProperties(Classifier classifier) {
	        EList attributes = new UniqueEList();

	        attributes.addAll(classifier.getAttributes());
	        if (classifier instanceof org.eclipse.uml2.uml.Class) {
	            Class clazz = (Class) classifier;
	            for (int i = 0; i < clazz.getImplementedInterfaces().size();
	i++) {
	                attributes.addAll(0, getAllInterfaceAttributes(clazz
	                        .getImplementedInterfaces().get(i)));
	            }

	            if (clazz.parents().size() > 0) {
	                attributes.addAll(0,
	getAllAttributes(clazz.parents().get(0)));
	            }
	        }
	        return attributes;
	    }

	/**
	 * Collects all operations the classifier and their interfaces have.
	 * @param classifier The classifier the operations should be collected
	 * @return An <code>EList</code> with all collected operations
	 */
	public static EList getAllOperations(Classifier classifier){
		EList operations = new UniqueEList();

		operations.addAll(classifier.getOperations());
		if (classifier instanceof org.eclipse.uml2.uml.Class){
			Class clazz = (Class) classifier;
			for (int i=0;i<clazz.getImplementedInterfaces().size();i++){
				operations.addAll(getAllInterfaceOperations((Interface) clazz.getImplementedInterfaces().get(i)));
			}
		}
		return operations;
	}

	/**
	 * Collects all dependencies the NamedElement has. In the case of a Class 
	 * the dependencies of its interfaces will be processed too.
	 * @param element The NamedElement the dependencies should be collected
	 * @return An <code>EList</code> with all collected dependencies
	 */
	public static EList getAllDependencies(NamedElement element){
		EList dependencies = new UniqueEList();

		dependencies.addAll(element.getClientDependencies());
		if (element instanceof org.eclipse.uml2.uml.Class){
			Class clazz = (Class) element;
			for (int i=0;i<clazz.getImplementedInterfaces().size();i++){
				dependencies.addAll(getAllInterfaceAssociations((Interface) clazz.getImplementedInterfaces().get(i)));
			}
		}

		EList depsFiltered = new UniqueEList();
		for (Iterator iter = dependencies.iterator(); iter.hasNext();) {
			Object e = (Object) iter.next();
			if (!(e instanceof InterfaceRealization)){
				depsFiltered.add(e);
			}
		}
		return depsFiltered;
	}

	/**
	 * Collects all associations the classifier and their interfaces have.
	 * @param classifier The classifier the associations should be collected
	 * @return An <code>EList</code> with all collected associations
	 */
	public static EList getAllAssociations(Classifier classifier){
		EList associations = new UniqueEList();

		associations.addAll(classifier.getAssociations());
		if (classifier instanceof org.eclipse.uml2.uml.Class){
			Class clazz = (Class) classifier;
			for (int i=0;i<clazz.getImplementedInterfaces().size();i++){
				associations.addAll(getAllInterfaceAssociations((Interface) clazz.getImplementedInterfaces().get(i)));
			}
		}
		return associations;
	}

	/**
	 * Collects all attributes of the given interface needed to implement (creating fields
	 * and getter/setter methods) by a implementing class.
	 * @param iFace The interface to collect the operations from
	 * @return An <code>EList</code> with all collected attributes
	 */
	private static EList getAllInterfaceAttributes(Interface iFace){
		EList attributes = new UniqueEList();

		attributes.addAll(iFace.getAllAttributes());
		if (iFace.getGeneralizations().size() > 0){
			for (int i=0;i<iFace.getGeneralizations().size();i++){
				attributes.addAll(
						getAllInterfaceAttributes(
								(Interface) ((Generalization) iFace.getGeneralizations().get(i)).getGeneral()));
			}
		}
		return attributes;
	}

	/**
	 * Collects all operation of the given interface needed to implement by a
	 * implementing class.
	 * @param iFace The interface to collect the operations from
	 * @return An <code>EList</code> with all collected operations
	 */
	private static EList getAllInterfaceOperations(Interface iFace){
		EList operations = new UniqueEList();

		operations.addAll(iFace.getAllOperations());
		if (iFace.getGeneralizations().size() > 0){
			for (int i=0;i<iFace.getGeneralizations().size();i++){
				operations.addAll(
						getAllInterfaceOperations(
								(Interface) ((Generalization) iFace.getGeneralizations().get(i)).getGeneral()));
			}
		}
		return operations;
	}

	/**
	 * Collects all associations of the given interface needed to implement by a
	 * implementing class.
	 * @param iFace The interface to collect the associations from
	 * @return An <code>EList</code> with all collected associations
	 */
	private static EList getAllInterfaceAssociations(Interface iFace){
		EList associations = new UniqueEList();

		associations.addAll(iFace.getAssociations());
		if (iFace.getGeneralizations().size() > 0){
			for (int i=0;i<iFace.getGeneralizations().size();i++){
				associations.addAll(
						getAllInterfaceAssociations(
								(Interface) ((Generalization) iFace.getGeneralizations().get(i)).getGeneral()));
			}
		}
		return associations;
	}


	public static String formatComment(Element element,
			String prefix, String propertyFileName) {
		String comment = "";
		EList comments = new BasicEList();

		createAnnotationSourceKey(propertyFileName);
		for (Iterator iter = annotationSourceKeyMap.keySet().iterator(); iter.hasNext();) {
			String source = (String) iter.next();
			String key = (String) annotationSourceKeyMap.get(source);
			comment = findDocumentationAnnotation(element, source, key);
			if(comment != null){
				break;
			}
		}
		
		if (comment != null){
			comments.add(comment);
		}else{
			comments = element.getOwnedComments();
		}
		return getFormatedComment(comments, prefix, null);
	}
	
	public static boolean createAnnotationSourceKey(String propertyFileName){
		String[] items;
		String source;
		String key;
		
		if (annotationSourceKeyMap != null){
			return false;
		}
				
		annotationSourceKeyMap = new HashMap();
		items = propertyFileName.split(",");
		for (int i = 0; i < items.length; i++) {
			String item = items[i];
			item = item.trim();
			
			int start = item.indexOf("[");
			int end = item.indexOf("]");
			
			if(start < 0 || end < start){
				source = item;
				key = "documentation";
			}else{
				source = item.substring(0, start);
				key = item.substring(start+1, end);
			}
			annotationSourceKeyMap.put(source, key);
		}
		return true;
	}
	
	private static String findDocumentationAnnotation(Element parent, String source, String key){
		EAnnotation ea = parent.getEAnnotation("http://www.topcased.org/documentation");
		String comment = null;
		
		if (ea != null){
			EMap details = ea.getDetails();
			if(details!= null && !details.isEmpty() 
					&& details.get("documentation")!= null){
				comment = details.get("documentation").toString();
			}
		}
		
		return comment;		
	}

	/**
	 * A method comment is extended by the description of the parameters.
	 * @precondition Iff the parameter is a return type, the type of the parameter must be not null.
	 * 
	 * @param parameter
	 * @param prefix
	 * @param annotation
	 * @param propertyFileName
	 * @return The line in the comment describing given parameter
	 */
	public static String formatParameterComment(Parameter parameter,
			String prefix, String annotation, String propertyFileName) {
		String comment = "";		
		EList comments = new BasicEList();
		createAnnotationSourceKey(propertyFileName);
		for (Iterator iter = annotationSourceKeyMap.keySet().iterator(); iter.hasNext();) {
			String source = (String) iter.next();
			String key = (String) annotationSourceKeyMap.get(source);
			comment = findDocumentationAnnotation(parameter, source, key);
			if(comment != null){
				break;
			}
		}
		
		if (comment != null){
			comments.add(comment);
		}else{
			comments = parameter.getOwnedComments();
		}

		if (comments.isEmpty()) {
			comment = prefix + "@" + annotation + " " + 
				((parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL))?
						"<code>"+parameter.getType().getName()+"</code>":
							parameter.getName());
		} else {
			comment = getFormatedComment(comments, prefix,
					annotation+" "+
					((parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL))?
							"":parameter.getName()));
		}
		return comment;
	}

	public static String getDefaultValue(Property property){
		ValueSpecification vs = property.getDefaultValue();

		if (vs == null){
			if (property.getType() instanceof PrimitiveType){
				PrimitiveType pt = (PrimitiveType) property.getType();
				if (pt.getName().equals("int")){
					return "0";
				}
			}
			return "null";
		}else{
			if (vs.getType() == null){
				return vs.stringValue();
			}else if (vs.getType().getName().equals("String")){
				return vs.stringValue();
			}else if (vs.getType().getName().equals("Integer")){
				return vs.integerValue()+"";
			}else if (vs.getType().getName().equals("Boolean")){
				return vs.booleanValue()+"";
			}
			return vs.stringValue();
		}
	}

	private static String getFormatedComment(EList comments, String prefix,
			String annotation) {
		String s = "";

		if (!comments.isEmpty()) {
			for (int i = 0; i < comments.size(); i++) {
				Object commentsObject = comments.get(i);
				String text = "";
				if (commentsObject instanceof String){
					text = (String) commentsObject;
				}else if (commentsObject instanceof Comment){
					Comment c = (Comment) comments.get(i);
					text = c.getBody();
				}
				
				if (text !=null && !"".equals(text)){
					s= doFormatting(text, s, prefix, annotation);
				}else{
					s ="* ";
				}
			}
		}else{
			s = "* ";
		}
		return s;
	}

	private static String doFormatting(String text, String appendTo,String prefix,
			String annotation){
		if (!"".equals(appendTo)){
			appendTo += "\n";
		}
		
		text = text.replaceAll("\\n", "\n" + prefix);
		appendTo += prefix;
		if (annotation != null && !"".equals(annotation)) {
			appendTo += "@" + annotation;
		}
		appendTo += " " + text;
		return appendTo;
	}

	/**
	 * This method takes a string and try's to cut it down into its peaces. The character
	 * given as delimiter will be used to determine the single peaces.
	 * 
	 * @param thwString.
	 * @return theList
	 * @since 2.1.0
	 */
	public static EList convertStringToList(String theString, String delimiter) {
		if(delimiter == null || delimiter.equals("")) {
			delimiter = ",";
		}
		
		StringTokenizer tokenizer = new StringTokenizer(theString, delimiter);
		EList theList = new UniqueEList(tokenizer.countTokens());
		
		String currentToken = null;
		while (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
			if(StringUtils.isNotEmpty(currentToken)) {
				theList.add(currentToken.trim());
			}
		}
		
		return theList;
	}
}
