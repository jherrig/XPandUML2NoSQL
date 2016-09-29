package de.ul.generator;

import java.util.Iterator;

import org.eclipse.emf.ecore.EStructuralFeature;

public class SerialVersionUID {
	
	/**
	 * This computes a valid Serial-Version-UID for use in the <code>serialVersionUID</code>-field in Java-Classes.
	 * 
	 * @param eObject The EObject for that a serialVersionUID should be computed.
	 * @return the computed UID
	 * @since 2.1.0
	 */
	public static long computeSerialVersionUID(org.eclipse.uml2.uml.Class umlClass) {
		long serialVersionUID = umlClass.hashCode();
			 
		Iterator structuralFeatures = umlClass.eClass().getEAllStructuralFeatures().iterator();
		while (structuralFeatures.hasNext()) {
			
			Object value = umlClass.eGet((EStructuralFeature) structuralFeatures.next());
			if (value != null) {
				serialVersionUID ^= value.hashCode();
			}
		}
		return serialVersionUID;
	}
}
