package com.entertainment;

import java.util.Comparator;

public class TelevisionChannelComparator implements Comparator<Television> {

	@Override
	public int compare(Television arg0, Television arg1) {
		return (-1) * Integer.compare(arg0.getCurrentChannel(), arg1.getCurrentChannel());
	}
}
