package com.peter.left.interview.treeLevelSum;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class NodeSumTreeLevelRetriever implements RetrieveTreeLevelNodeSum
{
    private void travelTree(final TreeNode currentPos, final int level, final Map<Integer, Integer> levelNodeSum)
	{
		if (null != currentPos)
		{
			if (levelNodeSum.containsKey(level))
			{
				levelNodeSum.put(level, currentPos.getValue()+levelNodeSum.get(level));
			}
			else
			{
				levelNodeSum.put(level, currentPos.getValue());
			}
			
			travelTree(currentPos.getLeftChild(), level + 1, levelNodeSum);
			travelTree(currentPos.getRightChild(), level + 1, levelNodeSum);
		}
	}
	
	@Override
	public Set<Integer> apply(final TreeNode root, final int targetValue)
	{
		final Set<Integer> levelSet = Sets.newHashSet();
		if (null != root)
		{
			final Map<Integer, Integer> levelNodeSum = Maps.newHashMap();
			travelTree(root, 0, levelNodeSum);
			for (final Entry<Integer, Integer> entry : levelNodeSum.entrySet())
			{
				if (targetValue == entry.getValue())
				{
					levelSet.add(entry.getKey());
				}
			}
		}
		return levelSet;
	}
}
