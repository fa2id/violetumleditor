package com.horstmann.violet.jUnitTest.checker;

import com.horstmann.violet.product.diagram.abstracts.AbstractGraph;
import com.horstmann.violet.product.diagram.abstracts.edge.IEdge;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;

public class RecursiveChecker {
	public int getNumberOfRecursive(String className) {
		ClassNode classNode1 = null;

		for (INode node: AbstractGraph.nodesCopy) {
			ClassNode classNode = (ClassNode) node;
			if (classNode.getName().toString().equals(className))
				classNode1 = classNode;
		}
		
		int counter = 0;
		if (classNode1 != null) {
			for (IEdge edge: AbstractGraph.edgesCopy) {
				if (edge.getStartNode() == classNode1 && edge.getEndNode() == classNode1)
					counter++;
			}
		}
		return counter;
	}
	
	public boolean isInvalidRecursive(String className) {
		if (getNumberOfRecursive(className)>1)
			return true;
		return false;
	}
}
