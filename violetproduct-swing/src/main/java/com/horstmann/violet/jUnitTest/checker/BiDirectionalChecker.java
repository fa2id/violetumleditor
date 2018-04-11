package com.horstmann.violet.jUnitTest.checker;

import com.horstmann.violet.product.diagram.abstracts.AbstractGraph;
import com.horstmann.violet.product.diagram.abstracts.edge.IEdge;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;

public class BiDirectionalChecker {
	public boolean checkBiDirectional(String className1, String className2) {
		ClassNode classNode1 = null;
		ClassNode classNode2 = null;

		for (INode node: AbstractGraph.nodesCopy) {
			ClassNode classNode = (ClassNode) node;
			if (classNode.getName().toString().equals(className1))
				classNode1 = classNode;
			if (classNode.getName().toString().equals(className2))
				classNode2 = classNode;
		}
		if (classNode1 != null && classNode2 != null) {
			for(IEdge edge:AbstractGraph.edgesCopy) {
				for(IEdge edgeToCheck:AbstractGraph.edgesCopy) {
					if (edge != edgeToCheck) {
						if (edge.getEndNode()==edgeToCheck.getStartNode() && edge.getStartNode()==edgeToCheck.getEndNode())
							return true;
					}
				}
			}
		}
		return false;

	}
}
