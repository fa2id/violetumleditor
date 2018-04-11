package com.horstmann.violet.jUnitTest;

import static org.junit.Assert.assertEquals;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.junit.Before;
import org.junit.Test;

import com.horstmann.violet.UMLEditorApplication;
import com.horstmann.violet.product.diagram.abstracts.AbstractGraph;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;

public class JUnitTestCBO implements Testable {
		
	@Before
	public void init() throws InterruptedException {
		UMLEditorApplication.main(new String[] {});
		finishProgramAfter(30000);
	}
	
	@Override
	@Test
	public void test() {
		assertEquals(3, getNodesSize());
		assertEquals(2, getEdgesSize());
		assertEquals(true, checkCBO("Farid", 2));
	}
	
	private void finishProgramAfter(long time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	private int getNodesSize(){
		return AbstractGraph.nodesCopy.size();
	}
	
	private int getEdgesSize(){
		return AbstractGraph.edgesCopy.size();
	}
	
	private boolean checkCBO(String className, int cboNumber) {
		for (INode node: AbstractGraph.nodesCopy) {
			ClassNode classNode = (ClassNode) node;
			if (classNode.getName().toString().equals(className) 
					&& classNode.getCBO() == cboNumber)
				return true;
		}
		return false;
	}
}
