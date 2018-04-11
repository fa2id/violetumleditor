package com.horstmann.violet.jUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.horstmann.violet.UMLEditorApplication;
import com.horstmann.violet.jUnitTest.checker.RecursiveChecker;
import com.horstmann.violet.product.diagram.abstracts.AbstractGraph;

public class JUnitTestRecursiveFeature implements Testable {

	@Before
	public void init() throws InterruptedException {
		UMLEditorApplication.main(new String[] {});
		finishProgramAfter(40000);
	}
	
	@Override
	@Test
	public void test() {
		assertEquals(2, getNodesSize());
		assertEquals(4, getEdgesSize());
		RecursiveChecker recursiveChecker = new RecursiveChecker();
		assertEquals(3, recursiveChecker.getNumberOfRecursive("Concordia"));
		assertEquals(false, recursiveChecker.isInvalidRecursive("Farid"));
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
}
