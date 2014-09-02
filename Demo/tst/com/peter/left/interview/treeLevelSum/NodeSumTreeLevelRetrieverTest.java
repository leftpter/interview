package com.peter.left.interview.treeLevelSum;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class NodeSumTreeLevelRetrieverTest
{
	private RetrieveTreeLevelNodeSum triever;
	
	@Before
	public void setUp()
	{
		triever = new NodeSumTreeLevelRetriever();
	}

	@Test
	public void emptyTree_itShould_retrieveEmptySet()
	{
		assertThat(triever.apply(null, 2), empty());
	}
	
	@Test
	public void singletonLevelFit_itShould_retrive0Level()
	{
		final Set<Integer> result = triever.apply(new TreeNode(1, null, null), 1);
		assertThat(result, equalTo(Collections.singleton(0)));
	}
	
	@Test
	public void singletonLevelNotFit_itShould_retriveEmptySet()
	{
		assertThat(triever.apply(new TreeNode(1, null, null), 2), empty());
	}
	
	@Test
	public void twoLevelNotFit_itShould_retriveEmptySet()
	{
		final TreeNode leaf = new TreeNode(1, null, null);
		assertThat(triever.apply(new TreeNode(2, leaf, leaf), 1), empty());
	}
	
	@Test
	public void twoLevelBothFit_itShould_retrive01Level()
	{
		final TreeNode leaf = new TreeNode(1, null, null);
		final Set<Integer> result = triever.apply(new TreeNode(2, leaf, leaf), 2);
		assertThat(result, hasSize(2));
		assertThat(result, contains(0, 1));
	}
	
	@Test
	public void twoLevelFirstOneFit_itShould_retrive0Level()
	{
		final TreeNode leaf = new TreeNode(1, null, null);
		final Set<Integer> result = triever.apply(new TreeNode(1, leaf, leaf), 1);
		assertThat(result, equalTo(Collections.singleton(0)));
	}
	
	@Test
	public void twoLevelSecondOneFit_itShould_retrive1Level()
	{
		final TreeNode leaf = new TreeNode(1, null, null);
		final Set<Integer> result = triever.apply(new TreeNode(1, leaf, leaf), 2);
		assertThat(result, equalTo(Collections.singleton(1)));
	}	
}
